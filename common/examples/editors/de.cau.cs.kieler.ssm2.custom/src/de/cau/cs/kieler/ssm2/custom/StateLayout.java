package de.cau.cs.kieler.ssm2.custom;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

public class StateLayout extends StackLayout {

	IFigure parent;
	
	public void layout(IFigure p) {
		parent = p;
		List children = parent.getChildren();
		int count = 1;
		
		for (int i = 0; i < 6; i++) {
			IFigure currentFigure = (IFigure) children.get(i);
			
			if (currentFigure instanceof WrappingLabel) {
				centerAtTop(currentFigure);
			}
			else {
				fillPart(currentFigure, 5, count, true);
				count++;
			}
		}
	}	

	private void center(IFigure figure) {
		Dimension prefSize = figure.getPreferredSize();
		figure.getBounds().x = parent.getClientArea().x + (parent.getClientArea().width / 2) - (prefSize.width / 2);
		figure.getBounds().y = parent.getClientArea().y + (parent.getClientArea().height / 2) - (prefSize.height / 2);
		figure.getBounds().width = prefSize.width;
		figure.getBounds().height = prefSize.height;
	}
	
	private void centerAtTop(IFigure figure) {
		Dimension prefSize = figure.getPreferredSize();
		figure.getBounds().x = parent.getClientArea().x + (parent.getClientArea().width / 2) - (prefSize.width / 2);
		figure.getBounds().y = parent.getClientArea().y;
		figure.getBounds().width = prefSize.width;
		figure.getBounds().height = prefSize.height;
	}
	
	private void fillPart(IFigure figure, int numOfParts, int numOfPart, boolean offset) {
		figure.getBounds().x = parent.getClientArea().x + (parent.getClientArea().width / numOfParts)*(numOfPart-1);
		figure.getBounds().y = parent.getClientArea().y;
		figure.getBounds().width = parent.getClientArea().width / numOfParts;
		figure.getBounds().height = parent.getClientArea().height;
		
		if (offset) {
			int prefHeight = ((IFigure) parent.getChildren().get(0)).getPreferredSize().height;
			figure.getBounds().y += prefHeight;
			figure.getBounds().height -= prefHeight;
		}
	}
}
