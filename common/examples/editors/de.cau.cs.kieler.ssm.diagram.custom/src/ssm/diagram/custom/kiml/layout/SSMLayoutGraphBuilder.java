/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package ssm.diagram.custom.kiml.layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.AnimatableScrollPane;
import org.eclipse.gmf.runtime.notation.impl.ViewImpl;
import org.eclipse.jface.viewers.IStructuredSelection;

import ssm.diagram.custom.SSMDiagramCustomPlugin;
import ssm.diagram.custom.preferences.PreferenceConstants;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphBuilder;
import de.cau.cs.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import de.cau.cs.kieler.kiml.ui.helpers.KimlMetricsHelper;
import de.cau.cs.kieler.ssm.diagram.edit.parts.CompositeState2EditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.CompositeStateCompositeStateCompartment2EditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.CompositeStateCompositeStateCompartmentEditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.CompositeStateEditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.InitialStateEditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.RegionEditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.RegionRegionCompartmentEditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.SafeStateMachineEditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.SimpleStateEditPart;
import de.cau.cs.kieler.ssm.diagram.part.SafeStateMachineDiagramEditor;

/**
 * The layouter for SafeStateMachines as defined and used by the
 * {@link SafeStateMachineDiagramEditor}. This class implements the methods of
 * the {@link KimlAbstractLayouter} to perform the translation of a
 * SafeStateMachine diagram, or parts thereof, to the {@link KLayoutGraph} and
 * back, as well as some setup functions.
 * <p/>
 * The transformation is able to identify collapsed Regions and CompositeStates
 * and will treat them as such in the further layout process.
 * <p/>
 * This version is a simplified one which can just layout the main composite
 * elements, that are Regions and CompositeStates as a whole. However, this is
 * general what you want. If you want to layout parts of Regions and
 * CompositeStates separately, take a look at the
 * {@link KimlSSMDiagramGroupingLayouter}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlAbstractLayoutGraphBuilder
 */
public class SSMLayoutGraphBuilder extends KimlAbstractLayoutGraphBuilder {

	/** preference settings */
	private boolean prefAlternatingHVLayout = false;
	private boolean prefAutosizeEmptyElements = true;
	private float prefWidthCollapsed = 80f;
	private float prefHeightCollapsed = 40f;

	/** height of header/title of Composite State and other defaults */
	private int insetTop = 20;
	private int defaultHeightSimple = 30;
	private int defaultWidthSimple = 40;
	private int defaultHeightComposite = 40;
	private int defaultWidthComposite = 50;

	/** mappings just for this special layout graph builder */
	private Map<GraphicalEditPart, KLayoutNode> graphicalEditPart2LayoutNode = new HashMap<GraphicalEditPart, KLayoutNode>();

	/*------------------------------------------------------------------------------*/
	/*------------------------- BUILDING OF KLAYOUTGRAPH ---------------------------*/
	/*------------------------------------------------------------------------------*/

	/**
	 * Builds up the KLayoutGraph out of the SSM Diagram.
	 * 
	 */
	@Override
	protected void doBuildLayoutGraph() {
				
		/*
		 * if the rootPart was a complete SSM, that is when clicked into the
		 * empty diagram background space, start with its first and only child,
		 * the Top CompositeState.
		 */
		if (layoutRootPart.getClass().equals(
				SafeStateMachineEditPart.class)) {
			layoutRootPart = (GraphicalEditPart) layoutRootPart
					.getChildren().get(0);
		}

		/*
		 * process the provided root according to its type. A
		 * CompositeState2EditPart corresponds to a normal CompositeState, a
		 * CompositeStateEditPart corresponds to the one Top CompositeState of a
		 * SSM.
		 */
		if (layoutRootPart.getClass().equals(
				CompositeState2EditPart.class)
				|| layoutRootPart.getClass().equals(
						CompositeStateEditPart.class)
				|| layoutRootPart.getClass().equals(
						RegionEditPart.class)) {

			/*
			 * do the common translation, that is position, size and label,
			 * layout hints, ...
			 */
			processCommon(layoutRootPart,
					layoutGraph,
					new ArrayList<ConnectionEditPart>());
			processLayoutHints(
					(GraphicalEditPart) layoutRootPart,
					layoutGraph);
			/*
			 * If Emma wants to lay out the Top Composite State, that is also
			 * the top figure of the StateMachine, move the upper left corner to
			 * (10,10)
			 */
			if (layoutRootPart.getClass().equals(
					CompositeStateEditPart.class)) {
				KPoint location = KimlLayoutGraphFactory.eINSTANCE
						.createKPoint();
				location.setX(10);
				location.setY(10);
				layoutGraph.getLayout().setLocation(location);
			}

			/* maintain the mapping of elements for the applyLayout function */
			graphicalEditPart2LayoutNode.put(layoutRootPart,
					layoutGraph);
			layoutNode2EditPart.put(
					layoutGraph,
					layoutRootPart);

			/* do the same for all children */
			buildLayoutGraphRecursively(layoutRootPart,
					layoutGraph);
		}
	}

