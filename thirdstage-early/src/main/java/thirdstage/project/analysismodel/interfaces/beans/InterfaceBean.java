package thirdstage.project.analysismodel.interfaces.beans;

import thirdstage.framework.mars.*;
/**
 *
 * @author 3rdstage
 * @version 0.9, 3rdstge, 2005-10-18
 * @since 2005-10-18
 *
 * @jsf.bean name="interfaceBean"
 *           scope="request"
 */
public class InterfaceBean implements thirdstage.framework.mars.Bean{
	
	
	private String id = null;
	private String name = null;
	private String description = null;
	
	/**
     * Creates a new instance of InterfaceBean
     */
	public InterfaceBean() {
	}

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
	
}
