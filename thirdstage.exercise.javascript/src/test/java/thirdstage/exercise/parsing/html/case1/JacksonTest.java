package thirdstage.exercise.parsing.html.case1;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
	
	final static Logger logger = LoggerFactory.getLogger(JacksonTest.class);
	
	ObjectMapper jsonMapper;
	URL jsonFileUrl; 
	
	
	@BeforeClass
	public void beforeClass() {
		this.jsonMapper = new ObjectMapper();
		this.jsonFileUrl = ClassLoader.getSystemResource("thirdstage/exercise/parsing/html/case1/krx-stock-code-20130503.json");
		
	}


	/**
	 * @fixme ...
	 * @throws Exception
	 */
	@Test
	public void testArrayParsingWithMapper() throws Exception{
		
		JsonFactory jf = new JsonFactory();
		JsonParser jp = jf.createParser(new File(this.jsonFileUrl.toURI()));
		jp.nextValue();
		jp.nextValue();
		
		List<Map<String,Object>> issues = this.jsonMapper.readValue(
			jp, new TypeReference<List<Map<String, Object>>>(){});
		
		logger.info("The size of the array is {}", issues.size());
		
		
	}
	
	@Test
	public void testArrayParsingWithoutMapper() throws Exception{

		JsonFactory jf = new JsonFactory();
		JsonParser jp = jf.createParser(new File(this.jsonFileUrl.toURI()));
		jp.nextToken();
		
		List<Map<String,Object>> issues = jp.readValueAs(new TypeReference<List<Map<String, Object>>>(){});
		
		logger.info("The size of the array is {}", issues.size());
		
		
	}	
	@Test
	public void testSimplestArrayParsing() throws Exception{
		
		String contents = new StringBuilder().append("[{")
				.append("\"code\": \"KR7000020008\", ")
				.append("\"issue\": \"동화약품보통주\", ")
				.append("\"issuerCode\": \"00002\"")
				.append("},{")
				.append("\"code\": \"KR7000031005\", ")
				.append("\"issue\": \"우리은행1우선주\", ")
				.append("\"issuerCode\": \"00003\"")
				.append("}]")
				.toString();
		
		List<Map<String,Object>> issues = this.jsonMapper.readValue(
				contents, new TypeReference<List<Map<String, Object>>>(){});
		
		logger.info("The size of the array is {}", issues.size());
		
	}
		



}
