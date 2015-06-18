/**
 *
 */
package thirdstage.exercise.lang.generics.case2.bar;

import javax.annotation.concurrent.Immutable;

import org.hibernate.validator.constraints.Range;

import thirdstage.exercise.lang.generics.case2.EventType;

/**
 * @author 3rdstage
 *
 */
@Immutable
public class BarCrowdDensityEvent extends BarEvent {

	private float density;

	public BarCrowdDensityEvent(@Range(min=0, max=1) float density){
		super(EventType.CROWD_DENSITY);
		this.density = density;
	}

	public float getDensity(){
		return this.density;
	}

}
