/**
 * 
 */
package thirdstage.exercise.lang.serializable.case1;

/**
 * A serializable class that extends non-serializable super which
 * DOESN'T have explicit default constructor.
 * 
 * @author 3rdstage
 *
 */
public class Mark2 extends Point2 implements java.io.Serializable{
	
	private String name;
	
	private boolean visible = true;
	
	public Mark2(){
		super(0,0);
	}
	
	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name; }
	
	public boolean isVisible(){ return this.visible; }
	public void setVisible(boolean visible){ this.visible = visible; }	

}
