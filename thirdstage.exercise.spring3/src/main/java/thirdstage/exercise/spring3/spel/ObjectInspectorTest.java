package thirdstage.exercise.spring3.spel;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ObjectInspectorTest {
	
	private static ObjectInspector inspector;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		inspector = new ObjectInspector();
	}
	
	@Test
	public void testCheckBooleanExpression(){
		
		Person p1 = new Person("Peter", Person.Gender.MALE, (new GregorianCalendar(71, 10, 23)).getTime());
		Person p2 = new Person("Jane", Person.Gender.FEMALE, (new GregorianCalendar(74, 5, 9)).getTime());
		
		//first eye-checking
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		Assert.assertTrue(inspector.checkBooleanExpression(p1, "'Peter'.equals(#root.name)", Person.class));
		Assert.assertTrue(inspector.checkBooleanExpression(p2, "#root.birthday.month == 5", Person.class));
		
		Rectangle rct1 = new Rectangle(5, 10, 3, 6);
		
		Assert.assertTrue(inspector.checkBooleanExpression(rct1, "#root.width == 5", Rectangle.class));
		Assert.assertFalse(inspector.checkBooleanExpression(rct1, "#root.height == 5", Rectangle.class));
		Assert.assertTrue(inspector.checkBooleanExpression(rct1, "#root.area == 15", Rectangle.class));
	}
}

class Person{
	
	enum Gender{ MALE, FEMALE }
	
	private String name;
	private Gender gender;
	private Date birthday;
	
	public Person(String name, Gender gender, Date date){
		this.name = name;
		this.gender = gender;
		this.birthday = date;
	}

	public String getName() { return name; }
	public Gender getGender() { return gender; }
	public Date getBirthday() {	return birthday; }
	
	@Override
	public String toString(){
		return String.format("Name : %1$s, Gender : %2$s, Birthday : %3$tF", this.name, this.gender, this.birthday);
	}
}


class Rectangle{
	
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	public Rectangle(int x1, int x2, int y1, int y2){
		if(x1 > x2) throw new IllegalArgumentException("x1 should not greater than x2");
		if(y1 > y2) throw new IllegalArgumentException("y1 should not greater than y2");
		
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public int getX1() { return x1; }
	public int getX2() { return x2;	}
	public int getY1() { return y1;	}
	public int getY2() { return y2;	}
	
	public int getWidth(){ return (x2 - x1); }
	public int getHeight(){ return (y2 - y1); }
	public int getArea(){ return (this.getWidth())*(this.getHeight()); }
}


