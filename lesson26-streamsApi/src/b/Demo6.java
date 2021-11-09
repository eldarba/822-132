package b;

import java.util.Arrays;
import java.util.List;

public class Demo6 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(3, 5, 7, 9, 1, 5, 9, 1);
		System.out.println(list);

		boolean anyEven = list.stream().anyMatch(e -> e % 2 == 0);
		System.out.println("any even numbers? " + anyEven);

	}

}
