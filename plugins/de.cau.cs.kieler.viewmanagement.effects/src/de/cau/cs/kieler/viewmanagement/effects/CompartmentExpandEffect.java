package de.cau.cs.kieler.viewmanagement.effects;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

public class CompartmentExpandEffect extends AEffect {

    ShapeEditPart objectToHighlight;
    //List<IFigure> resizableFigures = new ArrayList<IFigure>();
   
    
    // default constructor is always called by Eclipse... 
    public CompartmentExpandEffect() {
       
        
    }
    
    @Override
    public void execute() {
    	IFigure selectedFigure =  objectToHighlight.getFigure();
    	System.out.println("CompInit!");
    	List<IFigure> resizableFigures = new ArrayList<IFigure>();
    	getResizeableCompartments(selectedFigure, resizableFigures);
    	//List <IFigure> collapsedComps =  new ArrayList<IFigure>();
    	//Here could be added some more refined method, like collapsing only some objects
    	for(int i=0; i<resizableFigures.size(); i++){
    		ResizableCompartmentFigure tempfig = (ResizableCompartmentFigure) resizableFigures.get(i);
    		//collapsedComps.add(tempfig);
    		tempfig.expand();
    		}
    	
    	
    }
    
    public void getResizeableCompartments(IFigure f, List<IFigure> resizableFigures){
    	
    	
    	if (f instanceof ResizableCompartmentFigure){
    		resizableFigures.add(f);
    		//((ResizableCompartmentFigure) f).collapse();
    	}
    	List childList = f.getChildren();
    	for(int i=0;  i<f.getChildren().size(); i++)
    		getResizeableCompartments((IFigure) f.getChildren().get(i), resizableFigures);
    		
    		
    	
		return;
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

	@Override
	public void setParameters(Object parameters) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void setActive(boolean effectActive) {
//		// TODO Auto-generated method stub
//		
//	}

}
