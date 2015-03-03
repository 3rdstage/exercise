/**
 * 
 */
package thirdstage.exercise.data.tree.case11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version 0.7, 2009-08-11, Sangmoon Oh, Implement transverse method successfully in first time.
 * @since 2009-08-11
 * @author 3rdstage
 */
public class DefaultTree implements Tree{
	
	protected java.util.Map<String, TreeNode> nodesMap;
	
	protected TreeNode root;
	
	public DefaultTree(){
		this.nodesMap = new java.util.HashMap<String, TreeNode>();
	}
	

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.Tree#addNode(thirdstage.exercise.data.tree.case11.TreeNode, java.lang.String)
	 */
	public void addNode(TreeNode node, String parentId){
		this.getNode(parentId).addChild(node);
		this.nodesMap.put(node.getId(), node);

	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.Tree#getNode(java.lang.String)
	 */
	public TreeNode getNode(String id){
		return this.nodesMap.get(id);
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.Tree#getOrderedList()
	 */
	public List<TreeNode> getOrderedList(){
		java.util.List<TreeNode> list = new java.util.ArrayList<TreeNode>(this.nodesMap.size());
		
		this.traverse(this.root, list);
		return list;
	}

	//TODO, 2009-08-11, Sangmoon Oh, Improve to traverse from non-root start node.
	//reference http://en.wikipedia.org/wiki/Tree_traversal
	protected void traverse(TreeNode node, java.util.List<TreeNode> list){
		if(node != null) list.add(node);

		TreeNode next = null;
		if(!node.isLeaf()){ next = node.getChild(0); }
		else{
			next = node.getNextSibling();
			TreeNode tmp = node;
			while(next == null){
				if(tmp.isRoot()){ break; }
				else{
					tmp = tmp.getParent();
					next = tmp.getNextSibling();
				}
			}
		}
		
		if(next == null) return;
		else this.traverse(next, list);
	}

	
	
	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.Tree#getRootNode()
	 */
	public TreeNode getRootNode(){
		return this.root;
	}

	
	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.Tree#setRootNode(thirdstage.exercise.data.tree.case11.TreeNode)
	 */
	public void setRootNode(TreeNode root){
		if(root == null || root.getId() == null || root.getId().trim().length() == 0){
			throw new IllegalArgumentException("The given root is null or has no meaningful identifier.");
		}
		if(root.getParent() != null){
			throw new IllegalArgumentException("The root node shoul not have parent node.");
		}
		
		this.root = root;
		this.nodesMap.put(root.getId(), root);

	}
}
