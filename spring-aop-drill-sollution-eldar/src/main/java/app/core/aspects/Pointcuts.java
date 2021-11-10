package app.core.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

	// all methods in any class of app.core package and sub packages
	@Pointcut("execution(* app.core..*.*(..))")
	public void appCore() {
	}

}
