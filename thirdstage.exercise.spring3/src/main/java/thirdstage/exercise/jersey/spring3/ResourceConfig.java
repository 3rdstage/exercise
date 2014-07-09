package thirdstage.exercise.jersey.spring3;

import javax.ws.rs.core.Application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceConfig extends Application{
	
	private static ApplicationContext springContext;
	
	static{
		springContext = new ClassPathXmlApplicationContext("thirdstage/exercise/jersey/spring3/spring.xml");
		
	}
	
	
	@Override
	public java.util.Set<Object> getSingletons(){
	
		return null;
	}

}
