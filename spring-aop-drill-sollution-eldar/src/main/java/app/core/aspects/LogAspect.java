package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before("appCore() && login()")
	public void preLoginAdvice(JoinPoint jp) {
		System.out.print(">>>LOG::preLoginAdvice: ");
		System.out.println("log in is about to execute with password: " + jp.getArgs()[0]);
	}

	// all methods in any class of app.core package and sub packages
	@Pointcut("execution(* app.core..*.*(..))")
	public void appCore() {
	}

	@Pointcut("execution(* login(..))")
	public void login() {
	}

}
