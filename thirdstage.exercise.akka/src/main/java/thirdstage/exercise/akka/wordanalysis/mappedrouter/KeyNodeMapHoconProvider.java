package thirdstage.exercise.akka.wordanalysis.mappedrouter;

import javax.annotation.Nonnull;
import org.apache.commons.lang3.Validate;
import org.slf4j.LoggerFactory;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigList;
import com.typesafe.config.ConfigObject;
import com.typesafe.config.ConfigValue;

public class KeyNodeMapHoconProvider implements KeyNodeMapProvider<String>{

   public final static String PATH_DEFAULT = "key-node-map";

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private final KeyNodeMap<String> keyNodeMap = new SimpleKeyNodeMap<String>();

   public KeyNodeMapHoconProvider(@Nonnull Config config){
      Validate.isTrue(config != null, "The config should be provided.");

      if(!config.hasPath(PATH_DEFAULT)){
         this.logger.warn("The provided HOCON configuration doesn't include key/node map information.");
         return;
      }

      ConfigList list = config.getList(PATH_DEFAULT);
      Config config2 = null;
      String key = null;
      String nodeId = null;
      for(ConfigValue val : list){
         config2 = ((ConfigObject)val).toConfig();
         key = config2.getString("key");
         nodeId = config2.getString("node");
         this.logger.debug("Key/node map entry - key: {}, node: {}.", key, nodeId);

         this.keyNodeMap.putNodeId(new Key<String>(key), nodeId);
      }
      this.logger.info("Key/node map has {} entries", list.size());

   }

   @Override @Nonnull
   public KeyNodeMap getKeyNodeMap(){
      return this.keyNodeMap;
   }

}
