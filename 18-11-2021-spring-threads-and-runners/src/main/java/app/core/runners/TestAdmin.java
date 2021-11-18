package app.core.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class TestAdmin implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Admin Test ==================");

		try {
			// test steps is defined in separate methods
			doLogin();
			doAddCompany();
			doDeleteCompany();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void doLogin() {
		System.out.println("doing login");

	}

	private void doAddCompany() {
		System.out.println("company added");
	}

	private void doDeleteCompany() {
		System.out.println("company deleted");
	}

}
