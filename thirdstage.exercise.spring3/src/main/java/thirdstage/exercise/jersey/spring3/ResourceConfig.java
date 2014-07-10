package thirdstage.exercise.jersey.spring3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.core.Application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 

public class ResourceConfig extends Application{
	
	
	@Override
	public java.util.Set<Object> getSingletons(){
		
		ApplicationContext springContext = new ClassPathXmlApplicationContext("thirdstage/exercise/jersey/spring3/spring.xml");
		
		Map<String, Object> resources = springContext.getBeansWithAnnotation(javax.ws.rs.Path.class);
		Set<Object> result = new HashSet<Object>();
		for(Object resource: resources.values()){
			result.add(resource);
		}
		return result;
	}

}
