package thirdstage.project3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Process")
@org.hibernate.annotations.AccessType("property")
public class Process{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false, insertable = true, updatable = true)
	private long id;

	@Column(name = "code", unique = true, nullable = false, insertable = true, updatable = true)
	private String code;

	@Column(name = "name", unique = false, nullable = false, insertable = true, updatable = true)
	private String name;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "parentProcessId", unique= false, nullable = true, insertable = true, updatable = true)
	private Process parentProcess;

	@Column(name = "description", unique = false, nullable = true, insertable = true, updatable = true)
	private String description;

	public Process(){

	}

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Process getParentProcess(){
		return parentProcess;
	}

	public void setParentProcess(Process parentProcess){
		this.parentProcess = parentProcess;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}

}
