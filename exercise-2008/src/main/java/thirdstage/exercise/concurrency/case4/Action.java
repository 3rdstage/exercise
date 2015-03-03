/**
 * 
 */
package thirdstage.exercise.concurrency.case4;

/**
 * @author 3rdstage
 *
 */
public interface Action<V> {
	
	
	V process(Context cntx) throws Exception;

}
