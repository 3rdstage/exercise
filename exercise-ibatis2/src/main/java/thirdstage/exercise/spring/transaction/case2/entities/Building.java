package thirdstage.exercise.spring.transaction.case2.entities;

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
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(name="Building")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
@org.hibernate.annotations.AccessType("field")
public class Building{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Basic
	@Column(name="name", nullable=false, unique=false)
	@Length(max=60)@NotNull
	private String name;
	
	@ManyToOne(cascade={}, fetch=FetchType.EAGER)
	@JoinColumn(name="companyId", unique=false)
	@NotNull
	private Company company;
	
	public Building(){}
	
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Company getCompany(){
		return company;
	}
	public void setCompany(Company company){
		this.company = company;
	}
	
	

}
