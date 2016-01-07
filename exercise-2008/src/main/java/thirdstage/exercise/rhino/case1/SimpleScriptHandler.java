/**
 * 
 */
package thirdstage.exercise.rhino.case1;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.NodeVisitor;

/**
 * @author 3rdstage
 *
 */
public class SimpleScriptHandler {
	
	private NodeVisitor visitor;
	
	
	public SimpleScriptHandler(@Nullable NodeVisitor visitor){
		this.visitor = visitor;
		
	}
	
	public String process(File src) throws Exception{
		
		Context cntx = ContextFactory.getGlobal().enterContext();
		Reader rd = null;
		AstRoot root = null;
		try{
			rd = new java.io.FileReader(src);
			
			CompilerEnvirons env = new CompilerEnvirons();
			env.initFromContext(cntx);
			env.setGeneratingSource(true);
			ErrorReporter errRprt = env.getErrorReporter();
			Parser p = new Parser(env, errRprt);
			root = p.parse(rd, "", 1);
			
			if(this.visitor != null) root.visit(this.visitor);
			
			System.out.println(root.toSource());
			
		}catch(Exception ex){
			throw ex;
		}finally{
			Context.exit();
			if(rd != null) try{ rd.close(); }catch(Exception ex){}
		}
		return null;
	}

}
