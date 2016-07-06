/**
 *
 */
package thirdstage.exercise.jackson.databind.case5;

import org.apache.commons.lang3.tuple.Pair;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

/**
 * @author Sangmoon Oh
 *
 */
public class PairSerDeTest{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private final ObjectMapper jacksonMapper = new ObjectMapper();

   @BeforeClass
   public void beforeClass(){

      this.jacksonMapper.registerModule(new JaxbAnnotationModule())
      .configure(MapperFeature.AUTO_DETECT_FIELDS, false)
      .configure(MapperFeature.AUTO_DETECT_CREATORS, false)
      .configure(MapperFeature.AUTO_DETECT_GETTERS, true)
      .configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true)
      .configure(MapperFeature.AUTO_DETECT_SETTERS, true);
   }


   @Test(expectedExceptions={com.fasterxml.jackson.core.JsonProcessingException.class})
   public void testCommonsPairSerDe1() throws Exception{

      JSONObject pair = new JSONObject();
      pair.put("left", "Green");
      pair.put("right", "Orange");


      Pair<String, String> pair2 = this.jacksonMapper.readValue(pair.toString(), Pair.class);


   }





}
