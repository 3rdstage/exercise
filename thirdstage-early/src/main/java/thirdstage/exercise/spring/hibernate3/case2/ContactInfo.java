
package thirdstage.exercise.spring.hibernate3.case2;

/**
 *
 * @author 3rdstage
 * @since 2006-07-07
 * 
 * @hibernate.class table="ContactInfo2"
 */
public class ContactInfo {
	
	private Long id = null;
	private String address = null;
	private String phoneNumber = null;
	
	/** Creates a new instance of ContactInfo */
	public ContactInfo() {
	}

	/**
	 * @hibernate.id column="id" unsaved-value="null" generator-class="native"
	 */
	public Long getId(){ return this.id; }
	public void setId(Long id){ this.id = id; }

	/**
	 * @hibernate.property column="address" type="string" length="200"
	 *                     unique="false" not-null="false"
	 */
	public String getAddress(){ return this.address; }
	public void setAddress(String address){ this.address = address; }

	/**
	 * @hibernate.property column="phoneNumber" type="string" length="50"
	 *                     unique="false" not-null="false"
	 */
	public String getPhoneNumber(){return this.phoneNumber; }
	public void setPhoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber;	}
	
}
