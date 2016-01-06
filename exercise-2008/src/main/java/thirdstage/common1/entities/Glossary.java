/**
 * 
 */
package thirdstage.common1.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;

/**
 * @author 3rdstage
 *
 */
@Entity
@Table(name = "Glossary")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
@org.hibernate.annotations.AccessType("field")
public class Glossary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Basic
	@Column(name="name", unique=false)
	@Length(max=50)@NotNull
	private String name;
	
	@Basic
	@Column(name="lang_code", unique=false, nullable=true)
	@Length(max=2)
	private String languageCode;
	
	@Basic
	@Column(name="descn", unique=false, nullable=true)
	@Length(max=500)
	private String description;
	
	@OneToMany(mappedBy="glossary",
		cascade={CascadeType.PERSIST}, fetch=FetchType.LAZY
	)
	@ForeignKey(name="fk_word_1")
	@OrderBy("id")
	@org.hibernate.annotations.LazyCollection(LazyCollectionOption.FALSE)
	private List<Word> words;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param languageCode the languageCode to set
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the words
	 */
	public List<Word> getWords() {
		return words;
	}

	/**
	 * @param words the words to set
	 */
	public void setWords(List<Word> words) {
		this.words = words;
	}
	
	
	public void addWord(Word word){
		this.words.add(word);
	}
	

}
