package b;

import java.util.Arrays;
import java.util.List;

public class Demo8 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(3, 5, 7, 9, 1, 5, 9, 1);
		System.out.println(list);
		List<Integer> list2 = Arrays.asList(2, 4, 6, 5, 7);
		System.out.println(list2);

		boolean nonEven = list.stream().noneMatch(e -> e % 2 == 0);
		System.out.println("no even numbers? " + nonEven);

		nonEven = list2.stream().allMatch(e -> e % 2 == 0);
		System.out.println("no even numbers? " + nonEven);

	}

}
