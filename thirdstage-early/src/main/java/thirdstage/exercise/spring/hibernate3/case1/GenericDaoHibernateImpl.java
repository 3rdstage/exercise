
package thirdstage.exercise.spring.hibernate3.case1;

/**
 *
 * @author 3rdstage
 */
public class GenericDaoHibernateImpl<T, PK extends java.io.Serializable> implements GenericDao<T, PK> {
	
	private org.hibernate.SessionFactory sessionFactory = null;
	private Class<T> type;
	
	public GenericDaoHibernateImpl(Class<T> type, org.hibernate.SessionFactory factory){
		this.type = type;
		this.sessionFactory = factory;
	}
	
	public PK create(T o){
		return (PK)(this.getSession().save(o));
	}

	public T read(PK id){
		return (T)(this.getSession().get(type, id));	
	}
	
	public void update(T o){
		this.getSession().update(o);
	}
	
	public void delete(T o){
		this.getSession().delete(o);
	}
	
	public org.hibernate.Session getSession(){
		boolean allowCreates = true;
		return org.springframework.orm.hibernate3.SessionFactoryUtils.getSession(this.sessionFactory, allowCreates);
	}
	
	public org.hibernate.SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	
	
}
