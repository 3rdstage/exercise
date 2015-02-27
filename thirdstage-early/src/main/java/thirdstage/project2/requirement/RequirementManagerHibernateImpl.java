package thirdstage.project2.requirement;

//~--- non-JDK imports --------------------------------------------------------

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

/**
 *
 * @author 3rdstage
 * @version 1.1, 2006-10-27, 3rdstage, upgrade getAllRequirements() and getAllRequirementsInMinValue() methods
 * @version 1.0, 2006-09-15, 3rdstage
 * @since 2006-09-15
 *
 * @spring.bean id="requirementManager2" autowire="no" lazy-init="true" singleton="true"
 * @spring.property name="sessionFactory" ref="hibernateSessionFactory2"
 */
public class RequirementManagerHibernateImpl implements RequirementManager {
    private static org.apache.commons.logging.Log log =
        org.apache.commons.logging.LogFactory.getLog(RequirementManagerHibernateImpl.class);
    private org.hibernate.SessionFactory sessionFactory = null;

    /** Creates a new instance of RequirementManagerHibernateImpl */
    public RequirementManagerHibernateImpl() {}

    public org.hibernate.SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	 /**
	  * @to-do 2007-04-17, 3rdstage, not planned,  
	  *        replace sessionFactory.openSession with sessionFactory.getCurrentSession
	  *        and remove session.close() by setting property hibernate.current_session_context_class
	  *        to thread.
	  * @to-do 2007-04-17, 3rdstage, not planned,
	  *        use JTA transaction demarcation with open-source JTA impl. such as JOTM.
	  * @to-do 2007-04-17, 3rdstage, not planned.
	  *        remove transaction demarcation by using AOP.    
	  */
    public void createRequirement(Requirement requirement) throws HibernateException {
        log.info("createRequirement method entered.");

        org.hibernate.Session session = null;

        try {
            session = sessionFactory.openSession();

            org.hibernate.Transaction tx = session.beginTransaction();

            session.save(requirement);
            tx.commit();
        } catch (HibernateException ex) {
            log.error(ex);

            throw ex;
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException ex2) {}
            }
        }

        log.info("createRequirement method leaving.");
    }

    public void createRequirements(java.util.List<Requirement> requirements) throws HibernateException {

        // @todo 2006-10-30, 3rdstage, not yet implemented
    }

	 /**
	  * @fix 2007-04-09, 3rdstage, This method doesn't work correctly 'cause of bug in Hibernate 3.2.1
	  *       In 3.2.1, HQL can't work with non-identifier property named id. But this bug
	  *       is fixed at 3.2.2. So, this method is also fixed automatically.      
	  *
	  */
    public Requirement getRequirementById(String id) throws Exception {
        org.hibernate.Session sess = null;
        Requirement           req  = null;

        try {
            sess = sessionFactory.openSession();
            req  = (Requirement) (sess.getNamedQuery("requirement.getRequirementById").setString("id",
                    id).uniqueResult());
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sess != null) {
                try {
                    sess.close();
                } catch (Exception ex) {}
            }
        }

        return req;
    }

    /**
     *
     * @return empty List if there's no requirement
     */
    public java.util.List<Requirement> getAllRequirement() throws HibernateException {
        log.info("getAllRequirement method entered.");

        org.hibernate.Session       session      = null;
        java.util.List<Requirement> requirements = null;

        try {
            session      = this.getSessionFactory().openSession();
            requirements = session.getNamedQuery("requirement.getAllRequirements").list();

            if (requirements == null) {
                requirements = new java.util.ArrayList<Requirement>();
            }
        } catch (org.hibernate.HibernateException ex) {
            log.error("", ex);

            throw ex;
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (Exception ex2) {}
            }
        }

        log.info("getAllRequirement method leaving.");

        return requirements;
    }

    /**
     *
     * @return empty List if there's no requirement
     */
    public java.util.List<RequirementMinValue> getAllRequirementInMinValue() throws HibernateException {
        log.info("getAllRequirementInMinValue method entered.");

        org.hibernate.Session               session      = null;
        java.util.List<Requirement>         requirements = null;
        java.util.List<RequirementMinValue> values       = null;

        try {
            session      = this.getSessionFactory().openSession();
            requirements = session.getNamedQuery("requirement.getAllRequirement").list();

            if (requirements != null) {
                values = new java.util.ArrayList<RequirementMinValue>();

                for (int i = 0, n = requirements.size(); i < n; i++) {
                    values.add(new RequirementMinValue((Requirement) (requirements.get(i))));
                }
            }
        } catch (org.hibernate.HibernateException ex) {
            log.error("", ex);

            throw ex;
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (Exception ex2) {}
            }
        }

        log.info("getAllRequirementInMinValue method leaving.");

        return values;
    }

    public void modifyRequirement(Requirement requirement) throws HibernateException {

        // @todo 2006-10-30, 3rdstage, not yet implemented
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
