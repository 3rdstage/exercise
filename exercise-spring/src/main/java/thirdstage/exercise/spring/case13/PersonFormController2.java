package thirdstage.exercise.spring.case13;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class PersonFormController2 extends SimpleFormController {
	
	private String[] languages = new String[]{"Java", "Ruby", "Python"};
	private PersonDao personDao;
	
	public PersonFormController2(){
		
		setCommandName("person");
		setCommandClass(Person.class);
		setFormView("exercises/spring/case13/NewPerson");
		setSuccessView("exercises/spring/case13/NewPersonSuccess2");
		
	}
	
	public void setPersonDao(PersonDao dao){
		this.personDao = dao;
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
	protected ModelAndView onSubmit(Object command) throws Exception{
		Person person = (Person)command;
		this.personDao.persist(person);
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("suggestedBook", suggestBook(person.getFavoriteProgrammingLanguage()));
		model.put(this.getCommandName(), person.toString());
		
		return new ModelAndView(this.getSuccessView(), model);
	}
	
	
	public String suggestBook(String favoriteProgrammingLanguage){
		Language language = Language.create(favoriteProgrammingLanguage);
		return language.recommendBookTitle();
		
	}
	

}
