package thirdstage.exercise.eclipse.jface.case3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class SafeText extends Composite implements VerifyListener{

	public final static String ALLOWED_PATTERN = new String("([0-9a-zA-Z,.?!@%()_:;'\",/+-]|\\x5B|\\x5D|\\x20|\\n|\\r|\\f)*");
	private final static Pattern pattern = Pattern.compile(ALLOWED_PATTERN);
	
	private StatusLineManager statusLineMgr;
	
	public SafeText(Composite parent, StatusLineManager mgr){
		super(parent, SWT.NONE);
		this.statusLineMgr = mgr;
		
		this.setLayout(new FillLayout());
		Text text = new Text(this, SWT.MULTI | SWT.V_SCROLL);
		text.addVerifyListener(this);
	}		
	
	public void verifyText(VerifyEvent ev){
		Matcher mt = SafeText.pattern.matcher(ev.text);
		
		if(!mt.matches()){
			ev.doit = false;
			
			if(this.statusLineMgr != null){
				this.statusLineMgr.setMessage("You can write only the following characters : alphabet, number, space, ,(comma), .(period), !, ?, (, ), [, ], +, -, _, :, ;, ', \", /, @, %");
			}
		}
		else{
			if(this.statusLineMgr != null){
				this.statusLineMgr.setMessage("");
			}
		}
	}

}
