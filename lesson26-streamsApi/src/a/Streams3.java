package a;

import java.util.ArrayList;
import java.util.List;

public class Streams3 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(8);

		list

				.stream() // get a stream

				.map(e -> e * 2) // intermediate operation

				.forEach(currNum -> System.out.println(currNum)); // terminal operation

		System.out.println(list);

	}

}
