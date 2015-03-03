package thirdstage.caveatemptor1.model.domain;

import java.util.List;


/**
 * @uml.dependency   supplier="thirdstage.caveatemptor1.model.domain.Item"
 */
public class Category {

	/**
	 * @uml.property  name="name"
	 */
	private String name = "";

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @uml.property   name="items"
	 * @uml.associationEnd   multiplicity="(0 -1)" ordering="true" inverse="categories:thirdstage.caveatemptor1.model.domain.Item"
	 */
	private List items;

	/** 
	 * Getter of the property <tt>items</tt>
	 * @return  Returns the items.
	 * @uml.property  name="items"
	 */
	public List getItems() {
		return items;
	}

	/** 
	 * Setter of the property <tt>items</tt>
	 * @param items  The items to set.
	 * @uml.property  name="items"
	 */
	public void setItems(List items) {
		this.items = items;
	}

	/**
	 * @uml.property   name="parentCategory"
	 * @uml.associationEnd   inverse="childCategories:thirdstage.caveatemptor1.model.domain.Category"
	 */
	private Category parentCategory;

	/** 
	 * Getter of the property <tt>parentCategory</tt>
	 * @return  Returns the parentCategory.
	 * @uml.property  name="parentCategory"
	 */
	public Category getParentCategory() {
		return parentCategory;
	}

	/** 
	 * Setter of the property <tt>parentCategory</tt>
	 * @param parentCategory  The parentCategory to set.
	 * @uml.property  name="parentCategory"
	 */
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	/**
	 * @uml.property   name="childCategories"
	 * @uml.associationEnd   multiplicity="(0 -1)" ordering="true" inverse="parentCategory:thirdstage.caveatemptor1.model.domain.Category"
	 */
	private List childCategories;

	/** 
	 * Getter of the property <tt>childCategories</tt>
	 * @return  Returns the childCategories.
	 * @uml.property  name="childCategories"
	 */
	public List getChildCategories() {
		return childCategories;
	}

	/** 
	 * Setter of the property <tt>childCategories</tt>
	 * @param childCategories  The childCategories to set.
	 * @uml.property  name="childCategories"
	 */
	public void setChildCategories(List childCategories) {
		this.childCategories = childCategories;
	}

}
