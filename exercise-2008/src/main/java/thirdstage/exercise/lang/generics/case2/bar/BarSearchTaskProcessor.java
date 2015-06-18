/**
 *
 */
package thirdstage.exercise.lang.generics.case2.bar;

import javax.annotation.concurrent.NotThreadSafe;

import thirdstage.exercise.lang.generics.case2.AbstractSearchTaskProcessor;
import thirdstage.exercise.lang.generics.case2.SearchResult;
import thirdstage.exercise.lang.generics.case2.SearchTaskProcessor;
import thirdstage.exercise.lang.generics.case2.SearchTaskStatus;

/**
 * @author 3rdstage
 *
 */
@NotThreadSafe
public class BarSearchTaskProcessor extends
	AbstractSearchTaskProcessor<BarSearchCriteria, BarEvent, BarEventContext> {

	private final static SearchResult<BarEvent, BarEventContext> sampleResult
		= new SearchResult<BarEvent, BarEventContext>();

	static{
		BarEvent ev;
		BarEventContext cntx;

		ev = new BarIntrusionEvent();
		cntx = new BarEventContext(100, "", "20150510120000");
		sampleResult.addItem(ev, cntx);

		ev = new BarPeopleCountEvent(100);
		cntx = new BarEventContext(100, "", "20150510120500");
		sampleResult.addItem(ev, cntx);

		ev = new BarPeopleCountEvent(150);
		cntx = new BarEventContext(100, "", "20150510121000");
		sampleResult.addItem(ev, cntx);

		ev = new BarCrowdDensityEvent(0.8f);
		cntx = new BarEventContext(100, "", "20150510122000");
		sampleResult.addItem(ev, cntx);

	}

	@Override
	public SearchResult<BarEvent, BarEventContext> process(String systemId, String devId,
			String from, String to, BarSearchCriteria criteria){

		SearchResult<BarEvent, BarEventContext> result = new SearchResult<BarEvent, BarEventContext>();

		return sampleResult;
	}

}
