/*
 * Cat2.java
 *
 * Created on 2005-03-29
 */

package thirdstage.exercise.hibernate3.case1;

import javax.persistence.*;

/**
 * Sample class for Hibernate 3 Annotation(!!). This class require JDK 1.5 or higher
 * 
 * 
 * @author 3rdstage
 * @version 1.0, 2005-03-29
 * @since 2005-03-29
 */
@Entity
@Table(name="Cat3")
public class Cat2 implements java.io.Serializable {

	private String id = null;
	private String name = null;
	private char sex = 'M';
	private float weight = 0.0f;
	
	/** Creates a new instance of Cat2 */
	public Cat2() {
	}
	
	@Id
	@Column(name="id")
	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }
	
	@Basic
	@Column(name="name")
	public String getName(){ return name; }
	public void setName(String name) { this.name = name; }

	@Basic
	@Column(name="sex")
	public char getSex() { return sex; }
	public void setSex(char sex) { this.sex = sex; }

	@Basic
	@Column(name="weight")
	public float getWeight() { return weight; }
	public void setWeight(float weight) { this.weight = weight; }
	
}
