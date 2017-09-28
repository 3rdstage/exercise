/*
 * RoleBean.java
 *
 * Created on 2005-02-17
 */

package thirdstage.accesscontrol.beans;
import java.io.Serializable;
import thirdstage.accesscontrol.vo.RoleMinValue;
import thirdstage.accesscontrol.vo.RoleNormalValue;

/**
 * @author 3rdstage
 */
public class RoleBean extends Object implements Serializable {
	
	public static final String OUTCOME_SUCCESS = "success";
	public static final String OUTCOME_FAILURE = "failure";
	
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserBean.class);
	
	protected String outcome = "";
	
	private String id = null;
	private String name = null;
	private String description = null;
	
	public RoleBean(){
		
	}
	
	public RoleBean(String id, String name){
		this.setId(id);
		this.setName(name);
	}
	
	public RoleBean(String id, String name, String desc){
		this.setId(id);
		this.setName(name);
		this.setDescription(desc);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public RoleNormalValue normalValue(){
		return new RoleNormalValue(this.getId(), this.getName(), this.getDescription());
	}
	
	public RoleMinValue minValue(){
		return new RoleMinValue(this.getId(), this.getName());
	}
	
	
	
	
}
