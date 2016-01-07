/**
 * 
 */
package thirdstage.exercise.jmx.simple3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author 3rdstage
 *
 */
public class ComponentMetaRegistryImpl implements ComponentMetaRegistry{
	
	private Map<String, ComponentMeta> componentMetas = new HashMap<String, ComponentMeta>();
	
	public ComponentMetaRegistryImpl(){
		
	}	

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple3.ComponentMetaRegistry#getAllComponentIds()
	 */
	@Override
	public Set<String> getAllComponentIds() {
		
		return this.componentMetas.keySet();
	
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple3.ComponentMetaRegistry#getComponentMeta(java.lang.String)
	 */
	@Override
	public ComponentMeta getComponentMeta(String id) {
		return this.componentMetas.get(id);
	}
	
	
	public void boundComponentMeta(String id, ComponentMeta meta){
		
		this.componentMetas.put(id, meta);
	}
	
	
	

}
