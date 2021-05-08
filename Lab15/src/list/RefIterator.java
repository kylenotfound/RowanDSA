package list;

/**
 * will be used to iterate through a Linkedlist (using the references in the LinkedList)
 */
class RefIterator<E> implements Iterator<E> {

    LinkedList<E> list;
    //reference to the node storing the last value
    //obtained by a call to next
    Node<E> cursor;

    //Constructor
    RefIterator(LinkedList<E> list) {
        this.list = list;
        cursor = list.head;
    }

    @Override
    public boolean hasNext() {
        return cursor.next != list.tail;
    }

    @Override
    public E next() {
        cursor = cursor.next;
        return cursor.value;
    }

    @Override
    public void remove() {
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        list.size--;
    }

    /* RefIterator Class */
    public boolean has2More(){
        return hasNext() && cursor.next.next != list.tail;
    }

    @Override
    public void remove2() {

    }

}
