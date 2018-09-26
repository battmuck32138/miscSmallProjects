
/**
 * A generic, double linked list class built with a circular sentinel topology
 * that eliminates all the special cases for simplicity.
 * Most of the bells and whistles but no merge-sort yet.
 * */
public class LinkedListDeque<T> implements Deque<T> {
    //Invariants:
    //Sentinel Node: first node of list is always at sentinel.next.
    //Sentinel Node: last node of the list is always at sentinel.prev.
    //Sentinel Node: item value is just a place holder, could be null.
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<>(138138);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node current = new Node<>(item);
        current.prev = sentinel;
        current.next = sentinel.next;
        sentinel.next.prev = current;
        sentinel.next = current;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node current = new Node<>(item);
        current.prev = sentinel.prev;
        current.next = sentinel;
        sentinel.prev.next = current;
        sentinel.prev = current;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node current = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T firstItem = (T) sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return firstItem;
    }

    @Override
    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T lastItem = (T) sentinel.prev.item;
        Node newLast = sentinel.prev.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        size--;
        return lastItem;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node current = sentinel.next;
        while (index != 0) {
            current = current.next;
            index--;
        }
        return (T) current.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursive(index, sentinel.next);
    }

    //Helper Method/////////////////////////////////////////////////////////
    private T getRecursive(int index, Node current) {
        if (index == 0) {
            return (T) current.item;
        }
        return getRecursive(--index, current.next);
    }

    //Helper Class///////////////////////////////////////////////////////////
    private class Node<T> {
        private T item = null;
        private Node<T> prev = null;
        private Node<T> next = null;

        private Node() {
            this.item = null;
            this.prev = null;
            this.next = null;
        }

        private Node(T item) {
            this.item = item;
        }

    }

}
