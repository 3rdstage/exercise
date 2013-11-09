package thirdstage.exercise.datastructure.tree.case4;

import java.util.List;

public interface TreeNode{
	
	String getId();
	void setId(String id);
	
	TreeNode getParent();

	void addChild(TreeNode node);
	List<TreeNode> getAllChildren();

	void removeChildCascade(String nodeId);
	void removeChildRestricted(String nodeId);
	
	TreeNode getPreviousSbiling();
	TreeNode getNextSibling();
	List<TreeNode> getAllSiblings();
	
	boolean isRoot();
	boolean isLeaf();
	
	
	
	

}
