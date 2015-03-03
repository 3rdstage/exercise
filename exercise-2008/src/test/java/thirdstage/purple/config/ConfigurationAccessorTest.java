package thirdstage.purple.config;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import thirdstage.purple.config.ConfigurationAccessor;

public class ConfigurationAccessorTest {

	private static ConfigurationAccessor configAccessor;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		configAccessor = new ConfigurationAccessor(
				"hibernate-common.cfg.oracle.xml/spring-caveatemptor.xml");

	}

	@Test
	public void testGetHibernateProperties() {
		Properties props = this.configAccessor
				.getHibernateProperties("defaultHibernateSessionFactory");

		// pros.list(System.out);
		Enumeration names = props.propertyNames();
		String name = null;

		System.out.println("");
		System.out.println("### Hibernate Properties ###");
		while (names.hasMoreElements()) {
			name = (String) names.nextElement();

			if (name.startsWith("hibernate")) {
				System.out.println(name + " = " + props.getProperty(name));
			}
		}

		assertTrue(true);
	}

	@Test
	public void testGetAllHibernateEntityNames() {
		String[] names = this.configAccessor
				.getAllHibernateEntityNames("defaultHibernateSessionFactory");

		System.out.println("");
		System.out.println("### Names of Entities in Hibernate ###");
		for (String name : names) {
			System.out.println(name);
		}

		assertTrue(true);
	}

	@Test
	public void testGetAllSpringBeanNames() {
		String[] names = this.configAccessor.getAllSpringBeanNames();

		System.out.println("");
		System.out.println("### Names of Beans in Spring ###");
		for (String name : names) {
			System.out.println(name);
		}

		assertTrue(true);
	}

}
