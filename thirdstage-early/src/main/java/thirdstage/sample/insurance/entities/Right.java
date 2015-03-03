
package thirdstage.sample.insurance.entities;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005년 10월 30일 (일)
 * @since 2005년 10월 30일 (일)
 * 
 * @hibernate.class table="Right" polymorphism="implicit" discriminator-value="RIG"
 * @hibernate.discriminator column="discriminator" type="string" length="5"
 */
public class Right {
	
	private String id = null;
	private java.util.Date date = null;
	
	/** Creates a new instance of Right */
	public Right() {
	}
	
	/**
	 * @hibernate.id column="id" generator-class="assigned" unsaved-value="null" length="16"
	 */
	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }
	
	/**
	 * @hibernate.property name="date" column="start_date" type="date"
	 */
	public java.util.Date getDate(){ return this.date; }
	public void setDate(java.util.Date date){ this.date = date; }
	
	
}
