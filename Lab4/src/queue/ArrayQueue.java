package queue;

import list.*;

public class ArrayQueue<E> implements QueueADT<E> {

    List<E> values = new ArrayList<E>();
    int front = 0;
    int back = 0;
    int size = 0;

    public void add(E value) {
        //ArrayList is full?
        if (size == values.size()) {
            values.add(back, value); //Insert
            front = (front + 1) % values.size(); //wrap Around
        } else {
            values.set(back, value); //Clobber
        }
        back = (back + 1) % values.size(); //Wrap Around
        size++;
    }

    public E remove() {
        E result = values.get(front);
        front = (front + 1) % values.size();
        size--;
        return result;
    }

    public E peek() {
        if (size > 0) {
            return values.get(front);
        }
        return null;
    }

    public int size() {
        return values.size();
    }

    public void clear() {
        values.clear();
        size = 0;
        front = 0;
        back = 0;
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public String toString() {
        return values.toString();
    }
}
