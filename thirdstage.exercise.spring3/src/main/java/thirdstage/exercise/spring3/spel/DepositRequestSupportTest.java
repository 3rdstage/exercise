package thirdstage.exercise.spring3.spel;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DepositRequestSupportTest {
	
	private static DepositRequestSupport support;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		support = new DepositRequestSupport();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testCheck1(){
		DepositRequest req = new DepositRequest("foo", "ACC100", 2000.0);
		
		boolean b1 = support.check(req, "#root.amount > 1000");
		
		Assert.assertTrue(b1);
	}
	
	@Test
	public void testCheck2(){
		
		List<DepositRequest> reqs = new ArrayList<DepositRequest>();
		
		int no = 10;
		DepositRequest req = null;
		for(int i = 0; i < no; i++){
			req = new DepositRequest( i%2 == 0 ? "foo" : "bar", i%2 == 0 ? "ACC100" : "ACC200", i*1000.0);
			reqs.add(req);
		}
		
		int cnt = 0;
		for(DepositRequest r : reqs){
			if(support.check(r, "'foo'.equals(#root.client) and (#root.amount > 5000)")) cnt++;
		}
		
		Assert.assertEquals(2, cnt);
	}
	
}
