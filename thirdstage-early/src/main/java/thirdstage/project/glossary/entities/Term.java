
package thirdstage.project.glossary.entities;

import thirdstage.framework.mars.*;
/**
 *
 * @author 3rdstage
 * @hibernate.class table="Term"
 */
public class Term implements thirdstage.framework.mars.Persistable {
	
	
	private String id = null;
	private String name = null;
	private String nameInEng = null;
	private String description = null;
	
	/** Creates a new instance of Word */
	public Term(){
	}
	
	public Term(String id, String name, String nameInEng, String description){
		
		this.id = id;
		this.name = name;
		this.nameInEng = nameInEng;
		this.description = description;
	}
	
	/**
	 * @hibernate.id generator-class="assigned" column="id" unsaved-value="null"
	 */
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	
	/**
	 * @hibernate.property column="name" not-null="true" length="50"
	 */
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	/**
	 * @hibernate.property column="nameInEng" not-null="false" length="50"
	 */
	public String getNameInEng() { return this.nameInEng; }
	public void setNameInEng(String nameInEng) { this.nameInEng = nameInEng; }
	
	/**
	 * @hibernate.property column="description" not-null="false" length="4000"
	 */
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
}
