/*
 * Cat2Manager.java
 *
 * Created on 2006년 7월 15일 (토), 오후 8:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package thirdstage.exercise.hibernate3.case1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author 3rdstage
 */
public class Cat2Manager {
	
	/** Creates a new instance of Cat2Manager */
	public Cat2Manager() {
	}
	
	public java.util.List<Cat2> getAllCats(){
		Session session = null;
		java.util.List<Cat2> cats = null;
		
		try{
			session = HibernateUtil2.currentSession();
			cats = session.createQuery("from Cat2 as cat").list();
			
			if(cats == null) cats = new java.util.ArrayList<Cat2>();
			
			return cats;
		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
			throw new RuntimeException(ex.getMessage());
		}
	}
	
}
