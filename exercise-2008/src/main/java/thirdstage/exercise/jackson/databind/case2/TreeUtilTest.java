package thirdstage.exercise.jackson.databind.case2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class TreeUtilTest {
	
	protected static TreeUtil util; //thread-safe
	
	protected static Tree categoryTree;
	
	
	@BeforeClass
	public void beforeClass() {
		util = new TreeUtil();

		TreeNode[] nodes = {
			new TreeNode("CAT0001", "Electronics"), 
			new TreeNode("CAT0002", "Cell Phones"),
			new TreeNode("CAT0003", "Smartphones"),
			new TreeNode("CAT0004", "Digital Camera"),
			new TreeNode("CAT0005", "Fashion"),
			new TreeNode("CAT0006", "Women's Clothing"),
			new TreeNode("CAT0007", "Women's Handbags"),
			new TreeNode("CAT0008", "Women's Shoes"),
			new TreeNode("CAT0009", "Women's Accessories"),
			new TreeNode("CAT0010", "Men's Clothing"),
			new TreeNode("CAT0011", "Men's Shoes"),
			new TreeNode("CAT0012", "Men's Accessories"),
			new TreeNode("CAT0013", "Jacket"),
			new TreeNode("CAT0014", "Coat")
		};
		
		nodes[0].addChild(nodes[1]).addChild(nodes[2]).addChild(nodes[3]);
		nodes[4].addChild(nodes[5]).addChild(nodes[6])
			.addChild(nodes[7]).addChild(nodes[8])
			.addChild(nodes[9]).addChild(nodes[10])
			.addChild(nodes[11]);
		nodes[5].addChild(nodes[12]).addChild(nodes[13]);
		
		TreeNode root = new TreeNode("CAT0000", "Root")
			.addChild(nodes[0]).addChild(nodes[4]);
		
		categoryTree = new Tree("Categories", root);
	}


	@Test
	public void testSerializeTreeToJson() throws Exception{
		
		System.out.println(util.serializeTreeToJson(categoryTree));
	}
	
	@Test
	public void testSerializeTreeToIndentedJson() throws Exception{
		System.out.println(util.serializeTreeToIndentedJson(categoryTree));
	}
}
