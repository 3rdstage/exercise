/*
 * UserBean.java
 *
 * Created on 2005-02-11
 */

package thirdstage.accesscontrol.beans;

import org.apache.commons.codec.digest.*;
import thirdstage.accesscontrol.manager.AccessControlManager;
import thirdstage.accesscontrol.vo.UserNormalValue;
import thirdstage.accesscontrol.vo.UserMinValue;

/**
 * This class is not thread-safe
 *
 * @author 3rdstage
 */
public class UserBean implements java.io.Serializable {
	
	public static final String OUTCOME_SUCCESS = "success";
	public static final String OUTCOME_FAILURE = "failure";

	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserBean.class);
			
	protected String outcome = "";
			
	private String id = null;
	private String roleId = null;
	private String password = null;
	private String passwordHash = null;
	private String name = null;
	private String residentRegistrationNo = null;
	
	
	/** Creates a new instance of UserBean */
	public UserBean() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getRoleId(){
		return this.roleId;
	}
	
	public void setRoleId(String id){
		this.roleId = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResidentRegistrationNo() {
		return residentRegistrationNo;
	}

	public void setResidentRegistrationNo(String rrn) {
		this.residentRegistrationNo = rrn;
	}

	public String register(){
		logger.debug("method entered : " + (UserBean.class).getName() + ".register"); 
		
		
		AccessControlManager manager = new AccessControlManager();
		
		try{
			manager.registerUser(this.normalValue());
			this.outcome = OUTCOME_SUCCESS;
		}
		catch(Exception ex){
			logger.error(ex);
			this.outcome = OUTCOME_FAILURE;
		}

		return this.outcome;
	}

	public UserNormalValue normalValue(){
		String hash = DigestUtils.shaHex(this.getPassword());
		
		return new UserNormalValue(this.getId(), this.getPassword(), hash, this.getName(), this.getResidentRegistrationNo(), this.getRoleId(), "");
	}

	public UserMinValue minValue(){
		return new UserMinValue(this.getId(), this.getName());
	}
	
}
