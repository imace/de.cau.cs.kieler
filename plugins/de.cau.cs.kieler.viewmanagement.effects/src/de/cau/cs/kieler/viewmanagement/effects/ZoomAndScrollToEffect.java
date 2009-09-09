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
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.swt.graphics.Color;

import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 *
 */
public class ZoomAndScrollToEffect extends AEffect {

    ShapeEditPart objectToHighlight;
    RectangleFigure highlightFigure;
   
    int lineWidth=3; 
    Color color= ColorConstants.red;
    
    
    /**
     * default constructor, highlighting figure is initially defined here
     */
    public ZoomAndScrollToEffect() {
        

        
        
    }
    
    
    public void execute() {
        
        // search a layer we can draw on        
        RootEditPart rootEP = objectToHighlight.getRoot();
        
     
            // get Figure to the EditPart
           
            IFigure selectedFigure = objectToHighlight.getFigure();
            
//            highlightFigure.setLineWidth(lineWidth);
//            highlightFigure.setForegroundColor(color);
            
            

            
            // get same bounds as the selected figure ...
            Rectangle bounds = selectedFigure.getBounds().getCopy();
            int height = 340;
            double zoomFactor = height/bounds.height;
            // ... but in absolute coordinates

            //translateToAbsolute is really bothersome, can't cope with either scrolling or zooming
           selectedFigure.translateToAbsolute(bounds);
           double zoomValue = ((RenderedDiagramRootEditPart) rootEP).getZoomManager().getZoom();
           zoomValue = zoomValue+zoomFactor;
           ((RenderedDiagramRootEditPart) rootEP).getZoomManager().setZoom(zoomValue);
           //Add correction for Zooming-related translation error
            bounds.scale(1/zoomValue);
            //get the top-most Viewport to determine the scroll value and apply for correction
            //this still has a zooming-related error in it, another corretion is needed
           Viewport viewport = null;
          IFigure parentFigure = selectedFigure.getParent();
            while( parentFigure != null ) {
             if(parentFigure instanceof Viewport) {
               viewport = (Viewport)parentFigure;
               

             }
             parentFigure = parentFigure.getParent();
			
            }
            int horValue = viewport.getHorizontalRangeModel().getValue();
            int verValue = viewport.getVerticalRangeModel().getValue();
            viewport.getHorizontalRangeModel().setValue(bounds.x);
            viewport.getVerticalRangeModel().setValue(bounds.y);
           
//               bounds.translate(
//                     (int) ((1/zoomValue)*viewport.getHorizontalRangeModel().getValue()),
//                     (int) ((1/zoomValue)*viewport.getVerticalRangeModel().getValue()));
//               
//             }
             
//               parentFigure = parentFigure.getParent();
             
            } 
            
            
                   
            
            // set the bounds of the Figure that will do the highlighting
            
//            highlightFigure.setBounds(bounds);
//            System.out.println(highlightFigure.getBounds() +  " "+bounds);
            // add the new highlight figure to the layer
          
            
            
            
            // schedule a repaint of the feedback layer
//            layer.invalidate();
//        }
        //System.out.println("Highlight");
    

    /**
     * Undo the effect. Here the highlighting will be removed.
     */
    public void undo(){
        
    }
    
    /**
     * @param target
     */
    public void setTarget(EditPart target) {
        this.objectToHighlight = (ShapeEditPart) target;
    }

	
	public void setParameters(Object objectParameters) {
		// TODO Auto-generated method stub
		
	}



	


}
