/**
 * 
 */
package thirdstage.exercise.lang.misc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * @author 3rdstage
 *
 */
public class ShortAndStringTest {
	
	
	
	public static void main(String... args){
		
		ShortAndStringTest testee = new ShortAndStringTest();
		
		char c1 = 0x20;
		char c2 = 0x30;
		char c3 = 0x70;
		char c4 = 0x08;
		char c5 = 0x04;
		
		int c6 = c1 + c4;	// char + char 연산은   Java의 기본 promotion에 따라 int type으로 변경됨.
		int c7 = c2 + c5;
		
		int c11 = 32;
		
		System.out.println("c1 = '" + c1 + "'");
		System.out.println("c2 = '" + c2 + "'");
		System.out.println("c3 = '" + c3 + "'");
		System.out.println("c4 = '" + c4 + "'");
		System.out.println(c4);
		System.out.println("c5 = '" + c5 + "'");
		System.out.println("c6 = '" + (char)c6 + "'");  //위의 예에서는 char + char 연산 결과를 char 로 다시 downcast하여도 문제가 없음.
		System.out.println("c7 = '" + (char)c7 + "'");
		System.out.println("c11 = '" + (char)c11 + "'");
		
		
	}
	

}
