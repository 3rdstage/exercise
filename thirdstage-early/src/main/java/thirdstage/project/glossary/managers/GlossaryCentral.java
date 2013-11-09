/*
 * GlossaryCentral.java
 *
 * Created on 2005-04-07
 */

package thirdstage.project.glossary.managers;

/**
 *
 * @author 3rdstage
 */
public class GlossaryCentral {
	
	private static GlossaryCentral singleton = new GlossaryCentral();
	
	private static GlossaryCentral getInstance(){
		return singleton;
	}
	
	protected java.util.List terms = null;
	
	/** Creates a new instance of GlossaryCentral */
	private GlossaryCentral() {
		terms = new java.util.ArrayList();
	}
		
	public java.util.List getAllTerms(){
		return terms;
	}
	
	public void addTerm(){
		
		
		
	}
	
	public void removeTerm(String id){
		
	}
	
}
