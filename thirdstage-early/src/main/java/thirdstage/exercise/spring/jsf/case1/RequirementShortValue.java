
package thirdstage.exercise.spring.jsf.case1;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-08-10, 3rdstage
 * @since 2006-08-10
 */
public class RequirementShortValue implements java.io.Serializable{

	private Long no = null;
	private String id = null;
	private String title = null; //제목
	private String source = null; //출처
	private String significance = null; //중요도
	private String status = null; //현재상태
	private java.util.Date requestedDate = null; //요청일
	
	/** Creates a new instance of RequirementShortValue */
	public RequirementShortValue() {
	}

	public Long getNo() { return no; }
	public void setNo(Long no) { this.no = no; }

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getSource() { return source; }
	public void setSource(String source) { this.source = source; }

	public String getSignificance() { return significance; }
	public void setSignificance(String significance) { this.significance = significance; }

	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }

	public java.util.Date getRequestedDate() { return requestedDate; }
	public void setRequestedDate(java.util.Date requestedDate) { this.requestedDate = requestedDate; }
}
