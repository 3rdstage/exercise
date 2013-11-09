package thirdstage.project2.requirement;

/**
 * 
 * @author 3rdstage
 * @version 1.0, 2006-09-15, 3rdstage
 * @since 2006-09-15
 */
public interface RequirementManager {
	
	public void createRequirement(Requirement requirement) throws Exception;

	public void createRequirements(java.util.List<Requirement> requirements) throws Exception;
	
	public Requirement getRequirementById(String id) throws Exception;
	
	public java.util.List<RequirementMinValue> getAllRequirementInMinValue() throws Exception;
	
	public java.util.List<Requirement> getAllRequirement() throws Exception;
	
	public void modifyRequirement(Requirement requirement) throws Exception;
   
}
