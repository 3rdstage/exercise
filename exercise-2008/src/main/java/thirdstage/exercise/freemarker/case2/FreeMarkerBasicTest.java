package thirdstage.exercise.freemarker.case2;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template; 

public class FreeMarkerBasicTest {
	
	private static Configuration config;
	
	@BeforeClass
	public void beforeClass() {
		
		config = new Configuration();
		config.setClassForTemplateLoading(this.getClass(), "/");
		BeansWrapper bw = new BeansWrapper();
		bw.setExposeFields(true);
		config.setObjectWrapper(bw);
		
	}

	@Test
	public void testArray01() throws Exception {
		String p = "thirdstage/exercise/freemarker/case2/array-test.ftl";
		Template tpl = config.getTemplate(p);

		String[] line = new String[5];
		for(int i = 0, n = line.length; i < n; i++){
			line[i] = "Point(" + i + ")";
		}		
		
		String[][] contents = new String[3][4];
		for(int i = 0, n = contents.length; i < n; i++){
			for(int j = 0, m = contents[0].length; j < m; j++){
				contents[i][j] = "Cell(" + i + ", " + j + ")";
			}
		}
		
		Map<String, Object> dm = new HashMap<String, Object>();
		dm.put("line", line);
		dm.put("contents", contents);
		
		StringWriter sw = new StringWriter();
		tpl.process(dm, sw);
		
		String result = sw.toString();
		System.out.println(result);
		
		Assert.assertNotNull(result);
	}

	@Test
	public void testFunction01() throws Exception {
		String p = "thirdstage/exercise/freemarker/case2/function-test.ftl";
		Template tpl = config.getTemplate(p);

		double[] nums = new double[5];
		for(int i = 0, n = nums.length; i < n; i++){
			nums[i] = 1.1 + 0.1*i;
		}
		
		Map<String, Object> dm = new HashMap<String, Object>();
		dm.put("nums", nums);
		
		StringWriter sw = new StringWriter();
		tpl.process(dm, sw);
		
		String result = sw.toString();
		System.out.println(result);
		
		Assert.assertNotNull(result);
	}
	
}
