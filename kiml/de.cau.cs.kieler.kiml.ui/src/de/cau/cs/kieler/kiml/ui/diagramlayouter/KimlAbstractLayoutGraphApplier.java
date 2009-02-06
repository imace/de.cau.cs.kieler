/*******************************************************************************
 * Copyright (c) 2009 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.ui.diagramlayouter;

import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel;

/**
 * The abstract base class for all LayoutGraphAppliers. <br/>
 * Implementing classes must extend <code>doApplyLayoutGraph</code> which uses
 * the information of the KLayoutGraph to update the diagram and
 * <code>updatePreferences</code> to set preferences used during this step. <br/>
 * The final method <code>applyLayoutGraph</code> is responsible for the correct
 * collaboration of the single steps, and for the correct passing of the
 * information from the {@link KimlLayoutInformation} class. <br/>
 * The implementation of <code>doApplyLayout</code> can rely on populated maps
 * for the mapping of KLayoutGraph elements to EditParts and on initialized
 * objects of <code>layoutRootPart</code> and <code>layoutGraph</code>
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * 
 */
public abstract class KimlAbstractLayoutGraphApplier {

	/*
	 * some strings used when creating the concrete LayoutGraphAppliers via the
	 * extension point mechanism
	 */
	public static final String EXTENSION_POINT_ID = "de.cau.cs.kieler.kiml.ui.kimlLayoutGraphApplier";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_EDITOR_ID = "editor_id";
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_ICON = "icon";

	/* the mappings of KLayoutGraph LAYOUT elements to EditParts */
	protected Map<KLayoutNode, GraphicalEditPart> layoutNode2EditPart;
	protected Map<KLayoutEdge, ConnectionEditPart> layoutEdge2EditPart;
	protected Map<KLayoutPort, GraphicalEditPart> layoutPort2EditPart;

	/* the mappings of KLayoutGraph LABEL elements to LabelEditParts */
	protected Map<KNodeLabel, LabelEditPart> nodeLabel2EditPart;
	protected Map<KEdgeLabel, LabelEditPart> edgeLabel2EditPart;
	protected Map<KPortLabel, LabelEditPart> portLabel2EditPart;

	/*
	 * the layoutRootPart where the layout should start with and an instance of
	 * the layout graph
	 */
	protected GraphicalEditPart layoutRootPart;
	protected KLayoutGraph layoutGraph;

	/**
	 * Is responsible for the correct collaboration of the single steps, and for
	 * the correct passing of the information from the
	 * {@link KimlLayoutInformation} class.
	 * 
	 * @param layoutInformation
	 *            The KimlLayoutInformation structure with the KLayoutGraph, the
	 *            layoutRootPart and the mapping of EditParts to the
	 *            KLayoutGraph
	 */
	protected final void applyLayoutGraph(
			KimlLayoutInformation layoutInformation) {

		/* first get the preference needed for the application of the layout */
		updatePreferences();

		/*
		 * populate the local fields used in the doApplyLayout step with the
		 * information passed in the KimlLayoutInformation structure
		 */
		layoutNode2EditPart = layoutInformation.layoutNode2EditPart;
		layoutEdge2EditPart = layoutInformation.layoutEdge2EditPart;
		layoutPort2EditPart = layoutInformation.layoutPort2EditPart;
		nodeLabel2EditPart = layoutInformation.nodeLabel2EditPart;
		edgeLabel2EditPart = layoutInformation.edgeLabel2EditPart;
		portLabel2EditPart = layoutInformation.portLabel2EditPart;
		layoutRootPart = layoutInformation.layoutRootPart;
		layoutGraph = layoutInformation.layoutGraph;

		/*
		 * finally, trigger the actual appliance of the layout information to
		 * the diagram elements
		 */
		doApplyLayoutGraph();
	}

	/**
	 * Implementation should use the layout information provided by the
	 * KLayoutGraph and utilize the mappings to lay out the diagram elements. <br/>
	 * The implementation of <code>doApplyLayout</code> can rely on populated
	 * maps for the mapping of KLayoutGraph elements to EditParts and on
	 * initialized objects of <code>layoutRootPart</code> and
	 * <code>layoutGraph</code>.
	 */
	protected abstract void doApplyLayoutGraph();

	/**
	 * Implementation should fetch preference settings needed during the
	 * doApplyLayout step.
	 */
	protected abstract void updatePreferences();
	
	/**
	 * Helper function used when translating the location for a connection or a
	 * connection label as provided by the layout provider to the connection
	 * layer. The layout provider returns relative positions for the connection
	 * points for every level of a possible hierarchy, whereas in the GMF
	 * diagram all the connections are draw plainly on the special connection
	 * layer with absolute coordinates.
	 * 
	 * @param point
	 *            The Point which should be translated
	 * @param from
	 *            The Figure with the coordinate system from which the given
	 *            Point should be translated
	 * @param to
	 *            The Figure with the coordinate system to which the given Point
	 *            should be translated
	 * @return The translated Point with its location now in the coordinate
	 *         system of the <b>to</b> Figure
	 */
	protected Point translateFromTo(Point point, IFigure from, IFigure to) {
		from.translateToAbsolute(point);
		to.translateToRelative(point);
		return point;
	}

}
