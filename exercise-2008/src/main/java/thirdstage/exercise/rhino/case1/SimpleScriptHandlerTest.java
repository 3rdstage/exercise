package thirdstage.exercise.rhino.case1;

import java.net.URL;

import org.mozilla.javascript.ast.NodeVisitor;
import org.testng.annotations.Test;

public class SimpleScriptHandlerTest {

	@Test
	public void testProcess01() throws Exception{
		
		String path = "thirdstage/exercise/rhino/case1/simple-script-01.js";
		this.testProcess(path,new IdentifyingNodeVisitor());
	}
	
	@Test
	public void testProcess02() throws Exception{
		
		String path = "thirdstage/exercise/rhino/case1/simple-script-02.js";
		this.testProcess(path,new IdentifyingNodeVisitor());
	}
	
	@Test
	public void testProcess03() throws Exception{
		
		String path = "thirdstage/exercise/rhino/case1/simple-script-02.js";
		this.testProcess(path,new ReplacingPropertyGetVisitor());
	}
	
	private void testProcess(String path, NodeVisitor vst) throws Exception{
		
		URL url = ClassLoader.getSystemResource(path);
		SimpleScriptHandler ssh = new SimpleScriptHandler(vst);
		
		ssh.process(new java.io.File(url.toURI()));
	}
	
}
