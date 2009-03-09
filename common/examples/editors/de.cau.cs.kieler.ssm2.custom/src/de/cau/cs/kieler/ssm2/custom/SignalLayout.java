package de.cau.cs.kieler.ssm2.custom;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

public class SignalLayout extends StackLayout {

	public void layout(IFigure parent) {
		List children = parent.getChildren();
		IFigure figure;
		Dimension prefSize = new Dimension(0, 0);
		
		if (children.size() > 0) {
			figure = (IFigure) children.get(0);
			if (figure instanceof WrappingLabel) {
				prefSize = figure.getPreferredSize();
				parent.getClientArea().width = prefSize.width + prefSize.height * 3;
				parent.getClientArea().height = prefSize.height;
				figure.getBounds().x = parent.getClientArea().x + prefSize.height * 3;
				figure.getBounds().y = parent.getClientArea().y;
				figure.getBounds().width = prefSize.width;
				figure.getBounds().height = prefSize.height;
			}
		}
		
		if (parent instanceof AttributeAwareSignalFigure) {
			figure = ((AttributeAwareSignalFigure) parent).getCurrentFigure();
			figure.getBounds().x = parent.getClientArea().x;
			figure.getBounds().y = parent.getClientArea().y;
			figure.getBounds().width = prefSize.height * 3;
			figure.getBounds().height = prefSize.height;
			figure.repaint();
		}
	}	
		
}
