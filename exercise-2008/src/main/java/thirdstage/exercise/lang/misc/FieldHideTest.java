/**
 * 
 */
package thirdstage.exercise.lang.misc;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class FieldHideTest{

	@Test
	public void testFieldHide1(){
	
		Book book1 = new Book("Odyssey");
		
		Assert.assertNull(book1.getName());
	}
	
}

abstract class CreativeWork{
	
	private String name;
	
	public CreativeWork(String name){ this.name = name; }
	
}


class Book extends CreativeWork{
	private String name;
	
	public Book(String name){
		super(name);
	}
	
	public String getName(){ return this.name; }
}



