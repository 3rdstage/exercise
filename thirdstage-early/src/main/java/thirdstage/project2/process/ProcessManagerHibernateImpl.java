package thirdstage.project2.process;

import org.hibernate.HibernateException;
/**
 *
 * @author 3rdstage
 * @version 1.0, 3rdstage, 2006-10-30
 * @since 2006-10-30
 *
 * @spring.bean id="project2.processManager" autowire="no" lazy-init="true" singleton="true"
 * @spring.property name="sessionFactory" ref="hibernateSessionFactory2"
 */
public class ProcessManagerHibernateImpl implements ProcessManager {
	
	private static org.apache.log4j.Logger logger
			= org.apache.log4j.Logger.getLogger(ProcessManagerHibernateImpl.class);
	
	private org.hibernate.SessionFactory sessionFactory = null;
	
	/** Creates a new instance of ProcessManagerHibernateImpl */
	public ProcessManagerHibernateImpl() {
	}
	
	public org.hibernate.SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	public void setSessionFactory(org.hibernate.SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	
	public void createProcess(Process process) throws HibernateException{
		if(logger.isInfoEnabled()) logger.info("createProcess method entered.");
		
		org.hibernate.Session session = null;
		
		try{
			session = sessionFactory.openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			session.save(process);
			tx.commit();
		} catch(HibernateException ex){
			logger.error(ex);
			throw ex;
		} finally{
			if(session != null){
				try{ session.close(); } catch(HibernateException ex2){}
			}
		}
		
		if(logger.isInfoEnabled()) logger.info("createProcess method leaving.");
	}
	
	public void createProcesses(java.util.List<Process> processes) throws HibernateException{
		//@todo 2006-10-30, 3rdstage, not yet implemented
	}
	
	public Process getProcess(Long no) throws HibernateException{
		if(logger.isInfoEnabled()) logger.info("getProcess method entered.");
	
		org.hibernate.Session sess = null;
		Process process = null;
		
		try{
			sess = sessionFactory.openSession();
			process = (Process)(sess.get(Process.class, no));
		} catch(HibernateException ex){
			throw ex;
		} finally{
			if(sess != null){
				try{ sess.close(); }catch(Exception ex){ }
			}
		}

		if(logger.isInfoEnabled()) logger.info("getProcess method leaving.");
		return process;
	}
	
	public Process getProcessById(String id) throws HibernateException{
		//@todo 2006-10-30, 3rdstage, not yet implemented
		return null;
	}
	
	
	public java.util.List<Process> getAllProcesses() throws HibernateException{
		if(logger.isInfoEnabled()) logger.info("getAllProcess method entered.");
		
		org.hibernate.Session session = null;
		java.util.List<Process> processes = null;
		
		try{
			session = this.getSessionFactory().openSession();
			processes = session.getNamedQuery("requirement.getAllProcess").list();
			
			if(processes == null){
				processes = new java.util.ArrayList<Process>();
			}
		} catch(org.hibernate.HibernateException ex){
			logger.error("", ex);
			throw ex;
		} finally{
			if(session != null){
				try{ session.close(); }catch(Exception ex2){}
			}
		}
		
		if(logger.isInfoEnabled()) logger.info("getAllProcess method leaving.");
		return processes;
	
	}
	
	public java.util.List<ProcessMinValue> getAllProcessesInMinValue() throws HibernateException{
		//@todo 2006-10-30, 3rdstage, not yet implemented
		return null;
	}
	
	
}
