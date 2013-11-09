
package thirdstage.exercise.hibernate3.case2;

/**
 * Hibernate One-to-Many Collection Example
 *
 * @author 3rdstage
 * @version 1.0, 2005-11-03
 * @since 2005-11-03
 * 
 * @hibernate.class table="Employee"
 */
public class Employee {
	
	private String id = null;
	private Employee boss = null;
	private String name = null;
	
	private Company company = null;
	
	/** Creates a new instance of Employee */
	public Employee() {
	}
	
	public Employee(String name){ this.setName(name); }

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
	 * @hibernate.many-to-one column="bossId" foreign-key="fk_employee_1"
	 */
    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
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
	 * @hibernate.many-to-one column="companyId" foreign-key="fk_employee_2"
	 */
	public Company getCompany(){ return this.company; }
	public void setCompany(Company company){ this.company = company; }
	 
	 
	
	
	
}
