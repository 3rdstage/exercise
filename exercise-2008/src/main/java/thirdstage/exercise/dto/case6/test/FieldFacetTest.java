/**
 * 
 */
package thirdstage.exercise.dto.case6.test;

import junit.framework.Assert;

import org.testng.annotations.Test;

import thirdstage.exercise.dto.case6.FieldFacet;
import static thirdstage.exercise.dto.case6.FieldFacetType.*;

/**
 * @author 3rdstage
 *
 */
public class FieldFacetTest {
	
	@Test
	public void testLengthFacet(){
		
		FieldFacet f1 = new FieldFacet(LENGTH, 10);
		
		Assert.assertEquals(f1.getType(), LENGTH);
		Assert.assertEquals(f1.getValueType(), LENGTH.getValueType());
		Assert.assertEquals(f1.getValue(), 10);
	}
	
	@Test
	public void testPatternFacet(){
		
		FieldFacet f1 = new FieldFacet(PATTERN, "[a-zA-Z0-9]{3, 5}");
		
		Assert.assertEquals(f1.getType(), PATTERN);
		Assert.assertEquals(f1.getValueType(), PATTERN.getValueType());
		Assert.assertEquals(f1.getValueType(), f1.getValue().getClass());
		Assert.assertEquals(f1.getValue(), "[a-zA-Z0-9]{3, 5}");
	}
	
	@Test
	public void testEnumeration(){
		
		FieldFacet f1 = new FieldFacet(ENUM, new String[]{"Jan", "Feb", "Mar"});
		
		Assert.assertEquals(f1.getType(), ENUM);
		Assert.assertEquals(f1.getValueType(), ENUM.getValueType());
		Assert.assertNotSame(f1.getValueType(), f1.getValue().getClass());
		Assert.assertEquals(((String[])f1.getValue())[0], "Jan");		
		
	}
	
	
}
