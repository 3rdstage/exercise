package thirdstage.exercise.hibernate3.case4;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-12-29, 3rdstage
 * @since 2005-12-29
 *
 * @hibernate.class table="Employee4"
 */
public class Employee {
	
	private Long id = null;
	private String taxfileNumber = null;
	private Name name = null;
	
	/**
	 * Creates a new instance of Employee
	 */
	public Employee() {
	}
	
	/**
	 * @hibernate.id column="id" generator-class="native"
	 */
	public Long getId(){ return this.id; }
	public void setId(Long id){ this.id = id; }
	
	/**
	 * @hibernate.property column="taxfileNumber" type="string" length="20" not-null="false"
	 */
	public String getTaxfileNumber(){ return this.taxfileNumber; }
	public void setTaxfileNumber(String number){ this.taxfileNumber = number; }
	
	/**
	 * @hibernate.component
	 */
	public Name getName(){ return this.name; }
	public void setName(Name name){ this.name = name; }
	
	
	
}
