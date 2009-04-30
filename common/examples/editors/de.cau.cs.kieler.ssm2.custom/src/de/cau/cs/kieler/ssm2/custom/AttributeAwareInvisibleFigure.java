package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.gef.EditPart;

public class AttributeAwareInvisibleFigure extends AttributeAwareFigure {

	// The figure for figures that are not supposed to be seen, such as the
	// background figures needed for signal and action labels; actually
	// they do not need to be attribute aware,
	// but if they were not, the code templates would not work since we cannot
	// distinguish different classes in code templates (at least I can't)
	public AttributeAwareInvisibleFigure(EditPart e) {
		super();
		this.setModelElementAndRegisterFromEditPart(e);
		
		RoundedRectangle invisibleFigure = new RoundedRectangle();
		invisibleFigure.setFill(false);
		invisibleFigure.setOutline(false);
		
		this.setDefaultFigure(invisibleFigure);
		this.setCurrentFigure(invisibleFigure);
		
	}
}
