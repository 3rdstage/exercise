/**
 * 
 */
package thirdstage.exercise.resourcebundle;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javassist.ClassPool;
import javassist.NotFoundException;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;


/**
 * @author 3rdstage
 *
 */
public class ResourceBundleTest {
	
	@Test
	public void testCommonCommands() throws Exception{
		
		ResourceBundle rb = ResourceBundle.getBundle("thirdstage/exercise/resourcebundle/CommonCommands");
		Enumeration<String> keys = rb.getKeys();

		String key = null;
		Object val = null;
		int cnt = 0;
		System.out.printf("The commands in CommonCommands properties file with locale of %1$s.%n", 
				rb.getLocale());
		while(keys.hasMoreElements()){
			key = keys.nextElement();
			val = rb.getObject(key);
			
			if(val instanceof String){
				System.out.printf("  Key : %1$-10s, Value : %2$s%n", key, val);
			}
			cnt++;
		}
		System.out.println("");
		
		Assert.assertEquals(7, cnt);
		
		/*
		 * @important When no exact matching resource bundle is found with given locale, 
		 * default locale used before base. For more detail, refer javadoc of ResourceBundle class
		 */
		ResourceBundle rb2 = ResourceBundle.getBundle("thirdstage/exercise/resourcebundle/CommonCommands", Locale.CHINA);
		
		Assert.assertTrue(StringUtils
				.equals(rb2.getString("command.common.open"), rb.getString("command.common.open")));
		Assert.assertTrue(StringUtils
				.equals(rb2.getString("command.common.close"), rb.getString("command.common.close")));
		Assert.assertTrue(StringUtils
				.equals(rb2.getString("command.common.copy"), rb.getString("command.common.copy")));
		Assert.assertTrue(StringUtils
				.equals(rb2.getString("command.common.paste"), rb.getString("command.common.paste")));

		
		ResourceBundle rb3 = ResourceBundle.getBundle("thirdstage/exercise/resourcebundle/CommonCommands", Locale.US);
		
		keys = rb3.getKeys();
		cnt = 0;
		System.out.printf("The commands in CommonCommands properties file with locale of %1$s.%n", 
				rb3.getLocale());
		while(keys.hasMoreElements()){
			key = keys.nextElement();
			val = rb3.getObject(key);
			
			if(val instanceof String){
				System.out.printf("  Key : %1$-10s, Value : %2$s%n", key, val);
			}
			cnt++;
		}
		System.out.println("");
		
		Assert.assertEquals(9, cnt);
		
		/**
		 * @important The element that is contained only in other locale's resource bundle 
		 * but not in base resource bundle couldn't be shown to other locale even though
		 * the former locale is default one.  
		 */
		Assert.assertFalse(rb3.containsKey("options.common.boolean"));
		
		
	}
	
	
	@Test
	public void testResourceBundleInJar(){
		
		String dir = System.getProperty("user.dir");
		if(dir != null) dir = dir.replace('\\', '/');
				
		String path = dir + "/src/main/java/thirdstage/exercise/resourcebundle/resource-bundle.jar";
		
		System.out.printf("Path for Jar file is %1$s%n", path);
		
		try{
			addClassPath(new File(path));
		}
		catch(RuntimeException ex){
			Assume.assumeNoException(ex);
			ex.printStackTrace(System.out);
		}
		
		ResourceBundle rb = ResourceBundle.getBundle("thirdstage/exercise/resourcebundle/CommonWords");
		Enumeration<String> keys = rb.getKeys();
		
		System.out.printf("The commands in CommonWords properties file with locale of %1$s.%n", 
				Locale.getDefault());
		String key = null;
		Object val = null;
		int cnt = 0;
		while(keys.hasMoreElements()){
			key = keys.nextElement();
			val = rb.getObject(key);
			
			if(val instanceof String){
				System.out.printf("  Key : %1$-10s, Value : %2$s%n", key, val);
			}
			cnt++;
		}
		System.out.println("");
		
		Assert.assertEquals(12, cnt);
	}
	
	
	public static void addClassPath(File f){
		
		try{
			URLClassLoader sysloader = (URLClassLoader)(ClassLoader.getSystemClassLoader());
			Class<URLClassLoader> clazz = URLClassLoader.class;
		
			Method method = clazz.getDeclaredMethod("addURL", URL.class);
			method.setAccessible(true);
			method.invoke(sysloader, f.toURI().toURL());
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

}
