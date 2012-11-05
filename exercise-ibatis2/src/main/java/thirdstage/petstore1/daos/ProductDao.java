package thirdstage.petstore1.daos;

import java.sql.SQLException;
import java.util.List;
import thirdstage.petstore1.domain.entities.Product;

public interface ProductDao{
	
	Product getProduct(String id) throws SQLException;
	List<Product> getProductsByCategory(String categoryId) throws SQLException;
	List<Product> searchProducts(String keyword) throws SQLException;

}
