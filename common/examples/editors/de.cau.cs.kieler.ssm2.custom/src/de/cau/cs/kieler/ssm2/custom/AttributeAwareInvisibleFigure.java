package de.cau.cs.kieler.ssm2.custom;

import java.util.List;

import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

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
	
	public AttributeAwareInvisibleFigure() {
		super();
		
		RoundedRectangle invisibleFigure = new RoundedRectangle();
		invisibleFigure.setFill(false);
		invisibleFigure.setOutline(false);
		
		this.setDefaultFigure(invisibleFigure);
		this.setCurrentFigure(invisibleFigure);
		
	}
	
	// The preferred size of the invisible figure is the maximum preferred size
	// of all its child labels
	@Override
	public Dimension getPreferredSize(int hint, int hint2) {
		List<Object> children = this.getChildren();
		Dimension prefSize = new Dimension();
		if ((children != null) && (children.size() > 0)) {
			for (Object child : children) {
				if (child instanceof WrappingLabel) {
					WrappingLabel label = (WrappingLabel) child;
					int width = label.getPreferredSize().width+5;
					int height = label.getPreferredSize().height;
					if (width > prefSize.width) {
						prefSize.width = width; 
					}
					if (width > prefSize.height) {
						prefSize.height = height; 
					}
				}
			}
		}
		return prefSize;
	}
	
	// The minimum size of the invisible figure is the same as the
	// preferred size
	@Override
	public Dimension getMinimumSize(int hint, int hint2) {
		return getPreferredSize();
	}
}
