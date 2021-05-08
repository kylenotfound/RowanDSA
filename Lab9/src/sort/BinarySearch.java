package sort;

import list.*;

/**
 * Binary Search Algorithm of a sorted List.
 * For fast performance the list should be an ArrayList
 * @param <E>
 */

// O(log(n))

public class BinarySearch <E extends Comparable>{

    private List<E> list;

    public BinarySearch(List<E> list) {
        this.list = list;
    }

    /**
     *
     * @return the pos of a target or -1 if not found
     */
    public int search (E target) {
        return binSearch(0, list.size() - 1, target);
    }

    /**
     *
     * @return the position of the target start through end or -1 if not found
     */
    private int binSearch (int start, int end, E target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        //System.out.print(mid + ", ");
        int cmp = target.compareTo(list.get(mid));
        if (cmp == 0) {
            return mid;
        }
        if (cmp < 0) {
            return binSearch(start, mid - 1, target);
        }
        return binSearch(mid + 1, end, target);

    }

}
