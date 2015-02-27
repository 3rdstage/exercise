
package thirdstage.platform.template;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005년 11월 7일 (월), 3rdstage
 * @since 2005년 11월 7일 (월)
 */
public class InitialContextTemplate implements Template{
	
	/** Creates a new instance of InittialContextTemplate */
	public InitialContextTemplate() {
		
		
	}
	
	
	public void template(){
		javax.naming.Context ctx = null;
		javax.sql.DataSource ds = null;
		
		try{
			ctx = new javax.naming.InitialContext();
			ds = (javax.sql.DataSource)(ctx.lookup("java:comp/env/jdbc/DefaultDB"));
			
			//...
		}
		catch(javax.naming.NamingException ex){
			//...
		}
		catch(Exception ex){
			//..
		}
	}
}
