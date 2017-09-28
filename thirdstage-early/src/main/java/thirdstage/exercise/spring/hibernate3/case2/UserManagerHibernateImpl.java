
package thirdstage.exercise.spring.hibernate3.case2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-07-08, 3rdstage
 * @since 2006-07-08
 *
 * @spring.bean id="userManager" description="manages user, group and role"
 * @spring.property name="sessionFactory" ref="hibernateSessionFactory"
 */
public class UserManagerHibernateImpl implements UserManager{
	
	private SessionFactory sessionFactory = null;
	
	/** Creates a new instance of UserManagerHibernateImpl */
	public UserManagerHibernateImpl() {
	}
	
	public UserManagerHibernateImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory(){ return this.sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory){ this.sessionFactory = sessionFactory; }
	
	public User createUser(User user) throws Exception{
		Session session = null;
		
		try{
			session = this.getSessionFactory().openSession();
			session.save(user);
			
			return user;
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		finally{
			if(session != null){
				try{ session.close(); }
				catch(Exception ex2){}
			}
		}
	}
	
	
	public User[] getAllUsers() throws Exception{
		Session session = null;
		java.util.List users = null;
		
		try{
			session = this.getSessionFactory().openSession();
			users = session.getNamedQuery("findAllUsers").list();

			if(users != null){
				return (User[])(users.toArray(new User[users.size()]));
			}
			else{ return new User[0]; }
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		finally{
			if(session != null){
				try{ session.close(); }
				catch(Exception ex2){}
			}
		}
	}
	
	public java.util.List<User> getAllUsers2() throws Exception{
		Session session = null;
		java.util.List users = null;
		
		try{
			session = this.getSessionFactory().openSession();
			users = session.getNamedQuery("findAllUsers").list();
				
			if(users == null) users = new java.util.ArrayList();
			
			return users;
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
		finally{
			if(session != null){
				try{ session.close(); }
				catch(Exception ex2){}
			}
		}
	}
	
	
}
