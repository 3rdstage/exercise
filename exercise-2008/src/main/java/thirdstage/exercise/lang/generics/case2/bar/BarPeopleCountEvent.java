/**
 *
 */
package thirdstage.exercise.lang.generics.case2.bar;

import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.Min;

import thirdstage.exercise.lang.generics.case2.EventType;

/**
 * @author 3rdstage
 *
 */
@Immutable
public class BarPeopleCountEvent extends BarEvent {

	private int count;

	public BarPeopleCountEvent(int cnt){
		super(EventType.PEOPLE_COUNT);
		this.count = cnt;
	}

	@Min(1)
	public int getCount(){ return this.count; }

}
