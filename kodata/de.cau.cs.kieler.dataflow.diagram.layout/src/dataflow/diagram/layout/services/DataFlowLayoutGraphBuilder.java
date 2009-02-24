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
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;

import dataflow.diagram.edit.parts.DataflowModelEditPart;
import dataflow.diagram.edit.parts.InputPortEditPart;
import dataflow.diagram.layout.DataflowDiagramLayoutPlugin;
import dataflow.diagram.layout.preferences.DiagramLayoutPreferencePage;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphBuilder;
import de.cau.cs.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;

public class DataFlowLayoutGraphBuilder extends KimlAbstractLayoutGraphBuilder {

	/** inset value to be used for the top side of each node */
	private static final float INSET_TOP = 25.0f;
	/** inset value to be used for the bottom side of each node */
	private static final float INSET_BOTTOM = 5.0f;
	/** inset value to be used for the left side of each node */
	private static final float INSET_LEFT = 5.0f;
	/** inset value to be used for the right side of each node */
	private static final float INSET_RIGHT = 5.0f;

	/**
	 * Definition of possible edge types in a dataflow diagram with operators.
	 */
	private enum EdgeHierarchyType {
		INPUT_TO_OP, OP_TO_OP, OP_TO_OUTPUT
	}

	/** preference: preserve port positions for empty boxes */
	private boolean fixedOuterPortsPref;
	/** preference: preserve port positions for non-empty boxes */
	private boolean fixedInnerPortsPref;
	/** preference: preserve box size for empty boxes */
	private boolean fixedNodeSizePref;
	/** preference: fixed port sides for non-empty boxes */
	private boolean fixedPortSidesPref;
	/** preference: alternating layout direction */
	private boolean alternateHVPref;

	private Map<BorderedBorderItemEditPart, KLayoutPort> borderItem2PortMapping = new HashMap<BorderedBorderItemEditPart, KLayoutPort>();

	@Override
	protected void doBuildLayoutGraph() {
			
		IPreferenceStore preferenceStore = DataflowDiagramLayoutPlugin
				.getDefault().getPreferenceStore();
		KLayoutOption layoutDirection = preferenceStore.getString(
				DiagramLayoutPreferencePage.LAYOUT_DIRECTION)
				.equals("vertical") //$NON-NLS-1$
		? KLayoutOption.VERTICAL
				: KLayoutOption.HORIZONTAL;
		if (layoutRootPart instanceof DataflowModelEditPart) {
			layoutGraph = KimlLayoutGraphFactory.eINSTANCE.createKLayoutGraph();
			DataflowModelEditPart modelPart = (DataflowModelEditPart)layoutRootPart;
			layoutGraph.setIdString(Integer.toString((modelPart.hashCode())));
			// set the top node's layout
			KNodeLayout topGroupLayout = KimlLayoutGraphFactory.eINSTANCE
					.createKNodeLayout();
			createLayout(topGroupLayout, modelPart.getFigure());
			KInsets insets = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
			topGroupLayout.setInsets(insets);
			topGroupLayout.setLayouterName(KimlGMFLayoutHintHelper
					.getContainedElementsLayouterName(modelPart));
			topGroupLayout.setLayoutType(KimlGMFLayoutHintHelper
					.getContainedElementsLayoutType(modelPart));
			topGroupLayout.getLayoutOptions().add(layoutDirection);
			layoutGraph.setLayout(topGroupLayout);
			KNodeLabel topGroupLabel = KimlLayoutGraphFactory.eINSTANCE
					.createKNodeLabel();
			topGroupLabel.setText(modelPart.getDiagramView().getName());
			layoutGraph.setLabel(topGroupLabel);
			// build the whole graph structure
			if (alternateHVPref)
				layoutDirection = KLayoutOption.VERTICAL;
			buildLayoutGraphRecursively(modelPart.getChildren(), layoutGraph,
					layoutDirection);
		} else if (layoutRootPart instanceof AbstractBorderedShapeEditPart) {
			AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart) layoutRootPart;
			// build just the selected node
			layoutGraph = (KLayoutGraph) buildNode(boxEditPart,
					layoutDirection, true);
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
		KPoint kPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		kPoint.setX(figure.getBounds().x);
		kPoint.setY(figure.getBounds().y);
		shapeLayout.setLocation(kPoint);
		KDimension kDimension = KimlLayoutGraphFactory.eINSTANCE
				.createKDimension();
		kDimension.setHeight(figure.getBounds().height);
		kDimension.setWidth(figure.getBounds().width);
		shapeLayout.setSize(kDimension);
	}

