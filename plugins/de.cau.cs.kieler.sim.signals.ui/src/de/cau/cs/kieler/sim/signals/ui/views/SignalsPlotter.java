/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.sim.signals.ui.views;

import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Panel;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
import de.cau.cs.kieler.sim.signals.SignalList;
import de.cau.cs.kieler.sim.signals.Signal;

/**
 * The class SignalsPlotter implements the basic plotter for the synchronous
 * signals. It can be zoomed using a zoom level (in percent).
 * 
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 */
public class SignalsPlotter {

	/** The fixed size constants. */
	private final int XSPACE = 25;
	private final int YOFFSET = 40;
	private final int YSPACE = 40;
	private final int XOFFSET = 60;
	private final String SIGNALLABELSAFETYMARGINSPACE = "    ";

	/** The zoomed size variables. */
	private int zoomedXSpace = 25;
	private int zoomedYOffset = 40;
	private int zoomedYSpace = 40;
	private int zoomedXOffset = 60;

	/** The signal list. */
	SignalList signalList = null;

	/** The SWT parent. */
	Composite parent = null;

	/** The signal contents. */
	Panel signalContents = null;

	/** The outer scrolled composite. */
	ScrolledComposite outerScrolledComposite = null;

	/** The outer canvas. */
	FigureCanvas outerCanvas = null;

	/** The color constants. */
	private RGB backgroundColor = new RGB(0, 0, 0); // black
	private RGB signalColor1 = new RGB(100, 100, 255); // light blue
	private RGB signalColor2 = new RGB(200, 200, 255); // lighter blue
	private RGB signalColor0 = new RGB(0, 0, 50); // dark blue
	private RGB signalColorMarker = new RGB(255, 0, 0); // red

	/**
	 * The initial signal name size. This is re-calculated with the maximal
	 * label size each time plot() is called.
	 */
	Dimension signalNameSize = new Dimension(100, 40);

	// -------------------------------------------------------------------------

	/**
	 * Instantiates a new signals plotter.
	 * 
	 * @param parent
	 *            the parent
	 */
	public SignalsPlotter(Composite parent) {
		setParent(parent);
	}

	// -------------------------------------------------------------------------

	/**
	 * Sets the signal list.
	 * 
	 * @param signalList
	 *            the new signal list
	 */
	public void setSignalList(SignalList signalList) {
		this.signalList = signalList;
	}

	// -------------------------------------------------------------------------

	/**
	 * Sets the parent.
	 * 
	 * @param parent
	 *            the new parent
	 */
	public void setParent(Composite parent) {
		this.parent = parent;
	}

	// -------------------------------------------------------------------------

	/**
	 * Sets the focus.
	 */
	public void setFocus() {
		outerScrolledComposite.setFocus();
	}

	// -------------------------------------------------------------------------

	/**
	 * Calculate zoomed values relative to a zoomLevel.
	 * 
	 * @param zoomLevel
	 *            the zoom level
	 */
	private void zoom(int zoomLevel) {
		zoomedXSpace = (XSPACE * zoomLevel) / 100;
		zoomedYOffset = (YOFFSET * zoomLevel) / 100;
		zoomedYSpace = (YSPACE * zoomLevel) / 100;
		zoomedXOffset = (XOFFSET * 1) / 100;
	}

	// -------------------------------------------------------------------------

