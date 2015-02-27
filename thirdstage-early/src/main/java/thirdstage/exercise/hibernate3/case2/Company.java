
package thirdstage.exercise.hibernate3.case2;


import java.util.List;
import java.util.Set;
/**
 * Hibernate One-to-Many Collection Example
 * 
 * @author 3rdstage
 * @version 1.0, 2005-11-04, 3rdstage
 * @since 2005-11-04
 * @see Building
 * @see Factory
 * @see Employee
 *
 * @hibernate.class table="Company" 
 */
public class Company {
	
	private String id;
	private String name;
	
	private List employees;
	private Set factories;
	private Building[] buildings;
	
	/** Creates a new instance of Company */
	public Company() {
	}
	
	/**
	 * @hibernate.id column="id" generator-class="assigned" length="16" unsaved-value="null"
	 */
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }

	/**
	 * @hibernate.property column="name" type="string" length="60"
	 * @hibernate.column name="name" index="idx_company_1"
	 */
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	
	/**
	 * @hibernate.list cascade="save-update" lazy="false" inverse="true"
	 * @hibernate.collection-one-to-many class="thirdstage.exercise.hibernate3.case2.Employee"
	 * @hibernate.collection-key column="companyId"
	 * @hibernate.collection-index column="id"
	 */
	public List getEmployees() { return employees; }
	public void setEmployees(List employees) { this.employees = employees;}
	
	
	/**
	 * @hibernate.set cascade="save-update" lazy="false" inverse="true"
	 * @hibernate.collection-one-to-many class="thirdstage.exercise.hibernate3.case2.Factory"
	 * @hibernate.collection-key column="companyId"
	 */
	public Set getFactories() { return factories; }
	public void setFactories(Set factories) { this.factories = factories;}
	
	/**
	 * @hibernate.array cascade="save-update" inverse="true"
	 * @hibernate.collection-one-to-many class="thirdstage.exercise.hibernate3.case2.Building"
	 * @hibernate.collection-key column="companyId"
	 * @hibernate.collection-index column="id"
	 */
	public Building[] getBuildings() { return buildings; }
	public void setBuildings(Building[] buildings) { this.buildings = buildings; }
	
	
	
	
	
	
}
