package thirdstage.exercise.spring.case13;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class PersonFormController extends SimpleFormController {
	
	private String[] languages = new String[]{"Java", "Ruby", "Python"};
	
	public PersonFormController(){
		
		setCommandName("person");
		setCommandClass(Person.class);
		setFormView("exercises/spring/case13/NewPerson");
		setSuccessView("exercises/spring/case13/NewPersonSuccess");
		
	}
	
	@Override
	protected void initBinder(HttpServletRequest request, 
			       ServletRequestDataBinder binder) throws Exception{
		binder.registerCustomEditor(java.util.Date.class, 
		        new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
		
	}
	
	@Override
	protected java.util.Map referenceData(HttpServletRequest req) throws Exception{
		
		java.util.Map data = new java.util.HashMap();
		data.put("languages", languages);
		return data;
	}
	
	@Override
	protected void doSubmitAction(Object command) throws Exception{
		Person person = (Person)command;
	}
	
	

}
