package thirdstage.exercise.ejb3.catalog;

import java.io.Serializable;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1538696837622554822L;
	
	
	private String id;

	private String name;
	
	private String description;
	
	private Category parentCategory;
	
	/**
	 * 
	 */
	public Category() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the parentCategory
	 */
	public Category getParentCategory() {
		return parentCategory;
	}

	/**
	 * @param parentCategory the parentCategory to set
	 */
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}


	
	

}
