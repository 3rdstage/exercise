/**
 * 
 */
package thirdstage.exercise.dto.case2;

/**
 * @author 3rdstage
 *
 */
public interface Field {
	
	FieldMeta getMeta();
	
	void setMeta(FieldMeta meta);
	
	/**
	 * Gets key from field meta.
	 * 
	 * @return
	 * 
	 */
	String getKey();
	
	String getValue();
	
	void setValue(String value);
	

}
