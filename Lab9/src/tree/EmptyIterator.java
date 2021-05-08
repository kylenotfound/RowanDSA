package tree;
import list.*;

public class EmptyIterator<E> implements Iterator<E> {

    public boolean hasNext() {
        return false;
    }

    public E next() {
        return null;
    }

    public void remove() {

    }

    public boolean has2More() {
        return false;
    }
}
