/**
 * 
 */
package thirdstage.exercise.data.tree.case11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version 0.7, 2009-08-11, Sangmoon Oh, Initial Revision
 * @since 2009-08-11
 * @author 3rdstage
 */
public class DefaultTreeNode implements TreeNode{

	//TODO, 2009-08-11, Sangmoon Oh
	//adjust parent field for the child when added, removed or replaced
	
	private String id;
	
	private String name; 
	
	private String description;
	
	TreeNode parent;
	
	java.util.List<TreeNode> children = new java.util.ArrayList<TreeNode>();
	
	public DefaultTreeNode(){}
	
	public DefaultTreeNode(String id){
		this.setId(id);
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		DefaultTreeNode other = (DefaultTreeNode) obj;
		
		if(id == null)	return false;
		else if(!id.equals(other.id)) return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#addChild(thirdstage.exercise.data.tree.case11.TreeNode)
	 */
	public void addChild(TreeNode child){
		this.children.add(child);
		child.setParent(this);
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#getChild(int)
	 */
	public TreeNode getChild(int index){
		return this.children.get(index);
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#getChildren()
	 */
	public List<TreeNode> getChildren(){
		return this.children;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#getDescription()
	 */
	public String getDescription(){
		return this.description;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#getId()
	 */
	public String getId(){
		return this.id;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#getName()
	 */
	public String getName(){
		return this.name;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#getParent()
	 */
	public TreeNode getParent(){
		return this.parent;
	}


	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#getSiblings()
	 */
	public List<TreeNode> getSiblings(){
		if(this.isRoot()){ //root node
			return Collections.emptyList();
		}
		else{
			return this.getParent().getChildren();
		}
	}
	
	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#getNextSibling()
	 */
	public TreeNode getNextSibling(){
		if(this.isRoot()){ //root node
			return null;
		}
		else{
			List<TreeNode> siblings = this.getSiblings();
			int n = siblings.size();
			int l = siblings.indexOf(this);
			if(l == (n - 1)){ //last of siblings
				return null;
			}
			else{
				return siblings.get(l + 1);
			}
		}
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#isLeaf()
	 */
	public boolean isLeaf(){
		return (this.getChildren().size() == 0);
		
		
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#isRoot()
	 */
	public boolean isRoot(){
		return (this.getParent() == null);
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#removeChild(int)
	 */
	public void removeChild(int index){
		this.children.remove(index);
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#setChild(thirdstage.exercise.data.tree.case11.TreeNode, int)
	 */
	public void setChild(TreeNode child, int index){
		this.children.set(index, child);
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#setDescription(java.lang.String)
	 */
	public void setDescription(String desc){
		this.description = desc;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#setId(java.lang.String)
	 */
	public void setId(String id){
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#setName(java.lang.String)
	 */
	public void setName(String name){
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.data.tree.case11.TreeNode#setParent(thirdstage.exercise.data.tree.case11.TreeNode)
	 */
	public void setParent(TreeNode parent){
		this.parent = parent;
		
	}
	
}
