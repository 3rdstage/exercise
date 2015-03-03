/**
 * 
 */
package thirdstage.util.config.json;

import javax.annotation.concurrent.ThreadSafe;

/**
 * @author 3rdstage
 *
 */
@ThreadSafe
public interface ConfigurationMetaLoader {
	
	public ConfigurationMeta load(String path) throws Exception;

}
