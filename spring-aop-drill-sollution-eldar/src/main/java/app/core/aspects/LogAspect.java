package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before("all()")
	public void ad() {
		System.out.println("xxxxxxxxxx");
	}

	@Pointcut("execution(* *(..)")
	public void all() {
	}

}
