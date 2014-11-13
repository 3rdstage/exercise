package thirdstage.exercise.oracle;

import java.io.Console;
import java.sql.*;

import org.junit.Test;


public class JdbcOciTestMain {
	

	public static void main(String[] arg) throws Exception{
		
		Connection conn = null;
		
		System.out.println("Env. Var. = " + System.getenv());
		System.out.println("PATH = " + System.getenv().get("Path"));
		
		String url = "jdbc:oracle:oci:@(DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)" 
					+ "(HOST=203.235.212.178)(PORT=1521))"
					+ "(CONNECT_DATA=(SERVICE_NAME=nexcore)))";
		
		//url = "jdbc:oracle:oci:@203.235.212.178:1521/nexcore";
		
		try{
			conn = DriverManager.getConnection(url);
			
			
			System.console().readLine();

		}catch(Exception ex){
			ex.printStackTrace(System.err);
			
		}finally{
			if(conn != null){ 
				try{ conn.close(); }
				catch(Exception ex){} 
			}
		}
	}
	

}
