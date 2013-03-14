package thirdstage.exercise.eclipse.jface.case1;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;

public class SimpleWindow01 extends ApplicationWindow {
	
	public SimpleWindow01(){
		super(null);
	}
	
	@Override
	protected Control createContents(Composite parent){
		
		Group grp = new Group(parent, SWT.SHADOW_ETCHED_IN);
		grp.setText("Group");
		
		Button bt1 = new Button(grp, SWT.ARROW | SWT.RIGHT | SWT.FLAT);
		bt1.setBounds(20, 20, 40, 40);
		bt1.pack();
		Button bt2 = new Button(grp, SWT.ARROW | SWT.DOWN);
		bt2.setBounds(20, 60, 40, 40);
		bt2.pack();
		
		grp.pack();
		parent.pack();
		return parent;
		
	}
	
	public static void main(String[] args){
		SimpleWindow01 win = new SimpleWindow01();
		win.setBlockOnOpen(true);
		win.open();
		Display.getCurrent().dispose();
	}
	
}
