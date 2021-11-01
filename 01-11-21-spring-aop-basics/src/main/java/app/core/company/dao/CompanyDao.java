package app.core.company.dao;

import org.springframework.stereotype.Component;

@Component
public class CompanyDao {

	public void addCompany(Company company) throws RuntimeException {
		System.out.println("company added");
	}

	public void sayHello() {
		System.out.println("Hello from CompanyDao");
	}

}
