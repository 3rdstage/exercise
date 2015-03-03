package thirdstage.exercise.dto.case6.test;

import junit.framework.Assert;

import org.testng.annotations.Test;

import thirdstage.exercise.dto.case6.FieldMeta;
import static thirdstage.exercise.dto.case6.FieldType.*;

public class FieldMetaTest {

	
	@Test
	public void a() {
		
		FieldMeta m1 = new FieldMeta("firstName", STRING);
		FieldMeta m2 = new FieldMeta("lastName", STRING);
		
		Assert.assertEquals(m1.getName(), "firstName");
		Assert.assertEquals(m1.getType(), STRING);
		Assert.assertEquals(m2.getName(), "lastName");
		Assert.assertEquals(m2.getType(), STRING);

	}
}
