/*
 * ServiceLocatorFactory.java
 *
 * Created on 2005-03-06
 */

package thirdstage.platform.web;

import javax.naming.NamingException;
/**
 *
 * @author 3rdstage
 */
public class ServiceLocatorFactory {
   
	private static ServiceLocatorFactory singleton = new ServiceLocatorFactory();
	
	private java.util.Map locators = null;
	
   /** Creates a new instance of ServiceLocatorFactory */
   private ServiceLocatorFactory() {
		try{
			locators = java.util.Collections.synchronizedMap(new java.util.HashMap());
		}
		catch(Exception ex){
			
		}
   }
   
	public static ServiceLocatorFactory getInstance(){
		return singleton;
	}
	
	/**
	 *
	 * @throws IllegalArgumentException if <code>key</code> value is <code>null</code> or empty string
	 * @throws IllegalStateException if this factory object doesn't include <code>ServiceLocator</code>
	 *         corresponding to the given <code>key</code>
	 */
	public ServiceLocator getServiceLocator(String key) throws IllegalArgumentException, IllegalStateException{
		if(key == null || key.length() == 0) throw new IllegalArgumentException("the key argument should be neither null nor empty.");
		
		if(!locators.containsKey(key)) throw new IllegalStateException("There's no service locator corresponding to the key of " + key);
		
		return (ServiceLocator)(locators.get(key));
	}
	
	/**
	 *
	 * @param key a identifier for the <code>ServiceLocator</code> instance to add
	 * @param props properties for the <code>ServiceLocator</code> instance to add
	 * @throws IllegalArgumentException if <code>key</code> value is <code>null</code> or empty string
	 * @throws IllegalStateException if this factory already include <code>ServiceLocator</code> 
	 *         corresponding to the given <code>key</code>
	 */
	public void putServiceLocator(String key, java.util.Properties props) throws IllegalArgumentException, IllegalStateException, NamingException{
		if(key == null || key.length() == 0) throw new IllegalArgumentException("the key argument should be neither null nor empty.");
		if(locators.containsKey(key)) throw new IllegalStateException("There's already service locator corresponding to the key of " + key);
		
		if(props != null)	locators.put(key, new ServiceLocator(props, true));
		else locators.put(key, new ServiceLocator(true));
	}
	
}
