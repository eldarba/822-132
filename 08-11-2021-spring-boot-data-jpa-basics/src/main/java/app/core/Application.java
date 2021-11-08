package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Person;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		// we get the persistence context factory from the spring context
		EntityManagerFactory emFactory = ctx.getBean(EntityManagerFactory.class);
		// the EntityManager manages entities during a session transaction
		EntityManager em = emFactory.createEntityManager();

		try {
			em.getTransaction().begin(); // start transaction
			Person p1 = new Person(0, "Dan", 25);
			Person p2 = new Person(0, "Ran", 33);
			Person p3 = new Person(0, "Rina", 25);
			em.persist(p1); // save the person to the database
			em.persist(p2); // save the person to the database
			if (Math.random() < 0.8) {
				throw new RuntimeException("testing the transaction");
			}
			em.persist(p3); // save the person to the database
			em.getTransaction().commit(); // end the transaction with commit
		} catch (Exception e) {
			em.getTransaction().rollback(); // end the transaction with rollback
			e.printStackTrace();
		}

	}

}
