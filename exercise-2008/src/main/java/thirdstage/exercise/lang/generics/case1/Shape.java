/**
 *
 */
package thirdstage.exercise.lang.generics.case1;

import javax.annotation.Nonnull;
import javax.validation.constraints.Min;

/**
 * @author 3rdstage
 *
 */
public interface Shape {

	@Nonnull public String getName();

	public boolean isClosed();

	@Min(0L)
	public double getLength();

	@Min(0L)
	public double getArea();

}
