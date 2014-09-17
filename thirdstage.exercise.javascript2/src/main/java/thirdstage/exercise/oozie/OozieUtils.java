package thirdstage.exercise.oozie;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.slf4j.LoggerFactory;

public class OozieUtils{

   /**
    * {@code Schema} class is thread-safe and immutable and so can be cached.
    */
   protected static Map<String, Schema> workflowSchemas = new HashMap<String, Schema>();


   static{
      Map<String, String> paths = new HashMap<String, String>();
      paths.put("0.4", "schemas/oozie/oozie-workflow-0.4.xsd");
      paths.put("0.5", "schemas/oozie/oozie-workflow-0.5.xsd");

      SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      String ver;
      Schema sch;
      for(Map.Entry<String, String> path: paths.entrySet()){
         try{
            ver = path.getKey();
            sch = sf.newSchema(ClassLoader.getSystemResource(path.getValue()));
            workflowSchemas.put(ver, sch);
         }catch(Exception ex){
            LoggerFactory.getLogger(OozieUtils.class).error("Fail to load schema from {}", path.getValue(), ex);
         }
      }

      workflowSchemas = Collections.unmodifiableMap(workflowSchemas);
   }




   public static XmlValidationResult validateWorkflowDefinition(@Nonnull String def){
      if(def == null) throw new IllegalArgumentException("Definition string shouldn't be null.");

      XmlValidationResult result = new XmlValidationResult();


      return result;
   }




}
