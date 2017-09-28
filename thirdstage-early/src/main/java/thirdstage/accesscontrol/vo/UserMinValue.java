/*
 * UserMinValue.java
 *
 * Created on 2005-03-11
 */

package thirdstage.accesscontrol.vo;

/**
 *
 * @author 3rdstage
 */
public class UserMinValue {
	
	private String id = "";
	private String name = "";
	
	/** Creates a new instance of UserMinValue */
	public UserMinValue() {
	}
	
	public UserMinValue(String id, String name){
		this.setId(id);
		this.setName(name);
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
