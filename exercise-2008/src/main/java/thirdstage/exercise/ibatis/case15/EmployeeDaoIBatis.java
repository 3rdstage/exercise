/**
 * 
 */
package thirdstage.exercise.ibatis.case15;

import java.util.List;
import org.springframework.beans.factory.annotation.Required;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author 3rdstage
 *
 */
public class EmployeeDaoIBatis implements EmployeeDao{
	
	private SqlMapClient sqlMapClient;
	
	public EmployeeDaoIBatis(){}
	
	
	@Required
	public void setSqlMapClient(SqlMapClient sqlMapClient){
		this.sqlMapClient = sqlMapClient;
	}
	
	protected SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case15.EmployeeDao#addEmployee(thirdstage.exercise.ibatis.case15.Employee)
	 */
	public void addEmployee(Employee emp){
		try{
			this.getSqlMapClient().insert("Employee.addEmployee", emp);
		}catch(RuntimeException ex){
			throw ex;
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case15.EmployeeDao#addEmployees(java.util.List)
	 */
	public void addEmployees(List<Employee> emps){
		throw new RuntimeException("Not yet implemented");
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case15.EmployeeDao#findEmployee(java.lang.Long)
	 */
	public Employee findEmployee(Long id){
		try{
			return (Employee)this.getSqlMapClient().queryForObject("Employee.findEmployee", id);
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case15.EmployeeDao#removeEmployees(java.util.List)
	 */
	public void removeEmployees(List<Long> ids){
	// TODO Auto-generated method stub
		throw new RuntimeException("Not yet implemented");

	}

}
