
package thirdstage.exercise.hibernate3.case2;

/**
 * Hibernate One-to-Many Collection Example
 *
 * @author 3rdstage
 * @version 1.0, 2005-11-04
 * @since 2005-11-04
 * 
 * @hibernate.class table="Building"
 */
public class Building {
	
	private String id = null;
	private String name = null;
	private Company company = null;
	
	/** Creates a new instance of Building */
	public Building() {
	}
	
	/**
	 * @hibernate.id column="id" generator-class="assigned" length="16" unsaved-value="null"
	 */
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @hibernate.property column="name" type="string" length="60"
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @hibernate.many-to-one column="companyId" foreign-key="fk_building_1"
	 *                        index="fkx_building_1"
	 */
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
	
}
