package proxy;

public class CarProxy implements Car {

	private FamilyCar car = new FamilyCar();

	@Override
	public void drive() {
		System.out.println("check air bag");
		car.drive();

	}

	@Override
	public void stop() {
		car.stop();

	}

}
