package b;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo10 {

	public static void main(String[] args) {

		{

			List<Integer> list = Arrays.asList(3, 5, 7, 9, 11, 1, 5, 9, 1);

			Optional<Integer> opt = list.stream().max((e1, e2) -> e1.compareTo(e2));
			if (opt.isPresent()) {
				System.out.println("maximum is: " + opt.get());
			} else {
				System.out.println("no max");
			}

			opt = list.stream().filter(e -> e % 2 == 0).max((e1, e2) -> e1.compareTo(e2));
			if (opt.isPresent()) {
				System.out.println("maximum is: " + opt.get());
			} else {
				System.out.println("no max");
			}
		}

//		{
//			Optional<String> opt = Optional.of("AAA");
//			Optional<String> optEmpty = Optional.empty();
//
//			System.out.println(opt.isPresent());
//			System.out.println(optEmpty.isPresent());
//
//		}

	}

}
