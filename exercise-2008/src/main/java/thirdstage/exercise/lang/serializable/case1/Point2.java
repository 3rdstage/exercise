/**
 * 
 */
package thirdstage.exercise.lang.serializable.case1;

/**
 * A superclass that DOSEN'T have default constructor.
 * 
 * @author 3rdstage
 *
 */
public class Point2{

	private int x;
	
	private int y;
	
	public Point2(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){ return this.x; }
	public void setX(int x){ this.x = x; }
	
	public int getY(){ return this.y; }
	public void setY(int y){ this.y = y; }
	
}
