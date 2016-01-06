/**
 *
 */
package thirdstage.exercise.lang.generics.case1;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.Min;

/**
 * @author 3rdstage
 *
 */
@Immutable
public class Rectangle implements Shape{

	private double x;
	private double y;
	private double len;
	private double area;

	public Rectangle(@Min(0) double x, @Min(0) double y){
		this.x = x;
		this.y = y;
		this.len = 2*(x + y);
		this.area = x*y;
	}


	@Override @Nonnull public String getName(){
		return "Rectangle";
	}

	@Override public boolean isClosed(){
		return true;
	}

	@Override public double getLength(){
		return this.len;
	}

	@Override public double getArea(){
		return this.area;
	}

	public double getWidth(){ return this.x; }

	public double getHeight(){ return this.y; }
}
