package dataflow.diagram.services;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;

import dataflow.diagram.edit.parts.*;
import dataflow.diagram.DataflowDiagramLayoutPlugin;
import dataflow.diagram.Messages;
import dataflow.diagram.part.DataflowDiagramEditor;
import dataflow.diagram.preferences.DiagramLayoutPreferencePage;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.*;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouter;
import de.cau.cs.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import de.cau.cs.kieler.kiml.ui.policies.LayoutEditPolicy;


/**
 * This layouter for dataflow diagrams performs the needed transformation
 * from diagram elements to the KIML Layout Graph structure and applies layout
 * information from the layout engine.
 * 
 * @author msp
 */
public class DataflowDiagramLayouter extends KimlAbstractLayouter {

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
		INPUT_TO_OP,
		OP_TO_OP,
		OP_TO_OUTPUT
	}
	
	/** root edit part used for layout */
	private EditPart layoutRootPart = null;
	/** generated layout graph */
	private KLayoutGraph layoutGraph = null;

	/** mapping used for back transformation */
	private Map<KLayoutNode, AbstractBorderedShapeEditPart> node2BoxMapping = new LinkedHashMap<KLayoutNode, AbstractBorderedShapeEditPart>();
	/** mapping used for back transformation */
	private Map<KLayoutEdge, ConnectionEditPart> edge2ConnectionMapping = new LinkedHashMap<KLayoutEdge, ConnectionEditPart>();
	/** mapping used for back transformation */
	private Map<KLayoutPort, BorderedBorderItemEditPart> port2BorderItemMapping = new LinkedHashMap<KLayoutPort, BorderedBorderItemEditPart>();
	/** mapping used for creation of the layout graph */
	private Map<BorderedBorderItemEditPart, KLayoutPort> borderItem2PortMapping = new HashMap<BorderedBorderItemEditPart, KLayoutPort>();
	
	/** label provider for the elements of dataflow diagrams */
	private ILabelProvider dataflowLabelProvider = new DataflowLabelProvider();
	
	/** preference: preserve port positions for empty boxes */
	private boolean fixedOuterPortsPref;
	/** preference: preserve port positions for non-empty boxes */
	private boolean fixedInnerPortsPref;
	/** preference: preserve box size for empty boxes */
	private boolean fixedNodeSizePref;
	/** preference: strict port side: left for input ports, right for output ports */
	private boolean strictPortSide;
	/** preference: alternating layout direction */
	private boolean alternateHV;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouter#getLabelProvider()
	 */
	public ILabelProvider getLabelProvider() {
		return dataflowLabelProvider;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouter#init(java.lang.Object)
	 */
	protected void init(Object target) {
		node2BoxMapping.clear();
		edge2ConnectionMapping.clear();
		port2BorderItemMapping.clear();
		borderItem2PortMapping.clear();
		
		// load layout preferences
		IPreferenceStore preferenceStore = DataflowDiagramLayoutPlugin
				.getDefault().getPreferenceStore();
		fixedOuterPortsPref = preferenceStore.getBoolean(DiagramLayoutPreferencePage.FIXED_OUTER_PORTS);
		fixedInnerPortsPref = preferenceStore.getBoolean(DiagramLayoutPreferencePage.FIXED_INNER_PORTS);
		fixedNodeSizePref = preferenceStore.getBoolean(DiagramLayoutPreferencePage.FIXED_NODE_SIZE);
		strictPortSide = preferenceStore.getBoolean(DiagramLayoutPreferencePage.STRICT_PORT_SIDE);
		alternateHV = preferenceStore.getString(DiagramLayoutPreferencePage.LAYOUT_DIRECTION).equals("hv"); 
		
		// find the dataflow model edit part depending on the type of input
		if (target instanceof DiagramRootEditPart) {
			DiagramRootEditPart editor = (DiagramRootEditPart)target;
			layoutRootPart = editor.getContents();
		}
		else if (target instanceof DiagramDocumentEditor) {
			DiagramDocumentEditor documentEditor = (DiagramDocumentEditor)target;
			layoutRootPart = documentEditor.getDiagramEditPart();
		}
		else if (target instanceof DataflowModelEditPart) {
			DataflowModelEditPart editPart = (DataflowModelEditPart)target;
			DiagramRootEditPart editor = (DiagramRootEditPart) editPart.getRoot();
			layoutRootPart = editor.getContents();
		}
		else if (target instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)target;
			layoutRootPart = findRootPart(selection.toList());
			// check for special cases
			if (layoutRootPart instanceof CompartmentEditPart
					|| layoutRootPart instanceof BorderedBorderItemEditPart) {
				// BoxBoxCompartmentEditPart, BoxNameEditPart
				layoutRootPart = layoutRootPart.getParent();
			}
			else if (layoutRootPart instanceof LabelEditPart) {
				// InputPortNameEditPart, OutputPortNameEditPart
				layoutRootPart = layoutRootPart.getParent().getParent();
			}
			else if (layoutRootPart instanceof DiagramRootEditPart) {
				// RenderedDiagramRootEditPart
				layoutRootPart = ((DiagramRootEditPart)layoutRootPart).getContents();
			}
		}
		else throw new IllegalArgumentException(Messages.getString("dataflow.layout.1") //$NON-NLS-1$
				+ target.getClass().getSimpleName());
	}

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouter#buildLayoutGraph()
	 */
	protected KLayoutGraph buildLayoutGraph() {
		IPreferenceStore preferenceStore = DataflowDiagramLayoutPlugin
				.getDefault().getPreferenceStore();
		KLayoutOption layoutDirection = preferenceStore.getString(DiagramLayoutPreferencePage.LAYOUT_DIRECTION).equals("vertical") //$NON-NLS-1$
				? KLayoutOption.VERTICAL : KLayoutOption.HORIZONTAL;
		if (layoutRootPart instanceof DataflowModelEditPart) {
			layoutGraph = KimlLayoutGraphFactory.eINSTANCE.createKLayoutGraph();
			DataflowModelEditPart modelPart = (DataflowModelEditPart)layoutRootPart;
			layoutGraph.setIdString(Integer.toString((modelPart.hashCode())));
			// set the top node's layout
			KNodeLayout topGroupLayout = KimlLayoutGraphFactory.eINSTANCE.createKNodeLayout();
			createLayout(topGroupLayout, modelPart.getFigure());
			KInsets insets = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
			topGroupLayout.setInsets(insets);
			topGroupLayout.setLayouterName(KimlGMFLayoutHintHelper.getContainedElementsLayouterName(modelPart));
			topGroupLayout.setLayoutType(KimlGMFLayoutHintHelper.getContainedElementsLayoutType(modelPart));
			topGroupLayout.getLayoutOptions().add(layoutDirection);
			layoutGraph.setLayout(topGroupLayout);
			KNodeLabel topGroupLabel = KimlLayoutGraphFactory.eINSTANCE.createKNodeLabel();
			topGroupLabel.setText(modelPart.getDiagramView().getName());
			layoutGraph.setLabel(topGroupLabel);
			// build the whole graph structure
			if (alternateHV)
				layoutDirection = KLayoutOption.VERTICAL;
			buildLayoutGraphRecursively(modelPart.getChildren(), layoutGraph, layoutDirection);
		}
		else if (layoutRootPart instanceof AbstractBorderedShapeEditPart) {
			AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart)layoutRootPart;
			// build just the selected node
			layoutGraph = (KLayoutGraph)buildNode(boxEditPart, layoutDirection, true);
			buildNodeEdges(boxEditPart, false);
		}
		
		return layoutGraph;
	}

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouter#applyLayout()
	 */
	@SuppressWarnings("unchecked")
	protected void applyLayout() {
		ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart)layoutRootPart.getRoot();
		double zoomLevel = rootEditPart.getZoomManager().getZoom();
		
		// apply node layouts
		CompoundCommand nodesCC = new CompoundCommand();
		for (KLayoutNode layoutNode : node2BoxMapping.keySet()) {
			AbstractBorderedShapeEditPart boxEditPart = node2BoxMapping.get(layoutNode);
			KNodeLayout nodeLayout = layoutNode.getLayout();
			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
			changeBoundsRequest.setEditParts(boxEditPart);
			
			Dimension oldSize = boxEditPart.getFigure().getBounds().getSize();
			PrecisionDimension newSize = new PrecisionDimension(nodeLayout.getSize().getWidth(),
					nodeLayout.getSize().getHeight());

			Dimension sizeDelta = new PrecisionDimension(newSize.preciseWidth - oldSize.width,
					newSize.preciseHeight - oldSize.height);
			changeBoundsRequest.setResizeDirection(PositionConstants.CENTER);
			changeBoundsRequest.setSizeDelta(sizeDelta.scale(zoomLevel));

			Point oldLocation = boxEditPart.getFigure().getBounds().getLocation();
			PrecisionPoint newLocation = new PrecisionPoint(nodeLayout.getLocation().getX(),
					nodeLayout.getLocation().getY());

			Point moveDelta = new PrecisionPoint(newLocation.preciseX - oldLocation.x,
					newLocation.preciseY - oldLocation.y);
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
			changeBoundsRequest.setLocation(newLocation);
			
			nodesCC.add(boxEditPart.getCommand(changeBoundsRequest));
		}
		
		// apply port layouts
		CompoundCommand portsCC = new CompoundCommand();
		for (KLayoutPort port : port2BorderItemMapping.keySet()) {
			BorderedBorderItemEditPart borderItem = port2BorderItemMapping.get(port);
			KPoint portLocation = port.getLayout().getLocation();
			Point nodeLocation = node2BoxMapping.get(port.getNode())
					.getFigure().getBounds().getLocation();
			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
			changeBoundsRequest.setEditParts(borderItem);
			
			Point oldLocation = borderItem.getFigure().getBounds().getLocation();
			PrecisionPoint newLocation = new PrecisionPoint(portLocation.getX()
					+ nodeLocation.x, portLocation.getY() + nodeLocation.y);

			Point moveDelta = new PrecisionPoint(newLocation.preciseX - oldLocation.x,
					newLocation.preciseY - oldLocation.y);
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
			changeBoundsRequest.setLocation(newLocation);
			
			// set the automatic layout option in the extended data
			changeBoundsRequest.getExtendedData().put(LayoutEditPolicy.AUTO_LAYOUT_KEY, Boolean.TRUE);
			portsCC.add(borderItem.getCommand(changeBoundsRequest));
		}

		// apply edge layouts
		final CompoundCommand edgesCC = new CompoundCommand();
		for (KLayoutEdge edge : edge2ConnectionMapping.keySet()) {
			ConnectionEditPart connection = edge2ConnectionMapping.get(edge);
			KEdgeLayout edgeLayout = edge.getLayout();
			PointList pointList = new PointList();
			Point offset = getConnectionOffset(edge);
			
			// set start point
			Point startPoint = kPoint2Point(edgeLayout.getSourcePoint())
					.translate(offset);
			pointList.addPoint(startPoint);

			// set grid points
			for (KPoint gridPoint : edgeLayout.getGridPoints()) {
				Point point = kPoint2Point(gridPoint).translate(offset);
				pointList.addPoint(point);
			}

			// set end point
			Point endPoint = kPoint2Point(edgeLayout.getTargetPoint())
					.translate(offset);
			pointList.addPoint(endPoint);

			// create request and add it
			SetAllBendpointRequest request = new SetAllBendpointRequest(
					RequestConstants.REQ_SET_ALL_BENDPOINT,	pointList,
					startPoint, endPoint);
			edgesCC.add(connection.getCommand(request));
		}
		
		Object adapter = getEditor().getAdapter(CommandStack.class);
		if (adapter instanceof DiagramCommandStack) {
			final DiagramCommandStack commandStack = (DiagramCommandStack)adapter;
			CompoundCommand compoundCommand = new CompoundCommand();
			compoundCommand.setLabel(Messages.getString("dataflow.layout.2")); //$NON-NLS-1$
			compoundCommand.add(nodesCC);
			compoundCommand.add(portsCC);
			compoundCommand.add(edgesCC);
			commandStack.execute(compoundCommand);
		}
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
	
	/**
	 * Sets the location and size properties of a shape layout.
	 * 
	 * @param shapeLayout layout object to be changed
	 * @param figure source object with layout information
	 */
	private static void createLayout(KShapeLayout shapeLayout, IFigure figure) {
		KPoint kPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		kPoint.setX(figure.getBounds().x);
		kPoint.setY(figure.getBounds().y);
		shapeLayout.setLocation(kPoint);
		KDimension kDimension = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
		kDimension.setHeight(figure.getBounds().height);
		kDimension.setWidth(figure.getBounds().width);
		shapeLayout.setSize(kDimension);
	}
	
	/**
	 * Sets the location and size properties of a shape layout and subtracts
	 * an offset value from its size.
	 * 
	 * @param shapeLayout layout object to be changed
	 * @param figure source object with layout information
	 * @param offset by which the given figure is translated
	 */
	private static void createRelativeLayout(KShapeLayout shapeLayout,
			IFigure figure, KPoint offset) {
		KPoint kPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		kPoint.setX(figure.getBounds().x - offset.getX());
		kPoint.setY(figure.getBounds().y - offset.getY());
		shapeLayout.setLocation(kPoint);
		KDimension kDimension = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
		kDimension.setHeight(figure.getBounds().height);
		kDimension.setWidth(figure.getBounds().width);
		shapeLayout.setSize(kDimension);
	}
	
	/**
	 * Processes the elements and all sub-elements of a node by recursive call.
	 * 
	 * @param children list of child elements of a node
	 * @param parentNode parent layout node
	 * @param layoutDirection layout direction
	 */
	@SuppressWarnings("unchecked")
	private void buildLayoutGraphRecursively(List children, KLayoutNode parentNode,
			KLayoutOption layoutDirection) {
		if (children != null)
		{
			// build layout nodes
			for (Object child : children) {
				if (child instanceof AbstractBorderedShapeEditPart) {
					AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart)child;
					KLayoutNode childNode = buildNode(boxEditPart, layoutDirection, false);
					// set the parent group; this automatically adds the node
					// to the parent's list of children
					childNode.setParentNode(parentNode);
				}
			}
			
			// build edges
			for (Object child : children) {
				if (child instanceof AbstractBorderedShapeEditPart) {
					AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart)child;
					buildNodeEdges(boxEditPart, true);
				}
			}
		}
	}
	
	/**
	 * Builds the layout graph for a given node edit part.
	 * 
	 * @param boxEditPart edit part for which the layout graph shall be built
	 * @param layoutDirection layout direction
	 * @param topNode if true, a KLayoutGraph will be created, else a KLayoutNode
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
		node2BoxMapping.put(childNode, boxEditPart);
		childNode.setIdString(Integer.toString((boxEditPart.hashCode())));
		// set the child node's layout
		KNodeLayout nodeLayout = KimlLayoutGraphFactory.eINSTANCE.createKNodeLayout();
		createLayout(nodeLayout, boxEditPart.getFigure());
		KInsets insets = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
		insets.setLeft(INSET_LEFT);
		insets.setRight(INSET_RIGHT);
		insets.setTop(INSET_TOP);
		insets.setBottom(INSET_BOTTOM);
		nodeLayout.setInsets(insets);
		nodeLayout.setLayouterName(KimlGMFLayoutHintHelper.getContainedElementsLayouterName(boxEditPart));
		nodeLayout.setLayoutType(KimlGMFLayoutHintHelper.getContainedElementsLayoutType(boxEditPart));
		nodeLayout.getLayoutOptions().add(layoutDirection);
		childNode.setLayout(nodeLayout);
		// switch layout direction if needed
		if (alternateHV) {
			if (layoutDirection == KLayoutOption.VERTICAL)
				layoutDirection = KLayoutOption.HORIZONTAL;
			else
				layoutDirection = KLayoutOption.VERTICAL;
		}
		// set the input and output ports and node label
		List subChildren = null;
		for (Object nodeElement : boxEditPart.getChildren()) {
			if (nodeElement instanceof ShapeCompartmentEditPart) {
				subChildren = ((ShapeCompartmentEditPart)nodeElement).getChildren();
			}
			else if (nodeElement instanceof BorderedBorderItemEditPart) {
				BorderedBorderItemEditPart borderItem = (BorderedBorderItemEditPart)nodeElement;
				// add the new port
				KLayoutPort port = KimlLayoutGraphFactory.eINSTANCE.createKLayoutPort();
				port2BorderItemMapping.put(port, borderItem);
				borderItem2PortMapping.put(borderItem, port);
				port.setType(borderItem instanceof InputPortEditPart ? KPortType.INPUT : KPortType.OUTPUT);
				port.setNode(childNode);
				// set the port's layout
				KPortLayout portLayout = KimlLayoutGraphFactory.eINSTANCE.createKPortLayout();
				createRelativeLayout(portLayout, borderItem.getFigure(),
						nodeLayout.getLocation());
				portLayout.setPlacement(getPortPlacement(nodeLayout,
						portLayout, port.getType(), layoutDirection));
				port.setLayout(portLayout);
				// set the port label
				for (Object portChild : borderItem.getChildren()) {
					if (portChild instanceof ITextAwareEditPart) {
						ITextAwareEditPart portNameEditPart = (ITextAwareEditPart)portChild;
						KPortLabel portLabel = KimlLayoutGraphFactory.eINSTANCE.createKPortLabel();
						portLabel.setText(portNameEditPart.getEditText());
						port.setLabel(portLabel);
						// set the port label's layout
						KPortLabelLayout labelLayout = KimlLayoutGraphFactory.eINSTANCE.createKPortLabelLayout();
						KPoint offset = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
						offset.setX(nodeLayout.getLocation().getX()
								+ portLayout.getLocation().getX());
						offset.setY(nodeLayout.getLocation().getY()
								+ portLayout.getLocation().getY());
						createRelativeLayout(labelLayout, portNameEditPart.getFigure(), offset);
						portLabel.setLabelLayout(labelLayout);
					}
				}
			}
			else if (nodeElement instanceof ITextAwareEditPart) {
				ITextAwareEditPart boxNameEditPart = (ITextAwareEditPart)nodeElement;
				// add layout node label
				KNodeLabel nodeLabel = KimlLayoutGraphFactory.eINSTANCE.createKNodeLabel();
				nodeLabel.setText(boxNameEditPart.getEditText());
				childNode.setLabel(nodeLabel);
				// set the layout node label's layout
				KNodeLabelLayout labelLayout = KimlLayoutGraphFactory.eINSTANCE.createKNodeLabelLayout();
				createRelativeLayout(labelLayout, ((WrappingLabel)boxNameEditPart.getFigure()).getTextFigure(),
						nodeLayout.getLocation());
				nodeLabel.setLabelLayout(labelLayout);
			}
		}
		
		// set fixed ports option
		if (subChildren != null && !subChildren.isEmpty()) {
			if (fixedOuterPortsPref)
				nodeLayout.getLayoutOptions().add(KLayoutOption.FIXED_PORTS);
		}
		else {
			if (fixedInnerPortsPref)
				nodeLayout.getLayoutOptions().add(KLayoutOption.FIXED_PORTS);
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
	 * @param boxEditPart edit part whose edges shall be built
	 * @param processExternal indicates whether edges to nodes of the same or
	 *     higher hierarchy level should be processed
	 */
	private void buildNodeEdges(AbstractBorderedShapeEditPart boxEditPart,
			boolean processExternal) {
		for (Object nodeElement : boxEditPart.getChildren()) {
			if (nodeElement instanceof BorderedBorderItemEditPart) {
				BorderedBorderItemEditPart portEditPart = (BorderedBorderItemEditPart)nodeElement;
				KLayoutPort port1 = borderItem2PortMapping.get(portEditPart);
				for (Object portElement : portEditPart.getSourceConnections()) {
					if (portElement instanceof ConnectionEditPart) {
						ConnectionEditPart connectionEditPart = (ConnectionEditPart)portElement;
						KLayoutPort port2 = borderItem2PortMapping.get(connectionEditPart.getTarget());
						if (port2 != null) {
							// add the new edge according to its type
							if (port1.getType() == KPortType.OUTPUT && port2.getType() == KPortType.INPUT) {
								if (processExternal && port1.getNode().getParentNode()
										== port2.getNode().getParentNode()) {
									addEdge(port1, port2, connectionEditPart, EdgeHierarchyType.OP_TO_OP);
								}
							}
							else if (port1.getType() == KPortType.INPUT && port2.getType() == KPortType.INPUT) {
								if (port1.getNode() == port2.getNode().getParentNode()) {
									addEdge(port1, port2, connectionEditPart, EdgeHierarchyType.INPUT_TO_OP);
								}
							}
							else if (port1.getType() == KPortType.OUTPUT && port2.getType() == KPortType.OUTPUT) {
								if (processExternal && port1.getNode().getParentNode()
										== port2.getNode()) {
									addEdge(port1, port2, connectionEditPart, EdgeHierarchyType.OP_TO_OUTPUT);
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * Adds an edge to the KLayoutGraph. If the edge goes to an sub-node,
	 * it is not added to the incoming or outgoing edges of the parent
	 * node, but only to those of the sub-node.
	 * 
	 * @param sourcePort source port of the edge
	 * @param targetPort target port of the edge
	 * @param connectionEditPart edit part related to the edge
	 * @param edgeType hierarchy type of the edge
	 */
	private void addEdge(KLayoutPort sourcePort, KLayoutPort targetPort,
			ConnectionEditPart connectionEditPart, EdgeHierarchyType edgeType) {
		KLayoutEdge edge = KimlLayoutGraphFactory.eINSTANCE.createKLayoutEdge();
		edge2ConnectionMapping.put(edge, connectionEditPart);
		float sourceNodeX = 0.0f, sourceNodeY = 0.0f,
			targetNodeX = 0.0f, targetNodeY = 0.0f;
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
		KEdgeLayout edgeLayout = KimlLayoutGraphFactory.eINSTANCE.createKEdgeLayout();
		KPoint sourcePoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		sourcePoint.setX(sourcePort.getLayout().getLocation().getX()
				+ sourcePort.getLayout().getSize().getWidth() / 2 + sourceNodeX);
		sourcePoint.setY(sourcePort.getLayout().getLocation().getY()
				+ sourcePort.getLayout().getSize().getHeight() / 2 + sourceNodeY);
		edgeLayout.setSourcePoint(sourcePoint);
		KPoint targetPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		targetPoint.setX(targetPort.getLayout().getLocation().getX()
				+ targetPort.getLayout().getSize().getWidth() / 2 + targetNodeX);
		targetPoint.setY(targetPort.getLayout().getLocation().getY()
				+ targetPort.getLayout().getSize().getHeight() / 2 + targetNodeY);
		edgeLayout.setTargetPoint(targetPoint);
		edge.setLayout(edgeLayout);
	}
	
	/**
	 * Determines the port placement from a given node and port layout.
	 * 
	 * @param nodeLayout layout object of the corresponding node
	 * @param portLayout layout object of the corresponding port
	 * @param portType port type
	 * @param layoutDirection layout direction
	 * @return port placement
	 */
	private KPortPlacement getPortPlacement(KNodeLayout nodeLayout,
			KPortLayout portLayout, KPortType portType,
			KLayoutOption layoutDirection) {
		if (!strictPortSide) {
			// determine port placement from port position
			float nodeWidth = nodeLayout.getSize().getWidth();
			float nodeHeight = nodeLayout.getSize().getHeight();
			float relx = (portLayout.getLocation().getX() + portLayout.getSize().getWidth() / 2)
				- (nodeWidth / 2);
			float rely = (portLayout.getLocation().getY() + portLayout.getSize().getHeight() / 2)
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
		}
		// determine port placement from port type
		if (layoutDirection == KLayoutOption.VERTICAL) {
			if (portType == KPortType.INPUT)
				return KPortPlacement.NORTH;
			else
				return KPortPlacement.SOUTH;
		}
		else {
			if (portType == KPortType.INPUT)
				return KPortPlacement.WEST;
			else
				return KPortPlacement.EAST;
		}
	}
	
	/**
	 * Determines the offset to apply to a given edge, depending on the
	 * position of all parent layout nodes.
	 * 
	 * @param edge edge for which the offset shall be determined 
	 * @return offset
	 */
	private Point getConnectionOffset(KLayoutEdge edge) {
		PrecisionPoint point = new PrecisionPoint(0, 0);
		KLayoutNode parent = edge.getSource();
		if (parent == null)
			parent = edge.getTarget().getParentNode();
		else
			parent = parent.getParentNode();
		
		while (parent.getParentNode() != null) {
			point.preciseX += parent.getLayout().getLocation().getX();
			point.preciseY += parent.getLayout().getLocation().getY();
			parent = parent.getParentNode();
			point.preciseX += parent.getLayout().getInsets().getLeft();
			point.preciseY += parent.getLayout().getInsets().getTop();
		}
		
		return point;
	}

	/**
	 * Converts a KIML Layout Graph point to a Draw2D point.
	 * 
	 * @param kpoint layout graph point
	 * @return Draw2D point
	 */
	private Point kPoint2Point(KPoint kpoint) {
		return new Point(kpoint.getX(), kpoint.getY());
	}
	
	/**
	 * Retrieves the currently active editor from the platform UI.
	 * TODO find a way to dispense with PlatformUI
	 * 
	 * @return the active dataflow diagram editor
	 */
	private DataflowDiagramEditor getEditor() {
		return (DataflowDiagramEditor)PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}

}
