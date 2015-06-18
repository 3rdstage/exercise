/**
 *
 */
package thirdstage.exercise.lang.generics.case2;

import java.util.ArrayList;
import java.util.List;

import org.testng.internal.collections.Pair;

/**
 * <pre><code>
 * SearchResult = Item*
 * Item = Event + EventContext
 * </code></pre>
 *
 * @author 3rdstage
 *
 */
public class SearchResult<E extends Event, C extends EventContext> {


	List<Pair<? extends E, C>> items = new ArrayList<Pair<? extends E, C>>();

	public SearchResult(){

	}

	public <T extends E> void addItem(T ev, C cntx){
		this.items.add(Pair.of(ev, cntx));
	}

	public List<Pair<? extends E, C>> getItems(){
		return this.items;
	}
}
