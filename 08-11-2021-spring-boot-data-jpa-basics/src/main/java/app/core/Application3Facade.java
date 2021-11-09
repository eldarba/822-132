package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Person;
import app.core.services.PersonFacade;

@SpringBootApplication
public class Application3Facade {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application3Facade.class, args);

		PersonFacade personFacade = ctx.getBean(PersonFacade.class);

		{ // add persons to the database using the Dao
			personFacade.add(new Person(0, "Yuval", 22));
			personFacade.add(new Person(0, "Ronit", 22));
		}

	}

}
