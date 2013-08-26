/**
 * 
 */
package thirdstage.exercise.rhino.case1;

import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.NodeVisitor;
import org.mozilla.javascript.ast.PropertyGet;

/**
 * @author 3rdstage
 *
 */
public class IdentifyingNodeVisitor implements NodeVisitor {

	/* (non-Javadoc)
	 * @see org.mozilla.javascript.ast.NodeVisitor#visit(org.mozilla.javascript.ast.AstNode)
	 */
	@Override
	public boolean visit(AstNode node) {
		String className = node.getClass().getName();
		String shortName = node.shortName();
		String str = node.toString();
		
		System.out.printf("Node - name : %1$s, class : %2$s, string : %3$s\n", shortName, className, str);
		System.out.printf("       toSource : %1$s\n", node.toSource());
		if(node instanceof PropertyGet){
			System.out.printf("       property : %1$s\n", ((PropertyGet)node).getProperty().getIdentifier());
		}
		System.out.println(node.debugPrint());
		
		return true;
	}

}
