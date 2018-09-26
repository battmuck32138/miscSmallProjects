/*
Mathew Buck
Java II Lab B
 */
package librarygenericsdriver;

import java.util.ArrayList;
import java.util.Calendar;

//This class can be used to manage a collection of LibraryItems, ie
//Book, DVD, Magazine.
public class LibraryCollection<E extends Comparable<E>> {

    private ArrayList<E> collection = new ArrayList<>();
    private int numItems = 0;
    public static int collectionId = 1;
    private final int id = collectionId;

    //Constructor
    public LibraryCollection() {
        collectionId++;
    }

    public Comparable getElem(int index) {
        return collection.get(index);
    }

    //Adds the contents of the argument collection to this collection.
    public boolean addAll(LibraryCollection<? extends E> c) {
        if (c.size() == 0) {
            return false;
        }
        for (int i = 0; i < c.size(); i++) {
            collection.add(c.collection.get(i));
            numItems++;
        }
        return true;
    }

    //Removes the contents of the argument collection from this collection.
    public boolean removeAll(LibraryCollection<?> c) {
        if (c.size() == 0) {
            return false;
        }
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < collection.size(); j++) {
                if (c.getElem(i).compareTo(getElem(j)) == 0) {
                    collection.remove(j);
                    numItems--;
                }
            }
        }
        return true;
    }

    //Copies the contents of this collecton to an array.
    public Object[] toArray() {
        Object[] arr = new Object[numItems];
        for (int i = 0; i < numItems; i++) {
            arr[i] = getElem(i);
        }
        return arr;
    }

    //Copies the contents of the argument array to another array.
    public <T> T[] toArray(T[] a) {
        Object[] arr = new Object[a.length];
        arr = a;
        return a;
    }

    //Retains in this collection, the instances of LibraryItems in the 
    //argument collection.  All other LibraryItems are removed.
    public void retainAll(LibraryCollection<?> c) {
        ArrayList newCollection = new ArrayList<>();
        numItems = 0;
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < collection.size(); j++) {
                if (c.getElem(i).equals(getElem(j))) {
                    newCollection.add(c.getElem(i));
                    numItems++;
                }
            }
        }
        collection = newCollection;
    }

    //Retruns true if all of the Library items in the argument collection 
    //are also contained in this collection.  Returns false otherwise.
    public boolean containsAll(LibraryCollection<?> c) {
        int[] trueFalse = new int[c.size()];
        for (int i = 0; i < c.size(); i++) {
            trueFalse[i] = 0;
            for (int j = 0; j < collection.size(); j++) {
                if (c.getElem(i).equals(getElem(j))) {
                    trueFalse[i] = 1;
                }
            }
        }
        for (int i = 0; i < trueFalse.length; i++) {
            if (trueFalse[i] == 0) {
                return false;
            }
        }
        return true;
    }

    //Adds the item E to the collection.
    public boolean add(E o) {
        numItems++;
        return collection.add(o);
    }

    //Removes Object from collection.
    public boolean remove(E o) {
        numItems--;
        return collection.remove(o);
    }

    //Clears all items from collection.
    public void clear() {
        collection = new ArrayList<>();
        numItems = 0;
    }

    //Tests all items in this collection for a match with the argument item.
    public boolean contains(E o) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return collection.isEmpty();
    }

    public int size() {
        return collection.size();
    }

    @Override
    public String toString() {
        String s = "Collection#" + this.id + " Sz:" + numItems + " [";
        for (int i = 0; i < collection.size(); i++) {
            s += collection.get(i);
            if (i < collection.size() - 1) {
                s += ", \n";
            }
        }
        s += "]";
        return s;
    }

    //Creates a checkOutCart I can get ot from other classes.
    public CheckOutCart checkOutCart() {
        return new CheckOutCart();
    }

    //Creates an iterator that I can get to from other classes.
    public Literator iterator() {
        return new Literator();
    }

    //Creates an iterator that I can get to from other classes.
    public DueDateIterator getDueDateIterator() {
        return new DueDateIterator();
    }

    //------------------------------------------------------------------------
    //Helper Class
    //------------------------------------------------------------------------
    //Iterates normaly.
    public class Literator implements Iterator {

        int i = 0;
        E item = null;

        @Override
        public boolean hasNext() {
            if (i != collection.size()) {
                return true;
            } //reset index for next use
            else {
                i = 0;
                return false;
            }
        }

        @Override
        public E getNext() {
            if (hasNext()) {
                item = collection.get(i);
                i++;
            }
            return item;
        }

        @Override
        public boolean isEmpty() {
            return collection.isEmpty();
        }

        //end helper class
    }

    //------------------------------------------------------------------------
    //Helper Class
    //------------------------------------------------------------------------
    public class CheckOutCart<T extends Borrowable>
            extends LibraryCollection<E> {

        //Iterates through the list of library items and saves the 
        //overdue items to an array. 
        public <T> T[] getOverDueBooks(Calendar c) {
            Book b = new Book("", "");
            E l;
            LibraryCollection overdueBooks = new LibraryCollection();
            for (int i = 0; i < collection.size(); i++) {
                l = collection.get(i);
                if (b.getClass().equals(l.getClass())) {
                    b = (Book) l;
                    b.setCheckoutDate(c);
                    if (b.isOverDue()) {
                        overdueBooks.add(b);
                    }
                }
            }
            T[] arr = (T[]) overdueBooks.toArray();
            return arr;
        }

        //end helper class
    }

    //------------------------------------------------------------------------
    //Helper Class
    //------------------------------------------------------------------------
    //Iterates through a list of LibraryItems bases on the due date.
    public class DueDateIterator<E extends Comparable<E>> implements Iterator {

        int i = 0;
        E item = null;
        Comparable[] arr = new Comparable[collection.size()];
        ArrayList<E> byDueDates = sortByDueDates();

        //Creates an auxillary arrayList that has been sorted by dueDates.
        public ArrayList sortByDueDates() {
            ArrayList<E> byDueDates = new ArrayList();
            for (int i = 0; i < collection.size(); i++) {
                arr[i] = collection.get(i);
            }
            insertionSort(arr, 0, arr.length - 1);
            for (int i = 0; i < arr.length; i++) {
                byDueDates.add((E) arr[i]);
            }
            return byDueDates;
        }

        @Override
        public boolean hasNext() {
            if (i != byDueDates.size()) {
                return true;
            } //reset index for next use
            else {
                i = 0;
                return false;
            }
        }

        @Override
        public E getNext() {
            if (hasNext()) {
                item = byDueDates.get(i);
                i++;
            }
            return item;
        }

        @Override
        public boolean isEmpty() {
            return byDueDates.isEmpty();
        }

        //Insertion Sort (Comparable)
        //O(n^2) ,Stable Sort, Inplace
        //Works well if majority or the items are expected to be in 
        //order, worthless otherwise.
        //Best case is O(n)
        public void insertionSort(Comparable[] arr, int lo, int hi) {
            for (int i = lo + 1; i < hi + 1; i++) {
                for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                    swap(arr, j - 1, j);
                }
            }
        }

        //Helper Method for sort.
        public void swap(Comparable[] arr, int i, int j) {
            Comparable tmp;
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        //end helper class
    }

}
