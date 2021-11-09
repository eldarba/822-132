package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {

	public static void main(String[] args) {
		// create a spring container
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		// ask the container for a bean of type Person
		Person person = ctx.getBean("person", Person.class);
		Person person2 = ctx.getBean("person", Person.class);
		Person otherPerson = ctx.getBean("otherPerson", Person.class);
		Person otherPerson2 = ctx.getBean("otherPerson", Person.class);
		System.out.println(person.hashCode());
		System.out.println(person2.hashCode());
		System.out.println(otherPerson.hashCode());
		System.out.println(otherPerson2.hashCode());
		System.out.println(otherPerson2.getName());

		ctx.close();

	}

}
