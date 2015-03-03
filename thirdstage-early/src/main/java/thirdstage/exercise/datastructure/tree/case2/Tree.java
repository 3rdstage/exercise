package thirdstage.exercise.datastructure.tree.case2;

/**
 *
 * @author 3rdstage
 * @since 2007-04-27
 */
public interface Tree {
	
	public TreeNode getRootNode();
	
	public TreeNode getNode(TreeNodeId id);
	
	public void addNode(TreeNode node);
	
	public java.util.List<TreeNode> getSortedNodeList();
	
	
}
