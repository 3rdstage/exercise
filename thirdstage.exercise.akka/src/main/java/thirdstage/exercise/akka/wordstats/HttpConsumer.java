package thirdstage.exercise.akka.wordstats;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.validation.constraints.Min;
import org.apache.camel.Consume;
import org.apache.camel.Exchange;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.camel.CamelMessage;
import akka.camel.javaapi.UntypedConsumerActor;
import akka.camel.javaapi.UntypedProducerActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import thirdstage.exercise.akka.wordstats.StatsMessages.StatsJob;

public class HttpConsumer extends UntypedConsumerActor{

   private final LoggingAdapter logger = Logging.getLogger(this.getContext().system(), this);

   private final String address;

   private final int port;

   private final String uri;

   private final ActorRef producer;

   public HttpConsumer(@NotBlank String addr, @Min(1) int port, @Nonnull ActorRef service){
      this.address = addr;
      this.port = port;
      this.uri = "jetty:http://" + addr + ":" + port + "/wordstats";

      producer = getContext().actorOf(Props.create(HttpProducer.class, service), "httpProducer");
   }


   @Override @Consume
   public String getEndpointUri(){
      return this.uri;
   }

   @Override
   public void onReceive(Object msg) throws Exception{
      if(msg instanceof CamelMessage){
         logger.debug("Received a HTTP request via Camel.");
         producer.forward(msg, this.getContext());
      }else{
         this.unhandled(msg);
      }

   }
}

class HttpProducer extends UntypedProducerActor{

   private final LoggingAdapter logger = Logging.getLogger(this.getContext().system(), this);

   private static ObjectMapper jacksonMapper = new ObjectMapper();

   static{
      jacksonMapper.registerModule(new JaxbAnnotationModule())
      .configure(MapperFeature.AUTO_DETECT_FIELDS, false)
      .configure(MapperFeature.AUTO_DETECT_CREATORS, false)
      .configure(MapperFeature.AUTO_DETECT_GETTERS, true)
      .configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true)
      .configure(MapperFeature.AUTO_DETECT_SETTERS, true);
   }

   private final ActorRef service;

   HttpProducer(@Nonnull ActorRef service){
      this.service = service;
   }

   @Override
   public String getEndpointUri(){
      return "http://google.com/";
   }


   @Override
   public Object onTransformOutgoingMessage(Object msg){
      if(msg instanceof CamelMessage){
         CamelMessage msg2 = (CamelMessage) msg;
         Set<String> httpPath = new HashSet<String>();
         httpPath.add(Exchange.HTTP_PATH);
         return msg2.withHeaders(((CamelMessage)msg).getHeaders());
      }else{
         return super.onTransformOutgoingMessage(msg);
      }
   }

   @Override
   public void onRouteResponse(Object msg){
      if(msg instanceof CamelMessage){
         CamelMessage msg2 = (CamelMessage) msg;
         String body = msg2.getBodyAs(String.class, getCamelContext());
         StatsJob job = null;
         try{
            job = jacksonMapper.readValue(body, StatsJob.class);
            this.logger.debug("Successfully build the job object parsing the request body.");
         }catch(Exception ex){
            throw new RuntimeException("Fail to parse the request body", ex);
         }

         service.forward(job, getContext());
      }else{
         super.onRouteResponse(msg);
      }
   }

}
