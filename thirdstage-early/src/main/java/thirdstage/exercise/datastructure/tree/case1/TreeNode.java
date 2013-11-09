package thirdstage.exercise.datastructure.tree.case1;

/**
 *
 * @author 3rdstage
 * @since 2006-11-02
 */
public interface TreeNode {
	

	public Long getId();
	public void setId(Long id);
	
	public String getName();
	public void setName(String name);
	
	public String getDescription();
	public void setDescription(String desc);
	
	public java.util.Date getCreatedDate();
	public void setCreatedDate(java.util.Date createdDate);
	
	public TreeNode getParent();
	public void setParent(TreeNode node);
	
	public java.util.List<TreeNode> getChildren();
	public void setChildren(java.util.List<TreeNode> Node);
	
}
