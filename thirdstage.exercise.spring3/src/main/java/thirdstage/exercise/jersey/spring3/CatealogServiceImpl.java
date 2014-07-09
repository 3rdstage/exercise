package thirdstage.exercise.jersey.spring3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CatealogServiceImpl implements CatalogService {
	
	private static List<CategoryValue> categories = new ArrayList<CategoryValue>();
	
	static{
		categories.add(new CategoryValue("CAT0001", "Electronics"));
		categories.add(new CategoryValue("CAT0002", "Cell Phones"));
		categories.add(new CategoryValue("CAT0003", "Smartphones"));
		categories.add(new CategoryValue("CAT0004", "Digital Camera"));
		categories.add(new CategoryValue("CAT0005", "Fashion"));
	}

	@Override
	public List<CategoryValue> findAllCategories() {
		return categories;
	}

}
