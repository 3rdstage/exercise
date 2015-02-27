package thirdstage.exercise.spring.case12;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * @author   3rdstage
 */
public class HomeController extends AbstractController {
	
	private static final int FIVE_MINUTES = 5*60;
	private FlightService service = null;
	
	public HomeController(){
		setRequireSession(false);
		setSupportedMethods(new String[]{METHOD_GET});
		setCacheSeconds(FIVE_MINUTES);
	}

	public void setFlightService(FlightService flightService){
		this.service = flightService;
	}
	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView("Home");
		mav.addObject("specials", service.getSpecialDeals());
		return mav;
	}

}
