package thirdstage.exercise.reflection;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;


public class PrivateFieldAccessTest {

	@Test(expected=IllegalAccessException.class)
	public void testAccessPrivateField() throws Exception{

		Category cat1 = new Category("CAT0001", "Digital Camera");

		Class<Category> clazz1 = Category.class;
		//nameInCapital is private field and has no getter
		Field f1 = clazz1.getDeclaredField("nameInCapital");

		String str1 = (String)f1.get(cat1);

		System.out.printf("The name of category is %1$s%n", str1);

		Assert.assertEquals(cat1.getName().toUpperCase(), str1);		
	}

	
	@Test
	public void testAccessPrivateFieldAfterAccessEnabled() throws Exception{

		Category cat1 = new Category("CAT0001", "Digital Camera");

		Class<Category> clazz1 = Category.class;
		//nameInCapital is private field and has no getter
		Field f1 = clazz1.getDeclaredField("nameInCapital");

		//make private field accessible
		f1.setAccessible(true);
		
		String str1 = (String)f1.get(cat1);

		System.out.printf("The name of category is %1$s%n", str1);

		Assert.assertEquals(cat1.getName().toUpperCase(), str1);		
		
	}



}


