package thirdstage.exercise.datastructure.tree.case4;

import java.util.List;

public interface Tree{
	
	int getSize();
	boolean hasDummyRootNode();
	void setDummyRootNode(boolean flag);

	void addNode(TreeNode node);
	void addNodes(List<TreeNode> nodes);

	TreeNode getNode(String nodeId);
	TreeNode getRootNode();

	void removeNodeCascaded(String nodeId);
	void removeNodeResctricted(String nodeId);
	
	Tree getSubTree(String nodeId);
	List<TreeNode> getAllNodesInHierarchicalOrder();
}
