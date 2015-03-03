package thirdstage.exercise.datastructure.tree.case3;

/**
 *
 * @author 3rdstage
 */
public interface Tree {
	
	public List getList();
	
	public List getSubList(TreeNode node);
	
	public void addNode(TreeNode parent, TreeNode node);
	
	public void deleteNodeCascaded(TreeNode node);
	
	public void deleteNodeRestricted(TreeNode node);
	
	
}
