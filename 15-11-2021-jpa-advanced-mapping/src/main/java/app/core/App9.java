package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Student;
import app.core.entities.University;

@SpringBootApplication
public class App9 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App9.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			// ========================
			University barIlan = new University(0, "Bar Ilan", "Israel");
			University benGurion = new University(0, "Ben Gurion", "Israel");
			em.persist(barIlan);
			em.persist(benGurion);

			Student st1 = new Student(0, "aaa", barIlan);
			Student st2 = new Student(0, "bbb", barIlan);
			Student st3 = new Student(0, "ccc", barIlan);

			Student st4 = new Student(0, "ddd", benGurion);
			Student st5 = new Student(0, "eee", benGurion);

			em.persist(st1);
			em.persist(st2);
			em.persist(st3);
			em.persist(st4);
			em.persist(st5);

			// ========================
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

}
