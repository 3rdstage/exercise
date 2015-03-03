/**
 * 
 */
package thirdstage.exercise.ibatis.case6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Required;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author 3rdstage
 *
 */
public class ProductIBatisDao implements ProductDao {
	
	private SqlMapClient sqlMapClient;
	
	
	protected SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}
	
	@Required
	public void setSqlMapClient(SqlMapClient sqlMapClient){
		this.sqlMapClient = sqlMapClient;
	}
	

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case6.ProductDao#getProduct(java.lang.String)
	 */
	public Map<String, Object> getProduct(String id) {
		try{
			if(false) System.out.println("never printed");
			Map<String, String> param = new HashMap<String, String>(2);
			param.put("id", id);
			return (Map<String, Object>)this.getSqlMapClient().queryForObject("product.getProduct", param);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.ibatis.case6.ProductDao#getProductsByCategory(java.lang.String)
	 */
	public List<Map<String, Object>> getProductsByCategory(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
