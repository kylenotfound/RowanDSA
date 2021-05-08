package list;

public interface Iterator <E> {

    /**
     * @return true iff there are more values to be obtained
     * with this Iterator.
     */
    boolean hasNext();

    /**
     * @return the next value in the associated collection.
     * Pre: hasNext() is true.
     */
    E next();

    /**
     * Remove the last value obtained with this Iterator.
     * Pre: next() has been called at least once since the last
     * call to remove().
     */
    void remove();

    /** @return true iff there are at least two more values

     * to be obtained */

    boolean has2More();

    void remove2();
}
