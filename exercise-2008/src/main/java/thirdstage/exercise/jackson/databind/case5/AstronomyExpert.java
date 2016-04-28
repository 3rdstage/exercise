/**
 *
 */
package thirdstage.exercise.jackson.databind.case5;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

/**
 * @author Sangmoon Oh
 *
 */
public class AstronomyExpert {

   private final List<MessierObject> messierCatalog = new ArrayList<MessierObject>();

   private static final ObjectMapper jacksonMapper = new ObjectMapper();

   static{
      jacksonMapper.registerModule(new JaxbAnnotationModule())
      .configure(MapperFeature.AUTO_DETECT_FIELDS, false)
      .configure(MapperFeature.AUTO_DETECT_CREATORS, false)
      .configure(MapperFeature.AUTO_DETECT_GETTERS, true)
      .configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true)
      .configure(MapperFeature.AUTO_DETECT_SETTERS, true);
   }

   @Nonnull
   public List<MessierObject> getMessierCatalog(){
      return this.messierCatalog;
   }

   public String getMessierCatalogInJsonString() throws Exception{
      String result = null;

      List<MessierObject> mos = this.getMessierCatalog();

      Writer wr = new StringWriter();
      jacksonMapper.writeValue(wr, mos);

      return wr.toString();
   }

   @Immutable
   public static class MessierObject{

      private String number;

      private String ngcNumber;

      private String commonName;

      private String type;

      private Double distance;

      private String constellation;

      private Double apparentMagnitude;

      /**
       * @param number
       * @param ngcNumber
       * @param commonName
       * @param type
       * @param distance
       * @param constellation
       * @param apparentMagnitude
       */
      @JsonCreator
      public MessierObject(@JsonProperty("number") String number,
            @JsonProperty("ngc-number") String ngcNumber,
            @JsonProperty("common-name") String commonName,
            @JsonProperty("type") String type,
            @JsonProperty("distance") Double distance,
            @JsonProperty("constellation") String constellation,
            @JsonProperty("apparent-magnitude") Double apparentMagnitude){
         super();
         this.number = number;
         this.ngcNumber = ngcNumber;
         this.commonName = commonName;
         this.type = type;
         this.distance = distance;
         this.constellation = constellation;
         this.apparentMagnitude = apparentMagnitude;
      }

      public String getNumber(){ return number; }

      public String getNgcNumber(){ return ngcNumber;}

      public String getCommonName(){ return commonName; }

      public String getType(){ return type; }

      public Double getDistance(){ return distance; }

      public String getConstellation(){ return constellation; }

      public Double getApparentMagnitude(){ return apparentMagnitude; }
   }
}
