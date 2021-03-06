/**
 * 
 */
package thirdstage.purple.hibernate;

import java.io.Serializable;
import java.sql.Connection;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.EntityMode;
import org.hibernate.Filter;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.ReplicationMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.hibernate.stat.SessionStatistics;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author 3rdstage
 *
 */
public class DefaultOpenSession extends AbstractOpenSession{
	
	Session baseSess;
	
	public DefaultOpenSession(){}
	
	@Required
	public void setBaseSession(Session sess){
		this.baseSess = sess;
	}
	
	protected Session getBaseSession(){
		return this.baseSess;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#beginTransaction()
	 */
	public Transaction beginTransaction() throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#cancelQuery()
	 */
	public void cancelQuery() throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#clear()
	 */
	public void clear(){
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#connection()
	 */
	public Connection connection() throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#contains(java.lang.Object)
	 */
	public boolean contains(Object object){
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#createCriteria(java.lang.Class)
	 */
	public Criteria createCriteria(Class persistentClass){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#createCriteria(java.lang.String)
	 */
	public Criteria createCriteria(String entityName){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#createCriteria(java.lang.Class, java.lang.String)
	 */
	public Criteria createCriteria(Class persistentClass, String alias){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#createCriteria(java.lang.String, java.lang.String)
	 */
	public Criteria createCriteria(String entityName, String alias){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#createFilter(java.lang.Object, java.lang.String)
	 */
	public Query createFilter(Object collection, String queryString) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#createQuery(java.lang.String)
	 */
	public Query createQuery(String queryString) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#createSQLQuery(java.lang.String)
	 */
	public SQLQuery createSQLQuery(String queryString) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#delete(java.lang.Object)
	 */
	public void delete(Object object) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#delete(java.lang.String, java.lang.Object)
	 */
	public void delete(String entityName, Object object) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#disableFilter(java.lang.String)
	 */
	public void disableFilter(String filterName){
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#disconnect()
	 */
	public Connection disconnect() throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#doWork(org.hibernate.jdbc.Work)
	 */
	public void doWork(Work work) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#enableFilter(java.lang.String)
	 */
	public Filter enableFilter(String filterName){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#evict(java.lang.Object)
	 */
	public void evict(Object object) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#flush()
	 */
	public void flush() throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#get(java.lang.Class, java.io.Serializable)
	 */
	public Object get(Class clazz, Serializable id) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#get(java.lang.String, java.io.Serializable)
	 */
	public Object get(String entityName, Serializable id) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#get(java.lang.Class, java.io.Serializable, org.hibernate.LockMode)
	 */
	public Object get(Class clazz, Serializable id, LockMode lockMode) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#get(java.lang.String, java.io.Serializable, org.hibernate.LockMode)
	 */
	public Object get(String entityName, Serializable id, LockMode lockMode) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getCacheMode()
	 */
	public CacheMode getCacheMode(){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getCurrentLockMode(java.lang.Object)
	 */
	public LockMode getCurrentLockMode(Object object) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getEnabledFilter(java.lang.String)
	 */
	public Filter getEnabledFilter(String filterName){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getEntityMode()
	 */
	public EntityMode getEntityMode(){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getEntityName(java.lang.Object)
	 */
	public String getEntityName(Object object) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getFlushMode()
	 */
	public FlushMode getFlushMode(){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getIdentifier(java.lang.Object)
	 */
	public Serializable getIdentifier(Object object) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getNamedQuery(java.lang.String)
	 */
	public Query getNamedQuery(String queryName) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getSession(org.hibernate.EntityMode)
	 */
	public Session getSession(EntityMode entityMode){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getSessionFactory()
	 */
	public SessionFactory getSessionFactory(){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getStatistics()
	 */
	public SessionStatistics getStatistics(){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#getTransaction()
	 */
	public Transaction getTransaction(){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#isConnected()
	 */
	public boolean isConnected(){
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#isDirty()
	 */
	public boolean isDirty() throws HibernateException{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#isOpen()
	 */
	public boolean isOpen(){
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#load(java.lang.Class, java.io.Serializable)
	 */
	public Object load(Class theClass, Serializable id) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#load(java.lang.String, java.io.Serializable)
	 */
	public Object load(String entityName, Serializable id) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#load(java.lang.Object, java.io.Serializable)
	 */
	public void load(Object object, Serializable id) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#load(java.lang.Class, java.io.Serializable, org.hibernate.LockMode)
	 */
	public Object load(Class theClass, Serializable id, LockMode lockMode) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#load(java.lang.String, java.io.Serializable, org.hibernate.LockMode)
	 */
	public Object load(String entityName, Serializable id, LockMode lockMode) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#lock(java.lang.Object, org.hibernate.LockMode)
	 */
	public void lock(Object object, LockMode lockMode) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#lock(java.lang.String, java.lang.Object, org.hibernate.LockMode)
	 */
	public void lock(String entityName, Object object, LockMode lockMode) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#merge(java.lang.Object)
	 */
	public Object merge(Object object) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#merge(java.lang.String, java.lang.Object)
	 */
	public Object merge(String entityName, Object object) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#persist(java.lang.Object)
	 */
	public void persist(Object object) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#persist(java.lang.String, java.lang.Object)
	 */
	public void persist(String entityName, Object object) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#reconnect()
	 */
	public void reconnect() throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#reconnect(java.sql.Connection)
	 */
	public void reconnect(Connection connection) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#refresh(java.lang.Object)
	 */
	public void refresh(Object object) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#refresh(java.lang.Object, org.hibernate.LockMode)
	 */
	public void refresh(Object object, LockMode lockMode) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#replicate(java.lang.Object, org.hibernate.ReplicationMode)
	 */
	public void replicate(Object object, ReplicationMode replicationMode) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#replicate(java.lang.String, java.lang.Object, org.hibernate.ReplicationMode)
	 */
	public void replicate(String entityName, Object object, ReplicationMode replicationMode) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#save(java.lang.Object)
	 */
	public Serializable save(Object object) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#save(java.lang.String, java.lang.Object)
	 */
	public Serializable save(String entityName, Object object) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#saveOrUpdate(java.lang.Object)
	 */
	public void saveOrUpdate(Object object) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#saveOrUpdate(java.lang.String, java.lang.Object)
	 */
	public void saveOrUpdate(String entityName, Object object) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#setCacheMode(org.hibernate.CacheMode)
	 */
	public void setCacheMode(CacheMode cacheMode){
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#setFlushMode(org.hibernate.FlushMode)
	 */
	public void setFlushMode(FlushMode flushMode){
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#setReadOnly(java.lang.Object, boolean)
	 */
	public void setReadOnly(Object entity, boolean readOnly){
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#update(java.lang.Object)
	 */
	public void update(Object object) throws HibernateException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.Session#update(java.lang.String, java.lang.Object)
	 */
	public void update(String entityName, Object object) throws HibernateException{
	// TODO Auto-generated method stub

	}

}
