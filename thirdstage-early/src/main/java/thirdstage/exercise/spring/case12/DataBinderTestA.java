package thirdstage.exercise.spring.case12;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;

import junit.framework.TestCase;

public class DataBinderTestA extends TestCase {
	
	ServletRequestDataBinder binder = null;
	MockHttpServletRequest request = null;

	protected void setUp() throws Exception {
	}

	public void testSimpleBinding() {

		Name name = new Name();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(name, "nameBean");
		MockHttpServletRequest request = new MockHttpServletRequest();

		request.addParameter("firstName", "Anya");
		request.addParameter("lastName", "Lala");

		binder.bind(request);

		assertEquals("Anya", name.getFirstName());
		assertEquals("Lala", name.getLastName());
	}
	
	public void testNestedBinding(){
		
		Person person = new Person();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(person, "personBean");
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		request.addParameter("name.firstName", "Anya");
		request.addParameter("name.lastName", "Lala");
		
		binder.bind(request);
		
		assertEquals("Anya", person.getName().getFirstName());
		assertEquals("Lala", person.getName().getLastName());
	}
	
	public void testListBinding(){
		
		List<Name> names = new ArrayList<Name>();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(names, "namesBean");
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		names.add(new Name());
		names.add(new Name());
		
		//@to-do how to define request?
		assert(false);
	}
	
	
	public void testNestedListBinding(){
		
		NameListBean names = new NameListBean();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(names, "namesBean");
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		request.addParameter("names[0].firstName", "Anya");
		request.addParameter("names[0].lastName", "Lala");
		request.addParameter("names[1].firstName", "Tom");
		request.addParameter("names[1].lastName", "Cruise");
		
		
		binder.bind(request);
		
		assertEquals("Anya", names.getNames().get(0).getFirstName());
		assertEquals("Lala", names.getNames().get(0).getLastName());
		assertEquals("Tom", names.getNames().get(1).getFirstName());
		assertEquals("Cruise", names.getNames().get(1).getLastName());
	}

	public void testNestedArrayBinding(){
		
		NameArrayBean names = new NameArrayBean();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(names, "namesBean");
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		request.addParameter("names[0].firstName", "Anya");
		request.addParameter("names[0].lastName", "Lala");
		request.addParameter("names[1].firstName", "Tom");
		request.addParameter("names[1].lastName", "Cruise");
		
		
		binder.bind(request);
		
		assertEquals("Anya", names.getNames()[0].getFirstName());
		assertEquals("Lala", names.getNames()[0].getLastName());
		assertEquals("Tom", names.getNames()[1].getFirstName());
		assertEquals("Cruise", names.getNames()[1].getLastName());
	}

	public void testMultiTypeBinding() throws MalformedURLException{
		MultiTypeBean bean = new MultiTypeBean();
		
		ServletRequestDataBinder binder = new ServletRequestDataBinder(bean, "multiTypeBean");
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		request.addParameter("intProperty", "34");
		request.addParameter("integerProperty", "200");
		request.addParameter("classProperty", "java.util.Calendar");
		request.addParameter("urlProperty", "http://www.google.com");
		
		binder.bind(request);
		
		assertEquals(34, bean.getIntProperty());
		assertEquals(new Integer(200), bean.getIntegerProperty());
		assertEquals(java.util.Calendar.class, bean.getClassProperty());
		assertEquals(new URL("http://www.google.com"), bean.getUrlProperty());
	}
	
	public void testCustomDateEditor() throws Exception{
		
		DateBean bean = new DateBean();
		
		ServletRequestDataBinder binder = new ServletRequestDataBinder(bean, "dateBean");
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date expected = dateFormat.parse("2001-01-01");
		
		CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, dateEditor);
		
		request.addParameter("date", "2001-01-01");
		
		binder.bind(request);
		
		assertEquals(expected, bean.getDate());
	}
	
}

class Name {
	private String firstName = null;
	private String lastName = null;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

class Person {
	private Name name = new Name(); //shouldn't be null for nested binding

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}

class NameListBean{
	private List<Name> names = new ArrayList<Name>(); //shouldn't be null for nested binding
	
	public NameListBean(){
		//should initialize as many names as needed.
		names.add(new Name());
		names.add(new Name());
	}

	public List<Name> getNames() {
		return names;
	}

	public void setNames(List<Name> names) {
		this.names = names;
	}
}


class NameArrayBean{
	private Name[] names = new Name[]{new Name(), new Name()};

	public Name[] getNames() {
		return names;
	}

	public void setNames(Name[] names) {
		this.names = names;
	}
	
	
}

class MultiTypeBean{
	
	private int intProperty = 0;
	private Integer integerProperty = null;
	private Class classProperty = null;
	private URL urlProperty = null;
	public int getIntProperty() {
		return intProperty;
	}
	public void setIntProperty(int intProperty) {
		this.intProperty = intProperty;
	}
	public Integer getIntegerProperty() {
		return integerProperty;
	}
	public void setIntegerProperty(Integer integerProperty) {
		this.integerProperty = integerProperty;
	}
	public Class getClassProperty() {
		return classProperty;
	}
	public void setClassProperty(Class classProperty) {
		this.classProperty = classProperty;
	}
	public URL getUrlProperty() {
		return urlProperty;
	}
	public void setUrlProperty(URL urlProperty) {
		this.urlProperty = urlProperty;
	}


}

class DateBean{
	
	private Date date = null;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
