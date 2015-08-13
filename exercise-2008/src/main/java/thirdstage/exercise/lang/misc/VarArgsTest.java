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
public class VarArgsTest {


	@Test
	public void testVariableArgs1(){

		int n1 = this.countArguments(1.0f, 1.0f, 1.0f);
		Assert.assertEquals(n1, 3);

		int n2 = this.countArguments();
		Assert.assertEquals(n2, 0);
	}

	public int countArguments(float... args){
		return args.length;
	}
}
