/*
 * HibernateUtil2.java
 *
 * Created on 2005-03-29
 */

package thirdstage.exercise.hibernate3.case1;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.cfg.*;
/**
 * Utility class for Hibernate 3 with annotation enabled
 *
 * @author 3rdstage
 * @version 1.0, 2005-03-29
 * @since 2005-03-29
 */
public class HibernateUtil2 {
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HibernateUtil2.class);
	
	private static SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	static{
		try{
			/**
			sessionFactory = new AnnotationConfiguration().
					addAnnotatedClass(thirdstage.exercise.hibernate3.case1.Cat2.class).
					setProperty("hibernate.connection.datasource", "java:comp/env/jdbc/TestDB").
					setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect").
					setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory").
					setProperty("hibernate.show_dql", "true").
			      buildSessionFactory();
			 */

			sessionFactory = new AnnotationConfiguration().
					addPackage("thirdstage.exercise.hibernate3.case1").
					addAnnotatedClass(Cat2.class).
					setProperty("hibernate.connection.driver_class", "org.gjt.mm.mysql.Driver").
					setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8").
					setProperty("hibernate.connection.username", "tester").
					setProperty("hibernate.connection.password", "testhh").
					setProperty("hibernate.show_sql", "true").
					setProperty("hibernate.use_sql_comments", "true").
					buildSessionFactory();
			
			logger.info("Hibernate SessionFactory is initialized successfully.");
			System.out.println("[Info] Hibernate SessionFactory is initialized successfully.");
		}
		catch(Throwable ex){
			logger.error("Cant't Initialize Hibernate SessionFatory.", ex);
			System.err.println("[Error]  Cant't Initialize Hibernate SessionFatory.");
			ex.printStackTrace(System.err);
			sessionFactory = null;
			
			//This lead to context load failure. (too critical)
			//throw new ExceptionInInitializerError(ex);
		}
	}

	public Logger getLogger() {
		return logger;
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
	public HibernateUtil2() {
	}
	

	
}
