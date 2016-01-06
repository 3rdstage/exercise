/**
 * 
 */
package thirdstage.exercise.dto.case1;

import java.util.List;
import java.util.Set;

/**
 * @author 3rdstage
 *
 */
public interface DataSet{
	
	int getSize();

	boolean containsKey(String key);
	
	String get(String key);
	
	DataSet put(String key, String value);
	
	DataSet remove(String key);
	
	Set<String> getKeys();
	
	List<String> getValues();
	
}
