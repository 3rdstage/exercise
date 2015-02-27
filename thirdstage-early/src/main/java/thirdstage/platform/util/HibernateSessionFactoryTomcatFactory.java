
package thirdstage.platform.util;

/**
 * ObjectFactory class for Tomcat to bind hibernate's SessionFactory to JNDI
 * Supports Tomcat 5.0 and 5.5
 *
 * @author 3rdstage
 * @version 1.1, 2007-04-13, 3rdstage, add Log4j logger
 * @version 1.0, 2005-11-04, 3rdstage, Initial Release
 * @since 2005-11-04
 */
import java.util.Hashtable;
import java.util.Enumeration;
import javax.naming.Name;
import javax.naming.Context;
import javax.naming.Reference;
import javax.naming.RefAddr;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;

public class HibernateSessionFactoryTomcatFactory implements javax.naming.spi.ObjectFactory{

	private static Logger logger = Logger.getLogger(HibernateSessionFactoryTomcatFactory.class);
	
	public Object getObjectInstance(Object obj, Name name, Context cntx, Hashtable env) throws javax.naming.NamingException{

      SessionFactory sessionFactory = null;
      RefAddr addr = null;
      
      try{
         Enumeration addrs = ((Reference)(obj)).getAll();
			
         while(addrs.hasMoreElements()){
            addr = (RefAddr) addrs.nextElement();
            if("configuration".equals((String)(addr.getType()))){
 					logger.info("HibernateSessionFactoryTomcatFactory.getObjectInstance : " + addr.getType() + " - " + addr.getContent());
					sessionFactory = (new Configuration()).configure((String)addr.getContent()).buildSessionFactory();
            }
         }
      }catch(Exception ex){
         throw new javax.naming.NamingException(ex.getMessage());
      }

      return sessionFactory;
   }
}