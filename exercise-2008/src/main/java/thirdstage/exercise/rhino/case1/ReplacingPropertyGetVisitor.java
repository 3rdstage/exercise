/**
 * 
 */
package thirdstage.exercise.rhino.case1;

import org.mozilla.javascript.Node;
import org.mozilla.javascript.ast.Assignment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.NodeVisitor;
import org.mozilla.javascript.ast.PropertyGet;

/**
 * @author 3rdstage
 *
 */
public class ReplacingPropertyGetVisitor implements NodeVisitor {

	/* (non-Javadoc)
	 * @see org.mozilla.javascript.ast.NodeVisitor#visit(org.mozilla.javascript.ast.AstNode)
	 */
	@Override
	public boolean visit(AstNode node) {
		
		if(node instanceof PropertyGet){
			String str = node.toSource();
			
			if(str != null && str.startsWith("a.")){
				str = "$(\"#a\")" + str.substring(1);
				Node node2 = node.newString(str);
				
				Node p = node.getParent();
				if(p instanceof Assignment){
					Assignment p2 = (Assignment)p;
					if(node.equals(p2.getLeft())){

					}
					
					
				}
				
				
				p.removeChild(node);	
			}
			
			return false;
		}else{
			return true;
		}
	}

}
