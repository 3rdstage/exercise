
package thirdstage.project.misc;

import org.hibernate.*;
import org.hibernate.cfg.*;
/**
 * Utility class for Hibernate 3 with annotation enabled
 *
 * @author 3rdstage
 * @version 1.0, 2005-04-18
 * @since 2005-04-18
 */
public class HibernateSessionManager {
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HibernateSessionManager.class);
	
	private static SessionFactory sessionFactory = null;
	
	public static final ThreadLocal threadLocalSession = new ThreadLocal();
	
	
	static{
		init();
	}
 
	/**
	 * @param configFile absolute path for Hibernate configuration file in XML format
	 */
	public static void init(){
		try{
			Configuration cfg = new AnnotationConfiguration().
			                    addAnnotatedClass(thirdstage.project.glossary.entities.Term.class).
			                    setProperty("hibernate.connection.datasource", "java:comp/env/jdbc/ProjectDB").
                             setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect").
			                    setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory").
			                    setProperty("hibernate.show_dql", "false");
					
		
			sessionFactory = cfg.buildSessionFactory();
			
			logger.info("Hibernate SessionFactory is initialized successfully.");
			System.out.println("[Info] Hibernate SessionFactory is initialized successfully.");
		}
		catch(Throwable ex){
			sessionFactory = null;
			logger.error("Cant't Initialize Hibernate SessionFatory.", ex);
			System.err.println("[Error]  Cant't Initialize Hibernate SessionFatory.");
			System.err.println(ex.toString());
			sessionFactory = null;
			
			//This lead to context load failure. (too critical)
			//throw new ExceptionInInitializerError(ex);
		}
	}
	

	public static Session currentSession() throws HibernateException, IllegalStateException{
		if(sessionFactory == null) throw new IllegalStateException("This class is not initialized properly");

		Session session = (Session)(threadLocalSession.get());
 		
		if(session == null){
			session = sessionFactory.openSession();
			threadLocalSession.set(session);
		}
		
		return session;
	}
	
	public static void closeSession() throws HibernateException, IllegalStateException{
		if(sessionFactory == null) throw new IllegalStateException("This class is not initialized properly");

		Session session = (Session)(threadLocalSession.get());
		threadLocalSession.set(null);
		if(session != null) session.close();
	}
	
}
