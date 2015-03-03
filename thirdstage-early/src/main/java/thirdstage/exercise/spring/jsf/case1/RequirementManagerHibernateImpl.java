package thirdstage.exercise.spring.jsf.case1;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-08-06, 3rdstage
 * @since 2006-08-06
 *
 * @spring.bean id="requirementManager" autowire="no" lazy-init="true" singleton="true"
 * @spring.property name="sessionFactory" ref="hibernateSessionFactory"
 */
public class RequirementManagerHibernateImpl implements RequirementManager {
	
	private org.hibernate.SessionFactory sessionFactory = null;
	
	/** Creates a new instance of RequirementManagerHibernateImpl */
	public RequirementManagerHibernateImpl() {
	}
	
	public org.hibernate.SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	public void setSessionFactory(org.hibernate.SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public void createRequirement(Requirement requirement) throws Exception{
		org.hibernate.Session session = null;
		
		try{
			session = this.getSessionFactory().openSession();
			org.hibernate.Transaction tx = session.beginTransaction();			
			session.save(requirement);
			tx.commit();
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(session != null){
				try{ session.close(); }
				catch(Exception ex2){}
			}
		}
	}

	public void createRequirements(java.util.List<Requirement> requirements) throws Exception{
		//@todo 3rdstage, 2006-08-07, Not yet implemented
	}
	
	public Requirement getRequirement(String id) throws Exception{
		//@todo 3rdstage, 2006-08-07, Not yet implemented
		return null;
	}
	
	public java.util.List<Requirement> getAllRequirement() throws Exception{
		org.hibernate.Session session = null;
		java.util.List requirements = null;
		
		try{
			session = this.getSessionFactory().openSession();
			requirements = session.createQuery("from Requirement").list();
	
			return requirements;
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(session != null){
				try{ session.close(); }
				catch(Exception ex2){}
			}
		}
	}

	public java.util.List<RequirementMinValue> getAllRequirementInMinValue() throws Exception{
		org.hibernate.Session session = null;
		java.util.List requirements = null;
		
		try{
			session = this.getSessionFactory().openSession();
	
			//@FIXME 3rdstage, 2006-08-10, There seems to exist some bugs in result transforming when alias is 'id'
			requirements = session.createQuery(
					"select req.no as no, req.id as id, req.title as title from Requirement as req")
					.setResultTransformer(org.hibernate.transform.Transformers.aliasToBean(RequirementMinValue.class))
					.list();
			
			return requirements;
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(session != null){
				try{ session.close(); }
				catch(Exception ex2){}
			}
		}
		
	}

	
	public void modifyRequirement(Requirement requirement) throws Exception{
		//@todo 3rdstage, 2006-08-07, Not yet implemented
	}
		
	
	
}
