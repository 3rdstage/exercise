/**
 *
 */
package thirdstage.exercise.lang.generics.case2.bar;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import thirdstage.exercise.lang.generics.case2.Event;
import thirdstage.exercise.lang.generics.case2.EventType;

/**
 * @author 3rdstage
 *
 */
@Immutable
public abstract class BarEvent implements Event{

	private EventType type;

	private String str;

	public BarEvent(@Nonnull EventType type){
		this.type = type;
	}

	@Override
	public EventType getType(){ return this.type; }

	@Override
	public String toString(){
		if(this.str == null){
			this.str = type.toString() + " event";
		}
		return str;
	}
}
