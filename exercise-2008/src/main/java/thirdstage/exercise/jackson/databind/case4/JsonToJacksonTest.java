/**
 *
 */
package thirdstage.exercise.jackson.databind.case4;

import junit.framework.Assert;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import thirdstage.exercise.jackson.databind.case4.RequestToken.Action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

/**
 * @author Sangmoon Oh
 *
 */
public class JsonToJacksonTest {

	private ObjectMapper jacksonMapper;


	@BeforeClass
	public void beforeClass(){

		this.jacksonMapper = new ObjectMapper();
		this.jacksonMapper.registerModule(new JaxbAnnotationModule());



	}


	@Test
	public void testSerDe1() throws Exception{
		JSONObject reqJson = new JSONObject();

		reqJson.put("id", 1);
		reqJson.put("type", Action.ADD_IMAGE);
		reqJson.put("date", new java.util.Date());

		String reqStr = reqJson.toString();

		RequestToken req = this.jacksonMapper.readValue(reqStr, RequestToken.class);

		Assert.assertEquals(req.getId(), reqJson.getInt("id"));
		Assert.assertEquals(req.getAction(), reqJson.getEnum(Action.class, "type"));

		//Not equal without any annotation or built-in/custom deserializer
		//Assert.assertEquals(req.getDate(), (java.util.Date)reqJson.get("date"));

	}


}
