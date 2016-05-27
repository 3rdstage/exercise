package thirdstage.exercise.akka.wordanalysis.mappedrouter;

public interface Keyed<T extends java.io.Serializable>{

   public Key<T> getKey();

}
