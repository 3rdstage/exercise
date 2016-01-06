/**
 * 
 */
package thirdstage.exercise.concurrency.case4;

import java.util.List;

/**
 * Stateful object.
 * 
 * @author 3rdstage
 *
 */
public interface ParallelProcessor<V, A extends Action<V>> {
	
	
	void setup(List<PreProcessor> pres, List<PostProcessor> posts, Partitioner<A> prt, Context cntx);
	

	void process() throws Exception;

	/**
	 * Returns unmodifiable list ...
	 * 
	 * @return
	 */
	List<PreProcessor> getAllPreProcessors();
	
	void enablePreProcessor(int index) throws IndexOutOfBoundsException;
	
	void disablePreProcessor(int index) throws IndexOutOfBoundsException;
	
	/**
	 * Returns unmodifiable list ...
	 * 
	 * @return
	 */
	List<PostProcessor> getAllPostProcessors();
	
	void enablePostProcessor(int index) throws IndexOutOfBoundsException;
	
	void disablePostProcessor(int index) throws IndexOutOfBoundsException;
	
	
	// @todo needs more accessors for Partitions, Context, Actions, Workers or Futures of this processor

}
