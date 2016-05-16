package thirdstage.exercise.akka.wordanalysis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.LoggerFactory;

public class SimpleRoutingMap implements RoutingMap{


   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private final Map<String, String> map = new HashMap<String, String>();


   public SimpleRoutingMap(@Nonnull Map<String, String> map){
      this.map.putAll(map);
   }


   @Override
   public Set<String> getKeys(){
      return this.map.keySet();
   }

   @Override
   public String getPath(@NotBlank String key){
      return this.map.get(key);
   }




}
