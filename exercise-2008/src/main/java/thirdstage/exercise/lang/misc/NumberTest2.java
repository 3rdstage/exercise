/**
 * 
 */
package thirdstage.exercise.lang.misc;

import java.math.BigDecimal;

/**
 * @author 3rdstage
 *
 */
public class NumberTest2 {
	
	public static void main(String... args){
		
		NumberTest2 testee = new NumberTest2();
		
		testee.testDoublePrecision();
		testee.testDoubleToString();
		testee.testDoubleToStringMore();
		testee.testDoubleStaticToString();
		testee.testStringValueOfDouble();
		testee.testBigDecimalConstructedWithDouble();
	}
	
	
	public void testDoublePrecision(){
		
		double a = 1.10;
		double b = 2.00;
		double c = 0.90;
		
		System.out.println("");
		System.out.println("Testig printing of double : ");
		System.out.println("printing double a = 1.10 : " + a);
		System.out.println("printing double b = 2.00 : " + b);
		System.out.println("printing double c = 0.90 : " + c);
		System.out.println("printing 2.00 - 1.10 : " + (b - a));
		System.out.println("printing 2.00*1000 - 1.10*100 : " + (b*1000 - a*100));
		System.out.println("");
		
	}
	
	public void testDoubleToString(){
		
		String s1 = "2.00";
		String s2 = "1.10";
		String s3 = "0.90";
		
		Double x1 = new Double(s1);
		Double x2 = new Double(s2);
		Double x3 = new Double(s3);
		Double x4 = new Double(x1 - x2);
		
		System.out.println("");
		System.out.println("Testing Double.toString() method : ");
		System.out.println("new Double(" + s1 + ").toString() : " + x1.toString());
		System.out.println("new Double(" + s2 + ").toString() : " + x2.toString());
		System.out.println("new Double(" + s3 + ").toString() : " + x3.toString());
		System.out.println("new Double(" + s1 + " - " + s2 + ").toString() : " + x4.toString());
	}
	
	public void testDoubleToStringMore(){
		
		Double a2 = 1.10;
		Double a3 = 1.100;
		Double a16 = 1.1000000000000000;
		Double a17 = 1.10000000000000000;
		Double a18 = 1.100000000000000000;
		
		System.out.println("");
		System.out.println("Testing Double.toString() method more : ");
		System.out.println("(1.10).toString() : " + a2.toString());
		System.out.println("(1.100).toString() : " + a3.toString());
		System.out.println("(1.1000000000000000).toString() : " + a16.toString());
		System.out.println("(1.10000000000000000).toString() : " + a17.toString());
		System.out.println("(1.100000000000000000).toString() : " + a18.toString());
		
		System.out.println("");
	}
	
	public void testDoubleStaticToString(){
		
		double a = 1.10;
		double b = 2.00;
		double c = 0.90;
		double d = b - a;
		
		System.out.println("");
		System.out.println("Testing static Double.toString(double) method : ");
		System.out.println("Double.toString(1.10) : " + Double.toString(a));
		System.out.println("Double.toString(2.00) : " + Double.toString(b));
		System.out.println("Double.toString(0.90) : " + Double.toString(c));
		System.out.println("Double.toString(2.00 - 1.10) : " + Double.toString(d));
		System.out.println("");
	}
	
	
	
	
	public void testStringValueOfDouble(){
		double a = 1.10;
		double b = 2.00;
		double c = 0.90;
		double d = b - a;
		
		System.out.println("");
		System.out.println("String.valueOf(1.10) : " + String.valueOf(a));
		System.out.println("String.valueOf(2.00) : " + String.valueOf(b));
		System.out.println("String.valueOf(0.90) : " + String.valueOf(c));
		System.out.println("String.valueOf(2.00 - 1.10) : " + String.valueOf(d));
		
		
	}
	
	
	public void testBigDecimalConstructedWithDouble(){
		
		BigDecimal c = new BigDecimal(0.1);
		BigDecimal d = new BigDecimal(String.valueOf(0.1));
		BigDecimal e = new BigDecimal(0.10000000000000001);
		BigDecimal f = new BigDecimal(0.10000000000000002);

		BigDecimal x = new BigDecimal(2.00);
		BigDecimal y = new BigDecimal(1.10);
		BigDecimal z = new BigDecimal(2.00 - 1.10);
		
		System.out.println("");
		System.out.println("new BigDecimal(0.1).toString() is : " + c.toString());
		System.out.println("new BigDecimal(0.1).toPlainString() is : " + c.toPlainString());
		System.out.println("new BigDecimal(0.1).toEngineeringString() is : " + c.toEngineeringString());
	
		System.out.println("new BigDecimal(String.valueOf(0.1)).toString() is : " + d.toString());

		System.out.println("new BigDecimal(0.10000000000000001).toString() is : " + e.toString());
		System.out.println("new BigDecimal(0.10000000000000002).toString() is : " + f.toString());

		System.out.println("new BigDecimal(2.00).toString() is : " + x.toString());
		System.out.println("new BigDecimal(1.10).toString() is : " + y.toString());
		System.out.println("new BigDecimal(2.00 - 1.10).toString() is : " + z.toString());
		
	}

}
