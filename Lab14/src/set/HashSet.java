package set;

import hash.*;
import list.*;

/**
 * An implementation of Set, using a HashTable
 * @author Kyle Evangelisto
 * @param <E>
 */
public class HashSet<E> implements Set<E>{

    HashTable<E> table = new HashTable<>();
    int size = 0;

    @Override
    public boolean contains(Object obj) {
        return table.containsKey(obj);
    }

    @Override
    public boolean add(E value) {
        if(contains(value)) {
            return false;   //no duplicates
        }
        table.put(value);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        size--;
        return table.remove(obj);
    }

    @Override
    public Iterator<E> iterator() {
        return table.iterator();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        table = new HashTable<>();
    }

    @Override
    public int size() {
        return table.size();
    }

    public boolean equals (Object obj) {
        if(!(obj instanceof Set)) {
            return false;
        }
        Set<E> other = (Set) obj;
        if(table.size() != other.size()) {
            return false;
        }
        Iterator <E> iterator = this.iterator();
        while(iterator.hasNext()) {
            if (!(other.contains(iterator.next()))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        Iterator<E> it = this.iterator();
        StringBuilder builder = new StringBuilder();
        while(it.hasNext()) {
            builder.append(it.next().toString()).append(" ");
        }
        return builder.toString();
    }

    //quiz 6
    public Set<E> intersection(Set <E> other){
        if(this.isEmpty()) {
            return this;
        }
        if(other.isEmpty()) {
            return other;
        }
        Set<E> intersectionSet = new HashSet<E>();
        Iterator<E> iterator = this.iterator();
        while(iterator.hasNext()) {
            E nextElement = iterator.next();
            if(other.contains(nextElement)) {
                intersectionSet.add(nextElement);
            }
        }
        return intersectionSet;
    }
}
