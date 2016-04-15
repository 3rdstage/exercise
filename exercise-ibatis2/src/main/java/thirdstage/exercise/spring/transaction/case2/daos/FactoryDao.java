package thirdstage.exercise.spring.transaction.case2.daos;

import java.util.List;
import org.springframework.dao.DataAccessException;
import thirdstage.exercise.spring.transaction.case2.entities.Factory;

/**
 * This class assumes MySQL database underneath.
 * 
 * @author 3rdstage
 * 
 */
public interface FactoryDao{
	
	List<Factory> getAllFactories() throws DataAccessException;
	List<Factory> getFactoriesOfCompany(Long companyId) throws DataAccessException;
	Factory getFactory(Long id) throws DataAccessException;
	long getNumberOfAllFactories() throws DataAccessException;
	
	void addFactory(Factory factory) throws DataAccessException;

}
