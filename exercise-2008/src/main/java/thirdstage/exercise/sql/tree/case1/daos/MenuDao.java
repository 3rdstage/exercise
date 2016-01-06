/**
 * 
 */
package thirdstage.exercise.sql.tree.case1.daos;

import java.util.List;
import thirdstage.exercise.sql.tree.case1.entities.Menu;

/**
 * @author 3rdstage
 *
 */
public interface MenuDao{

	
	List<Menu> getAllMenusSorted() throws Exception; 
	
	List<Menu> getSubmenusSorted(String menuId) throws Exception;
	
}
