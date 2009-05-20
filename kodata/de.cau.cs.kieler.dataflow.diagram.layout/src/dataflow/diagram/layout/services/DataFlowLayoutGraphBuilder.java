package dataflow.diagram.layout.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;

import dataflow.diagram.edit.parts.DataflowModelEditPart;
import dataflow.diagram.edit.parts.InputPortEditPart;
import dataflow.diagram.layout.DataflowDiagramLayoutPlugin;
import dataflow.diagram.layout.preferences.DiagramLayoutPreferencePage;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.core.kgraph.KPortType;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutDataFactory;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.options.LayoutDirection;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.options.PortConstraints;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import de.cau.cs.kieler.kiml.ui.layout.AbstractLayoutGraphBuilder;

public class DataFlowLayoutGraphBuilder extends AbstractLayoutGraphBuilder {

	/** inset value to be used for the top side of each node */
	private static final float INSET_TOP = 5.0f;
	/** inset value to be used for the bottom side of each node */
	private static final float INSET_BOTTOM = 5.0f;
	/** inset value to be used for the left side of each node */
	private static final float INSET_LEFT = 5.0f;
	/** inset value to be used for the right side of each node */
	private static final float INSET_RIGHT = 5.0f;
	
	/** default height for node labels, to be added to the top inset */
	private static final float DEFAULT_LABEL_HEIGHT = 15.0f;

	/**
	 * Definition of possible edge types in a dataflow diagram with operators.
	 */
	private enum EdgeHierarchyType {
		INPUT_TO_OP, OP_TO_OP, OP_TO_OUTPUT
	}

	/** preference: preserve box size for empty boxes */
	private boolean fixedNodeSizePref;
	/** preference: port constraints for empty boxes */
	private PortConstraints emptyPortConstraints;
	/** preference: port constraints for non-empty boxes */
	private PortConstraints nonemptyPortConstraints;
	/** preference: alternating layout direction */
	private boolean alternateHVPref;

