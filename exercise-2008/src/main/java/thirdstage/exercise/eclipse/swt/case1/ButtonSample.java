/**
 * 
 */
package thirdstage.exercise.eclipse.swt.case1;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * @author 3rdstage
 *
 */
public class ButtonSample {

	public static void main(String[] args){
		
		Display display = new Display();
		Shell shell = new Shell(display);
		
		shell.setText("Hello World");
		shell.setBounds(100, 100, 800, 100);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button button1 = new Button(shell, SWT.ARROW);
		button1.setText("Arrow");
		Button button2 = new Button(shell, SWT.CHECK);
		button2.setText("Check");
		Button button3 = new Button(shell, SWT.PUSH);
		button3.setText("Push");
		Button button4 = new Button(shell, SWT.RADIO);
		button4.setText("Radio");
		Button button5 = new Button(shell, SWT.TOGGLE);
		button5.setText("Toggle");
		Button button6 = new Button(shell, SWT.UP);
		button6.setText("Up");
		Button button7 = new Button(shell, SWT.DOWN);
		button7.setText("Down");
		Button button8 = new Button(shell, SWT.LEFT);
		button8.setText("Left");
		Button button9 = new Button(shell, SWT.RIGHT);
		button9.setText("Right");

		shell.open();
		while(!shell.isDisposed()){
			
			if(!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}

	
}
