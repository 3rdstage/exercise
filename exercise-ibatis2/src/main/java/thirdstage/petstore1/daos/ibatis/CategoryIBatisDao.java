package thirdstage.petstore1.daos.ibatis;

import java.sql.SQLException;
import java.util.List;
import thirdstage.petstore1.daos.CategoryDao;
import thirdstage.petstore1.domain.entities.Category;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CategoryIBatisDao implements CategoryDao{

	private SqlMapClient sqlMapClient;

	public CategoryIBatisDao(){
		super();
	}

	protected SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setSqlMapClient(SqlMapClient sqlMapClient){
		this.sqlMapClient = sqlMapClient;
	}

	public List<Category> getAllCategories() throws SQLException{
		return (List<Category>)(this.getSqlMapClient().queryForList("getAllCategories"));
	}

	public Category getCategory(String id) throws SQLException{
		return (Category)(this.getSqlMapClient().queryForObject("getCategory", id));
	}

}
