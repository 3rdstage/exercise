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

/**
 * Hibernate session implementation that can't be closed.<br/>
 * This is basic constraint to provide application-scope session with 
 * long life-time based on 'Open Session in View' which is described
 * at <a href="https://www.hibernate.org/43.html" target="_blank">https://www.hibernate.org/43.html</a>
 * 
 * @author 3rdstage
 *
 */
public abstract class AbstractOpenSession implements Session{

	public Connection close(){
		throw new UnsupportedOperationException("OpenSession can't be closed");
	}

}
