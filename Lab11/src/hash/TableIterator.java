package hash;

import list.Iterator;

/**
 * A TableIterator permits the client to iterate
 * through a HashTable.
 * @author Kyle Evangelisto
 */
public class TableIterator <K> implements Iterator<K> {

    HashTable<K> table;
    Iterator<K> iterator;
    int index = 0; //current index in the array list.

    public TableIterator(HashTable<K> table) {
        this.table = table;
        setIterator(index);
    }

    /**
     * Set the iterator of the LinkedList at the given index
     * in the Array List
     */
    private void setIterator(int index) {
        iterator = table.lists.get(index).iterator();
    }

    /**
     * @return the index of the next non-empty LinkedList, or -1 if none.
     */
    private int nextList() {
        for(int i = index + 1; i < table.lists.size(); i++) {
            if (!table.lists.get(i).isEmpty()){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        if(iterator.hasNext()){
            return true;
        }
        return nextList() > 0;
    }

    @Override
    public K next() {
        if (!iterator.hasNext()) {
            index = nextList();
            setIterator(index);
        }
        return iterator.next();
    }

    @Override
    public void remove() {
        iterator.remove();
        table.size--;
    }

    @Override
    public boolean has2More() {
        return false;
    }
}
