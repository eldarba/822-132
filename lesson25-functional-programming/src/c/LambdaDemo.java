package c;

public class LambdaDemo {

	public static void main(String[] args) {

		Greeter greeter = () -> {
			System.out.println("Hello");
		};
		greeter.greet();

		//////////////////////////////////////////////////////////

		AddCalculator adder1 = (a, b) -> {
			int sum = a + b;
			return sum;
		};

		System.out.println(adder1.add(5, 9));

		//////////////////////////////////////////////////////////
		// for return statement only the return keyword is omitted and no {} is needed
		AddCalculator adder2 = (a, b) -> a + b;
		System.out.println(adder2.add(500, 9));

		//////////////////////////////////////////////////////////
		// for 1 parameter no () is needed
		Multiplyer multiplyer = x -> x * 2;
		System.out.println(multiplyer.multiplyBy2(25));

	}

}

// let's add functional interfaces here

@FunctionalInterface
interface Multiplyer {
	int multiplyBy2(int val);
}

@FunctionalInterface
interface AddCalculator {
	int add(int a, int b);
}

@FunctionalInterface
interface Greeter {
	void greet();
}
