package proxy;

public class Test {

	public static void main(String[] args) {
		Car car = new CarProxy();
		car.drive();
		car.stop();

	}

}
