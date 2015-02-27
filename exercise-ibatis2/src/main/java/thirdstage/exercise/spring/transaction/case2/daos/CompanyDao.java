package thirdstage.exercise.spring.transaction.case2.daos;

import java.util.List;
import org.springframework.dao.DataAccessException;
import thirdstage.exercise.spring.transaction.case2.entities.Company;

public interface CompanyDao{
	
	List<Company> getAllCompanies() throws DataAccessException;
	Company getCompany(Long id) throws DataAccessException;
	long getNumberOfAllCompanies() throws DataAccessException;
	
	void addCompany(Company company) throws DataAccessException;

}
