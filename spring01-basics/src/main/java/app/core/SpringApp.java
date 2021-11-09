package app.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {

		// this is spring container
		// it gets a configuration class to know what beans to create
		// we use it to get beans
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get a reference to the bean we defined in: applicationContext.xml
		Person p = ctx.getBean(Person.class);

		System.out.println(p);

		ctx.close();

	}

}
