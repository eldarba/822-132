package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.entities.Customer;

@SpringBootApplication
public class App12 {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(App12.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			// ========================

			Customer customer1 = new Customer(0, "aaa", "aaa@mail");
			Customer customer2 = new Customer(0, "bbb", "bbb@mail");

			Coupon coupon1 = new Coupon(0, "aaa");
			Coupon coupon2 = new Coupon(0, "bbb");
			Coupon coupon3 = new Coupon(0, "ccc");
			Coupon coupon4 = new Coupon(0, "ddd");
			Coupon coupon5 = new Coupon(0, "eee");

			em.persist(customer1);
			em.persist(customer2);

			em.persist(coupon1);
			em.persist(coupon2);
			em.persist(coupon3);
			em.persist(coupon4);
			em.persist(coupon5);

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
