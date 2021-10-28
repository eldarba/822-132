package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import app.core.beans.Car;
import app.core.beans.Person;

@ComponentScan
@Configuration
public class SpringApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApp.class);

		Person p1 = ctx.getBean(Person.class);
		p1.setName("Avi");
		Person p2 = ctx.getBean(Person.class);
		p2.setName("Danna");
		System.out.println(p1);
		System.out.println(p2);

		Car c1 = ctx.getBean("car", Car.class);
		Car c2 = ctx.getBean("car", Car.class);
		c1.setNumber(111);
		c2.setNumber(222);

		System.out.println(c1);
		System.out.println(c2);

		System.out.println("======== fast cars");
		Car c3 = ctx.getBean("fastCar", Car.class);
		Car c4 = ctx.getBean("fastCar", Car.class);
		c3.setSpeed(50);
		c4.setSpeed(80);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c3);

		ctx.close();

	}

	@Bean
	@Scope("prototype")
	public Car fastCar() {
		Car car = new Car();
		car.setSpeed(160);
		return car;
	}

}
