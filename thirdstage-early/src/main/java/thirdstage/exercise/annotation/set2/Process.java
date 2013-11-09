package thirdstage.exercise.annotation.set2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 *
 * @author 3rdstage
 * @version 0.81, 2007-09-03, 3rdstage, moves packages and makes enable to describe multi processes. 
 * @version 0.8, 2007-08-31, 3rdstage, initial
 * @since 2007-08-31 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Process{
	
	String[] ids();
	
}