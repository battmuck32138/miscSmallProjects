/*
Mathew Buck
DeQue (double-ended-que)
Double LInked List
 */

package driverscheduling;

//FIFI QUE with linked list.
//Linked List contains nodes from index 1 to n.
public class DeQue<T> {

    private DoubleNode first = null;
    private DoubleNode last = null;
    private int size = 0;

    //------------------------------------------------------------------------
    //default constructor
    DeQue() {
        first = null;
        last = null;
        size = 0;
    }
    
    public Object getFirstData(){
        return first.getData();
    }

    //------------------------------------------------------------------------
    public boolean isEmpty() {
        return first == null;
    }

    //------------------------------------------------------------------------
    public int getSize() {
        return size;
    }

    //------------------------------------------------------------------------
    //displays the size and contents of the nodes
    public void displayQue() {
        DoubleNode current = first;
        System.out.print("Size " + size + ": ");
        while (current != null) {
            current.displayNode();
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println();
    }

    //------------------------------------------------------------------------
    //Adds node to begining of the que.
    public void addFirst(T data) {
        DoubleNode newNode = new DoubleNode(data);
        //case 1: que is empty
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } //case 2: que is not empty
        else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    //------------------------------------------------------------------------
    //Adds a node to end of the que.
    public void addLast(T data) {
        DoubleNode newNode = new DoubleNode(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    //------------------------------------------------------------------------
    //Removes node from the front of the que.
    public void removeFirst() {
        //case 1: is empty
        if (isEmpty()) {
            System.out.println("DeQue is empty.");
        } //case 2: only one node in que
        else if (first.next == null) {
            first = null;
            last = null;
        } //case 3: multiple nodes in que
        else {
            first = first.next;
            first.prev = null;
        }
        if (size != 0) {
            size--;
        }
    }

    //------------------------------------------------------------------------
    //Removes node from the end of the que.
    public void removeLast() {
        //case 1: is empty
        if (isEmpty()) {
            System.out.println("DeQue is empty.");
        } //case 2: only one node in que
        else if (first.next == null) {
            first = null;
            last = null;
        } //case 3: multiple nodes in que
        else {
            last = last.prev;
            last.next = null;
        }
        if (size != 0) {
            size--;
        }
    }

    //------------------------------------------------------------------------
    //Adds a new node to a specifed index in the que.
    //Enter the desired positon of the new node as first argument.
    public void insertBefore(int position, T data) {
        //case 1: que is empty
        if (isEmpty()) {
            addFirst(data);
            return;
        } //case 2: insert at the front of que
        else if (position <= 1 || first.next == null) {
            addFirst(data);
            return;
        } //case 3: insert at the end of que
        else if (position > size) {
            addLast(data);
            return;
        }
        //case 4: insert between 2 elements
        DoubleNode newNode = new DoubleNode(data);
        DoubleNode current = first;
        DoubleNode tmpPrev = null;
        int count = 1;
        while (position > count) {
            tmpPrev = current;
            current = current.next;
            count++;
        }
        newNode.prev = tmpPrev;
        newNode.next = current;
        tmpPrev.next = newNode;
        current.prev = newNode;
        size++;
    }

    //------------------------------------------------------------------------
    //Inserts a node after the position in the argument.
    public void insertAfter(int position, T data) {
        int pos = position + 1;
        insertBefore(pos, data);
    }

    //------------------------------------------------------------------------
    //Removes a node from a given position in the que.
    public void removeNode(int position) {
        //case 1: nonexistant node
        if (position < 1 || position > size) {
            System.out.println("Nonexistant node.");
        } //case 2: position is 1
        else if (position == 1) {
            removeFirst();
            return;
            // first = first.next;
            //first.prev = null;
        } //case: 3 position is last
        else if (position == size) {
            removeLast();
            return;
        }
        //case 4 position is in between 2 elements
        DoubleNode current = first;
        DoubleNode tmpPrev = null;
        DoubleNode tmpNext = null;
        int count = 1;

        while (position > count) {
            tmpPrev = current;
            current = current.next;
            tmpNext = current.next;
            count++;
        }
        tmpNext.prev = tmpPrev;
        tmpPrev.next = tmpNext;
        current = null;
        size--;
    }

    //------------------------------------------------------------------------
    //Moves a node to the front of the que
    public void moveFront(int position) {
        //condition 1: position is 1 or nonexistant
        if (position <= 1 || position > size) {
            return;
        }
        //condition 2: postition is last
        if (position == size) {
            last.next = first;
            first.prev = last;
            first = last;
            last = first.prev;
            first.prev = null;
            last.next = null;
        } //case 2: postion is in between 2 nodes
        else {
            DoubleNode tmpPrev = null;
            DoubleNode current = first;
            DoubleNode tmpNext = null;
            int count = 1;

            while (count < position) {
                current = current.next;
                tmpPrev = current.prev;
                tmpNext = current.next;
                count++;
            }
            first.prev = current;
            current.prev = null;
            current.next = first;
            first = current;
            tmpPrev.next = tmpNext;
            tmpNext.prev = tmpPrev;
        }
    }

    //------------------------------------------------------------------------
    //Moves node to the end of the que.
    public void moveEnd(int position) {
        //case 1: position is end of the que or nonexistant
        if (position >= size || position < 1) {
            return;
        }
        //case 2: position is first
        if (position == 1) {
            last.next = first;
            first.prev = last;
            first.next.prev = null;
            first = first.next;
            last = last.next;
            last.next = null;
        } else {
            //case 3: position is in between two nodes
            DoubleNode current = first;
            DoubleNode tmpPrev = null;
            DoubleNode tmpNext = null;
            int count = 1;
            while (position > count) {
                current = current.next;
                tmpPrev = current.prev;
                tmpNext = current.next;
                count++;
            }
            last.next = current;
            current.prev = last;
            last = current;
            last.next = null;
            tmpPrev.next = tmpNext;
            tmpNext.prev = tmpPrev;
        }
    }

    //------------------------------------------------------------------------
    //helper class////////////////////////////////////////////////////////////
    //------------------------------------------------------------------------
    private class DoubleNode<T> {

        private T data;
        private DoubleNode<T> prev = null;
        private DoubleNode<T> next = null;

        //--------------------------------------------------------------------
        public DoubleNode(T data) {
            this.data = data;
        }

        //--------------------------------------------------------------------
        public T getData(){
            return data;
        }
        
        //--------------------------------------------------------------------
        public DoubleNode getlinkNext() {
            return next;
        }

        //--------------------------------------------------------------------
        public DoubleNode getLinkPrev() {
            return prev;
        }

        //--------------------------------------------------------------------
        public void setLinkNext(DoubleNode node) {
            next = node;
        }

        //--------------------------------------------------------------------
        public void displayNode() {
            System.out.print(data);
        }

        //--------------------------------------------------------------------
        public String toString() {
            return data.toString();
        }
        
    //end class    
    }
//end class
}
