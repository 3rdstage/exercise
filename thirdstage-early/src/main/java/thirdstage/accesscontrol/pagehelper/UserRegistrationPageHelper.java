/*
 * UserRegistrationPageHelper.java
 *
 * Created on 2005-02-18
 */

package thirdstage.accesscontrol.pagehelper;

import javax.faces.model.SelectItem;
import thirdstage.accesscontrol.manager.AccessControlManager;
import thirdstage.accesscontrol.vo.RoleMinValue;

/**
 * All method in this class is thread-safe
 *
 * @author 3rdstage
 */
public class UserRegistrationPageHelper extends thirdstage.framework.mercury.AbstractPageHelper{
	
	protected AccessControlManager accessControlManager = null;
	
	/** Creates a new instance of UserRegistrationPageHelper */
	public UserRegistrationPageHelper() {
		this.accessControlManager = new AccessControlManager();
		
	}
	
	public SelectItem[] getAllRoles(){
		RoleMinValue[] roles = null;
		SelectItem[] items = null;
		
		try{
			roles = accessControlManager.getAllRolesInMinValue();
			items = new SelectItem[roles.length];
			
			for(int i = 0, n = roles.length; i < n; i++){
				items[i] = new SelectItem(roles[i].getId(), roles[i].getName());
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
		return items;
	}
	
	
}
