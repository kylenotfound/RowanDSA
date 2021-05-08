package queue;
import list.*;

/**
 * An implementation of the QueueADT interface, using a
 * LinkedList
 */

public class Queue<E> implements QueueADT<E> {

    List<E> values = new LinkedList<E>();

    //front is at pos 0 (head)
    //back is at position size - 1 (tail)
    @Override
    public void add (E value) {
        values.add(value);
    }

    @Override
    public E remove() {
        return values.remove(0);
    }

    @Override
    public E peek() {
        if (values.isEmpty()) {
            return null;
        }
        return values.get(0);
    }

    @Override
    public int size() {
        return values.size();
    }

    public void clear() {
        values.clear();
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public String toString() {
        return values.toString();
    }
}
