/**
 * 
 */
package thirdstage.util.config.json;

import java.io.File;

import javax.annotation.Nonnull;

import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 3rdstage
 *
 */
public class DefaultConfigurationMetaLoader implements ConfigurationMetaLoader {

	// TODO(Sangmoon Oh, 2013-08-05) : Caching?
	
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
		//JsonNode nd = this.jsonMapper.readTree(f);
		
		
		

		return null;
	}

}
