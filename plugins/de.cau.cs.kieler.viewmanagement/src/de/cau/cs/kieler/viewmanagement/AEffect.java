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

import java.util.Map;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
/**
 * @author nbe
 *
 */

public abstract class AEffect {


	
	public abstract void execute();
	
	public abstract void setTarget(ShapeEditPart target);
		
	public abstract void setParameters(Object parameters);
	
	//public abstract void setActive(boolean effectActive);
}
