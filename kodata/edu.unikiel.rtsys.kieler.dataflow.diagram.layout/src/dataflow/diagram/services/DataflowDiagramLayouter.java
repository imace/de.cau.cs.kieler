package dataflow.diagram.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
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
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;

import dataflow.diagram.edit.parts.*;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;

/**
 * This layouter for dataflow diagrams performs the needed transformation
 * from diagram elements to the KIML Layout Graph structure and applies layout
 * information from the layout engine.
 * 
 * @author msp
 */
public class DataflowDiagramLayouter extends KimlAbstractLayouter {

	/** Inset value to be used for each node */
	private static final float BORDER_INSET = 10.0f;
	
	/**
	 * Definition of possible edge types in a dataflow diagram with operators.
	 */
	private enum EdgeHierarchyType {
		INPUT_TO_OP,
		OP_TO_OP,
		OP_TO_OUTPUT
	}
	
	private EditPart layoutRootPart = null;
	private KLayoutGraph layoutGraph = null;
	
	private Map<KNodeGroup, AbstractBorderedShapeEditPart> nodeGroup2BoxMapping = new HashMap<KNodeGroup, AbstractBorderedShapeEditPart>();
	private Map<KEdge, ConnectionEditPart> edge2ConnectionMapping = new HashMap<KEdge, ConnectionEditPart>();
	private Map<KPort, BorderedBorderItemEditPart> port2BorderItemMapping = new HashMap<KPort, BorderedBorderItemEditPart>();
	private Map<BorderedBorderItemEditPart, KPort> borderItem2PortMapping = new HashMap<BorderedBorderItemEditPart, KPort>();
	
