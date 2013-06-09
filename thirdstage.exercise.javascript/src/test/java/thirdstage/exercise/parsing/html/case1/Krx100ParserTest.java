package thirdstage.exercise.parsing.html.case1;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class Krx100ParserTest {
	@BeforeClass
	public void beforeClass() {
	}


	@Test
	public void testGetLatestItemsOfKrx100() throws Exception{

		Krx100Parser parser = new Krx100Parser();
		
		
		List<Krx100Item> items = parser.getLatestItemsOfKrx100();


	}
}
