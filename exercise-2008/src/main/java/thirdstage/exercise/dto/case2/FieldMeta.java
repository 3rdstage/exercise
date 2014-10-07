/**
 * 
 */
package thirdstage.exercise.dto.case2;

/**
 * 
 * Every object of this type should have non-null and non-empty(after trimmed) key.<br/>
 * 
 * Two <code>FieldMeta</code> object which have same key ignoring case should be equals. In other word
 * the following is always <code>true</code>
 * <pre><code>
 *    a.getKey().equalsIgnoreCase(b.getKey()) iff a.equals(b)
 * </code></pre>
 * For this, the implementation of this interface should override {@link Object#equals} method and 
 * {@link Object#hashCode} method, or it can extends {@link AbstractFieldMeta} class.
 * <br/><br/>
 * The implementation is encouraged to be immutable, so that the object can be pooled applying 
 * factory patterns for better performance.
 * 
 * @author Sangmoon Oh
 * @since 2009-02-27
 *
 */
public interface FieldMeta {
	
	String getKey();
	
	/**
	 * @return
	 * @see java.sql.Types
	 */
	int getSqlType();
	
	
	/**
	 * Returns -1, if max length is not defined.<br/>
	 * 
	 * @return
	 */
	int getMaxLength();
	
	
	// @TODO, think more over this
	FieldMeta getInstance(String key, int sqlType);
	
	FieldMeta getInstance(String key, int sqlType, int length);
	
}
