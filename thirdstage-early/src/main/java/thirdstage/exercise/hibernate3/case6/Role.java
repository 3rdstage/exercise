
package thirdstage.exercise.hibernate3.case6;

import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-08-04, 3rdstage
 * @since 2006-08-04
 */
@Entity
@Table(name="Role6", schema="test")
@org.hibernate.annotations.Table(
	appliesTo="Role6", 
	indexes={@org.hibernate.annotations.Index(name="idx_role6_1", columnNames={"name"})}
)
public class Role implements java.io.Serializable{
	
	private Long id = null;
	private String name = null;
	private String description = null;
	private java.util.List<Role> roles = null;
	
	
	/** Creates a new instance of Role */
	public Role() {}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	@Basic
	@Column(name="name", length=50, nullable=false, unique=true)
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Basic
	@Column(name="description", length=200, nullable=true, unique=false)
	public String getDescription() {	return description; }
	public void setDescription(String description) { this.description = description; }
	
	@ManyToMany(
		targetEntity=thirdstage.exercise.hibernate3.case6.Role.class,
		cascade={CascadeType.PERSIST}
	)
	@IndexColumn(name="roleId")
	@JoinTable(
		name="UserRole6",
		joinColumns={@JoinColumn(name="userId")},
		inverseJoinColumns={@JoinColumn(name="roleId")}
	)
	public java.util.List<Role> getRoles(){ return this.roles; }
	public void setRoles(java.util.List<Role> roles){ this.roles = roles; }
	
}
