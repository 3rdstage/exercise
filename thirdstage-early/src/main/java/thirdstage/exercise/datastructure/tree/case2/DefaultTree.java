package thirdstage.exercise.datastructure.tree.case2;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 3rdstage
 */
public class DefaultTree implements Tree{
	
	private TreeNode rootNode = null;
	
	private java.util.List<TreeNode> nodes = null;
	
	
	/** Creates a new instance of DefaultTree */
	public DefaultTree() {
	}

	public void addNode(TreeNode node) {
		
		this.nodes.add(node);

		Iterator itr = nodes.iterator();
		TreeNode aNode = null; 
		while(itr.hasNext()){
			aNode = (TreeNode)(itr.next());
			
			
		}
		
	}

	public List<TreeNode> getSortedNodeList() {
		return null;
	}

	public TreeNode getRootNode() {
		return null;
	}

	public TreeNode getNode(TreeNodeId id) {
		return null;
	}

	
}