	/**
	 * Plot with a defined zoomLevel.
	 * 
	 * @param zoomLevel
	 *            the zoom level
	 */
	public void plot(int zoomLevel) {
		// re-calculate zoomed values
		zoom(zoomLevel);

		// if no place to plot, or no data to plot, return.
		if (parent == null || signalList == null)
			return;

		// if no panel exists yet, create a new one
		if (signalContents == null) {
			signalContents = new Panel();
			signalContents.setLayoutManager(new XYLayout());
			signalContents.setBackgroundColor(new Color(Display.getCurrent(),
					backgroundColor));

			outerScrolledComposite = new ScrolledComposite(parent, SWT.BORDER
					| SWT.H_SCROLL | SWT.V_SCROLL);
			outerScrolledComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
			outerScrolledComposite.getHorizontalBar().setIncrement(20);
			outerScrolledComposite.getHorizontalBar().setPageIncrement(200);
			outerScrolledComposite.getVerticalBar().setIncrement(20);
			outerScrolledComposite.getVerticalBar().setPageIncrement(200);
			outerScrolledComposite.setMinSize(0, 0);
			outerScrolledComposite.setExpandHorizontal(true);
			outerScrolledComposite.setExpandVertical(true);

			Composite outerComposite = new Composite(outerScrolledComposite,
					SWT.NONE);

			Layout layout = new FillLayout(SWT.HORIZONTAL);
			outerComposite.setLayout(layout);
			outerScrolledComposite.setContent(outerComposite);

			Composite outerComposite1 = new Composite(outerComposite, SWT.NONE);
			outerComposite1.setLayout(new FillLayout(SWT.HORIZONTAL));
			outerComposite1.setSize(200, outerComposite1.getSize().y);

			outerCanvas = new FigureCanvas(outerComposite1);
			outerCanvas.setContents(signalContents);
		}

		// draw signal view content buffered
		Panel buffer = new Panel();
		buffer.setLayoutManager(new XYLayout());
		buffer.setBackgroundColor(new Color(Display.getCurrent(),
				backgroundColor));

		drawSignals(buffer);
		drawSignalNames(buffer, 0, Label.RIGHT);
		if (signalList.size() > 0 && (signalList.getMaxTick() - signalList.getMinTick() > 0)) {
			// only draw left signal names if there is already data to be displayed
			drawSignalNames(buffer, outerScrolledComposite.getMinWidth()
					- signalNameSize.width, Label.LEFT);
		}
		outerCanvas.setContents(buffer);

		// scroll to the center of selected tick
		long currentTick = signalList.getCurrentTick();
		long minTick = signalList.getMinTick();
		int visibleWidth = outerScrolledComposite.getParent().getSize().y;
		int xScroll = ((int) (currentTick - minTick) * zoomedXSpace
				- (visibleWidth / 2) + signalNameSize.width);
		int yScroll = outerScrolledComposite.getOrigin().y;
		outerScrolledComposite.setOrigin(xScroll, yScroll);

	}

	// -------------------------------------------------------------------------

	/**
	 * Draw all signal present data.
	 * 
	 * @param contents
	 *            the contents
	 */
	private void drawSignals(IFigure contents) {
		int y = zoomedYOffset;
		long maxTick = signalList.getMaxTick();
		long minTick = Math.max(1, signalList.getMinTick());
		long currentTick = signalList.getCurrentTick();
		RGB signalColor = signalColor1;

		outerScrolledComposite.setMinSize((int) (maxTick + 1 - minTick)
				* zoomedXSpace + 2 * signalNameSize.width,
				outerScrolledComposite.getMinHeight());

		for (Signal signal : signalList) {
			Node lastNode = null;

			for (long tick = minTick; tick <= maxTick; tick++) {
				int presentOffset = 0;
				int presentOffsetInverse = -(zoomedYOffset / 2);
				if (signal.isPresent(tick)) {
					presentOffset = -(zoomedYOffset / 2);
					presentOffsetInverse = 0;
				}
				Node nodeS = new Node();
				nodeS.x = ((int) (tick - minTick) * zoomedXSpace + 2 + signalNameSize.width);
				nodeS.y = y + presentOffset + zoomedYOffset / 11;
				nodeS.data = signal;
				Node nodeE = new Node();
				nodeE.x = ((int) (tick - minTick) * zoomedXSpace + zoomedXSpace
						+ 2 + signalNameSize.width);
				nodeE.y = y + presentOffset + zoomedYOffset / 11;
				nodeE.data = signal;

				Node node = new Node();
				Node nodeInverse = new Node();
				node.x = ((int) (tick - minTick) * zoomedXSpace
						+ (zoomedXSpace / 2) + signalNameSize.width);
				node.y = y + presentOffset;
				node.data = signal;
				nodeInverse.x = ((int) (tick - minTick) * zoomedXSpace
						+ (zoomedXSpace / 2) + signalNameSize.width);
				nodeInverse.y = y + presentOffsetInverse;
				nodeInverse.data = signal;

				drawNode(contents, nodeS, signalColor, 0, tick, null);
				drawNode(contents, nodeE, signalColor, 0, tick, null);

				if (lastNode == null) {
					lastNode = nodeE;
				}
				drawEdge(contents, lastNode, nodeS, signalColor);
				drawEdge(contents, nodeS, nodeE, signalColor);
				lastNode = nodeE;

				// if this is the current tick then mark the node in the
				// signalColorMarker color
				if (tick != currentTick) {
					drawNode(contents, node, signalColor, zoomedYOffset / 8,
							tick, signal.getName());
				} else {
					node.y = node.y - zoomedYOffset / 14;
					node.x = node.x - zoomedYOffset / 20;
					drawNode(contents, node, signalColorMarker,
							zoomedYOffset / 5, tick, signal.getName());
				}

				drawNode(contents, nodeInverse, signalColor0,
						zoomedYOffset / 8, tick, signal.getName());

			}

			// toggle color
			if (signalColor == signalColor1) {
				signalColor = signalColor2;
			} else {
				signalColor = signalColor1;
			}

			y += zoomedYSpace;
		}

	}

	// -------------------------------------------------------------------------

