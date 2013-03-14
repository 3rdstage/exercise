package thirdstage.exercise.eclipse.jface.case1;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class HelloJface extends ApplicationWindow{
	
	
	public HelloJface(){
		super(null);
	}
	
	protected Control createContents(Composite parent){
		Text text1 = new Text(parent, SWT.CENTER);
		text1.setText("Hello World!");
		
		parent.pack();
		return parent;
	}
	
	public static void main(String[] args){
		HelloJface win = new HelloJface();
		win.setBlockOnOpen(true);
		win.open();
		Display.getCurrent().dispose();
	}
	

}
