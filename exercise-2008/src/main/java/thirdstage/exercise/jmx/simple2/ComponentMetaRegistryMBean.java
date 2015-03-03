/**
 * 
 */
package thirdstage.exercise.jmx.simple2;

import java.util.List;
import java.util.Set;

/**
 * @author 3rdstage
 *
 */
public interface ComponentMetaRegistryMBean {
	
	
	/**
	 * The returned <code>Set</code> object is unmodifiable and
	 * snapshot of the component metas registered in the registry.
	 * 
	 * @return
	 */
	Set<String> findAllComponentIds(); //This is operation.
	
	Set<String> getAllComponentIds(); // This is attributes.
	
	ComponentMeta getComponentMeta(String id);


}
