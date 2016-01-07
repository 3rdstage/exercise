/**
 * 
 */
package thirdstage.exercise.meta.service.case1;

import javax.annotation.Nullable;

/**
 * @author 3rdstage
 *
 */
public interface FieldFacet<T> {

	String getName();
	
	Class<T> getType();
	 
	String getDescription(@Nullable String lang); 
	
	@Nullable T getDefault();
	
	@Nullable T getMax();
	
	Boolean isMaxInclusive();
	
	@Nullable T getMin();
	
	Boolean isMinInclusive();
	
	@Nullable T[] getEnums();

	String getPattern();
	
}
