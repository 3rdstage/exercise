/**
 * 
 */
package thirdstage.exercise.dto.case5;

import org.junit.Test;


/**
 * @author 3rdstage
 *
 */
public class PackageTest {
	
	@Test 
	public void testFieldType1(){
		
		FieldType<Integer> type = FieldType.INTEGER;
		System.out.printf("Name : %1$s, Simple Name : %2$s%n", type.getName(), type.getSimpleName());
		System.out.printf("%n");
	}

}
