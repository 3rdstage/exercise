/*
 * RoleManagementPageHelper.java
 *
 * Created on 2005-03-11
 */

package thirdstage.accesscontrol.pagehelper;


import javax.faces.model.*;
import thirdstage.accesscontrol.manager.AccessControlManager;
import thirdstage.accesscontrol.vo.*;
/**
 *
 * @author 3rdstage
 */
public class RoleManagementPageHelper extends thirdstage.framework.mercury.AbstractPageHelper{

	protected AccessControlManager accessControlManager = null;

	
	/** Creates a new instance of RoleManagementPageHelper */
	public RoleManagementPageHelper() {
		this.accessControlManager = new AccessControlManager();
	}
	
	public DataModel getAllRoles(){
		DataModel data = null;
		RoleNormalValue[] roles = null;
		
		try{
			roles = this.accessControlManager.getAllRolesInNormalValue();
			data = new ArrayDataModel(roles);
		}
		catch(Exception ex){
			
		}

		return data;
	}
	
}
