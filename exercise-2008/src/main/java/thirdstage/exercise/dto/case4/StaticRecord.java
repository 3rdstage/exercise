/**
 * 
 */
package thirdstage.exercise.dto.case4;

import java.util.List;

/**
 * @author 3rdstage
 *
 */
public interface StaticRecord extends Record {
	
	
	String[] getFieldNames();
	
	String getFieldName(int index);
	
	String getFieldType(String name);
	
	String getFieldType(int index);
	
	Field[] getFields();
	
	Field[] getFieldsCopy();
	
}
