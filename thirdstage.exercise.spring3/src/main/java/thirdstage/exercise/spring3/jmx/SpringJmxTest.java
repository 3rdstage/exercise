/**
 *
 */
package thirdstage.exercise.spring3.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author 3rdstage
 * @version
 * @since
 *
 */
public class SpringJmxTest {

	public static final String SPRING_CONF_LOC = "classpath:thirdstage/exercise/spring3/jmx/spring.xml";

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


	@Test
	public void testJmx1() throws Exception{

		//implicit default profile
		GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
		cntx.load(SPRING_CONF_LOC);
		cntx.refresh();

		MBeanServer mBeanServer = cntx.getBean("mBeanServer", MBeanServer.class);
		StorageAccessService service = cntx.getBean("storageAccessService",  StorageAccessService.class);

		Assert.assertNotNull(mBeanServer);
		Assert.assertNotNull(service);
		Assert.assertEquals(mBeanServer.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageProxyBuilder")), true);
		Assert.assertEquals(mBeanServer.isRegistered(
				new ObjectName(":type=bean,name=concurrentStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer.isRegistered(
				new ObjectName(":type=bean,name=incrementalStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageAccessService")), true);

		cntx.close();
		logger.info("The Spring container in default implicit profile has closed.");

		Assert.assertNotNull(mBeanServer);
		Assert.assertNotNull(service);
		Assert.assertEquals(mBeanServer.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer.isRegistered(
				new ObjectName(":type=bean,name=concurrentStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer.isRegistered(
				new ObjectName(":type=bean,name=incrementalStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageAccessService")), false);

		//'concurrent' profile
		GenericXmlApplicationContext cntx2 = new GenericXmlApplicationContext();
		String profile = "concurrent";
		cntx2.getEnvironment().setActiveProfiles(profile);
		cntx2.load(SPRING_CONF_LOC);
		cntx2.refresh();

		MBeanServer mBeanServer2 = cntx2.getBean("mBeanServer", MBeanServer.class);
		StorageAccessService service2 = cntx2.getBean("storageAccessService",  StorageAccessService.class);

		Assert.assertNotNull(mBeanServer2);
		Assert.assertSame(mBeanServer2, mBeanServer);
		Assert.assertNotNull(service2);
		Assert.assertNotSame(service2, service);
		Assert.assertEquals(mBeanServer2.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer2.isRegistered(
				new ObjectName(":type=bean,name=concurrentStorageProxyBuilder")), true);
		Assert.assertEquals(mBeanServer2.isRegistered(
				new ObjectName(":type=bean,name=incrementalStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer2.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageAccessService")), true);

		cntx2.close();
		logger.info("The Spring container in '{}' profile has closed.", profile);

		Assert.assertNotNull(mBeanServer2);
		Assert.assertNotNull(service2);
		Assert.assertEquals(mBeanServer2.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer2.isRegistered(
				new ObjectName(":type=bean,name=concurrentStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer2.isRegistered(
				new ObjectName(":type=bean,name=incrementalStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer2.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageAccessService")), false);

		//'concurrent' profile
		GenericXmlApplicationContext cntx3 = new GenericXmlApplicationContext();
		profile = "incremental";
		cntx3.getEnvironment().setActiveProfiles(profile);
		cntx3.load(SPRING_CONF_LOC);
		cntx3.refresh();

		MBeanServer mBeanServer3 = cntx3.getBean("mBeanServer", MBeanServer.class);
		StorageAccessService service3 = cntx3.getBean("storageAccessService",  StorageAccessService.class);

		Assert.assertNotNull(mBeanServer3);
		Assert.assertSame(mBeanServer3, mBeanServer);
		Assert.assertNotNull(service3);
		Assert.assertNotSame(service3, service2);
		Assert.assertEquals(mBeanServer3.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer3.isRegistered(
				new ObjectName(":type=bean,name=concurrentStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer3.isRegistered(
				new ObjectName(":type=bean,name=incrementalStorageProxyBuilder")), true);
		Assert.assertEquals(mBeanServer3.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageAccessService")), true);

		cntx3.close();
		logger.info("The Spring container in '{}' profile has closed.", profile);

		Assert.assertNotNull(mBeanServer3);
		Assert.assertNotNull(service3);
		Assert.assertEquals(mBeanServer3.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer3.isRegistered(
				new ObjectName(":type=bean,name=concurrentStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer3.isRegistered(
				new ObjectName(":type=bean,name=incrementalStorageProxyBuilder")), false);
		Assert.assertEquals(mBeanServer3.isRegistered(
				new ObjectName(":type=bean,name=defaultStorageAccessService")), false);

	}

}
