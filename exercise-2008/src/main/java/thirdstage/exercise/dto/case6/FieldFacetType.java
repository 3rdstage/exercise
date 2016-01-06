package thirdstage.exercise.dto.case6;

/**
 * Overall concept of facet is based on the facet of XML schema.
 * Facet is said to be a single defining aspect of a value space.
 * For more, read http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/#rf-facets
 * 
 * @author 3rdstage
 *
 */
public enum FieldFacetType {
	
	LENGTH(Integer.class),
	MIN_LENGTH(Integer.class),
	MAX_LENGTH(Integer.class),
	PATTERN(String.class),
	ENUM(Object[].class),
	MAX(Double.class), // max inclusive, equal or less than
	MIN(Double.class), // min inclusive, equal or more than
	MAX_EXCLUSIVE(Double.class), //less than
	MIN_EXCLUSIVE(Double.class); //more than

	/**
	 * The Java type of the facet's value
	 */
	private Class<?> valueType;
	
	FieldFacetType(Class<?> type){
		this.valueType = type;
	}
	
	public Class<?> getValueType(){
		return this.valueType;
	}
	
}
