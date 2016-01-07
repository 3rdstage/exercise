/**
 * 
 */
package thirdstage.exercise.datatype;

import static java.lang.System.out;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.validator.routines.IntegerValidator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author 3rdstage
 *
 */
/**
 * @author 3rdstage
 *
 */
public class StringHandlingTest{

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
	 * Tests of <code>org.apache.commons.lang.math.NumberUtils.isNumber()</code> method
	 * using various parameters.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNumberUtilsIsNumber() throws Exception{
		
		List<String> strs = new ArrayList<String>();
		List<String> comments = new ArrayList<String>();

		strs.add("128.2");
		comments.add("숫자와 소수점 허용.");

		strs.add("128.");
		comments.add("소수점으로 끝나는 경우 허용하지 않음.");

		strs.add("128.0");
		comments.add("정밀도(precision)를 명시하기 위해 소수점 이하 0을 표시하는 경우 허용.");
		
		strs.add("00128.2000");
		comments.add("앞부분에 위치하는 0(zero) 허용.");

		strs.add("000");
		comments.add("\"");

		strs.add("");
		comments.add("빈문자열은 허용하지 않음.");
		
		strs.add(null);
		comments.add("null은 허용하지 않음.");
		
		strs.add("-128.2");
		comments.add("맨앞의 - 기호 허용.");

		strs.add("-00128.2000");
		comments.add("\"");
		
		strs.add("+128.2");
		comments.add("맨앞의 + 기호는 허용하지 않음.");
		
		strs.add(" 128.2 ");
		comments.add("앞뒤의 여백문자 허용하지 않음.");
		
		strs.add("0x128");
		comments.add("정수 앞에 붙은 16진 지시어(0x) 허용.");

		strs.add("0X128");
		comments.add("정수 앞에 붙은 16진 지시어(0x) 허용.");
		
		strs.add("-0x128");
		comments.add("음의 정수에 사용한 16진 지시어(0x) 허용.");
		
		strs.add("0x128.2");
		comments.add("정수가 아닌 실수에 대한 16진 지시어(0x) 허용하지 않음.");

		strs.add("0x128.0");
		comments.add("소수점이 있는 경우, 소수 부분이 0이라 하더라도 정수로 인식하지 않음.");

		strs.add("0xA2B");
		comments.add("16진수에 대해서는 A, B, C, D, E, F 허용.");
	
		strs.add("12B.0");
		comments.add("10진수에 대해서는 A, B, C, D, E, F 허용하지 않음.");
		
		strs.add("128L");
		comments.add("맨뒤에 위치하는 데이터타입 지시어(L, l, D, d, F, f) 허용.");
		
		strs.add("128l");
		comments.add("\"");

		strs.add("128.2L");
		comments.add("\"");

		strs.add("128.2D");
		comments.add("\"");
		
		strs.add("128.2d");
		comments.add("\"");

		strs.add("128D");
		comments.add("\"");
		
		strs.add("128.2F");
		comments.add("\"");

		strs.add("128.2f");
		comments.add("\"");

		strs.add("128.2e3");
		comments.add("자연지수를 이용한 과학적 표기법 허용");
		
		strs.add("128.2E3");
		comments.add("\"");

		strs.add("128.2e-3");
		comments.add("\"");
		
		int l = 0;
		for(String str : strs){
			if(str != null && str.length() > l) l = str.length();
		}
		
		out.println("");
		for(int i = 0, n = strs.size(); i < n; i++){
			if(strs.get(i) != null){
				out.println(String.format("%1$-" + (l + 23 + 3) + "s", "NumberUtils.isNumber(\"" + strs.get(i) + "\")") + " = " + String.format("%1$-5b", NumberUtils.isNumber(strs.get(i))) + " //" + comments.get(i));
			}
			else{
				out.println(String.format("%1$-" + (l + 23 + 3) + "s", "NumberUtils.isNumber(null)") + " = " + String.format("%1$-5b", NumberUtils.isNumber(strs.get(i))) + " //" + comments.get(i));
				
			}
		}
		
		assertTrue(true);
	
	}

	@Test
	public void testNumberUtilsIsDigits() throws Exception{
		
		List<String> strs = new ArrayList<String>();
		List<String> comments = new ArrayList<String>();

		strs.add("128");
		comments.add("양의 정수 허용.");

		strs.add("-128");
		comments.add("음의 정수 허용하지 않음. --;");

		
		int l = 0;
		for(String str : strs){
			if(str != null && str.length() > l) l = str.length();
		}
		
		out.println("");
		for(int i = 0, n = strs.size(); i < n; i++){
			if(strs.get(i) != null){
				out.println(String.format("%1$-" + (l + 23 + 3) + "s", "NumberUtils.isDigit(\"" + strs.get(i) + "\")") + " = " + String.format("%1$-5b", NumberUtils.isDigits(strs.get(i))) + " //" + comments.get(i));
			}
			else{
				out.println(String.format("%1$-" + (l + 23 + 3) + "s", "NumberUtils.isDigit(null)") + " = " + String.format("%1$-5b", NumberUtils.isDigits(strs.get(i))) + " //" + comments.get(i));
				
			}
		}
		
		assertTrue(true);
		
	}
	
	
	/**
	 * 
	 * 
	 * @see org.apache.commons.validator.routines.IntegerValidator#IntegerValidator()
	 */
	@Test
	public void testIntegerValidatorIsValid(){
		
		IntegerValidator validator1 = new IntegerValidator(); //strict instance
		IntegerValidator validator2 = new IntegerValidator(false, IntegerValidator.STANDARD_FORMAT); //unstrict instance
		
		List<String> strs = new ArrayList<String>();
		List<String> comments = new ArrayList<String>();
		
		strs.add("128");
		comments.add("");
		
		strs.add("128.0");
		comments.add("");
		
		int l = 0;
		for(String str : strs){
			if(str != null && str.length() > l) l = str.length();
		}
		
		out.println("");
		out.println("[[With Strict Validator]]");
		for(int i = 0, n = strs.size(); i < n; i++){
			if(strs.get(i) != null){
				out.println(String.format("%1$-" + (l + 23 + 3) + "s", "IntegerValidator.isValid(\"" + strs.get(i) + "\")") + " = " + validator1.isValid(strs.get(i)) + " //" + comments.get(i));
			}
			else{
				out.println(String.format("%1$-" + (l + 23 + 3) + "s", "IntegerValidator.isValid(null)") + " = " + validator1.isValid(strs.get(i)) + " //" + comments.get(i));
				
			}
		}
		
		out.println("\n\n\n");
		out.println("[[With Unstrict Validator]]");
		for(int i = 0, n = strs.size(); i < n; i++){
			if(strs.get(i) != null){
				out.println(String.format("%1$-" + (l + 23 + 3) + "s", "IntegerValidator.isValid(\"" + strs.get(i) + "\")") + " = " + validator2.isValid(strs.get(i)) + " //" + comments.get(i));
			}
			else{
				out.println(String.format("%1$-" + (l + 23 + 3) + "s", "IntegerValidator.isValid(null)") + " = " + validator2.isValid(strs.get(i)) + " //" + comments.get(i));
				
			}
		}		
		
		assertTrue(true);		
		
		
	}
	
	
}
