package a;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Streams1 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(8);

		Stream<Integer> stream = list.stream();

		list.forEach(currNum -> System.out.println(currNum));

	}

}
