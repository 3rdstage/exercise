package thirdstage.exercise.akka.wordanalysis;

import java.util.Set;
import javax.annotation.Nonnull;
import org.hibernate.validator.constraints.NotBlank;


//@TODO Consider to define RoutingMapBuilder to make the implementations to be immutable
/**
 * @author Sangmoon Oh
 *
 * @param <K>
 */
public interface RoutingMap<K extends java.io.Serializable>{



   @Nonnull public Set<Key<K>> getKeys();

   public String getPath(@NotBlank Key<K> key);


}
