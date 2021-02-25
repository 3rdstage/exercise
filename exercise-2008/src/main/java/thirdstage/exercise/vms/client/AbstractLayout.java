/**
 *
 */
package thirdstage.exercise.vms.client;

import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;
import checkers.nullness.quals.Nullable;

/**
 * @author Sangmoon Oh
 * @since Dec 23, 2016
 *
 */
public abstract class AbstractLayout implements Layout{


   @NotBlank private final String id;

   @NotBlank private final String name;

   private final boolean isEven;

   @Min(1) private final int tilesNum;

   private final String desc;

   protected AbstractLayout(@NotBlank String id, @NotBlank String name, boolean isEven, @Min(1) int tilesNum, @Nullable String desc){
      this.id = id;
      this.name = name;
      this.isEven = isEven;
      this.tilesNum = tilesNum;
      this.desc = (desc == null) ? "" : desc;

   }

   @Override
   public String getId(){ return this.id; }

   @Override
   public String getName(){ return this.name; }

   @Override
   public int getNumberOfTiles(){ return this.tilesNum; }

   @Override
   public boolean isEven(){ return this.isEven; }

   @Override
   public String getDesc(){ return this.desc; }

}
