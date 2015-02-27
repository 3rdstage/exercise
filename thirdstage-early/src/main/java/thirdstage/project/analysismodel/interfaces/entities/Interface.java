
package thirdstage.project.analysismodel.interfaces.entities;

import thirdstage.framework.mars.Persistable;
/**
 *
 * @author 3rdstage
 * @version 1.0, 2005년 10월 20일 (목)
 * @since 2005년 10월 20일 (목)
 *
 * @hibernate.class table="Interface"
 */
public class Interface implements thirdstage.framework.mars.Persistable {
	
	private String id = null;
	
	/** Creates a new instance of Interface */
	public Interface() {
	}
	
	/**
	 * @hibernate.id generator-class="assigned" column="id" unsaved-value="null"
	 */
	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }
	
}
