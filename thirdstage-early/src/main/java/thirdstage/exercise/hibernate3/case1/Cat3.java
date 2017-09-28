/*
 * Cat3.java
 *
 * Created on 2005-04-01
 */

package thirdstage.exercise.hibernate3.case1;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-04-01
 * @since 2005-04-01
 * @hibernate.class table="Cat3"
 */
public class Cat3 {
	
	private String id = null;
	private String name = null;
	private char sex = 'm';
	private float weight = 0.0f;
	
	/** Creates a new instance of Cat */
	public Cat3() {
	}
	
	/**
	 * @hibernate.id generator-class="assigned" column="id" length="32" unsaved-value="null"
	 */
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	/**
	 * @hibernate.property column="name" not-null="true" length="16"
	 */
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	/**
	 * @hibernate.property column="sex"
	 */
	public char getSex() { return sex; }
	public void setSex(char sex) { this.sex = sex; }
	
	/**
	 * @hibernate.property column="weight"
	 */
	public float getWeight() { return weight; }
	public void setWeight(float weight) { this.weight = weight;	}
	
}
