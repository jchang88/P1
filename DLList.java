/**
 * Doubly Linked List implementation of the List interface.
 * Uses sentinel nodes at the head & tail, and an inner Node class.
 * This is only a partial implementation, loosely based on OpenDSA version.
 *
 * This version differs notably from the DSA version in that the curr 
 * data member refers to the node *before* the cursor, whereas in OpenDSA
 * the curr data member refers to the node *after* the cursor.
 *
 * @author Joanne Selinski
 * @param <T> the type of the List
 */
public class DLList<T> implements List<T> {

    /**
     * Inner doubly linked Node class for convenience.
     * Note that the generic type is implied since we are within DLList<T>.
     */
    public class Node {

        /** The data in the element. */
        private T data;
        /** The left neighbor node. */
        private Node prev;
        /** The right neighbor node. */
        private Node next;

        /**
         * Make a node.
         * @param item the data to put in it
         * @param p the link to the previous node
         * @param n the link to the next node
         */
        public Node(T item, Node p, Node n) {
            this.data = item;
            this.prev = p;
            this.next = n;
        }
    }

    /** Head node. */
    private Node head;
    /** Number of actual data nodes in list. */
    private int size;
    /** Current node (think of as a cursor between nodes). */
    private Node curr;
    /** Position of the current node in int. */    
    private int position;

    /**
     * Create an empty list with sentinels.
     */
    public DLList() {
        this.clear();  // code reuse!
    }
    
    /**
     * Remove all contents from the list, so it is once again empty.
     */
    public void clear() {
        this.size = 0;
        this.head = new Node(null, null, null);
        this.curr = this.head;
    }

    /**
     * Insert a value at (after) the current location.
     * The client must ensure that the list's capacity is not exceeded.
     * @param t the value to insert
     * @return true if successfully inserted, false otherwise
     */
    public boolean insert(T t) {
        if (this.size == 0){
            this.head.data = t;
            this.head.prev = this.head;
            this.head.next = this.head;
            this.size++;
            return true;
        } else if (this.size == 1) {
            Node n = new Node(t, this.head, this.head);
            this.head.next = n;
            this.head.prev = n;
            this.size++;
            return true;
        } else {
            Node n = new Node(t, this.curr, this.curr.next);
            n.prev.next = n;   // connect left neighbor
            n.next.prev = n;   // connect right neighbor
            this.size++;
            return true;
        }
    }

    /**
     * Append a value at the end of the list.
     * The client must ensure that the list's capacity is not exceeded.
     * @param t the value to append
     * @return true if successfully appended, false otherwise
     */
    public boolean append(T t) {
        Node temp = this.curr;        // hold onto original position
        this.curr = this.head.prev;   // move to before the tail sentinel
        this.insert(t);               // code reuse!
        this.curr = temp;             // restore cursor to original position
        return true;
    }

    /**
     * Remove and return the current element (one to right of cursor). 
     * @return the value of the element removed, null if list is empty
     */
    public T remove() {
        if (this.curr.next == this.head.prev) {
            return null;
        }
        T val = this.curr.next.data;
        this.curr.next = this.curr.next.next;  // bypass node being deleted
        this.curr.next.prev = this.curr;       // bypass it in other direction
        this.size--;
        return val;
    }

    /**
     * Return the current element (data to right of cursor).
     * @return the value of the current element, null if none
     */
    public T getValue() {
        if (this.curr.next == this.head.prev) {
            return null;
        }
        return this.curr.next.data;
    }

    /**
     * Return the number of elements in the list.
     * @return the length of the list
     */
    public int length() {
        return this.size;
    }

    /* ---------- METHODS BELOW THIS LINE ARE NOT IMPLEMENTED ------------ */

    /**
     * Set the current position to the start of the list.
     */
    public void moveToStart() {
        this.curr = this.head;
        this.position = 0;
    }

    /**
     * Set the current position to the end of the list.
     */
    public void moveToEnd() {
        this.curr = this.head.prev;
        this.position = this.size - 1;
    }

    /**
     * Move the current position one step left,
     * no change if already at beginning.
     */
    public void prev() {
        if (this.position != 0) {
            this.curr = this.curr.prev;
            this.position -= 1;
        }
    }

    /**
     * Move the current position one step right, no change if already at end.
     */
    public void next() {
        if (this.position != this.size - 1) {
            this.curr = this.curr.next;
            this.position += 1;
        }
    }

    /**
     * Return the position of the current element.
     * @return the current position in the list
     */
    public int currPos() {
        return this.position;
    }

    /**
     * Set the current position.
     * @param pos the value to set the position to
     * @return true if successfully changed position, false otherwise
     */
    public boolean moveToPos(int pos) {
        this.position = pos;
        return true;
    }

    /**
     * Return true if current position is at end of the list.
     * @return true if the current position is the end of the list
     */
    public boolean isAtEnd() {
        if (this.position == this.size - 1) {
            return true;
        }
        return false;
    }

}
