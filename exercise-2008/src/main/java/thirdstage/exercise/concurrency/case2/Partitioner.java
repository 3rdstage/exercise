/**
 * 
 */
package thirdstage.exercise.concurrency.case2;

import java.util.List;

/**
 * @author 3rdstage
 *
 */
public interface Partitioner<T extends Bundle> {
	
	List<T> partition(); 

}
