package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Address;
import app.core.entities.Company;

@SpringBootApplication
public class App05 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App05.class, args);

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		try {
			Company company = em.find(Company.class, 1);
			if (company != null) {
				Address address = company.getAddress();
				System.out.println(company);
				System.out.println(address);

				company.setAddress(null); // set the address to null

				// now we can delete the address

				em.remove(address);
				System.out.println("deleted");
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
