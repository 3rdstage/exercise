/**
 *
 */
package thirdstage.exercise.lang.generics.case2.foo;

import org.apache.commons.lang3.tuple.Pair;

import thirdstage.exercise.lang.generics.case1.Shape;
import thirdstage.exercise.lang.generics.case2.AbstractSearchTaskProcessor;
import thirdstage.exercise.lang.generics.case2.EventType;
import thirdstage.exercise.lang.generics.case2.SearchResult;
import thirdstage.exercise.lang.generics.case2.SearchTaskProcessor;
import thirdstage.exercise.lang.generics.case2.SearchTaskStatus;
import thirdstage.exercise.lang.generics.case2.bar.BarCrowdDensityEvent;
import thirdstage.exercise.lang.generics.case2.bar.BarEvent;
import thirdstage.exercise.lang.generics.case2.bar.BarEventContext;
import thirdstage.exercise.lang.generics.case2.bar.BarIntrusionEvent;
import thirdstage.exercise.lang.generics.case2.bar.BarPeopleCountEvent;
import thirdstage.exercise.lang.generics.case2.bar.BarSearchCriteria;

/**
 * @author 3rdstage
 *
 */
public class FooSearchTaskProcessor extends
	AbstractSearchTaskProcessor<FooSearchCriteria, FooEvent, FooEventContext>{

	private final static SearchResult<FooEvent, FooEventContext> sampleResult
	= new SearchResult<FooEvent, FooEventContext>();

	static{
		FooEvent ev;
		FooEventContext cntx;
		Pair<String, ?> param;

		ev = new FooEvent(EventType.INTRUSION);
		cntx = new FooEventContext("CCTV100", "20150510-1200-1", 1233);
		sampleResult.addItem(ev, cntx);

		ev = new FooEvent(EventType.PEOPLE_COUNT, Pair.of("COUNT", 100));
		cntx = new FooEventContext("CCTV100", "20150510-1205-10", 567832);
		sampleResult.addItem(ev, cntx);

		ev = new FooEvent(EventType.CROWD_DENSITY, Pair.of("DENSITY", 0.8f));
		cntx = new FooEventContext("CCTV100", "20150510-1220-5", 21333890);
		sampleResult.addItem(ev, cntx);

	}


	@Override
	public SearchResult<FooEvent, FooEventContext> process(String systemId, String devId,
			String from, String to, FooSearchCriteria criteria){

		SearchResult<BarEvent, BarEventContext> result = new SearchResult<BarEvent, BarEventContext>();

		return sampleResult;
	}

}
