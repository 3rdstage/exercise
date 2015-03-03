
package thirdstage.exercise.hibernate3.case2;

import java.util.List;
import java.util.Set;
/**
 * Hibernate One-to-Many Collection Example
 *
 * @author 3rdstage
 * @version 1.0, 2005-11-04, 3rdstage
 * @since 2005-11-04
 *
 * @hibernate.class table="Factory"
 */
public class Factory {
	
	private String id = null;
	private String name = null;
	
	private Company company = null;
	
	/** Creates a new instance of Factory */
	public Factory() {
	}
	
	/**
	 * @hibernate.id column="id" generator-class="assigned" length="16" unsaved-value="null"
	 */
	public String getId() { return id; }
	public void setId(String id) { this.id = id;	}
	
	/**
	 * @hibernate.property column="name" type="string" length="60"
	 */
	public String getName() { return name;	}
	public void setName(String name) { this.name = name;}
	
	/**
	 * @hibernate.many-to-one column="companyId" foreign-key="fk_factory_1"
	 */
	public Company getCompany() { return company; }
	public void setCompany(Company company) { this.company = company; }
	
	
	
}
