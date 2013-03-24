package thirdstage.exercise.eclipse.draw2d.case2;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MidpointLocator;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener.Stub;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * This sample is from the page "http://publib.boulder.ibm.com/infocenter/rtnlhelp/v6r0m0/topic/org.eclipse.draw2d.doc.isv/reference/api/org/eclipse/draw2d/doc-files/demo4.html"
 * But it has some bugs ^^;
 * Refer the original source at "http://git.eclipse.org/c/gef/org.eclipse.gef.git/tree/org.eclipse.draw2d.examples/src/org/eclipse/draw2d/examples/connections/ConnectionAndAnchorExample.java"
 * 
 * @author 3rdstage
 *
 */
public class DraggingExercise {

	public static void main(String... args){
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(350, 350);
		
		shell.setText("Eclipse Draw2d Dragging Test");
		LightweightSystem lws = new LightweightSystem(shell);
		IFigure pannel = new Figure();
		lws.setContents(pannel);
		
		IFigure node1 = new RectangleFigure();
		IFigure node2 = new RectangleFigure();
		
		node1.setBounds(new Rectangle(40, 40, 50, 30));
		node1.setBackgroundColor(ColorConstants.red);
		node2.setBounds(new Rectangle(200, 40, 50, 30));
		node2.setBackgroundColor(ColorConstants.blue);
		//node2.setLocation(new Point(100, 100));
		
		PolylineConnection conn = new PolylineConnection();
		conn.setSourceAnchor(new ChopboxAnchor(node1));
		conn.setTargetAnchor(new ChopboxAnchor(node2));
		conn.setTargetDecoration(new PolygonDecoration());
		
		Label lbl = new Label("midpoint");
		lbl.setOpaque(true);
		lbl.setBackgroundColor(ColorConstants.buttonLightest);
		lbl.setBorder(new LineBorder());
		conn.add(lbl, new MidpointLocator(conn, 0));
		
		pannel.add(node1);
		pannel.add(node2);
		pannel.add(conn);
		
		DragListener dragLstn1 = new DragListener();
		node1.addMouseListener(dragLstn1);
		node1.addMouseMotionListener(dragLstn1);
		
		DragListener dragLstn2 = new DragListener();
		node2.addMouseListener(dragLstn2);
		node2.addMouseMotionListener(dragLstn2);
		
		
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}

		
	}
	
	static class DragListener extends Stub implements MouseListener{
		Point last = null;
		
		public void mouseReleased(MouseEvent ev){}
		public void mouseClicked(MouseEvent ev){}
		public void mouseDoubleClicked(MouseEvent ev){}
		public void mousePressed(MouseEvent ev){
			last = ev.getLocation();
		}
		public void mouseDragged(MouseEvent ev){
			Point p = ev.getLocation();
			Dimension delta = p.getDifference(last);
			last = p;
			IFigure fig = (IFigure)(ev.getSource());
			fig.setBounds(fig.getBounds().getTranslated(delta.width, delta.height));
		}
	}
}
