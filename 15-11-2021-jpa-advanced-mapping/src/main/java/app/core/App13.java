package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.entities.Customer;

@SpringBootApplication
public class App13 {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(App13.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			// ========================

			Customer customer = em.find(Customer.class, 2);
			customer.purchaseCoupon(em.find(Coupon.class, 1));
			customer.purchaseCoupon(em.find(Coupon.class, 2));

			System.out.println("done");

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
