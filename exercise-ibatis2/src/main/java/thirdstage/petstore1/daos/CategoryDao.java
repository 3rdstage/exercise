package thirdstage.petstore1.daos;

import java.sql.SQLException;
import java.util.List;

import thirdstage.petstore1.domain.entities.Category;

public interface CategoryDao{
	
	List<Category> getAllCategories() throws SQLException;
	
	Category getCategory(String id) throws SQLException;

}
