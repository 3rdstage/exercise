package thirdstage.exercise.hibernate3.case5;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-12-30, 3rdstage
 * @since 2005-12-30
 *
 * @hibernate.class table="Employer5" comment="고용주"
 * @hibernate.mapping auto-import="false"
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
	 * @hibernate.id generator-class="native" column="id" type="long" unsaved-value="null"
	 */
	public Long getId(){ return this.id; }
	public void setId(Long id){ this.id = id; }
	
	/**
	 * @hibernate.property type="string"
	 * @hibernate.column name="name" length="60" not-null="false" unique="false" comment="고용주명"
	 */
	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name; }
	
	
}
