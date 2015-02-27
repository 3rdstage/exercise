/**
 * 
 */
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
public class SpringOnlyLauncher {
	
	private static final String springConfigLoc = "classpath:thirdstage/exercise/jersey/spring3/spring-test.xml";
	
	public static void main(String[] args) throws Exception{
		
		ConfigurableApplicationContext springCntx = new GenericXmlApplicationContext(springConfigLoc);
		
		
		System.out.println("Press [Enter] key to start.");
		int cnt;
		while((cnt = System.in.available()) < 1){
			Thread.currentThread().sleep(500);
		}
		System.out.println("Ending the application");
	}

}
