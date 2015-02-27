
package thirdstage.sample.insurance.entities;

import thirdstage.framework.mars.*;
import thirdstage.sample.insurance.values.IndividualNormalValue;
/**
 * 
 * @author 3rdstage
 * @version 1.0, 2005년 10월 21일 (금)
 * @since 2005년 10월 21일 (금)
 * 
 * @hibernate.joined-subclass table="Individual"
 * @hibernate.joined-subclass-key column="id"
 */
public class Individual extends Person implements thirdstage.framework.mars.Persistable {
	
	private String firstName = null;
	private String lastName = null;
	
	/**
	 * Gets value object from given individual entity. If the given entity is <code>null</code>
	 * , returns <code>null</code>
	 *
	 * @return value obejct of given entity or <code>null</code> if the given entity is <code>null</code>
	 */
	public static IndividualNormalValue getNormalValue(Individual individual){
		if(individual == null) return null;
		
		IndividualNormalValue value = new IndividualNormalValue();
		value.setId((individual.getId() != null) ? individual.getId() : "");
		value.setFirstName((individual.getFirstName() != null) ? individual.getFirstName() : "");
		value.setLastName((individual.getLastName() != null) ? individual.getLastName() : "");
		
		return value;
	}
	
	/** Creates a new instance of Individual */
	public Individual() {
	}
	
	
	/**
	 * @hibernate.property column="first_name" type="string" length="50"
	 */
	public String getFirstName(){ return this.firstName; }
	public void setFirstName(String name){ this.firstName = name; }
	
	/**
	 * @hibernate.property column="last_name" type="string" length="50"
	 */
	public String getLastName(){ return this.lastName; }
	public void setLastName(String name){ this.lastName = name; }
	
	
	public boolean equals(Object obj){
		if(obj == this) return true;
		if(!(obj instanceof Individual)) return false;
		
		if(this.getId().equals(((Individual)obj).getId())) return true;
		else return false;
	}
	
	public int hashCode(){
		return this.getId().hashCode();
	}
	
}
