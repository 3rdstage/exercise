/**
 * 
 */
package thirdstage.exercise.data.tree.case11.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import thirdstage.exercise.data.tree.case11.DefaultTree;
import thirdstage.exercise.data.tree.case11.DefaultTreeNode;
import thirdstage.exercise.data.tree.case11.Tree;
import thirdstage.exercise.data.tree.case11.TreeNode;

/**
 * @author 3rdstage
 *
 */
public class DefaultTreeTest{

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}

	/**
	 * Test method for {@link thirdstage.exercise.data.tree.case11.DefaultTree#getOrderedList()}.
	 */
	@Test
	public void testGetOrderedList(){
		
		Tree tree = new DefaultTree();
		TreeNode root = new DefaultTreeNode("0");
		tree.setRootNode(root);
		tree.addNode(new DefaultTreeNode("1"), "0");
		tree.addNode(new DefaultTreeNode("2"), "0");
		tree.addNode(new DefaultTreeNode("3"), "0");
		tree.addNode(new DefaultTreeNode("4"), "1");
		tree.addNode(new DefaultTreeNode("5"), "2");
		tree.addNode(new DefaultTreeNode("6"), "2");
		tree.addNode(new DefaultTreeNode("7"), "3");
		tree.addNode(new DefaultTreeNode("8"), "3");
		tree.addNode(new DefaultTreeNode("9"), "3");
		tree.addNode(new DefaultTreeNode("10"), "4");
		tree.addNode(new DefaultTreeNode("11"), "4");
		tree.addNode(new DefaultTreeNode("12"), "8");

		List<TreeNode> list = tree.getOrderedList();
		
		System.out.println("");
		for(int i = 0, n = list.size(); i < n; i++){
			System.out.println(list.get(i).getId());
		}
		System.out.println("");
		
		int cnt = 0;
		Assert.assertEquals("0", list.get(cnt++).getId());
		Assert.assertEquals("1", list.get(cnt++).getId());
		Assert.assertEquals("4", list.get(cnt++).getId());
		Assert.assertEquals("10", list.get(cnt++).getId());
		Assert.assertEquals("11", list.get(cnt++).getId());
		Assert.assertEquals("2", list.get(cnt++).getId());
		Assert.assertEquals("5", list.get(cnt++).getId());
		Assert.assertEquals("6", list.get(cnt++).getId());
		Assert.assertEquals("3", list.get(cnt++).getId());
		Assert.assertEquals("7", list.get(cnt++).getId());
		Assert.assertEquals("8", list.get(cnt++).getId());
		Assert.assertEquals("12", list.get(cnt++).getId());
		Assert.assertEquals("9", list.get(cnt++).getId());


		
	}

}
