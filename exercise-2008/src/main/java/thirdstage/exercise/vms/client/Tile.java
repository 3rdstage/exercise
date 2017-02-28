/**
 *
 */
package thirdstage.exercise.vms.client;

import javax.annotation.Nonnull;
import javax.validation.constraints.Min;
import checkers.nullness.quals.Nullable;

/**
 * @author Sangmoon Oh
 * @since Dec 23, 2016
 *
 */
public class Tile{

   @Min(1) private final int no;

   @Nullable private LivePlayer player = null;

   public Tile(@Min(1) int no){
      this.no = no;
   }

   public int getNo(){ return this.no; }

   public boolean isEmpty(){ return (this.player == null); }

   public void setPlayer(@Nullable LivePlayer player){
      this.player = player;
   }

   public void play(@Nonnull String deviceId){
      if(this.isEmpty()){
         throw new IllegalStateException("Unable to play the specified deivce because the player is not attached for this tile.");
      }

      this.player.start(deviceId);
   }

}
