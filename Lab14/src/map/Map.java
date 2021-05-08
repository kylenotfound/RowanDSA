package map;

import set.*;

/**
 * Each entry in a map consists of a key and a value.
 * Keys must be unique.
 * Access the values via the keys
 * @author Kyle Evangelisto
 */
public interface Map <K, V> {

    /**
     *
     * @return true iff the Map contains the given key.
     */
    boolean containsKey(K key);

    /**
     *
     * @return the value corresponding to the given key, or null if not in the map
     */
    V get (K key);

    /**
     *
     * If the given key is already in the map, change its corresponding value
     * to the given value. If not, include the key-value pair in this map
     * @param key
     * @param value
     * @return the old value, or null if it is not in this map.
     */
    V put (K key, V value);

    /**
     *
     * Remove the key-value pair having the given key from this map
     * @param key
     * @return the value, or null if not in this map
     */
    V remove(K key);

    /** Clear this Map */
    void clear();

    /** @return true iff this Map is empty */
    boolean isEmpty();

    /** @return the number of entries in this Map  */
    int size();

    /**  @return the entries in this Map as a String, in the format key=value */
    String toString();

    /** @ return a Set of all the keys in this Map */
    Set<K> keySet();

    /** @return true iff obj is a Map, and maps the same keys
     *to the same values as this Map*/
    boolean equals(Object obj);

}
