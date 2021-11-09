package a;

import java.util.ArrayList;
import java.util.List;

public class Streams7 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("25");
		list.add("-3");
		list.add("150");

		list.stream().map(e -> Integer.parseInt(e)).map(e -> Math.abs(e)).forEach(e -> System.out.println(e));

		System.out.println(list);

	}

}
