package thirdstage.exercise.hibernate3.case2;

import thirdstage.framework.mars.exceptions.SystemException;
/**
 *
 * @author 3rdstage
 * @version 1.0, 3rdstage, 2005-11-16
 * @since 2005-11-16
 */
public interface CompanyManager extends thirdstage.framework.mars.Manager {
	
	public Company findCompany(String id) throws SystemException;
	
}
