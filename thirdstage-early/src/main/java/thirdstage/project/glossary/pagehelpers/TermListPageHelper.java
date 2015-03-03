/*
 *
 * Created on 2005-04-07
 */

package thirdstage.project.glossary.pagehelpers;

import thirdstage.framework.mars.*;
import thirdstage.project.glossary.entities.Term;

/**
 *
 * @author 3rdstage
 * @version 0.9, 2005-04-07
 * @since 2005-04-07
 *
 * @jsf.bean name="termListPageHelper"
 *           scope="application"
 */
public class TermListPageHelper extends AbstractPageHelper {
	
	/** Creates a new instance of WordListPageHelper */
	public TermListPageHelper() {
	}
	
	
	public java.util.List getAllTerms(){
		
		//FIXME test code
		java.util.List terms = new java.util.ArrayList();
		
		terms.add(new Term("1", "LC", "Letter of Credit", "...."));
		terms.add(new Term("2", "BL", "Bill of Landing", "..."));
		
		return terms;
	}
}
