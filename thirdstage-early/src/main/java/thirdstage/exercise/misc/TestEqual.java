package thirdstage.exercise.misc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class TestEqual{
	
	public static void main(String[] args){
		
		String s1 = new String("Test");
		String s2 = new String("Test");
		
		int h1 = s1.hashCode();
		int h2 = s2.hashCode();
		
		System.out.println("Hashcode for String 1(new String(\"Test\") is : " + h1);
		System.out.println("Hashcode for String 2(new String(\"Test\") is : " + h2);
		System.out.println("Reference equality test for String 1 and String 2 is : " + (s1 == s2));
		System.out.println("");
		
	    String s3 = "Test2";
	    String s4 = "Test2";
	    
	    int h3 = s3.hashCode();
	    int h4 = s4.hashCode();
	    
	    System.out.println("Hashcode for String 3(\"Test2\") is : " + h3);
		System.out.println("Hashcode for String 4(\"Test2\") is : " + h4);
		System.out.println("Reference equality test for String 3 and String 4 is : " + (s1 == s2));
		System.out.println("");
		
		
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);

		int h5 = i1.hashCode();
		int h6 = i2.hashCode();
		
		System.out.println("Hashcode for Integer object 1(new Integer(1)) is : " + h5);
		System.out.println("Hashcode for Integer object 2(new Integer(1)) is : " + h6);
		System.out.println("String value for Integer object 1 is : " + i1.toString());
		System.out.println("String value for Integer object 1 again is : " + i1);
		System.out.println("String value for Integer object 2 is : " + i2.toString());
		System.out.println("String value for Integer object 2 again is : " + i2);
		System.out.println("Reference equality test for Integer object 1 and Integer object 2 is : " + (i1 == i2));
		System.out.println("");

		
		List l1 = new ArrayList();
		List l2 = new ArrayList();
		
		int h7 = l1.hashCode();
		int h8 = l2.hashCode();
		
		System.out.println("Hashcode for List object 1(new ArrayList()) is : " + h7);
		System.out.println("Hashcode for List object 2(new ArrayList()) is : " + h8);
		System.out.println("String value for List object 1 with toString method is : " + l1.toString());
		System.out.println("String value for List object 1 w/o toString method is : " + l1);
		System.out.println("String value for List object 2 with toString method is : " + l2.toString());
		System.out.println("String value for List object 2 w/o toString method is : " + l2);
		System.out.println("Reference equality test for List object 1 and List object 2 is : " + (l1 == l2));
		System.out.println("");		

		
		Period pd1 = new Period();
		Period pd2 = new Period();

		int h9 = pd1.hashCode();
		int h10 = pd2.hashCode();
		
		System.out.println("Hashcode for Period object 1(new Period()) is : " + h9);
		System.out.println("Hashcode for Period object 2(new Period()) is : " + h10);
		System.out.println("String value for Period object 1 with toString method is : " + pd1.toString());
		System.out.println("String value for Period object 1 w/o toString method is : " + pd1);
		System.out.println("String value for Period object 2 with toString method is : " + pd2.toString());
		System.out.println("String value for Period object 2 w/o toString method is : " + pd2);
		System.out.println("Reference equality test for Period object 1 and Period object 2 is : " + (pd1 == pd2));
		System.out.println("");		
	
	}

}


class Period{
	
	Date startTime;
	Date endTime;
	
	public Period(){
		
	}
	
	public Period(Date start, Date end){
		this.startTime = start;
		this.endTime = end;
	}

	public Date getStartTime(){ return this.startTime; }
	public Date getEndTime(){ return this.endTime; }
	
	public void setStartTime(Date dt){ this.startTime = dt; }
	public void endTime(Date dt){ this.endTime = dt; }
	
	public long getDurationInSecond(){ return 0L; }
	
	
	
	
}
