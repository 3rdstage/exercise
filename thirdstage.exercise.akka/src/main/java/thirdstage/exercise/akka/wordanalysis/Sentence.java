package thirdstage.exercise.akka.wordanalysis;

import javax.annotation.concurrent.Immutable;
import org.hibernate.validator.constraints.NotBlank;

@Immutable
public class Sentence implements java.io.Serializable{

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   private final String sourceId;

   @NotBlank public String getSourceId(){ return this.sourceId; }

   private final String text;

   public String getText(){ return this.text; }

   public Sentence(@NotBlank String sourceId, String text){
      this.sourceId = sourceId;
      this.text = text;
   }

}
