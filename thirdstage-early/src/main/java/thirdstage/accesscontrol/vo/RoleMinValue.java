/*
 * RoleValue.java
 *
 * Created on 2005-02-18
 */

package thirdstage.accesscontrol.vo;

/**
 *
 * @author 3rdstage
 */
public class RoleMinValue {
	
	private String id = "";
	private String name = "";
	
	/** Creates a new instance of RoleValue */
	public RoleMinValue() {
	}
	
	public RoleMinValue(String id, String name){
		this.id = id;
		this.name = name;
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
	
	
	
}
