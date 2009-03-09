package de.cau.cs.kieler.ssm2.custom;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

public class AttributeAwareConnection extends PolylineConnection implements Adapter {

	protected List<ConditionalFigure> conditionalFigureList;
	protected EObject modelElement;
	protected PolylineConnection defaultFigure;
	protected PolylineConnection currentFigure;
	protected AbstractLayout layout;
	
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
	
	public void setDefaultFigure(PolylineConnection f) {
		defaultFigure = f;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		currentFigure.setBounds(this.getBounds());
		currentFigure.setStart(this.getStart());
		currentFigure.setEnd(this.getEnd());
		currentFigure.setPoints(this.getPoints());
		// Anscheinend wird die location der Decorations nicht gesetzt
		// gibt leider keinen Accessor dafür :(
		currentFigure.paint(g);
	}
	
	public Figure getCurrentFigure() {
		return currentFigure;
	}
	
	public void setCurrentFigure(PolylineConnection f) {
		currentFigure = f;
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
				if (!(c.isValid(modelElement))) {
					fulfilled = false;
					break;
				}
			}
			if (fulfilled) {
				setCurrentFigure((PolylineConnection) (cf.getFigure()));
				break;
			} 
			else {
				setCurrentFigure(defaultFigure);
			}
		}
		this.repaint();
	}

	@Override
	public void setTarget(Notifier newTarget) {
		// TODO Auto-generated method stub
		
	}

}
