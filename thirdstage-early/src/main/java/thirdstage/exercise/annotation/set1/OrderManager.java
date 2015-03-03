package thirdstage.exercise.annotation.set1;

/**
 *
 * @author 3rdstage
 * @version 0.8, 2007-08-31, 3rdstage
 * @since 2007-08-31
 */
@Controller(processes={@Process(id="PR-ORD-001"), 
                       @Process(id="PR-ORD-002"), 
                       @Process(id="PR-ORD-003")})
public class OrderManager {
	
	/** Creates a new instance of OrderManager */
	public OrderManager() {
	}
	
}
