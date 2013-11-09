/*
 * 
 *
 * Created on 2005-04-06
 */

package thirdstage.project.glossary.beans;

import thirdstage.framework.mars.Bean;
/**
 *
 * @author 3rdstage
 * @version 0.9, 2005-04-06
 * @since 2005-04-06
 *
 * @jsf.bean name="termBean"
 *           scope="request"
 */
public class TermBean implements thirdstage.framework.mars.Bean{
	
	private String id = null;
	private String name = null;
	private String nameInEng = null;
	private String description = null;
	
	/** Creates a new instance of TermNormalValue */
	public TermBean() {
	}
	
	public String getId() { return this.id; }
	
	public void setId(String id) { this.id = id; }
	
	public String getName() { return this.name; }
	
	public void setName(String name) { this.name = name; }
	
	public String getNameInEng() { return this.nameInEng; }
	
	public void setNameInEng(String nameInEng) { this.nameInEng = nameInEng; }
	
	public String getDescription() { return this.description; }
	
	public void setDescription(String description) { this.description = description; }
	
	
	public java.util.List searchByName(String name){
		return null;
	}
	
	public void add(){
		
		
	}
	
}
