package list;

/**
 * A list iterator specifically for ArrayLists.
 * @param <E>
 */
public class ArrayListIterator <E> extends ArrayIterator<E> implements ListIterator<E> {
    /**
     * ndx is in the super class. Implicit cursor is between
     * ndx and ndx + 1
     */

    //forward => iterating left to right using next().
    //!forward => iterating right to left using previous().
    private boolean forward = true;


    ArrayListIterator(List<E> list) {
        super(list);
    }

    ArrayListIterator (List<E> list, int start) {
        super(list);
        ndx = start - 1;
    }

    @Override
    public boolean hasPrevious() {
        return ndx >= 0;
    }

    @Override
    public E previous() {
        forward = false;
        ndx--;
        return list.get(ndx + 1);
    }

    @Override
    public E next() {
        forward = true;
        return super.next();
    }

    @Override
    public void remove() {
        if (forward) {
            list.remove(ndx);
            ndx--;
        } else {
            list.remove(ndx + 1);
        }
    }

    public void add (E value) {
        list.add(ndx + 1, value);
        ndx++;
    }

}
