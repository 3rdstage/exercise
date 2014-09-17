package thirdstage.exercise.oozie;

import junit.framework.Assert;
import org.testng.annotations.Test;

public class OozieUtilsTest {

   @Test
   public void validateWorkflowDefinition() {
      String def = "";


      XmlValidationResult result = OozieUtils.validateWorkflowDefinition(def);

      Assert.assertEquals(0, result.getItems().size());

   }
}
