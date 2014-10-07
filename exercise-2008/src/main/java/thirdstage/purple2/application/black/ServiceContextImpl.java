/**
 * 
 */
package thirdstage.purple2.application.black;

import java.util.HashMap;
import java.util.Map;
import thirdstage.purple2.application.ServiceContext;

/**
 * @author 3rdstage
 *
 */
public class ServiceContextImpl implements ServiceContext{
	
	public static final String ATTR_KEY_FOR_LOGGING_CONTEXT = "__key.loggingContext";
	
	private Map<String, Object> attributes = new HashMap<String, Object>();

	/* (non-Javadoc)
	 * @see thirdstage.purple2.application.ServiceContext#getAttribute(java.lang.String)
	 */
	public Object getAttribute(String key){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.purple2.application.ServiceContext#setAttribute(java.lang.String, java.lang.Object)
	 */
	public void setAttribute(String key, Object attr){
	// TODO Auto-generated method stub

	}

}
