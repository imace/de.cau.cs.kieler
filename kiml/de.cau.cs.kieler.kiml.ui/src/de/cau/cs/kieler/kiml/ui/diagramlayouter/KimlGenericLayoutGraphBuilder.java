/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
package de.cau.cs.kieler.kiml.ui.diagramlayouter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.impl.ViewImpl;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import de.cau.cs.kieler.kiml.ui.helpers.KimlMetricsHelper;
import de.cau.cs.kieler.kiml.ui.preferences.PreferenceConstants;

/**
 * A generic implementation of the {@link KimlGenericLayoutGraphBuilder}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * 
 */
public class KimlGenericLayoutGraphBuilder extends
		KimlAbstractLayoutGraphBuilder {

	/* preference setting */
	private int prefInsetsTop = 0;
	private int prefInsetsLeft = 0;
	private int prefInsetsBottom = 0;
	private int prefInsetsRight = 0;

	private Map<GraphicalEditPart, KLayoutNode> graphicalEditPart2LayoutNode = new HashMap<GraphicalEditPart, KLayoutNode>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphBuilder
	 * #doBuildLayoutGraph()
	 */
	@Override
	protected void doBuildLayoutGraph() {

		if (layoutRootPart instanceof NodeEditPart) {
			NodeEditPart rootEditPart = (NodeEditPart) layoutRootPart;

			/* set ID */
			EObject currentEObject = ((ViewImpl) rootEditPart.getModel())
					.getElement();
			layoutGraph.setIdString(kimlAdapterLabelProvider
					.getKimlLongLabel(currentEObject));

			/* set location */
			layoutGraph.getLayout().getLocation().setX(
					rootEditPart.getFigure().getBounds().x);
			layoutGraph.getLayout().getLocation().setY(
					rootEditPart.getFigure().getBounds().y);

			/* set size */
			layoutGraph.getLayout().getSize().setHeight(
					rootEditPart.getFigure().getBounds().height);
			layoutGraph.getLayout().getSize().setWidth(
					rootEditPart.getFigure().getBounds().width);

			/* set LayouterName and LayoutType if root is ShapeNodeEditPart */
			if (rootEditPart instanceof ShapeNodeEditPart) {
				layoutGraph
						.getLayout()
						.setLayouterName(
								KimlGMFLayoutHintHelper
										.getContainedElementsLayouterName((ShapeNodeEditPart) rootEditPart));
				layoutGraph
						.getLayout()
						.setLayoutType(
								KimlGMFLayoutHintHelper
										.getContainedElementsLayoutType((ShapeNodeEditPart) rootEditPart));
			}

			/* map the root EditPart to the top KLayoutNode */
			graphicalEditPart2LayoutNode.put(rootEditPart, layoutGraph);
			layoutNode2EditPart.put(layoutGraph, rootEditPart);

			/* wander recursively through the diagram */
			buildLayoutGraphRecursively(rootEditPart, layoutGraph);
		}
		/*
		 * if the rootPart was a complete Diagram, that is when clicked into the
		 * empty diagram background space, start with its children.
		 */
		else if (layoutRootPart instanceof DiagramEditPart) {
			/*
			 * set information about LayouterName and LayoutType
			 */
			KLayoutType layoutType = KLayoutType.DEFAULT;
			String layouterName = "";
			layoutType = KimlGMFLayoutHintHelper
					.getContainedElementsLayoutType((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) layoutRootPart);
			layouterName = KimlGMFLayoutHintHelper
					.getContainedElementsLayouterName((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) layoutRootPart);
			layoutGraph.getLayout().setLayoutType(layoutType);
			layoutGraph.getLayout().setLayouterName(layouterName);
			graphicalEditPart2LayoutNode.put(layoutRootPart, layoutGraph);
			layoutNode2EditPart.put(layoutGraph, layoutRootPart);
			buildLayoutGraphRecursively(layoutRootPart, layoutGraph);
		}
	}

	/**
	 * Recursive helper function for the sub elements of a composite element.
	 * 
	 * @param currentEditPart
	 *            The GraphicalEditPart which children will be processed
	 * @param currentLayoutNode
	 *            The corresponding KLayoutNode
	 */
	private void buildLayoutGraphRecursively(GraphicalEditPart currentEditPart,
			KLayoutNode currentLayoutNode) {

		/*
		 * List to save the information about the connection. Connection can
		 * only be added, when source AND target state is in the KLayoutGraph,
		 * so process the connection when all sub states of a region have been
		 * added.
		 */
		ArrayList<ConnectionEditPart> connections = new ArrayList<ConnectionEditPart>();

		/* iterate through the children of the element */
		for (Object obj : currentEditPart.getChildren()) {

			/* if true, Emma has a real EditPart with contents. */
			if (obj instanceof NodeEditPart) {

				NodeEditPart childNodeEditPart = (NodeEditPart) obj;
				KLayoutNode childLayoutNode = KimlLayoutUtil
						.createInitializedLayoutNode();
				Rectangle childBounds = childNodeEditPart.getFigure()
						.getBounds();

				/* store all the connections to process them later */
				for (Object conn : childNodeEditPart.getTargetConnections()) {
					if (conn instanceof ConnectionEditPart) {
						connections.add((ConnectionEditPart) conn);
					}
				}

				/* set location */
				childLayoutNode.getLayout().getLocation().setX(childBounds.x);
				childLayoutNode.getLayout().getLocation().setY(childBounds.y);

				/* set size */
				childLayoutNode.getLayout().getSize().setHeight(
						childBounds.height);
				childLayoutNode.getLayout().getSize().setWidth(
						childBounds.width);

				/* set ID */
				EObject currentEObject = ((ViewImpl) childNodeEditPart
						.getModel()).getElement();
				childLayoutNode.setIdString(kimlAdapterLabelProvider
						.getKimlLongLabel(currentEObject));

				/*
				 * set information about LayouterName and LayoutType
				 */
				KLayoutType layoutType = KLayoutType.DEFAULT;
				String layouterName = "";
				layoutType = KimlGMFLayoutHintHelper
						.getContainedElementsLayoutType((ShapeNodeEditPart) childNodeEditPart);
				layouterName = KimlGMFLayoutHintHelper
						.getContainedElementsLayouterName((ShapeNodeEditPart) childNodeEditPart);
				childLayoutNode.getLayout().setLayoutType(layoutType);
				childLayoutNode.getLayout().setLayouterName(layouterName);

				/* add node */
				currentLayoutNode.getChildNodes().add(childLayoutNode);

				/* keep track of mapping between elements */
				graphicalEditPart2LayoutNode.put(childNodeEditPart,
						childLayoutNode);
				layoutNode2EditPart.put(childLayoutNode, childNodeEditPart);

				/* and process the child as new current */
				buildLayoutGraphRecursively(childNodeEditPart, childLayoutNode);
			}

			/*
			 * If it is ShapeCompartmentEditPart, Emma needs the children of it
			 * to add to new KLayoutNodes. She handles possible insets, which
			 * may result from labels and other stuff.
			 */
			if (obj instanceof ShapeCompartmentEditPart
					&& ((ShapeCompartmentEditPart) obj).getChildren().size() != 0) {

				KInsets parentInsets = graphicalEditPart2LayoutNode.get(
						((GraphicalEditPart) obj).getParent()).getLayout()
						.getInsets();
				parentInsets.setTop(prefInsetsTop);
				parentInsets.setLeft(prefInsetsLeft);
				parentInsets.setBottom(prefInsetsBottom);
				parentInsets.setRight(prefInsetsRight);

				buildLayoutGraphRecursively((GraphicalEditPart) obj,
						currentLayoutNode);

			}
			/* label handling */
			if (obj instanceof GraphicalEditPart) {

				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) obj;
				IFigure labelFigure = graphicalEditPart.getFigure();
				if (labelFigure instanceof WrappingLabel) {

					/*
					 * handling of the label, in most cases a small symbol is
					 * drawn left to the label. Emma must enlarge the
					 * label(text), to let the layout provider set the size
					 * properly.
					 */
					String text = ((WrappingLabel) labelFigure).getText();

					graphicalEditPart2LayoutNode.get(
							graphicalEditPart.getParent()).getLabel().setText(
							text.concat("XX"));
					graphicalEditPart2LayoutNode.get(
							graphicalEditPart.getParent()).setIdString(text);
				} else if (labelFigure instanceof Label) {
					String text = ((Label) labelFigure).getText();

					graphicalEditPart2LayoutNode.get(
							graphicalEditPart.getParent()).getLabel().setText(
							text.concat("XX"));
					graphicalEditPart2LayoutNode.get(
							graphicalEditPart.getParent()).setIdString(text);
				}
			}
		}
		/*
		 * Finally process all the connections, as Emma has build all the needed
		 * KLayoutNodes which act as source and target.
		 */
		processConnections(connections);
	}

	/**
	 * This function creates new KEdges and takes care of the labels for each
	 * connection identified in the <code>buildLayoutGraphRecursively</code>
	 * step before.
	 * 
	 * @param connections
	 *            The connections that were build for a certain Node before.
	 */
	private void processConnections(ArrayList<ConnectionEditPart> connections) {

		/* iterate through all the connections of an compartment element */
		for (ConnectionEditPart connection : connections) {

			/*
			 * create the KLayoutEdge. The KLayoutEdge does not need to be added
			 * explicitly to the KLayoutGraph, but exists in it through the
			 * EOppositeReference of EMF.
			 */
			KLayoutEdge edge = KimlLayoutUtil.createInitializedEdge();
			edge.setSource(graphicalEditPart2LayoutNode.get(connection
					.getSource()));
			edge.setTarget(graphicalEditPart2LayoutNode.get(connection
					.getTarget()));
			layoutEdge2EditPart.put(edge, connection);

			/*
			 * Process the label, at the moment 3 are hard coded.
			 * 
			 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			 * SOURCE and TARGET is exchanged when defining it in the.gmfgen
			 * file. So if Emma sets a label to be placed as TARGET on a
			 * connection (transition in the SSM case), then the label will show
			 * up next to the source node in the diagram editor. So correct it
			 * here, very ugly.
			 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			 */
			for (Object obj : connection.getChildren()) {
				if (obj instanceof LabelEditPart) {
					LabelEditPart labelEditPart = (LabelEditPart) obj;
					KDimension labelSize = KimlMetricsHelper
							.dimension2KDimension(labelEditPart.getFigure()
									.getBounds().getSize());

					// head label
					if (labelEditPart.getKeyPoint() == ConnectionLocator.SOURCE) {
						String headLabel = "";

						if ((headLabel.equals(""))
								&& (labelEditPart.getFigure() instanceof WrappingLabel))
							headLabel = ((WrappingLabel) labelEditPart
									.getFigure()).getText();

						if (!headLabel.equals("")) {
							KEdgeLabel hLabel = KimlLayoutUtil
									.createInitializedEdgeLabel();
							hLabel.getLabelLayout().setLabelPlacement(
									KEdgeLabelPlacement.HEAD);
							hLabel.getLabelLayout().setSize(labelSize);
							hLabel.setText(headLabel);
							edge.getLabel().add(hLabel);
							edgeLabel2EditPart.put(hLabel, labelEditPart);
						}
					}

					// middle label
					if (labelEditPart.getKeyPoint() == ConnectionLocator.MIDDLE) {
						String midLabel = "";

						if ((midLabel.equals(""))
								&& (labelEditPart.getFigure() instanceof WrappingLabel))
							midLabel = ((WrappingLabel) labelEditPart
									.getFigure()).getText();

						if (!midLabel.equals("")) {
							KEdgeLabel mLabel = KimlLayoutUtil
									.createInitializedEdgeLabel();
							mLabel.getLabelLayout().setLabelPlacement(
									KEdgeLabelPlacement.CENTER);
							mLabel.getLabelLayout().setSize(labelSize);
							mLabel.setText(midLabel);
							edge.getLabel().add(mLabel);
							edgeLabel2EditPart.put(mLabel, labelEditPart);
						}
					}

					// tail label
					if (labelEditPart.getKeyPoint() == ConnectionLocator.TARGET) {
						String tailLabel = "";

						if ((tailLabel.equals(""))
								&& (labelEditPart.getFigure() instanceof WrappingLabel))
							tailLabel = ((WrappingLabel) labelEditPart
									.getFigure()).getText();

						if (!tailLabel.equals("")) {
							KEdgeLabel tLabel = KimlLayoutUtil
									.createInitializedEdgeLabel();
							tLabel.getLabelLayout().setLabelPlacement(
									KEdgeLabelPlacement.TAIL);
							tLabel.getLabelLayout().setSize(labelSize);
							tLabel.setText(tailLabel);
							edge.getLabel().add(tLabel);
							edgeLabel2EditPart.put(tLabel, labelEditPart);
						}
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphBuilder
	 * #resetCustomMaps()
	 */
	@Override
	protected void resetCustomMaps() {
		graphicalEditPart2LayoutNode.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphBuilder
	 * #updatePreferences()
	 */
	@Override
	protected void updatePreferences() {
		/* get preference values */
		IPreferenceStore kimlUiPreferenceStore = KimlUiPlugin.getDefault()
				.getPreferenceStore();
		prefInsetsTop = kimlUiPreferenceStore
				.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_TOP);
		prefInsetsLeft = kimlUiPreferenceStore
				.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_LEFT);
		prefInsetsBottom = kimlUiPreferenceStore
				.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_BOTTOM);
		prefInsetsRight = kimlUiPreferenceStore
				.getInt(PreferenceConstants.PREF_GENERIC_DIAGRAM_LAYOUTER_INSET_RIGHT);

	}

}
