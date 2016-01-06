package thirdstage.purple.config;

import java.util.Properties;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

public class ConfigurationAccessor {
	
	private ApplicationContext springContext;
	
	public ConfigurationAccessor(String springConfigClassPath){
		this.springContext = new ClassPathXmlApplicationContext(springConfigClassPath);
	}

	
	public Properties getHibernateProperties(String beanId){
		
		LocalSessionFactoryBean factoryBean = (LocalSessionFactoryBean)(this.springContext.getBean("&" + beanId));
		
		return factoryBean.getConfiguration().getProperties();
	}
	
	public String[] getAllHibernateEntityNames(String beanId){
		SessionFactory sessionFactory = (SessionFactory)(this.springContext.getBean(beanId));
		
		Set keys = sessionFactory.getAllClassMetadata().keySet();
		return (String[])(keys.toArray(new String[keys.size()])); 
	}
	
	public String[] getAllSpringBeanNames(){
		return this.springContext.getBeanDefinitionNames();
		
	}

}
