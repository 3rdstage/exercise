package thirdstage.exercise.akka.wordanalysis;

public interface Keyed<T extends java.io.Serializable>{

   public Key<T> getKey();

}
