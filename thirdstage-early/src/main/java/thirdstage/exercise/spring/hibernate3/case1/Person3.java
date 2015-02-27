

package thirdstage.exercise.spring.hibernate3.case1;

/**
 *
 * @author 3rdstage
 * @since 2006-07-06
 * 
 * @hibernate.class table="Person3"
 */
public class Person3 {
	
	private Long id = new Long(-1);
	private String name = null;
	private Integer weight = null;
	
	public Person3(){
		
	}
	/** Creates a new instance of Person2 */
	public Person3(String name, Integer weight) {
		this.name = name;
		this.weight = weight;
	}
	
	/**
	 * @hibernate.id column="id" type="long" unsaved-value="-1" generator-class="native"
	 */
	public Long getId(){ return this.id; }
	public void setId(Long id){ this.id = id; }
	
	/**
	 * @hibernate.property column="name" type="string" length="30" unique="false" not-null="true"
	 */
	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name; }
	
	/**
	 * @hibernate.property column="weight" type="integer" length="5" unique="false" not-null="false"
	 */
	public Integer getWeight(){ return this.weight; }
	public void setWeight(Integer weight){ this.weight = weight; }
	
	
	
}
