package a;

import java.util.ArrayList;
import java.util.List;

public class Streams6 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("25");
		list.add("-3");
		list.add("150");

		list

				.stream() // get a stream of String

				.map(e -> Integer.parseInt(e)) // map to int and return stream of Integer

				.map(e -> Math.abs(e)) // map to absolute and return stream of Integer

				.forEach(e -> System.out.println(e)); // print each processed element

		System.out.println(list);

	}

}
