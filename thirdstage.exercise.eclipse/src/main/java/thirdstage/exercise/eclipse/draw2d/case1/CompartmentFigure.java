package thirdstage.exercise.eclipse.draw2d.case1;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;



public class CompartmentFigure extends Figure {
	
	public CompartmentFigure(){
		ToolbarLayout lo = new ToolbarLayout();
		lo.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
		lo.setStretchMinorAxis(false);
		lo.setSpacing(2);
		this.setLayoutManager(lo);
		this.setBorder(new CompartmentFigureBorder());
	}
	
	public class CompartmentFigureBorder extends AbstractBorder{
		public Insets getInsets(IFigure figure){
			return new Insets(1,0,0,0);
		}
		
		public void paint(IFigure figure, Graphics graphics, Insets insets){
			graphics.drawLine(getPaintRectangle(figure, insets).getTopLeft(),
					tempRect.getTopRight());
		}
		
	}
	

}
