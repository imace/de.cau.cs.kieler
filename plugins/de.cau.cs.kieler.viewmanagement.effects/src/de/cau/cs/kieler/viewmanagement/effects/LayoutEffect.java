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
import org.eclipse.draw2d.Label;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import de.cau.cs.kieler.kiml.ui.layout.*;
import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 *
 */
public class LayoutEffect extends AEffect{
	
	ShapeEditPart objectToLayout;
    Object objectParameters;
    Label textualFigure;
   
    
	/**
	 * default constructor
	 */
	public LayoutEffect(){
		
	}

	
	public void execute() {
		
		DiagramLayoutManager.layout(null, objectToLayout, false, false);

		
	}

	
	public void setParameters(Object parameters) {
		this.objectParameters= parameters;
		
	}

	
	public void setTarget(ShapeEditPart target) {
		this.objectToLayout = target;
		
	}

}
