package thirdstage.exercise.spring.transaction.case2.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "industry")
@Check(constraints = "parentId != id")
public class Industry{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Basic
	@Column(name = "name", unique = false)
	@Length(max = 50)
	@NotNull
	private String name;

	@Basic
	@Column(name = "descn", unique = false)
	@Length(max = 1000)
	private String description;

	@ManyToOne
	@JoinColumn(name = "parentId")
	@ForeignKey(name = "fk_industry_1")
	private Industry parent;

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public Industry getParent(){
		return parent;
	}

	public void setParent(Industry parent){
		this.parent = parent;
	}

}
