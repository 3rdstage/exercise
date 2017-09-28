package thirdstage.project2.process;

/**
 *
 * @author 3rdstage
 * @version 0.8, 3rdstage, 2007-04-14, Rename surrogate key to no and natural key to id which
 *          were id and extId respectively in prev. version. This became possible from 
 *          Hibernate 3.2.2.
 * @version 0.7, 3rdstage, 2006-10-27
 * @since 2006-10-27
 *  
 * @hibernate.class table="Process2" schema="project2"
 *
 */
public class Process {
	
	private Long no = null;
	private String id = null;
	private String name = null;
	private String description = null;
	private java.util.Date createdDate = null;
	
	private Process parentProcess = null;
	private Process[] childProcesses = null;
	
	
	/** Creates a new instance of Process */
	public Process() {
	}

	/**
	 * @hibernate.id generator-class="native" column="no" unsaved-value="null"
	 */
	public Long getNo() {	return this.no; }
	public void setNo(Long no) { this.no = no; }

	/**
	 * 
	 * 
	 * @hibernate.column name="id" length="50" not-null="true" unique="true"
	 *                   index="idx_process_1"
	 *                   comment="external(user defined) identifier for this process"
	 * @hibernate.property column="id" type="string"
	 */
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }

	/**
	 * @hibernate.property column="name" type="string"
	 * @hibernate.column name="name" length="200" not-null="true" unique="false"
	 *                   index="idx_process_2"
	 *                   comment="name of this process"
	 */
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	/**
	 * @hibernate.property column="description" type="string"
	 * @hibernate.column name="description" length="4000" not-null="false" unique="false"
	 *                   comment="description of this process"
	 */
	public String getDescription(){ return this.description; }
	public void setDescription(String desc){ this.description = desc; }

	/**
	 * @hibernate.property column="createdDate"
	 * @hibernate.column name="createdDate" not-null="false" unique="false"
	 *                   comment="created date in database for this process"
	 */
	public java.util.Date getCreatedDate() { return this.createdDate; }
	public void setCreatedDate(java.util.Date createdDate) { this.createdDate = createdDate; }
	
	/**
	 * @hibernate.many-to-one column="parentProcessId" 
	 *                        foreign-key="fk_process_1" 
	 *                        lazy="proxy"
	 * @hibernate.column name="parentProcessId" not-null="false" unique="false"
	 *                   comment="the next higher level process of this process"
	 */
	public Process getParentProcess() { return this.parentProcess; }
	public void setParentProcess(Process process){ this.parentProcess = process; }
	
	/**
	 * 
	 * 
	 * @hibernate.array inverse="true" cascade="save-update"
	 * @hibernate.collection-index column="id"
	 * @hibernate.collection-key column="parentProcessId"
	 * @hibernate.collection-one-to-many class="thirdstage.project2.process.Process"
	 */ 
	public Process[] getChildProcesses() { return this.childProcesses; }
	public void setChildProcesses(Process[] processes){ this.childProcesses = processes; }
	
	
	
	
	
}
