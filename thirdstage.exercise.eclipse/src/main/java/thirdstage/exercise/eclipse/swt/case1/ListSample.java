/**
 * 
 */
package thirdstage.exercise.eclipse.swt.case1;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/**
 * @author 3rdstage
 *
 */
public class ListSample {
	
	public static void main(String[] args){
		
		
		Display display = new Display();
		Shell shell = new Shell(display);
		
		shell.setText("List Sample");
		shell.setBounds(100, 100, 200, 200);
		shell.setLayout(new FillLayout());
		
		final List list = new List(shell, SWT.SINGLE);
		list.setItems(new String[]{"Strawberry", "Water Melon", "Grape"});
		
		list.addSelectionListener(
				new SelectionAdapter(){
					public void widgetSelected(SelectionEvent ev){
						String[] selected = ((List)ev.getSource()).getSelection();
						if(selected.length > 0){
							System.out.println("Selected : " + selected[0]); 
						}
					}
				}
			);
		
		shell.open();
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()) display.sleep();
		}
		
		display.dispose();
		
	}

}
