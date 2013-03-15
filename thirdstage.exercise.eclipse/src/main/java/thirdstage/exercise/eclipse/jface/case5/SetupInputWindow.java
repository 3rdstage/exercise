package thirdstage.exercise.eclipse.jface.case5;

import java.util.ResourceBundle;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SetupInputWindow{
	
	public static void main(String[] args){

		ResourceBundle rb = ResourceBundle.getBundle("thirdstage.exercise.eclipse.jface.case5.Display");
		PropertiesConfiguration meta = null;
		try{
			meta = new PropertiesConfiguration(ClassLoader.getSystemResource("thirdstage/exercise/eclipse/jface/case5/Meta.properties"));
		}
		catch(Exception ex){
			throw new IllegalStateException("Something is wrong. Examine root cause", ex);
		}
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(meta.getInt("window.width"), meta.getInt("window.height"));
		Font ft = shell.getFont();
		FontData[] fds = ft.getFontData();
		for(FontData fd : fds){
			fd.setHeight(meta.getInt("window.font.height"));
		}
		
		//My choices from default fonts of Microsoft Windows XP are
		//Arial Black/normal, Lucida Grande/normal, Helvetica/bold, Tahoma/bold, Verdana/bold, Geneva/bold
		Font ft2 = new Font(display, new FontData("Verdana", 10, SWT.BOLD));
		shell.setFont(ft2);
		
		GridLayout gl = new GridLayout(2, false);
		gl.marginTop = meta.getInt("window.marginTop");
		gl.marginRight = meta.getInt("window.marginRight");
		gl.marginBottom = meta.getInt("window.marginBottom");
		gl.marginLeft = meta.getInt("window.marginLeft");
		shell.setLayout(gl);

		int w1 = Math.round(meta.getInt("window.width") * meta.getFloat("window.grid.first.width.ratio"));
		GridDataFactory gdf1 = GridDataFactory.fillDefaults()
			.align(SWT.LEFT, SWT.CENTER).grab(false, false).hint(w1, SWT.DEFAULT);
		
		GridDataFactory gdf2 = GridDataFactory.fillDefaults()
			.align(SWT.LEFT, SWT.CENTER).grab(false, false).hint(SWT.DEFAULT, SWT.DEFAULT);
		
		GridDataFactory gdf3 = GridDataFactory.fillDefaults()
				.align(SWT.LEFT, SWT.CENTER).grab(true, false).hint(SWT.DEFAULT, SWT.DEFAULT).span(2, 1);

		
		Label prjCodeLabel = new Label(shell, SWT.SHADOW_ETCHED_IN);
		prjCodeLabel.setText(rb.getString("field.prjCode.label"));
		prjCodeLabel.setFont(ft2);
		prjCodeLabel.setLayoutData(gdf1.create());
		prjCodeLabel.pack();
		
		Text prjCodeTxt = new Text(shell, SWT.BORDER);
		prjCodeTxt.setTextLimit(meta.getInt("field.prjCode.maxLength"));
		prjCodeTxt.setFont(ft2);
		prjCodeTxt.setLayoutData(gdf2.create());
		prjCodeTxt.pack();
	
		Label sprt1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		sprt1.setLayoutData(gdf3.create());
		sprt1.pack();
		
		Label installsJdkLabel = new Label(shell, SWT.SHADOW_ETCHED_IN);
		installsJdkLabel.setText(rb.getString("field.installsJdk.label"));
		installsJdkLabel.setFont(ft2);
		installsJdkLabel.setLayoutData(gdf1.create());
		installsJdkLabel.pack();
		
//		Group installsJdkRadios = new Group(shell, SWT.NULL);
//		installsJdkRadios.setLayout(new RowLayout());
//		
//		Button installsJdkYes = new Button(installsJdkRadios, SWT.RADIO);
//		installsJdkYes.setText(rb.getString("label.yes"));
//		installsJdkYes.setFont(ft2);
//		installsJdkYes.pack();
//		
//		Button installsJdkNo = new Button(installsJdkRadios, SWT.RADIO);
//		installsJdkNo.setText(rb.getString("label.no"));
//		installsJdkNo.setFont(ft2);
//		installsJdkNo.pack();
//		
//		installsJdkRadios.setLayoutData(gdf2.create());
//		installsJdkRadios.pack();
		
		Button installsJdkCheck = new Button(shell, SWT.CHECK);
		installsJdkCheck.setFont(ft2);
		installsJdkCheck.setLayoutData(gdf2.create());
		installsJdkCheck.pack();
		
		Label jdkTypeLabel = new Label(shell, SWT.SHADOW_IN);
		jdkTypeLabel.setText(rb.getString("field.jdkType.label"));
		jdkTypeLabel.setFont(ft2);
		jdkTypeLabel.setLayoutData(gdf1.create());
		jdkTypeLabel.pack();

		Combo jdkTypeCombo = new Combo(shell, SWT.READ_ONLY | SWT.BORDER);
		jdkTypeCombo.setItems(meta.getStringArray("field.jdkType.enumeration"));
		jdkTypeCombo.setFont(ft2);
		jdkTypeCombo.setLayoutData(gdf2.create());
		jdkTypeCombo.pack();
		

		
		Label avlFontLabel = new Label(shell, SWT.SHADOW_ETCHED_OUT);
		avlFontLabel.setText("Available Fonts");
		avlFontLabel.setFont(ft2);
		avlFontLabel.setLayoutData(gdf1.create());
		avlFontLabel.pack();
		
		FontData[] fts = display.getFontList(null, true);
		String[] ftNames = new String[fts.length];
		for(int i = 0, n = fts.length; i < n; i++){
			ftNames[i] = fts[i].getName();
		}
		
		Combo avlFontCombo = new Combo(shell, SWT.READ_ONLY | SWT.BORDER);
		avlFontCombo.setItems(ftNames);
		avlFontCombo.setLayoutData(gdf2.create());
		avlFontCombo.setFont(ft2);
		avlFontCombo.pack();
		
		
		
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();		
		
		
	}
	

}