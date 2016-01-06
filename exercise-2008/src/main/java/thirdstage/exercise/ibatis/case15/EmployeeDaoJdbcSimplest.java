/**
 * 
 */
package thirdstage.exercise.ibatis.case15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * @author 3rdstage
 *
 */
public class EmployeeDaoJdbcSimplest implements EmployeeDao{

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case15.EmployeeDao#addEmployee(thirdstage.exercise.ibatis.case15.Employee)
	 */
	public void addEmployee(Employee emp){
	// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case15.EmployeeDao#addEmployees(java.util.List)
	 */
	public void addEmployees(List<Employee> emps){

		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "exercise", "exercisedev");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			for(Employee emp : emps){
				sql = "insert into employees_min (id, name) values (" + emp.getId() + ", '" + emp.getName() + "')";
				stmt.addBatch(sql);
			}
			
			stmt.executeBatch();
			conn.commit();
			
		}catch(RuntimeException ex){
			if(conn != null){ try{conn.rollback(); }catch(Exception ex2){}}
			throw ex;
		}catch(Exception ex){
			if(conn != null){ try{conn.rollback(); }catch(Exception ex2){}}
			throw new RuntimeException(ex);
		}finally{
			if(stmt != null){ try{stmt.close();}catch(Exception ex){}}
			if(conn != null){ try{conn.close();}catch(Exception ex){}}
		}
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case15.EmployeeDao#findEmployee(java.lang.Long)
	 */
	public Employee findEmployee(Long id){
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		ResultSet rs = null;
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "exercise", "exercisedev");
			stmt = conn.createStatement();
			sql = "select id, name from employees_min where id = " + id;
			rs = stmt.executeQuery(sql);

			Employee emp = null;

			if(rs.next()){
				emp = new Employee();
				emp.setId(rs.getLong("id"));
				emp.setName(rs.getString("name"));
			}
			
			return emp;
			
		}catch(RuntimeException ex){
			throw ex;
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}finally{
			if(rs != null){ try{rs.close();}catch(Exception ex){}}
			if(stmt != null){ try{stmt.close();}catch(Exception ex){}}
			if(conn != null){ try{conn.close();}catch(Exception ex){}}
		}
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case15.EmployeeDao#removeEmployees(java.util.List)
	 */
	public void removeEmployees(List<Long> ids){
	// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not yet implemented.");

	}

}
