/**
 *
 */
package thirdstage.exercise.lang.misc;

import java.lang.reflect.Field;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class SystemTest {

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test(description="Loading a native library mutilple times.")
	public void testLoadLibrary1() throws Exception{

		String name = "kernel32";
		NativeLoader loader1 = new NativeLoader1(name);
		NativeLoader loader2 = new NativeLoader2(name);
		NativeLoader loader3 = new NativeLoader3(name);

		loader1.load();
		loader2.load();
		loader3.load();

		ClassLoader cl = this.getClass().getClassLoader();

		Field fld = ClassLoader.class.getDeclaredField("loadedLibraryNames");
		fld.setAccessible(true);

		List<String> names = (List<String>)fld.get(cl);
		int cnt = this.countElementsContaining(names, name);
		Assert.assertEquals(cnt, 1);

		names = (List<String>)fld.get(loader1.getClass().getClassLoader());
		cnt = this.countElementsContaining(names, name);
		Assert.assertEquals(cnt, 1);

		names = (List<String>)fld.get(loader2.getClass().getClassLoader());
		cnt = this.countElementsContaining(names, name);
		Assert.assertEquals(cnt, 1);

		names = (List<String>)fld.get(loader3.getClass().getClassLoader());
		cnt = this.countElementsContaining(names, name);
		Assert.assertEquals(cnt, 1);

		this.logger.info("Although calling System.loadLibrary in multiple times for the same native library, "
			+ "The file is cached into the ClassLoader just one time.");
	}

	private int countElementsContaining(List<String> list, String contained){
		int cnt = 0;
		for(String str: list){
			if(str.contains(contained)){ cnt++; }
		}
		return cnt;
	}

	public static interface NativeLoader{
		void load();
	}

	public static class NativeLoader1 implements NativeLoader{
		private final String name;

		public NativeLoader1(String name){ this.name = name; }
		@Override public void load(){ System.loadLibrary(name); }
	}

	public static class NativeLoader2 implements NativeLoader{
		private final String name;

		public NativeLoader2(String name){ this.name = name; }
		@Override public void load(){ System.loadLibrary(name); }
	}

	public static class NativeLoader3 implements NativeLoader{
		private final String name;

		public NativeLoader3(String name){ this.name = name; }
		@Override public void load(){ System.loadLibrary(name); }

	}
}
