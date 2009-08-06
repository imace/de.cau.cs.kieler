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

public class HighlightEffect extends AEffect {

    ShapeEditPart objectToHighlight;
    RectangleFigure highlightFigure;
    //boolean highlightActive;
    int lineWidth= 0;
    Color color = ColorConstants.red;
    
    // default constructor is always called by Eclipse... 
    public HighlightEffect() {
        // configure the figure that should be used for highlighting.
        this.highlightFigure = new RectangleFigure();
        highlightFigure.setLineWidth(lineWidth);
        highlightFigure.setForegroundColor(color);
        highlightFigure.setFill(false);
        highlightFigure.setFillXOR(false);
        highlightFigure.setOutline(true);
        highlightFigure.setOutlineXOR(false);
        highlightFigure.setOpaque(false);
        
        
    }
    
    
    public void execute() {
        
        // search a layer we can draw on        
        RootEditPart rootEP = objectToHighlight.getRoot();
        
        if(rootEP instanceof RenderedDiagramRootEditPart){
            IFigure layer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.FEEDBACK_LAYER);
            IFigure guideLayer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.GUIDE_LAYER);
            IFigure connectionLayer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.CONNECTION_LAYER);
            IFigure decoprintLayer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.DECORATION_PRINTABLE_LAYER);
            IFigure decounprintLayer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.DECORATION_UNPRINTABLE_LAYER);
            IFigure gridLayer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.GRID_LAYER);
            IFigure handleLayer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.HANDLE_LAYER);
            IFigure primaryLayer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.PRIMARY_LAYER);
            IFigure feedBackLayer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.FEEDBACK_LAYER);
            IFigure scaledFBLayer = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.SCALED_FEEDBACK_LAYER);
            IFigure printableLayers = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.PRINTABLE_LAYERS);
            IFigure scaleableLayers = ((RenderedDiagramRootEditPart) rootEP).getLayer(RenderedDiagramRootEditPart.SCALABLE_LAYERS);
            
            // get Figure to the EditPart
           
            IFigure selectedFigure = objectToHighlight.getFigure();
            
            

            
            // get same bounds as the selected figure ...
            Rectangle bounds = selectedFigure.getBounds().getCopy();
            // ... but in absolute coordinates
//            System.out.println(bounds);
//            
//            System.out.println(bounds);
            
            selectedFigure.translateToAbsolute(bounds);
            bounds.scale(((RenderedDiagramRootEditPart) rootEP).getZoomManager().getZoom());
            //get the top-most Viewport to determine the scroll value and apply for correction 
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
            
            
                   
            
            // set the bounds of the Figure that will do the highlighting
            
            highlightFigure.setBounds(bounds);
//            System.out.println(highlightFigure.getBounds() +  " "+bounds);
            // add the new highlight figure to the layer
          
            layer.add(highlightFigure);
            
            
            // schedule a repaint of the feedback layer
            layer.invalidate();
        }
        System.out.println("Highlight");
    }

    /**
     * Undo the effect. Here the highlighting will be removed.
     */
    public void undo(){
        this.highlightFigure.getParent().remove(this.highlightFigure);
    }
    
    /**
     * @param target
     */
    public void setTarget(ShapeEditPart target) {
        this.objectToHighlight = target;
    }

	
	public void setParameters(Object objectParameters) {
		// TODO Auto-generated method stub
		
	}


	
//	public void setActive(boolean effectActive) {
//		this.highlightActive= effectActive;
//		
//	}
	public void setHighlightFigure(int width, Color lineColor){
		lineWidth=width;
		color=lineColor;
	}
	

}
