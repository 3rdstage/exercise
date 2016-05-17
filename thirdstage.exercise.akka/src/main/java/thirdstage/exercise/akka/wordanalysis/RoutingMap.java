package thirdstage.exercise.akka.wordanalysis;

import java.util.Set;
import javax.annotation.Nonnull;
import org.hibernate.validator.constraints.NotBlank;

public interface RoutingMap<K>{

   @Nonnull public Set<Key<K>> getKeys();

   public String getPath(@NotBlank Key<K> key);


}
