package thirdstage.exercise.jersey.spring3;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope;

public class Config {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public enum ItemMeta{
		
		/**
		 * The value is expected to be Spring resource location format
		 */
		BOOTSTRAP_LOG4J_CONFIG_LOCATION("bootstrap.log4jConfigLocation", null),
		
		/**
		 * The value is expected to be Spring resource location format
		 */
		BOOTSTRAP_SPRING_CONFIG_LOCATION("bootstrap.springConfigLocation", "classpath:thirdstage/exercise/jersey/spring3/spring-auto.xml"),
		
		/**
		 * The value should start with '/'
		 */
		ROOT_SERVLET_CONTEXT_PATH("rootServlet.contextPath", "/", "////.*"),
		
		ROOT_SERVLET_SESSION_ID("rootServlet.sessionId", "JERSEYSPRINGSESSIONID"),
		
		JERSEY_SERVLET_URL_PATTEN("jerseyServlet.urlPattern", "/api/*"),
		
		JERSEY_SERVLET_INIT_ORDER("jerseyServlet.initOrder", "2"),
		
		WEB_SERVER_THREAD_POOL_SIZE("webServer.threadPoolSize", "10"),
		
		WEB_SERVER_PORT("webServer.port", "80"),
		
		WEB_SERVER_MAX_IDLE_TIME("webServer.maxIdleTime", "900000"),
		
		UNKNOWN("N/A", null);
		
		private String name; 
		
		/**
		 * If there's no default value, this field is {@code null}
		 */
		private String defaultValue;
		
		private String constraint;
		
		private ItemMeta(@Nonnull String name, @Nullable String defaultValue){
			this.name = name;
			this.defaultValue = defaultValue;
		}
		
		private ItemMeta(@Nonnull String name, @Nullable String defaultValue, @Nullable String constraint){
			this(name, defaultValue);
			this.constraint = constraint;
		}
		
		public @Nonnull String getName(){ return this.name; }
		
		/**
		 * Gets default value for this item.
		 * If the config doesn't include this item, default value would be used.
		 * Retruns {@code null}, if there's no default value.
		 * 
		 * @return
		 */
		public @Nullable String getDefaultValue(){ return this.defaultValue; }
		
		/**
		 * Gets contraint for this item in regex format.
		 * Returns {@code null}, if there's no constrains for this item.
		 * 
		 */
		public @Nullable String getConstraint(){ return this.constraint; }
		
		@Override
		public String toString(){
			return this.name;
		}
		
	}
	
	private Properties props = null;

	protected Properties getProperties(){
		return this.props;
	}
	
	public Config(@Nonnull Properties props){
		this.props = props;
	}
	
	/**
	 * Gets the value for the specified item in string.
	 * Returns {@code null}, if this config doesn't contains the specified item
	 * and default value for the item is {@code null} or undefined.
	 * 
	 * @param meta
	 * @return
	 */
	public String getValue(@Nonnull ItemMeta meta){
		if(props == null) throw new IllegalStateException("This config is NOT correctly initialized.");
		if(meta == null) throw new IllegalArgumentException("The item to access is NOT specified.");
		
		return this.props.getProperty(meta.getName(), meta.getDefaultValue());
	}
	
	
	/**
	 * Gets the value for the specified item in string.
	 * Returns {@code null}, if this config doesn't contains the specified item
	 * and default value for the item is {@code null} or undefined.
	 * 
	 * @param meta
	 * @return the value for the specified item in integer.
	 * @throws NumberFormatException When the value for the specified item can't be correctly converted into integer,
	 * @see org.apache.commons.lang3.math.NumberUtils.createInteger(String str)
	 */
	public Integer getIntValue(@Nonnull ItemMeta meta){
		if(props == null) throw new IllegalStateException("This config is NOT correctly initialized.");
		if(meta == null) throw new IllegalArgumentException("The item to access is NOT specified.");
		
		String value = this.props.getProperty(meta.getName(), meta.getDefaultValue());
		
		return NumberUtils.createInteger(value);
	}
	

}
