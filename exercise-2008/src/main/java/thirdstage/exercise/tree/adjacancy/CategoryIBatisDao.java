/**
 * 
 */
package thirdstage.exercise.tree.adjacancy;

import java.util.List;
import org.springframework.beans.factory.annotation.Required;
import com.ibatis.sqlmap.client.SqlMapClient;
import thirdstage.exercise.tree.adjacancy.entities.Category;

/**
 * @author 3rdstage
 *
 */
public class CategoryIBatisDao implements CategoryDao{
	
	private SqlMapClient sqlMapClient = null;
	
	public CategoryIBatisDao(){}
	
	protected SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}

	@Required
	public void setSqlMapClient(SqlMapClient sqlMapClient){
		this.sqlMapClient = sqlMapClient;
	}
	
	/* (non-Javadoc)
	 * @see thirdstage.exercise.tree.adjacancy.CategoryDao#get(java.lang.String)
	 */
	public Category get(String id) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.tree.adjacancy.CategoryDao#getAll()
	 */
	public List<Category> getAll() throws Exception{
		return (List<Category>)this.getSqlMapClient().queryForList("Category.getAll");
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.tree.adjacancy.CategoryDao#getSubordinates(thirdstage.exercise.tree.adjacancy.entities.Category)
	 */
	public List<Category> getSubordinates(String id) throws Exception{
		return (List<Category>)this.getSqlMapClient().queryForList("Category.getSubordinates", id);
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.tree.adjacancy.CategoryDao#getSuperiors(thirdstage.exercise.tree.adjacancy.entities.Category)
	 */
	public List<Category> getSuperiors(String id) throws Exception{
		return (List<Category>)this.getSqlMapClient().queryForList("Category.getSuperios", id);
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.tree.adjacancy.CategoryDao#getSiblings(thirdstage.exercise.tree.adjacancy.entities.Category)
	 */
	public List<Category> getSiblings(String id) throws Exception{
		return (List<Category>)this.getSqlMapClient().queryForList("Category.getSiblings", id);
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.tree.adjacancy.CategoryDao#add(thirdstage.exercise.tree.adjacancy.entities.Category)
	 */
	public void add(Category category) throws Exception{
	// TODO Auto-generated method stub
	
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.tree.adjacancy.CategoryDao#modify(thirdstage.exercise.tree.adjacancy.entities.Category)
	 */
	public void modify(Category category) throws Exception{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.tree.adjacancy.CategoryDao#remove(thirdstage.exercise.tree.adjacancy.entities.Category)
	 */
	public void remove(String id) throws Exception{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.tree.adjacancy.CategoryDao#removeWithSubordinates(thirdstage.exercise.tree.adjacancy.entities.Category)
	 */
	public void removeWithSubordinates(String id) throws Exception{
	// TODO Auto-generated method stub

	}

}
