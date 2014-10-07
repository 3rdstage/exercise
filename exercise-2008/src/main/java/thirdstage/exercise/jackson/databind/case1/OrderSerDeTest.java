package thirdstage.exercise.jackson.databind.case1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderSerDeTest {

	
	private static OrderSerDe serDe;
	
	private static Order order1;
	
	@BeforeClass
	public void beforeClass(){
		serDe = new OrderSerDe();
		
		order1 = new Order();
		order1.setId("ORD1000");
		order1.setPoNo("PO10000");
		order1.setCreateDate("2014-07-31 11:11:00");
	}
	
	@Test
	public void testSerializeUsingJacksonAnnotations() throws Exception{
		
		System.out.println(serDe.serializeUsingJacksonAnnotations(order1));
	}
	
	@Test
	public void testSerializeUsingJaxbAnnotations() throws Exception{
		
		System.out.println(serDe.serializeUsingJaxbAnnotations(order1));
	}


}
