/**
 * 
 */
package thirdstage.common1;

import java.util.List;

import org.springframework.dao.DataAccessException;  

import thirdstage.common1.entities.Glossary;
import thirdstage.common1.entities.Word;

/**
 * @author 3rdstage
 *
 */
public class GlossaryIBatisManager implements GlossaryManager {

	/* (non-Javadoc)
	 * @see thirdstage.common1.GlossaryManager#getAllGlossaries()
	 */
	public List<Glossary> getAllGlossaries() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.common1.GlossaryManager#getWordsByGlossary(int)
	 */
	public List<Word> getWordsByGlossary(int glossaryId)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
