package app.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import app.core.beans.Order;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class App1 {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App1.class)) {
			System.out.println("start - containet is up");

			Order order = ctx.getBean("order2", Order.class);
			System.out.println(order);
		}
		System.out.println("stop - container is closed");
	}

	@Bean
	public Order order1() {
		Order order = new Order("order 1 - tel aviv");
		return order;
	}

	@Bean
	public Order order2(@Qualifier("storeAddressB") String address) {
		Order order = new Order(address);
		return order;
	}

	@Bean
	public String storeAddressA() {
		return "1 Sderot Ben Gurion st. Jerusalem";
	}

	@Bean
	public String storeAddressB() {
		return "23 Menachem Begin st. Haifa";
	}

}
