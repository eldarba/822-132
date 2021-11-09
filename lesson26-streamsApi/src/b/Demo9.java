package b;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo9 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(3, 5, 2, 7, 9, 4, 1, 5, 8, 9, 1);

		List<Integer> evens = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());

		System.out.println(list);
		System.out.println(evens);
	}

}
