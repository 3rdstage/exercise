package thirdstage.exercise.akka.wordanalysis;

import org.apache.camel.Consume;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import akka.camel.CamelMessage;
import akka.camel.javaapi.UntypedConsumerActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.ConsistentHashingGroup;

public class WebService extends UntypedConsumerActor{

   private static ObjectMapper jacksonMapper = new ObjectMapper();

   private ConsistentHashingGroup router;

   static{
      jacksonMapper.registerModule(new JaxbAnnotationModule())
      .configure(MapperFeature.AUTO_DETECT_FIELDS, false)
      .configure(MapperFeature.AUTO_DETECT_CREATORS, false)
      .configure(MapperFeature.AUTO_DETECT_GETTERS, true)
      .configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true)
      .configure(MapperFeature.AUTO_DETECT_SETTERS, true);
   }

   private final LoggingAdapter logger = Logging.getLogger(this.getContext().system(), this);

   private final String uri;

   public WebService(String uri){
      this.uri = uri;
   }



   @Override @Consume
   public String getEndpointUri(){
      return this.uri;
   }

   @Override
   public void onReceive(Object msg) throws Exception{
      if(msg instanceof CamelMessage){
         logger.debug("Received a HTTP request via Camel.");

         CamelMessage msg2 = (CamelMessage) msg;
         String body = msg2.getBodyAs(String.class, getCamelContext());
         Sentence setence = null;
         try{
            setence = jacksonMapper.readValue(body, Sentence.class);
            this.logger.debug("Successfully build the job object parsing the request body.");
         }catch(Exception ex){
            throw new RuntimeException("Fail to parse the request body", ex);
         }

      }else{
         this.unhandled(msg);
      }

   }

}
