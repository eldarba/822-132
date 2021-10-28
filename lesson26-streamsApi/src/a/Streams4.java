package a;

import java.util.ArrayList;
import java.util.List;

public class Streams4 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Dan Levi");
		list.add("Rina Yehooda");
		list.add("Eyal Rotem");

		list

				.stream() // get a stream

				.map(e -> e.toUpperCase()) // intermediate operation

				.map(e -> e.substring(0, 3)) // intermediate operation

				.forEach(e -> System.out.println(e)); // terminal operation

		System.out.println(list);

	}

}
