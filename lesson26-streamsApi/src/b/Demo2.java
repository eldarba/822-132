package b;

import java.util.LinkedHashSet;
import java.util.Set;

public class Demo2 {

	public static void main(String[] args) {

		Set<Integer> ages = new LinkedHashSet<Integer>();
		ages.add(25);
		ages.add(32);
		ages.add(12);
		ages.add(85);
		ages.add(5);

		ages.stream().filter(e -> e >= 18).forEach(e -> System.out.println(e));

	}

}
