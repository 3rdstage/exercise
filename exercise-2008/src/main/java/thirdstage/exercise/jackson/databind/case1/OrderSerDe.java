/**
 * 
 */
package thirdstage.exercise.jackson.databind.case1;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

/**
 * @author 3rdstage
 *
 */
@ThreadSafe
public class OrderSerDe{
	
	//mapper using Jackson annotation
	private ObjectMapper mapper1;
	
	//mapper using JAXB annotation
	private ObjectMapper mapper2;
	
	
	public OrderSerDe(){
		AnnotationIntrospector intro1 = new JacksonAnnotationIntrospector();
		AnnotationIntrospector intro2 = new JaxbAnnotationIntrospector();
		
		mapper1 = new ObjectMapper();
		mapper2 = new ObjectMapper();
		
		
		mapper1.setAnnotationIntrospector(intro1);
		mapper2.setAnnotationIntrospector(intro2);
		
	}

	public String serializeUsingJacksonAnnotations(@Nonnull Order order) throws Exception{
		if(order == null) throw new IllegalArgumentException("Null is NOT allowed.");
		
		return mapper1.writeValueAsString(order);
	}
	
	public String serializeUsingJaxbAnnotations(@Nonnull Order order) throws Exception{
		if(order == null) throw new IllegalArgumentException("Null is not allowed.");
		
		return mapper2.writeValueAsString(order);
	}
}
