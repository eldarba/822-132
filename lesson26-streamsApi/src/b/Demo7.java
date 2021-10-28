package b;

import java.util.Arrays;
import java.util.List;

public class Demo7 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(3, 5, 7, 9, 1, 5, 9, 1);
		System.out.println(list);
		List<Integer> list2 = Arrays.asList(2, 4, 6);
		System.out.println(list2);

		boolean allEven = list.stream().allMatch(e -> e % 2 == 0);
		System.out.println("all even numbers? " + allEven);

		allEven = list2.stream().allMatch(e -> e % 2 == 0);
		System.out.println("all even numbers? " + allEven);

	}

}
