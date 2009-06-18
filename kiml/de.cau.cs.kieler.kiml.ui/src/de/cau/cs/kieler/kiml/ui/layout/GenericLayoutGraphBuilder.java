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
package de.cau.cs.kieler.kiml.ui.layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.options.EdgeLabelPlacement;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.options.LayoutType;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;

/**
 * A generic implementation of the {@link GenericLayoutGraphBuilder}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * 
 */
public class GenericLayoutGraphBuilder extends
		AbstractLayoutGraphBuilder {

	/* preference setting */
	private int prefInsetsTop = 0;
	private int prefInsetsLeft = 0;
	private int prefInsetsBottom = 0;
	private int prefInsetsRight = 0;

	private Map<GraphicalEditPart, KNode> graphicalEditPart2LayoutNode = new HashMap<GraphicalEditPart, KNode>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.cau.cs.kieler.kiml.ui.layout.AbstractLayoutGraphBuilder
	 * #doBuildLayoutGraph()
	 */
	@Override
	protected void doBuildLayoutGraph() {

		if (layoutRootPart instanceof NodeEditPart) {
			NodeEditPart rootEditPart = (NodeEditPart) layoutRootPart;
			KShapeLayout shapeLayout = KimlLayoutUtil.getShapeLayout(layoutGraph);

			/* set location */
			shapeLayout.setXpos(rootEditPart.getFigure().getBounds().x);
			shapeLayout.setYpos(rootEditPart.getFigure().getBounds().y);

			/* set size */
			shapeLayout.setHeight(rootEditPart.getFigure().getBounds().height);
			shapeLayout.setWidth(rootEditPart.getFigure().getBounds().width);

			/* set LayouterName and LayoutType if root is ShapeNodeEditPart */
			if (rootEditPart instanceof ShapeNodeEditPart) {
			    LayoutOptions.setLayouterName(shapeLayout,
			            KimlGMFLayoutHintHelper.getContainedElementsLayouterName(
			            (ShapeNodeEditPart) rootEditPart));
			    			    
			    LayoutOptions.setLayoutType(shapeLayout,
						KimlGMFLayoutHintHelper.getContainedElementsLayoutType(
						(ShapeNodeEditPart) rootEditPart));
			}

			/* map the root EditPart to the top KNode */
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
			LayoutType layoutType = LayoutType.OTHER;
			String layouterName = "";
			layoutType = KimlGMFLayoutHintHelper
					.getContainedElementsLayoutType((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) layoutRootPart);
			layouterName = KimlGMFLayoutHintHelper
					.getContainedElementsLayouterName((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) layoutRootPart);
			KShapeLayout shapeLayout = KimlLayoutUtil.getShapeLayout(layoutGraph);
			LayoutOptions.setLayoutType(shapeLayout, layoutType);
			LayoutOptions.setLayouterName(shapeLayout, layouterName);
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
	 *            The corresponding KNode
	 */
	private void buildLayoutGraphRecursively(GraphicalEditPart currentEditPart,
			KNode currentLayoutNode) {

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
				KNode childLayoutNode = KimlLayoutUtil
						.createInitializedNode();
				Rectangle childBounds = childNodeEditPart.getFigure()
						.getBounds();
				KShapeLayout nodeLayout = KimlLayoutUtil.getShapeLayout(childLayoutNode);

				/* store all the connections to process them later */
				for (Object conn : childNodeEditPart.getTargetConnections()) {
					if (conn instanceof ConnectionEditPart) {
						connections.add((ConnectionEditPart) conn);
					}
				}

				/* set location */
				nodeLayout.setXpos(childBounds.x);
				nodeLayout.setYpos(childBounds.y);

				/* set size */
				nodeLayout.setHeight(childBounds.height);
				nodeLayout.setWidth(childBounds.width);

				/*
				 * set information about LayouterName and LayoutType
				 */
				LayoutType layoutType = LayoutType.OTHER;
				String layouterName = "";
				layoutType = KimlGMFLayoutHintHelper
						.getContainedElementsLayoutType((ShapeNodeEditPart) childNodeEditPart);
				layouterName = KimlGMFLayoutHintHelper
						.getContainedElementsLayouterName((ShapeNodeEditPart) childNodeEditPart);
				LayoutOptions.setLayoutType(nodeLayout, layoutType);
				LayoutOptions.setLayouterName(nodeLayout, layouterName);

				/* add node */
				currentLayoutNode.getChildren().add(childLayoutNode);

				/* keep track of mapping between elements */
				graphicalEditPart2LayoutNode.put(childNodeEditPart,
						childLayoutNode);
				layoutNode2EditPart.put(childLayoutNode, childNodeEditPart);

				/* and process the child as new current */
				buildLayoutGraphRecursively(childNodeEditPart, childLayoutNode);
			}

			/*
			 * If it is ShapeCompartmentEditPart, Emma needs the children of it
			 * to add to new KNodes. She handles possible insets, which
			 * may result from labels and other stuff.
			 */
			if (obj instanceof ShapeCompartmentEditPart
					&& ((ShapeCompartmentEditPart) obj).getChildren().size() != 0) {

			    KShapeLayout parentLayout = KimlLayoutUtil.getShapeLayout(
			            graphicalEditPart2LayoutNode.get(((GraphicalEditPart)obj)
			            .getParent()));
				KInsets parentInsets = LayoutOptions.getInsets(parentLayout);
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
				} else if (labelFigure instanceof Label) {
					String text = ((Label) labelFigure).getText();

					graphicalEditPart2LayoutNode.get(
							graphicalEditPart.getParent()).getLabel().setText(
							text.concat("XX"));
				}
			}
		}
		/*
		 * Finally process all the connections, as Emma has build all the needed
		 * KNodes which act as source and target.
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
			 * create the KEdge. The KEdge does not need to be added
			 * explicitly to the KLayoutGraph, but exists in it through the
			 * EOppositeReference of EMF.
			 */
			KEdge edge = KimlLayoutUtil.createInitializedEdge();
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
					Dimension labelSize = labelEditPart.getFigure()
									.getBounds().getSize();

					// head label
					if (labelEditPart.getKeyPoint() == ConnectionLocator.SOURCE) {
						String headLabel = "";

						if ((headLabel.equals(""))
								&& (labelEditPart.getFigure() instanceof WrappingLabel))
							headLabel = ((WrappingLabel) labelEditPart
									.getFigure()).getText();

						if (!headLabel.equals("")) {
							KLabel hLabel = KimlLayoutUtil.createInitializedLabel(edge);
							KShapeLayout labelLayout = KimlLayoutUtil.getShapeLayout(hLabel);
							LayoutOptions.setEdgeLabelPlacement(labelLayout,
									EdgeLabelPlacement.HEAD);
							labelLayout.setWidth(labelSize.width);
							labelLayout.setHeight(labelSize.height);
							hLabel.setText(headLabel);
							edge.getLabels().add(hLabel);
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
							KLabel mLabel = KimlLayoutUtil.createInitializedLabel(edge);
							KShapeLayout labelLayout = KimlLayoutUtil.getShapeLayout(mLabel);
                            LayoutOptions.setEdgeLabelPlacement(labelLayout,
									EdgeLabelPlacement.CENTER);
                            labelLayout.setWidth(labelSize.width);
                            labelLayout.setHeight(labelSize.height);
                            mLabel.setText(midLabel);
							edge.getLabels().add(mLabel);
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
							KLabel tLabel = KimlLayoutUtil.createInitializedLabel(edge);
							KShapeLayout labelLayout = KimlLayoutUtil.getShapeLayout(tLabel);
                            LayoutOptions.setEdgeLabelPlacement(labelLayout,
									EdgeLabelPlacement.TAIL);
                            labelLayout.setWidth(labelSize.width);
                            labelLayout.setHeight(labelSize.height);
                            tLabel.setText(tailLabel);
							edge.getLabels().add(tLabel);
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
	 * de.cau.cs.kieler.kiml.ui.layout.AbstractLayoutGraphBuilder
	 * #resetCustomMaps()
	 */
	@Override
	protected void resetCustomMaps() {
		graphicalEditPart2LayoutNode.clear();
	}

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.ui.layout.AbstractLayoutGraphBuilder#updatePreferences()
     */
    protected void updatePreferences() {
    }

}
