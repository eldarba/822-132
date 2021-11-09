package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.services.PersonService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		PersonService personService = ctx.getBean(PersonService.class);

//		{ // create
//			personService.add(new Person(0, "aaa", 22));
//			personService.add(new Person(0, "bbb", 33));
//			personService.add(new Person(0, "ccc", 44));
//		}

//		{
//			List<Person> list = personService.readAll();
//			System.out.println("================");
//			for (Person person : list) {
//				System.out.println(person);
//			}
//			System.out.println("================");
//		}

//		{
//			try {
//				personService.update(new Person(2, "Ronen", 80));
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}

		{
			try {
				personService.delete(1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
