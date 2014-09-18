package thirdstage.exercise.oozie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OozieUtilsTest {

   @Test
   public void testValidateWorkflowDefinition() {
      String def = "";


      XmlValidationResult result = OozieUtils.validateWorkflowDefinition(def);

      Assert.assertEquals(0, result.getItems().size());

   }


   @Test
   public void testWorkflowShcemaVerPattern(){

      Pattern p = OozieUtils.workflowShcemaVerPattern;

      String str1 = "<workflow-app xmlns=\"uri:oozie:workflow:0.2\" name=\"oozie-exercise-workflow\">";

      Matcher m1 = p.matcher(str1);

      Assert.assertTrue(m1.find());




   }
}
