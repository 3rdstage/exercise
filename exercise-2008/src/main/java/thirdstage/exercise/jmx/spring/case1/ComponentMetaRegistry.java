/**
 * 
 */
package thirdstage.exercise.jmx.spring.case1;

import java.util.Set;


/**
 * @author 3rdstage
 *
 */
public interface ComponentMetaRegistry {

	Set<String> getAllComponentIds();
	
	//This is operation, not attribute, 'cause it has parameter.
	ComponentMeta  getComponentMeta(String id);
	
	void boundComponentMeta(String id, ComponentMeta meta);
	
}
