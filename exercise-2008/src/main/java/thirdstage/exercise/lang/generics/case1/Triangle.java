/**
 *
 */
package thirdstage.exercise.lang.generics.case1;

import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * @author 3rdstage
 *
 */
@Immutable
public class Triangle implements Shape {

	private double[] bases = new double[3];

	@Min(0) private double len;
	@Min(0) private double area;

	public Triangle(@Min(0) double a, @Min(0) double b, @Min(0) double c){
		this.bases[0] = a;
		this.bases[1] = b;
		this.bases[2] = c;

		this.len = (a + b + c);
		double s = this.len/2.0;

		this.area = Math.sqrt(s*(s - a)*(s -  b)*(s - c));
	}

	@Override public String getName() { return "Triangle"; }

	@Override public boolean isClosed() { return true; }

	@Override @Min(0)
	public double getLength() { return this.len; }

	@Override @Min(0)
	public double getArea() { return this.area; }

	@Size(min=3, max=3)
	public double[] getBaseLengths(){ return this.bases; }

	@Range(min=0, max=180)
	public double getAngle(@Range(min=0, max=2) int index1){
		throw new UnsupportedOperationException("Not yet implemented.");
	}


}
