package thirdstage.exercise.misc;

import org.hibernate.SessionFactory;
/**
 *
 * @author 3rdstage
 * @version 1.0, 2007-04-13, 3rdstage
 * @since 2007-04-13
 */
public class SimpleClassTestingJNDI {
	
	/** Creates a new instance of SimpleClassTestingJNDI */
	public SimpleClassTestingJNDI() {
	}
	
	
	public org.hibernate.SessionFactory getSampleSessionFactory() throws Exception{
		
		javax.naming.Context initialCntx = new javax.naming.InitialContext();
		SessionFactory sessionFactory = (SessionFactory)initialCntx.lookup("java:comp/env/hibernate/SampleSessionFactory");
		return sessionFactory;
	}
	
	public org.hibernate.SessionFactory getTestSessionFactory() throws Exception{
		
		javax.naming.Context initialCntx = new javax.naming.InitialContext();
		SessionFactory sessionFactory = (SessionFactory)initialCntx.lookup("java:comp/env/hibernate/TestSessionFactory");
		return sessionFactory;
	}
	
}
