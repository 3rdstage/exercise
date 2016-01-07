/**
 * 
 */
package thirdstage.exercise.dto.case3;

import java.util.Set;

/**
 * @author 3rdstage
 *
 */
public interface SimpleType extends java.io.Serializable{

	Set<Class> getAllowedTypesForFields();
	
	boolean isSimpleType(Class<? extends SimpleType> clazz);
}
