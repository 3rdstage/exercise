/**
 * 
 */
package thirdstage.exercise.lang.serializable.case2.domain;

import org.hibernate.validator.constraints.Range;

/**
 * @author 3rdstage
 *
 */
public class Color1 implements java.io.Serializable{
   
   
   private static final long serialVersionUID = 2092020624153119851L;

   @Range(min=0, max=255) private int r;
   
   @Range(min=0, max=255) private int g;
   
   @Range(min=0, max=255) private int b;
   
   
   protected Color1(){}
   
   public Color1(@Range(min=0, max=255) int r, @Range(min=0, max=255) int g,
         @Range(min=0, max=255) int b){
      this.r = r;
      this.g = g;
      this.b = b;
   }
   
   public int getR(){ return this.r; }
   
   public int getG(){ return this.g; }
   
   public int getB(){ return this.b; }
   
}

