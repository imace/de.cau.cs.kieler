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

/**
 * @author nbe
 * 
 */

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;

import de.cau.cs.kieler.viewmanagement.AEffect;

public class UnFilterEffect extends AEffect {

	public UnFilterEffect(){
		
	}
	
	@Override
	public void execute() {
		IFigure selectedFigure = ((ShapeEditPart)this.affectedObject).getFigure();

        
        if (selectedFigure.isVisible()){
        	
        
        	selectedFigure.setVisible(true);
        }
		
	}



}
