package thirdstage.common1;

import java.util.List;

import org.springframework.dao.DataAccessException;

import thirdstage.common1.entities.Glossary;
import thirdstage.common1.entities.Word;

/**
 * @author 3rdstage
 *
 */
public interface GlossaryManager {
	
	List<Glossary> getAllGlossaries() throws DataAccessException;
	
	List<Word> getWordsByGlossary(int glossaryId) throws DataAccessException;
	
	

}
