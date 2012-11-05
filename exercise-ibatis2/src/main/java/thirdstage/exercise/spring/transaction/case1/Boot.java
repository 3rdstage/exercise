package thirdstage.exercise.spring.transaction.case1;

import java.util.Properties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Boot{

	public static void main(String[] args) throws Exception{
		
		ApplicationContext cntx = new ClassPathXmlApplicationContext("spring-context-exercise.xml", Boot.class);
		FooService fooService = (FooService)(cntx.getBean("fooService"));
		
		Properties props = new Properties();
		props.load((new ClassPathResource("log4j-exercise.properties", Boot.class)).getInputStream());
		org.apache.log4j.PropertyConfigurator.configure(props);
		
		fooService.insertFoo(new Foo());
	}
	
}
