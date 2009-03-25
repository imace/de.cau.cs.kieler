package de.cau.cs.kieler.ssm2.custom;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

public class AttributeAwareConnection extends PolylineConnectionEx implements Adapter {

	protected List<ConditionalConnectionLook> conditionalFigureList;
	protected EObject modelElement;
	protected AbstractLayout layout;
	protected ConditionalConnectionLook defaultLook;
	protected ConditionalConnectionLook currentLook;
	
	public AttributeAwareConnection() {
		super();
	}
	
	public void setLayout(AbstractLayout l) {
		layout = l;
	}
	
	public EObject getModelElement() {
		return modelElement;
	}
		
	public void setModelElementAndRegisterFromEditPart(EditPart e) {
		modelElement = ((View) (e.getModel())).getElement();
		((Notifier) modelElement).eAdapters().add(this);
	}
	
	public void setDefaultLook(ConditionalConnectionLook look) {
		defaultLook = look;
	}
	
	public void setCurrentLook(ConditionalConnectionLook look) {
		currentLook = look;
	}
	
	public ConditionalConnectionLook getDefaultLook() {
		return defaultLook;
	}
	
	public ConditionalConnectionLook getCurrentLook() {
		return currentLook;
	}
	
	public void addConditionalFigure(ConditionalConnectionLook cf) {
		conditionalFigureList.add(cf);
	}
	
	public Notifier getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAdapterForType(Object type) {
		// TODO Auto-generated method stub
		return false;
	}

	public void notifyChanged(Notification notification) {
		for (ConditionalConnectionLook cf : conditionalFigureList) {
			boolean fulfilled = true;
			for (Condition c : cf.getConditions()) {
				if (!(c.isValid(modelElement))) {
					fulfilled = false;
					break;
				}
			}
			if (fulfilled) {
				setLook(cf);
				break;
			} 
			else {
				setLook(defaultLook);
			}
		}
		this.repaint();
	}

	public void setTarget(Notifier newTarget) {
		// TODO Auto-generated method stub
		
	}
	
	protected void setLook(ConditionalConnectionLook look) {
		this.setSourceDecoration(look.getSourceDeco());
		this.setTargetDecoration(look.getTargetDeco());
	}

}
