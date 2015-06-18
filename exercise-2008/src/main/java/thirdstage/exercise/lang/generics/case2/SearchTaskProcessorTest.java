/**
 *
 */
package thirdstage.exercise.lang.generics.case2;

import org.testng.annotations.Test;

import thirdstage.exercise.lang.generics.case2.bar.BarSearchTaskProcessor;

/**
 * @author 3rdstage
 *
 */
public class SearchTaskProcessorTest {

	@Test
	public void testSearchTaskProcessor1(){
		SearchTaskProcessor processor = null;

		processor = new BarSearchTaskProcessor();
		processor.process("", "", "", "", null);
	}

	@Test
	public void testBarSearchTaskProcessor1(){

		BarSearchTaskProcessor processor = new BarSearchTaskProcessor();

	}


}
