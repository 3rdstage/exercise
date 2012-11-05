package thirdstage.exercise.spring.transaction.case2.daos.jdbc;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import thirdstage.exercise.spring.transaction.case2.entities.Factory;

/**
 * This class has defect in {@link #addFactory(Factory)} method which
 * has transaction attribute of NOT_SUPPORTED.
 * 
 * @author 3rdstage
 *
 */
public class FactoryJdbcDaoWithDefect2 extends FactoryJdbcDao{

	
	/**
	 * IMPORTANT Transaction roll-back
	 *  
	 * An run-time exception raised in NOT_SUPPORTED method
	 * called by REQUITED method will roll-back the caller method.
	 * Try the JUnit test case.
	 * 
	 * This method has defect so only throws Exception.
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addFactory(Factory factory){
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
