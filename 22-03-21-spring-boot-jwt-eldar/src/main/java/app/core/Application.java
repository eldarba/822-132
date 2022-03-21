package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.utils.JwtUtil;
import app.core.utils.JwtUtil.ClientDetails;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		JwtUtil jwtUtil = ctx.getBean(JwtUtil.class);

		ClientDetails client = new ClientDetails(101, "admin@mail", ClientDetails.ClientType.ADMIN);
		String token = jwtUtil.generateToken(client);
		System.out.println(token);
	}

}
