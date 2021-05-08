package queue;

import list.*;

/**
 * A PriorityQueue is a Queue, in which each item has a priority
 * When removing, the value with the highest priority is removed (not FIFO)
 * @author Kyle Evangelisto
 * @param <E>
 */
public class PriorityQueue <E extends  Comparable> implements QueueADT<E>{

    List<E> values = new ArrayList<>();
    //we need to track size here in order to check isEmpty, clear, etc.
    int size = 0; //prevent removing a last item, or having to add and remove from the list

    public PriorityQueue() {}

    public E remove() {
        if (size == 0) {
            return null;
        }
        E result = values.get(0);   //highest priority
        int last = values.size() - 1;
        int available = 0;  //position of an available slot
        int bc = biggerChild(0);    //Position of bigger child
        size--; //decrement the size

        while (((2 * available + 1) < last) && (greater(bc, last))) {
            values.set(available, values.get(bc));
            available = bc;
            bc = biggerChild(available);
        }

        values.set(available, values.get(last));
        values.remove(last);
        return result;
    }

    public void add(E value) {
        int added, parent;
        values.add(value);
        added = values.size() - 1;
        parent = (added - 1) / 2;
        size++; //increment size

        while (added > 0 && greater(added, parent)) {
            swap(added, parent);    //added moves up
            added = parent;
            parent = (added - 1) / 2;
        }
    }

    /**
     * @return position of the parents bigger child
     */
    private int biggerChild(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;

        if (right >= values.size()) {
            return left;
        }
        if (greater(left, right)) {
            return left;
        }
        return right;
    }

    /**
     * @return true iff the value at position x is greater than the value at position y
     */
    private boolean greater (int x, int y) {
        return values.get(x).compareTo(values.get(y)) > 0;
    }

    /**
     * Swap the two values, not shown in lecture but reused
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        E temp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, temp);
    }

    /**
     * @return the value at the front of the queue,
     *  or null if the queue is empty
     */
    public E peek() {
        if (size() == 0) {
            return null;
        }
        return values.get(0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        Iterator<E> iterator = values.iterator();
        StringBuilder result = new StringBuilder("[");
        while (iterator.hasNext()) {
            result.append(iterator.next()).append(", ");
        }
        return result + "]";
    }

}
