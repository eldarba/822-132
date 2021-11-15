package app.core;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.entities.Review;

@SpringBootApplication
public class App7 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App7.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			// ========================
			Coupon coupon = em.find(Coupon.class, 1);

			if (coupon != null) {
				System.out.println(coupon);
				List<Review> reviews = coupon.getReviews();
				System.out.println(reviews);
			}

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
