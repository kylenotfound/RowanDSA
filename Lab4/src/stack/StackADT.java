package stack;

/**
 * A stack is a last in first out list.
 * Access is limited to the 'top' of the Stack.
 * @param <E>
 */

public interface StackADT<E> {

    /**
     * Add the given value at the top of this StackADT
     * @return the value which was pushed
     */

    E push (E value);

    /**
     * Remove the value at the top of this StackADT.
     * @return the value removed
     * Pre: This StackADT is not empty.
     */

    E pop();

    /**
     * @return the value at the top of this StackADT.
     * Pre: This StackADT is not empty.
     */

    E peek();

    /**Clear the StackADT **/
    void clear();

    /** @return true if the stack is empty **/
    boolean isEmpty();

    /** @return the number of elements in this StackADT **/
    int size();

}
