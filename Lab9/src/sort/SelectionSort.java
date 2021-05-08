package sort;

import list.*;

public class SelectionSort <E extends Comparable> implements Sorter<E> {

    List<E> list;

    /**
     * Items in the list
     * @param list
     */
    @Override
    public void sort(List<E> list) {
        this.list = list;
        for (int i =  0; i < list.size() - 1; i++) {
            swap(posSmallest(i), i);
        }
    }

    /**
     *
     * @param start int starting value
     * @return the position of the smallest item from the given position
     * to the end of the list
     */
    private int posSmallest (int start) {
        int result = start;
        for (int i = start + 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(result)) < 0) {
                result = i;
            }
        }
        return result;
    }

    /**
     *  Exchange items at the given positions in the list
     * @param x swap value
     * @param y swap value
     */
    private void swap (int x, int y) {
        E temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }


}
