package b;

import java.util.LinkedHashSet;
import java.util.Set;

public class Demo3 {

	public static void main(String[] args) {

		Set<String> names = new LinkedHashSet<>();
		names.add("Ben");
		names.add("Avi");
		names.add("Ran");
		names.add("Asaf");

		names.stream().filter(name -> name.charAt(0) == 'A').forEach(name -> System.out.println(name));

		long startWithA = names.stream().filter(name -> name.charAt(0) == 'A').count();
		System.out.println(startWithA);

	}

}
