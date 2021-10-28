package b;

public class Test {

	public static void main(String[] args) {

		Flyer flyer = () -> {
			System.out.println("Lambda Flyer");
		};

		flyer.fly();

	}

}
