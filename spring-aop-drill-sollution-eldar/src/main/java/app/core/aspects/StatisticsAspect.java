package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StatisticsAspect {

	private int countGetCalls;

	public int getCountGetCalls() {
		return countGetCalls;
	}

	// ADVICES

	@Before("basePackage() && getX()")
	public void countGetCalls() throws Throwable {
		countGetCalls++;
	}

	// POINTCUTS

	@Pointcut("execution(* get*(..))")
	public void getX() {
	}

	@Pointcut("app.core.aspects.Pointcuts.appCore()")
	public void basePackage() {
	}

}
