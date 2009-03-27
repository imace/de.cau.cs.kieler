package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Color;

public class InvisibleBorder extends LineBorder {
	
	public InvisibleBorder(Color color, int width) {
		super(color, width);
	}
	
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		
	}
	
}
