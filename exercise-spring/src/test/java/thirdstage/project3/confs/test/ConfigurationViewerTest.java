package thirdstage.project3.confs.test;

import static org.junit.Assert.*;
import java.util.Enumeration;
import java.util.Properties;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import thirdstage.project3.confs.ConfigurationViewer;

public class ConfigurationViewerTest{

	private ConfigurationViewer configViewer;

	@Before
	public void setUp(){
		configViewer = new ConfigurationViewer();
	}

	@Test
	public void testGetAllHibernateProperties(){

		Properties props = ConfigurationViewer.getHibernateProperties("hibernateSessionFactory");

		Enumeration names = props.propertyNames();
		String name = null;
		while(names.hasMoreElements()){
			name = (String)names.nextElement();
			
			if(name.startsWith("hibernate")){
				System.out.println(name + " = " + props.getProperty(name));
			}
		}
		
		//System.out.println(System.getProperty("hibernate.connection.release_mode"));

		assertTrue(props != null);

	}

}
