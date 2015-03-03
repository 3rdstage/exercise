package thirdstage.exercise.json.case1;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MessageMetaUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParseMessageMetaFromJsonString() throws Exception {
		
		String id = "msg0000001";
		String name = "Make An Order";
		String ver = "1.2";
		String date = "2012-03-01";
		
		String jsonStr = "{ \"id\" : \"" + id + "\", \n" 
				               + "  \"name\" : \"" + name + "\", \n"
				               + "  \"version\" : \"" + ver + "\", \n"
				               + "  \"date\" : \"" + date + "\" }";
		
		MessageMeta meta = MessageMetaUtil.parseMessageMetaFromJson(jsonStr);
		
		Assert.assertEquals(id, meta.getId());
		Assert.assertEquals(name, meta.getName());
		Assert.assertEquals(ver, meta.getVersion());
		Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse(date), meta.getDate());

	}

	@Test
	public void testParseMessageMetaFromJsonFile() throws Exception{
		
		java.io.File f = new File(ClassLoader.getSystemResource("thirdstage/exercise/json/case1/message-meta-1-1.json").toURI());
		
		MessageMeta meta = MessageMetaUtil.parseMessageMetaFromJson(f);
		
		Assert.assertEquals("msg0000002", meta.getId());
		Assert.assertEquals("Cancel an Order", meta.getName());
		Assert.assertEquals("2.1", meta.getVersion());
		Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2012-03-02"), meta.getDate());
	}

}
