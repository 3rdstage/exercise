/*
 * RoleDAO.java
 *
 * Created on 2005-02-18
 */

package thirdstage.accesscontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import javax.naming.NamingException;
import thirdstage.platform.web.ServiceLocatorFactory;
import thirdstage.accesscontrol.vo.RoleMinValue;
import thirdstage.accesscontrol.vo.RoleNormalValue;

/**
 *
 * @author 3rdstage
 */
public class RoleDAO extends thirdstage.framework.mercury.AbstractDAO{
			
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RoleDAO.class);

	
	/** Creates a new instance of RoleDAO */
	public RoleDAO() {
		
		
	}
	
	/**
	 *
	 * @return empty array if there's no role
	 */
	public RoleMinValue[] getAllRolesInMinValue() throws java.sql.SQLException, javax.naming.NamingException{
		logger.debug("method entered : RoleDAO.getAllRolesInMinValue");
		
		DataSource ds = null;
		Connection conn = null;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		java.util.List roles = new java.util.ArrayList();
		
		try{
			ds = ServiceLocatorFactory.getInstance().getServiceLocator("AccessControl")
			                          .getDataSource("java:comp/env/jdbc/AccessControlDB");

			conn = ds.getConnection();
			
			//conn.setAutoCommit(true); //Is this concerned with UserTransaction control in JTS ?
			
			sql = "SELECT id, name FROM RoleTB ORDER BY name ASC";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				roles.add(new RoleMinValue(rs.getString("id"), rs.getString("name")));
			}
		}
		catch(javax.naming.NamingException ex){
			logger.error("can't get InitialContext", ex);
			throw ex;
		}
		catch(java.sql.SQLException ex){
			logger.error("can't perform sql task properly", ex);
			throw ex;
		}
		catch(IllegalStateException ex){
			logger.error("", ex);
			throw new javax.naming.NamingException(ex.getMessage());
		}
		finally{
			if(rs != null){
				try{ rs.close(); }
				catch(Exception ex){ logger.error("can't close ResultSet", ex); }
			}
			if(pstmt != null){
				try{ pstmt.close(); }
				catch(Exception ex){ logger.error("can't close PreparedStatement", ex); }
			}
			if(conn != null){
				try{ conn.close(); }
				catch(Exception ex){ logger.error("can't close Connection", ex); }
			}
		}
		
		logger.debug("method leaving : RoleDAO.getAllRolesInMinValue");
		return (RoleMinValue[])(roles.toArray(new RoleMinValue[roles.size()]));
	}
	
	/**
	 *
	 * @return empty array if there's no role
	 */
	public RoleNormalValue[] getAllRolesInNormalValue() throws java.sql.SQLException, javax.naming.NamingException{
		logger.debug("method entered : RoleDAO.getAllRolesInNormalValue");
		
		DataSource ds = null;
		Connection conn = null;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		java.util.List roles = new java.util.ArrayList();
		
		try{
			ds = ServiceLocatorFactory.getInstance().getServiceLocator("AccessControl")
			                          .getDataSource("java:comp/env/jdbc/AccessControlDB");
			conn = ds.getConnection();
			
			//conn.setAutoCommit(true); //Is this concerned with UserTransaction control in JTS ?
			
			sql = "SELECT id, name, description FROM RoleTB ORDER BY id ASC";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				roles.add(new RoleNormalValue(rs.getString("id"), rs.getString("name"), rs.getString("description")));
			}
		}
		catch(javax.naming.NamingException ex){
			logger.error("can't get InitialContext", ex);
			throw ex;
		}
		catch(java.sql.SQLException ex){
			logger.error("can't perform sql task properly", ex);
			throw ex;
		}
		finally{
			if(rs != null){
				try{ rs.close(); }
				catch(Exception ex){ logger.error("can't close ResultSet", ex); }
			}
			if(pstmt != null){
				try{ pstmt.close(); }
				catch(Exception ex){ logger.error("can't close PreparedStatement", ex); }
			}
			if(conn != null){
				try{ conn.close(); }
				catch(Exception ex){ logger.error("can't close Connection", ex); }
			}
		}
		
		return (RoleNormalValue[])(roles.toArray(new RoleNormalValue[roles.size()]));
	}
	
	public void createRole(RoleNormalValue role) throws java.sql.SQLException, javax.naming.NamingException{
		logger.debug("method entered : RoleDAO.createRole");
		
		if(role == null) throw new IllegalArgumentException("The argument role should not be null");
		
		DataSource ds = null;
		Connection conn = null;
		String sql = null;
		PreparedStatement pstmt = null;
		
		try{
			ds = ServiceLocatorFactory.getInstance().getServiceLocator("AccessControl")
			                          .getDataSource("java:comp/env/jdbc/AccessControlDB");
			conn = ds.getConnection();
			
			sql = "INSERT INTO RoleTB (id, name, description) "
				 +	"SELECT max(id) + 1, ?, ? FROM RoleTB";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, role.getName());
			pstmt.setString(2, role.getDescription());
			pstmt.executeUpdate();
		}
		catch(javax.naming.NamingException ex){
			logger.error("Can't get InitialContext", ex);
			throw ex;
		}
		catch(java.sql.SQLException ex){
			logger.error("Can't perform sql task properly", ex);
			throw ex;
		}
		finally{
			if(pstmt != null){
				try{ pstmt.close(); }
				catch(Exception ex){ logger.error("can't close PreparedStatement", ex); }
			}
			if(conn != null){
				try{ conn.close(); }
				catch(Exception ex){ logger.error("can't close Connection", ex); }
			}
		}
		
	}
	
}
