package thirdstage.exercise.eclipse.jface.case3;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class TabelSample01 {
	
	public static void main(String... args){
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		
		Table table = new Table(shell, SWT.BORDER | SWT.MULTI);
		table.setLinesVisible(true);
		
		for(int i = 0; i < 3; i++){
			TableColumn col = new TableColumn(table, SWT.NONE);
			col.setWidth(100);
		}
		
		for(int i = 0; i < 12; i++){
			new TableItem(table, SWT.NONE);
		}
		
		TableItem[] items = table.getItems();
		TableEditor editor = null;
		CCombo combo = null;
		Text text = null;
		Button btn = null;
		for(int i = 0, n = items.length; i < n; i ++){
			editor = new TableEditor(table);
			combo = new CCombo(table, SWT.NONE);
			combo.setText("CCombo");
			combo.add("Item1");
			combo.add("Item2");
			editor.grabHorizontal = true;
			editor.setEditor(combo, items[i], 0);
			
			editor = new TableEditor(table);
			text = new Text(table, SWT.NONE);
			text.setText("Text");
			editor.grabHorizontal = true;
			editor.setEditor(text, items[i], 1);
			
			editor = new TableEditor(table);
			btn = new Button(table, SWT.CHECK);
			btn.pack();
			editor.minimumWidth = btn.getSize().x;
			editor.horizontalAlignment = SWT.LEFT;
			editor.setEditor(btn, items[i], 2);
			
		}
		shell.pack();
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}

}
