package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before("execution(* app.core.coupon.dao.*.*(..))")
	public void myAdvice() {
		System.out.println(">>> from myAdvice");
	}

}
