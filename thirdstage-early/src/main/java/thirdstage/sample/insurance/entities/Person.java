
package thirdstage.sample.insurance.entities;

import thirdstage.framework.mars.*;
/**
 *
 * @author 3rdstage
 * @version 1.0, 2005년 10월 20일 (목)
 * @since 2005년 10월 20일 (목)
 *
 * @hibernate.class table="Person" polymorphism="implicit"
 */
public class Person  implements thirdstage.framework.mars.Persistable {
	
	private String id = null;
	
	/** Creates a new instance of Person */
	public Person() {
	}
	
	/**
	 * @hibernate.id generator-class="assigned" column="id" unsaved-value="null"
	 */
	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }
	
	public boolean equals(Object obj){
		if(obj == this) return true;
		if(!(obj instanceof Person)) return false;
		
		if(this.getId().equals(((Person)obj).getId())) return true;
		else return false;
	}
	
	public int hashCode(){
		return this.getId().hashCode();
	}
	
}
