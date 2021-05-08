package tree;

import queue.*;
import list.*;

/**
 * An Iterator for a BinaryTree, using an iterator, using an in-order traversal.
 * Kyle Evangelisto
 */
public class TreeIterator<E> implements Iterator<E> {

    QueueADT<E> queue = new Queue<>();
    BinaryTree<E> tree;
    private E lastGotten;

    public TreeIterator(BinaryTree<E> tree) {
        this.tree = tree;
        buildQ(tree);
    }

    /**
     * Build a queue of values using InOrder traversal
     */
    private void buildQ (BinaryTree<E> tree) {
        if (tree.isEmpty()) {
            return;
        }
        buildQ(tree.getLeft());
        queue.add(tree.getValue());
        buildQ(tree.getRight());
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public E next() {
        lastGotten = queue.peek();
        return queue.remove();
    }

    public void remove() {
        //check if 2 children
        if (!tree.getLeft().isEmpty() &&
                !tree.getRight().isEmpty() ||
                !tree.getValue().equals(lastGotten)) {
            tree = tree.remove(lastGotten);
        }
        E replace;
        if (tree.getLeft().isEmpty()) {
            replace = getSuccessorValue();
        } else {
            replace = getPredecessorValue();
        }
        tree.remove(replace);
        tree.setValue(replace);
    }

    private E getSuccessorValue() {
        BinaryTree<E> result = tree.getRight();
        while (!result.getLeft().isEmpty()) {
            result = result.getLeft();
        }
        return result.getValue();
    }

    private E getPredecessorValue() {
        BinaryTree<E> result = tree.getLeft();
        while (!result.getRight().isEmpty()) {
            result = result.getRight();
        }
        return result.getValue();
    }

    public boolean has2More() {
        return false;
    }


}
