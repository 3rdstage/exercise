package thirdstage.common1.daos;

import java.util.List;
import thirdstage.common1.entities.Word;

public interface WordDao {
	
	List<Word> getWordsByGlossary(long glossaryId);
	
	List<Word> getWordsByGlossaryPaged(long glossaryId, int size, int seq);
	
	
	

}
