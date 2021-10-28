package proxy;

public class FamilyCar implements Car {

	@Override
	public void drive() {
		System.out.println("car is driving");
	}

	@Override
	public void stop() {
		System.out.println("car stopped");
	}

}
