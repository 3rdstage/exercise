/**
 *
 */
package thirdstage.exercie.vms.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.validation.constraints.Min;
import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @author Sangmoon Oh
 * @since Dec 23, 2016
 *
 */
public class MonitoringArea{

   public static final int MAX_TILES_NUMBER = 64; //maximum value for the number of tiles for a monitoring area;

   private final Logger logger = LoggerFactory.getLogger(this.getClass());

   private final Map<String, Layout> layouts = new HashMap<String, Layout>();



   private final LivePlayer[] players = new LivePlayer[MAX_TILES_NUMBER];

   @Nonnull private Layout currentLayout;

   protected Layout getCurrentLayout(){
      if(this.currentLayout == null){
         throw new IllegalStateException("The current layout is never expected to be unspecified.");
      }

      return this.currentLayout;
   }


   public void changeLayout(@Nonnull String layoutId){
      if(this.currentLayout.getId().equals(layoutId)){
         //do nothing
      }else{
         //@TODO
      }

   }

   public void startPlayer(@Min(1) int tileNo){

      if(tileNo < 1){

      }else if(tileNo > this.currentLayout.getNumberOfTiles()){

      }else{

      }

   }

   public void pausePlayer(@Min(1) int tileNo){

   }

   public void stopPlayer(@Min(1) int tileNo){

   }

   public void addOrReplacePlayer(@Min(1) int tileNo, @NotBlank String systemId, @NotBlank String deviceId){

   }


   public void addPlayer(@NotEmpty List<Pair<String, String>> devices){

   }

   private int getNumberOfEmptyTiles(){
      for

   }






}
