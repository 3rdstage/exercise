/*
 * UserDAO.java
 *
 * Created on 2005-02-17
 */

package thirdstage.accesscontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.NamingException;
import thirdstage.platform.web.ServiceLocatorFactory;
import thirdstage.accesscontrol.beans.UserBean;
import thirdstage.accesscontrol.vo.*;

/**
 *
 * @author 3rdstage
 */
public class UserDAO extends thirdstage.framework.mercury.AbstractDAO {
			
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserDAO.class);

	/** Creates a new instance of UserDAO */
	public UserDAO() {
	}
	
	//TO-DO
	//change API to createUser(UserValue user) 
	public void createUser(UserNormalValue user) throws java.sql.SQLException, javax.naming.NamingException, IllegalArgumentException{
		logger.debug("method entered : UserDAO.createUser");
		
		if(user == null) throw new IllegalArgumentException("the argument user should not be null");
		
		DataSource ds = null;
		Connection conn = null;
		String sql = null;
		PreparedStatement pstmt = null;
		
		try{
			ds = ServiceLocatorFactory.getInstance().getServiceLocator("AccessControl")
                                   .getDataSource("java:comp/env/jdbc/AccessControlDB");

			conn = ds.getConnection();
			//conn.setAutoCommit(true); //Is this concerned with UserTransaction control in JTS ?
			
			sql = "INSERT INTO UserTB (id, roleId, passwd, passwdHash, name, rrn) VALUES (?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			//setting sql parameters
			pstmt.setString(1, user.getId());
			pstmt.setInt(2, Integer.parseInt(user.getRoleId()));
			pstmt.setString(3, user.getPassword()); //don't store password
			pstmt.setString(4, user.getPasswordHash());
			pstmt.setString(5, user.getName());
			pstmt.setString(6, user.getResidentRegistrationNo());

			pstmt.executeUpdate();
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
	
	public UserNormalValue[] getAllUsersInNormalValue() 
	       throws java.sql.SQLException, javax.naming.NamingException{
	
		logger.debug("method entered : UserDAO.getAllUsersInNormalValue");
		
		DataSource ds = null;
		Connection conn = null;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		java.util.List users = new java.util.ArrayList();
		
		try{
			ds = ServiceLocatorFactory.getInstance().getServiceLocator("AccessControl")
	                                .getDataSource("java:comp/env/jdbc/AccessControlDB");

			conn = ds.getConnection();
			
			//conn.setAutoCommit(true); //Is this concerned with UserTransaction control in JTS ?
			
			sql = "SELECT a.id, a.name, a.rrn, a.roleId, b.name "
				 + "FROM UserTB AS a, RoleTB AS b "
				 + "WHERE a.roleId = b.id";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			UserNormalValue user = null;
			while(rs.next()){
				user = new UserNormalValue(rs.getString("a.id"), "", "", 
						                     rs.getString("a.name"), rs.getString("a.rrn"), 
						                     rs.getString("a.roleId"), rs.getString("b.name"));
				users.add(user);
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
		
		return (UserNormalValue[])(users.toArray(new UserNormalValue[users.size()]));		
	
	}
	
}