	private ILabelProvider dataflowLabelProvider = new DataflowLabelProvider();
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#getLabelProvider()
	 */
	public ILabelProvider getLabelProvider() {
		return dataflowLabelProvider;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#init(java.lang.Object)
	 */
	protected boolean init(Object target) {
		nodeGroup2BoxMapping.clear();
		edge2ConnectionMapping.clear();
		port2BorderItemMapping.clear();
		borderItem2PortMapping.clear();
		
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
			
			// check for unexpected case
			if (!(layoutRootPart instanceof AbstractBorderedShapeEditPart)
					&& !(layoutRootPart instanceof DataflowModelEditPart)) {
				// TODO remove debug message
				System.out.println("DataflowDiagramLayouter: Unexpected layout root part: "
						+ layoutRootPart.getClass().getSimpleName());
			}
		}
		else return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#buildLayoutGraph()
	 */
	protected KLayoutGraph buildLayoutGraph() {
		layoutGraph = KimlLayoutGraphFactory.eINSTANCE.createKLayoutGraph();
		if (layoutRootPart instanceof DataflowModelEditPart) {
			DataflowModelEditPart modelPart = (DataflowModelEditPart)layoutRootPart;
			// the layout graph always has a top node
			KNodeGroup topNode = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroup();
			layoutGraph.setTopGroup(topNode);
			topNode.setIdString(Integer.toString((modelPart.hashCode())));
			// set the top node's layout
			KNodeGroupLayout topGroupLayout = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroupLayout();
			createLayout(topGroupLayout, modelPart.getFigure());
			topGroupLayout.setInsets(KimlLayoutGraphFactory.eINSTANCE.createKInsets());
			topGroupLayout.setLayouterName(KimlGMFLayoutHintHelper.getLayouterName(modelPart));
			topGroupLayout.setLayoutType(KimlGMFLayoutHintHelper.getLayoutType(modelPart));
			topNode.setLayout(topGroupLayout);
			KNodeGroupLabel topGroupLabel = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroupLabel();
			topGroupLabel.setText(modelPart.getDiagramView().getName());
			topNode.setLabel(topGroupLabel);
			// build the whole graph structure
			buildLayoutGraphRecursively(modelPart.getChildren(), topNode);
		}
		else if (layoutRootPart instanceof AbstractBorderedShapeEditPart) {
			AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart)layoutRootPart;
			// build just the selected node
			layoutGraph.setTopGroup(buildNode(boxEditPart));
			buildNodeEdges(boxEditPart, false);
		}
		
		return layoutGraph;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#applyLayout()
	 */
	protected void applyLayout() {
		// prepare changes to GMF diagram
		DiagramCommandStack commandStack = new DiagramCommandStack(null);
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.setLabel("Dataflow Diagram Layout");
		ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart)layoutRootPart.getRoot();
		double zoomLevel = rootEditPart.getZoomManager().getZoom();
		
		// apply node layouts
		for (KNodeGroup nodeGroup : nodeGroup2BoxMapping.keySet()) {
			AbstractBorderedShapeEditPart boxEditPart = nodeGroup2BoxMapping.get(nodeGroup);
			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
			changeBoundsRequest.setEditParts(boxEditPart);
			
			Dimension oldSize = boxEditPart.getFigure().getBounds().getSize();
			Dimension newSize = kDimension2Dimension(nodeGroup.getLayout().getSize());

			Dimension sizeDelta = newSize.getExpanded(oldSize.negate());
			changeBoundsRequest.setResizeDirection(PositionConstants.CENTER);
			changeBoundsRequest.setSizeDelta(sizeDelta.scale(zoomLevel));

			Point oldLocation = boxEditPart.getFigure().getBounds().getLocation();
			Point newLocation = kPoint2Point(nodeGroup.getLayout().getLocation());

			Point moveDelta = newLocation.getTranslated(oldLocation.negate());
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
			
			compoundCommand.add(boxEditPart.getCommand(changeBoundsRequest));
		}
		
		// apply port layouts
		for (KPort port : port2BorderItemMapping.keySet()) {
			BorderedBorderItemEditPart borderItem = port2BorderItemMapping.get(port);
			ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
			changeBoundsRequest.setEditParts(borderItem);
			
			Point oldLocation = borderItem.getFigure().getBounds().getLocation();
			Point newLocation = kPoint2Point(port.getLayout().getLocation());

			Point moveDelta = newLocation.getTranslated(oldLocation.negate());
			changeBoundsRequest.setMoveDelta(moveDelta.scale(zoomLevel));
			
			compoundCommand.add(borderItem.getCommand(changeBoundsRequest));
		}
		
		// apply edge layouts
		for (KEdge edge : edge2ConnectionMapping.keySet()) {
			ConnectionEditPart connection = edge2ConnectionMapping.get(edge);
			KEdgeLayout edgeLayout = edge.getLayout();
			PointList pointList = new PointList();

			// set start point
			Point startPoint = kPoint2Point(edgeLayout.getSourcePoint());
			pointList.addPoint(startPoint);

			// set grid points
			for (KPoint gridPoint : edgeLayout.getGridPoints()) {
				Point point = kPoint2Point(gridPoint);
				pointList.addPoint(point);
			}

			// set end point
			Point endPoint = kPoint2Point(edgeLayout.getTargetPoint());
			pointList.addPoint(endPoint);

			// create request and add it
			SetAllBendpointRequest request = new SetAllBendpointRequest(RequestConstants.REQ_SET_ALL_BENDPOINT, pointList);
			compoundCommand.add(connection.getCommand(request));
		}
		
		commandStack.execute(compoundCommand);
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
	 * Converts a dimension from the KLayoutGraph into a Draw2D dimension.
	 * @param kDimension KLayoutGraph dimension
	 * @return Draw2D dimension
	 */
	private static Dimension kDimension2Dimension(KDimension kDimension) {
		Dimension dimension = new Dimension();
		dimension.height = (int)kDimension.getHeight();
		dimension.width = (int)kDimension.getWidth();
		return dimension;
	}
	
	/**
	 * Converts a point from the KLayoutGraph into a Draw2D point.
	 * @param kPoint KLayoutGraph point
	 * @return Draw2D point
	 */
	private static Point kPoint2Point(KPoint kPoint) {
		Point point = new Point();
		point.x = (int)kPoint.getX();
		point.y = (int)kPoint.getY();
		return point;
	}
	
	/**
	 * Processes the elements and all sub-elements of a node by recursive call.
	 * @param children list of child elements of a node
	 * @param parentGroup parent node group
	 */
	@SuppressWarnings("unchecked")
	private void buildLayoutGraphRecursively(List children, KNodeGroup parentGroup) {
		if (children != null)
		{
			// build node groups
			for (Object child : children) {
				if (child instanceof AbstractBorderedShapeEditPart) {
					AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart)child;
					KNodeGroup childNode = buildNode(boxEditPart);
					// set the parent group; this automatically adds the node
					// to the parent's list of children
					childNode.setParentGroup(parentGroup);
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
	 * @return the created node group
	 */
	@SuppressWarnings("unchecked")
	private KNodeGroup buildNode(AbstractBorderedShapeEditPart boxEditPart) {
		// add the new child node
		KNodeGroup childNode = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroup();
		nodeGroup2BoxMapping.put(childNode, boxEditPart);
		childNode.setIdString(Integer.toString((boxEditPart.hashCode())));
		// set the child node's layout
		KNodeGroupLayout nodeGroupLayout = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroupLayout();
		createLayout(nodeGroupLayout, boxEditPart.getFigure());
		KInsets insets = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
		insets.setLeft(BORDER_INSET);
		insets.setRight(BORDER_INSET);
		insets.setTop(2*BORDER_INSET);
		insets.setBottom(BORDER_INSET);
		nodeGroupLayout.setInsets(insets);
		nodeGroupLayout.setLayouterName(KimlGMFLayoutHintHelper.getContainedElementsLayouterName(boxEditPart));
		nodeGroupLayout.setLayoutType(KimlGMFLayoutHintHelper.getContainedElementsLayoutType(boxEditPart));
		childNode.setLayout(nodeGroupLayout);
		// set the input and output ports
		List subChildren = null;
		for (Object nodeElement : boxEditPart.getChildren()) {
			if (nodeElement instanceof ShapeCompartmentEditPart) {
				subChildren = ((ShapeCompartmentEditPart)nodeElement).getChildren();
			}
			else if (nodeElement instanceof BorderedBorderItemEditPart) {
				BorderedBorderItemEditPart borderItem = (BorderedBorderItemEditPart)nodeElement;
				// add the new port
				KPort port = KimlLayoutGraphFactory.eINSTANCE.createKPort();
				port2BorderItemMapping.put(port, borderItem);
				borderItem2PortMapping.put(borderItem, port);
				port.setType(borderItem instanceof InputPortEditPart ? PORT_TYPE.INPUT : PORT_TYPE.OUTPUT);
				port.setNodeGroup(childNode);
				// set the port's layout
				KPortLayout portLayout = KimlLayoutGraphFactory.eINSTANCE.createKPortLayout();
				createLayout(portLayout, borderItem.getFigure());
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
						createLayout(labelLayout, portNameEditPart.getFigure());
						portLabel.setLabelLayout(labelLayout);
					}
				}
			}
			else if (nodeElement instanceof ITextAwareEditPart) {
				ITextAwareEditPart boxNameEditPart = (ITextAwareEditPart)nodeElement;
				// add node group label
				KNodeGroupLabel nodeGroupLabel = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroupLabel();
				nodeGroupLabel.setText(boxNameEditPart.getEditText());
				childNode.setLabel(nodeGroupLabel);
				// set the node group label's layout
				KNodeGroupLabelLayout labelLayout = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroupLabelLayout();
				createLayout(labelLayout, boxNameEditPart.getFigure());
				nodeGroupLabel.setLabelLayout(labelLayout);
			}
		}
		// process next hierarchy level
		buildLayoutGraphRecursively(subChildren, childNode);
		
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
				KPort port1 = borderItem2PortMapping.get(portEditPart);
				for (Object portElement : portEditPart.getSourceConnections()) {
					if (portElement instanceof ConnectionEditPart) {
						ConnectionEditPart connectionEditPart = (ConnectionEditPart)portElement;
						KPort port2 = borderItem2PortMapping.get(connectionEditPart.getTarget());
						if (port2 != null) {
							// add the new edge according to its type
							if (port1.getType() == PORT_TYPE.OUTPUT && port2.getType() == PORT_TYPE.INPUT) {
								if (processExternal && port1.getNodeGroup().getParentGroup()
										== port2.getNodeGroup().getParentGroup()) {
									addEdge(port1, port2, connectionEditPart, EdgeHierarchyType.OP_TO_OP);
								}
							}
							else if (port1.getType() == PORT_TYPE.INPUT && port2.getType() == PORT_TYPE.INPUT) {
								if (port1.getNodeGroup() == port2.getNodeGroup().getParentGroup()) {
									addEdge(port1, port2, connectionEditPart, EdgeHierarchyType.INPUT_TO_OP);
								}
							}
							else if (port1.getType() == PORT_TYPE.OUTPUT && port2.getType() == PORT_TYPE.OUTPUT) {
								if (processExternal && port1.getNodeGroup().getParentGroup()
										== port2.getNodeGroup()) {
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
	private void addEdge(KPort sourcePort, KPort targetPort,
			ConnectionEditPart connectionEditPart, EdgeHierarchyType edgeType) {
		KEdge edge = KimlLayoutGraphFactory.eINSTANCE.createKEdge();
		edge2ConnectionMapping.put(edge, connectionEditPart);
		if (edgeType != EdgeHierarchyType.INPUT_TO_OP) {
			// set the source node; this automatically adds the edge
			// to the source's list of outgoing edges
			edge.setSource(sourcePort.getNodeGroup());
		}
		edge.setSourcePort(sourcePort);
		if (edgeType != EdgeHierarchyType.OP_TO_OUTPUT) {
			// set the target node; this automatically adds the edge to
			// the target's list of incoming edges
			edge.setTarget(targetPort.getNodeGroup());
		}
		edge.setTargetPort(targetPort);
		sourcePort.getEdges().add(edge);
		targetPort.getEdges().add(edge);
		// set the edge's layout
		KEdgeLayout edgeLayout = KimlLayoutGraphFactory.eINSTANCE.createKEdgeLayout();
		edgeLayout.setSourcePoint(KimlLayoutGraphFactory.eINSTANCE.createKPoint());
		edgeLayout.setTargetPoint(KimlLayoutGraphFactory.eINSTANCE.createKPoint());
		edge.setLayout(edgeLayout);
	}

}
