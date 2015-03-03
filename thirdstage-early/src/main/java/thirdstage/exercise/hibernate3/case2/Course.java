
package thirdstage.exercise.hibernate3.case2;

/**
 * Hibernate Many-to-Many Collection Mapping Example 
 *
 * @author 3rdstage
 * @version 1.0, 2005-11-17, 3rdstage
 * @since 2005-11-17
 * @see Student
 * 
 * @hibernate.class table="Course" comment="과목 Master"
 */
public class Course {
	
	private String id = null;
	private String name = null;
	
	/** Creates a new instance of Course */
	public Course() {
	}
	
	/**
	 * @hibernate.id column="id" length="16" generator-class="assigned" unsaved-value="null"
	 *
	 */
	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }
	
	/**
	 * @hibernate.property column="name" type="string" length="60"
	 */
	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name; }
	
	
	
	
}
