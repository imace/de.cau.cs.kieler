package de.cau.cs.kieler.ssm2.custom;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

public class AttributeAwareFigure extends Figure implements Adapter {

	protected List<ConditionalFigure> conditionalFigureList;
	protected EObject modelElement;
	protected Figure defaultFigure;
	protected Figure currentFigure;
	
	public AttributeAwareFigure() {
		super();
		modelElement = null;
		conditionalFigureList = null;
		defaultFigure = null;
		currentFigure = null;
	}
		
	public void setModelElementAndRegisterFromEditPart(EditPart e) {
		modelElement = ((View) (e.getModel())).getElement();
		((Notifier) modelElement).eAdapters().add(this);
	}
	
	public void setDefaultFigure(Figure f) {
		defaultFigure = f;
	}
	
	public void setCurrentFigure(Figure f) {
		// TODO wenn möglich, immer das Bild als erstes und einziges Kind der Figure behalten
		// TODO und alle Kinder der Figure (Labels, Compartments usw.) als Kinder des Bildes setzen
		if (currentFigure != null) {
			this.remove(currentFigure);
		}
		currentFigure = f;
		this.add(currentFigure);
	}
	
	public void addConditionalFigure(ConditionalFigure cf) {
		conditionalFigureList.add(cf);
	}
	
	@Override
	public Notifier getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void notifyChanged(Notification notification) {
		for (ConditionalFigure cf : conditionalFigureList) {
			boolean fulfilled = true;
			for (Condition c : cf.getConditions()) {
				if (((modelElement.eGet(c.getFeature()).getClass()).equals(c.getValue().getClass()))
						&& (!modelElement.eGet(c.getFeature()).equals(c.getValue()))) {
					fulfilled = false;
					break;
				}
			}
			if (fulfilled) {
				setCurrentFigure(cf.getFigure());
				break;
			} 
			else {
				setCurrentFigure(defaultFigure);
			}
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {
		// TODO Auto-generated method stub
		
	}
}
