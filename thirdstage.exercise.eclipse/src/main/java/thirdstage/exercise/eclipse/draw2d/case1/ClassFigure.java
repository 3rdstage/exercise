package thirdstage.exercise.eclipse.draw2d.case1;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Color;

public class ClassFigure extends Figure {
	
	public static Color color = new Color(null, 255, 255, 206);
	
	private CompartmentFigure attrFigure = new CompartmentFigure();
	private CompartmentFigure methodFigure = new CompartmentFigure();
	
	public ClassFigure(Label name){
		ToolbarLayout lo = new ToolbarLayout();
		this.setLayoutManager(lo);
		this.setBorder(new LineBorder(ColorConstants.black, 1));
		this.setBackgroundColor(color);
		this.setOpaque(true);
		
		this.add(name);
		this.add(attrFigure);
		this.add(methodFigure);
	}
	
	public CompartmentFigure getAttributeCompartment(){ return this.attrFigure; }
	
	public CompartmentFigure getMethodCompartment(){ return this.methodFigure; }
	
	

}
