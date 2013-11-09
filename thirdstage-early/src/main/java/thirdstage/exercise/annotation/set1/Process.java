package thirdstage.exercise.annotation.set1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 *
 * @author 3rdstage
 * @version 0.8, 2007-08-31, 3rdstage
 * @since 2007-08-31 
 */
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Process{
	
	String id();
	
}