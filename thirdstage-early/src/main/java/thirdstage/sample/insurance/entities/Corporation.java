
package thirdstage.sample.insurance.entities;

import thirdstage.framework.mars.*;
/**
 *
 * @author 3rdstage
 * @version 1.0, 2005년 10월 21일 (금)
 * @since 2005년 10월 21일 (금)
 * 
 * @hibernate.joined-subclass
 * @hibernate.joined-subclass-key column="id"
 */
public class Corporation extends Person implements thirdstage.framework.mars.Persistable {
	
	private String name = null;
	private String registrationNo = null;
	
	/** Creates a new instance of Corporation */
	public Corporation() {
	}
	
	/**
	 * @hibernate.property column="name"
	 */
	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name; }
	
	/**
	 * @hibernate.property column="reg_no"
	 */
	public String getRegistrationNo(){ return this.registrationNo; }
	public void setRegistrationNo(String regNo){ this.registrationNo = regNo; }
	
	
	public boolean equals(Object obj){
		if(obj == this) return true;
		if(!(obj instanceof Corporation)) return false;
		
		if(this.getId().equals(((Corporation)obj).getId())) return true;
		else return false;
	}
	
	public int hashCode(){
		return this.getId().hashCode();
	}
}
