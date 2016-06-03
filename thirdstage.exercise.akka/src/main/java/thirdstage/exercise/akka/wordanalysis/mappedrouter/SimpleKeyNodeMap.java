package thirdstage.exercise.akka.wordanalysis.mappedrouter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nonnull;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.hibernate.validator.constraints.NotBlank;

public class SimpleKeyNodeMap<T extends java.io.Serializable> implements KeyNodeMap<T>{


   private final Map<Key<T>, String> map = new HashMap<Key<T>, String>();


   public SimpleKeyNodeMap(){ }

   public SimpleKeyNodeMap(@Nonnull Map<T, String> map){
      for(T key : map.keySet()){
         this.map.put(new Key<T>(key), map.get(key));
      }
   }

   @Override @Nonnull
   public Set<Key<T>> getKeys(){
      return this.map.keySet();
   }

   @Override
   public String getNodeId(@Nonnull Key<T> key){
      Validate.isTrue(key != null, "The key should be non-null.");
      return this.map.get(key);

   }

   @Override
   public String putNodeId(@Nonnull Key<T> key, @NotBlank String nodeId){
      Validate.isTrue(key != null, "The key should be non-null.");
      Validate.isTrue(StringUtils.isNotBlank(nodeId), "The node ID shoud be specified.");

      return this.map.put(key, nodeId);
   }

   @Override
   public boolean isEmpty(){
      return this.map.isEmpty();
   }

   @Override
   public boolean containsKey(@Nonnull Key<T> key){
      Validate.isTrue(key != null, "The key should be non-null.");

      return this.map.containsKey(key);
   }

   @Override
   public Set<Entry<Key<T>, String>> getEntrySet(){
      return this.map.entrySet();
   }





}
