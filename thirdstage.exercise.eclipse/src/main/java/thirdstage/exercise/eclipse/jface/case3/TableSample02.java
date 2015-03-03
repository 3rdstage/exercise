package thirdstage.exercise.eclipse.jface.case3;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class TableSample02 {


	public void load(int cols, int rows){

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		Table table = new Table(shell, SWT.BORDER | SWT.MULTI);
		table.setLinesVisible(true);

		for(int i = 0; i < cols; i++){
			TableColumn col = new TableColumn(table, SWT.NONE);
			col.setWidth(100);
		}

		for(int i = 0; i < rows; i++){
			new TableItem(table, SWT.NONE);
		}

		TableItem[] items = table.getItems();
		TableEditor editor = null;
		CCombo combo = null;
		Text text = null;
		Button btn = null;
		for(int i = 0; i < rows; i ++){

			for(int j = 0; j < cols; j++){

				editor = new TableEditor(table);
				text = new Text(table, SWT.NONE);
				text.setText("Text");
				editor.grabHorizontal = true;
				editor.setEditor(text, items[i], j);
			}

		}
		shell.pack();
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()) display.sleep();
		}
		display.dispose();		
	}

	public static void main(String... args){
		TableSample02 sample = new TableSample02();
		sample.load(4, 15);
	}
}
