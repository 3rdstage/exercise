
package thirdstage.exercise.hibernate3.case6;

import javax.persistence.*;
import org.hibernate.annotations.Index;


/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-08-04일, 3rdstage
 * @since 2006-08-04
 */
@Entity
@Table(name="User6", schema="test")
public class User implements java.io.Serializable {
	
	private Long id = null;
	private String password = null;
	private String name = null;
	private String email = null;
	
	
	/** Creates a new instance of User */
	public User() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	@Basic
	@Column(name="passwd", length=16, nullable=false, unique=false)
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password;	}

	@Basic
	@Column(name="name", length=50, nullable=false, unique=false)
	@org.hibernate.annotations.Index(name="idx_user6_1")
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@Basic
	@Column(name="email", length=80, nullable=true, unique=false)
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
}
