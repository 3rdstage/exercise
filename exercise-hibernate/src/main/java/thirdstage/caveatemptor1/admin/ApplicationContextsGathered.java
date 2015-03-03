package thirdstage.caveatemptor1.admin;

public interface ApplicationContextsGathered {

	org.springframework.context.ApplicationContext getSpringContext();
	
	org.hibernate.cfg.Configuration getDefaultHibernateConfiguration();
	
	org.hibernate.cfg.Configuration getHibernateConfiguration(String name);
	
	
	
}
