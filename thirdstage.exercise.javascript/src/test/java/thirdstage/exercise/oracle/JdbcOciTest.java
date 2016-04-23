package thirdstage.exercise.oracle;

import java.io.Console;
import java.sql.*;

import org.junit.Test;


public class JdbcOciTest {
	

	@Test
	public void testJdbcOci1(){
		
		Connection conn = null;
		Console cons = System.console();
		String url = "jdbc:oracle:oci:@(DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)" 
					+ "(HOST=203.235.212.178)(PORT=1521))"
					+ "(CONNECT_DATA=(SERVICE_NAME=nexcore)))";
		
		try{
			conn = DriverManager.getConnection(url);
			
			
			cons.readLine();
		}catch(Exception ex){
			
		}finally{
			if(conn != null){ 
				try{ conn.close(); }
				catch(Exception ex){} 
			}
		}
	}
	

}
