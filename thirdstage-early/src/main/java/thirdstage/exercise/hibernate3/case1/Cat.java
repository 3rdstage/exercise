/*
 * Cat.java
 *
 * Created on 2005-03-16
 */

package thirdstage.exercise.hibernate3.case1;



/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-03-16
 * @since 2005-03-16
 */
public class Cat {
	
	private String id = null;
	private String name = null;
	private char sex = 'm';
	private float weight = 0.0f;
	
	/** Creates a new instance of Cat */
	public Cat() {
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
	
	public char getSex() {
		return sex;
	}
	
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}
