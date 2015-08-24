/**
 * 
 */
package thirdstage.exercise.lang.serializable.case2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import thirdstage.exercise.lang.serializable.case1.Mark1;
import thirdstage.exercise.lang.serializable.case2.domain.Color1;

/**
 * @author 3rdstage
 *
 */
public class SerializationTest2{

   private final Logger logger = LoggerFactory.getLogger(this.getClass());

   /**
    * Shows that <strong><emp>protected</emp></strong> no-arg constructor is enough
    * for JDK built-in object serialization.
    */
   @Test
   public void testColor1SerDe(){

      Color1 color = new Color1(250, 250, 15);
      ByteArrayOutputStream baos = null;
      ObjectOutputStream oos = null;
      String str = null;
      byte[] bytes = null;
      ByteArrayInputStream bais = null;
      ObjectInputStream ois = null;
      Color1 anotherColor = null;

      try{
         baos = new ByteArrayOutputStream();
         oos = new ObjectOutputStream(baos);

         oos.writeObject(color);
         bytes = baos.toByteArray();

         bais = new ByteArrayInputStream(bytes);
         ois = new ObjectInputStream(bais);

         anotherColor = (Color1)(ois.readObject());

         Assert.assertTrue(color != anotherColor);
         Assert.assertEquals(anotherColor.getR(), color.getR());
         Assert.assertEquals(anotherColor.getG(), color.getG());
         Assert.assertEquals(anotherColor.getB(), color.getB());
      }catch(Exception ex){
         this.logger.error(ex.getMessage(), ex);
         throw new RuntimeException(ex);

      }finally{
         if(baos != null){ 
            try{ baos.close(); }
            catch(Exception ex){}
         }
         if(oos != null){
            try{ oos.close(); }
            catch(Exception ex){}
         }
         if(bais != null){
            try{ bais.close(); }
            catch(Exception ex){}
         }
         if(ois != null){
            try{ ois.close(); }
            catch(Exception ex){}
         }
      }
   }   
   
}
