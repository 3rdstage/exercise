/**
 * 
 */
package thirdstage.exercise.jmx.spring.case1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
@ManagedResource(objectName="thirdstage.exercie:type=ComponentMetaRegistry2")
public class ComponentMetaRegistry2Impl implements ComponentMetaRegistry2{

	private Map<String, ComponentMeta> componentMetas = new HashMap<String, ComponentMeta>();
	
	public ComponentMetaRegistry2Impl(){
		
	}	

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple3.ComponentMetaRegistry#getAllComponentIds()
	 */
	@Override
	@ManagedAttribute
	public Set<String> getAllComponentIds() {
		
		Set<String> keys = new HashSet<String>();
		
		for(String key : this.componentMetas.keySet()){
			keys.add(key);
		}
		
		
		return keys;
	
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple3.ComponentMetaRegistry#getComponentMeta(java.lang.String)
	 */
	@Override
	@ManagedOperation
	@ManagedOperationParameters({@ManagedOperationParameter(name="id", description="ID of component to find")})
	public ComponentMeta getComponentMeta(String id) {
		return this.componentMetas.get(id);
	}
	
	@Override
	public void boundComponentMeta(String id, ComponentMeta meta){
		
		this.componentMetas.put(id, meta);
	}
		
	
}
