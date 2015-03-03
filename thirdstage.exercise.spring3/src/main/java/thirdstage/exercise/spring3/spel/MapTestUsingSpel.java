package thirdstage.exercise.spring3.spel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@ContextConfiguration
public class MapTestUsingSpel extends AbstractTestNGSpringContextTests{
	
	@Resource(name = "map")
	private Map map;
	
	enum KEYS{
		ID,
		NAME,
		DESCRIPTION,
		PRICE,
		SHIPS_FREE,
		STOCKS;
		
		private static int size = KEYS.class.getEnumConstants().length;;
		
		public static int size(){
			return size;
		}
	}
	
	private static List<Map> salesItems = new ArrayList<Map>(); 


	@BeforeClass
	public void prepareMaps(){
		
		Map<String, Object> item = new HashMap<String, Object>(KEYS.size());
		item.put(KEYS.ID.name(), "ITM0001");
		item.put(KEYS.NAME.name(), "Canon EOS 600D");
		item.put(KEYS.DESCRIPTION.name(), "");
		item.put(KEYS.PRICE.name(), 900000);
		item.put(KEYS.SHIPS_FREE.name(), true);
		item.put(KEYS.STOCKS.name(), 15);
		salesItems.add(item);
		
		item = new HashMap<String, Object>(KEYS.size());
		item.put(KEYS.ID.name(), "ITM0002");
		item.put(KEYS.NAME.name(), "Canon EOS 60D");
		item.put(KEYS.DESCRIPTION.name(), "");
		item.put(KEYS.PRICE.name(), 1200000);
		item.put(KEYS.SHIPS_FREE.name(), true);
		item.put(KEYS.STOCKS.name(), 5);
		salesItems.add(item);
		
		item = new HashMap<String, Object>(KEYS.size());
		item.put(KEYS.ID.name(), "ITM0003");
		item.put(KEYS.NAME.name(), "Canon EOS 5D Mark III");
		item.put(KEYS.DESCRIPTION.name(), "");
		item.put(KEYS.PRICE.name(), 2000000);
		item.put(KEYS.SHIPS_FREE.name(), true);
		item.put(KEYS.STOCKS.name(), 0);
		salesItems.add(item);		
		
		item = new HashMap<String, Object>(KEYS.size());
		item.put(KEYS.ID.name(), "ITM0003");
		item.put(KEYS.NAME.name(), "Sony Alpha 57");
		item.put(KEYS.DESCRIPTION.name(), "");
		item.put(KEYS.PRICE.name(), 2000000);
		item.put(KEYS.SHIPS_FREE.name(), true);
		item.put(KEYS.STOCKS.name(), 0);
		salesItems.add(item);
	}
	

	@Test
	public void testAccessingSalesItemsBySpel() {
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression idExp = parser.parseExpression("#this[ID]");
		String id1 = idExp.getValue(this.salesItems.get(0), String.class);
		
		Assert.assertEquals(this.salesItems.get(0).get(KEYS.ID.toString()), id1);
	}
	
	@Test
	public void testPropertyConfigurerAndProperty(){
		
		System.out.println(this.map);
		

	}
}
