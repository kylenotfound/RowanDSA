package sort;

import list.*;

/**
 * Sort a given list using heapsort algorithm
 * @author Kyle Evangelisto
 */
public class HeapSort <E extends Comparable> implements Sorter{

    List<E> list;

    /**
     * Long lists are good for a heap sort, for a shorter list, use a quick sort or selection sort.
     * Heap Sort worst case:
     * O(n(log(n)) + n(log(n))) ==> O(2nlog(n)) ==> O(n(log(n)))
     * @param list
     */
    @Override
    public void sort(List list) {
        this.list = list;

        int last = list.size() - 1;
        heapify(0);
        while(last > 0) {
            swap(0, last);
            last--;
            percDown(0, last);
        }
    }

    /**
     * O(1) constant time
     * @param x
     * @param y
     */
    private void swap(int x, int y) {
        E temp = list.get(x);
        list.set(x,  list.get(y));
        list.set(y,  temp);
    }

    /**
     *
     * O(n(log(n)))
     * Make the part of the list beginning at root into a heap
     * @param root
     */
    public void heapify (int root) {
        int max = list.size() - 1;
        if (root >= max) {
            return; //base case
        }
        heapify(root * 2 + 1); //left child
        heapify(root * 2 + 2); //right child
        percDown(root, max); //perc down root
    }

    /**
     * O(log(n))
     *
     * Move the root down, so as to make this part of the list into a heap.
     * do not go beyond the max
     */
    private void percDown (int root, int max) {
        int bc = biggerChild(root, max);    //has a child ? and a bigger child
        while (((2 * root + 1) <= max) && greater(bc, root)) {
            swap(root, bc);
            root = bc;
            bc = biggerChild(root, max);
        }
    }

    /**
     * O(1) //constant time
     * @param root
     * @param max
     * @return the position of the bigger child of given root position.
     * Pre: root has left child.
     */
    private int biggerChild (int root, int max) {
        //int bc = biggerChild(root, max);
        int left = 2 * root + 1, right = 2 * root + 2;
        if (right > max) {
            return left;
        }
        if (greater(left, right)) {
            return left;
        }
        return right;
    }

    /**
     * @return true iff the value at position p1 is greater than the value at p2.
     * O(1) //constant time
     */
    private boolean greater(int p1, int p2) {
        return list.get(p1).compareTo(list.get(p2)) > 0;
    }

}
