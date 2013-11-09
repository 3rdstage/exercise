/*
 * RiskValue.java
 *
 * Created on 2005-02-02
 */

package thirdstage.exercise.values;

/**
 *
 * @author 3rdstage
 */
public class RiskValue {
	
	private String projectName = null;
	private String auditType = null;
	private String projectStage = null;
	private String auditStartDate = null; //yyyyMMdd
	private String auditEndDate = null; //yyyyMMdd
	private String riskId = null; 
	private String riskType = null;
	private String riskTitle = null;
	private String deadline = null;
	private String scheduledDate = null;
	private String follower = null;
	private String completedDate = null;
	private String approvedDate = null;
	private String status = null;
	
	/** Creates a new instance of RiskValue */
	public RiskValue() {
	}
	
	public RiskValue(String prjName, String auditType, String prjStage, String auditStartDt, String auditEndDt,
			String riskId, String riskType, String riskTitle, String deadline, String scheduledDate,
			String follower, String completedDt, String approvedDate, String status){
		this.projectName = prjName;
		this.auditType = auditType;
		this.projectStage = prjStage;
		this.auditStartDate = auditStartDt;
		this.auditEndDate = auditEndDt;
		this.riskId = riskId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getAuditType() {
		return auditType;
	}
	
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	
	public String getProjectStage() {
		return projectStage;
	}
	
	public void setProjectStage(String projectStage) {
		this.projectStage = projectStage;
	}
	
	public String getAuditStartDate() {
		return auditStartDate;
	}
	
	public void setAuditStartDate(String auditStartDate) {
		this.auditStartDate = auditStartDate;
	}
	
	public String getAuditEndDate() {
		return auditEndDate;
	}
	
	public void setAuditEndDate(String auditEndDate) {
		this.auditEndDate = auditEndDate;
	}
	
	public String getRiskId() {
		return riskId;
	}
	
	public void setRiskId(String riskId) {
		this.riskId = riskId;
	}
	
	public String getRiskType() {
		return riskType;
	}
	
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	
	public String getRiskTitle() {
		return riskTitle;
	}
	
	public void setRiskTitle(String riskTitle) {
		this.riskTitle = riskTitle;
	}
	
	public String getDeadline() {
		return deadline;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public String getScheduledDate() {
		return scheduledDate;
	}
	
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	public String getFollower() {
		return follower;
	}
	
	public void setFollower(String follower) {
		this.follower = follower;
	}
	
	public String getCompletedDate() {
		return completedDate;
	}
	
	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}
	
	public String getApprovedDate() {
		return approvedDate;
	}
	
	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
