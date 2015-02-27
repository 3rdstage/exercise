package thirdstage.exercise.eclipse.jface.case4;

import java.util.Date;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class BindingSample01 {
	
	
	public static void main(String... args){
		
		Display display = new Display();
		Shell shell = new Shell(display);
		
		GridLayout gl = new GridLayout(2, false);
		shell.setLayout(gl);
		
		GridDataFactory gdf1 = GridDataFactory.fillDefaults()
			.align(SWT.LEFT, SWT.CENTER).grab(false, false).hint(200, SWT.DEFAULT);
			
		GridDataFactory gdf2 = GridDataFactory.fillDefaults()
			.align(SWT.LEFT, SWT.CENTER).grab(false, false).hint(400, SWT.DEFAULT);
		
		Label lbl1 = new Label(shell, SWT.SHADOW_ETCHED_IN);
		lbl1.setText("Name");
		lbl1.setLayoutData(gdf1.create());
		lbl1.pack();
		
		Text txt1 = new Text(shell, SWT.BORDER);
		txt1.setLayoutData(gdf2.create());
		txt1.pack();
		
		Person prs = new Person();
		
		IObservableValue nameObsv1 = SWTObservables.observeText(txt1, SWT.Modify);
		
		shell.pack();
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}
	

		

}
