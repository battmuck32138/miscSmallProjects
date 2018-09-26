package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        arb.enqueue(6);
        arb.enqueue(7);
        arb.enqueue(8);
        arb.enqueue(9);
        arb.enqueue("lastItem");
        assertTrue(arb.capacity() == 10);
        assertTrue(arb.fillCount() == 10);
        assertFalse(arb.isEmpty());
        assertTrue(arb.isFull());
        assertTrue(arb.dequeue().equals(1));
        assertTrue(arb.fillCount() == 9);
        arb.enqueue("newLastItem");
        assertTrue(arb.fillCount() == 10);
        assertTrue(arb.peek().equals(2));
        assertTrue(arb.dequeue().equals(2));
        assertTrue(arb.dequeue().equals(3));
        assertTrue(arb.dequeue().equals(4));
        assertTrue(arb.dequeue().equals(5));
        assertTrue(arb.dequeue().equals(6));
        assertTrue(arb.dequeue().equals(7));
        assertTrue(arb.dequeue().equals(8));
        assertTrue(arb.dequeue().equals(9));
        assertTrue(arb.dequeue().equals("lastItem"));
        assertTrue(arb.dequeue().equals("newLastItem"));
        assertTrue(arb.fillCount() == 0);
        assertTrue(arb.isEmpty());

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
