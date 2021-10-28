package b;

import java.util.ArrayList;
import java.util.List;

public class Demo5 {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("Ben");
		names.add("Avi");
		names.add("Avi");
		names.add("Avi");
		names.add("Ben");
		names.add("Ran");
		names.add("Asaf");
		names.add("Ben");

		long x = names

				.stream()

				.peek(e -> System.out.println(e))

				.filter(e -> e.charAt(0) == 'A')

				.peek(e -> System.out.println("*** " + e))

				.count();

		System.out.println("==============");
		System.out.println("total:");

		System.out.println(x);

	}

}
