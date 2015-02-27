/*
 * ServiceLocator.java
 *
 * Created on 2005-03-04
 */

package thirdstage.platform.web;

import javax.naming.*;
import javax.sql.*;
/**
 *
 * @author 3rdstage
 */
public class ServiceLocator {
	
	private javax.naming.InitialContext initialCntx = null;
	private java.util.Map cache = null;
	private boolean isCacheEnabled = true;
	
	/** Creates a new instance of ServiceLocator */
	public ServiceLocator() throws javax.naming.NamingException {
		this.cache = java.util.Collections.synchronizedMap(new java.util.HashMap());
		this.initialCntx = new javax.naming.InitialContext();
		this.isCacheEnabled = true;
	}
	
	public ServiceLocator(boolean isCacheEnabled) throws javax.naming.NamingException {
		this.cache = java.util.Collections.synchronizedMap(new java.util.HashMap());
		this.initialCntx = new javax.naming.InitialContext();
		this.isCacheEnabled = isCacheEnabled;
	}

	public ServiceLocator(java.util.Properties props, boolean isCacheEnabled) throws javax.naming.NamingException, IllegalArgumentException{
		if(props == null) throw new IllegalArgumentException("the argument should not be null.");
		this.cache = java.util.Collections.synchronizedMap(new java.util.HashMap());
		this.initialCntx = new javax.naming.InitialContext(props);
		this.isCacheEnabled = isCacheEnabled;
	}

	public boolean isCacheEnabled(){ return this.isCacheEnabled; }
	
	public DataSource getDataSource(String name) throws NamingException, IllegalArgumentException{
		if(name == null || name.length() == 0){
			throw new IllegalArgumentException("the name argument should be neither null nor empty.");
		}
		
		DataSource ds = null;
		if(this.isCacheEnabled && this.cache.containsKey(name)){
			ds = (DataSource)(this.cache.get(name));
		}
		else{
			ds = (DataSource)(initialCntx.lookup(name));
			if(this.isCacheEnabled) this.cache.put(name, ds);
		}
		return ds;
	}
	
	public java.net.URL getURL(String name) throws NamingException, IllegalArgumentException{
		if(name == null || name.length() == 0){
			throw new IllegalArgumentException("the name argument should be neither null nor empty.");
		}

		java.net.URL url = null;
		if(this.isCacheEnabled && this.cache.containsKey(name)){
			url = (java.net.URL)(this.cache.get(name));
		}
		else{
			url = (java.net.URL)(initialCntx.lookup(name));
			if(this.isCacheEnabled) this.cache.put(name, url);
		}
		return url;
	}
	
	public boolean getBoolean(String name) throws NamingException, IllegalArgumentException{
		if(name == null || name.length() == 0){
			throw new IllegalArgumentException("the name argument should be neither null nor empty.");
		}
		
		Boolean value = null;
		if(this.isCacheEnabled && this.cache.containsKey(name)){
			value = (Boolean)(this.cache.get(name));
		}
		else{
			value = (Boolean)(initialCntx.lookup(name));
			if(this.isCacheEnabled) this.cache.put(name, value);
		}
		return value.booleanValue();
	}
	
	public String getString(String name) throws NamingException, IllegalArgumentException{
		if(name == null || name.length() == 0){
			throw new IllegalArgumentException("the name argument should be neither null nor empty.");
		}
		
		String str = null;
		if(this.isCacheEnabled && this.cache.containsKey(name)){
			str = (String)(this.cache.get(name));
		}
		else{
			str = (String)(initialCntx.lookup(name));
			if(this.isCacheEnabled) this.cache.put(name, str);
		}
		return str;
	}
	
}
