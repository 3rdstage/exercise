/**
 * 
 */
package thirdstage.exercise.jmx.spring.case1;

import java.util.Set;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * @author 3rdstage
 *
 */
/**
 * 
 */
public interface ComponentMetaRegistry2 {
	
	Set<String> getAllComponentIds();
	
	//This is operation, not attribute, 'cause it has parameter.
	
	ComponentMeta  getComponentMeta(String id);
	
	void boundComponentMeta(String id, ComponentMeta meta);

}
