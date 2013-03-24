package thirdstage.exercise.eclipse.draw2d.case1;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * This sample program is from the article "Display a UML Diagram using Draw2D"
 * at http://www.eclipse.org/articles/Article-GEF-Draw2d/GEF-Draw2d.html
 * 
 *  
 * @author 3rdstage
 * @since 2013-03-23
 *
 */
public class ClassFigureTest {
	
	public static void main(String... args){
		
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setSize(400, 400);
		shell.setText("Draw2d Exercise");
		
		LightweightSystem lws = new LightweightSystem(shell);
		Figure contents = new Figure();
		XYLayout lo = new XYLayout();
		contents.setLayoutManager(lo);
		
		Font ft1 = new Font(null, "Arial", 12, SWT.BOLD);
		Label classLbl1 = new Label("Table");
		classLbl1.setFont(ft1);
		Label classLbl2 = new Label("Column");
		classLbl2.setFont(ft1);
		
		
		final ClassFigure classFg1 = new ClassFigure(classLbl1);
		final ClassFigure classFg2 = new ClassFigure(classLbl2);
		
		Label attr11 = new Label("colums: Column[]");
		Label attr12 = new Label("rows: Row[]");
		Label attr21 = new Label("columnId: int");
		Label attr22 = new Label("items: List");
		
		classFg1.getAttributeCompartment().add(attr11);
		classFg1.getAttributeCompartment().add(attr12);
		classFg2.getAttributeCompartment().add(attr21);
		classFg2.getAttributeCompartment().add(attr22);
		
		Label mthd11 = new Label("getColums(): Column[]");
		Label mthd12 = new Label("getRows(): Row[]");
		Label mthd21 = new Label("getColumnId(): int");
		Label mthd22 = new Label("getItems(): List");
		
		classFg1.getMethodCompartment().add(mthd11);
		classFg1.getMethodCompartment().add(mthd12);
		classFg2.getMethodCompartment().add(mthd21);
		classFg2.getMethodCompartment().add(mthd22);
		
		lo.setConstraint(classFg1,	new Rectangle(10, 10, -1, -1));
		lo.setConstraint(classFg2, new Rectangle(200, 200, -1, -1));

		PolylineConnection conn = new PolylineConnection();
		ChopboxAnchor srcAnch = new ChopboxAnchor(classFg1);
		ChopboxAnchor tgtAnch = new ChopboxAnchor(classFg2);
		conn.setSourceAnchor(srcAnch);
		conn.setTargetAnchor(tgtAnch);
		
		contents.add(classFg1);
		contents.add(classFg2);
		contents.add(conn);
		
		
		lws.setContents(contents);
		shell.open();
		while(!shell.isDisposed()){
			while(!display.readAndDispatch()){
				display.sleep();
			}
		}
	}

}
