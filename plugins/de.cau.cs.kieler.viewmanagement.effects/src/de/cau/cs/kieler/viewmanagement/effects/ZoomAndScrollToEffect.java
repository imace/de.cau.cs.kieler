/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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




import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;


import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 *
 */
public class ZoomAndScrollToEffect extends AEffect {

    ShapeEditPart objectToHighlight;
    int offset = 25;

   
    
    
    
    /**
     * default constructor, highlighting figure is initially defined here
     */
    public ZoomAndScrollToEffect() {
        

        
        
    }
    
    
    public void execute() {
        
          
        RootEditPart rootEP = objectToHighlight.getRoot();
           
            IFigure selectedFigure = objectToHighlight.getFigure();

            
            Rectangle bounds = selectedFigure.getBounds().getCopy();
            Viewport viewport = null;
            IFigure parentFigure = selectedFigure.getParent();
             while( parentFigure != null ) {
              if(parentFigure instanceof Viewport) {
                viewport = (Viewport)parentFigure;
                

              }
              parentFigure = parentFigure.getParent();
 			
             }
             bounds.height= bounds.height+offset;
             bounds.width= bounds.width+offset;
             double maxHeight = viewport.getBounds().height;
             double maxWidth = viewport.getBounds().width;
           
            double zoomFactor1 = maxHeight/bounds.height;
            double zoomFactor2 = maxWidth/bounds.width;
            
            double zoomFactor;
			if (zoomFactor1 < zoomFactor2)
            	 zoomFactor = zoomFactor1;
			else zoomFactor = zoomFactor2;
         

           
           selectedFigure.translateToAbsolute(bounds);
           double zoomValue = ((RenderedDiagramRootEditPart) rootEP).getZoomManager().getZoom();
           double newZoomValue = zoomFactor;
           ((RenderedDiagramRootEditPart) rootEP).getZoomManager().setZoom(newZoomValue);
           
            bounds.scale(1/newZoomValue);
           
           

            
            int horValue = viewport.getHorizontalRangeModel().getValue();
            int verValue = viewport.getVerticalRangeModel().getValue();
            viewport.getHorizontalRangeModel().setValue(bounds.x);
            viewport.getVerticalRangeModel().setValue(bounds.y);
           
             
            } 
            

    

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
		
		
		
		 
		
		
	}



	


}
