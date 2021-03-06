/**
 * 
 */
package thirdstage.exercise.lang.clone.case1;

/**
 * @author 3rdstage
 *
 */
public class Point3 implements Cloneable{

	private int x;
	
	private int y;
	
	private String color;
	
		
	public Point3(int x, int y, String color){
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public int getX(){ return this.x; }
	public void setX(int x){ this.x = x; }
	
	public int getY(){ return this.y; }
	public void setY(int y){ this.y = y; }
	
	public String getColor(){ return this.color; }
	public void setColor(String color){ this.color = color; }

	@Override
	public Point3 clone() throws CloneNotSupportedException{
		return (Point3)super.clone();
	}
	
}
