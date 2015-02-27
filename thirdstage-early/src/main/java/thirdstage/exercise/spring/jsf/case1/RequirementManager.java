/*
 * RequirementManager.java
 *
 * Created on 2006년 8월 6일 (일), 오전 1:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package thirdstage.exercise.spring.jsf.case1;

/**
 *
 * @author 3rdstage
 */
public interface RequirementManager {
	
	public void createRequirement(Requirement requirement) throws Exception;

	public void createRequirements(java.util.List<Requirement> requirements) throws Exception;
	
	public Requirement getRequirement(String id) throws Exception;
	
	public java.util.List<Requirement> getAllRequirement() throws Exception;
	
	public java.util.List<RequirementMinValue> getAllRequirementInMinValue() throws Exception;
	
	public void modifyRequirement(Requirement requirement) throws Exception;
	
}