	/**
	 * Draw a node include a tooltip text if the signalName is not null.
	 * 
	 * @param contents
	 *            the contents
	 * @param node
	 *            the node
	 * @param signalColor
	 *            the signal color
	 * @param size
	 *            the size
	 * @param tick
	 *            the tick
	 * @param signalName
	 *            the signal name
	 */
	private void drawNode(IFigure contents, Node node, RGB signalColor,
			int size, long tick, String signalName) {
		RectangleFigure dotFigure = new RectangleFigure();
		node.data = dotFigure;
		int xPos = node.x;
		int yPos = node.y;
		dotFigure.setVisible(true);
		dotFigure.setSize(size, size);
		dotFigure.setBackgroundColor(new Color(Display.getCurrent(),
				signalColor));
		dotFigure.setForegroundColor(new Color(Display.getCurrent(),
				signalColor));
		dotFigure.setLocation(new Point(xPos, yPos));
		contents.add(dotFigure);

		if (signalName != null) {
			Label toolTipLabel = new Label();
			toolTipLabel.setText(" " + tick + " / " + signalName + " ");
			dotFigure.setToolTip(toolTipLabel);
		}

		contents.setConstraint(dotFigure, new Rectangle(xPos, yPos, -1, -1));
	}

	// -------------------------------------------------------------------------

	/**
	 * Draw an edge between two nodes.
	 * 
	 * @param contents
	 *            the contents
	 * @param node1
	 *            the node1
	 * @param node2
	 *            the node2
	 * @param signalColor
	 *            the signal color
	 */
	private void drawEdge(IFigure contents, Node node1, Node node2,
			RGB signalColor) {
		PolylineConnection wireFigure = new PolylineConnection();
		wireFigure.setVisible(true);
		wireFigure.setForegroundColor(new Color(Display.getCurrent(),
				signalColor));
		// edge.source is the Node to the left of this edge
		EllipseAnchor sourceAnchor = new EllipseAnchor(
				(RectangleFigure) node1.data);

		// edge.target is the Node to the right of this edge
		EllipseAnchor targetAnchor = new EllipseAnchor(
				(RectangleFigure) node2.data);
		wireFigure.setSourceAnchor(sourceAnchor);
		wireFigure.setTargetAnchor(targetAnchor);
		contents.add(wireFigure);
	}

	// -------------------------------------------------------------------------

	/**
	 * Gets the maximum text width of all signal names including safety margin
	 * space.
	 * 
	 * @param font
	 *            the font
	 * @return the maximum text width
	 */
	private Dimension getMaximumTextWidth(Font font) {
		int maxWidth = 0;
		Dimension maxDimension = signalNameSize;
		for (Signal signal : signalList) {
			Dimension currentDimension = TextUtilities.INSTANCE.getTextExtents(
					SIGNALLABELSAFETYMARGINSPACE + signal.getName()
							+ SIGNALLABELSAFETYMARGINSPACE, font);
			int currentWidth = currentDimension.width;
			if (currentWidth > maxWidth) {
				maxWidth = currentWidth;
				maxDimension = currentDimension;
			}
		}
		return maxDimension;
	}

	// -------------------------------------------------------------------------

	/**
	 * Draw the signal names. Ensure safety margin space left and right.
	 * 
	 * @param contents
	 *            the contents
	 * @param xPos
	 *            the xPos
	 */
	private void drawSignalNames(IFigure contents, int xPos, int align) {

		outerScrolledComposite.setMinSize(outerScrolledComposite.getMinWidth(),
				signalList.size() * zoomedYSpace + (zoomedYOffset / 2));
		Font font = new Font(Display.getCurrent(), "Arial",
				(zoomedYOffset / 4), SWT.NORMAL);

		// update signal name width again
		signalNameSize = getMaximumTextWidth(font);

		int y = zoomedYOffset / 2;
		RGB signalColor = signalColor1;
		for (Signal signal : signalList) {
			Label labelFigure = new Label();
			labelFigure.setText(SIGNALLABELSAFETYMARGINSPACE + signal.getName()
					+ SIGNALLABELSAFETYMARGINSPACE);
			labelFigure.setVisible(true);
			labelFigure.setFont(font);
			labelFigure.setLabelAlignment(align);
			labelFigure.setSize(signalNameSize.width, signalNameSize.height);
			labelFigure.setForegroundColor(new Color(Display.getCurrent(),
					signalColor));
			labelFigure.setLocation(new Point(xPos - zoomedXOffset, y));
			contents.add(labelFigure);
			y += zoomedYSpace;
			// toggle color
			if (signalColor == signalColor1) {
				signalColor = signalColor2;
			} else {
				signalColor = signalColor1;
			}
		}
	}

	// -------------------------------------------------------------------------

}
