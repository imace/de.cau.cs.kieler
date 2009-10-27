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



import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * @author nbe
 * 
 */
public class ZoomEffect extends AEffect {

	
	  ShapeEditPart objectToZoom;
	  Object objectParameters;
	  ZoomManager zoomManager;
	public void execute() {
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		 if (editor instanceof DiagramEditor) {
             DiagramEditPart diagramEdit=  ((DiagramEditor) editor)
                     .getDiagramEditPart();
             zoomManager= ((RenderedDiagramRootEditPart)diagramEdit.getRoot()).getZoomManager();
         }
		 	
		 zoomManager.setZoomAsText(ZoomManager.FIT_ALL);
		 
	}

	@Override
	public void setParameters(Object parameters) {
		this.objectParameters= parameters;
		
	}

	@Override
	public void setTarget(EditPart target) {
		this.objectToZoom = (ShapeEditPart) target;
		
	}

}
