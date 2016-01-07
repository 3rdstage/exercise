/**
 * 
 */
package thirdstage.exercise.concurrency.case2;

import java.util.List;

/**
 * @author 3rdstage
 *
 */
public interface Validator<T extends BundleElement> {

	List<Report> validate();
	
}
