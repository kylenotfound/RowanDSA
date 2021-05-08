package sortDriver;

import list.ArrayList;
import list.List;
import sort.BinarySearch;
import sort.QuickSort;

public class TestBinSearch {

    public static void main (String ... args) {
        List<Integer> list = new ArrayList<>();

        BinarySearch<Integer> searcher = new BinarySearch<>(list);

        list.add(-3);
        list.add(-3);
        list.add(0);
        list.add(5);
        list.add(12);
        list.add(23);
        list.add(36);
        list.add(99);

        System.out.println("target is 5. Mid is: " + searcher.search(5));
        System.out.println("target is -3. Mid is: " +  searcher.search(-3));
        System.out.println("target is 15. Mid is: " + searcher.search(15));
        System.out.println("target is 99. Mid is: " + searcher.search(99));
        System.out.println("target is 200. Mid is: " +  searcher.search(200));


        /**
        List<Integer> list1 = new ArrayList<>();

        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(4);
        list1.add(2);
        list1.add(0);
        System.out.println("before"  + list1);

        QuickSort quickSort = new QuickSort();
        quickSort.sort(list1);
        System.out.println("after" + list1);*/

    }

}
