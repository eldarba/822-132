package b;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {

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

		names.stream().forEach(name -> System.out.println(name));
		System.out.println("============");
		names.stream().distinct().forEach(name -> System.out.println(name));

		System.out.println("============");
		names.stream().distinct().map(e -> e.toUpperCase()).forEach(name -> System.out.println(name));

	}

}
