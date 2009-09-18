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
package de.cau.cs.kieler.viewmanagement;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
/**
 * @author nbe
 *
 */

public abstract class AEffect {


	
	protected EditPart affectedObject;
	public abstract void execute();
	
	public  void setTarget(EditPart target) {
		this.affectedObject = target;
	}
		
	public void setParameters(Object parameters) {
	}
	public EditPart translateToEditPart (EObject input){
		
		
		return null;
		
	}
	
	
}
