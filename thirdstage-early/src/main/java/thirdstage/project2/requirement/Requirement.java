
package thirdstage.project2.requirement;

//import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/**
 *
 * @author 3rdstage
 * @since 2006-09-15
 *
 * @hibernate.class table="Requirement2" schema="project2"
 * @hibernate.query name="requirement.getRequirementById" query="from Requirement as req where req.id = :id"
 * @hibernate.query name="requirement.getAllRequirements" query="from Requirement"
 * 
 *
 */
public class Requirement implements java.io.Serializable{
	
	private Long no = null;
	private String id = null;
	private String title = null;
	private String request = null;
	private String response = null;
	private java.util.Date requestedDate = null;
	
	/** Creates a new instance of Requirement */
	public Requirement() {
	}
	
	public Requirement(String id, String title){
		this.id = id;
		this.title = title;
	}

	/**
	 *	@hibernate.id generator-class="native" column="no" length="16" unsaved-value="null"
	 */
	public Long getNo() { return this.no; }
	public void setNo(Long no){ this.no = no; }
	
	/**
	 * @hibernate.property column="id" type="string"
	 * @hibernate.column name="id" length="32" not-null="true" unique="true"
	 *                   comment="user-awared identifier for each requirement"
	 *                   index="idx_requirement_1"
	 */
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	/**
	 * @hibernate.property column="title" type="string"
	 * @hibernate.column name="title" length="100" not-null="true" unique="false"
	 *                   comment="the title for the requirement"
	 */
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	/**
	 * @hibernate.property column="request" type="string"
	 * @hibernate.column name="request" length="1000" not-null="false" unique="false"
	 *                   comment="the detail contents which customer demand"
	 */
	public String getRequest() { return request; }
	public void setRequest(String request) { this.request = request; }
	
	/**
	 * @hibernate.property column="response" type="string"
	 * @hibernate.column name="response" length="1000" not-null="false" unique="false"
	 *                   comment="the detail contents ..."
	 */
	public String getResponse() { return response; }
	public void setResponse(String response) { this.response = response; }
	
	/**
	 * @hibernate.property column="requestedDate"
	 * @hibernate.column name="requestedDate" not-null="false" unique="false"
	 */
	public java.util.Date getRequestedDate() { return requestedDate; }
	public void setRequestedDate(java.util.Date requestedDate) {	this.requestedDate = requestedDate; }
	
	
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(!(obj instanceof Requirement)) return false;
				
		if(!(this.getId().equals(((Requirement)obj).getId()))) return false;
		else return true;
	}
	
	public int hashCode(){
		return this.getId().hashCode();
	}
}
