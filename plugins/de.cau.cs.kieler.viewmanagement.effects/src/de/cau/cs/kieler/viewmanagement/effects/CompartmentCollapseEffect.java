package de.cau.cs.kieler.viewmanagement.effects;



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

public class CompartmentCollapseEffect extends AEffect {

    ShapeEditPart objectToHighlight;
    Map <String, String> objectParameters;
	
   
    
    // default constructor is always called by Eclipse... 
    public CompartmentCollapseEffect() {
       
        
    }
    
    @Override
    public void execute() {
    	IFigure selectedFigure =  objectToHighlight.getFigure();
    	System.out.println("CompInit!");
    	int length = getCollapseableComponents().length;
    	List<?> collapsedComponents;
    	ResizableCompartmentFigure [][]componentsToCollapse= getCollapseableComponents();
    	if (objectParameters.get("depth")==null)
    		for (int i=0; i < componentsToCollapse.length; i++ )
    			for (int j=0; j < componentsToCollapse.length; j++)
    				collapsedComponents.add((componentsToCollapse[i][j]));				
			}
    	
    	/*if (selectedFigure instanceof DefaultSizeNodeFigure)
    		{
    			for (int i = 0; i < 10; i++) {
    				IFigure childFigure = selectedFigure;
    				for(int j=0; j< childFigure.getChildren().size(); j++){
    						IFigure	tempFigure = (IFigure) childFigure.getChildren().get(j);
    					if ( tempFigure instanceof ShapeCompartmentFigure){
    						ShapeCompartmentFigure collapseFigure = (ShapeCompartmentFigure) tempFigure;
    						//TODO Save Elements before collapsing for undo, change to ResizableCompartmentFigure
    						collapseFigure.collapse();
    					}
    						
    					else childFigure= tempFigure;
    				}
					
				}
					
				}
    			 List children= selectedFigure.getChildren();
    			 
    			 */
    			 
    
    
    		
  
    	
       
        
        
     
    }

    /**
     * Undo the effect. Here the highlighting will be removed.
     */
    public void undo(){
        
    }
    
    public ResizableCompartmentFigure[][] getCollapseableComponents(){
    	IFigure selectedFigure =  objectToHighlight.getFigure();
    	ResizableCompartmentFigure [][]collapseableComponents = new ResizableCompartmentFigure [20][];
    	int i = 0,j =0;
    	List<?> childrenList;
    	if (selectedFigure instanceof ResizableCompartmentFigure){
    		collapseableComponents[i][j]= (ResizableCompartmentFigure) selectedFigure;
    		i++;
    	}
    	
    		childrenList = selectedFigure.getChildren();
    		while (childrenList.get(j)!= null){
    			if (childrenList.get(j)instanceof ResizableCompartmentFigure)
    				collapseableComponents[i][j]= (ResizableCompartmentFigure) childrenList.get(j);
    			j++;
    		}
    	
    	
    	
    	return collapseableComponents;
    	
    	
    	
    }
    
    /**
     * @param target
     */
    public void setTarget(ShapeEditPart target) {
        this.objectToHighlight = target;
    }

	@Override
	public void setParameters(Map<String, String> parameters) {
		this.objectParameters = parameters;
		
	}

}
