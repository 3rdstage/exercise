/**
 * 
 */
package thirdstage.project3.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
/**
 * @author 3rdstage
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
/**
 * Specify the elementary process in analysis model for the program.
 * This can the fine grained use-case or something like that according the methodology. 
 */
public @interface ElementaryProcess {
	/**
	 * Specify the unique identifier, code, or something like that for the elementary process.
	 * This field is mandatory.
	 */
	String id();
	
	/**
	 * Speicify the name of the elementary process.
	 * This field is optional.
	 */
	String name();
}
