package d.functional.interfaces;

import java.util.function.Function;

public class Demo1Function {

	public static void main(String[] args) {

		Function<String, Double> oldImp = new Function<String, Double>() {

			@Override
			public Double apply(String str) {
				return Double.parseDouble(str);
			}
		};

		Function<String, Double> implementor = str -> Double.parseDouble(str);

//		String priceAsString = JOptionPane.showInputDialog("enter price");
//		double priceAsDouble = implementor.apply(priceAsString);
//		System.out.println(priceAsDouble);
//		System.out.println(priceAsDouble * 1.18);

		// create another Function object that gets a String and return a shorter String
		// (3 characters)
		Function<String, String> shortener = str -> str.substring(0, 3);
		System.out.println(shortener.apply("aaaaaaaaaaaaa"));
		System.out.println(shortener.apply("ahgdte"));
		System.out.println(shortener.apply("Hello"));

		// create another Function object that gets a String and return its length
		Function<String, Integer> getStringLength = str -> str.length();
		System.out.println(getStringLength.apply("a"));
		System.out.println(getStringLength.apply("aaa"));
		System.out.println(getStringLength.apply("Hello world"));

	}

}
