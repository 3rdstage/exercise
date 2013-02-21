package thirdstage.common1.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(name="Word")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
@org.hibernate.annotations.AccessType("field")
public class Word {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(cascade={}, fetch=FetchType.EAGER)
	@JoinColumn(name="glossary_id", unique=false)
	@NotNull
	private Glossary glossary;
	
	@Basic
	@Column(name="name", unique=false)
	@Length(max=50) @NotNull
	private String name;
	
	
	@Basic
	@Column(name="short_descn", unique=false, nullable=true)
	@Length(max=300)
	private String shortDescription;
	
	@Basic
	@Column(name="full_descn", unique=false, nullable=true)
	@Length(max=2000)
	private String fullDescription;

	/**
	 * @return the id
	 */
	public long getId(){
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id){
		this.id = id;
	}

	/**
	 * @return the glossary
	 */
	public Glossary getGlossary(){
		return glossary;
	}

	/**
	 * @param glossary the glossary to set
	 */
	public void setGlossary(Glossary glossary){
		this.glossary = glossary;
	}

	/**
	 * @return the name
	 */
	public String getName(){
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * @return the shortDescription
	 */
	public String getShortDescription(){
		return shortDescription;
	}

	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription){
		this.shortDescription = shortDescription;
	}

	/**
	 * @return the fullDescription
	 */
	public String getFullDescription(){
		return fullDescription;
	}

	/**
	 * @param fullDescription the fullDescription to set
	 */
	public void setFullDescription(String fullDescription){
		this.fullDescription = fullDescription;
	}
	

}
