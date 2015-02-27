/*
 * UserNormalValue.java
 *
 * Created on 2005-03-11
 */

package thirdstage.accesscontrol.vo;

/**
 *
 * @author 3rdstage
 */
public class UserNormalValue {
	
	private String id = "";
	private String password = "";
	private String passwordHash = "";
	private String name = "";
	private String residentRegistrationNo = "";
	private String roleId = "";
	private String roleName = "";
	
	/** Creates a new instance of UserNormalValue */
	public UserNormalValue() {
	}
	
	public UserNormalValue(String id, String passwd, String passwdHash,
			                 String name, String rrn, String roleId, java.lang.String roleName){
		
		this.setId(id);
		this.setPassword(passwd);
		this.setPasswordHash(passwdHash);
		this.setName(name);
		this.setResidentRegistrationNo(rrn);
		this.setRoleId(roleId);
		this.setRoleName(roleName);
	}

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResidentRegistrationNo() {
        return this.residentRegistrationNo;
    }

    public void setResidentRegistrationNo(String rrn) {
        this.residentRegistrationNo = rrn;
    }
	 
    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

	 public String getRoleName(){ return this.roleName; }
	
	 public void setRoleName(String name){ this.roleName = name; }
	
}
