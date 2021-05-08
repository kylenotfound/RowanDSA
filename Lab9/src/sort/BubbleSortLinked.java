//BubbleSortLinked Class
package sort;
import list.*;

public class BubbleSortLinked <E extends Comparable> implements Sorter<E> {
	
	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		ListIterator<E> iterator;
		E left, right;
		for(int i = 0; i < list.size() - 1; i++) {
			iterator = list.listIterator();
			right = iterator.next();
			for(int j = 0; j < list.size() - i - 1; j++) {
				left = right;
				right = iterator.next();
				if(left.compareTo(right) > 0) {
					iterator.remove();
					iterator.previous();
					iterator.add(right);
					right = iterator.next();
				}
			}
		}
	}
}