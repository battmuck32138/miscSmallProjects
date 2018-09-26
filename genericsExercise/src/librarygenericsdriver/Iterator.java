/*
Mathew Buck
Java II Lab B
 */
package librarygenericsdriver;

public interface Iterator<E> {
    
    public E getNext();
    public boolean hasNext();
    public boolean isEmpty();
    
}
