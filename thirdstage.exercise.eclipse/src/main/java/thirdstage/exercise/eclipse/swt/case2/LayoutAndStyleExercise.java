package thirdstage.exercise.eclipse.swt.case2;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LayoutAndStyleExercise {

	public static void main(String[] args){

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(600, 800);
		
		GridLayout gl = new GridLayout(2, false);
		shell.setLayout(gl);
		
		GridDataFactory gdf1 = GridDataFactory.fillDefaults()
				.align(SWT.LEFT, SWT.CENTER).grab(false, false).hint(200, SWT.DEFAULT);
		
		GridDataFactory gdf2 = GridDataFactory.fillDefaults()
				.align(SWT.LEFT, SWT.CENTER).grab(false, false).hint(400, SWT.DEFAULT);
		
		Label installsJdkLabel = new Label(shell, SWT.SHADOW_OUT | SWT.LEFT);
		installsJdkLabel.setText("Installs JDK");
		installsJdkLabel.setLayoutData(gdf1.create());
		installsJdkLabel.pack();
		
		Text installsJdkTxt = new Text(shell, SWT.SINGLE | SWT.BORDER | SWT.LEFT);
		installsJdkTxt.setLayoutData(gdf2.create());
		installsJdkTxt.setTextLimit(12);
		installsJdkTxt.pack();

		
		shell.pack();
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()) display.sleep();
		}

		display.dispose();

	}

}
