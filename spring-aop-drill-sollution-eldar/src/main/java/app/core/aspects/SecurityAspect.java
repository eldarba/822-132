package app.core.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.core.beans.login.LoginManager;

@Component
@Aspect
public class SecurityAspect {
	@Autowired
	private LoginManager loginManager;

	// ADVICES

	@Around("daoMethods()")
	public Object checkLoginAdvice(ProceedingJoinPoint pjp) throws Throwable {
		if (loginManager.isLoggedIn()) {
			return pjp.proceed();
		} else {
			throw new Exception("---------- You are not logged in");
		}
	}

	// POINTCUTS

	@Pointcut("execution(* app.core.dao.*.*(..))")
	public void daoMethods() {
	}

}
