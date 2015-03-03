/**
 * 
 */
package thirdstage.exercise.dto.case6;

import javax.validation.constraints.NotNull;

/**
 * @author 3rdstage
 *
 */
public class FieldFacet {
	
	
	private FieldFacetType type;
	
	private Class<?> valueType;
	
	private Object value;
	
	/**
	 * @param type
	 * @param value
	 * @throw IllegalArgumentException when the given <code>value</code> is not
	 *    proper for the given facet <code>type</code>.
	 */
	public FieldFacet(@NotNull FieldFacetType type, Object value){
		this.type = type;
		this.valueType = type.getValueType();
		
		if(value != null){
			if(!this.valueType.isAssignableFrom(value.getClass())){
				throw new IllegalArgumentException("The given value is not proper fot the specified facet.");
			}
		}
		
		this.value = value;
	}
	
	@NotNull
	public FieldFacetType getType(){
		return this.type;
	}
	
	@NotNull
	public Class<?> getValueType(){
		return this.valueType;
	}

	public Object getValue(){
		return this.value;
	}
	
	public String getValueAsString(){
	
		return String.valueOf(this.value);
	}
	
}
