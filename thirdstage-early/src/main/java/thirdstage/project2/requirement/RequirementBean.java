package thirdstage.project2.requirement;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-09-16, 3rdstage
 * @since 2006-09-16
 *
 * @jsf.bean name="requirementBean2" scope="request"
 */
public class RequirementBean extends Requirement implements java.io.Serializable{

	private RequirementManager manager = null;

	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RequirementBean.class);

	/** Creates a new instance of RequirementBean */
	public RequirementBean() {
	}
	
	/**
	 * @jsf.managed-property name="requirementManager2" value="#{requirementManager}"
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
	
	public java.util.List<Requirement> getAll() throws Exception{
		logger.info("getAll method entered.");

		logger.info("getAll method leaving.");
		return this.getRequirementManager().getAllRequirement();
	}
	
}