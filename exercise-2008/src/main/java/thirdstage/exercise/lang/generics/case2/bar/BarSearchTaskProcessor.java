/**
 *
 */
package thirdstage.exercise.lang.generics.case2.bar;

import javax.annotation.concurrent.NotThreadSafe;

import thirdstage.exercise.lang.generics.case2.SearchResult;
import thirdstage.exercise.lang.generics.case2.SearchTaskProcessor;
import thirdstage.exercise.lang.generics.case2.SearchTaskStatus;

/**
 * @author 3rdstage
 *
 */
@NotThreadSafe
public class BarSearchTaskProcessor implements
	SearchTaskProcessor<BarSearchCriteria, BarEvent, BarEventContext> {

	private SearchTaskStatus status;

	@Override
	public SearchResult<BarEvent, BarEventContext> process(String systemId, String devId,
			String from, String to, BarSearchCriteria criteria){

		SearchResult<BarEvent, BarEventContext> result = new SearchResult<BarEvent, BarEventContext>();

		return result;
	}

	@Override
	public SearchTaskStatus getStatus(){
		return this.status;
	}

}
