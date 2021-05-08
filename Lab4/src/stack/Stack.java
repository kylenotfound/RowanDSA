package stack;

import list.*;

/**
 * An implementation of the StackADT interface using a List.
 * Client may opt for an ArrayList or a LinkedList.
 * Top of the Stack is at the end of the List.
 * @author Kyle Evangelisto
 */
public class Stack<E> implements StackADT<E> {
    List<E> values = new ArrayList<E>();

    /**
     * Default constructor that uses an ArrayList.
     */
    public Stack() { }

    /**
     * Constructor
     * @param arrayBased => Use an ArrayList.
     *        !arrayBased => Use a LinkedList
     */

    public Stack (boolean arrayBased) {
        if (!arrayBased) {
            values = new LinkedList<E>();
        }
    }

    public E push (E value) {
        values.add(value);
        return value;
    }

    //remove to pop
    public E pop () {
        return values.remove(values.size() - 1);
    }

    //get to peek
    public E peek () {
        return values.get(values.size() - 1);
    }


    public void clear() {
       values.clear();
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public int size() {
        return values.size();
    }

    @Override
    public String toString() {
        return "Stack{" +
                "values=" + values +
                '}';
    }
}
