/**
 * 
 */
package thirdstage.exercise.jmx.simple2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 3rdstage
 *
 */
public class ComponentMetaRegistry implements ComponentMetaRegistryMBean {

	private Map<String, ComponentMeta> componentMetas = new HashMap<String, ComponentMeta>();
	
	
	
	public ComponentMetaRegistry(){
		
	}

	
	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple2.ComponentMetaRegistryMBean#getComponentMeta(java.lang.String)
	 */
	public ComponentMeta getComponentMeta(String id) {
		return this.componentMetas.get(id);
	}
	
	@Override
	public Set<String> findAllComponentIds() {
		Set<String> ids = new HashSet<String>();
		
		for(String key : this.componentMetas.keySet()){
			ids.add(key);
		}

		return Collections.unmodifiableSet(ids);
		
		//return Collections.unmodifiableSet(this.componentMetas.keySet());
	
	}
	
	@Override
	public Set<String> getAllComponentIds(){ 
		return this.findAllComponentIds();
	}

	public void boundComponentMeta(String id, ComponentMeta meta){
		
		this.componentMetas.put(id, meta);
		
	}
	
}
