package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	// ADVICES

	@Before("basePackage() && login()")
	public void preLoginAdvice(JoinPoint jp) {
		System.out.print(">>>LOG::preLoginAdvice: ");
		System.out.println("log in is about to execute with password: " + jp.getArgs()[0]);
	}

	@Before("basePackage() && add()")
	public void preAddAdvice(JoinPoint jp) {
		System.out.print(">>>LOG::preAddAdvice: ");
		System.out.println("about to add: " + jp.getSignature().getName());
	}

	// POINTCUTS

	@Pointcut("execution(* login(..))")
	public void login() {
	}

	@Pointcut("execution(* add*(..))")
	public void add() {
	}

	@Pointcut("app.core.aspects.Pointcuts.appCore()")
	public void basePackage() {
	}

}
