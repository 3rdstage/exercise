/**
 *
 */
package thirdstage.exercise.lang.generics.case2.foo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import thirdstage.exercise.lang.generics.case1.Shape;
import thirdstage.exercise.lang.generics.case2.Event;
import thirdstage.exercise.lang.generics.case2.EventType;

/**
 * @author 3rdstage
 *
 */
public class FooEvent implements Event{

	private EventType type;

	private String str;

	private Map<String, Object> props = new HashMap<String, Object>();

	public FooEvent(EventType type, Pair<String, ?>... params){
		this.type = type;
		for(Pair<String, ?> param : params){
			this.props.put(param.getLeft(), param.getRight());
		}
	}

	@Override
	public EventType getType(){ return this.type; }

	public Object getProperty(String key){
		return this.props.get(key);
	}

	public Object getStringProperty(String key){
		return String.valueOf(this.props.get(key));
	}

	@Override
	public String toString(){
		if(this.str == null){
			this.str = type.toString() + " event";
		}
		return str;
	}

}
