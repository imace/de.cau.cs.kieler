/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 * 
 *****************************************************************************/
package de.cau.cs.kieler.synccharts.custom;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.gef.EditPart;

/**
 * This class represents the attribute aware region figures, which are grey dashed boxes.
 * @author schm
 *
 */
//public class AttributeAwareRegionFigure extends AttributeAwareFigure {
    public class AttributeAwareRegionFigure extends NeighborAwareOpenRectangleFigure {
    
    /**
     * The constructor. 
     * @param e The edit part the figure is supposed to watch.
     */
	// The figure for regions; actually they do not need to be attribute aware,
	// but if they were not, the code templates would not work since we cannot
	// distinguish different classes in code templates (at least I can't)
	public AttributeAwareRegionFigure(EditPart e) {
		super();
		//this.setModelElementAndRegisterFromEditPart(e);
		
		this.setFill(false);
		this.setLineWidth(2);
		this.setLineStyle(Graphics.LINE_DASH);
		this.setForegroundColor(ColorConstants.gray);
		
		this.setSiblingLevel(2);
	}
}
