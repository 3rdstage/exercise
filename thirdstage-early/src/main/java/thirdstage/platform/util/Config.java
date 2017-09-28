package thirdstage.platform.util;

import java.util.*;
import java.io.*;

/**
 * Handles the configuration stored in a file. The configuation file should be in
 * the java properties file format.
 *
 * @author Sang-Moon Oh
 * @version 1.1, 2002/03/15
 * @see java.util.Properties java.util.Properties
 * @since 2001/11/01
 */
public class Config {
	
	/**
	 * the canonical(minimal form of absolute) path of the file containing this
	 * configuration
	 */
	private String mFilePath = null;
	
	/**
	 * the set of properties in this configuration
	 */
	private Properties mProp = null;
	
	/**
	 * Constructs an object with specified configuration file. The file should be in a
	 * format of the java properties file.
	 *
	 * @param file the file containing this configuration
	 * @throws java.lang.Exception if the specified file is not found or cann't be
	 * accessed due to security
	 * @see java.util.Properties#load
	 */
	public Config(java.io.File file) throws Exception {
		
		this.mProp = new Properties();
		this.mProp.load(new FileInputStream(file));
		this.mFilePath = file.getCanonicalPath();
	}
	
	/**
	 * Gets names of all the properties in this configuration.
	 *
	 * @return an array of string for the names of all the properties in this
	 * configuration
	 */
	public String[] getPropertyNames() {
		//entirely modified to improve performance by Sang-Moon Oh at ver. 1.1
		
		/*
		ArrayList list = new ArrayList();
		Enumeration enum = this.mProp.propertyNames();
		 
		while(enum.hasMoreElements()) list.add(enum.nextElement());
		return (String[])(list.toArray(new String[]{""}));
		 */
		
		String[] names = new String[this.mProp.size()];
		Enumeration enums = this.mProp.propertyNames();
		
		for(int i = 0; enums.hasMoreElements(); i++) names[i] = (String)enums.nextElement();
		return names;
	}
	
	/**
	 * Gets value of the specified property from the runtime configuration of this
	 * application.
	 *
	 * @param name the name of the property to get
	 * @return the value of the specified property
	 * @throws java.util.NoSuchElementException if the specified property cann't be
	 * found in the runtime configuration of this application. Notes this is runtime
	 * exception.
	 */
	public String getPropertyValue(String name) throws NoSuchElementException {
		
		String value = this.mProp.getProperty(name);
		if(value == null) throw new NoSuchElementException("The specified property cann't be found in runtime configuration");
		return value;
	}
	
	/**
	 * Gets the canonical path(minimal form of absolute path) of the file containing
	 * this configuration.
	 *
	 * @return the canonical path of the file containing this configuration
	 */
	public String getFilePath() {
		
		return this.mFilePath;
	}
}