	/**
	 * Sets the location and size properties of a shape layout and subtracts an
	 * offset value from its size.
	 * 
	 * @param shapeLayout
	 *            layout object to be changed
	 * @param figure
	 *            source object with layout information
	 * @param offset
	 *            by which the given figure is translated
	 */
	private static void createRelativeLayout(KShapeLayout shapeLayout,
			IFigure figure, KPoint offset) {
		KPoint kPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		kPoint.setX(figure.getBounds().x - offset.getX());
		kPoint.setY(figure.getBounds().y - offset.getY());
		shapeLayout.setLocation(kPoint);
		KDimension kDimension = KimlLayoutGraphFactory.eINSTANCE
				.createKDimension();
		kDimension.setHeight(figure.getBounds().height);
		kDimension.setWidth(figure.getBounds().width);
		shapeLayout.setSize(kDimension);
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
	@SuppressWarnings("unchecked")
	private void buildLayoutGraphRecursively(List children,
			KLayoutNode parentNode, KLayoutOption layoutDirection) {
		if (children != null) {
			// build layout nodes
			for (Object child : children) {
				if (child instanceof AbstractBorderedShapeEditPart) {
					AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart) child;
					KLayoutNode childNode = buildNode(boxEditPart,
							layoutDirection, false);
					// set the parent group; this automatically adds the node
					// to the parent's list of children
					childNode.setParentNode(parentNode);
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
	 * @param topNode
	 *            if true, a KLayoutGraph will be created, else a KLayoutNode
	 * @return the created layout node
	 */
	@SuppressWarnings("unchecked")
	private KLayoutNode buildNode(AbstractBorderedShapeEditPart boxEditPart,
			KLayoutOption layoutDirection, boolean topNode) {
		// add the new child node
		KLayoutNode childNode;
		if (topNode)
			childNode = KimlLayoutGraphFactory.eINSTANCE.createKLayoutGraph();
		else
			childNode = KimlLayoutGraphFactory.eINSTANCE.createKLayoutNode();
		layoutNode2EditPart.put(childNode, boxEditPart);
		childNode.setIdString(Integer.toString((boxEditPart.hashCode())));
		// set the child node's layout
		KNodeLayout nodeLayout = KimlLayoutGraphFactory.eINSTANCE
				.createKNodeLayout();
		createLayout(nodeLayout, boxEditPart.getFigure());
		KInsets insets = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
		insets.setLeft(INSET_LEFT);
		insets.setRight(INSET_RIGHT);
		insets.setTop(INSET_TOP);
		insets.setBottom(INSET_BOTTOM);
		nodeLayout.setInsets(insets);
		nodeLayout.setLayouterName(KimlGMFLayoutHintHelper
				.getContainedElementsLayouterName(boxEditPart));
		nodeLayout.setLayoutType(KimlGMFLayoutHintHelper
				.getContainedElementsLayoutType(boxEditPart));
		nodeLayout.getLayoutOptions().add(layoutDirection);
		childNode.setLayout(nodeLayout);
		// switch layout direction if needed
		if (alternateHVPref) {
			if (layoutDirection == KLayoutOption.VERTICAL)
				layoutDirection = KLayoutOption.HORIZONTAL;
			else
				layoutDirection = KLayoutOption.VERTICAL;
		}
		// set the input and output ports and node label
		List subChildren = null;
		for (Object nodeElement : boxEditPart.getChildren()) {
			if (nodeElement instanceof ShapeCompartmentEditPart) {
				subChildren = ((ShapeCompartmentEditPart) nodeElement)
						.getChildren();
			} else if (nodeElement instanceof BorderedBorderItemEditPart) {
				BorderedBorderItemEditPart borderItem = (BorderedBorderItemEditPart) nodeElement;
				// add the new port
				KLayoutPort port = KimlLayoutGraphFactory.eINSTANCE
						.createKLayoutPort();
				layoutPort2EditPart.put(port, borderItem);
				borderItem2PortMapping.put(borderItem, port);
				port
						.setType(borderItem instanceof InputPortEditPart ? KPortType.INPUT
								: KPortType.OUTPUT);
				port.setNode(childNode);
				// set the port's layout
				KPortLayout portLayout = KimlLayoutGraphFactory.eINSTANCE
						.createKPortLayout();
				createRelativeLayout(portLayout, borderItem.getFigure(),
						nodeLayout.getLocation());
				portLayout.setPlacement(getPortPlacement(nodeLayout,
						portLayout, port.getType(), layoutDirection));
				port.setLayout(portLayout);
				// set the port label
				for (Object portChild : borderItem.getChildren()) {
					if (portChild instanceof ITextAwareEditPart) {
						ITextAwareEditPart portNameEditPart = (ITextAwareEditPart) portChild;
						KPortLabel portLabel = KimlLayoutGraphFactory.eINSTANCE
								.createKPortLabel();
						portLabel.setText(portNameEditPart.getEditText());
						port.setLabel(portLabel);
						// set the port label's layout
						KPortLabelLayout labelLayout = KimlLayoutGraphFactory.eINSTANCE
								.createKPortLabelLayout();
						KPoint offset = KimlLayoutGraphFactory.eINSTANCE
								.createKPoint();
						offset.setX(nodeLayout.getLocation().getX()
								+ portLayout.getLocation().getX());
						offset.setY(nodeLayout.getLocation().getY()
								+ portLayout.getLocation().getY());
						createRelativeLayout(labelLayout, portNameEditPart
								.getFigure(), offset);
						portLabel.setLabelLayout(labelLayout);
					}
				}
			} else if (nodeElement instanceof ITextAwareEditPart) {
				ITextAwareEditPart boxNameEditPart = (ITextAwareEditPart) nodeElement;
				// add layout node label
				KNodeLabel nodeLabel = KimlLayoutGraphFactory.eINSTANCE
						.createKNodeLabel();
				nodeLabel.setText(boxNameEditPart.getEditText());
				childNode.setLabel(nodeLabel);
				// set the layout node label's layout
				KNodeLabelLayout labelLayout = KimlLayoutGraphFactory.eINSTANCE
						.createKNodeLabelLayout();
				createRelativeLayout(labelLayout,
						((WrappingLabel) boxNameEditPart.getFigure())
								.getTextFigure(), nodeLayout.getLocation());
				nodeLabel.setLabelLayout(labelLayout);
			}
		}

		// set layout options
		if (subChildren != null && !subChildren.isEmpty()) {
			if (fixedOuterPortsPref)
				nodeLayout.getLayoutOptions().add(KLayoutOption.FIXED_PORTS);
		} else {
			if (fixedInnerPortsPref)
				nodeLayout.getLayoutOptions().add(KLayoutOption.FIXED_PORTS);
			else if (fixedPortSidesPref)
				nodeLayout.getLayoutOptions().add(KLayoutOption.FIXED_PORT_SIDES);
			if (fixedNodeSizePref)
				nodeLayout.getLayoutOptions().add(KLayoutOption.FIXED_SIZE);
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
				KLayoutPort port1 = borderItem2PortMapping.get(portEditPart);
				for (Object portElement : portEditPart.getSourceConnections()) {
					if (portElement instanceof ConnectionEditPart) {
						ConnectionEditPart connectionEditPart = (ConnectionEditPart) portElement;
						KLayoutPort port2 = borderItem2PortMapping
								.get(connectionEditPart.getTarget());
						if (port2 != null) {
							// add the new edge according to its type
							if (port1.getType() == KPortType.OUTPUT
									&& port2.getType() == KPortType.INPUT) {
								if (processExternal
										&& port1.getNode().getParentNode() == port2
												.getNode().getParentNode()) {
									addEdge(port1, port2, connectionEditPart,
											EdgeHierarchyType.OP_TO_OP);
								}
							} else if (port1.getType() == KPortType.INPUT
									&& port2.getType() == KPortType.INPUT) {
								if (port1.getNode() == port2.getNode()
										.getParentNode()) {
									addEdge(port1, port2, connectionEditPart,
											EdgeHierarchyType.INPUT_TO_OP);
								}
							} else if (port1.getType() == KPortType.OUTPUT
									&& port2.getType() == KPortType.OUTPUT) {
								if (processExternal
										&& port1.getNode().getParentNode() == port2
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
	private void addEdge(KLayoutPort sourcePort, KLayoutPort targetPort,
			ConnectionEditPart connectionEditPart, EdgeHierarchyType edgeType) {
		KLayoutEdge edge = KimlLayoutGraphFactory.eINSTANCE.createKLayoutEdge();
		layoutEdge2EditPart.put(edge, connectionEditPart);
		float sourceNodeX = 0.0f, sourceNodeY = 0.0f, targetNodeX = 0.0f, targetNodeY = 0.0f;
		if (edgeType != EdgeHierarchyType.INPUT_TO_OP) {
			// set the source node; this automatically adds the edge
			// to the source's list of outgoing edges
			edge.setSource(sourcePort.getNode());
			sourceNodeX = sourcePort.getNode().getLayout().getLocation().getX();
			sourceNodeY = sourcePort.getNode().getLayout().getLocation().getY();
		}
		edge.setSourcePort(sourcePort);
		if (edgeType != EdgeHierarchyType.OP_TO_OUTPUT) {
			// set the target node; this automatically adds the edge to
			// the target's list of incoming edges
			edge.setTarget(targetPort.getNode());
			targetNodeX = targetPort.getNode().getLayout().getLocation().getX();
			targetNodeY = targetPort.getNode().getLayout().getLocation().getY();
		}
		edge.setTargetPort(targetPort);
		sourcePort.getEdges().add(edge);
		targetPort.getEdges().add(edge);
		// set the edge's layout
		KEdgeLayout edgeLayout = KimlLayoutGraphFactory.eINSTANCE
				.createKEdgeLayout();
		KPoint sourcePoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		sourcePoint
				.setX(sourcePort.getLayout().getLocation().getX()
						+ sourcePort.getLayout().getSize().getWidth() / 2
						+ sourceNodeX);
		sourcePoint.setY(sourcePort.getLayout().getLocation().getY()
				+ sourcePort.getLayout().getSize().getHeight() / 2
				+ sourceNodeY);
		edgeLayout.setSourcePoint(sourcePoint);
		KPoint targetPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		targetPoint
				.setX(targetPort.getLayout().getLocation().getX()
						+ targetPort.getLayout().getSize().getWidth() / 2
						+ targetNodeX);
		targetPoint.setY(targetPort.getLayout().getLocation().getY()
				+ targetPort.getLayout().getSize().getHeight() / 2
				+ targetNodeY);
		edgeLayout.setTargetPoint(targetPoint);
		edge.setLayout(edgeLayout);
	}

	/**
	 * Determines the port placement from a given node and port layout.
	 * 
	 * @param nodeLayout
	 *            layout object of the corresponding node
	 * @param portLayout
	 *            layout object of the corresponding port
	 * @param portType
	 *            port type
	 * @param layoutDirection
	 *            layout direction
	 * @return port placement
	 */
	private KPortPlacement getPortPlacement(KNodeLayout nodeLayout,
			KPortLayout portLayout, KPortType portType,
			KLayoutOption layoutDirection) {
		// determine port placement from port position
		float nodeWidth = nodeLayout.getSize().getWidth();
		float nodeHeight = nodeLayout.getSize().getHeight();
		float relx = (portLayout.getLocation().getX() + portLayout
				.getSize().getWidth() / 2)
				- (nodeWidth / 2);
		float rely = (portLayout.getLocation().getY() + portLayout
				.getSize().getHeight() / 2)
				- (nodeHeight / 2);

		if (relx > nodeWidth / 4 && rely > -nodeHeight / 2 + 3
				&& rely < nodeHeight / 2 - 3)
			return KPortPlacement.EAST;
		if (relx < -nodeWidth / 4 && rely > -nodeHeight / 2 + 3
				&& rely < nodeHeight / 2 - 3)
			return KPortPlacement.WEST;
		if (rely > nodeHeight / 4 && relx > -nodeWidth / 2 + 3
				&& relx < nodeWidth / 2 - 3)
			return KPortPlacement.SOUTH;
		if (rely < -nodeHeight / 4 && relx > -nodeWidth / 2 + 3
				&& relx < nodeWidth / 2 - 3)
			return KPortPlacement.NORTH;

		// determine port placement from port type
		if (layoutDirection == KLayoutOption.VERTICAL) {
			if (portType == KPortType.INPUT)
				return KPortPlacement.NORTH;
			else
				return KPortPlacement.SOUTH;
		} else {
			if (portType == KPortType.INPUT)
				return KPortPlacement.WEST;
			else
				return KPortPlacement.EAST;
		}
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
	 * @see de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphBuilder#updatePreferences()
	 */
	@Override
	protected void updatePreferences() {
		// load layout preferences
		IPreferenceStore preferenceStore = DataflowDiagramLayoutPlugin
				.getDefault().getPreferenceStore();
		fixedOuterPortsPref = preferenceStore
				.getBoolean(DiagramLayoutPreferencePage.FIXED_OUTER_PORTS);
		fixedNodeSizePref = preferenceStore
				.getBoolean(DiagramLayoutPreferencePage.FIXED_NODE_SIZE);
		fixedInnerPortsPref = preferenceStore.getString(
				DiagramLayoutPreferencePage.PORT_CONSTRAINTS).equals(
				DiagramLayoutPreferencePage.VAL_FIXED_PORTS);
		fixedPortSidesPref = preferenceStore.getString(
				DiagramLayoutPreferencePage.PORT_CONSTRAINTS).equals(
						DiagramLayoutPreferencePage.VAL_FIXED_SIDES);
		alternateHVPref = preferenceStore.getString(
				DiagramLayoutPreferencePage.LAYOUT_DIRECTION).equals(
				DiagramLayoutPreferencePage.VAL_ALTERNATING);
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlAbstractLayoutGraphBuilder#resetCustomMaps()
	 */
	@Override
	protected void resetCustomMaps() {
		borderItem2PortMapping.clear();
	}
}
