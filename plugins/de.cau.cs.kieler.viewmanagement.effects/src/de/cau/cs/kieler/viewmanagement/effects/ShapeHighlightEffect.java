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
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;

import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 *
 */
public class ShapeHighlightEffect extends AEffect {

    EditPart objectToHighlight;
   
   
    int lineWidth=3; 
    Color color= ColorConstants.red;
    
    
    /**
     * default constructor, highlighting figure is initially defined here
     */
    public ShapeHighlightEffect() {
        
        
        
        
    }
    
    
    public void execute() {
        
        
            objectToHighlight.getRoot();
            IFigure  figure = ((GraphicalEditPart)objectToHighlight).getFigure();
            figure.setForegroundColor(ColorConstants.red);
            figure.setBackgroundColor(ColorConstants.red);
           
//            Rectangle bounds = figure.getBounds();
//            bounds.height=bounds.height+20;
//            bounds.width=bounds.width+20;
//            figure.setBounds(bounds);
            Color fgcolor = figure.getForegroundColor();
            figure.repaint();
            
            

         
            
            

          
          
            
            
            // schedule a repaint of the feedback layer
            //layer.invalidate();
        
        //System.out.println("Highlight");
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
        this.objectToHighlight = target;
    }

	
	public void setParameters(Object objectParameters) {
		// TODO Auto-generated method stub
		
	}


	
//	public void setActive(boolean effectActive) {
//		this.highlightActive= effectActive;
//		
//	}
	/**
	 * Changes parameters of highlight figure. Will be re-read on every execute() call
	 * @param width
	 * @param lineColor
	 */
	public void setHighlightFigure(int width, Color lineColor){
		this.lineWidth = width;
		this.color=lineColor;
	}
	
//	public  Color getHighlightColor(){
//		return color;
//	}
//	public int getHighlightLine(){
//		return lineWidth;
//	}

}
