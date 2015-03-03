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
public interface TreeNode{
	
	String getId();

	void setId(String id);
	
	String getName();

	void setName(String name);
	
	String getDescription();

	void setDescription(String desc);
	
	TreeNode getParent();

	void setParent(TreeNode parent);
	
	/**
	 * @return list of child nodes, or empty list if this node has no child.
	 */
	java.util.List<TreeNode> getChildren();

	TreeNode getChild(int index);

	void setChild(TreeNode child, int index);

	void addChild(TreeNode child);

	void removeChild(int index);
	
	/**
	 * @return list of sibling nodes including this node.
	 */
	List<TreeNode> getSiblings();
	
	TreeNode getNextSibling();
	
	boolean isLeaf();
	
	boolean isRoot();
	
}
