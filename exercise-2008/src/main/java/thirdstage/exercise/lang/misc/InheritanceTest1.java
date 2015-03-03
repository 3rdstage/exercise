/**
 * 
 */
package thirdstage.exercise.lang.misc;

/**
 * @author 3rdstage
 *
 */
public class InheritanceTest1 {

	public static void main(String [] args){
		NextNumber num = new NextNumber(3);
		
		System.out.println("Next number of 3 is : " + num.getNo());
	}
	
	

}

class Number{
	
	private int no;
	
	public Number(int no){
		setNo(no);
	}
	
	public int getNo(){ return this.no; }
	
	public void setNo(int no){ this.no = no; }
}

class NextNumber extends Number{
	
	public NextNumber(int no){
		super(no);
	}
	
	public void setNo(int no){ super.setNo(no + 1); } 
	
	
	
}

