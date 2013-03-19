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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SetupInputWindow{
	
	//@todo Border, edge or eching of control or layout
	//@todo Wrapping the text on label
	//@todo Blank control
	//@todo FornLayout
	//@todo Event listener
	//@todo data binding ?

	
	private ResourceBundle bundle;
	private PropertiesConfiguration meta;
	
	private Label projectCodeLabel;
	private Text projectCodeCtrl;
	private Label projectCodeDesc;

	private Label installsJdkLabel;
	private Button installsJdkCtrl;
	
	private Label jdkTypeLabel;
	private Combo jdkTypeCtrl;
	
	private Label installsEclipseLabel;
	private Button installsEclipseCtrl;
	
	private Label eclipseTypeLabel;
	private Combo eclipseTypeCtrl;
	
	private Label j2eeVersionLabel;
	private Combo j2eeVersionCtrl;
	
	private Label applServerProductLabel;
	private Combo applServerProductCtrl;
	
	private Label uiProductLabel;
	private Combo uiProductCtrl;
	
	private Label scmProductLabel;
	private Combo scmProductCtrl;
	
	private Label includesDeferredModuleLabel;
	private Button includesDeferredModuleCtrl;
	
	private Label includesCryptoLibLabel;
	private Button includesCryptoLibCtrl;
	
	private Label includesXmlParserLabel;
	private Button includesXmlParserCtrl;

	public SetupInputWindow(Shell shell){
		
		bundle = ResourceBundle.getBundle("thirdstage.exercise.eclipse.jface.case5.Display");
		try{
			meta = new PropertiesConfiguration(ClassLoader.getSystemResource("thirdstage/exercise/eclipse/jface/case5/Meta.properties"));
		}
		catch(Exception ex){
			throw new IllegalStateException("Something is wrong. Examine root cause", ex);
		}
		
		shell.setSize(meta.getInt("window.width"), meta.getInt("window.height"));
		
		//My choices from default fonts of Microsoft Windows XP are
		//Arial Black/normal, Lucida Grande/normal, Helvetica/bold, Tahoma/bold, Verdana/bold, Geneva/bold
		Font ft2 = new Font(shell.getDisplay(), new FontData("Verdana", 10, SWT.NORMAL));
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
			.align(SWT.LEFT, SWT.CENTER).grab(false, false).hint(shell.getSize().x - w1, SWT.DEFAULT);
		
		GridDataFactory gdf3 = GridDataFactory.fillDefaults()
				.align(SWT.CENTER, SWT.CENTER).grab(true, false)
				.hint(shell.getSize().x, SWT.DEFAULT)
				.span(2, 1);
		

		//project code field - text input
		projectCodeLabel = new Label(shell, SWT.SHADOW_ETCHED_IN);
		projectCodeLabel.setText(bundle.getString("field.projectCode.label"));
		projectCodeLabel.setFont(ft2);
		projectCodeLabel.setLayoutData(gdf1.create());
		projectCodeLabel.pack();
		
		projectCodeCtrl = new Text(shell, SWT.BORDER);
		projectCodeCtrl.setTextLimit(meta.getInt("field.projectCode.maxLength"));
		projectCodeCtrl.setFont(ft2);
		projectCodeCtrl.setLayoutData(gdf2.create());
		projectCodeCtrl.pack();
		
		new Label(shell, SWT.FLAT).pack(); //simple filler
		
		projectCodeDesc = new Label(shell, SWT.SHADOW_ETCHED_OUT | SWT.WRAP);
		projectCodeDesc.setText(bundle.getString("field.projectCode.desc"));
		projectCodeDesc.setFont(ft2);
		projectCodeDesc.setLayoutData(gdf2.create());
		projectCodeDesc.pack();
		//end of project code field

		Label hr1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		hr1.setLayoutData(gdf3.create());
		hr1.pack();
		
		//install JDK or not field - checkbox
		installsJdkLabel = new Label(shell, SWT.SHADOW_ETCHED_IN);
		installsJdkLabel.setText(bundle.getString("field.installsJdk.label"));
		installsJdkLabel.setFont(ft2);
		installsJdkLabel.setLayoutData(gdf1.create());
		installsJdkLabel.pack();
		
		installsJdkCtrl = new Button(shell, SWT.CHECK);
		installsJdkCtrl.setFont(ft2);
		installsJdkCtrl.setSelection(meta.getBoolean("field.installsJdk.default"));
		installsJdkCtrl.setLayoutData(gdf2.create());
		installsJdkCtrl.pack();

		SelectionListener installsJdkCtrlListener = new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent ev){
				jdkTypeCtrl.setEnabled(((Button)ev.getSource()).getSelection());
			
			}
		};
		installsJdkCtrl.addSelectionListener(installsJdkCtrlListener);
		//end of install JDK or not field
		
		//JDK type field - single combo
		jdkTypeLabel = new Label(shell, SWT.SHADOW_IN);
		jdkTypeLabel.setText(bundle.getString("field.jdkType.label"));
		jdkTypeLabel.setFont(ft2);
		jdkTypeLabel.setLayoutData(gdf1.create());
		jdkTypeLabel.pack();

		jdkTypeCtrl = new Combo(shell, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER);
		jdkTypeCtrl.setItems(meta.getStringArray("field.jdkType.enumeration"));
		jdkTypeCtrl.select(0);
		jdkTypeCtrl.setVisibleItemCount(Math.min(jdkTypeCtrl.getItemCount(), 7));
		jdkTypeCtrl.setFont(ft2);
		jdkTypeCtrl.setLayoutData(gdf2.create());
		jdkTypeCtrl.pack();
		//end of JDK type
		
		//install Eclipse or not field - check box
		installsEclipseLabel = new Label(shell, SWT.SHADOW_ETCHED_OUT);
		installsEclipseLabel.setText(bundle.getString("field.installsEclispe.label"));
		installsEclipseLabel.setFont(ft2);
		installsEclipseLabel.setLayoutData(gdf1.create());
		installsEclipseLabel.pack();
		
		installsEclipseCtrl = new Button(shell, SWT.CHECK);
		installsEclipseCtrl.setFont(ft2);
		installsEclipseCtrl.setSelection(meta.getBoolean("field.installsEclispe.default"));
		installsEclipseCtrl.setLayoutData(gdf2.create());
		installsEclipseCtrl.pack();
		//end of install Eclipse or not field

		//Eclipse type field - combo
		eclipseTypeLabel = new Label(shell, SWT.SHADOW_OUT);
		eclipseTypeLabel.setText(bundle.getString("field.eclipseType.label"));
		eclipseTypeLabel.setFont(ft2);
		eclipseTypeLabel.setLayoutData(gdf1.create());
		eclipseTypeLabel.pack();
		
		eclipseTypeCtrl = new Combo(shell, SWT.READ_ONLY | SWT.BORDER);
		eclipseTypeCtrl.setItems(meta.getStringArray("field.eclipseType.enumeration"));
		eclipseTypeCtrl.select(0);
		eclipseTypeCtrl.setVisibleItemCount(Math.min(eclipseTypeCtrl.getItemCount(), 7));
		eclipseTypeCtrl.setFont(ft2);
		eclipseTypeCtrl.setLayoutData(gdf2.create());
		eclipseTypeCtrl.pack();
		//end of Eclipse type field
		
		//J2EE version field - combo
		j2eeVersionLabel = new Label(shell, SWT.SHADOW_OUT);
		j2eeVersionLabel.setText(bundle.getString("field.j2eeVersion.label"));
		j2eeVersionLabel.setFont(ft2);
		j2eeVersionLabel.setLayoutData(gdf1.create());
		j2eeVersionLabel.pack();
		
		j2eeVersionCtrl = new Combo(shell, SWT.READ_ONLY | SWT.BORDER);
		j2eeVersionCtrl.setItems(meta.getStringArray("field.j2eeVersion.enumeration"));
		j2eeVersionCtrl.select(0);
		j2eeVersionCtrl.setVisibleItemCount(Math.min(j2eeVersionCtrl.getItemCount(), 7));
		j2eeVersionCtrl.setFont(ft2);
		j2eeVersionCtrl.setLayoutData(gdf2.create());
		j2eeVersionCtrl.pack();
		//end of J2EE version field
		
		//Appl. server product field - combo
		applServerProductLabel = new Label(shell, SWT.SHADOW_OUT);
		applServerProductLabel.setText(bundle.getString("field.applServerProduct.label"));
		applServerProductLabel.setFont(ft2);
		applServerProductLabel.setLayoutData(gdf1.create());
		applServerProductLabel.pack();
		
		applServerProductCtrl = new Combo(shell, SWT.READ_ONLY | SWT.BORDER);
		applServerProductCtrl.setItems(meta.getStringArray("field.applServerProduct.enumeration"));
		applServerProductCtrl.select(0);
		applServerProductCtrl.setVisibleItemCount(Math.min(applServerProductCtrl.getItemCount(), 7));
		applServerProductCtrl.setFont(ft2);
		applServerProductCtrl.setLayoutData(gdf2.create());
		applServerProductCtrl.pack();		
		//end of Appl. server product field
		
		//UI product field - combo
		uiProductLabel = new Label(shell, SWT.SHADOW_OUT);
		uiProductLabel.setText(bundle.getString("field.uiProduct.label"));
		uiProductLabel.setFont(ft2);
		uiProductLabel.setLayoutData(gdf1.create());
		uiProductLabel.pack();
		
		uiProductCtrl = new Combo(shell, SWT.READ_ONLY | SWT.BORDER);
		uiProductCtrl.setItems(meta.getStringArray("field.uiProduct.enumeration"));
		uiProductCtrl.select(0);
		uiProductCtrl.setVisibleItemCount(Math.min(uiProductCtrl.getItemCount(), 7));
		uiProductCtrl.setFont(ft2);
		uiProductCtrl.setLayoutData(gdf2.create());
		uiProductCtrl.pack();
		//end of UI product field
		
		//SCM product field - combo
		scmProductLabel = new Label(shell, SWT.SHADOW_OUT);
		scmProductLabel.setText(bundle.getString("field.scmProduct.label"));
		scmProductLabel.setFont(ft2);
		scmProductLabel.setLayoutData(gdf1.create());
		scmProductLabel.pack();
		
		scmProductCtrl = new Combo(shell, SWT.READ_ONLY | SWT.BORDER);
		scmProductCtrl.setItems(meta.getStringArray("field.scmProduct.enumeration"));
		scmProductCtrl.select(0);
		scmProductCtrl.setVisibleItemCount(Math.min(scmProductCtrl.getItemCount(), 7));
		scmProductCtrl.setFont(ft2);
		scmProductCtrl.setLayoutData(gdf2.create());
		scmProductCtrl.pack();		
		//end of SCM product
		
		//include deferred module or not - checkbox
		includesDeferredModuleLabel = new Label(shell, SWT.SHADOW_ETCHED_IN);
		includesDeferredModuleLabel.setText(bundle.getString("field.includesDeferredModule.label"));
		includesDeferredModuleLabel.setFont(ft2);
		includesDeferredModuleLabel.setLayoutData(gdf1.create());
		includesDeferredModuleLabel.pack();
		
		includesDeferredModuleCtrl = new Button(shell, SWT.CHECK);
		includesDeferredModuleCtrl.setFont(ft2);
		includesDeferredModuleCtrl.setSelection(meta.getBoolean("field.includesDeferredModule.default"));
		includesDeferredModuleCtrl.setLayoutData(gdf2.create());
		includesDeferredModuleCtrl.pack();
		//end of include deferred module or not
		
		//include crypto library or not - checkbox
		includesCryptoLibLabel = new Label(shell, SWT.SHADOW_ETCHED_IN);
		includesCryptoLibLabel.setText(bundle.getString("field.includesCryptoLib.label"));
		includesCryptoLibLabel.setFont(ft2);
		includesCryptoLibLabel.setLayoutData(gdf1.create());
		includesCryptoLibLabel.pack();
		
		includesCryptoLibCtrl = new Button(shell, SWT.CHECK);
		includesCryptoLibCtrl.setFont(ft2);
		includesCryptoLibCtrl.setSelection(meta.getBoolean("field.includesCryptoLib.default"));
		includesCryptoLibCtrl.setLayoutData(gdf2.create());
		includesCryptoLibCtrl.pack();
		//end of include crypto library or not
		
		
		//include XML parsers or not - checkbox
		includesXmlParserLabel = new Label(shell, SWT.SHADOW_ETCHED_IN);
		includesXmlParserLabel.setText(bundle.getString("field.includesXmlParser.label"));
		includesXmlParserLabel.setFont(ft2);
		includesXmlParserLabel.setLayoutData(gdf1.create());
		includesXmlParserLabel.pack();
		
		includesXmlParserCtrl = new Button(shell, SWT.CHECK);
		includesXmlParserCtrl.setFont(ft2);
		includesXmlParserCtrl.setSelection(meta.getBoolean("field.includesXmlParser.default"));
		includesXmlParserCtrl.setLayoutData(gdf2.create());
		includesXmlParserCtrl.pack();
		//end of include XML parsers or not		

		
		Label hrz = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.SHADOW_ETCHED_OUT);
		hrz.setLayoutData(gdf3.create());
		hrz.pack();
		
		//available fonts
		Label avlFontLabel = new Label(shell, SWT.SHADOW_ETCHED_OUT);
		avlFontLabel.setText("Available Fonts");
		avlFontLabel.setFont(ft2);
		avlFontLabel.setLayoutData(gdf1.create());
		avlFontLabel.pack();
		
		FontData[] fts = shell.getDisplay().getFontList(null, true);
		String[] ftNames = new String[fts.length];
		for(int i = 0, n = fts.length; i < n; i++){
			ftNames[i] = fts[i].getName();
		}
		
		Combo avlFontCombo = new Combo(shell, SWT.READ_ONLY | SWT.BORDER);
		avlFontCombo.setItems(ftNames);
		avlFontCombo.setLayoutData(gdf2.create());
		avlFontCombo.setFont(ft2);
		avlFontCombo.pack();
		//end of available fonts
		
		shell.pack();
	}
	
	public static void main(String... args){
		
		Display display = new Display();
		Shell shell = new Shell(display);
		
		new SetupInputWindow(shell);

		shell.open();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();		
	}
	

}

 