	private Map<BorderedBorderItemEditPart, KPort> borderItem2PortMapping = new HashMap<BorderedBorderItemEditPart, KPort>();

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.ui.layout.AbstractLayoutGraphBuilder#doBuildLayoutGraph()
	 */
	@Override
	protected void doBuildLayoutGraph() {
		IPreferenceStore preferenceStore = DataflowDiagramLayoutPlugin
				.getDefault().getPreferenceStore();
		LayoutDirection layoutDirection = preferenceStore.getString(
				DiagramLayoutPreferencePage.LAYOUT_DIRECTION)
				.equals("vertical") //$NON-NLS-1$
				? LayoutDirection.VERTICAL
				: LayoutDirection.HORIZONTAL;
		if (layoutRootPart instanceof DataflowModelEditPart) {
			layoutGraph = KimlLayoutUtil.createInitializedNode();
			DataflowModelEditPart modelPart = (DataflowModelEditPart)layoutRootPart;
			// set the top node's layout
			KShapeLayout topGroupLayout = KimlLayoutUtil.getShapeLayout(layoutGraph);
			createLayout(topGroupLayout, modelPart.getFigure());
			LayoutOptions.setLayouterName(topGroupLayout, KimlGMFLayoutHintHelper
					.getContainedElementsLayouterName(modelPart));
			LayoutOptions.setLayoutType(topGroupLayout, KimlGMFLayoutHintHelper
					.getContainedElementsLayoutType(modelPart));
			LayoutOptions.setLayoutDirection(topGroupLayout, layoutDirection);
			layoutGraph.getLabel().setText(modelPart
			        .getDiagramView().getName());
			// build the whole graph structure
			if (alternateHVPref)
				layoutDirection = LayoutDirection.VERTICAL;
			buildLayoutGraphRecursively(modelPart.getChildren(), layoutGraph,
					layoutDirection);
		} else if (layoutRootPart instanceof AbstractBorderedShapeEditPart) {
			AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart) layoutRootPart;
			// build just the selected node
			layoutGraph = buildNode(boxEditPart, layoutDirection);
			buildNodeEdges(boxEditPart, false);
		}
	}

	

	/**
	 * Sets the location and size properties of a shape layout.
	 * 
	 * @param shapeLayout
	 *            layout object to be changed
	 * @param figure
	 *            source object with layout information
	 */
	private static void createLayout(KShapeLayout shapeLayout, IFigure figure) {
	    shapeLayout.setXpos(figure.getBounds().x);
	    shapeLayout.setYpos(figure.getBounds().y);
	    shapeLayout.setHeight(figure.getBounds().height);
	    shapeLayout.setWidth(figure.getBounds().width);
	}

	/**
	 * Sets the location and size properties of a shape layout and subtracts an
	 * offset value from its size.
	 * 
	 * @param shapeLayout
	 *            layout object to be changed
	 * @param figure
	 *            source object with layout information
	 * @param xoffset
	 *            x offset by which the given figure is translated
	 * @param yoffset
     *            y offset by which the given figure is translated
	 */
	private static void createRelativeLayout(KShapeLayout shapeLayout,
			IFigure figure, float xoffset, float yoffset) {
	    shapeLayout.setXpos(figure.getBounds().x - xoffset);
	    shapeLayout.setYpos(figure.getBounds().y - yoffset);
	    shapeLayout.setHeight(figure.getBounds().height);
	    shapeLayout.setWidth(figure.getBounds().width);
	}

	/**
	 * Processes the elements and all sub-elements of a node by recursive call.
	 * 
	 * @param children
	 *            list of child elements of a node
	 * @param parentNode
	 *            parent layout node
	 * @param layoutDirection
	 *            layout direction
	 */
	private void buildLayoutGraphRecursively(List<?> children,
			KNode parentNode, LayoutDirection layoutDirection) {
		if (children != null) {
			// build layout nodes
			for (Object child : children) {
				if (child instanceof AbstractBorderedShapeEditPart) {
					AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart) child;
					KNode childNode = buildNode(boxEditPart,
							layoutDirection);
					// set the parent group; this automatically adds the node
					// to the parent's list of children
					childNode.setParent(parentNode);
				}
			}

			// build edges
			for (Object child : children) {
				if (child instanceof AbstractBorderedShapeEditPart) {
					AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart) child;
					buildNodeEdges(boxEditPart, true);
				}
			}
		}
	}

	/**
	 * Builds the layout graph for a given node edit part.
	 * 
	 * @param boxEditPart
	 *            edit part for which the layout graph shall be built
	 * @param layoutDirection
	 *            layout direction
	 * @return the created layout node
	 */
	private KNode buildNode(AbstractBorderedShapeEditPart boxEditPart,
			LayoutDirection layoutDirection) {
		// add the new child node
		KNode childNode = KimlLayoutUtil.createInitializedNode();
		layoutNode2EditPart.put(childNode, boxEditPart);
		// set the child node's layout
		KShapeLayout nodeLayout = KimlLayoutUtil.getShapeLayout(childNode);
		createLayout(nodeLayout, boxEditPart.getFigure());
		KInsets insets = LayoutOptions.getInsets(nodeLayout);
		insets.setLeft(INSET_LEFT);
		insets.setRight(INSET_RIGHT);
		insets.setTop(INSET_TOP + DEFAULT_LABEL_HEIGHT);
		insets.setBottom(INSET_BOTTOM);
		LayoutOptions.setLayouterName(nodeLayout, KimlGMFLayoutHintHelper
				.getContainedElementsLayouterName(boxEditPart));
		LayoutOptions.setLayoutType(nodeLayout, KimlGMFLayoutHintHelper
				.getContainedElementsLayoutType(boxEditPart));
		LayoutOptions.setLayoutDirection(nodeLayout, layoutDirection);
		// switch layout direction if needed
		if (alternateHVPref) {
			if (layoutDirection == LayoutDirection.VERTICAL)
				layoutDirection = LayoutDirection.HORIZONTAL;
			else
				layoutDirection = LayoutDirection.VERTICAL;
		}
		// set the input and output ports and node label
		List<?> subChildren = null;
		for (Object nodeElement : boxEditPart.getChildren()) {
			if (nodeElement instanceof ShapeCompartmentEditPart) {
				subChildren = ((ShapeCompartmentEditPart) nodeElement)
						.getChildren();
			} else if (nodeElement instanceof BorderedBorderItemEditPart) {
				BorderedBorderItemEditPart borderItem = (BorderedBorderItemEditPart) nodeElement;
				// add the new port
				KPort port = KimlLayoutUtil.createInitializedPort();
				layoutPort2EditPart.put(port, borderItem);
				borderItem2PortMapping.put(borderItem, port);
				port.setType(borderItem instanceof InputPortEditPart
				        ? KPortType.INPUT : KPortType.OUTPUT);
				port.setNode(childNode);
				// set the port's layout
				KShapeLayout portLayout = KimlLayoutUtil.getShapeLayout(port);
				createRelativeLayout(portLayout, borderItem.getFigure(),
						nodeLayout.getXpos(), nodeLayout.getYpos());
				// set the port label
				for (Object portChild : borderItem.getChildren()) {
					if (portChild instanceof ITextAwareEditPart) {
						ITextAwareEditPart portNameEditPart = (ITextAwareEditPart) portChild;
						KLabel portLabel = port.getLabel();
						portLabel.setText(portNameEditPart.getEditText());
						// set the port label's layout
						KShapeLayout labelLayout = KimlLayoutUtil.getShapeLayout(portLabel);
						float xoffset = nodeLayout.getXpos()
								+ portLayout.getXpos();
						float yoffset = nodeLayout.getYpos()
								+ portLayout.getYpos();
						createRelativeLayout(labelLayout, portNameEditPart
								.getFigure(), xoffset, yoffset);
					}
				}
			} else if (nodeElement instanceof ITextAwareEditPart) {
				ITextAwareEditPart boxNameEditPart = (ITextAwareEditPart) nodeElement;
				// add layout node label
				KLabel nodeLabel = childNode.getLabel();
				nodeLabel.setText(boxNameEditPart.getEditText());
				// set the node label's layout
				KShapeLayout labelLayout = KimlLayoutUtil.getShapeLayout(nodeLabel);
				IFigure labelFigure = boxNameEditPart.getFigure();
				labelLayout.setXpos(labelFigure.getBounds().x - nodeLayout.getXpos());
				labelLayout.setYpos(labelFigure.getBounds().y - nodeLayout.getYpos());
				labelLayout.setWidth(labelFigure.getPreferredSize().width);
				labelLayout.setHeight(labelFigure.getPreferredSize().height);
				insets.setTop(INSET_TOP + labelLayout.getHeight());
			}
		}

		// set layout options
		if (subChildren != null && !subChildren.isEmpty()) {
			LayoutOptions.setPortConstraints(nodeLayout,
			        nonemptyPortConstraints);
		} else {
		    LayoutOptions.setPortConstraints(nodeLayout,
		            emptyPortConstraints);
			if (fixedNodeSizePref)
				LayoutOptions.setFixedSize(nodeLayout, true);
		}

		// process next hierarchy level
		buildLayoutGraphRecursively(subChildren, childNode, layoutDirection);

		return childNode;
	}

	/**
	 * Builds all outgoing edges of a given node edit part.
	 * 
	 * @param boxEditPart
	 *            edit part whose edges shall be built
	 * @param processExternal
	 *            indicates whether edges to nodes of the same or higher
	 *            hierarchy level should be processed
	 */
	private void buildNodeEdges(AbstractBorderedShapeEditPart boxEditPart,
			boolean processExternal) {
		for (Object nodeElement : boxEditPart.getChildren()) {
			if (nodeElement instanceof BorderedBorderItemEditPart) {
				BorderedBorderItemEditPart portEditPart = (BorderedBorderItemEditPart) nodeElement;
				KPort port1 = borderItem2PortMapping.get(portEditPart);
				for (Object portElement : portEditPart.getSourceConnections()) {
					if (portElement instanceof ConnectionEditPart) {
						ConnectionEditPart connectionEditPart = (ConnectionEditPart) portElement;
						KPort port2 = borderItem2PortMapping
								.get(connectionEditPart.getTarget());
						if (port2 != null) {
							// add the new edge according to its type
							if (port1.getType() == KPortType.OUTPUT
									&& port2.getType() == KPortType.INPUT) {
								if (processExternal
										&& port1.getNode().getParent() == port2
												.getNode().getParent()) {
									addEdge(port1, port2, connectionEditPart,
											EdgeHierarchyType.OP_TO_OP);
								}
							} else if (port1.getType() == KPortType.INPUT
									&& port2.getType() == KPortType.INPUT) {
								if (port1.getNode() == port2.getNode().getParent()) {
									addEdge(port1, port2, connectionEditPart,
											EdgeHierarchyType.INPUT_TO_OP);
								}
							} else if (port1.getType() == KPortType.OUTPUT
									&& port2.getType() == KPortType.OUTPUT) {
								if (processExternal
										&& port1.getNode().getParent() == port2
												.getNode()) {
									addEdge(port1, port2, connectionEditPart,
											EdgeHierarchyType.OP_TO_OUTPUT);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Adds an edge to the KLayoutGraph. If the edge goes to an sub-node, it is
	 * not added to the incoming or outgoing edges of the parent node, but only
	 * to those of the sub-node.
	 * 
	 * @param sourcePort
	 *            source port of the edge
	 * @param targetPort
	 *            target port of the edge
	 * @param connectionEditPart
	 *            edit part related to the edge
	 * @param edgeType
	 *            hierarchy type of the edge
	 */
	private void addEdge(KPort sourcePort, KPort targetPort,
			ConnectionEditPart connectionEditPart, EdgeHierarchyType edgeType) {
		KEdge edge = KimlLayoutUtil.createInitializedEdge();
		
		layoutEdge2EditPart.put(edge, connectionEditPart);
		float sourceNodeX = 0.0f, sourceNodeY = 0.0f, targetNodeX = 0.0f, targetNodeY = 0.0f;
		//if (edgeType != EdgeHierarchyType.INPUT_TO_OP) {
			// set the source node; this automatically adds the edge
			// to the source's list of outgoing edges
		KShapeLayout sourceLayout = KimlLayoutUtil.getShapeLayout(
		        sourcePort.getNode());
		edge.setSource(sourcePort.getNode());
		sourceNodeX = sourceLayout.getXpos();
		sourceNodeY = sourceLayout.getYpos();
		//}
		edge.setSourcePort(sourcePort);
		//if (edgeType != EdgeHierarchyType.OP_TO_OUTPUT) {
			// set the target node; this automatically adds the edge to
			// the target's list of incoming edges
		KShapeLayout targetLayout = KimlLayoutUtil.getShapeLayout(
		        targetPort.getNode());
		edge.setTarget(targetPort.getNode());
		targetNodeX = targetLayout.getXpos();
		targetNodeY = targetLayout.getYpos();
		//}
		edge.setTargetPort(targetPort);
		sourcePort.getEdges().add(edge);
		targetPort.getEdges().add(edge);
		// set the edge's layout
		KEdgeLayout edgeLayout = KimlLayoutUtil.getEdgeLayout(edge);
		KPoint sourcePoint = KLayoutDataFactory.eINSTANCE.createKPoint();
		KShapeLayout sourcePortLayout = KimlLayoutUtil.getShapeLayout(sourcePort);
		sourcePoint.setX(sourcePortLayout.getXpos()
				+ sourcePortLayout.getWidth() / 2 + sourceNodeX);
		sourcePoint.setY(sourcePortLayout.getYpos()
				+ sourcePortLayout.getHeight() / 2 + sourceNodeY);
		edgeLayout.setSourcePoint(sourcePoint);
		KPoint targetPoint = KLayoutDataFactory.eINSTANCE.createKPoint();
		KShapeLayout targetPortLayout = KimlLayoutUtil.getShapeLayout(targetPort);
		targetPoint.setX(targetPortLayout.getXpos()
				+ targetPortLayout.getWidth() / 2 + targetNodeX);
		targetPoint.setY(targetPortLayout.getYpos()
				+ targetPortLayout.getHeight() / 2 + targetNodeY);
		edgeLayout.setTargetPoint(targetPoint);
	}

	@Override
	protected GraphicalEditPart getLayoutRootPart(Object target) {
		GraphicalEditPart root = null;
		// find the dataflow model edit part depending on the type of input
		if (target instanceof DiagramRootEditPart) {
			DiagramRootEditPart editor = (DiagramRootEditPart)target;
			root = (GraphicalEditPart) editor.getContents();
		}
		else if (target instanceof DiagramDocumentEditor) {
			DiagramDocumentEditor documentEditor = (DiagramDocumentEditor)target;
			root = documentEditor.getDiagramEditPart();
		}
		else if (target instanceof DataflowModelEditPart) {
			DataflowModelEditPart editPart = (DataflowModelEditPart)target;
			DiagramRootEditPart editor = (DiagramRootEditPart) editPart.getRoot();
			root = (GraphicalEditPart) editor.getContents();
		}
		else if (target instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)target;
			root = (GraphicalEditPart) findRootPart(selection.toList());
			// check for special cases
			if (root instanceof CompartmentEditPart
					|| root instanceof BorderedBorderItemEditPart) {
				// BoxBoxCompartmentEditPart, BoxNameEditPart
				root = (GraphicalEditPart) root.getParent();
			}
			else if (root instanceof LabelEditPart) {
				// InputPortNameEditPart, OutputPortNameEditPart
				root = (GraphicalEditPart) root.getParent().getParent();
			}
			else if (root instanceof DiagramRootEditPart) {
				// RenderedDiagramRootEditPart
				root = (GraphicalEditPart) ((DiagramRootEditPart)root).getContents();
			}
		}
		return root;
	}
	
		
	/**
	 * Analyzes the tree structure of a diagram and returns the edit
	 * part that has all selected parts as children.
	 * 
	 * @param selectedParts list of selected parts
	 * @return the root part
	 */
	@SuppressWarnings("unchecked")
	private static EditPart findRootPart(List selectedParts) {
		Map<EditPart, Integer> mark = new HashMap<EditPart, Integer>();
		EditPart[] current = new EditPart[selectedParts.size()];
		EditPart rootPart = null;
		int activeParts = 0, maxMark = 0;;
		
		// initialize 'current' array
		int j = 0;
		for (Object obj : selectedParts) {
			if (obj instanceof ConnectionEditPart) {
				current[j] = ((ConnectionEditPart)obj).getSource();
				activeParts++;
			}
			else if (obj instanceof EditPart) {
				current[j] = (EditPart)obj;
				activeParts++;
			}
			else {
				current[j] = null;
			}
			j++;
		}
		
		do {
			for (int i = 0; i < current.length; i++) {
				if (current[i] != null) {
					int newMark = 1;
					// get the mark status of the current part
					Integer markValue = mark.get(current[i]);
					if (markValue != null) {
						newMark = markValue.intValue() + 1;
					}
					mark.put(current[i], new Integer(newMark));
					if (newMark > maxMark) {
						rootPart = current[i];
						maxMark = newMark;
					}
					// get the parent of the current part
					EditPart parent = current[i].getParent();
					current[i] = parent;
					if (parent == null) {
						activeParts--;
					}
				}
			}
		} while (activeParts > 0);
		
		return rootPart;
	}


	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.ui.layout.AbstractLayoutGraphBuilder#updatePreferences()
	 */
	@Override
	protected void updatePreferences() {
		// load layout preferences
		IPreferenceStore preferenceStore = DataflowDiagramLayoutPlugin
				.getDefault().getPreferenceStore();
		fixedNodeSizePref = preferenceStore
				.getBoolean(DiagramLayoutPreferencePage.FIXED_NODE_SIZE);
		alternateHVPref = preferenceStore.getString(
				DiagramLayoutPreferencePage.LAYOUT_DIRECTION).equals(
				DiagramLayoutPreferencePage.VAL_ALTERNATING);
		
		String emptyPortVal = preferenceStore.getString(
		        DiagramLayoutPreferencePage.EMPTY_PORT_CONSTRAINTS);
		if (emptyPortVal.equals(DiagramLayoutPreferencePage.VAL_PORT_FIXED_POS))
		    emptyPortConstraints = PortConstraints.FIXED_POS;
		else if (emptyPortVal.equals(DiagramLayoutPreferencePage.VAL_PORT_FIXED_ORDER))
            emptyPortConstraints = PortConstraints.FIXED_ORDER;
		else if (emptyPortVal.equals(DiagramLayoutPreferencePage.VAL_PORT_FIXED_SIDE))
            emptyPortConstraints = PortConstraints.FIXED_SIDE;
		else emptyPortConstraints = PortConstraints.FREE_PORTS;
		
		String nonemptyPortVal = preferenceStore.getString(
                DiagramLayoutPreferencePage.NONEMPTY_PORT_CONSTRAINTS);
        if (nonemptyPortVal.equals(DiagramLayoutPreferencePage.VAL_PORT_FIXED_POS))
            nonemptyPortConstraints = PortConstraints.FIXED_POS;
        else if (nonemptyPortVal.equals(DiagramLayoutPreferencePage.VAL_PORT_FIXED_ORDER))
            nonemptyPortConstraints = PortConstraints.FIXED_ORDER;
        else if (nonemptyPortVal.equals(DiagramLayoutPreferencePage.VAL_PORT_FIXED_SIDE))
            nonemptyPortConstraints = PortConstraints.FIXED_SIDE;
        else nonemptyPortConstraints = PortConstraints.FREE_PORTS;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.ui.layout.AbstractLayoutGraphBuilder#resetCustomMaps()
	 */
	@Override
	protected void resetCustomMaps() {
		borderItem2PortMapping.clear();
	}
}
