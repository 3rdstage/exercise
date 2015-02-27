/*
 * AccessControlManager.java
 *
 * Created on 2005-02-14
 */

package thirdstage.accesscontrol.manager;

import thirdstage.accesscontrol.beans.*;
import thirdstage.accesscontrol.dao.*;
import thirdstage.accesscontrol.vo.*;

/**
 * All Method in this class is thread-safe
 *
 * @author 3rdstage
 * @version 1.0
 * @since 2005/02/14
 */
public class AccessControlManager {
	
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AccessControlManager.class);
	
	protected UserDAO userDAO = null;
	protected RoleDAO roleDAO = null;
	
	/** Creates a new instance of AccessControlManager */
	public AccessControlManager() {
		this.userDAO = new UserDAO();
		this.roleDAO = new RoleDAO();
	}
	
	public void registerUser(UserNormalValue user) throws Exception{
		
		try{
			userDAO.createUser(user);
		}
		catch(Exception ex){
			throw new Exception("fail to register a new user");
		}
	}
	
	/**
	 *
	 * @return empty array if there's no role
	 */
	public RoleMinValue[] getAllRolesInMinValue() throws Exception{
		RoleMinValue[] roles = null;
		
		try{
			roles = roleDAO.getAllRolesInMinValue();
		}
		catch(Exception ex){
			throw new Exception("fail to get all roles");
		}
		
		return roles;
	}
	
	/**
	 *
	 * @return empty array if there's no role
	 */
	public RoleNormalValue[] getAllRolesInNormalValue() throws Exception{
		RoleNormalValue[] roles = null;
		
		try{
			roles = roleDAO.getAllRolesInNormalValue();
		}
		catch(Exception ex){
			throw new Exception("fail to get all roles");
		}
		
		return roles;
	}
	
	public UserNormalValue[] getAllUsersInNormalValue() throws Exception{
		UserNormalValue[] users = null;
		
		try{
			users = userDAO.getAllUsersInNormalValue();
		}
		catch(Exception ex){
			throw new Exception("fail to get all users");
		}
		
		return users;
	}
	
	
	
}
