
package thirdstage.exercise.hibernate3.case1;

import org.hibernate.*;
import org.hibernate.cfg.*;
/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-11-07, 3rdstage
 * @since 2005-11-07
 */
public class HibernateUtil3 {
	
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HibernateUtil3.class);
	
	private static org.hibernate.SessionFactory sessionFactory;
	
	static{
		try{
			javax.naming.Context ctx = new javax.naming.InitialContext();
			javax.naming.Context ctx2 = (javax.naming.Context)(ctx.lookup("java:comp/env"));
			sessionFactory = (org.hibernate.SessionFactory)(ctx2.lookup("hibernate/TestSessionFactory"));
			
			if(sessionFactory == null) logger.warn("SessionFactory is null");
			
			logger.info("Hibernate SessionFactory is initialized successfully using JNDI.");
			logger.info("The hashcode of the SessionFactory object is : " + sessionFactory.hashCode());
			System.out.println("[Info] Hibernate SessionFactory is initialized successfully.");
			
		} catch(Throwable ex){
			logger.error("Cant't Initialize Hibernate SessionFatory using JNDI.", ex);
			System.err.println("[Error]  Cant't Initialize Hibernate SessionFatory.");
			System.err.println(ex.toString());
			sessionFactory = null;
			
			//This lead to context load failure. (too critical)
			//throw new ExceptionInInitializerError(ex);
			
		}
	}
	
	public static final ThreadLocal threadLocalSession = new ThreadLocal();
	
	public static Session currentSession() throws HibernateException{
		logger.info("currentSession method entered.");
		
		Session session = (Session)(threadLocalSession.get());
		
		if(session == null){
			
			session = sessionFactory.openSession();
			threadLocalSession.set(session);
		}
		
		logger.info("currentSession method leaving.");
		return session;
	}
	
	public static void closeSession() throws HibernateException{
		Session session = (Session)(threadLocalSession.get());
		threadLocalSession.set(null);
		if(session != null) session.close();
	}
	
	/** Creates a new instance of HibernateUtil3 */
	public HibernateUtil3() {
	}
	
	
}
