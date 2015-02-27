package thirdstage.exercise.spring.transaction.case2.entities;

import java.util.ArrayList;
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
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(name="Company")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
@org.hibernate.annotations.AccessType("field")
public class Company{

	/**
	IMPORTANT Auto increment type or sequence for primary key
	
	Should preview the possibility and usefulness of adapting
	auto increment type primary key for MySQL and using sequence object
	for Oracle with plain JDBC, iBATIS SqlMap 2, or Hibernate 3 based
	persistency implementation strategy
	
	2008-08-28
	iBATIS and Hibernate support automatic primary key generation with
	their APIs. 
	SqlMapClient.insert method would return the generated 
	primary key object, so developers can use the generated primary key
	without additional query or code after insert.
	Hibernate would set the id of transient object during Session.save
	method. So developers can use getId method right after the save method.
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Basic
	@Column(name="name", unique=false)
	@Length(max=60)@NotNull
	private String name;
	
	@OneToMany(mappedBy="company",
			cascade={CascadeType.PERSIST},
			fetch=FetchType.EAGER)
	@ForeignKey(name="fk_company_1")
	@OrderBy("id")
	@org.hibernate.annotations.LazyCollection(LazyCollectionOption.FALSE)
	private List<Building> buildings = new ArrayList<Building>();

	@OneToMany(mappedBy="company",
			cascade={CascadeType.PERSIST},
			fetch=FetchType.LAZY)
	@ForeignKey(name="fk_company_2")
	@OrderBy("id")
	private List<Factory> factories = new ArrayList<Factory>();


	public Company(){}
	
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
	public List<Building> getBuildings(){
		return buildings;
	}
	public void setBuildings(List<Building> buildings){
		this.buildings = buildings;
	}
	public List<Factory> getFactories(){
		return factories;
	}
	public void setFactories(List<Factory> factories){
		this.factories = factories;
	}
	
	public void addBuilding(Building building){
		this.buildings.add(building);
		building.setCompany(this);
	}
	
	public void addFactory(Factory factory){
		this.factories.add(factory);
		factory.setCompany(this);
	}
	
	
}
