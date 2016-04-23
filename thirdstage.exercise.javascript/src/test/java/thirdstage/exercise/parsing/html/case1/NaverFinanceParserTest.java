package thirdstage.exercise.parsing.html.case1;

import java.io.File;
import java.net.URL;

import org.testng.annotations.Test;

public class NaverFinanceParserTest {

	@Test
	public void parseDailySummaryByStock() throws Exception {

		URL meta = ClassLoader.getSystemResource("thirdstage/exercise/parsing/html/case1/NaverFinanceMeta.properties");
		NaverFinanceParser parser = new NaverFinanceParser(new File(meta.toURI()));

		parser.parseDailySummaryByStock("003920");
	}
	
	
}
