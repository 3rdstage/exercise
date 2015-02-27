package thirdstage.petstore1.daos.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import com.ibatis.sqlmap.client.SqlMapClient;
import thirdstage.petstore1.daos.ProductDao;
import thirdstage.petstore1.domain.entities.Product;

public class ProductIBatisDao implements ProductDao{

	private SqlMapClient sqlMapClient;

	public ProductIBatisDao(){
		super();
	}

	protected SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setSqlMapClient(SqlMapClient sqlMapClient){
		this.sqlMapClient = sqlMapClient;
	}

	public Product getProduct(String id) throws SQLException{
		return (Product)(this.getSqlMapClient().queryForObject("getProduct", id));
	}

	public List<Product> getProductsByCategory(String categoryId) throws SQLException{
		return (List<Product>)(this.getSqlMapClient().queryForList("getProductsByCategory", categoryId));
	}

	public List<Product> searchProducts(String searchPhrase) throws SQLException{
		Object param = new ProductSearchParam(searchPhrase);

		return (List<Product>)(this.getSqlMapClient().queryForList("searchProducts", param));
	}

	public static class ProductSearchParam{
		private List<String> keywords = new ArrayList<String>(5);

		public ProductSearchParam(String searchPhrase){
			StringTokenizer st = new StringTokenizer(searchPhrase);
			while(st.hasMoreTokens()){
				this.keywords.add("%" + st.nextToken() + "%");
			}
		}

		public List<String> getKeywords(){
			return this.keywords;
		}
	}

}
