/**
 *
 */
package thirdstage.exercise.lang.generics.case2;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * @author 3rdstage
 *
 */
@NotThreadSafe
public interface SearchTaskProcessor<SC extends SearchCriteria,
	E extends Event, EC extends EventContext> {


	public SearchResult<E, EC> process(String systemId, String devId,
		String from, String to, SC criteria);

	public SearchTaskStatus getStatus();
}
