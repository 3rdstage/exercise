package thirdstage.exercise.jersey.spring3;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import com.sun.jersey.spi.container.WebApplication;
import com.sun.jersey.spi.spring.container.SpringComponentProviderFactory;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

/**
 * @author 3rdstage
 *
 */
public class JerseySpringServlet extends SpringServlet{
	
	//@todo Find the way expose the loaded Spring context outside.
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static final String INIT_PARM_SPRING_CONFIG_LOCATION = "springConfigLocation";
	public static final String INIT_PARM_JMX_EXPORTER_BEAN_ID = "jmxExporterBeanId";
	
	@Override
	protected void initiate(com.sun.jersey.api.core.ResourceConfig rc, WebApplication wa){
		String location = "";
		String id = null;
		try{
			location = getWebConfig().getInitParameter(INIT_PARM_SPRING_CONFIG_LOCATION);
			
			final ConfigurableWebApplicationContext cntx = new XmlWebApplicationContext();
			cntx.setServletContext(getServletContext());
			cntx.setConfigLocation(location);
			cntx.refresh();
			
			wa.initiate(rc, new SpringComponentProviderFactory(rc, cntx));
			
		}catch(RuntimeException ex){
			logger.error("Fail to load Jersey-Spring servlet with " + location, ex);
			throw ex;
		}
	}

}
