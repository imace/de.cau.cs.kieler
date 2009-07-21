package de.cau.cs.kieler.viewmanagement;

import java.util.Map;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;


public abstract class AEffect {


	
	public abstract void execute();
	
	public abstract void setTarget(ShapeEditPart target);
		
	public abstract void setParameters(Map <String, String> parameters);
}
