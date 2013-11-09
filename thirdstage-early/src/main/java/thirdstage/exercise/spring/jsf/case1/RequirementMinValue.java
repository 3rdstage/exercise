
package thirdstage.exercise.spring.jsf.case1;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-08-10, 3rdstage
 * @since 2006-08-10
 */
public class RequirementMinValue implements java.io.Serializable{
	
	private Long no = null;
	private String id = null;
	private String title = null; //제목

	/** Creates a new instance of RequirementMinValue */
	public RequirementMinValue() {
	}
	
	public Long getNo() { return no; }
	public void setNo(Long no) { this.no = no; }

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
}
