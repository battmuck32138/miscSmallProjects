
package synthesizer;
import java.util.Iterator;

//First in First Out queue.
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    private int first; //Points at the item to be dequeue'd (first item in).
    private int last; //Points at the index one past the last item (enqueue here).
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb =  (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        fillCount++;
        last += 1;
        if (last == capacity) {
            last = 0;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T item = rb[first];
        rb[first] = null;
        first += 1;
        fillCount--;
        if (first == capacity) {
            first = 0;
        }
        return item;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArbIterator();
    }


    //Helper Class////////////////////////////////////////////////////////
    private class ArbIterator implements Iterator<T> {
        int numberOfItemsSoFar = 0;
        int indexOfItem = first;

        @Override
        public boolean hasNext() {
            return numberOfItemsSoFar < fillCount();
        }

        @Override
        public T next() {
            T item = rb[indexOfItem];
            indexOfItem += 1;
            //Handles the wrap around if needed.
            if (indexOfItem == capacity) {
                indexOfItem = 0;
            }
            numberOfItemsSoFar += 1;
            return item;
        }
    }

}
