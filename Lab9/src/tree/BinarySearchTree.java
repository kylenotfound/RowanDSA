package tree;

import list.*;

/**
 * A BinaryTree whose left child's value is smaller, and
 * whose right value is greater than the value of this BinarySearchTree
 * @param <E>
 */
public class BinarySearchTree <E extends Comparable> implements BinaryTree<E> {

    //Average case is O(log(n)) on a best case
    //Worst case is O(n) sequential search, like a linked list

    BinaryTree<E> left = new EmptyBinarySearchTree<E>(),
            right = new EmptyBinarySearchTree<E>();
    E value;
    int size = 1;

    static boolean removed = false;
    static boolean added = false;

    public BinarySearchTree (E value) {
        this.value = value;
    }

    /**
     * Set the left child to the given binary tree to the given binary tree
     */
    public void setLeft(BinaryTree<E> left) {
        this.left = left;
        size = left.size() + right.size() + 1;
    }

    /**
     * Set the right child to the given binary tree to the given binary tree
     */
    public void setRight(BinaryTree<E> right) {
        this.right = right;
        size = left.size() + right.size() + 1;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public E get(E value) {
        int cmp = this.value.compareTo(value);
        if (cmp == 0) {
            return value;
        }
        if (cmp < 0) {
            return right.get(value);
        }
        return left.get(value);
    }

    public BinaryTree<E> add(E value) {
        added = false;
        return addHelper(value);
    }

    private BinaryTree<E> addHelper (E value) {
        int cmp = this.value.compareTo(value);
        if (cmp < 0) {
            right = right.add(value);
        }
        if (cmp > 0) {
            left = left.add(value);
        }
        if (added) {
            size++;
        }
        return this;
    }

    public boolean containsKey(Object obj) {
        int cmp = value.compareTo(obj);
        if (cmp == 0) {
            return true;
        }
        if (cmp < 0) {
            return right.containsKey(obj);
        }
        return left.containsKey(obj);
    }

    public BinaryTree<E> remove(Object obj) {
        removed = false;
        return removeHelper(obj);
    }

    private BinaryTree<E> removeHelper(Object obj) {
        int cmp = value.compareTo(obj);
        if (cmp == 0) {
            removed = true;
            List<BinaryTree<E>> kids = children();
            if (kids.size() == 0) {
                return new EmptyBinarySearchTree<>(); //no children
            }
            if (kids.size() == 1) {
                return kids.get(0); //one child
            }
            //Two Children
            BinaryTree<E> successor = getSuccessor();
            removeHelper(successor.getValue());
            setValue(successor.getValue());
            return this;
        }

        if (cmp > 0) {
            left = left.remove(obj);
        }

        if (cmp < 0) {
            right = right.remove(obj);
        }

        if (removed) {
            size--;
        }

        return this;
    }

    private List<BinaryTree<E>> children() {
        List<BinaryTree<E>> result = new ArrayList<>();
        if (!left.isEmpty()) {
            result.add(left);
        }
        if (!right.isEmpty()) {
            result.add(right);
        }
        return result;
    }

    /**
     *
     * @return the successor of this BinaryTree
     * successor is the smallest value in the family of the child
     */
    private BinaryTree<E> getSuccessor() {
        BinaryTree<E> temp = right;
        while (!temp.getLeft().isEmpty()) {
            temp = temp.getLeft();
        }
        return temp;
    }

    public Iterator<E> iterator(){
        return new TreeIterator<E>(this);
    }

    public String toString() {
        StringBuilder treeString = new StringBuilder("[");
        Iterator<E> it = iterator();
        while(it.hasNext()) {
            treeString.append(it.next()).append(" ");
        }
        return treeString + "]";
    }
}
