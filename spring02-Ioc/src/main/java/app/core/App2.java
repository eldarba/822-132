package app.core;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import app.core.beans.Order;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class App2 {

	public static void main(String[] args) {

		// Auto Resource Management
		// ARM - will close the ctx for us when the try block is finished
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class)) {
			System.out.println("start - containet is up");

			int beanCount = ctx.getBeanDefinitionCount();
			System.out.println("number of beans: " + beanCount);

			System.out.println("================");

			String[] beanNames = ctx.getBeanDefinitionNames();
			for (String name : beanNames) {
				System.out.println(name);
			}

			System.out.println(" @Component ================");

			beanNames = ctx.getBeanNamesForAnnotation(Component.class);
			for (String name : beanNames) {
				System.out.println(name);
			}
			System.out.println("@Bean ================");

			beanNames = ctx.getBeanNamesForAnnotation(Bean.class);
			for (String name : beanNames) {
				System.out.println(name);
			}
			System.out.println("of type Order ================");

			beanNames = ctx.getBeanNamesForType(Order.class);
			for (String name : beanNames) {
				System.out.println(name);
			}
			System.out.println("of type String ================");

			beanNames = ctx.getBeanNamesForType(String.class);
			for (String name : beanNames) {
				System.out.println(name);
			}

			System.out.println("======================");

			BeanDefinition beanDefinition = ctx.getBeanDefinition("order2");
			System.out.println(beanDefinition);

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		System.out.println("stop - container is closed");
	}

}
