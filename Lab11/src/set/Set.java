package set;

import list.*;

/**
 * A collection wit no duplicates. Ordering
 * of the values does not need to be maintained.
 * @author Kyle Evangelisto
 * @param <E>
 */
public interface Set<E> {

    /**
     * @return true iff this set contains the given object
     */
    boolean contains(Object obj);

    /**
     * Add the given value to this Set, if not already in the set
     * @return true iff it was added.
     */
    boolean add(E value);

    /**
     * Remove the given object from this Set, if possible.
     * @return true iff it was removed.
     */
    boolean remove (Object obj);

    /**
     * @return an iterator for this Set
     */
    Iterator<E> iterator();

    /**
     * @return if the set is empty or not
     */
    boolean isEmpty();

    /**
     * clear the set
     */
    void clear();

    /**
     * @return the size of the set
     */
    int size();

    /** @return true iff obj is a Set which contains the same values as
     * this Set, and only those values which are in this Set*/
    boolean equals (Object obj);
}
