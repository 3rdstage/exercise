package thirdstage.exercise.eclipse.jface.case2;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.resource.ImageDescriptor;

public class StatusAction extends Action {
	
	private StatusLineManager statusManager;
	private short triggerCount;
	
	public StatusAction(StatusLineManager mgr){
		super("&Trigger@Ctrl+T", AS_PUSH_BUTTON);
		this.statusManager = mgr;
		this.setToolTipText("Trigger the Action");
		this.setImageDescriptor(ImageDescriptor.createFromFile(this.getClass(), "eclipse.gif"));
	}
	
	@Override
	public void run(){
		this.triggerCount++;
		this.statusManager.setMessage("The status action has fired. Count : " + this.triggerCount);
	}

}
