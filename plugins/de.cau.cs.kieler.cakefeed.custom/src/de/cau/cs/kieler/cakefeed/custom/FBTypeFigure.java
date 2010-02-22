package de.cau.cs.kieler.cakefeed.custom;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Color;

import de.cau.cs.kieler.cakefeed.FB;
import de.cau.cs.kieler.cakefeed.FBType;
import de.cau.cs.kieler.cakefeed.IFInputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.InputWith;
import de.cau.cs.kieler.cakefeed.OutputWith;
import de.cau.cs.kieler.core.ui.figures.IAttributeAwareFigure;

public class FBTypeFigure extends Shape implements Adapter, IAttributeAwareFigure {

	protected EObject modelElement;
	protected int numOfEvents;
	protected int numOfVars;
	protected int maxInputWiths;
	protected int maxOutputWiths;
	protected Rectangle ctrlRectangle;
	protected Rectangle dataRectangle;
	
	public FBTypeFigure() {
		super();
		numOfEvents = 1;
		numOfVars = 1;
		maxInputWiths = 1;
		maxOutputWiths = 1;
		ctrlRectangle = new Rectangle();
		dataRectangle = new Rectangle();
		computeRectangles();
		
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
	
	public int getMaxInputWiths() {
		return maxInputWiths;
	}
	
	public int getMaxOutputWiths() {
		return maxOutputWiths;
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		RGB greyblue = new RGB(200, 200, 255);
		this.setBackgroundColor(DiagramColorRegistry.getInstance().getColor(greyblue));
		PointList points = computePoints(getBounds());
		graphics.fillPolygon(points);
	}

	private PointList computePoints(Rectangle bounds) {
		int s = numOfEvents + numOfVars + 1;
		
		int w = bounds.width;
		int h = bounds.height;
		
		int x0 = bounds.x;
		int y0 = bounds.y;
		int x1 = x0 + w / 10;
		int y1 = y0 + h / s * numOfEvents;
		int x2 = x0 + w - w / 10;
		int y2 = y0 + h / s * (numOfEvents + 1);
		int x3 = x0 + w;
		int y3 = y0 + h;
		
		PointList pointList = new PointList();
		pointList.addPoint(x0, y0);
		pointList.addPoint(x3-1, y0);
		pointList.addPoint(x3-1, y1);
		pointList.addPoint(x2, y1);
		pointList.addPoint(x2, y2);
		pointList.addPoint(x3-1, y2);
		pointList.addPoint(x3-1, y3-1);
		pointList.addPoint(x0, y3-1);
		pointList.addPoint(x0, y2);
		pointList.addPoint(x1, y2);
		pointList.addPoint(x1, y1);
		pointList.addPoint(x0, y1);
		return pointList;
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		this.setForegroundColor(ColorConstants.black);
		PointList points = computePoints(getBounds()); //test
		graphics.drawPolygon(points);
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
		if ((modelElement instanceof FBType) || (modelElement instanceof FB)) {
			FBType fbtype = null;
			if (modelElement instanceof FBType) {
				fbtype = (FBType)modelElement;
			} else {
				fbtype = (FBType)((FB)modelElement).getType();
			}
			if (fbtype != null) {
				numOfEvents = Math.max(fbtype.getInputEvents().size(), fbtype.getOutputEvents().size());
				numOfEvents = Math.max(numOfEvents, 1);
				numOfVars = Math.max(fbtype.getInputVars().size(), fbtype.getOutputVars().size());
				numOfVars = Math.max(numOfVars, 1);
			
				maxInputWiths = 1;
				int curInputWiths;
				for (IFInputEvent ie : fbtype.getInputEvents()) {
					curInputWiths = 0;
					EList<InputWith> with = ie.getWith();
					if (with != null) {
						curInputWiths += with.size();
					}
					if (curInputWiths > maxInputWiths) {
						maxInputWiths = curInputWiths;
					}
				}
				
				maxOutputWiths = 1;
				int curOutputWiths;
				for (IFOutputEvent oe : fbtype.getOutputEvents()) {
					curOutputWiths = 0;
					EList<OutputWith> with = oe.getWith();
					if (with != null) {
						curOutputWiths += with.size();
					}
					if (curOutputWiths > maxInputWiths) {
						maxInputWiths = curOutputWiths;
					}
				}
			} else {
				numOfEvents = 1;
				numOfVars = 1;
			}
		}
		this.computeRectangles();
		this.repaint();
	}

	public void computeRectangles() {
		PointList points = computePoints(/*getCorrectBounds()*/getBounds());
		ctrlRectangle.x = points.getPoint(0).x;
		ctrlRectangle.y = points.getPoint(0).y;
		ctrlRectangle.width = points.getPoint(2).x - points.getPoint(0).x;
		ctrlRectangle.height = points.getPoint(2).y - points.getPoint(0).y;
		
		dataRectangle.x = points.getPoint(8).x;
		dataRectangle.y = points.getPoint(8).y;
		dataRectangle.width = points.getPoint(6).x - points.getPoint(8).x;
		dataRectangle.height = points.getPoint(6).y - points.getPoint(8).y;
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
    
    public Rectangle getCtrlRectangle() {
    	return ctrlRectangle;
    }
    
    public Rectangle getDataRectangle() {
    	return dataRectangle;
    }

}
