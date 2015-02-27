package thirdstage.exercise.eclipse.jface.case3;

import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import thirdstage.exercise.eclipse.jface.case2.StatusActionTestWindow;

public class TestWindow extends ApplicationWindow {
	
	private StatusLineManager statusLineMgr = new StatusLineManager();
	
	public TestWindow(){
		super(null);
		this.addStatusLine();
	}

	public static void main(String[] args){
		TestWindow win = new TestWindow();
		win.setBlockOnOpen(true);
		win.open();
		Display.getCurrent().dispose();
	}	
	
	@Override
	protected Control createContents(Composite parent){
		
		parent.setSize(800, 600);
		TabFolder tf = new TabFolder(parent, SWT.NONE);
		
		TabItem ti1 = new TabItem(tf, SWT.NONE);
		ti1.setText("Text sample : SafeText");
		ti1.setControl(new SafeText(tf, this.getStatusLineManager()));

		TabItem ti2 = new TabItem(tf, SWT.NONE);
		ti2.setText("Combo sample : Built-in Combos");
		ti2.setControl(new ComboSample(tf));
		
		return parent;
	}
	

	@Override
	protected StatusLineManager createStatusLineManager(){
		return this.statusLineMgr;
	}
	
	
	
}
