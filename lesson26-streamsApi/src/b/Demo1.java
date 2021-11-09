package b;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Demo1 {

	public static void main(String[] args) {

		Consumer<Integer> stringConsumer1 = e -> System.out.println(e); // lambda
		Consumer<Integer> stringConsumer2 = System.out::println; // lambda - method reference

		Set<Integer> ages = new HashSet<Integer>();
		ages.add(25);
		ages.add(32);
		ages.add(12);
		ages.add(85);
		ages.add(5);

		ages

				.stream() // get a stream
				// call a terminal operation - forEach
				// forEach accepts a Consumer
				// lambda expression can be a method reference
				// here we refer to an existing method in some object
				// .forEach(System.out::println);
//				.forEach(stringConsumer2);
				.forEach(e -> System.out.println(e));

	}

}
