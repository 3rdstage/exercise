/**
 * 
 */
package thirdstage.exercise.concurrency.case4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 3rdstage
 *
 */
public class DefaultContext implements Context {
	
	
	Map<String, Object> map = new HashMap<String, Object>();

	/* (non-Javadoc)
	 * @see thirdstage.exercise.concurrency.case4.Context#put(java.lang.String, java.lang.Object)
	 */
	@Override
	public Object put(String key, Object value) {
		return this.map.put(key, value);
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.concurrency.case4.Context#get(java.lang.String)
	 */
	@Override
	public Object get(String key) {
		return this.map.get(key);
	}

}
