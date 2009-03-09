package de.cau.cs.kieler.ssm2.custom;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

public class StateLayout extends StackLayout {

	public void layout(IFigure parent) {
		List children = parent.getChildren();
		IFigure figure;
		Rectangle newBounds;
		
		if (children.size() > 0) {
			figure = (IFigure) children.get(0);
			if (figure instanceof WrappingLabel) {
				center(parent, figure);
			}
		}
		if (children.size() > 1) {
			figure = (IFigure) children.get(1);
			newBounds = new Rectangle(parent.getClientArea());
			newBounds.x += parent.getClientArea().width / 4;
			newBounds.y += parent.getClientArea().height / 4;
			newBounds.width = parent.getClientArea().width / 2;
			newBounds.height = parent.getClientArea().height / 2;
			figure.setBounds(newBounds);
		}
	}	
	
	private void center(IFigure parent, IFigure figure) {
		Dimension prefSize = figure.getPreferredSize();
		figure.getBounds().x = parent.getClientArea().x + (parent.getClientArea().width / 2) - (prefSize.width / 2);
		figure.getBounds().y = parent.getClientArea().y + (parent.getClientArea().height / 2) - (prefSize.height / 2);
		figure.getBounds().width = prefSize.width;
		figure.getBounds().height = prefSize.height;
	}
}
