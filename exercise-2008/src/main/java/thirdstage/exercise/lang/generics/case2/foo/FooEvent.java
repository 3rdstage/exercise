/**
 *
 */
package thirdstage.exercise.lang.generics.case2.foo;

import thirdstage.exercise.lang.generics.case2.Event;
import thirdstage.exercise.lang.generics.case2.EventType;

/**
 * @author 3rdstage
 *
 */
public class FooEvent implements Event{

	private EventType type;

	@Override
	public EventType getType(){ return this.type; }
}
