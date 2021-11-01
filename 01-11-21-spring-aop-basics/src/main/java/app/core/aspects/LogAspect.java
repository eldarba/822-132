package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before("any()")
	public void myAdvice(JoinPoint jp) {
		System.out.println(">>> from myAdvice: " + jp.getSignature());
	}

	@Pointcut("execution(* *(..))")
	public void any() {

	}

}
