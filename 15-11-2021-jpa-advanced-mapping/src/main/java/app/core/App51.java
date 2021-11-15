package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.services.AdminService;

@SpringBootApplication
public class App51 {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(App51.class, args);

		AdminService adminService = ctx.getBean(AdminService.class);
		Company company = adminService.getCompanyById(2);
		System.out.println(company);
		System.out.println(company.getAddress());

		Coupon coupon = adminService.getCoupon(1);
		System.out.println(coupon);
		System.out.println(adminService.getCouponReviews(1));

	}

}
