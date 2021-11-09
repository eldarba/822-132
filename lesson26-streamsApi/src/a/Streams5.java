package a;

import java.util.ArrayList;
import java.util.List;

public class Streams5 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Dan");
		list.add("Rina");
		list.add("Eyal");

		list.stream().map(e -> e.toUpperCase()).forEach(e -> System.out.println(e));

	}

}
