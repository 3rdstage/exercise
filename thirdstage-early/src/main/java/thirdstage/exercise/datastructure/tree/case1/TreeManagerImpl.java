/*
 * TreeManagerImpl.java
 *
 * Created on 2006년 11월 2일 (목), 오전 8:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package thirdstage.exercise.datastructure.tree.case1;

import java.util.List;
import org.apache.commons.lang.math.JVMRandom;

/**
 *
 * @author 3rdstage
 */
public class TreeManagerImpl implements TreeManager{
	
	/** Creates a new instance of TreeManagerImpl */
	public TreeManagerImpl() {
	}

	public List<TreeNode> getSiblings(TreeNode node) throws Exception {
		//@todo 3rdstage, 2006-11-01, not yet implemented
		return null;

	}

	public TreeNode createNode(TreeNode node) throws Exception {
		//@todo 3rdstage, 2006-11-01, not yet implemented
		return null;
	}

	public TreeNode getNode(Long id) throws Exception {
		//@todo 3rdstage, 2006-11-01, not yet implemented
		return null;
	}

	public List<TreeNode> getTopNodes() throws Exception {
		//@todo 3rdstage, 2006-11-01, not yet implemented
		return null;
	}

	public List<TreeNode> getAllNodesFlatted() throws Exception {
		
		//@todo 3rdstage, 2006-11-01, under implementation.
		java.util.List<TreeNode> flattedNodes = new java.util.ArrayList<TreeNode>();
		
		java.util.List<TreeNode> topNodes = this.getTopNodes();
		
		TreeNode current = null;
		java.util.List<TreeNode> children = null;
		return null;
	}
	
	public void hop(TreeNode node, java.util.List<TreeNode> flattedNodes) throws Exception{
		
		if(node.getChildren().size() == 0){
			TreeNode parentNode = node.getParent(); 
			
			
			int n = parentNode.getChildren().indexOf(node);
			
			//if()
			
		}
		else{
			hop(node.getChildren().get(0), flattedNodes);
		}
		
		
	}
	

	public List<TreeNode> getAllNodes() throws Exception {
		//@todo 3rdstage, 2006-11-01, not yet implemented
		return null;
	}

	public List<TreeNode> getPreviousSibling(TreeNode node) throws Exception {
		
		return null;
	}

	public List<TreeNode> getNextSibling(TreeNode node) throws Exception {
		
		return null;
	}
	
	
	
}
