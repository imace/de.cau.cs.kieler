package de.cau.cs.kieler.cakefeed.custom;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.notation.View;

public class AdjustPortPositionCommand extends Command {

	protected GraphicalEditPart editPart;
	protected BorderItemLocator locator;
	
	public AdjustPortPositionCommand(GraphicalEditPart editPart, BorderItemLocator locator) {
		super();
		this.editPart = editPart;
		this.locator = locator;
	}
	
	@Override
	public void execute() {
		IFigure figure = editPart.getFigure();
		figure.setBounds(locator.getValidLocation(new Rectangle(0, 0, figure.getPreferredSize().width, figure.getPreferredSize().height),
				editPart.getFigure()));
	}
	
}
