package thirdstage.exercise.akka.wordstats;

import akka.camel.javaapi.UntypedProducerActor;

public class JobTracer extends UntypedProducerActor{

   @Override
   public String getEndpointUri(){
      return "activemq:topic:JobTrace";
   }

}
