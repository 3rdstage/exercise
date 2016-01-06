/**
 * 
 */
package thirdstage.exercise.ibatis.case15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author 3rdstage
 *
 */
public class EmployeeDaoJdbcPrepared implements EmployeeDao{

	private DataSource dataSource;

	public EmployeeDaoJdbcPrepared(){}

	protected DataSource getDataSource(){
		return this.dataSource;
	}

	@Required
	public void setDataSource(DataSource ds){
		this.dataSource = ds;
	}	
	
	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case15.EmployeeDao#addEmployee(thirdstage.exercise.ibatis.case15.Employee)
	 */
	public void addEmployee(Employee emp){
	// TODO Auto-generated method stub
		throw new RuntimeException("Not yet implemented");

	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case15.EmployeeDao#addEmployees(java.util.List)
	 */
	public void addEmployees(List<Employee> emps){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try{
			conn = this.getDataSource().getConnection();
			conn.setAutoCommit(false);
			sql = "insert into employees_min (id, name) values (?, ?)";
			pstmt = conn.prepareStatement(sql);

			for(Employee emp : emps){
				pstmt.setLong(1, emp.getId());
				pstmt.setString(2, emp.getName());
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			conn.commit();
			
		}catch(RuntimeException ex){
			if(conn != null){ try{conn.rollback(); }catch(Exception ex2){}}
			throw ex;
		}catch(Exception ex){
			if(conn != null){ try{conn.rollback(); }catch(Exception ex2){}}
			throw new RuntimeException(ex);
		}finally{
			if(pstmt != null){ try{pstmt.close();}catch(Exception ex){}}
			if(conn != null){ try{conn.close();}catch(Exception ex){}}
		}
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case15.EmployeeDao#findEmployee(java.lang.Long)
	 */
	public Employee findEmployee(Long id){

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;

		try{
			conn = this.getDataSource().getConnection();
			sql = "select id, name from employees_min where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			rs = pstmt.executeQuery(sql);

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
			if(rs != null){
				try{
					rs.close();
				}catch(Exception ex){}
			}
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(Exception ex){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(Exception ex){}
			}
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
