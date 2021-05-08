package temp;
import set.*;
import queue.*;
public class Test {

    public static void main(String ... args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(5);
        pq.add(7);
        pq.add(3);
        pq.add(5);
        System.out.println(pq);

    }

}
