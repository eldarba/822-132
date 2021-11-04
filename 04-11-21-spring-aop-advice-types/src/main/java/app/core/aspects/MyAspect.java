package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Before("div()")
	public void beforeDiv(JoinPoint jp) {
		System.out.println(">>> @Before: " + jp.getSignature().getName());
	}

	@After("div()")
	public void afterDiv(JoinPoint jp) {
		System.out.println(">>> @After: " + jp.getSignature().getName());
	}

	@AfterReturning(pointcut = "div()", returning = "result")
	public void afterDivReturns(JoinPoint jp, String result) {
		System.out.println(">>> @AfterReturning: " + jp.getSignature().getName() + ", result: " + result);
	}

	@AfterThrowing(pointcut = "div()", throwing = "e")
	public void afterDivThrows(JoinPoint jp, Exception e) {
		System.out.println(">>> @AfterThrowing: " + jp.getSignature().getName() + ", error message: " + e.getMessage());
	}

	// around - advice handle exception
//	@Around("div()")
	public Object aroundDiv(ProceedingJoinPoint pjp) {
		System.out.println("-----------@Around - before");
		try {
			Object message = pjp.proceed(); // call the join point and return the returned value to caller
			System.out.println("-----------@Around - after returning");
			return message;
		} catch (Throwable e) {
			return "error: " + e.getMessage();
		}
	}

	// around - advice pass on exception to caller
	@Around("div() && servicePackage()")
	public Object aroundDiv2(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-----------@Around - before");
		try {
			Object message = pjp.proceed(); // call the join point and return the returned value to caller
			System.out.println("-----------@Around - after returning");
			return message;
		} catch (Throwable e) {
			System.out.println("-----------@Around - after throwing");
			System.out.println("error: " + e.getMessage());
			throw e;
		}
	}

	// you can use @Pointcut methods for pointcuts (the standard way)
	@Pointcut("execution(String div(int, int))")
	public void div() {
	}

	@Pointcut("execution(* add*(..))")
	public void add() {
	}

	@Pointcut("execution(* app.core.service.*.*(..))")
	public void servicePackage() {
	}

	// you can use String constants for pointcuts
	public static final String div = "execution(String div(int, int))";

}
