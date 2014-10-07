package thirdstage.exercise.dto.case6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

public class FieldMeta {
	
	private String name;
	
	private FieldType type;
	
	private String description = "";
	
	private Map<FieldFacetType, FieldFacet>	facets = new HashMap<FieldFacetType, FieldFacet>();
	
	/**
	 * To accept the extra properties more than general ones such as
	 * name, type, description or standard facets.  
	 */
	private Map<String, Object> properties;
	
	public FieldMeta(){
		
	}
	
	public FieldMeta(String name, FieldType type){
		this.name = name;
		this.type = type;
	}
	
	public FieldMeta(String name, FieldType type, String desc){
		this(name, type);
		this.description = desc;
	}

	@NotNull
	public String getName(){
		return this.name; 
	}

	@NotNull
	public FieldType getType(){
		return this.type;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	/**
	 * 
	 * @return
	 */
	@NotNull
	public Map<FieldFacetType, FieldFacet> getFacets(){
		//TODO(Sangmoon Oh): Maket the returned Map object unmodifiable
		
		return this.facets;
	}
	

	/**
	 * Field can have at most one facet for each type.
	 * If the type of specified <code>facet</code> is already included before 
	 * and specified not to <code>override</code>, exception would occurr.
	 * 
	 * @param facet
	 * @param override
	 * @throw IllegalArgumentException
	 */
	public void addFacet(FieldFacet facet, boolean override){
		//TODO(Sangmoon Oh) consider not all field types can have all the facet types.
		//In other word, each field type have only part of facet types.
		//For example, INTEGER field can not have LENGTH facet. 
		
		
		if(this.facets.containsKey(facet.getType()) && !override){
			throw new IllegalArgumentException("The specified facet is already added");
		}
		else{
			this.facets.put(facet.getType(), facet);
		}
	}
	
	//@Nullable
	public Map<String, Object> getProperties(){
		return this.properties;
	}
	
	public void setProperties(Map<String, Object> props){
		this.properties = props;
	}

}
