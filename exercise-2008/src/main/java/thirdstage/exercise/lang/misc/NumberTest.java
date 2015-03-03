/**
 * 
 */
package thirdstage.exercise.lang.misc;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author 3rdstage
 *
 */
public class NumberTest {
	
	public static void main(String... args){
		
		NumberTest testee = new NumberTest();
		
//		testee.testDoublePrecision();
//		testee.testDoubleToString();
//		testee.testDoubleToStringMore();
//		testee.testDoubleStaticToString();
//		testee.testStringValueOfDouble();
//		testee.testBigDecimalConstructedWithDouble();
//		testee.testBigDecimalConstructedWithString();
		
		testee.testDoubleToBigDecimalViaString();
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
		
		Double a = 1.10;
		Double b = 2.00;
		Double c = 0.90;
		Double d = b - a;
		
		System.out.println("");
		System.out.println("Testing Double.toString() method : ");
		System.out.println("(1.10).toString() : " + a.toString());
		System.out.println("(2.00).toString() : " + b.toString());
		System.out.println("(0.90).toString() : " + c.toString());
		System.out.println("(2.00 - 1.10).toString() : " + d.toString());
		System.out.println("");
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
		System.out.println("Testing toSting of BigDecimal object constructed with double paramter.");
		System.out.println("new BigDecimal(0.1).toString() is : " + c.toString());
		System.out.println("new BigDecimal(0.1).toPlainString() is : " + c.toPlainString());
		System.out.println("new BigDecimal(0.1).toEngineeringString() is : " + c.toEngineeringString());
	
		System.out.println("new BigDecimal(String.valueOf(0.1)).toString() is : " + d.toString());

		System.out.println("new BigDecimal(0.10000000000000001).toString() is : " + e.toString());
		System.out.println("new BigDecimal(0.10000000000000002).toString() is : " + f.toString());

		System.out.println("new BigDecimal(2.00).toString() is : " + x.toString());
		System.out.println("new BigDecimal(1.10).toString() is : " + y.toString());
		System.out.println("new BigDecimal(2.00 - 1.10).toString() is : " + z.toString());
		System.out.println("");
		
	}

	
	public void testBigDecimalConstructedWithString(){
		
		BigDecimal c = new BigDecimal("0.1");
		BigDecimal d = new BigDecimal(String.valueOf("0.1"));
		BigDecimal e = new BigDecimal("0.10000000000000001");
		BigDecimal f = new BigDecimal("0.10000000000000002");

		BigDecimal x = new BigDecimal("2.00");
		BigDecimal y = new BigDecimal("1.10");
		BigDecimal z = x.subtract(y);
		
		System.out.println("");
		System.out.println("Testing toSting of BigDecimal object constructed with string paramter.");
		System.out.println("new BigDecimal(\"0.1\").toString() is : " + c.toString());
		System.out.println("new BigDecimal(\"0.1\").toPlainString() is : " + c.toPlainString());
		System.out.println("new BigDecimal(\"0.1\").toEngineeringString() is : " + c.toEngineeringString());
	
		System.out.println("new BigDecimal(String.valueOf(\"0.1\")).toString() is : " + d.toString());

		System.out.println("new BigDecimal(\"0.10000000000000001\").toString() is : " + e.toString());
		System.out.println("new BigDecimal(\"0.10000000000000002\").toString() is : " + f.toString());

		System.out.println("new BigDecimal(\"2.00\").toString() is : " + x.toString());
		System.out.println("new BigDecimal(\"1.10\").toString() is : " + y.toString());
		System.out.println("new BigDecimal(2.00 - 1.10).toString() is : " + z.toString());
		System.out.println("");
		
	}
	
	public void testDoubleToBigDecimalViaString(){
		
		double d = 0.1;
		double e = 0.11;
		double f = e - d;
//		MathContext mc1 = MathContext.DECIMAL32;
//		MathContext mc2 = MathContext.UNLIMITED;
		MathContext mc1 = new MathContext(7);
		MathContext mc2 = new MathContext(34);
		
		BigDecimal bd1 = new BigDecimal(d);
		BigDecimal bd2 = new BigDecimal(String.valueOf(d));
		
		System.out.println("bd1 = " + bd1.toString());
		System.out.println("bd2 = " + bd2.toString());

		BigDecimal bd9 = new BigDecimal(d, mc1);
		BigDecimal bd10 = new BigDecimal(String.valueOf(d), mc1);
		
		System.out.println("bd9 = " + bd9.toString());
		System.out.println("bd10 = " + bd10.toString());

		BigDecimal bd11 = new BigDecimal(d, mc2);
		BigDecimal bd12 = new BigDecimal(String.valueOf(d), mc2);
		
		System.out.println("bd11 = " + bd11.toString());
		System.out.println("bd12 = " + bd12.toString());
		
		
		
		BigDecimal bd3 = new BigDecimal(f);
		BigDecimal bd4 = new BigDecimal(String.valueOf(f));
		
		System.out.println("bd3 = " + bd3.toString());
		System.out.println("bd4 = " + bd4.toString());

		BigDecimal bd5 = new BigDecimal(f, mc1);
		BigDecimal bd6 = new BigDecimal(String.valueOf(f), mc1);
		
		System.out.println("bd5 = " + bd5.toString());
		System.out.println("bd6 = " + bd6.toString());

		BigDecimal bd7 = new BigDecimal(f, mc2);
		BigDecimal bd8 = new BigDecimal(String.valueOf(f), mc2);
		
		System.out.println("bd7 = " + bd7.toString());
		System.out.println("bd8 = " + bd8.toString());

	}
}
