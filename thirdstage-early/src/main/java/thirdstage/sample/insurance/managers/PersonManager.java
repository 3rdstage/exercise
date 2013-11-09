package thirdstage.sample.insurance.managers;

import thirdstage.framework.mars.exceptions.*;
import thirdstage.sample.insurance.values.*;
import thirdstage.sample.insurance.entities.*;

/**
 *
 * @author 3rdstage
 * @version 1.0, 3rdstage, 2005년 10월 23일 (일)
 * @since 2005년 10월 23일 (일)
 */
public interface PersonManager extends thirdstage.framework.mars.Manager {
	
	public void createPerson(Person person) throws SystemException;
	
	public void createIndividual(Individual individual) throws SystemException;
	
	public void createCorporation(Corporation corporation) throws SystemException;
	
	/**
	 * @return ... or empty array if no person exists
	 */
	public Person[] findAllPersons() throws SystemException;
	
	/**
	 *
	 */
	public Person findPerson(String id) throws SystemException;
	
	
	/**
	 * Gets all individuals data in value object. The returned array would be ordered
	 * by individual's id ascendantly
	 *
	 * @return array of value object for all individuals or empty array if no individual exists
	 */
	public Individual[] findAllIndividuals() throws SystemException;
	
	
	/**
	 *
	 */
	public Individual findIndividual(String id) throws SystemException;
	
	/**
	 * @return ... or empty array if no corporation exists
	 */
	public Corporation[] findAllCorporations() throws SystemException;
	
	
	
	
	
}
