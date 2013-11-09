package thirdstage.project2.process;

/**
 *
 * @author 3rdstage
 * @version 0.9, 3rdstage, 2007-04-14
 * @version 0.7, 3rdstage, 2006-10-30
 * @since 2006-10-30
 */
public class ProcessMinValue implements java.io.Serializable{
	
	private Long no = null;
	private String id = null;
	private String name = null;
	
	
	/** Creates a new instance of ProcessMinValue */
	public ProcessMinValue() {
	}
	
	public Long getNo() { return no; }
	public void setNo(Long no) { this.no = no; }
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
}
