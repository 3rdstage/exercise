
package thirdstage.exercise.spring.jsf.case1;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-08-07, 3rdstage
 * @since 2006-08-07
 *
 * @jsf.bean name="requirementBean" scope="request"
 */
public class RequirementBean extends Requirement implements java.io.Serializable{

	private RequirementManager manager = null;

	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RequirementBean.class);

	/** Creates a new instance of RequirementBean */
	public RequirementBean() {
	}
	
	/**
	 * @jsf.managed-property name="requirementManager" value="#{requirementManager}"
	 *
	 */
	public RequirementManager getRequirementManager(){
		return this.manager;
	}
	
	public void setRequirementManager(RequirementManager manager){
		this.manager = manager;
	}
	
	public void create() throws Exception{
		logger.info("ID : " + this.getId() + ", Title : " + this.getTitle());
		
		Requirement requirement = new Requirement();
		requirement.setId(this.getId());
		requirement.setTitle(this.getTitle());

		this.getRequirementManager().createRequirement(requirement);
	}
	
}
