/**
 * 
 */
package thirdstage.exercise.lang.clone.case1;

/**
 * @author 3rdstage
 *
 */
public class Point2 implements Cloneable{
	
	private int x;
	
	private int y;
	
	private String color;
	
	public Point2(int x, int y, String color){
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

}
