package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLogAspect {

	@Before("annotatedMethod()")
	public void before1(JoinPoint jp) {
		System.out.println(">>> 1) method: " + jp.getSignature().getName());
	}

	@Before("greet()")
	public void before2(JoinPoint jp) {
		System.out.println(">>> 2) method: " + jp.getSignature().getName());
	}

	// pointcut for annotation
	@Pointcut("@annotation(app.core.aspects.annotations.MyLogAnnotation)")
	public void annotatedMethod() {

	}

	// pointcut for method
	@Pointcut("execution(void greet())")
	public void greet() {

	}

}
