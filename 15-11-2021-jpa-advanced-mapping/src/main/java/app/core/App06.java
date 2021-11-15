package app.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.entities.Review;

@SpringBootApplication
public class App06 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App06.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			// ========================
			Coupon coupon = new Coupon(0, "FOOD");

			List<Review> reviews = new ArrayList<>();
			reviews.add(new Review(0, "Very Good"));
			reviews.add(new Review(0, "Great"));
			reviews.add(new Review(0, "So so"));

			coupon.setReviews(reviews);

			em.persist(coupon);

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
