package d.functional.interfaces;

import java.util.function.BinaryOperator;

public class Demo4BinaryOperator {

	public static void main(String[] args) {

		BinaryOperator<String> con = (s1, s2) -> s1.concat(" ").concat(s2);

		String first = "Moshe";
		String last = "Levi";
		String full = con.apply(first, last);
		System.out.println(full);

	}

}
