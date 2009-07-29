package de.cau.cs.kieler.viewmanagement.effects;

import java.util.Map;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;

import de.cau.cs.kieler.viewmanagement.AEffect;

public class TextualRepresentationEffect extends AEffect{

	ShapeEditPart objectToHighlight;
	Map<String, String> textToDisplay;
	
	public TextualRepresentationEffect(){
		
	}
	@Override
	public void execute() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParameters(Map<String, String> parameters) {
		this.textToDisplay = parameters;
		
	}

	@Override
	public void setTarget(ShapeEditPart target) {
		this.objectToHighlight = target;
		
	}
	@Override
	public void setActive(boolean effectActive) {
		// TODO Auto-generated method stub
		
	}
	

}
