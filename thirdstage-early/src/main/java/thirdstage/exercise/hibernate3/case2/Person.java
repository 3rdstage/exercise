
package thirdstage.exercise.hibernate3.case2;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-11-02
 * @since 2005-11-02
 * @see Address
 *
 * @hibernate.class table="Person"
 */
public class Person {
	
	private String id = null;
	private String name = null;
	private Address address = null;
	
	/** Creates a new instance of Person */
	public Person() {
		
	}
	
	/**
	 * @hibernate.id column="id" length="16" generator-class="assigned" unsaved-value="null"
	 */
	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }
	
	/**
	 * @hibernate.property column="name" length="30" not-null="true"
	 */
	public String getName(){ return this.name; }
	public void setName(String nm){ this.name = nm; }
	
	/**
	 * @hibernate.component
	 */
	public Address getAddress(){ return this.address; }
	public void setAddress(Address addr){ this.address = addr; }
}
