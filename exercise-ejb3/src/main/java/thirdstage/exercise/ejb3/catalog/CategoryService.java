package thirdstage.exercise.ejb3.catalog;
import java.util.List;

import javax.ejb.Local;

@Local
public interface CategoryService {
	
	Category findCategory(String id);
	
	List<Category> findCategoriesByNamePart(String namePart);

}
