
package thirdstage.exercise.spring.hibernate3.case2;

/**
 *
 * @author 3rdstage
 * @since 2006-07-07
 *
 * @hibernate.class table="Group2"
 */
public class Group {
	
	private Long id = null;
	private String name = null;
	private String description = null;
	private java.util.List users = null;
	
	/** Creates a new instance of Group */
	public Group() {
	}
	
	public Group(String name, String desc){
		this.name = name;
		this.description = desc;
	}
	
	/**
	 * @hibernate.id column="id" unsaved-value="null" generator-class="native"
	 */
	public Long getId(){ return this.id; }
	public void setId(Long id){ this.id = id; }
	
	/**
	 * @hibernate.property column="name" type="string" length="50"
	 *                     unique="false" not-null="true"
	 */
	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name; }
	
	/**
	 * @hibernate.property column="description" type="string" length="200"
	 *                     unique="false" not-null="false"
	 */
	public String getDescription(){ return this.description; }
	public void setDescription(String desc){ this.description = desc; }
	
	/**
	 * @hibernate.list cascade="save-update" inverse="true"
	 * @hibernate.collection-key column="groupId"
	 * @hibernate.collection-index column="id"
	 * @hibernate.collection-one-to-many class="thirdstage.exercise.spring.hibernate3.case2.User"
	 */
	public java.util.List getUsers(){ return this.users; }
	public void setUsers(java.util.List users){ this.users = users; }

}
