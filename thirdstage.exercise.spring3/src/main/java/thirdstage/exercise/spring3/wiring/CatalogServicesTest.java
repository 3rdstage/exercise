package thirdstage.exercise.spring3.wiring;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration("/thirdstage/exercise/spring3/wiring/spring.xml")
public class CatalogServicesTest extends AbstractTestNGSpringContextTests {

	@Resource(name="catalogServices1")
	private CatalogServices catalogServices1;
	
	@Resource(name="catalogServices2")
	private CatalogServices catalogServices2;

	@Test
	public void testWiring1() {

		Assert.assertEquals(1, this.catalogServices1.findAllCategories().size());
		Assert.assertEquals(1, this.catalogServices1.findProductsByCategory("DSLR").size());
	}
	
	@Test
	public void testWiring2() {

		Assert.assertEquals(1, this.catalogServices2.findAllCategories().size());
		Assert.assertEquals(2, this.catalogServices2.findProductsByCategory("DSLR").size());
	}
}
