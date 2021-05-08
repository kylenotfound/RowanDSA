package set;

import tree.*;

public class TreeSetIterator<E extends Comparable> extends TreeIterator<E> {

    TreeSet<E> set;
    //I am assuming this is what we want here, i was getting a null pointer exception
    //when returning tree.iterator() in TreeSet.java
    public TreeSetIterator(TreeSet<E> set) {
        super(set.tree);
        this.set = set;
    }

    public void remove() {
        set.tree = set.tree.remove(getLastGotten());
        set.size--;
    }
}
