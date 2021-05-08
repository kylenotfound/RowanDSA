package list;

/**
 * A node stores one value in a LinkedList and
 * a reference to the next node in the list.
 * @author Kyle Evangelisto
 * @version Feb 2021
 */
class Node <E> {

    E value;
    Node <E> next; //represents the next node in the list
    Node<E> prev; //represents the previous node in the list

    //Constructor
    Node (E value, Node<E> next, Node<E> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

}

public class LinkedList <E> implements List <E> {

    //declare some class variables

    int size = 0;
    private Node<E> ref;
    Node<E> head = new Node<E>(null, null, null);
    Node<E> tail = new Node<E>(null, null, head);

    //constructor
    public LinkedList() {
        head.next = tail;
    }

    /**
     * Add the given value at the end of the linked list
     */
    public void add(E value) {
        Node<E> temp = new Node<E>(value, tail, tail.prev);
        tail.prev.next = temp;
        tail.prev = temp;
        size++;
    }

    /**
     * Insert given value at given position in this list
     *
     * @param 0 <= ndx <= size
     */
    public void add(int ndx, E value) {
        setRef(ndx);
        Node<E> temp = new Node<E>(value, ref, ref.prev);
        ref.prev.next = temp;
        ref.prev = temp;
        size++;
    }

    /**
     * @param 0 <= ndx < size
     * @return value at given index
     */
    public E get(int ndx) {
        setRef(ndx);
        return ref.value;
    }

    /**
     * Change the value at given ndx to given value
     *
     * @param 0 <= ndx < size
     * @return old value
     */
    public E set(int ndx, E value) {
        setRef(ndx);
        E result = ref.value;
        ref.value = value;
        return result;
    }

    private void setRef(int ndx) {
        if (ndx < size() / 2) {
            ref = head.next;
            for (int i = 0; i < ndx; i++) {
                ref = ref.next;
            }
        } else {
            ref = tail.prev;
            for (int i = 0; i < (size - ndx - 1); i++) {
                ref = ref.prev;
            }
        }
    }

    /**
     * @return the position of the first occurrence of the given Object in this List,
     * or -1 if it is not in this List
     */
    public int indexOf(Object obj) {
        ref = head.next;
        for (int index = 0; index < size(); index++) {
            if (ref.value.equals(obj)) {
                return index;
            }
            ref = ref.next;
        }
        return -1;
    }

    /**
     *  Utilize the indexOf method
     * @param obj
     * @return
     */
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /**
     * Clear this List
     */
    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     *
     * @return true boolean for if the size is 0 or not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @return the size of this List
     */
    public int size() {
        return size;
    }

    /**
     *
     * @return a string representation of the Linked List
     */
    public String toString() {
        ref = head.next;
        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < size() - 1; i++) {
            output.append(ref.value).append(", ");
            ref = ref.next;
        }

        if (size() > 0) {
            output.append(ref.value);
        }

        return output + "]";
    }

    /**
     * Remove the value at given ndx from this list
     *
     * @param
     * @return
     */
    public E remove(int ndx) {
        setRef(ndx);
        ref.prev.next = ref.next;
        ref.next.prev = ref.prev;
        size--;
        return ref.value;
    }

    /**
     * Utilize contains, remove and index of methods written in step 1 of the lab
     * @param obj
     * @return
     */
    public boolean remove(Object obj) {
        if (contains(obj)) {
            remove(indexOf(obj));
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new RefIterator<E>(this);
    }

    @Override
    public ListIterator<E> listIterator() {
        return new RefListIterator<E>(this);
    }

    @Override
    public ListIterator<E> listIterator(int start) {
        return new RefListIterator<E>(this, start);
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof List)) {
            return false;
        }

        List list = (List)obj;
        if(list.size() == this.size()) {
            Iterator<E> iterator1 = list.iterator();
            Iterator<E> iterator2 = this.iterator();

            while(iterator1.hasNext()) {
                if(!(iterator1.next().equals(iterator2.next()))) {
                    return false;
                }
            }
        }

        return true;
    }

}

