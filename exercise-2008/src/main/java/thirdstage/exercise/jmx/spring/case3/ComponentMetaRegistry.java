/**
 * 
 */
package thirdstage.exercise.jmx.spring.case3;

import java.util.Set;

import javax.management.MXBean;

/**
 * My first MXBean exercise.
 * 
 * @author 3rdstage
 * @version 1.0, 2010-12-24
 */
@MXBean(true)
public interface ComponentMetaRegistry {
	
	Set<String> getAllComponentIds();
	
	//This is operation, not attribute, 'cause it has parameter.
	ComponentMeta  getComponentMeta(String id);

}
