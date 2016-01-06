/**
 * 
 */
package thirdstage.exercise.classloader;

/**
 * @author 3rdstage
 *
 */
public class SimplestClassLoader extends ClassLoader{
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException{
		//return this.findClass(name);
		
		
	    Class c = null;
	    try {
	        c = getParent().loadClass(name);
	    } catch (ClassNotFoundException e) {
	    }
	    if(c == null)
	        c = findClass(name);
	    return c;

	}

}
