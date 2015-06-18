/**
 *
 */
package thirdstage.exercise.lang.generics.case1;

import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.Min;

/**
 * @author 3rdstage
 *
 */
@Immutable
public class Square extends Rectangle{

	public Square(@Min(0) double x){
		super(x, x);
	}

	@Override public String getName(){ return "Square"; }

}
