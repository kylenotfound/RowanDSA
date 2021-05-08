package tree;

import list.Iterator;

/**
 * A binary tree may have a value, and 0-2 children,
 * each of which is also a Binary Tree
 * @author Kyle Evangelisto
 * @param <E>
 */
public interface BinaryTree<E> {

    /**
     * Return the value of this binary tree or a null reference if there is no value
     */
    E getValue();

    /**
     * return the left child of a binary tree
     */
    BinaryTree<E> getLeft();

    /**
     * return the right child of a binary tree
     */
    BinaryTree<E> getRight();

    /**
     * Set the value of this binary tree to the given value
     */
    void setValue(E value);

    /**
     * Set the left child of the binary tree to the given binary tree
     */
    void setLeft(BinaryTree<E> left);

    /**
     * Set the right child of the binary tree to the given binary tree
     */
    void setRight(BinaryTree<E> right);

    /**
     * return true iff this binary tree os empty
     */
    boolean isEmpty();

    /**
     * return the size of the family of the binary tree
     */
    int size();

    /**
     * Search the family of this binary tree for the given value.
     * return the value found, or null if not found
     */
    E get(E value);

    /**
     * Add the given value to the family of this binary tree.
     * return the resulting binary tree
     */
    BinaryTree<E> add(E value);

    /**
     * return true iff the given object is in the family
     * of the binary tree
     */
    boolean containsKey(Object obj);

    /**
     * Remove the BinaryTree which has a value equal
     * to the given object from the family of this
     * BinaryTree, if possible.
     * return the resulting BinaryTree
     */
    BinaryTree<E> remove(Object obj);

    Iterator<E> iterator();
}
