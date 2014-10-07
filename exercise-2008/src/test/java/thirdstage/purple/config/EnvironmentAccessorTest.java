/**
 * 
 */
package thirdstage.purple.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author 3rdstage
 * 
 */
public class EnvironmentAccessorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAll() throws Exception {

		EnvironmentAccessor accessor = new EnvironmentAccessor();

		System.out
				.println("\n\nEnvironment varialbes and their values >>>>>>>");
		accessor.printEnv(System.out);

		System.out.println("\n\nJVM's system properites >>>>>>>");
		accessor.printSystemProperties(System.out);

		System.out.println("\n\nAvailable locales >>>>>>>");
		accessor.printAvailableLocales(System.out);

		System.out.println("\n\nAvailable character-sets >>>>>>>");
		accessor.printAvailableCharsets(System.out);

		Assert.assertTrue(true);
	}

	@Test
	public void testCharset() throws Exception {

		List<String> names = new ArrayList<String>();

		names.add("euc-kr");
		names.add("EUC-KR");

		Charset charset = null;
		for (String name : names) {
			charset = Charset.forName(name);

			if (charset != null) {
				System.out.println(name + " : " + charset.toString());
			} else {
				System.out.println(name);
			}
		}
	}
}
