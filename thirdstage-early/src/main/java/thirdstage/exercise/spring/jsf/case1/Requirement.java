
package thirdstage.exercise.spring.jsf.case1;

import javax.persistence.*;
/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-08-06, 3rdstage
 * @since 2006-08-06
 *
 * @hibernate.class table="Requirement1" schema="test"
 * @hibernate.query name="getAllRequirements" query="from Requirement"
 */
public class Requirement {
	
	private Long no = null;
	private String id = null;
	private String title = null; //제목
	private String request = null; //요구사항
	private String answer = null; //대응방안
	private String source = null; //출처
	private String significance = null; //중요도
	private String hardness = null; //난이도
	private String status = null; //현재상태
	private java.util.Date requestedDate = null; //요청일
	
	/** Creates a new instance of Requirement */
	public Requirement() {
	}

	/**
	 * @hibernate.id column="no" generator-class="native"
	 */
	public Long getNo() { return no; }
	public void setNo(Long no) { this.no = no; }

	/**
	 * @hibernate.property column="id" type="string"
	 * @hibernate.column name="id" sql-type="vachar" length="32" not-null="true" unique="true" index="idx_requirement1_1" comment="ID"
	 */
	public String getId() {	return id; }
	public void setId(String id) { this.id = id; }

	/**
	 * @hibernate.property column="title" length="250" not-null="true" unique="false"
	 */
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	/**
	 * @hibernate.property column="request" length="4000" not-null="false" unique="false"
	 */
	public String getRequest() { return request; }
	public void setRequest(String request) { this.request = request; }

	/**
	 * @hibernate.property column="answer" length="4000" not-null="false" unique="false"
	 */
	public String getAnswer() { return answer; }
	public void setAnswer(String answer) { this.answer = answer; }

	/**
	 * @hibernate.property column="source" length="50" not-null="false" unique="false"
	 */
	public String getSource() { return source; }
	public void setSource(String source) { this.source = source; }

	/**
	 * @hibernate.property column="significanceCode" length="10" not-null="false" unique="false" comment="중요도"
	 */
	public String getSignificance() { return significance; }
	public void setSignificance(String significance) { this.significance = significance; }

	/**
	 * @hibernate.property column="hardnessCode" length="10" not-null="false" unique="false" comment="난이도"
	 */
	public String getHardness() { return hardness; }
	public void setHardness(String hardness) { this.hardness = hardness; }

	/**
	 * @hibernate.property column="statusCode" length="10" not-null="false" unique="false" comment="상태"
	 */
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }

	/**
	 * @hibernate.property column="requestedDate" not-null="false" unique="false" comment="요청일"
	 */
	public java.util.Date getRequestedDate() { return requestedDate; }
	public void setRequestedDate(java.util.Date requestedDate) { this.requestedDate = requestedDate; }
	
}