	/**
	 * Recursive helper function for the sub elements of a CompositeState or
	 * Region.
	 * 
	 * @param currentEditPart
	 *            The GraphicalEditPart which children will be processed
	 * @param currentLayoutNode
	 *            The corresponding KLayoutNode
	 */
	private void buildLayoutGraphRecursively(GraphicalEditPart currentEditPart,
			KLayoutNode currentLayoutNode) {

		/*
		 * List to save the information about the connections. Connections can
		 * only be added, when source AND target state are in the KLayoutGraph,
		 * so process the connections when all sub states of a region have been
		 * added.
		 */
		ArrayList<ConnectionEditPart> connections = new ArrayList<ConnectionEditPart>();

		/*
		 * iterate through the children of the element, children may exist in a
		 * Region and in a CompositeState. Check what Emma found.
		 */
		for (Object childEditPart : currentEditPart.getChildren()) {

			/*
			 * Simple State and Initial State have just a position, size and
			 * connection: -> processCommon
			 */
			if (childEditPart.getClass().equals(SimpleStateEditPart.class)
					|| childEditPart.getClass().equals(
							InitialStateEditPart.class)) {

				KLayoutNode childLayoutNode = processGetNewSubNode(currentLayoutNode);
				processCommon((GraphicalEditPart) childEditPart,
						childLayoutNode, connections);
			}

			/*
			 * Composite State and Region have further children, address them,
			 * too.
			 */
			else if (childEditPart.getClass().equals(RegionEditPart.class)
					|| childEditPart.getClass().equals(
							CompositeState2EditPart.class)
					|| childEditPart.getClass().equals(
							CompositeStateEditPart.class)) {

				KLayoutNode childLayoutNode = processGetNewSubNode(currentLayoutNode);
				processCommon((GraphicalEditPart) childEditPart,
						childLayoutNode, connections);
				processLayoutHints((GraphicalEditPart) childEditPart,
						childLayoutNode);
				buildLayoutGraphRecursively((GraphicalEditPart) childEditPart,
						childLayoutNode);
			}

			/* if CompartmentEditPart, fetch the children */
			else if (childEditPart.getClass().equals(
					RegionRegionCompartmentEditPart.class)
					|| childEditPart
							.getClass()
							.equals(
									CompositeStateCompositeStateCompartmentEditPart.class)
					|| childEditPart
							.getClass()
							.equals(
									CompositeStateCompositeStateCompartment2EditPart.class)) {

				/*
				 * extend the label string to handle the node label of a
				 * composite state correctly
				 */
				String text = currentLayoutNode.getLabel().getText();
				if (text == null)
					text = "";
				currentLayoutNode.getLabel().setText(text.concat("XX"));

				/* check if Compartment is expanded */
				ShapeCompartmentFigure scf = (ShapeCompartmentFigure) ((GraphicalEditPart) childEditPart)
						.getFigure();
				AnimatableScrollPane asp = (AnimatableScrollPane) scf
						.getScrollPane();

				if (asp.isExpanded()) {
					/*
					 * if expanded, do also process the children
					 */
					buildLayoutGraphRecursively(
							(GraphicalEditPart) childEditPart,
							currentLayoutNode);
				}
				/*
				 * if collapsed, force the compartment to be laid out with the
				 * size to default values and omit all the children.
				 */
				else {
					currentLayoutNode.getLayout().getSize().setHeight(
							prefHeightCollapsed);
					currentLayoutNode.getLayout().getSize().setWidth(
							prefWidthCollapsed);
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
	 * Creates a new initialized KLayoutNode for the provided KLayoutNode and
	 * returns it.
	 * 
	 * @param currentLayoutNode
	 *            A KLayoutNode for which an initialized sub KLayoutNode should
	 *            be created.
	 * @return An initialized KLayoutNode which is a subnode of the provided one
	 */
	private KLayoutNode processGetNewSubNode(KLayoutNode currentLayoutNode) {
		KLayoutNode childLayoutNode = KimlLayoutUtil
				.createInitializedLayoutNode();
		currentLayoutNode.getChildNodes().add(childLayoutNode);
		return childLayoutNode;
	}

	/**
	 * Takes a KLayoutNode and an EditPart and fills the layout information of
	 * the EditPart into the KLayoutNode. Fills also the global maps which keep
	 * track of the mapping between EditParts and KLayoutNodes.
	 * 
	 * @param currentEditPart
	 *            The EditPart whose information should be filled into the
	 *            KLayoutNode
	 * @param currentLayoutNode
	 *            The respective KLayoutNode
	 * @param connections
	 *            A list to which all the connections of the EditPart are added.
	 */
	private void processCommon(GraphicalEditPart currentEditPart,
			KLayoutNode currentLayoutNode,
			ArrayList<ConnectionEditPart> connections) {

		Rectangle currentBounds = currentEditPart.getFigure().getBounds();

		// store all the connections to process them later
		for (Object conn : currentEditPart.getTargetConnections()) {
			if (conn instanceof ConnectionEditPart) {
				connections.add((ConnectionEditPart) conn);
			}
		}
		// set location
		currentLayoutNode.getLayout().getLocation().setX(currentBounds.x);
		currentLayoutNode.getLayout().getLocation().setY(currentBounds.y);

		// set size
		currentLayoutNode.getLayout().getSize().setHeight(currentBounds.height);
		currentLayoutNode.getLayout().getSize().setWidth(currentBounds.width);

		// special treatment if Emma wants auto sizing
		if (prefAutosizeEmptyElements) {
			if (currentEditPart.getClass()
					.equals(CompositeState2EditPart.class)) {
				currentLayoutNode.getLayout().getSize().setHeight(
						defaultHeightComposite);
				currentLayoutNode.getLayout().getSize().setWidth(
						defaultWidthComposite);
			} else if (currentEditPart.getClass().equals(
					SimpleStateEditPart.class)) {
				currentLayoutNode.getLayout().getSize().setHeight(
						defaultHeightSimple);
				currentLayoutNode.getLayout().getSize().setWidth(
						defaultWidthSimple);
			}
		}

		// set label and ID
		EObject currentEObject = ((ViewImpl) currentEditPart.getModel())
				.getElement();
		currentLayoutNode.getLabel().setText(
				kimlAdapterLabelProvider.getKimlShortLabel(currentEObject));
		currentLayoutNode.setIdString(kimlAdapterLabelProvider
				.getKimlLongLabel(currentEObject));

		// keep track of mapping between elements
		graphicalEditPart2LayoutNode.put(currentEditPart, currentLayoutNode);
		layoutNode2EditPart.put(currentLayoutNode,
				currentEditPart);

		return;
	}

	/**
	 * Takes a KLayoutNode and an EditPart and fills the layout hint information
	 * of the EditPart into the KLayoutNode. Layout hints are only applicable to
	 * certain elements of a SSM, that are Regions and CompositeStates, so
	 * therefore the distinction from <code>processCommon</code>.
	 * 
	 * @param currentEditPart
	 *            The EditPart whose layout hint information should be filled
	 *            into the KLayoutNode
	 * @param currentLayoutNode
	 *            The respective KLayoutNode
	 */
	private void processLayoutHints(GraphicalEditPart currentEditPart,
			KLayoutNode currentLayoutNode) {
		KLayoutType layoutType = KLayoutType.DEFAULT;
		String layouterName = "";
		layoutType = KimlGMFLayoutHintHelper
				.getContainedElementsLayoutType((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) currentEditPart);
		layouterName = KimlGMFLayoutHintHelper
				.getContainedElementsLayouterName((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) currentEditPart);
		currentLayoutNode.getLayout().setLayoutType(layoutType);
		currentLayoutNode.getLayout().setLayouterName(layouterName);

		/* attach top inset to compensate the label of a CompositeState */
		if (currentEditPart.getClass().equals(CompositeState2EditPart.class)
				|| currentEditPart.getClass().equals(
						CompositeStateEditPart.class)) {
			currentLayoutNode.getLayout().getInsets().setTop(insetTop);
		}
		/* enable alternating layout of regions */
		if (currentEditPart.getClass().equals(RegionEditPart.class)
				&& prefAlternatingHVLayout) {

			if (currentLayoutNode.getParentNode() != null
					&& currentLayoutNode.getParentNode().getParentNode() != null) {
				EList<KLayoutOption> layoutOptions = currentLayoutNode
						.getParentNode().getParentNode().getLayout()
						.getLayoutOptions();
				if (layoutOptions.contains(KLayoutOption.HORIZONTAL))
					currentLayoutNode.getLayout().getLayoutOptions().add(
							KLayoutOption.VERTICAL);
				else
					currentLayoutNode.getLayout().getLayoutOptions().add(
							KLayoutOption.HORIZONTAL);
			} else
				currentLayoutNode.getLayout().getLayoutOptions().add(
						KLayoutOption.HORIZONTAL);
		}
	}

	/**
	 * This function creates new KEdges and takes care of the labels for each
	 * connection identified in the <code>buildLayoutGraphRecursively</code>
	 * step before.
	 * 
	 * @param connections
	 *            The connections that were build for a certain KNode before.
	 */
	private void processConnections(ArrayList<ConnectionEditPart> connections) {

		/* iterate through all the connections of an element (that is a Region) */
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

			/* keep track of the mapping */
			layoutEdge2EditPart.put(edge, connection);

			/*
			 * Process the label, at the moment 3 are hard coded. Actually no
			 * possibility to get the location of the head label from GraphViz.
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
					// labelEditPart.getFigure().setLocation(new Point());
					KDimension labelSize = KimlMetricsHelper
							.dimension2KDimension(labelEditPart.getFigure()
									.getBounds().getSize());
					EObject transition = ((ViewImpl) connection.getModel())
							.getElement();
					// head label
					if (labelEditPart.getKeyPoint() == ConnectionLocator.SOURCE) {
						String headLabel = kimlAdapterLabelProvider
								.getKimlHeadLabel(transition);
						if (headLabel != null) {
							KEdgeLabel hLabel = KimlLayoutUtil
									.createInitializedEdgeLabel();
							hLabel.getLabelLayout().setLabelPlacement(
									KEdgeLabelPlacement.HEAD);
							hLabel.getLabelLayout().setSize(labelSize);
							hLabel.setText(headLabel);
							edge.getLabel().add(hLabel);
							edgeLabel2EditPart.put(hLabel,
									labelEditPart);
						}
					}

					// middle label
					if (labelEditPart.getKeyPoint() == ConnectionLocator.MIDDLE) {
						String midLabel = kimlAdapterLabelProvider
								.getKimlCenterLabel(transition);
						if (midLabel != null) {
							KEdgeLabel mLabel = KimlLayoutUtil
									.createInitializedEdgeLabel();
							mLabel.getLabelLayout().setLabelPlacement(
									KEdgeLabelPlacement.CENTER);
							mLabel.getLabelLayout().setSize(labelSize);
							mLabel.setText(midLabel);
							edge.getLabel().add(mLabel);
							edgeLabel2EditPart.put(mLabel,
									labelEditPart);
						}
					}

					// tail label
					if (labelEditPart.getKeyPoint() == ConnectionLocator.TARGET) {
						String tailLabel = kimlAdapterLabelProvider
								.getKimlTailLabel(transition);
						if (tailLabel != null) {
							KEdgeLabel tLabel = KimlLayoutUtil
									.createInitializedEdgeLabel();
							tLabel.getLabelLayout().setLabelPlacement(
									KEdgeLabelPlacement.TAIL);
							tLabel.getLabelLayout().setSize(labelSize);
							tLabel.setText(tailLabel);
							edge.getLabel().add(tLabel);
							edgeLabel2EditPart.put(tLabel,
									labelEditPart);
						}
					}
				}
			}
		}
	}


	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphBuilder#updatePreferences()
	 */
	@Override
	protected void updatePreferences() {

		prefAlternatingHVLayout = SSMDiagramCustomPlugin.getDefault()
				.getPreferenceStore().getBoolean(
						PreferenceConstants.PREF_ALTERNATING_HV_LAYOUT);
		prefHeightCollapsed = SSMDiagramCustomPlugin.getDefault()
				.getPreferenceStore().getInt(
						PreferenceConstants.PREF_HEIGHT_COLLAPSED);
		prefWidthCollapsed = SSMDiagramCustomPlugin.getDefault()
				.getPreferenceStore().getInt(
						PreferenceConstants.PREF_WIDTH_COLLAPSED);
		prefAutosizeEmptyElements = SSMDiagramCustomPlugin.getDefault()
				.getPreferenceStore().getBoolean(
						PreferenceConstants.PREF_AUTOSIZE_EMPTY_ELEMENTS);

	}


	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphBuilder#getLayoutRootPart(java.lang.Object)
	 */
	@Override
	protected GraphicalEditPart getLayoutRootPart(Object target) {
		GraphicalEditPart root = null;

		// no matter how much was selected, get the first element
		if (target instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) target;

			Object selectedObject = selection.getFirstElement();
			// if just one element was selected, use this, if NodeEditPart
			if (selection.size() == 1) {
				if (selectedObject instanceof NodeEditPart) {
					root = (NodeEditPart) selectedObject;
				} else if (selectedObject instanceof DiagramEditPart) {
					root = (GraphicalEditPart) ((DiagramEditPart) selectedObject)
							.getChildren().get(0);
				} else if (selectedObject instanceof CompartmentEditPart) {
					root = (GraphicalEditPart) ((CompartmentEditPart) selectedObject)
							.getParent();
				}
			}
			// more selected, find parent thereof
			else {
				root = findParentNode(selectedObject);
			}

		}

		if (target instanceof DiagramGraphicalViewer) {
			DiagramGraphicalViewer viewer = (DiagramGraphicalViewer) target;
			root = (GraphicalEditPart) viewer.getRootEditPart().getChildren()
					.get(0);
		}
		if (target instanceof DiagramEditor) {
			DiagramEditor editor = (DiagramEditor) target;
			root = (GraphicalEditPart) editor.getDiagramEditPart()
					.getChildren().get(0);
		}
		if (target instanceof DiagramEditPart) {
			DiagramEditPart dep = (DiagramEditPart) target;
			root = (GraphicalEditPart) dep.getChildren().get(0);
		}
		if (target instanceof GraphicalEditPart) {
			root = (GraphicalEditPart) root;
		}
		/* if alternating layout selected force layout of whole diagram */
		if (prefAlternatingHVLayout) {
			root = (GraphicalEditPart) root.getRoot().getContents();
		}
		return root;
	}

	/**
	 * Recursive helper function to get a GraphicalEditPart parent for an
	 * object.
	 */
	private GraphicalEditPart findParentNode(Object current) {
		if (current instanceof GraphicalEditPart) {
			GraphicalEditPart aep = (GraphicalEditPart) current;
			if (aep.getParent() instanceof NodeEditPart)
				return (NodeEditPart) aep.getParent();
			else {
				GraphicalEditPart parent = findParentNode(aep.getParent());
				if (parent == null) {
					DiagramGraphicalViewer viewer = (DiagramGraphicalViewer) aep
							.getViewer();
					return (GraphicalEditPart) viewer.getRootEditPart()
							.getChildren().get(0);
				} else
					return parent;
			}
		} else
			return null;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphBuilder#resetCustomMaps()
	 */
	@Override
	protected void resetCustomMaps() {
		graphicalEditPart2LayoutNode.clear();		
	}

}
