package thirdstage.exercise.spring.transaction.case2;

import org.springframework.dao.DataAccessException;
import thirdstage.exercise.spring.transaction.case2.entities.Company;

public interface CompanyService{
	
	Company getCompany(Long id) throws DataAccessException;
	
	void addCompany(Company company) throws DataAccessException;

}
