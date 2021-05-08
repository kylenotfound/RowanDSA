import list.ArrayList;
import list.Iterator;

public class test {

    public static void main (String ... args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        System.out.println(list);
        Iterator<Integer> iterator = list.listIterator();
        iterator.remove2();
        System.out.println(list);
    }

}
