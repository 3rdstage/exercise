package thirdstage.exercise.hibernate3.case4;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-12-29, 3rdstage
 * @since 2005-12-29
 *
 * @hibernate.class table="Employer4"
 */
public class Employer {
	
	private Long id = null;
	private String name = null;
	
	
	/**
	 * Creates a new instance of Employer
	 */
	public Employer() {
	}
	
	/**
	 * @hibernate.id column="id" generator-class="native"
	 */
	public Long getId(){ return this.id; }
	public void setId(Long id){ this.id = id; }
	
	/**
	 * @hibernate.property column="name" type="string" length="60"
	 */
	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name;}
	
	
}
