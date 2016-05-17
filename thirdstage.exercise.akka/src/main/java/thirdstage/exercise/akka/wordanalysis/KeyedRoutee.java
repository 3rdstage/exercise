package thirdstage.exercise.akka.wordanalysis;

import akka.routing.Routee;

public interface KeyedRoutee<T> extends Keyed<T>, Routee{

}
