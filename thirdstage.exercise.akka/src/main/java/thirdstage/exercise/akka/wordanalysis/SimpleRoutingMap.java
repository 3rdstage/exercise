package thirdstage.exercise.akka.wordanalysis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.LoggerFactory;

public class SimpleRoutingMap<K extends java.io.Serializable> implements RoutingMap<K>{


   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private final Map<Key<K>, String> map = new HashMap<Key<K>, String>();

   public SimpleRoutingMap(){ }

   public SimpleRoutingMap(@Nonnull Map<K, String> map){
      for(K key : map.keySet()){
         this.map.put(new Key<K>(key), map.get(key));
      }
   }

   public boolean containsKey(@Nonnull K key){
      return this.map.containsKey(new Key<K>(key));
   }

   public String put(@Nonnull K key, @Nonnull String path){
      return this.map.put(new Key<K>(key), path);
   }


   @Override
   public Set<Key<K>> getKeys(){
      return this.map.keySet();
   }

   @Override
   public String getPath(@NotBlank Key<K> key){
      return this.map.get(key);
   }
}
