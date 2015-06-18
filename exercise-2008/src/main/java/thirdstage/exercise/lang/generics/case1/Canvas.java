/**
 *
 */
package thirdstage.exercise.lang.generics.case1;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.Min;

import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.validator.constraints.Range;

/**
 * @author 3rdstage
 *
 */
public class Canvas {

	@Min(1) private int width;

	@Min(1) private int height;

	@Nonnull
	private final List<Pair<Shape, Point>> elements = new ArrayList<Pair<Shape, Point>>();


	public Canvas(@Min(1) int w, @Min(1) int h){
		this.width = w;
		this.height = h;
	}

	public <T extends Shape> void draw(@Nonnull T shape, @Nonnull Point p){

		Pair<Shape, Point> pair = Pair.of((Shape)shape, p);
		this.elements.add(pair);

		System.out.printf("Draw a(an) %1$s at (%2$f, %3$f)\n", shape.getName(), p.getX(), p.getY());
	}

	@Nonnegative
	public int getNumberOfElements(){
		return this.elements.size();
	}


	@Immutable
	public static class Point{

		@Range(min=0, max=1) private double x;
		@Range(min=0, max=1) private double y;

		public Point(@Range(min=0, max=1) double x, @Range(min=0, max=1) double y){
			this.x = x;
			this.y = y;
		}

		public double getX(){ return x; }

		public double getY(){ return y; }
	}

}
