/**
 * 
 */
package thirdstage.exercise.dto.case4;

import java.util.List;

/**
 * 
 * 
 * @author 3rdstage
 *
 */
public interface DynamicRecord extends Record {
	
	void putField(String name, String type, Object value);
	
	void putField(Field field);
	
	Field getField(String name);
	
	/**
	 * returns the references (not copy) of fields
	 * 
	 * @return
	 */
	List<Field> getFields();
	
	List<Field> getFieldsCopy();

}
