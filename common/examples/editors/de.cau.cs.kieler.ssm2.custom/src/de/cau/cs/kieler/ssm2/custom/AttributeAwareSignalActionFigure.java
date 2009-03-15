package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.gef.EditPart;

public class AttributeAwareSignalActionFigure extends AttributeAwareFigure {

	public AttributeAwareSignalActionFigure(EditPart e) {
		super();
		this.setModelElementAndRegisterFromEditPart(e);
		
		RoundedRectangle SignalActionFigure = new RoundedRectangle();
		SignalActionFigure.setFill(false);
		SignalActionFigure.setLineWidth(2);
		SignalActionFigure.setForegroundColor(ColorConstants.gray);
		
		this.setDefaultFigure(SignalActionFigure);
		this.setCurrentFigure(SignalActionFigure);
		
	}
}
