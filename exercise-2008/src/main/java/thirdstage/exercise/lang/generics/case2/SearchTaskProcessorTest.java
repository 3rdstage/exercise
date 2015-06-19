/**
 *
 */
package thirdstage.exercise.lang.generics.case2;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;

import thirdstage.exercise.lang.generics.case2.bar.BarEvent;
import thirdstage.exercise.lang.generics.case2.bar.BarEventContext;
import thirdstage.exercise.lang.generics.case2.bar.BarPeopleCountEvent;
import thirdstage.exercise.lang.generics.case2.bar.BarSearchCriteria;
import thirdstage.exercise.lang.generics.case2.bar.BarSearchTaskProcessor;
import thirdstage.exercise.lang.generics.case2.foo.FooEvent;
import thirdstage.exercise.lang.generics.case2.foo.FooEventContext;
import thirdstage.exercise.lang.generics.case2.foo.FooSearchCriteria;
import thirdstage.exercise.lang.generics.case2.foo.FooSearchTaskProcessor;

/**
 * @author 3rdstage
 *
 */
public class SearchTaskProcessorTest {

	@Test
	public void testFooSearchTaskProcessor1(){
		SearchTaskProcessor processor = null;

		processor = new FooSearchTaskProcessor();
		SearchResult result = processor.process("Foo01", "CCTV100", "201505100000", "201505102359", new FooSearchCriteria());
		List<Pair> items = result.getItems();
		Assert.assertEquals(items.size(), 3);

		for(Pair item : items){
			System.out.println("Found " + item.getLeft().toString() + " at " + item.getRight().toString());
		}

		List<Pair<FooEvent, FooEventContext>> items2 = result.getItems();
		Assert.assertEquals(items2.get(0).getLeft().getType(), EventType.INTRUSION);
		Assert.assertEquals(items2.get(1).getLeft().getType(), EventType.PEOPLE_COUNT);
		Assert.assertEquals(items2.get(1).getLeft().getProperty("COUNT"), new Integer(100));
		Assert.assertEquals(items2.get(1).getRight().getFileId(), "20150510-1205-10");
	}

	@Test
	public void testBarSearchTaskProcessor1(){

		SearchTaskProcessor processor = new BarSearchTaskProcessor();
		SearchResult result = processor.process("Bar01", "100", "201505100000", "201505102359", new BarSearchCriteria());

		List<Pair> items = result.getItems();
		Assert.assertEquals(items.size(), 4);

		for(Pair item : items){
			System.out.println("Found " + item.getLeft().toString() + " at " + item.getRight().toString());
		}

		List<Pair<BarEvent, BarEventContext>> items2 = result.getItems();
		Assert.assertEquals(items2.get(0).getLeft().getType(), EventType.INTRUSION);
		Assert.assertEquals(items2.get(1).getLeft().getType(), EventType.PEOPLE_COUNT);
		Assert.assertEquals(items2.get(1).getLeft().getClass(), BarPeopleCountEvent.class);
		Assert.assertEquals(((BarPeopleCountEvent)items2.get(1).getLeft()).getCount(), 100);
		Assert.assertEquals(items2.get(1).getRight().getTime(), "20150510120500");
		Assert.assertEquals(items2.get(1).getRight().getFileName(), "");

	}


}
