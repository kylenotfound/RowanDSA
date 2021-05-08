package sort;

import list.*;

public interface Sorter <E extends Comparable>{
    /**
     * Post: the given list will be arranged in ascending order
     * @param list
     */
    void sort(List<E> list);
}
