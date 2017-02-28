/**
 *
 */
package thirdstage.exercise.vms.client;

import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Sangmoon Oh
 * @since Dec 23, 2016
 *
 */
@Immutable
public class EvenLayout extends AbstractLayout{

   @Min(1) private final int rows;

   @Min(1) private final int cols;


   public EvenLayout(@NotBlank String id, @NotBlank String name, @Min(1) int rows, @Min(1) int cols, String desc){
      super(id, name, true, rows * cols, desc);

      this.rows = rows;
      this.cols = cols;

   }

   @Min(1) int getNumberOfLows(){ return this.rows; }

   @Min(1) int getNumberOfCols(){ return this.cols; }

}
