/**
 * 
 */
package thirdstage.exercise.mybatis.dtd;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.xml.parsers.DocumentBuilderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author 3rdstage
 * @version
 * @since
 *
 */
public class SpringMybatisLauncher{

	public static void main(String[] args) throws Exception{
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		dbf.setValidating(false);
		dbf.setNamespaceAware(true);
		dbf.setFeature("http://xml.org/sax/features/namespaces", false);
		dbf.setFeature("http://xml.org/sax/features/validation", false);
		dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
		dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);


		String springConfigLocation = "classpath:thirdstage/exercise/mybatis/dtd/spring.xml";
		ConfigurableApplicationContext springContext 
			= new GenericXmlApplicationContext(springConfigLocation);

		System.out.println("The Spring context is being loaded. Press [Enter] key to unload it and finish this application.");
		int cnt;
		while((cnt = System.in.available()) < 1){
			Thread.currentThread().sleep(500);
		}

	}		
}
