package thirdstage.exercise.sql.tree.case1.daos.ibatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Required;
import com.ibatis.sqlmap.client.SqlMapClient;
import thirdstage.exercise.sql.tree.case1.daos.MenuDao;
import thirdstage.exercise.sql.tree.case1.entities.Menu;

public class MenuIBatisDao implements MenuDao{
	
	private SqlMapClient sqlMapClient;
	
	public MenuIBatisDao(){}

	protected SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}

	@Required
	public void setSqlMapClient(SqlMapClient client){
		this.sqlMapClient = client;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.sql.tree.case1.daos.MenuDao#getAllMenusSorted()
	 */
	public List<Menu> getAllMenusSorted() throws Exception{
		
		return this.sqlMapClient.queryForList("getAllMenusSorted");
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.sql.tree.case1.daos.MenuDao#getSubmenusSorted(java.lang.String)
	 */
	public List<Menu> getSubmenusSorted(String menuId) throws Exception{
		
		return this.sqlMapClient.queryForList("getSubMenusSorted", menuId);
	}
	
	
	
}
