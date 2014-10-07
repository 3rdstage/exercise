/**
 * 
 */
package thirdstage.exercise.jackson.databind.case2;

import javax.annotation.Nonnull;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 3rdstage
 *
 */
public class Tree{
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("root")
	private TreeNode root;
	
	public Tree(){}
	
	public Tree(@Nonnull String name, @Nonnull TreeNode root){
		this.name = name;
		this.root = root;
	}
	
	public String getName(){ return this.name; }
	
	public Tree setName(String name){ 
		this.name = name;
		return this;
	}
	
	public TreeNode getRoot(){ return this.root; }
	
	public Tree setRoot(@Nonnull TreeNode node){ 
		this.root = node; 
		return this;
	}
	
	
	
	
	
	

}
