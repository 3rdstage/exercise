/*
 * UserSearchPageHelper.java
 *
 * Created on 2005-03-13
 */

package thirdstage.accesscontrol.pagehelper;

import javax.faces.model.*;
import thirdstage.accesscontrol.manager.*;
import thirdstage.accesscontrol.vo.*;

/**
 *
 * @author 3rdstage
 */
public class UserSearchPageHelper extends thirdstage.framework.mercury.AbstractPageHelper {

	protected AccessControlManager accessControlManager = null;

	/** Creates a new instance of UserSearchPageHelper */
	public UserSearchPageHelper() {
		this.accessControlManager = new AccessControlManager();
	}
	
	
	public DataModel getAllUsers(){
		DataModel data = null;
		UserNormalValue[] users = null;
		
		try{
			users = this.accessControlManager.getAllUsersInNormalValue();
			data = new ArrayDataModel(users);
		}
		catch(Exception ex){
		}

		return data;		
	}
}
