package de.cau.cs.kieler.cakefeed.custom;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EObject;

import de.cau.cs.kieler.cakefeed.FBType;

public class FBTypeFigure extends Shape implements Adapter {

	protected EObject modelElement;
	protected int numOfEvents;
	protected int numOfVars;
	
	public FBTypeFigure() {
		super();
		numOfEvents = 1;
		numOfVars = 1;
	}
	
	public EObject getModelElement() {
		return modelElement;
	}
	
	public int getNumOfEvents() {
		return numOfEvents;
	}
	
	public int getNumOfVars() {
		return numOfVars;
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		this.setBackgroundColor(ColorConstants.lightGray);
		PointList points = computePoints(getBounds());
		graphics.drawPolygon(points);
	}

	private PointList computePoints(Rectangle bounds) {
		int s = numOfEvents + numOfVars + 1;
		int h0 = bounds.height / s * (numOfEvents);
		int h1 = bounds.height / s * (numOfEvents + 1);
		int o = bounds.width / 6;
		int w0 = bounds.width - o;
		int w1 = bounds.x + o;
		
		PointList pointList = new PointList();
		pointList.addPoint(bounds.x, bounds.y);
		pointList.addPoint(bounds.width, bounds.y);
		pointList.addPoint(bounds.width, h0);
		pointList.addPoint(w0, h0);
		pointList.addPoint(w0, h1);
		pointList.addPoint(bounds.width, h1);
		pointList.addPoint(bounds.width, bounds.height);
		pointList.addPoint(bounds.x, bounds.height);
		pointList.addPoint(bounds.x, h1);
		pointList.addPoint(w1, h1);
		pointList.addPoint(w1, h0);
		pointList.addPoint(bounds.x, h0);
		return pointList;
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		this.setForegroundColor(ColorConstants.black);
		
		float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
	    int inset1 = (int)Math.floor(lineInset);
	    int inset2 = (int)Math.ceil(lineInset);

	    Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
	    r.x += inset1 ; 
	    r.y += inset1; 
	    r.width -= inset1 + inset2;
	    r.height -= inset1 + inset2;
	    
	    PointList points = computePoints(r);
		graphics.fillPolygon(points);
	}

	@Override
	public Notifier getTarget() {
		return modelElement;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		// always return false
		return false;
	}

	@Override
	public void notifyChanged(Notification notification) {
		if (modelElement instanceof FBType) {
			FBType fbtype = (FBType)modelElement;
			numOfEvents = Math.max(fbtype.getInputEvents().size(), fbtype.getOutputEvents().size());
			numOfEvents = Math.max(numOfEvents, 1);
			numOfVars = Math.max(fbtype.getInputVars().size(), fbtype.getOutputVars().size());
			numOfVars = Math.max(numOfVars, 1);
		}
		this.repaint();
	}

	@Override
	public void setTarget(Notifier newTarget) {
		// do not react to target change, as only {@link listenTo} may be used to change the target	
	}
	
    public void listenTo(final EObject object) {
        if (modelElement != null) {
            modelElement.eAdapters().remove(this);
        }
        modelElement = object;
        modelElement.eAdapters().add(this);  
    }

}
