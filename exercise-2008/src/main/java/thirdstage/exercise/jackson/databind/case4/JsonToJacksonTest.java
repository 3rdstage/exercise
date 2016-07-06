/**
 *
 */
package thirdstage.exercise.jackson.databind.case4;

import java.io.File;
import java.util.Arrays;
import java.util.TimeZone;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import junit.framework.Assert;
import thirdstage.exercise.jackson.databind.case4.RequestToken.Action;

/**
 * Testing the followings of Jasckson
 *
 * <ul>
 * <li>built-in serialization of byte array</li>
 * <li>custom serializer</li>
 * <li>polymorphic serialization using {@code JsonTypeInfo} annotation</li>
 * </ul>
 *
 * @author Sangmoon Oh
 *
 */
public class JsonToJacksonTest {

   private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private ObjectMapper jacksonMapper;

   private FastDateFormat dateFormat;


   @BeforeClass
   public void beforeClass(){
      this.dateFormat = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss", TimeZone.getTimeZone("GMT"));

      this.jacksonMapper = new ObjectMapper();
      this.jacksonMapper.registerModule(new JaxbAnnotationModule());
      this.jacksonMapper.disable(MapperFeature.AUTO_DETECT_FIELDS);
      this.jacksonMapper.enable(MapperFeature.AUTO_DETECT_GETTERS);
      this.jacksonMapper.enable(MapperFeature.AUTO_DETECT_SETTERS);
      this.jacksonMapper.enable(MapperFeature.AUTO_DETECT_IS_GETTERS);
      //this.jacksonMapper.enableDefaultTyping();
   }


   @Test
   public void testSerDe1() throws Exception{

      String imgLoc = "thirdstage/exercise/jackson/databind/case4/3rdstage.jpg";
      byte[] bytes = FileUtils.readFileToByteArray(new File(ClassLoader.getSystemResource(imgLoc).toURI()));

      JSONObject imgJson = new JSONObject();
      imgJson.put("class", "thirdstage.exercise.jackson.databind.case4.Image");
      imgJson.put("location", imgLoc);
      imgJson.put("width", 470);
      imgJson.put("height", 465);
      imgJson.put("bytes", Base64.encodeBase64String(bytes));

      JSONObject reqJson = new JSONObject();
      reqJson.put("id", 1);
      reqJson.put("action", Action.ADD_IMAGE);
      reqJson.put("date", this.dateFormat.format(new java.util.Date()));
      reqJson.put("object", imgJson);

      String reqStr = reqJson.toString();

      RequestToken req = this.jacksonMapper.readValue(reqStr, RequestToken.class);

      Assert.assertEquals(req.getId(), reqJson.getInt("id"));
      Assert.assertEquals(req.getAction(), reqJson.getEnum(Action.class, "action"));
      Assert.assertEquals(this.dateFormat.format(req.getDate()), reqJson.getString("date"));

      Image img = (Image)req.getObject();
      Assert.assertEquals(img.getLocation(), imgJson.getString("location"));
      Assert.assertEquals(img.getWidth(), imgJson.getInt("width"));
      Assert.assertEquals(img.getHeight(), imgJson.getInt("height"));

      Assert.assertEquals(img.getBytes().length, bytes.length);
      Assert.assertTrue(Arrays.equals(img.getBytes(), bytes));

   }

   @Test
   public void testSerDe2() throws Exception{


      JSONArray arryJson = new JSONArray();
      arryJson.put("11");
      arryJson.put("12");
      arryJson.put("13");

      JSONObject reqJson = new JSONObject();
      reqJson.put("id", 1);
            reqJson.put("action", Action.REMOVE_FACES);
      reqJson.put("object", arryJson);

      String reqStr = reqJson.toString();
      this.logger.info(reqStr);

      RequestToken req = this.jacksonMapper.readValue(reqStr, RequestToken.class);

      @SuppressWarnings("unused")
      Object obj = req.getObject();
   }


}
