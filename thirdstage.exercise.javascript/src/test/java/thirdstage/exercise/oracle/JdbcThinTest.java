package thirdstage.exercise.oracle;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

public class JdbcThinTest {
	
	@Test
	public void testOracleJdbcThinDriver1(){
		
		Connection conn = null;
		String url = "jdbc:oracle:thin:@203.235.212.178:1521/nexcore";
		
		try{
			Properties props = new Properties();
			props.setProperty("user", "idp_fwk");
			props.setProperty("password", "idp_fwk");
			props.setProperty("v$session.program", "My Program");
			props.setProperty("v$session.machine", InetAddress.getLocalHost().getHostAddress());
			props.setProperty("v$session.terminal", InetAddress.getLocalHost().getCanonicalHostName());
			
			conn = DriverManager.getConnection(url, props);

			System.in.read();

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
