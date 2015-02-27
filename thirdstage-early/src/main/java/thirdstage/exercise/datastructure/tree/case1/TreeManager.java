/*
 * TreeManager.java
 *
 * Created on 2006년 11월 2일 (목), 오전 8:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package thirdstage.exercise.datastructure.tree.case1;

/**
 *
 * @author 3rdstage
 */
public interface TreeManager {
	
	public TreeNode getNode(Long id) throws Exception;
	
	public TreeNode createNode(TreeNode node) throws Exception;
	
	public java.util.List<TreeNode> getAllNodes() throws Exception;
	
	public java.util.List<TreeNode> getSiblings(TreeNode node) throws Exception;
	
	public java.util.List<TreeNode> getNextSibling(TreeNode node) throws Exception;
	
	public java.util.List<TreeNode> getPreviousSibling(TreeNode node) throws Exception;
	
	public java.util.List<TreeNode> getTopNodes() throws Exception;
	
	public java.util.List<TreeNode> getAllNodesFlatted() throws Exception;
	
	
	
	
}
