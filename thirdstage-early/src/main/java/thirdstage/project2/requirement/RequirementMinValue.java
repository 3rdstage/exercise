package thirdstage.project2.requirement;

/**
 *
 * @author 3rdstage
 * @version 1.1, 2006-10-27, 3rdstage, Add RequirementMinValue(Requirement) consturctor
 * @version 1.0, 2006-09-15, 3rdstage
 * @since 2006-09-15
 */
public class RequirementMinValue implements java.io.Serializable {
	
	private Long no = null;
	private String id = null;
	private String title = null;
	private java.util.Date requestedDate = null;
	
	/** Creates a new instance of RequirementMinValue */
	public RequirementMinValue() {
	}
	
	/**
	 * @since 1.1
	 */
	public RequirementMinValue(Requirement requirement){
		this.no = requirement.getNo();
		this.id = requirement.getId();
		this.title = requirement.getTitle();
		this.requestedDate = requirement.getRequestedDate();
	}

	public Long getNo() { return this.no; }

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public java.util.Date getRequestedDate() { return requestedDate; }
	public void setRequestedDate(java.util.Date requestedDate) { this.requestedDate = requestedDate; }
	
}
