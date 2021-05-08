package list;

/**
 * A ListIterator specifically for LinkedLists.
 */

class RefListIterator <E> extends RefIterator<E> implements ListIterator<E> {

    /**
     * cursor, in the superclass, is a reference
     * to the last value returned by a call to next()
     * or previous()
     */

    private boolean forward = true;

    RefListIterator (LinkedList<E> list) {
        super(list);
    }

    // @param start is starting position for the iteration
    RefListIterator (LinkedList<E> list, int start) {
        super(list);
        for (int i = 0; i < start; i++) {
            cursor = cursor.next;
        }
    }

    @Override
    public boolean hasNext() {
        if (list.isEmpty()) {
            return false;
        }

        if (forward) {
            return cursor.next != list.tail;
        }

        return true;
    }

    @Override
    public E next() {
        if (forward) {
            cursor = cursor.next;
        }
        forward = true;
        return  cursor.value;
    }

    @Override
    public boolean hasPrevious() {
        if (!forward) {
            return  cursor.prev != list.head;
        }
        return cursor != list.head; //initial call to hasPrevious() ?
    }

    @Override
    public E previous() {
        if (!forward) {
            cursor = cursor.prev;
        }
        forward = false;
        return  cursor.value;
    }

    @Override
    public void remove() {
        super.remove();
        if (forward) {
            cursor = cursor.prev;
        } else {
            cursor = cursor.next;
        }
    }

    public void add (E value) {
        if(forward) {
            Node<E> temp = new Node<E> (value, cursor.next, cursor);
            cursor.next.prev = temp;
            cursor.next = temp;
            cursor = temp;
            list.size++;
        }
        else {
            Node<E> temp = new Node<E> (value, cursor, cursor.prev);
            cursor.prev.next = temp;
            cursor.prev = temp;
            list.size++;
        }
    }
}
