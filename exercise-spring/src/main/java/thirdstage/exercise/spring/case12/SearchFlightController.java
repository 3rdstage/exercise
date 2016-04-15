/**
 * 
 */
package thirdstage.exercise.spring.case12;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * @author   3rdstage
 * @version   1.0, 3rdstage, 2008-03-04
 * @since   2008-03-04
 */
public class SearchFlightController extends SimpleFormController {

	
	private FlightService service = null;
	
	public SearchFlightController(){
		setCommandName("searchCriteria");
		setCommandClass(FlightSearchCriteria.class);
		setFormView("SearchForm");
		setSuccessView("SearchResult");
	}
	
	public void setFlightService(FlightService flightService){
		this.service = flightService;
	}
	
	@Override
	protected void initBinder(HttpServletRequest req, 
			ServletRequestDataBinder binder)throws Exception{
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		
	}
	
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception{
		FlightSearchCriteria criteria = (FlightSearchCriteria) command;
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject("flights", service.findFlights(criteria));
		mav.addObject("searchCriteria", criteria);
		
		return mav;
	}
	
}
