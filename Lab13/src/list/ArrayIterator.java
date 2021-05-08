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
}
