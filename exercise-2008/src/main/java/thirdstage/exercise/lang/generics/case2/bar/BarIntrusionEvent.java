/**
 *
 */
package thirdstage.exercise.lang.generics.case2.bar;

import javax.annotation.concurrent.Immutable;

import thirdstage.exercise.lang.generics.case2.EventType;

/**
 * @author 3rdstage
 *
 */
@Immutable
public class BarIntrusionEvent extends BarEvent {

	public BarIntrusionEvent(){
		super(EventType.INTRUSION);
	}
}
