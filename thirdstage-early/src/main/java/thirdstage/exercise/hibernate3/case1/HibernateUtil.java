/*
 * HibernateUtil.java
 *
 * Created on 2005-03-24
 */

package thirdstage.exercise.hibernate3.case1;

import org.hibernate.*;
import org.hibernate.cfg.*;
/**
 *
 * @author 3rdstage
 */
public class HibernateUtil {
	
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HibernateUtil.class);
	
	private static SessionFactory sessionFactory;
	
	static{
		try{
			Configuration cfg = new Configuration().
					addClass(thirdstage.exercise.hibernate3.case1.Cat.class).
					setProperty("hibernate.connection.datasource", "java:comp/env/jdbc/TestDB").
					setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect").
					setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory").
					setProperty("hibernate.show_sql", "true");
		
			sessionFactory = cfg.buildSessionFactory();
			
			logger.info("Hibernate SessionFactory is initialized successfully.");
			System.out.println("[Info] Hibernate SessionFactory is initialized successfully.");
		}
		catch(Throwable ex){
			logger.error("Cant't Initialize Hibernate SessionFatory.", ex);
			System.err.println("[Error]  Cant't Initialize Hibernate SessionFatory.");
			System.err.println(ex.toString());
			sessionFactory = null;
			
			//This lead to context load failure. (too critical)
			//throw new ExceptionInInitializerError(ex);
			
		}
	}
	
	public static final ThreadLocal threadLocalSession = new ThreadLocal();

	public static Session currentSession() throws HibernateException{
		
		Session session = (Session)(threadLocalSession.get());
		
		if(session == null){
			session = sessionFactory.openSession();
			threadLocalSession.set(session);
		}
		
		return session;
	}
	
	public static void closeSession() throws HibernateException{
		Session session = (Session)(threadLocalSession.get());
		threadLocalSession.set(null);
		if(session != null) session.close();
	}
	
	/** Creates a new instance of HibernateUtil */
	public HibernateUtil() {
	}
	
	
}
