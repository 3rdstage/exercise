package thirdstage.exercise.akka.wordanalysis;

import java.util.Set;
import javax.annotation.Nonnull;
import org.hibernate.validator.constraints.NotBlank;

public interface RoutingMap{

   @Nonnull public Set<String> getKeys();

   public String getPath(@NotBlank String key);


}
