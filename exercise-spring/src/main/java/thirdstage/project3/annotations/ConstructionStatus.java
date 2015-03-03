package thirdstage.project3.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface ConstructionStatus {
	/**
	 * Specify the name of programmer who writes the program.
	 */
	String author();
	
	/**
	 * Specify the name of approver who should perform final unit test for the program
	 */
	String approver();
	
	/**
	 * Specify the planned date for the completion of the program in "yyyy-MM-dd" foramt. 
	 * 
	 */
	String targetDate();
	
	/**
	 * Specify percentage of completion for the program with an integer between 1 to 100.
	 * A program is said to be completed when it passes the unit test by the approver.
	 */
	int completionPercentage();
	
	
	
	
}
