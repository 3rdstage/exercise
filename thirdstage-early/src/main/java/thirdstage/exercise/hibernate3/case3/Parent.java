package thirdstage.exercise.hibernate3.case3;

import java.util.Set;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-12-29, 3rdstage
 * @since 2005-12-29
 *
 * @hibernate.class table="Parent3"
 */
public class Parent {
	
	private String id = null;
	private Set children = null;
	
	/**
	 * Creates a new instance of Parent
	 */
	public Parent() {
	}
	
	/**
	 * @hibernate.id column="id" length="16" generator-class="assigned" unsaved-value="null"
	 */
	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }
	
	/**
	 * @hibernate.set inverse="true" 
	 *                lazy="true" 
	 *                cascade="all-delete-orphan"
	 * @hibernate.collection-one-to-many class="thirdstage.exercise.hibernate3.case3.Child"
	 * @hibernate.collection-key column="parentId"
	 */
	public Set getChildren(){ return this.children; }
	public void setChildren(Set children){ this.children = children; }
	
	
	public void addChild(Child child){
		child.setParent(this);
		children.add(child);
	}
	
}	
	
