/**
 * 
 */
package thirdstage.exercise.dto.case2;

import java.util.Set;

/**
 * The field key should be unique (ignoring case) in a <code>FieldSet</code> object.<br/>
 * 
 * @author Sangmoon Oh
 * @since 2009-02-27
 *
 */
public interface FieldSet {

	//methods for field meta
	
	FieldMeta getFieldMeta(String key) throws NotExistingFieldException;
	
	/**
	 * Gets meta-data for all fields.<br/>
	 * This methods should operate in return-by-reference semantics.
	 * So, if you add more field meta to the <code>Set</code> object returned by this method, 
	 * they(added field meta) also added the <code>FieldSet</code> object that the method
	 * is operated.<br/>
	 * Returns empty set(not <code>null</code>), if the <code>FieldSet</code> object has no filed.
	 * 
	 * @return
	 */
	Set<FieldMeta> getFieldMetas();
	
	void setFieldMetas(Set<FieldMeta> metas);

	FieldSet addFieldMeta(FieldMeta meta);
	
	FieldSet removeFieldMeta(String key) throws NotExistingFieldException;

	boolean containsFieldMeta(String key);
	
	int getNumberOfFieldMetas();
	
	
	//methods for field
	Field getField(String key) throws NotExistingFieldException;
	
	String getFieldValue(String key) throws NotExistingFieldException;

	Set<Field> getAllFields();
	
	FieldSet setField(String key, String value) throws NotExistingFieldException;
	
	FieldSet addField(Field field);
	
	FieldSet removeField(String key) throws NotExistingFieldException;
	
	boolean containsField(String key);
	
	int getNumberOfFields();
	
}
