package de.cau.cs.kieler.cakefeed.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AbstractHintLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.BorderItemContainerFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

public class FBTypeLayout extends StackLayout {}

/*public class FBTypeLayout extends AbstractHintLayout {

	protected List<IFigure> inputEventFigures;
	protected List<IFigure> outputEventFigures;
	protected List<IFigure> inputVarFigures;
	protected List<IFigure> outputVarFigures;
	protected List<IFigure> labels;
	protected List<IFigure> compartments;
	
	protected Rectangle clientArea;
	protected Rectangle ctrlArea;
	protected Rectangle dataArea;
	
	protected int numOfEvents;
	protected int numOfVars;
	
	protected int maxInputWiths;
	protected int maxOutputWiths;
	
	protected final int portSize = 6;
	protected final int withSize = 30;
	
	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint,
			int hHint) {
        return container.getSize();
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
			
			maxInputWiths = fbtypefigure.getMaxInputWiths();
			maxOutputWiths = fbtypefigure.getMaxOutputWiths();
			
			clientArea = fbtypefigure.getClientArea();
			
			ctrlArea = calculateCtrlArea();
			dataArea = calculateDataArea();
				
			inputEventFigures = getPortsOfType(fbtypefigure, IFIEFigure.class);
			outputEventFigures = getPortsOfType(fbtypefigure, IFOEFigure.class);
			inputVarFigures = getPortsOfType(fbtypefigure, IFIVFigure.class);
			outputVarFigures = getPortsOfType(fbtypefigure, IFOVFigure.class);
			labels = getFiguresOfType(fbtypefigure, WrappingLabel.class);
			compartments = getFiguresOfType(fbtypefigure, ResizableCompartmentFigure.class);
			
			layoutLabelsAndCompartments();
			layoutPorts(inputEventFigures, true, true);
			layoutPorts(outputEventFigures, true, false);
			layoutPorts(inputVarFigures, false, true);
			layoutPorts(outputVarFigures, false, false);
		}
	}

	private List<IFigure> getPortsOfType(FBTypeFigure fbtypefigure,
			Class<?> class1) {
		List<IFigure> results = new ArrayList<IFigure>();
		IFigure fig = fbtypefigure.getParent();
		if (fig instanceof DefaultSizeNodeFigure) {
			DefaultSizeNodeFigure node = (DefaultSizeNodeFigure)fig;
			fig = node.getParent();
			if (fig instanceof BorderedNodeFigure) {
				BorderedNodeFigure bNode = (BorderedNodeFigure)fig;
				fig = null;
				for (Object c : bNode.getChildren()) {
					if (c instanceof BorderItemContainerFigure) {
						BorderItemContainerFigure bICFig = (BorderItemContainerFigure)c;
						for (Object d : bICFig.getChildren()) {
							if (d instanceof BorderedNodeFigure) {
								BorderedNodeFigure bNFig = (BorderedNodeFigure)d;
								for (Object e : bNFig.getChildren()) {
									if (e instanceof DefaultSizeNodeFigure) {
										DefaultSizeNodeFigure dSNFig = (DefaultSizeNodeFigure)e;
										for (Object f : dSNFig.getChildren()) {
											if (f.getClass().equals(class1)) {
												results.add((IFigure)f);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return results;
	}

	private void layoutPorts(List<IFigure> figures, boolean isCtrl, boolean isLeft) {
		Rectangle newBounds = new Rectangle();
		Rectangle reference;
		int line;
		int offset;
		int numOfFigures = figures.size();
		
		if (isCtrl) {
			reference = ctrlArea;
		} else {
			reference = dataArea;
		}
		if (isLeft) {
			line = reference.x;
		} else {
			line = reference.x + reference.width;
		}
		
		for (IFigure f : figures) {
			if (isLeft) {
				newBounds.x = line - portSize - maxInputWiths * withSize;
			} else {
				newBounds.x = line;
			}
			offset = reference.height / numOfFigures;
			newBounds.y = reference.y + offset * figures.indexOf(f) + offset / 2 - portSize / 2;
			if (isLeft) {
				newBounds.width = maxInputWiths * withSize;
			}
			else {
				newBounds.width = maxOutputWiths * withSize;
			}
			newBounds.height = portSize;
			f.setBounds(newBounds);
		}
	}

	private void layoutLabelsAndCompartments() {
		int x = clientArea.x;
		int y = clientArea.y;
		int w = clientArea.width;
		int h = clientArea.height;
		Rectangle newBounds = new Rectangle();
		
		for (IFigure label : labels) {
			int pW = label.getPreferredSize().width;
			int pH = label.getPreferredSize().height;
			
			newBounds.x = Math.max(x + (w - pW) / 2, 0);
			newBounds.y = y;
			newBounds.width = Math.min(pW, w);
			newBounds.height = pH;
			label.setBounds(newBounds);
			y += newBounds.height;
		}
		for (IFigure comp : compartments) {
			newBounds.x = x;
			newBounds.y = y;
			newBounds.width = w;
			newBounds.height = h / compartments.size();
			comp.setBounds(newBounds);
			y += newBounds.height;
		}
		
	}

	@SuppressWarnings("unchecked")
	private List<IFigure> getFiguresOfType(IFigure parent,
			Class<?> class1) {
		List<Object> children = parent.getChildren();
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
		return dataArea;
	}

	private Rectangle calculateCtrlArea() {
		Rectangle ctrlArea = new Rectangle();
		ctrlArea.x = clientArea.x;
		ctrlArea.y = clientArea.y;
		ctrlArea.width = clientArea.width;
		ctrlArea.height = clientArea.height / (numOfEvents + numOfVars + 1) * numOfEvents;
		return ctrlArea;
	}

}*/
