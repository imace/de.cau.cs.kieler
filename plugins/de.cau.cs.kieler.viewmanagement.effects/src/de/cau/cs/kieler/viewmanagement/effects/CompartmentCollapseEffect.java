package de.cau.cs.kieler.viewmanagement.effects;



import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.viewmanagement.AEffect;

public class CompartmentCollapseEffect extends AEffect {

    ShapeEditPart objectToHighlight;
   
    
    // default constructor is always called by Eclipse... 
    public CompartmentCollapseEffect() {
       
        
    }
    
    @Override
    public void execute() {
    	IFigure selectedFigure =  objectToHighlight.getFigure();
    	System.out.println("CompInit!");
    	if (selectedFigure instanceof DefaultSizeNodeFigure)
    		{
    			 List children= selectedFigure.getChildren();
    			 
    		ResizableCompartmentFigure compartmentFigure = (ResizableCompartmentFigure) selectedFigure;
    			//compartmentFigure.g
    			//compartmentFigure.setCollapsed();
    
    		
  
    	
        /*
         
            IFigure layer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.FEEDBACK_LAYER);

            // get Figure to the EditPart
            IFigure selectedFigure = objectToHighlight.getFigure();
            */
        
        
        System.out.println("HighlightCompartment");
    	}
    }

    /**
     * Undo the effect. Here the highlighting will be removed.
     */
    public void undo(){
        
    }
    
    /**
     * @param target
     */
    public void setTarget(ShapeEditPart target) {
        this.objectToHighlight = target;
    }

}
