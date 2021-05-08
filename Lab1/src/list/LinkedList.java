package list;

/**
 * A node stores one value in a LinkedList and
 * a reference to the next node in the list.
 * @author Kyle Evangelisto
 * @version Jan 2021
 */
class Node <E> {

    E value;
    Node <E> next;

    //Constructor
    Node (E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

}

public class LinkedList <E> implements List <E> {

    int size = 0;
    //Dummy Head node
    Node<E> head = new Node<E> (null, null);
    Node<E> tail = head;

    @Override
    public E get(int ndx) {
        Node<E> ref = head.next;
        for (int i = 0; i < ndx; i++) {
            ref = ref.next;
        }
        return ref.value;
    }

    @Override
    public E set(int ndx, E value) {
        Node<E> ref = head.next;
        for (int i = 0; i < ndx; i++) {
            ref = ref.next;
        }
        E result = ref.value;
        ref.value = value;
        return result;
    }

    public void add (E value) {
        Node<E> temp = new Node<E> (value, null);
        tail.next = temp;
        tail = temp;
        size++;
    }

    public void add (int ndx, E value) {
        //inserting in tail?
        if (ndx == size) {
            add(value);
        } else {
            Node<E> ref = head;
            for (int i = 0; i < ndx; i++) {
                ref = ref.next;
            }
            Node<E> temp = new Node<E> (value, ref.next);
            ref.next = temp;
            size++;
        }
    }

    @Override
    public E remove(int ndx) {
        Node<E> ref = head;
        for (int i = 0; i < ndx; i++){
            ref = ref.next;
        }
        E result = ref.next.value;
        if (ref.next == tail) {
            tail = ref;
        }
        ref.next = ref.next.next;
        //java garbage collector memory returns to system.
        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object obj) {
        return 0;
    }

    @Override
    public boolean contains(Object obj) {
        return false;
    }

    @Override
    public int indexOfLast(Object obj) {
        return 0;
    }

}
