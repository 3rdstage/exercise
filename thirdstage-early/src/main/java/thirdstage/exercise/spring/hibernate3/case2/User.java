
package thirdstage.exercise.spring.hibernate3.case2;

/**
 *
 * @author 3rdstage
 * @since 2006-07-06
 *
 * @hibernate.class table="User2"
 * 
 * @hibernate.query name="findAllUsers"
 *                  query="from User as user order by user.id asc"
 */
public class User {
	private Long id = null;
	private String password = null;
	private String name = null;
	private String email = null;
	private ContactInfo contactInfo = null;
	
	private Group group = null;
	private java.util.List roles = null;
	
	
	/** Creates a new instance of User */
	public User(){ }
	
	public User(String passwd, String name, String email){
		this.password = passwd;
		this.name = name;
		this.email = email;
	}
	
	/**
	 * @hibernate.id column="id" unsaved-value="null" generator-class="native"
	 */
	public Long getId(){ return this.id; }
	public void setId(Long id){ this.id = id; }
	
	/**
	 * @hibernate.property column="passwd" type="string" length="20"
	 *                    unique="false" not-null="true" update="false" insert="true"
	 */
	public String getPassword(){ return this.password; }
	public void setPassword(String password){ this.password = password; }

	/**
	 * @hibernate.property column="name" type="string" length="50"
	 *                     unique="false" not-null="true" update="false" insert="true"
	 */
	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name; }

	/**
	 * @hibernate.property column="email" type="string" length="80"
	 *                     unique="false" not-null="false" update="false" insert="true"
	 */
	public String getEmail(){ return this.email; }
	public void setEmail(String email){ this.email = email; }
	
	/**
	 * @hibernate.many-to-one column="contactInfoId" 
	 *                        foreign-key="fk_user2_2" 
	 *                        not-null="false" 
	 *                        lazy="true" casecade="update-save"
	 */
	public ContactInfo getContactInfo(){ return this.contactInfo; }
	public void setContactInfo(ContactInfo info){ this.contactInfo = info; }
	
	/**
	 * @hibernate.many-to-one column="groupId" 
	 *                        foreign-key="fk_user2_1" 
	 *                        not-null="false" 
	 *                        lazy="true" cascade="none"
	 */
	public Group getGroup(){ return this.group; }
	public void setGroup(Group group){ this.group = group; }
	
	
	/**
	 * @hibernate.list table="UserRole2" case-cade="save-update" inverse="false"
	 * @hibernate.collection-key column="userId" 
	 *                           foreign-key="fk_userrole2_1" comment="사용자 ID"
	 * @hibernate.collection-index column="roleId"
	 * @hibernate.collection-many-to-many class="thirdstage.exercise.spring.hibernate3.case2.Role" 
	 *                                    column="roleId"
	 *                                    foreign-key="fk_userrole2_2"
	 */
	public java.util.List getRoles(){ return this.roles; }
	public void setRoles(java.util.List roles){ this.roles = roles; }
}
