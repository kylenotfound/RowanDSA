package map;

import hash.*;
import list.*;
import set.*;

/**
 *
 * An implementation of the Map interface using a HashTable of entries
 * @author Kyle Evangelisto
 */
public class HashMap <K, V> implements Map <K, V> {

    class Entry <K,V> {
        K key;
        V value;

        Entry (K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         *
         * @param obj
         * @return true iff the key of the given object is an entry and its key is
         * equal to the key of this Entry
         */
        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry<K, V> entry = (Entry<K, V>) obj;
            return this.key.equals(entry.key);
        }

        /**
         *
         * @return a key's hashcode
         */
        public int hashCode() {
            return key.hashCode();
        }

        public String toString() {
            return "[key=" + key + ", value=" + value + "]";
        }
    }

    HashTable<Entry<K, V>> table;

    public HashMap () {
        table = new HashTable<Entry<K, V>>();
    }

    public HashMap (int size) {
        table = new HashTable<Entry<K, V>>(size);
    }

    public boolean containsKey(K key) {
        Entry<K, V> entry = new Entry<>(key, null); //we only look at keys
        return table.containsKey(entry);
    }

    public V get(K key) {
        Entry<K, V> entry = new Entry<>(key, null);
        entry = table.get(entry);
        if (entry == null) {
            return null; //not in table
        }
        return entry.value;
    }

    public V put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value) ,
                oldEntry = table.get(newEntry);
        if (oldEntry == null) {
            table.put(newEntry);
            return null;
        }
        V oldValue = oldEntry.value;
        oldEntry.value = value;
        return oldValue;
    }

    public V remove(K key) {
        Entry<K, V> entry = new Entry<>(key, null),
                result = table.get(entry);
        if (table.remove(entry)) {
            return result.value;
        }
        return null;
    }

    public void clear() {
        table.clear();
    }

    public boolean isEmpty() {
        return table.isEmpty();
    }

    public int size() {
        return table.size();
    }

    public String toString() {
        int i = 0;
        StringBuilder builder = new StringBuilder("[");
        Iterator<Entry<K,V>> iterator = table.iterator();
        while(iterator.hasNext() && i < table.size() - 1) {
            builder.append(iterator.next().toString()).append(",");
            i++;
        }
        return builder.toString() + iterator.next() + "]";
    }

    public Set<K> keySet(){
        Set<K> hashSet = new HashSet<K>();
        Iterator<Entry<K,V>> iterator = table.iterator();
        while(iterator.hasNext()) {
            hashSet.add(iterator.next().key);
        }
        return hashSet;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HashMap)) {
            return false;
        }
        HashMap<K, V> other = (HashMap<K, V>) obj;
        if (other.size() != this.size()) {
            return false;
        }
        while(table.iterator().hasNext()) {
            if (!(table.iterator().next().key.equals(other.table.iterator().next().key))) {
                return false;
            }
        }
        return true;
    }

    //quiz 6
    public Set<K> getKeys(V value) {
        Set<K> keySet = new HashSet<>();
        Iterator<K> iterator = this.keySet().iterator();
        while (iterator.hasNext()) {
            K key = iterator.next();
            if (this.get(key).equals(value)) {
                keySet.add(key);
            }
        }
        return keySet;
    }

}
