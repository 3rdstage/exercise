package thirdstage.exercise.jersey.spring3;


import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class Application{
	
	protected static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) throws Exception{
		
		//load main configuration
		Properties config = new Properties();
		try{
			config.load(new FileInputStream(ResourceUtils.getFile("classpath:thirdstage/exercise/jersey/spring3/config.properties")));
			logger.info("Successfully loaded main configuration.");
		}catch(Exception ex){
			logger.error("Fail to start in early part", ex);
			throw ex;
		}
		
		//load log4j configuration
		String log4jConfigLoc = config.getProperty("bootstarp.log4jConfigLocation");
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
		
		sch.setContextPath("/");
		sch.getSessionHandler().getSessionManager().setSessionCookie("JERSEYWITHSPRINGID");
		
		ServletHolder dsh = sch.addServlet(DefaultServlet.class, "/");
		dsh.setInitOrder(1);
		
		ServletHolder jsh = new ServletHolder(JerseySpringServlet.class);
		jsh.setInitParameter(JerseySpringServlet.INIT_PARM_SPRING_CONFIG_LOCATION,
			"classpath:thirdstage/exercise/jersey/spring3/spring-auto.xml");
		jsh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature",
         "true");
		sch.addServlet(jsh, "/api/*");
		jsh.setInitOrder(2);
		
		Server jetty = new Server();
		HandlerList hl = new HandlerList();
		hl.addHandler(sch);
		jetty.setHandler(hl);
		jetty.setThreadPool(new QueuedThreadPool(10));
		
		SelectChannelConnector conn = new SelectChannelConnector();
		conn.setPort(8088);
		conn.setMaxIdleTime(900000);
		
		jetty.addConnector(conn);
		jetty.setStopAtShutdown(true);
		
		try{
			jetty.start();
			logger.info("Jetty started at port {} on {}", "8088", "127.0.0.1");
		}catch(Exception ex){
			logger.error("Fail to start Jetty.", ex);
			System.exit(-1);
		}

	}

}
