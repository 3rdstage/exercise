package thirdstage.exercise.akka.wordanalysis;

import javax.annotation.concurrent.Immutable;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Immutable
public class Sentence implements Keyed<String>, java.io.Serializable{

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   private final String sourceId;

   @NotBlank public String getSourceId(){ return this.sourceId; }

   private final Key<String> key;

   @Override
   public Key<String> getKey(){ return this.key; }

   private final String text;

   public String getText(){ return this.text; }

   @JsonCreator
   public Sentence(@JsonProperty("sourceId") @NotBlank String sourceId, @JsonProperty("text") String text){
      this.sourceId = sourceId;
      this.text = text;
      this.key = new Key<String>(sourceId);
   }

}
