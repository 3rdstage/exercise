/**
 * 
 */
package thirdstage.exercise.concurrency.case4;

/**
 * @author 3rdstage
 *
 */
public interface Context {
	
	Object put(String key, Object value);
	
	Object get(String key);
	

}
