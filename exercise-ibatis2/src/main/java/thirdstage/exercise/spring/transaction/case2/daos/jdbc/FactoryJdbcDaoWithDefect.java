/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2.daos.jdbc;

import thirdstage.exercise.spring.transaction.case2.entities.Factory;

/**
 * This class has defect in {@link #addFactory(Factory)} method
 * 
 * @author 3rdstage
 * 
 */
public class FactoryJdbcDaoWithDefect extends FactoryJdbcDao{

	/**
	 * This method has defect so only throws Exception.
	 * 
	 */
	@Override
	public void addFactory(Factory factory){
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
