package thirdstage.exercise.datastructure.tree.case3;

/**
 *
 * @author 3rdstage
 */
public interface TreeNode {
	

	
	
	public TreeNode getParent();
	
	public java.util.List<TreeNode> getChildren();
	
	public void setParent(TreeNode parent);
	
	public void addChild(TreeNode child);
	
	public void deleteChildCascade(TreeNode child);
	
	
	
}
