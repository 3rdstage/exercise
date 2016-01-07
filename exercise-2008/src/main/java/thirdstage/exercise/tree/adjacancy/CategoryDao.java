/**
 * 
 */
package thirdstage.exercise.tree.adjacancy;

import java.util.List;
import thirdstage.exercise.tree.adjacancy.entities.Category;

/**
 * @author 3rdstage
 *
 */
public interface CategoryDao{
	
	public Category get(String id) throws Exception;
	
	public List<Category> getAll() throws Exception;
	
	public List<Category> getSubordinates(String id) throws Exception;
	
	public List<Category> getSuperiors(String id) throws Exception;
	
	public List<Category> getSiblings(String id) throws Exception;
	
	public void add(Category category) throws Exception;
	
	public void modify(Category category) throws Exception;
	
	public void remove(String id) throws Exception;
	
	public void removeWithSubordinates(String id) throws Exception;

}
