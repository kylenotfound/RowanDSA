package sort;

import list.List;

public class QuickSort <E extends Comparable> implements Sorter{

    //1 3 5 4 2 0
    //Average case: O(nlog(n)) Worst Case: O(n^2)
    List<E> list;

    @Override
    public void sort(List list) {
        this.list = list;
        qSort(0, list.size() - 1);
    }

    private void qSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition (start, end);
        qSort(start, p - 1);
        qSort(p + 1, end);
    }

    private int partition(int start, int end) {
        int p = start + (end - start ) / 2; // middle elem INDEX
        E head = list.get(start); // actual start elem
        E pivot = list.get(p); // actual middle elem
        //System.out.println(pivot);
        list.set(start, pivot); //swap
        list.set(p, head);

        p = start; //we need to make the pivot the start elem

        //System.out.println(list);
        for(int i = start + 1; i <= end; i++)
            if(list.get(i).compareTo(pivot) < 0) {
                list.set(p, list.get(i));
                p++;
                list.set(i, list.get(p));
            }
        list.set(p, pivot);
        return p;
    }


}
