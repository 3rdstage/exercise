/**
 * 
 */
package thirdstage.exercise.javassist.case1;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.junit.Assert; 
import org.junit.Test;

import javassist.ClassPool;


/**
 * @author 3rdstage
 *
 */
public class ClassPoolTest {
	
	@Test
	public void testToString() throws Exception{
		
		ClassPool pool = ClassPool.getDefault();
		System.out.println(pool.toString());

		pool.appendSystemPath();
		System.out.println(pool.toString());
		
		pool.appendClassPath("/*");
		System.out.println(pool.toString());

		pool.importPackage("java.util");
		System.out.println(pool.toString());
		
		StringTokenizer st = new StringTokenizer(System.getProperty("java.class.path"), File.pathSeparator); 
		Set<String> classpath = new HashSet<String>();
		while(st.hasMoreElements()) classpath.add(st.nextToken());
		for(String element: classpath) pool.appendClassPath(element);
		System.out.println(pool.toString());
		
		
		Assert.assertTrue(true);
	}

}
