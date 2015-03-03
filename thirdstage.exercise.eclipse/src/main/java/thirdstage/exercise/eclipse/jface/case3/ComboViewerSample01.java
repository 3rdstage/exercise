package thirdstage.exercise.eclipse.jface.case3;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ComboViewerSample01 {

	public static void main(String... args){
		
		Display display = new Display();
		Shell shell = new Shell(display);
		
		GridLayout lo = new GridLayout(2, false);
		shell.setLayout(lo);
		shell.setSize(600, 800);
		
		GridDataFactory gdf1 = GridDataFactory.fillDefaults()
				.align(SWT.LEFT, SWT.CENTER).grab(false, false).hint(SWT.DEFAULT, SWT.DEFAULT);
			
			GridDataFactory gdf2 = GridDataFactory.fillDefaults()
				.align(SWT.LEFT, SWT.CENTER).grab(false, false).hint(SWT.DEFAULT, SWT.DEFAULT);
			
		Label lbl01 = new Label(shell, SWT.NONE);
		lbl01.setLayoutData(GridDataFactory.fillDefaults().hint(200, 0).create());
		
		Label lbl02 = new Label(shell, SWT.NONE);
		lbl02.setLayoutData(GridDataFactory.fillDefaults().hint(400, 0).create());
			
			
		Label lblSelect = new Label(shell, SWT.NONE);
		lblSelect.setText("Select a person");
		lblSelect.setLayoutData(gdf1.create());
		
		final ComboViewer viewer = new ComboViewer(shell, SWT.READ_ONLY);
		viewer.getCombo().setLayoutData(gdf2.create());
		
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.setLabelProvider(new LabelProvider(){
			
			public String getText(Object obj){
				if(obj instanceof Person){
					Person p = (Person)obj;
					return p.getId() + ":" + p.getName();
				}
				return super.getText(obj);
			}
		});
		
		Person[] persons = new Person[]{
				new Person("0001", "홍길동", "Manager", "Software Architect"),
				new Person("0002", "Smith", "Associate", "Software Engineer"),
				new Person("0003", "Chris", "Associate", "Graphic Designer"),
				new Person("0010", "Sang", "Associate", "Software Engineer")
		};
		
		viewer.setInput(persons);
		
		
		Label lbl2 = new Label(shell, SWT.NONE);
		Label lbl3 = new Label(shell, SWT.NONE);
		
		Label lblId = new Label(shell, SWT.NONE);
		lblId.setText("ID");
		
		final Text txtId = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		txtId.setTextLimit(10);
		txtId.setLayoutData(gdf2.create());
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setText("Name");
		
		final Text txtName = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		txtName.setTextLimit(20);
		
		Label lblTitle = new Label(shell, SWT.NONE);
		lblTitle.setText("Title");
		
		final Text txtTitle = new Text(shell, SWT.READ_ONLY);
		txtTitle.setTextLimit(50);
		
		Label lblRole = new Label(shell, SWT.NONE);
		lblRole.setText("Role");
		
		final Text txtRole = new Text(shell, SWT.READ_ONLY);
		txtRole.setTextLimit(Text.LIMIT);
		txtRole.setLayoutData(gdf2.copy().hint(400, SWT.DEFAULT).create());
		

		viewer.addSelectionChangedListener(new ISelectionChangedListener(){
			
			public void selectionChanged(SelectionChangedEvent ev){
				IStructuredSelection selection = (IStructuredSelection)ev.getSelection();
				Person p = (Person)selection.getFirstElement();
				
				txtId.setText(p.getId());
				txtName.setText(p.getName());
				txtTitle.setText(p.getTitle());
				txtRole.setText(p.getRole());
			}
		});
		
		shell.pack();
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}
	
	public static class Person{
		
		private String id;
		
		private String name;
		
		private String title;
		
		private String role;
		
		public Person(String id, String name, String title, String role){
			this.id = id;
			this.name = name;
			this.title = title;
			this.role = role;
		}
		
		public String getId(){ return this.id; }
		public void setId(String id){ this.id = id; }
		public String getName(){ return this.name; }
		public void setName(String name){ this.name = name; }
		public String getTitle(){ return this.title; }
		public void setTitle(String title){ this.title = title; }
		public String getRole(){ return this.role; }
		public void setRole(String role){ this.role = role; }
		
	}
	
}


