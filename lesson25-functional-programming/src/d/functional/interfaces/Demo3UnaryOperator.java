package d.functional.interfaces;

import java.util.function.UnaryOperator;

public class Demo3UnaryOperator {

	public static void main(String[] args) {

		UnaryOperator<Integer> times2 = num -> num * 2;
		UnaryOperator<Integer> abs = num -> Math.abs(num);

		int a = 5;
		int b = times2.apply(a);
		System.out.println(b);

		a = -9;
		b = abs.apply(a);
		System.out.println(b);

	}

}
