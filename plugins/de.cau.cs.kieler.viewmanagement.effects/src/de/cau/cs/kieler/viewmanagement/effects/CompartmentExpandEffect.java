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



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
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

/**
 * @author nbe
 * 
 */

public class CompartmentExpandEffect extends AEffect {

    ShapeEditPart objectToExpand;
    //List<IFigure> resizableFigures = new ArrayList<IFigure>();
   
    
    // default constructor is always called by Eclipse... 
    public CompartmentExpandEffect() {
       
        
    }
    
    @Override
    public void execute() {
    	IFigure selectedFigure =  objectToExpand.getFigure();
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
    public void setTarget(EditPart target) {
        this.objectToExpand = (ShapeEditPart) target;
    }

	@Override
	public void setParameters(Object parameters) {
		// TODO Auto-generated method stub
		
	}



}
