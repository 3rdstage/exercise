/**
 * 
 */
package thirdstage.exercise.concurrency.case4;

import java.util.List;

/**
 * @author 3rdstage
 *
 */
public interface Partitioner<A extends Action> {
	
	List<A> partition();

}
