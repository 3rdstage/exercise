package thirdstage.exercise.oozie;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class OozieUtils{

   protected static Map<String, Schema> workflowSchemas = new HashMap<String, Schema>();





   public XmlValidationResult validateWorkflowDefinition(@Nonnull String def){
      if(def == null) throw new IllegalArgumentException("Definition string shouldn't be null.");

      XmlValidationResult result = new XmlValidationResult();

      SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);




      return result;
   }




}
