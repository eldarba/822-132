package app.core.test;

import app.core.Car;
import app.core.Country;
import app.core.FamilyCar;
import app.core.Highway;
import app.core.SportsCar;

public class App2 {

	private static int nextCarNumber = 101;
	private static int nextHighwayNumber = 1;

	public static void main(String[] args) {

		// create a country
		Country country = new Country();
		// add highways
		country.addHighway(getRandomHighway());
		country.addHighway(getRandomHighway());
		country.addHighway(getRandomHighway());

		// define needed variables
		double speedSumAllCarsInCountry = 0;
		int numOfAllCarsInTheCountry = 0;
		int maxSpeed = Car.MIN_SPEED;
		Highway busiestHighway = country.getHighways()[0];
		Highway fastestHighway = country.getHighways()[0];

		// iterate over the highways in the country
		for (Highway highway : country.getHighways()) {
			if (highway != null) {
				// print the number of cars on each highway (using toString method)
				System.out.print("Highway=" + highway.getName());
				System.out.print(", numberOfCars=" + highway.getNumberOfCars());
				System.out.println(", averageSpeed=" + highway.getAvgSpeed());
				// looking for the busiest highway
				if (highway.getNumberOfCars() > busiestHighway.getNumberOfCars()) {
					busiestHighway = highway;
				}
				// looking for the fastest highway
				if (highway.getAvgSpeed() > busiestHighway.getAvgSpeed()) {
					fastestHighway = highway;
				}
				// calculating average speed of all cars in the country
				// iterate over the cars on each highway in the country
				for (Car car : highway.getCars()) {
					if (car != null) {
						speedSumAllCarsInCountry += car.getSpeed();
						numOfAllCarsInTheCountry++;
						// looking for the speed of the fastest car in the country
						if (car.getSpeed() > maxSpeed) {
							maxSpeed = car.getSpeed();
						}
					}
				}

			}
		}

		System.out.println("=====================");

		// calculate the average speed of all cars in the country
		double avgApeedAllCarsInCountry = speedSumAllCarsInCountry / numOfAllCarsInTheCountry;

		// number of cars in country
		System.out.println("total number of cars in the country: " + country.getNumberOfCars());

		// average speed of all cars in the country
		System.out.println("average speed of all cars in country: " + avgApeedAllCarsInCountry);

		// max speed of all cars in the country
		System.out.println("speed of fastest car in the country: " + maxSpeed);

		// most busy highway in the country
		System.out.print("busiestHighway=" + busiestHighway.getName());
		System.out.println(", numberOfCars=" + busiestHighway.getNumberOfCars());

		// fastest highway in the country
		System.out.print("fastestHighway=" + fastestHighway.getName());
		System.out.println(", avgSpeed=" + fastestHighway.getAvgSpeed());

	}

	// method for getting a random highway
	private static Highway getRandomHighway() {
		String name = "H" + nextHighwayNumber++;
		Highway highway = new Highway(name);
		int numberOfCars = (int) (Math.random() * 50) + 5;
		for (int i = 0; i < numberOfCars; i++) {
			highway.addCar(getRandomCar());
		}
		return highway;
	}

	// method for getting a random car
	private static Car getRandomCar() {
		Car car;
		int number = nextCarNumber++;
		int speed = (int) (Math.random() * (Car.MAX_SPEED - Car.MIN_SPEED + 1)) + Car.MIN_SPEED;
		if (Math.random() < 0.5) {
			car = new FamilyCar(number, speed);
		} else {
			car = new SportsCar(number, speed);
		}
		return car;
	}

}
