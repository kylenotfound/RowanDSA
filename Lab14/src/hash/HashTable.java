package hash;

import list.*;

/**
 * Provide quick access to data values, using an ArrayList of LinkedLists.
 * performance is improved when the client's hashcode() minimizes collisions.
 *
 * If a class is going to use a hashtable, it should have an equals(Object obj) method
 * and a hashCode() method. Hashcode should agree with the equals().
 * If two objects have the same hashcode, it does not mean they are the same.
 * If two objects are equal, they must have the same hashcode.
 *
 * Many short LinkedLists => O(1)
 * Few Long Linked Lists => O(n)
 *
 * Searching a LinkedList => O(n)
 * Searching an ArrayList => O(1)
 *
 * @author Kyle Evangelisto
 * @version April 2021
 * @param <K> "Key"
 *
 */
public class HashTable<K> {

    List<List<K>> lists; //list of lists

    //Max length for linked list => ADDED for Lab 14
    private static final int MAX = 5;
    int maxList = 0;
    boolean noRehash = false;

    int size = 0;

    public HashTable (int cap) {
        lists = new ArrayList<List<K>>(cap); //current size is 0
        for (int i = 0; i < cap; i++) {
            lists.add(new LinkedList<K>()); //adding LinkedLists to the ArrayList
        }
    }

    /** Default ArrayList to Size 10*/
    public HashTable() {
        this(10); //size will be 10
    }

    /**
     * @return a valid index to the ArrayList, using the
     * client's hashcode() method
     */
    private int getCode(Object obj) {
        int result = obj.hashCode();
        result = Math.abs(result);
        result = result % lists.size(); //valid index
        return result;
    }

    /**
     * @return true iff the given obj is in this HashTable
     */
    public boolean containsKey(Object obj) {
        int code = getCode(obj);
        return lists.get(code).contains(obj);
    }

    /**
     * Add the given key to this HashTable
     */
    public void put(K key) {
        int code = getCode(key); //get the code
        List<K> list = lists.get(code);
        //too long? Lab 14
        if (list.size() > maxList) {
            maxList = list.size();
        }
        if (!noRehash) {
            rehash();
        }
        list.add(key);
        size++;
    }

    // Lab 14
    private void rehash() {
        if(maxList > MAX) {
            int oldMaxList = maxList;
            maxList = 0;
            List <List<K>> newTable = new ArrayList<List<K>>(2*lists.size());
            for(int i = 0; i < 2 * lists.size() ; i++) {
                newTable.add(new LinkedList<K>());
            }
            Iterator <K> iterator = this.iterator();
            while (iterator.hasNext()) {
                K key = iterator.next();
                int code = (Math.abs(key.hashCode())) % newTable.size();
                newTable.get(code).add(key);
                if(newTable.get(code).size() > maxList) {
                    maxList = newTable.get(code).size();
                }
            }
            this.lists = newTable;
            if (maxList == oldMaxList) {
                noRehash = true;
            }
        }
    }

    /**
     * @return a matching key from this HashTable,
     * or return null if not found.
     * Could be a problem with efficiency here.
     * Long HashTable = Long Linked List
     */
    public K get(K key) {
        int code = getCode(key);
        List<K> list = lists.get(code);
        int index = list.indexOf(key); //searching list once
        if (index < 0) {
            return null; //key not found
        }
        return list.get(index); //searching list again
    }

    /**
     * Remove the given obj from this HashTable, if possible.
     * @return true iff it was removed.
     */
    public boolean remove(Object obj) {
        int code = getCode(obj);
        List<K> list = lists.get(code);
        if (list.remove(obj)) {
            size--;
            return true;
        }
        return false;
    }

    /**
     * @return the number of keys in this HashTable *
     */
    public int size() {
        return size;
    }

    /** Clear this HashTable  */
    public void clear() {
        size = 0;
        lists = new ArrayList<List<K>>(10);
        for(int i = 0; i < 10; i++) {
            lists.add(new LinkedList<K>());
        }

    }

    /**
     * @return true iff this HashTable is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<K> iterator(){
        return new TableIterator<K>(this);
    }

    public String toString() {
        Iterator<K> iterator = this.iterator();
        StringBuilder builder = new StringBuilder();
        while(iterator.hasNext()) {
            builder.append(iterator.next().toString());
        }
        return builder.toString();

    }

}
