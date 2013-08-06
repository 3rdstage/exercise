/**
 * 
 */
package thirdstage.util.config.json;

import java.io.File;
import java.util.Iterator;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 3rdstage
 *
 */
public class DefaultConfigurationMetaLoader implements ConfigurationMetaLoader {

	// TODO(Sangmoon Oh, 2013-08-05) : Caching?
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final DefaultConfigurationMetaLoader instance = new DefaultConfigurationMetaLoader();
	
	public static DefaultConfigurationMetaLoader getInstance(){
		return instance;
	}
	
	private final ObjectMapper jsonMapper;
	 
	private DefaultConfigurationMetaLoader(){
		this.jsonMapper =  new ObjectMapper();
	}
	
	
	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.ConfigurationMetaLoader#load(java.lang.String)
	 */
	@Override
	public ConfigurationMeta load(@Nonnull String path) throws Exception{
		
		if(path == null){
			throw new IllegalArgumentException("The path shouldn't be null.");
		}
		
		File f = ResourceUtils.getFile(path);
		JsonNode nd = this.jsonMapper.readTree(f);
		
		String title = nd.get("title").asText();
		nd = nd.get("properties"); //parent node of subjects meta
		
		Iterator<String> names2 = nd.fieldNames();
		String name2 = null;
		String title2 = null;
		String desc2 = null;
		JsonNode props2 = null;
		String type2 = null;
		Iterator<String> names3 = null;
		String name3 = null;
		PropertyMeta<?> pm = null;
		while(names2.hasNext()){ //for each subject
			name2 = names2.next();
			title2 = nd.get(name2).get("title") != null ? 
					nd.get(name2).get("title").asText() : "";
			desc2 = nd.get(name2).get("description") != null ?
					nd.get(name2).get("description").asText() : "";
			
			//parent node of property meta
			props2 = nd.get(name2).get("properties"); 
			names3 = props2.fieldNames();
			while(names3.hasNext()){
				name3 = names3.next();
				pm = this.buildPropertyMeta(name3, props2.get(name3));
			}
			
		}
		return null;
	}

	
	private PropertyMeta<?> buildPropertyMeta(@Nonnull String name, @Nonnull JsonNode node){
		if(name == null) throw new IllegalArgumentException("");
		if(node == null) throw new IllegalArgumentException("");
		
		String type = node.get("type") != null ?
				node.get("type").asText() : "";
			
		//type member is mandatory for property 
		if(type.length() == 1){
			logger.error("Type should be defined for property meta of {}. (/properties/_subj_/properties/{})", name, name);
			throw new IllegalArgumentException(
				String.format("Type should be defined for property meta of %1$s. (/properties/_subj_/properties/%1$s)", name));
		}
		
		//max, min, max length, min length, enum, pattern, required, default, title, description
		//all of aboves are optional.
		
		Double max = node.get("maximum") != null ?
				node.get("maximum").asDouble() : null;
		Boolean exclusiveMax = node.get("exclusiveMaximum") != null ?
				node.get("exclusiveMaximum").asBoolean() : null;
		Double min = node.get("minimum") != null ?
				node.get("minimum").asDouble() : null;
		Boolean exclusiveMin = node.get("exclusiveMinimum") != null ?
				node.get("exclusiveMinimum").asBoolean() : null;
		Integer maxLen = node.get("maxLength") != null ?
				node.get("maxLength").asInt() : null;
		Integer minLen = node.get("minLength") != null ?
				node.get("minLength").asInt() : null;
		
		// TODO(Sangmoon Oh, 2013-08-05) : enum and default handling
				
		String pattern = node.get("pattern") != null ?
				node.get("pattern").asText() : null;
				
		Boolean required = node.get("required") != null ?
				node.get("required").asBoolean() : null;
		
		String title = node.get("title") != null ?
				node.get("title").asText() : name;
		String desc = node.get("description") != null ?
				node.get("description").asText() : "";				
		
		// TODO
		return PropertyMetaFactory.getInstance().createPropertyMeta(
				name, PropertyType.valueOfJsonType(type), title, desc, required, 
				max, exclusiveMax, min, exclusiveMin, 
				maxLen, minLen, null, pattern, null);
		
	}
}
