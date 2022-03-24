package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import app.core.filters.LoginFilter;
import app.core.utils.JwtUtil;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		// TESTING the JWT Util

//		JwtUtil jwtUtil = ctx.getBean(JwtUtil.class);
//
//		// create client
//		ClientDetails client = new ClientDetails(101, "admin@mail", ClientDetails.ClientType.ADMIN);
//		// create token with the client details
//		String token = jwtUtil.generateToken(client);
//		System.out.println(token);
//
////		Claims claims = jwtUtil.exctractAllClaims(token);
////		System.out.println(claims);
//
//		// extract client from token
//		ClientDetails clientDetails = jwtUtil.extractClient(token);
//		System.out.println(clientDetails);
	}

	// register the filter to specific routes using FilterRegistrationBean
	@Bean
	public FilterRegistrationBean<LoginFilter> loginFilterRegistration(JwtUtil jwtUtil) {
		// create an instance of FilterRegistrationBean
		FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();
		// give it an instance of our filter
		registrationBean.setFilter(new LoginFilter(jwtUtil));
		// set the routes for our filter
		registrationBean.addUrlPatterns("/api/*");
		// return the FilterRegistrationBean
		return registrationBean;
	}
}
