package thirdstage.meta.jls3;

import java.net.URL;
import org.eclipse.swt.graphics.Color;

public class Simple {
	
	private String name = "";
	
	private int height = 0;
	
	private int width = 0;
	
	private Color color;
	
	private URL link;
	
	
	public Simple(String name){
		this.name = name;
	}
	
	public Simple(String name, int h, int w){
		this(name);
		this.height = h;
		this.width = w;
	}
	
	public String getName(){ return this.name; }
	
	public int getHeight(){	return this.height;	}
	
	public void setHeight(int h){ this.height = h; }
	
	public int getWidth(){ return this.width; }
	
	public void setWidth(int w){ this.width = w; }
	
	

}
