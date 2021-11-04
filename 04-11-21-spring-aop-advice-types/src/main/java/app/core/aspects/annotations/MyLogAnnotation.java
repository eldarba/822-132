package app.core.aspects.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface MyLogAnnotation {

	// element definition
	String key() default "my-key";

	int value() default 1;

	boolean condition() default false;
}
