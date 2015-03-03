
package thirdstage.sample.insurance.managers;

import thirdstage.framework.mars.exceptions.*;
import thirdstage.sample.insurance.values.*;
import thirdstage.sample.insurance.entities.*;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005년 10월 23일 (일)
 * @since 2005년 10월 23일 (일)
 */
public class PersonManagerEJB  implements PersonManager, thirdstage.framework.mars.Manager{
	
	/** Creates a new instance of PersonManagerEJB */
	public PersonManagerEJB() {
		
		
		
	}
	
	public void createPerson(Person person){ }
	
	public void createIndividual(Individual individual){ }
	
	public void createCorporation(Corporation corporation){ }
	
	public Person[] findAllPersons(){
		return null;
	}
	
	public Person findPerson(String id){
		return null;
	}
	
	public Individual[] findAllIndividuals(){
		return null;
	}
	
	public Individual findIndividual(String id){
		return null;
	}
	
	public Corporation[] findAllCorporations(){
		return null;
	}
	
}
