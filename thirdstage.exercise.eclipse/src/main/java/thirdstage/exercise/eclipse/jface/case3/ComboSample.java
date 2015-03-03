package thirdstage.exercise.eclipse.jface.case3;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class ComboSample extends Composite {
	
	public ComboSample(Composite parent){
		super(parent, SWT.NONE);
		
		this.setLayout(new RowLayout());
		int[] styles = {SWT.SIMPLE, SWT.DROP_DOWN, SWT.READ_ONLY};
		
		Combo combo = null;
		for(int style: styles){
			combo = new Combo(this, style);
			combo.add("Option #1");
			combo.add("Option #2");
			combo.add("Option #3");
		}
		
	}
	

}
