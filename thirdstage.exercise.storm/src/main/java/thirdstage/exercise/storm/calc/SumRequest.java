package thirdstage.exercise.storm.calc;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.storm.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

@Immutable
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class SumRequest{
   
   @XmlElement(name="id")
   private String id;
   
   @XmlElement(name="from")
   private double from;
   
   @XmlElement(name="to")
   private double to;
   
   @XmlElement(name="step")
   private double step;
   
   /**
    * @param id
    * @param from
    * @param to
    * @param step
    */
   @JsonCreator
   public SumRequest(@Nonnull @JsonProperty("id") String id, 
      @JsonProperty("from") double from, @JsonProperty("to") double to, @JsonProperty("step") double step){
      Validate.isTrue(to >= from, "The parameter 'to' should be equal or greater than 'from'.");
      Validate.isTrue(step > 0.0, "The parameter 'step' should be positive.");
      
      this.id = id;
      this.from = from;
      this.to = to;
      this.step = step;
   }
   
   public String getId(){ return this.id; }
   
   public double getFrom(){ return this.from; }
   
   public double getTo(){ return this.to; }
   
   public double getStep(){ return this.step; }
}
