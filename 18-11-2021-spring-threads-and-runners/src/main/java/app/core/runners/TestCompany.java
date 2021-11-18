package app.core.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class TestCompany implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Company Test ==================");

		try {
			// test steps is defined in separate methods
			doLogin();
			doAddCoupon();
			doDeleteCoupon();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void doLogin() {
		System.out.println("doing login");

	}

	private void doAddCoupon() {
		System.out.println("coupon added");
	}

	private void doDeleteCoupon() {
		System.out.println("coupon deleted");
	}

}
