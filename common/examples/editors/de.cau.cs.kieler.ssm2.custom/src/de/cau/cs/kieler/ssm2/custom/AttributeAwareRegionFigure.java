package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.gef.EditPart;

public class AttributeAwareRegionFigure extends AttributeAwareFigure {

	public AttributeAwareRegionFigure(EditPart e) {
		super();
		this.setModelElementAndRegisterFromEditPart(e);
		
		RoundedRectangle regionFigure = new RoundedRectangle();
		regionFigure.setFill(false);
		regionFigure.setLineWidth(2);
		regionFigure.setLineStyle(Graphics.LINE_DASH);
		regionFigure.setForegroundColor(ColorConstants.gray);
		
		this.setDefaultFigure(regionFigure);
		this.setCurrentFigure(regionFigure);
		
	}
}
