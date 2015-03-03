/*
 * TermNormalValue.java
 *
 * Created on 2005-04-18
 */

package thirdstage.project.glossary.values;

/**
 *
 * @author 3rdstage
 */
public class TermNormalValue implements java.io.Serializable {
	
	private String id = null;
	private String name = null;
	private String nameInEng = null;
	private String description = null;
	
	/** Creates a new instance of TermNormalValue */
	public TermNormalValue() {
	}
	
	public TermNormalValue(String id, String name, String nameInEng, String description){
		
		this.id = id;
		this.name = name;
		this.nameInEng = nameInEng;
		this.description = description;
	}
	
	public String getId() { return this.id; }
	
	public void setId(String id) { this.id = id; }
	
	public String getName() { return this.name; }
	
	public void setName(String name) { this.name = name; }
	
	public String getNameInEng() { return this.nameInEng; }
	
	public void setNameInEng(String nameInEng) { this.nameInEng = nameInEng; }
	
	public String getDescription() { return this.description; }
	
	public void setDescription(String description) { this.description = description; }
	
	
	
}
