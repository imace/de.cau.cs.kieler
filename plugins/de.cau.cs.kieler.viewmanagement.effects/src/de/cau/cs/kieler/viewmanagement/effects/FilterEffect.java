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


import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;


import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 * 
 */

public class FilterEffect extends AEffect {

	

    IFigure undoFigure;

    /**
     * default constructor
     */
    public FilterEffect() {
       
    }
    
    
    public void execute() {
    			IFigure selectedFigure = ((ShapeEditPart)this.affectedObject).getFigure();

            
            if (selectedFigure.isVisible()){
            	undoFigure=selectedFigure;
            
            	selectedFigure.setVisible(false);
            }
          
    
    }
    /**
     * Undo the effect. 
     */
    public void undo(){
        if((this.undoFigure!=null)&& (!this.undoFigure.isVisible()))
        	this.undoFigure.setVisible(true);
    }
	
	

}
