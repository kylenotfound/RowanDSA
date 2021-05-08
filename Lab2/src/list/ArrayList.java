package list;

/**
 * An implementation of the List interface,
 * using an array to store the values.
 * @author Kyle Evangelisto
 * @version Jan 2021
 */

public class ArrayList <E> implements List <E> {

    private int size = 0;
    private E[] values;

    //default constructor
    public ArrayList() {
        this (10);
    }

    //parametrized constructor
    public ArrayList (int cap) {
        values = (E[]) new Object[cap];
    }

    public void add (E value) {
        add(size , value);
    }

    public void add (int ndx, E value) {
        //is the array full?
        if (values.length == size) {
            alloc(); //allocate more room
        }

        //make room for insertion
        for(int i = size; i > ndx; i--) {
            values[i] = values[i - 1];
        }

        values[ndx] = value;
        size++;
    }

    //implementing abstract functions from interface
    public E get (int ndx) {
        return values[ndx];
    }

    public E set (int ndx, E value) {
        E result = values[ndx];
        values[ndx] = value;
        return result;
    }

    /**
     * Allocate a new array, twice as big,
     * and copy all values
     */
    private void alloc() {
        E[] tempArray = (E[]) new Object[2 * values.length];
        for(int i = 0; i < size; i++){
            tempArray[i] = values [i];
        }
        values = tempArray;
    }


    public E remove (int ndx) {
        //Don't clobber the result
        E result = values[ndx];

        for(int i = ndx; i < size - 1; i++) {
            values[i] = values [i + 1];
        }
        size--;
        return result;
    }

    @Override
    public boolean remove(Object obj) {
        if (contains(obj)) {
            remove(indexOf(obj));
            return true;
        }
        return false;
    }

    /**@Override
    public int indexOfLast(Object obj) {
        return 0;
    }*/

    public int size () {
        return size;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public void clear () {
        for(int i = 0; i < size(); i++) {
            values[i] = (E) new Object();
        }
        size = 0;
    }

    public int indexOf (Object obj) {
        for(int i = 0; i < size; i++) {
            if(values[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains (Object obj) {
        return indexOf(obj) != -1;
    }

    public String toString () {
        StringBuilder output = new StringBuilder("[");
        for(int i = 0; i < size() - 1; i++) {
            output.append(values[i]).append(", ");
        }

        if(size() > 0) {
            output.append(values[size() - 1]);
        }

        return output + "]";
    }

}