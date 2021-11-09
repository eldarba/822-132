package c;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(5);
		list.add(3);
		list.add(1);
		list.add(4);

		System.out.println(list);

		list.sort(null);
		System.out.println(list);

		// old style
		// here we give the sort method a comparator object implemented in another class
		OpositeIntegerComparator op = new OpositeIntegerComparator();
		list.sort(op);
		System.out.println(list);

		// new style
		// here we give the sort method a comparator instance as lambda
		list.sort((a, b) -> b.compareTo(a));
		System.out.println(list);

	}

}
