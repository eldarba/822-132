package app.core;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Person;

public class App2 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(Config.class);

		Person p1 = ctx.getBean("thePerson", Person.class);
		Person p2 = ctx.getBean("thePerson", Person.class);
		Person p3 = ctx.getBean("manager", Person.class);
		p1.setName("Dan");
		p2.setName("Ruth");

		System.out.println(p1.getBeanName());
		System.out.println(p1.getName());
		System.out.println(p2.getBeanName());
		System.out.println(p2.getName());
		System.out.println(p3.getBeanName());
		System.out.println(p3.getName());

		System.out.println("======= All beans in the container:");
		Map<String, Person> map = ctx.getBeansOfType(Person.class);
		for (String key : map.keySet()) {
			System.out.println(key + " - " + map.get(key));
		}

		ctx.close();

	}

}
