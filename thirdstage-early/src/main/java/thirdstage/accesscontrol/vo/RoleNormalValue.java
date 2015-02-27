/*
 * RoleNormalValue.java
 *
 * Created on 2005-02-21
 */

package thirdstage.accesscontrol.vo;

/**
 *
 * @author 3rdstage
 */
public class RoleNormalValue {
	
	private String id = "";
	private String name = "";
	private String description = "";
	
	/** Creates a new instance of RoleNormalValue */
	public RoleNormalValue() {
	}
	
	public RoleNormalValue(String id, String name, String desc){
		this.id = id;
		this.name = name;
		this.description = desc;
	}
	
	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }
	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name; }
	public String getDescription(){ return this.description; }
	public void setDescription(String desc){ this.description = desc; }
	
}
