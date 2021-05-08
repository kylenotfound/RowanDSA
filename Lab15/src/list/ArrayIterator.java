package list;

/**
 * will be used to iterate through an ArrayList.
 */
class ArrayIterator<E> implements Iterator<E> {

    List<E> list;
    int ndx = -1;

    ArrayIterator(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return ndx < list.size() - 1;
    }

    @Override
    public E next() {
        ndx++; //go to the next position
        return  list.get(ndx);
    }

    @Override
    public void remove() {
        list.remove(ndx);
        ndx--;
    }

    /* ArrayIterator Class */
    public boolean has2More() {
        return ndx < list.size() - 2;
    }

    /** Remove the last value obtained by a call to
     * next(), and the following value.
     * Pre: There are two such values remaining in the List
     * Pre:  The next() method has been called at least once since the last call to remove() or remove2()
     */
    public void remove2() {
        this.remove(); //remove first element, we know we have one because of pre
        if (this.hasNext()){ //if we have another element after
            this.next(); //go to the next element
            this.remove(); //remove the second element
        }
    }

}
