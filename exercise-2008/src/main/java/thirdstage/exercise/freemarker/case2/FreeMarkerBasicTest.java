package thirdstage.exercise.freemarker.case2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;

public class FreeMarkerBasicTest {
	
	private static Configuration fmConfig;
	
	@BeforeClass
	public void beforeClass() {
		
		fmConfig = new Configuration();
		fmConfig.setClassForTemplateLoading(this.getClass(), "/");
		BeansWrapper bw = new BeansWrapper();
		bw.setExposeFields(true);
		fmConfig.setObjectWrapper(bw);
		
	}

	@Test
	public void testBasic001() {
		
		
		
	}

}
