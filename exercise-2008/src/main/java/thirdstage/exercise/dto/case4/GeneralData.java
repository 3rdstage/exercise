/**
 * 
 */
package thirdstage.exercise.dto.case4;

import java.util.List;

/**
 * @author 3rdstage
 *
 */
public interface GeneralData {
	
	List<String> getLinearDataKeys();
	Record getLinearData(String key);
	
	List<String> getTabularDataKeys();
	TabularData getTabularData(String key);
	
	
	/**
	 * replaceble method.
	 * 
	 * @param type
	 * @param key
	 * @return
	 */
	Field getField(String type, String linearPartKey, String name);
}
