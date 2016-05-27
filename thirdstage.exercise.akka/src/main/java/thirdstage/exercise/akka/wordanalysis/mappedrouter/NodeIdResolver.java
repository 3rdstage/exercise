package thirdstage.exercise.akka.wordanalysis.mappedrouter;

import akka.cluster.Member;

public interface NodeIdResolver{

   public String resolveNodeId(Member member);

}
