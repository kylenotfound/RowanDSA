package list;

/**
 * An ADT for a Collection in which
 * duplicates are permitted, and order
 * is maintained
 * @author Kyle Evangelisto
 * @version Jan 2021
 */

public interface List <E> {
    /**
     *
     * @param 0 <= ndx <= size
     * @return the value at the given index in this list
     */
    E get (int ndx);

    /**
     * Set the value of the given index to the given value
     *
     * @param 0 <= ndx <= size
     * @return the old value
     */
    E set (int ndx, E value);

    /**
     * Add the given value at the end of this list
     *
     */
    void add (E value);

    /**
     * Insert the given value at the given index
     * @param 0 <= ndx <= size
     */
    void add(int ndx, E value);

    /**
     * Remove the value of the given index from this list
     * @param 0 <= ndx < size
     */

    E remove (int ndx);

    /**
     * @return the size of this List
     */

    int size();

    /** Clear this List */

    void clear();

    /**
     * @return true iff this List is empty
     */

    boolean isEmpty();

    /** @return the position of the first occurrence of the given Object in this List,
    or -1 if it is not in this List... Excerpt from Lab 1, question 1 documentation */

    int indexOf (Object obj);

    /** @return true only if the given Object is in this List... Excerpt from Lab 1, question 2 documentation */

    boolean contains (Object obj);

    /** Remove the first occurrence of the given object from this List.
     * @return true if and only if it was removed **/
    boolean remove (Object obj);

    /** @return the position of the last occurrence of the given Object in this List,
     *  or -1, if not found

    int indexOfLast (Object obj);*/
}
