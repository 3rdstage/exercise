package thirdstage.exercise.datastructure.tree.case2;


/**
 *
 * @author 3rdstage
 * @since 2007-04-27
 */
public interface TreeNode {
	
	
	public TreeNodeId getId();
	
	public void setId(TreeNodeId id);
	
	public TreeNode getParent();
	
	public void setParent(TreeNode parent);
	
	public java.util.List<TreeNode> getChildren();
	
	public java.util.List<TreeNode> getSiblings();
	
	public TreeNode getNextSibling();
	
	public TreeNode setNextSibling();
	
	
}
