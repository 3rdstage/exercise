package thirdstage.project3.confs;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.toplink.LocalSessionFactory;
/**
 * This class is stateless
 * 
 * @author 3rdstage
 *
 */
public class ConfigurationViewer{
	
	
	private static ApplicationContext springContext;
	
	static{
		springContext = new ClassPathXmlApplicationContext("thirdstage/project3/confs/spring-project3-daos.xml");
		
	}
	
	public ConfigurationViewer(){}
	
	public static Properties getHibernateProperties(String beanId){
		
		LocalSessionFactoryBean factoryBean = (LocalSessionFactoryBean)(springContext.getBean("&" + beanId));
		
		return factoryBean.getConfiguration().getProperties();
		
	}
	
	

}
