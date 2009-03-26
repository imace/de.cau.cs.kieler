package de.cau.cs.kieler.ssm2.custom;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
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
	protected AbstractLayout layout;
	
	public AttributeAwareFigure() {
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
	
	public void setDefaultFigure(Figure f) {
		defaultFigure = f;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Rectangle newBounds = new Rectangle();
		newBounds.x = this.getBounds().x + 1;
		newBounds.y = this.getBounds().y + 1;
		newBounds.width = this.getBounds().width - 1;
		newBounds.height = this.getBounds().height - 1;
		currentFigure.setBounds(newBounds);
		currentFigure.paint(g);
	}
	
	public Figure getCurrentFigure() {
		return currentFigure;
	}
	
	public void setCurrentFigure(Figure f) {
		currentFigure = f;
	}
	
	public void addConditionalFigure(ConditionalFigure cf) {
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
		try {	
			for (ConditionalFigure cf : conditionalFigureList) {
				boolean fulfilled = true;
				for (Condition c : cf.getConditions()) {
					if (!(c.isValid(modelElement))) {
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
		catch (Exception e) {
			
		}
		this.repaint();
	}

	public void setTarget(Notifier newTarget) {
		// TODO Auto-generated method stub
		
	}
}
