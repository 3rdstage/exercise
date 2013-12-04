/**
 * 
 */
package thirdstage.exercise.lang.misc;

import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.Min;

/**
 * @author 3rdstage
 *
 */
public class OverrideTest{
	
	
	

}


interface Component{

	String getName();

	Component getParent();
}

class Panel implements Component{
	
	private String name;
	private Component parent;
	
	public Panel(Component parent){
		this.parent = parent;
	}
	
	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name; }
	
	public Component getParent(){ return this.parent; }
	public void setParent(Component parent){ this.parent = parent; }
}

class TitleBar implements Component{
	private String name;
	private Panel parent;
	
	public TitleBar(Panel parent){
		this.parent = parent;
	}
	
	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name; }
	
	@Override
	public Panel getParent(){ return this.parent; }
	public void setParent(Panel parent){ this.parent = parent; }
}
