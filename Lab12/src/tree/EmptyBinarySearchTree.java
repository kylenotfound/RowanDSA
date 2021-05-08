package tree;

import list.Iterator;

/**
 * A BinaryTree which has no value and no children
 * @param <E>
 */
public class EmptyBinarySearchTree<E extends Comparable> implements BinaryTree<E>{

    public BinaryTree<E> add (E value) {
        BinarySearchTree.added = true;
        return new BinarySearchTree<E> (value);
    }

    public boolean containsKey(Object obj) {
        return false;
    }

    public E get (E value) {
        return null;
    }

    @Override
    public E getValue() {
        return null;
    }

    @Override
    public BinaryTree<E> getLeft() {
        return null;
    }

    @Override
    public BinaryTree<E> getRight() {
        return null;
    }

    @Override
    public void setValue(E value) {
        //stub
    }

    @Override
    public void setLeft(BinaryTree<E> left) {
        //stub
    }

    @Override
    public void setRight(BinaryTree<E> right) {
        //stub
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 0;
    }

    @Override
    public BinaryTree<E> remove(Object obj) {
        return this;
    }

    public Iterator<E> iterator(){
        return new EmptyIterator<E>();
    }
}
