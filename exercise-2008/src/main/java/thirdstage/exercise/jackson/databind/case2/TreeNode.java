/**
 * 
 */
package thirdstage.exercise.jackson.databind.case2;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 3rdstage
 *
 */
public class TreeNode{
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("children")
	private List<TreeNode> children = new ArrayList<TreeNode>();
	
	public TreeNode(){}
	
	public TreeNode(String id, String title){
		this.id = id;
		this.title = title;
	}
	
	public String getId(){ return this.id; }
	
	public TreeNode setId(String id){ 
		this.id = id;
		return this;
	}

	public String getTitle(){ return this.title; }
	
	public TreeNode setTitle(String title){ 
		this.title = title;
		return this;
	}
	
	public @Nonnull List<TreeNode> getChildren(){ return this.children; }
	
	public TreeNode addChild(@Nonnull TreeNode node){
		this.children.add(node);
		return this;
	}
	
	

}
