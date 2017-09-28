
package thirdstage.exercise.spring.hibernate3.case2;

/**
 *
 * @author 3rdstage
 * @version 1.0, 3rdstage
 * @since 2006-07-31
 *
 * @hibernate.class table="Role2"
 */
public class Role {
	
	private Long id = null;
	private String name = null;
	private String description = null;
	
	/** Creates a new instance of Role */
	public Role() {
	}
	
	/**
	 * @hibernate.id column="id" unsaved-value="null" generator-class="native"
	 */
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id;}

	/**
	 * @hibernate.property column="name" type="string" length="50"
	 *                     unique="true" not-null="true" update="false" insert="true"
	 */	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	/**
	 * @hibernate.property column="description" type="string" length="200"
	 *                     unique="false" not-null="false"
	 */
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
}
