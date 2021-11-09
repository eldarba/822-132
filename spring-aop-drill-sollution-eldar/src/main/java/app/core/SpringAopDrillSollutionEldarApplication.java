package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.beans.login.LoginManager;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopDrillSollutionEldarApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringAopDrillSollutionEldarApplication.class, args);

		LoginManager loginManager = ctx.getBean(LoginManager.class);
		loginManager.login("aaa");
	}

}
