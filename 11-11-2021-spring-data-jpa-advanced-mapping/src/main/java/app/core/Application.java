package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.repositories.CompanyRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		CompanyRepository companyRepository = ctx.getBean(CompanyRepository.class);

//		{// create
//
//			// 1. create a company with address
//			Company company = new Company(0, "Apple", "apple@mail", new Address(0, "Jerusalem", "Israel"));
//
//			// 2. save the company (the address will be saved - cascade save)
//			companyRepository.save(company);
//		}

//		{ // get
//			Optional<Company> opt = companyRepository.findById(1);
//			if (opt.isPresent()) {
//				Company company = opt.get();
//				System.out.println(company);
//				System.out.println(company.getAddress());
//			} else {
//				System.out.println("company not found");
//			}
//		}

		{ // remove
			companyRepository.deleteById(1);
		}

	}

}
