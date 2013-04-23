package thirdstage.exercise.eclipse.jface.case3;

import org.eclipse.draw2d.GridData;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

public class TableViewerSample01 {

	public static void main(String... args){
		
		Display display = new Display();
		Shell shell = new Shell(display);
		
		shell.setSize(1200, 800);
		shell.setLayout(new GridLayout(2, false));
		
		
		final TableViewer viewer = new TableViewer(shell, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | 
				SWT.FULL_SELECTION | SWT.BORDER);
		
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		
		TableViewerColumn col1 = new TableViewerColumn(viewer, SWT.NONE);
		col1.getColumn().setWidth(200);
		col1.getColumn().setText("ID");
		col1.setLabelProvider(new ColumnLabelProvider(){
			public String getText(Object obj){
				if(obj instanceof Person){
					Person p = (Person) obj;
					return p.getId();
				}else{
					return super.getText(obj);
				}
			}
		});
		
		TableViewerColumn col2 = new TableViewerColumn(viewer, SWT.NONE); 
		col2.getColumn().setWidth(300);
		col2.getColumn().setText("Name");
		col2.setLabelProvider(new ColumnLabelProvider(){
			public String getText(Object obj){
				if(obj instanceof Person){
					Person p = (Person) obj;
					return p.getName();
				}else{
					return super.getText(obj);
				}
			}
		});
		
		TableViewerColumn col3 = new TableViewerColumn(viewer, SWT.NONE); 
		col3.getColumn().setWidth(300);
		col3.getColumn().setText("Title");
		col3.setLabelProvider(new ColumnLabelProvider(){
			public String getText(Object obj){
				if(obj instanceof Person){
					Person p = (Person) obj;
					return p.getTitle();
				}else{
					return super.getText(obj);
				}
			}
		});
		
		TableViewerColumn col4 = new TableViewerColumn(viewer, SWT.NONE); 
		col4.getColumn().setWidth(300);
		col4.getColumn().setText("Role");
		col4.setLabelProvider(new ColumnLabelProvider(){
			public String getText(Object obj){
				if(obj instanceof Person){
					Person p = (Person) obj;
					return p.getRole();
				}else{
					return super.getText(obj);
				}
			}
		});
		
		Person[] persons = new Person[]{
				new Person("0001", "홍길동", "Manager", "Software Architect"),
				new Person("0002", "Smith", "Associate", "Software Engineer"),
				new Person("0003", "Chris", "Associate", "Graphic Designer"),
				new Person("0010", "Sang", "Associate", "Software Engineer")
		};
		
		CellEditor[] editors = {new TextCellEditor(shell), new TextCellEditor(shell), new TextCellEditor(), new TextCellEditor()};
		viewer.setCellEditors(editors);
		viewer.setInput(persons);
		viewer.getControl().setLayoutData(
				GridDataFactory.fillDefaults().grab(true, true).
				align(GridData.FILL, GridData.FILL).span(2, 1).create());
		
		
		final Text txt1 = new Text(shell, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI);
		txt1.setText(java.util.Arrays.toString(persons));
		txt1.setLayoutData(
				GridDataFactory.fillDefaults().grab(true, true).span(2, 1).create());
		
		
		
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
		
		public String toString(){
			return new StringBuilder().append("ID : ").append(this.id).append(", ")
					.append("Name : ").append(this.name).append(", ")
					.append("Title : ").append(this.title).append(", ")
					.append("Role : ").append(this.role).append("\n").toString();
		}
		
	}
	
}


