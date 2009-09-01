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
package de.cau.cs.kieler.viewmanagement.effects;

import java.awt.Point;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.graphics.Color;

import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 * 
 */

public class FilterEffect extends AEffect {

    ShapeEditPart objectToHighlight;
    IFigure undoFigure;
    boolean filterActive;
   
    public FilterEffect() {
       
    }
    
    
    public void execute() {
           
            IFigure selectedFigure = objectToHighlight.getFigure();
            
            if (selectedFigure.isVisible()){
            	undoFigure=selectedFigure;
            
            	selectedFigure.setVisible(false);
            }
          
    
    }
    /**
     * Undo the effect. Here the highlighting will be removed.
     */
    public void undo(){
        if((undoFigure!=null)&& !undoFigure.isVisible())
        	undoFigure.setVisible(true);
    }
    
    /**
     * @param target
     */
    public void setTarget(ShapeEditPart target) {
        this.objectToHighlight = target;
    }

	
	public void setParameters(Object parameters) {
		// TODO Auto-generated method stub
		
	}


	
//	public void setActive(boolean effectActive) {
//		this.filterActive= effectActive;
//		
//	}
	
	

}
