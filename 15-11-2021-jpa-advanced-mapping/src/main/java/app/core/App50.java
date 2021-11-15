package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Address;
import app.core.entities.Company;
import app.core.services.AdminService;

@SpringBootApplication
public class App50 {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(App50.class, args);

		AdminService adminService = ctx.getBean(AdminService.class);
		Company company = new Company(0, "Tadiran", "tadiran@mail");
		company.setAddress(new Address(0, "aaa", 33, "bbb", "ccc"));
		int id = adminService.addCompany(company);
		System.out.println("company added: " + id);

	}

}
