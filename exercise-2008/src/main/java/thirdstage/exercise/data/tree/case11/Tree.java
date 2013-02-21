/**
 * 
 */
package thirdstage.exercise.data.tree.case11;

import java.util.List;

/**
 * @version 0.7, 2009-08-11, Sangmoon Oh, Initial Revision
 * @since 2009-08-11
 * @author 3rdstage
 */
public interface Tree{
	
	TreeNode getRootNode();

	
	/**
	 * @param root
	 * @throws IllegalArgumentException if the given <code>root</code> is <code>null</code> or 
	 *         has not meaningful id.
	 */
	void setRootNode(TreeNode root);

	/**
	 * @param id
	 * @return <code>TreeNode</code> object for the given <code>id</code>, or <code>null</code>.
	 *         if this tree has no node with the given <code>id</code>.
	 */
	TreeNode getNode(String id);
	
	
	/**
	 * @param note
	 * @param parentId
	 * @throws NoSuchElementException if this tree has no node with the given <code>parentId</code>.
	 * @throws IllegalArguementException if this tree already has a node equals 
	 *         with the given <code>node</code>.
	 * @throws IllegalArgumentException if the given <code>node</code> has not meaningful id.
	 */
	void addNode(TreeNode node, String parentId);
	
	
	java.util.List<TreeNode> getOrderedList();
	
}
