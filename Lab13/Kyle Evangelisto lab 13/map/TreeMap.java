package map;


import list.*;
import set.*;
import tree.BinaryTree;
import tree.EmptyBinarySearchTree;

/**
 *
 * An implementation of the Map interface using a BinaryTree of entries
 * @author Kyle Evangelisto
 */
public class TreeMap <K extends Comparable, V> implements Map<K, V> {

    class Entry <K extends Comparable, V> implements Comparable<Entry<K, V>> {
        K key;
        V value;

        Entry (K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         *
         * @param other
         * @return a positive int if this Entry is greater than the other,
         * return 0 if this Entry equals the other,
         * return a negative int if this Entry is less than the other
         */
        public int compareTo(Entry<K, V> other) {
            return key.compareTo(other.key);
        }

        public String toString() {
            return "[key=" + key + ", value=" + value + "]";
        }
    }

    BinaryTree<Entry<K, V>> tree = new EmptyBinarySearchTree<>();
    int size = 0;

    public boolean containsKey(K key) {
        Entry <K, V> entry = new Entry<K, V>(key, null);
        return tree.containsKey(entry);
    }

    public V get (K key) {
        Entry<K,V> entry = new Entry<K,V>(key, null);
        entry = tree.get(entry);
        if(entry == null) {
            return null;
        }
        return entry.value;
    }

    public V put(K key, V value) {
        Entry<K,V> newEntry = new Entry<K,V>(key, value);
        Entry<K,V> oldEntry = tree.get(newEntry);
        if(oldEntry == null) {
            tree = tree.add(newEntry);
            size++;
            return null;
        }
        V oldValue = oldEntry.value;
        oldEntry.value = value;
        return oldValue;
    }

    public V remove(K key) {
        Entry<K,V> entry = new Entry<K,V>(key, null);
        entry = tree.get(entry);
        if(entry == null) {
            return null;
        }
        tree = tree.remove(entry);
        size--;
        return entry.value;
    }

    public void clear() {
        //clear by making tree a new empty tree
        tree = new EmptyBinarySearchTree<Entry<K, V>>();
    }

    public boolean isEmpty() {
        return tree.isEmpty();
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "[ ]"; //show the user that there tree map is empty
        }
        Iterator<Entry<K, V>> iterator = tree.iterator();
        StringBuilder builder = new StringBuilder("[");
        while (iterator.hasNext()) {
            builder.append(iterator.next().toString()).append(",");
        }
        return builder + "]";
    }

    public Set<K> keySet(){
        Set<K> keys = new HashSet<K>();
        Iterator<Entry<K,V>> iterator = tree.iterator();
        while(iterator.hasNext()) {
            keys.add(iterator.next().key);
        }
        return keys;
    }

}
