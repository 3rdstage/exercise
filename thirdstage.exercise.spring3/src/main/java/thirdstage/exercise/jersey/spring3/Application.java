package thirdstage.exercise.jersey.spring3;


import java.io.FileInputStream;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.FilterMapping;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import thirdstage.exercise.jersey.spring3.Config.ItemMeta;

public class Application{
	
	protected static Logger logger = LoggerFactory.getLogger(Application.class);
	
	
	public static final String CONFIG_LOCATION_SYS_VAR = "bootstrap.configLocation";
	
	/**
	 * The value is expected to be Spring resource location format which can have prefix of
	 * "classpath:" or "file".
	 */
	public static final String CONFIG_LOCATION_DEFAULT = "classpath:thirdstage/exercise/jersey/spring3/config.properties";
	
	public static void main(String[] args) throws Exception{
		
		//load main configuration
		String configLoc = System.getProperty(CONFIG_LOCATION_SYS_VAR, CONFIG_LOCATION_DEFAULT);
		System.setProperty(CONFIG_LOCATION_SYS_VAR, configLoc);
		Properties configProps = new Properties();
		try{
			configProps.load(new FileInputStream(ResourceUtils.getFile(configLoc)));
			logger.info("Successfully loaded main configuration.");
		}catch(Exception ex){
			logger.error("Fail to start in early part", ex);
			throw ex;
		}
		Config config = new Config(configProps);
		
		//load log4j configuration
		//@todo review the effect and final configuration when -Dlog4j.properties is specified with command line
		String log4jConfigLoc = config.getValue(ItemMeta.BOOTSTRAP_LOG4J_CONFIG_LOCATION);
		if(log4jConfigLoc != null){
			Properties log4jConfig = new Properties();

			try{
				log4jConfig.load(new FileInputStream(ResourceUtils.getFile(log4jConfigLoc)));
				org.apache.log4j.LogManager.resetConfiguration();
				org.apache.log4j.PropertyConfigurator.configure(log4jConfig);  
				logger.info("Successfully loaded log4j configuration at {}", log4jConfigLoc);
			}catch(Exception ex){
				logger.error("Faile to load specified log4j configuration", ex);
				throw ex;
			}
		}
		
		ServletContextHandler sch = new ServletContextHandler(
			ServletContextHandler.SECURITY | ServletContextHandler.SESSIONS);
		
		sch.setContextPath(config.getValue(ItemMeta.ROOT_SERVLET_CONTEXT_PATH));
		sch.getSessionHandler().getSessionManager()
			.setSessionCookie(config.getValue(ItemMeta.ROOT_SERVLET_SESSION_ID));
		
		ServletHolder dsh = sch.addServlet(DefaultServlet.class, "/");
		dsh.setInitOrder(1);
		
		ServletHolder jsh = new ServletHolder(JerseySpringServlet.class);
		jsh.setInitParameter(JerseySpringServlet.INIT_PARM_SPRING_CONFIG_LOCATION,
			config.getValue(ItemMeta.BOOTSTRAP_SPRING_CONFIG_LOCATION));
		jsh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
		sch.addServlet(jsh, config.getValue(ItemMeta.JERSEY_SERVLET_URL_PATTEN));
		jsh.setInitOrder(config.getIntValue(ItemMeta.JERSEY_SERVLET_INIT_ORDER));
		
		FilterHolder fh = new FilterHolder(CrossOriginFilter.class);
		fh.setName("crossOriginFilter");
		fh.setInitParameter("allowedOrigins", "*");
		fh.setInitParameter("allowedMethods", "GET,PUT,POST,DELETE");
		fh.setInitParameter("allowedHeaders", "X-Requested-With, Content-Type, Accept, Origin, accept, x-requested-by");
		sch.addFilter(fh, "/*", FilterMapping.DEFAULT);
		
		Server jetty = new Server();
		HandlerList hl = new HandlerList();
		hl.addHandler(sch);
		jetty.setHandler(hl);
		jetty.setThreadPool(new QueuedThreadPool(config.getIntValue(ItemMeta.WEB_SERVER_THREAD_POOL_SIZE)));
		
		SelectChannelConnector conn = new SelectChannelConnector();
		conn.setPort(config.getIntValue(ItemMeta.WEB_SERVER_PORT));
		conn.setMaxIdleTime(config.getIntValue(ItemMeta.WEB_SERVER_MAX_IDLE_TIME));
		
		MBeanContainer mbc = new MBeanContainer(ManagementFactory.getPlatformMBeanServer());
		mbc.setDomain(config.getValue(ItemMeta.JMX_DOMAIN) + ".jetty");
		jetty.getContainer().addEventListener(mbc);
		jetty.addBean(mbc);
		
		jetty.addConnector(conn);
		jetty.setStopAtShutdown(true);
		
		try{
			jetty.start();
			logger.info("Jetty started at port {} on {}", conn.getPort(), "127.0.0.1");
		}catch(Exception ex){
			logger.error("Fail to start Jetty.", ex);
			System.exit(-1);
		}

	}

}
