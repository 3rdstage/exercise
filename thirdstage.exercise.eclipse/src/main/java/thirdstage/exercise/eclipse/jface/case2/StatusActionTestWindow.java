package thirdstage.exercise.eclipse.jface.case2;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class StatusActionTestWindow extends ApplicationWindow {
	
	
	private StatusLineManager statusLineMgr = new StatusLineManager();
	private StatusAction statusAction = new StatusAction(this.statusLineMgr);
	private ActionContributionItem contribItem = new ActionContributionItem(this.statusAction);
	
	public StatusActionTestWindow(){
		super(null);
		this.addStatusLine();
		this.addMenuBar();
		this.addToolBar(SWT.FLAT | SWT.WRAP);
	}
	
	@Override
	protected Control createContents(Composite parent){
		this.getShell().setText("Action/Contribution Example");
		parent.setSize(290, 150);
		this.contribItem.fill(parent);
		return parent;
	}

	public static void main(String[] args){
		StatusActionTestWindow win = new StatusActionTestWindow();
		win.setBlockOnOpen(true);
		win.open();
		Display.getCurrent().dispose();
		
	}
	
	@Override
	protected MenuManager createMenuManager(){
		MenuManager mainMenu = new MenuManager();
		MenuManager actionMenu = new MenuManager("Menu");
		mainMenu.add(actionMenu);
		actionMenu.add(this.statusAction);
		return mainMenu;
	}
	
	@Override
	protected ToolBarManager createToolBarManager(int style){
		ToolBarManager tbm = new ToolBarManager(style);
		tbm.add(this.statusAction);
		return tbm;
	}
	
	@Override
	protected StatusLineManager createStatusLineManager(){
		return this.statusLineMgr;
	}
}
