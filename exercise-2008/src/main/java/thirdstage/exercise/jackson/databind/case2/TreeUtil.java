/**
 * 
 */
package thirdstage.exercise.jackson.databind.case2;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

/**
 * @author 3rdstage
 *
 */
@ThreadSafe
public class TreeUtil{
	
	private ObjectMapper jsonMapper; //thread-safe
	
	public TreeUtil(){
		this.jsonMapper = new ObjectMapper();
		this.jsonMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
	}
	
 
	public String serializeTreeToJson(@Nonnull Tree tree) throws Exception{
		if(tree == null) throw new IllegalArgumentException("Null is NOT allowed.");
		
		return this.jsonMapper.writeValueAsString(tree);
	}
	
	public String serializeTreeToIndentedJson(@Nonnull Tree tree) throws Exception{
		return this.jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(tree);
	}

}
