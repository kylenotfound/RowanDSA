package hashDriver;

import hash.*;

public class Test {

    public static void main(String ... args) {
        HashTable<Integer> table = new HashTable<>(5);
        table.put(3);
        table.put(-3);
        table.put(20);
        table.put(8);
        table.put(0);
        table.put(30);

        System.out.println(new Integer(3).hashCode());
        System.out.println(new Integer(-3).hashCode());
        System.out.println(new Integer(20).hashCode());
        System.out.println(new Integer(8).hashCode());
        System.out.println(new Integer(0).hashCode());
        System.out.println(new Integer(30).hashCode());
    }

}
