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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 * 
 */

public class TextualRepresentationEffect extends AEffect {

    ShapeEditPart objectToText;
    Object objectParameters;
    Label textualFigure;
  
    
   
   
    public TextualRepresentationEffect() {
       
        this.textualFigure = new Label();
       
        textualFigure.setTextAlignment(PositionConstants.ALWAYS_RIGHT);
       
        textualFigure.setForegroundColor(ColorConstants.blue);
        
    }
    
    
    public void execute() {
        
              
        RootEditPart rootEP = objectToText.getRoot();
        
        if(rootEP instanceof RenderedDiagramRootEditPart){
            IFigure layer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.FEEDBACK_LAYER);
            IFigure selectedFigure = objectToText.getFigure();
            Rectangle bounds = selectedFigure.getBounds().getCopy();
            
            selectedFigure.translateToAbsolute(bounds);
            //translateToAbsolute is really bothersome, can't cope with either scrolling or zooming
            selectedFigure.translateToAbsolute(bounds);
            double zoomValue = ((RenderedDiagramRootEditPart) rootEP).getZoomManager().getZoom();
            //Add correction for Zooming-related translation error
             bounds.scale(1/zoomValue);
             //get the top-most Viewport to determine the scroll value and apply for correction
             //this still has a zooming-related error in it, another corretion is needed
           IFigure parentFigure = selectedFigure.getParent();
             while( parentFigure != null ) {
              if(parentFigure instanceof Viewport) {
                Viewport viewport = (Viewport)parentFigure;
                bounds.translate(
                      (int) ((1/zoomValue)*viewport.getHorizontalRangeModel().getValue()),
                      (int) ((1/zoomValue)*viewport.getVerticalRangeModel().getValue()));
                
              }
              
                parentFigure = parentFigure.getParent();
              
             } 
//            Little adjustment to not paint it over the figure. Should be done somehow better
            bounds.width = bounds.width+25;
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
        this.objectToText = target;
    }

	
	public void setParameters(Object parameters) {
		
		
		
	}




}
