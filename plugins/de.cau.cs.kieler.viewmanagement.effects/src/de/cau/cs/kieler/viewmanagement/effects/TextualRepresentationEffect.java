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
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
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

import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 * 
 */

public class TextualRepresentationEffect extends AEffect {

    ShapeEditPart objectToHighlight;
    Object objectParameters;
    //String textToAdd;
    Label textualFigure;
  
    
   
    public TextualRepresentationEffect() {
       
        this.textualFigure = new Label();
        //textualFigure.setTextPlacement(PositionConstants.RIGHT);
        textualFigure.setTextAlignment(PositionConstants.ALWAYS_RIGHT);
       
        textualFigure.setForegroundColor(ColorConstants.blue);
        
    }
    
    
    public void execute() {
        
              
        RootEditPart rootEP = objectToHighlight.getRoot();
        
        if(rootEP instanceof RenderedDiagramRootEditPart){
            IFigure layer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.FEEDBACK_LAYER);
            IFigure selectedFigure = objectToHighlight.getFigure();
            Rectangle bounds = selectedFigure.getBounds().getCopy();
            
            selectedFigure.translateToAbsolute(bounds);
            //bounds.scale(((RenderedDiagramRootEditPart) rootEP).getZoomManager().getZoom());
             
           IFigure parentFigure = selectedFigure.getParent();
            while( parentFigure != null ) {
             if(parentFigure instanceof Viewport) {
               Viewport viewport = (Viewport)parentFigure;
               bounds.translate(
                     viewport.getHorizontalRangeModel().getValue(),
                     viewport.getVerticalRangeModel().getValue());
               }
             
               parentFigure = parentFigure.getParent();
             
            } 
//            Little adjustment to not paint it over the figure. Should be done somehow better
            //bounds.width = bounds.width+25;
            textualFigure.setText((String) objectParameters);
            textualFigure.setBounds(bounds);

            layer.add(textualFigure);

            layer.invalidate();
        }
        System.out.println("Highlight");
    }

    /**
     * Undo the effect. Here the highlighting will be removed.
     */
    public void undo(){
        this.textualFigure.getParent().remove(this.textualFigure);
    }
    
    /**
     * @param target
     */
    public void setTarget(ShapeEditPart target) {
        this.objectToHighlight = target;
    }

	
	public void setParameters(Object parameters) {
		this.objectParameters= parameters;
		//textualFigure.setText(textParameters);
		
	}


	
//	public void setActive(boolean effectActive) {
//		this.highlightActive= effectActive;
//		
//	}

}
