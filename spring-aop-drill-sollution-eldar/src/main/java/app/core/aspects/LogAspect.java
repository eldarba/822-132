package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before("allAppCore()")
	public void ad() {
		System.out.println("xxxxxxxxxx");
	}

	// all methods in any class of app.core package and sub packages
	@Pointcut("execution(* app.core..*.*(..))")
	public void allAppCore() {
	}

}
