package set;

import list.Iterator;
import tree.*;

/**
 * An implementation of Set, using a BinaryTree
 * @author Kyle Evangelisto
 * @param <E>
 */
public class TreeSet<E extends Comparable> implements Set<E> {

    BinaryTree<E> tree = new EmptyBinarySearchTree<E>();
    int size = 0;

    public boolean contains(Object obj) {
        return tree.containsKey(obj);
    }

    public boolean add(E value) {
        if(contains(value)) {
            return false;
        }
        tree = tree.add(value);
        size++;
        return true;
    }

    public boolean remove(Object obj) {
        if(!contains(obj)) {
            return false;
        }
        tree = tree.remove(obj);
        size--;
        return true;
    }

    public Iterator<E> iterator(){
        if(size == 0) {
            return new EmptyIterator<>();
        }
        return new TreeSetIterator<E>(this);
        //return tree.iterator();
    }

    public void clear() {
        size = 0;
        tree = new EmptyBinarySearchTree<E>();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Set)) {
            return false;
        }
        Set<E> other = (Set<E>) obj;
        if(this.size != other.size()) {
            return false;
        }
        Iterator<E> it = this.iterator();
        while(it.hasNext()) {
            if(!other.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        Iterator<E> iterator = this.iterator();
        StringBuilder builder = new StringBuilder();
        while(iterator.hasNext()) {
            builder.append(iterator.next().toString()).append(" ");
        }
        return builder.toString();
    }

}
