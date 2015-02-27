package thirdstage.exercise.hibernate3.case5;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-01-02, 3rdstage
 * @since 2006-01-02
 *
 * @hibernate.class table="Employee5" comment="고용원" 
 * @hibernate.mapping auto-import="false"
 */
public class Employee {
	
	private Long id = null;
	private String taxfileNumber = null; 
			
	/**
	 * Creates a new instance of Employee
	 */
	public Employee() {
	}
	
	/**
	 * @hibernate.id generator-class="native" column="id" type="long" unsaved-value="null"
	 */
	public Long getId(){ return this.id; }
	public void setId(Long id){ this.id = id; }
	
	/**
	 * @hibernate.property type="string"
	 * @hibernate.column name="taxfileNo" length="60" not-null="false" unique="false" comment="Taxfile 번호"
	 */
	public String getTaxfileNumber(){ return this.taxfileNumber; }
	public void setTaxfileNumber(String no){ this.taxfileNumber = no; }
	
	
}
