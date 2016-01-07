/**
 * 
 */
package thirdstage.exercise.ibatis.case15;

import java.util.List;

/**
 * @author 3rdstage
 *
 */
public interface EmployeeDao{
	
	Employee findEmployee(Long id);
	
	void addEmployee(Employee emp);
	
	void addEmployees(List<Employee> emps);
	
	void removeEmployees(List<Long> ids);
}
