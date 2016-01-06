/**
 * 
 */
package thirdstage.exercise.lang.misc;

/**
 * @author 3rdstage
 *
 */
public class ClassLoaderTest{
	
	public static void main(String... args){
		
		ClassLoaderTest tester = new ClassLoaderTest();
		
		tester.reportAllFindableClassLoaders();
		
	}
	
	public void reportAllFindableClassLoaders(){
		
		ClassLoader cl1 = this.getClass().getClassLoader();
		System.out.println("The class loader from this.getClass().getClassLoader() is : " + cl1.toString());
		
		for(String child = null ; cl1.getParent() != null; ){
			child = cl1.toString();
			cl1 = cl1.getParent();
			System.out.println("The parent of " + child + " is : " + cl1.toString());
		}
	
		ClassLoader cl9 = this.getClass().getClassLoader().getSystemClassLoader();
		System.out.println("The system class loader is : " + cl9.toString());
		
		ClassLoader clth = Thread.currentThread().getContextClassLoader();
		System.out.println("The context class loader of current thread is : " + clth.toString());
		
	}

}
