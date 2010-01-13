package de.cau.cs.kieler.cakefeed.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AbstractHintLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

public class FBTypeLayout extends /*AbstractHintLayout*/ StackLayout {/*

	protected Rectangle clientArea;
	protected Rectangle ctrlArea;
	//protected Rectangle typeArea;
	protected Rectangle dataArea;
	
	protected List<IFigure> inputEventFigures;
	protected List<IFigure> outputEventFigures;
	protected List<IFigure> inputVarFigures;
	protected List<IFigure> outputVarFigures;
	protected List<IFigure> otherFigures;
	
	protected int numOfEvents;
	protected int numOfVars;
	
	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint,
			int hHint) {
		Dimension size = calculateMinimumSize(container, wHint, hHint);
        return size;
	}

	@Override
	public void layout(IFigure container) {
		if (!container.isVisible()) {
			return;
		}
		if (container instanceof FBTypeFigure) {
			FBTypeFigure fbtypefigure = (FBTypeFigure)container;
			numOfEvents = Math.max(fbtypefigure.getNumOfEvents(), 1);
			numOfVars = Math.max(fbtypefigure.getNumOfVars(), 1);
			
			clientArea = fbtypefigure.getClientArea();
			
			ctrlArea = calculateCtrlArea();
			//typeArea = calculateTypeArea();
			dataArea = calculateDataArea();
			
			Class<?>[] classes = {IFIEFigure.class, IFOEFigure.class, 
					IFIVFigure.class, IFOVFigure.class};
			
			inputEventFigures = getFiguresOfType(fbtypefigure, IFIEFigure.class);
			outputEventFigures = getFiguresOfType(fbtypefigure, IFOEFigure.class);
			inputVarFigures = getFiguresOfType(fbtypefigure, IFIVFigure.class);
			outputVarFigures = getFiguresOfType(fbtypefigure, IFOVFigure.class);
			otherFigures = getFiguresNotOfTypes(fbtypefigure, classes);
			
			layoutInputEventFigures();
			layoutOutputEventFigures();
			layoutInputVarFigures();
			layoutOutputVarFigures();
			layoutOtherFigures();
		}
	}

	private void layoutOtherFigures() {
		// TODO Auto-generated method stub
		
	}

	private void layoutOutputVarFigures() {
		// TODO Auto-generated method stub
		
	}

	private void layoutInputVarFigures() {
		// TODO Auto-generated method stub
		
	}

	private void layoutOutputEventFigures() {
		// TODO Auto-generated method stub
		
	}

	private void layoutInputEventFigures() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	private List<IFigure> getFiguresNotOfTypes(FBTypeFigure fbtypefigure,
			Class<?>[] classes) {
		List<Object> children = fbtypefigure.getChildren();
		List<IFigure> figures = new ArrayList();
		boolean isOkay;
		for (Object c : children) {
			isOkay = true;
			for (Class<?> class1 : classes) {
				if (c.getClass().equals(class1)) {
					isOkay = false;
				}
			}
			if ((c instanceof IFigure) && (isOkay)) {
				figures.add((IFigure)c);
			}
		}
		return figures;
	}

	@SuppressWarnings("unchecked")
	private List<IFigure> getFiguresOfType(FBTypeFigure fbtypefigure,
			Class<?> class1) {
		List<Object> children = fbtypefigure.getChildren();
		List<IFigure> figures = new ArrayList();
		for (Object c : children) {
			if ((c instanceof IFigure) && (c.getClass().equals(class1))) {
				figures.add((IFigure)c);
			}
		}
		return figures;
	}

	private Rectangle calculateDataArea() {
		Rectangle dataArea = new Rectangle();
		dataArea.x = clientArea.x;
		dataArea.y = clientArea.y + clientArea.height / (numOfEvents + numOfVars + 1) * (numOfEvents + 1);
		dataArea.width = clientArea.width;
		dataArea.height = clientArea.height / (numOfEvents + numOfVars + 1) * numOfVars;
		return ctrlArea;
	}

	*//*private Rectangle calculateTypeArea() {
		
		return null;
	}*//*

	private Rectangle calculateCtrlArea() {
		Rectangle ctrlArea = new Rectangle();
		ctrlArea.x = clientArea.x;
		ctrlArea.y = clientArea.y;
		ctrlArea.width = clientArea.width;
		clientArea.height = clientArea.height / (numOfEvents + numOfVars + 1) * numOfEvents;
		return ctrlArea;
	}
*/
}
