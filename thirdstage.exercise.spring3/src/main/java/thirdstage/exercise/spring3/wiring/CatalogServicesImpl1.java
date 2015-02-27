package thirdstage.exercise.spring3.wiring;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service("catalogServices1")
public class CatalogServicesImpl1 implements CatalogServices {
	
	@Resource(name="categoryDao1")
	private CategoryDao catDao;
	
	private ProductDao prdDao;

	@Resource(name="productDao1")
	private void setProductDao(ProductDao dao){
		this.prdDao = dao;
	}

	public List<Category> findAllCategories() {
		return this.catDao.findAllCategories();
	}

	public List<Product> findProductsByCategory(String categoryId) {
		return this.prdDao.findProductsByCategory(categoryId);
	}
}
