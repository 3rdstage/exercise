/**
 *
 */
package thirdstage.exercise.spring3.profile;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author 3rdstage
 * @version
 * @since 2015-09-21
 *
 */
public class SpringProfileTest {

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	private final String springConfLoc1 = "classpath:thirdstage/exercise/spring3/profile/spring1.xml";
	private final String springConfLoc2 = "classpath:thirdstage/exercise/spring3/profile/spring2.xml";
	private final String springConfLoc3 = "classpath:thirdstage/exercise/spring3/profile/spring3.xml";

	@Test
	public void testProfile1(){

		//implicit default profile
		GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
		cntx.getEnvironment().setActiveProfiles("dev");
		cntx.load(springConfLoc1);
		cntx.refresh();
		AccessManager am = cntx.getBean("accessManager", AccessManager.class);
		Assert.assertTrue(am instanceof FreeAccessManager);

		//'qa' profile
		cntx = new GenericXmlApplicationContext();
		cntx.getEnvironment().setActiveProfiles("qa");
		cntx.load(springConfLoc1);
		cntx.refresh();
		am = cntx.getBean("accessManager", AccessManager.class);
		Assert.assertTrue(am instanceof PasswordAccessManager);

		//'production' profile
		cntx = new GenericXmlApplicationContext();
		cntx.getEnvironment().setActiveProfiles("production");
		cntx.load(springConfLoc1);
		cntx.refresh();
		am = cntx.getBean("accessManager", AccessManager.class);
		Assert.assertTrue(am instanceof SslAccessManager);
	}

	@Test(description="Nested beans element without profile attribute is activated in all profiles including implicit default profile.")
	public void testProfile2(){

		//implicit default profile
		GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
		cntx.load(springConfLoc2);
		cntx.refresh();
		Assert.assertEquals(cntx.containsBean("freeAccessManager"), true);
		Assert.assertTrue(cntx.getBean("freeAccessManager", AccessManager.class)
				instanceof FreeAccessManager);
		Assert.assertEquals(cntx.containsBean("secureAccessManager"), false);
		cntx.close();

		//'qa' profile
		cntx = new GenericXmlApplicationContext();
		cntx.getEnvironment().setActiveProfiles("qa");
		cntx.load(springConfLoc2);
		cntx.refresh();
		Assert.assertEquals(cntx.containsBean("freeAccessManager"), true); //still contains freeAccessManager
		Assert.assertTrue(cntx.getBean("freeAccessManager", AccessManager.class)
				instanceof FreeAccessManager);
		Assert.assertEquals(cntx.containsBean("secureAccessManager"), true);
		Assert.assertTrue(cntx.getBean("secureAccessManager", AccessManager.class)
				instanceof PasswordAccessManager);
		cntx.close();

		//'production' profile
		cntx = new GenericXmlApplicationContext();
		cntx.getEnvironment().setActiveProfiles("production");
		cntx.load(springConfLoc2);
		cntx.refresh();
		Assert.assertEquals(cntx.containsBean("freeAccessManager"), true); //still contains freeAccessManager
		Assert.assertTrue(cntx.getBean("freeAccessManager", AccessManager.class)
				instanceof FreeAccessManager);
		Assert.assertEquals(cntx.containsBean("secureAccessManager"), true);
		Assert.assertTrue(cntx.getBean("secureAccessManager", AccessManager.class)
				instanceof SslAccessManager);
		cntx.close();
	}

	@Test(description="Nested beans element whose profile is 'default' is activated for only implicit default profile.")
	public void testProfile3(){

		//implicit default profile
		GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
		cntx.load(springConfLoc3);
		cntx.refresh();
		Assert.assertEquals(cntx.containsBean("freeAccessManager"), true);
		Assert.assertTrue(cntx.getBean("freeAccessManager", AccessManager.class)
				instanceof FreeAccessManager);
		Assert.assertEquals(cntx.containsBean("secureAccessManager"), false);
		cntx.close();

		//'qa' profile
		cntx = new GenericXmlApplicationContext();
		cntx.getEnvironment().setActiveProfiles("qa");
		cntx.load(springConfLoc3);
		cntx.refresh();
		Assert.assertEquals(cntx.containsBean("freeAccessManager"), false);
		Assert.assertEquals(cntx.containsBean("secureAccessManager"), true);
		Assert.assertTrue(cntx.getBean("secureAccessManager", AccessManager.class)
				instanceof PasswordAccessManager);
		cntx.close();

		//'production' profile
		cntx = new GenericXmlApplicationContext();
		cntx.getEnvironment().setActiveProfiles("production");
		cntx.load(springConfLoc3);
		cntx.refresh();
		Assert.assertEquals(cntx.containsBean("freeAccessManager"), false);
		Assert.assertEquals(cntx.containsBean("secureAccessManager"), true);
		Assert.assertTrue(cntx.getBean("secureAccessManager", AccessManager.class)
				instanceof SslAccessManager);
		cntx.close();
	}
}
