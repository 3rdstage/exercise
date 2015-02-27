package thirdstage.exercise.hibernate3.case3;

/**
 *
 * @author 3rdstage
 * @version 1.0, 200-12-29, 3rdstage
 * @since 2005-12-29
 *
 * @hibernate.class table="Child3"
 */
public class Child {
	
	private String id = null;
	private Parent parent = null;
	
	/**
	 * Creates a new instance of Child
	 */
	public Child() {
	}
	
	/**
	 * @hibernate.id column="id" length="16" generator-class="assigned" unsaved-value="null"
	 */
	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }
	
	
	/**
	 * @hibernate.many-to-one column="parentId" 
	 *                        foreign-key="fk_child_1" 
	 *                        cascade="save-update"
	 *                        not-null="true" 
	 */
	public Parent getParent(){ return this.parent; }
	public void setParent(Parent parent){ this.parent = parent; }
	
	
	
	
	
	
}
