/**
 * 
 */
package thirdstage.exercise.dto.case2;

/**
 * This class has it's key in lower-case always.<br/>
 * 
 * 
 * @author Sangmoon Oh
 * @since 2009-02-27
 *
 */
public abstract class AbstractFieldMeta implements FieldMeta {
	
	private String key;
	
	/**
	 * @param key
	 * @throws IllegalArgumentException if given <code>key</code> is <code>null</code> or empty after trimmed.
	 */
	public AbstractFieldMeta(String key){
		this.setKey(key);
		
	}
	
	/* (non-Javadoc)
	 * @see thirdstage.exercise.dto.case2.FieldMeta#getKey()
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * Sets key property of this object.<br/>
	 * The key is converted to lower-case always.
	 * 
	 * @see thirdstage.exercise.dto.case2.FieldMeta#setKey(java.lang.String)
	 * @throws IllegalArgumentException if given <code>key</code> is <code>null</code> or empty after trimmed.
	 */
	public void setKey(String key) {
		if(key == null || key.trim().length() == 0){
			throw new IllegalArgumentException("field key shouldn't null or empty");
		}
		
		this.key = key.toLowerCase();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractFieldMeta other = (AbstractFieldMeta) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equalsIgnoreCase(other.key))
			return false;
		return true;
	}

	
	
}
