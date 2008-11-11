package dataflow.diagram.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.ui.IEditorPart;

import dataflow.diagram.edit.parts.*;
import dataflow.diagram.part.DataflowDiagramEditor;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;

/**
 * This layouter for dataflow diagrams performs the needed transformation
 * from diagram elements to the KIML Layout Graph structure and applies layout
 * information from the layout engine.
 * 
 * @author msp
 */
public class DataflowDiagramLayouter extends KimlAbstractLayouter {

	private DataflowModelEditPart modelPart = null;
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
	public ILabelProvider getLabelProvider()
	{
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
		if (target instanceof IEditorPart)
		{
			DataflowDiagramEditor editor = (DataflowDiagramEditor)target;
			modelPart = (DataflowModelEditPart)editor.getDiagramEditPart();
		}
		else if (target instanceof IStructuredSelection)
		{
			IStructuredSelection selection = (IStructuredSelection)target;
			AbstractGraphicalEditPart content = (AbstractGraphicalEditPart)selection.getFirstElement();
			modelPart = (DataflowModelEditPart)content.getRoot().getChildren().get(0);
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
		// the layout graph always has a top node
		KNodeGroup topNode = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroup();
		layoutGraph.setTopGroup(topNode);
		// set the top node's layout
		KNodeGroupLayout topGroupLayout = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroupLayout();
		createLayout(topGroupLayout, modelPart.getFigure());
		topGroupLayout.setInsets(KimlLayoutGraphFactory.eINSTANCE.createKInsets());
		topNode.setLayout(topGroupLayout);
		
		buildLayoutGraphRecursively(modelPart.getChildren(), topNode);		
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
		ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart)modelPart.getRoot();
		double zoomLevel = rootEditPart.getZoomManager().getZoom();
		
		// apply node layouts
		for (KNodeGroup nodeGroup : nodeGroup2BoxMapping.keySet())
		{
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
		for (KPort port : port2BorderItemMapping.keySet())
		{
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
		for (KEdge edge : edge2ConnectionMapping.keySet())
		{
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
	 * Sets the location and size properties of a shape layout.
	 * @param shapeLayout layout object to be changed
	 * @param figure source object with layout information
	 */
	private static void createLayout(KShapeLayout shapeLayout, IFigure figure)
	{
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
	private static Dimension kDimension2Dimension(KDimension kDimension)
	{
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
	private static Point kPoint2Point(KPoint kPoint)
	{
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
	private void buildLayoutGraphRecursively(List children, KNodeGroup parentGroup)
	{
		if (children != null)
		{
			// build node groups
			for (Object child : children)
			{
				if (child instanceof AbstractBorderedShapeEditPart)
				{
					AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart)child;
					// add the new child node
					KNodeGroup childNode = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroup();
					nodeGroup2BoxMapping.put(childNode, boxEditPart);
					parentGroup.getSubNodeGroups().add(childNode);
					childNode.setParentGroup(parentGroup);
					// set the child node's layout
					KNodeGroupLayout nodeGroupLayout = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroupLayout();
					createLayout(nodeGroupLayout, boxEditPart.getFigure());
					nodeGroupLayout.setInsets(KimlLayoutGraphFactory.eINSTANCE.createKInsets());
					childNode.setLayout(nodeGroupLayout);
					// set the input and output ports
					List subChildren = null;
					for (Object nodeElement : boxEditPart.getChildren())
					{
						if (nodeElement instanceof ShapeCompartmentEditPart)
						{
							subChildren = ((ShapeCompartmentEditPart)nodeElement).getChildren();
						}
						else if (nodeElement instanceof BorderedBorderItemEditPart)
						{
							BorderedBorderItemEditPart borderItem = (BorderedBorderItemEditPart)nodeElement;
							// add the new port
							KPort port = KimlLayoutGraphFactory.eINSTANCE.createKPort();
							port2BorderItemMapping.put(port, borderItem);
							borderItem2PortMapping.put(borderItem, port);
							port.setType(borderItem instanceof InputPortEditPart ? PORT_TYPE.INPUT : PORT_TYPE.OUTPUT);
							childNode.getPorts().add(port);
							port.setNodeGroup(childNode);
							// set the port's layout
							KPortLayout portLayout = KimlLayoutGraphFactory.eINSTANCE.createKPortLayout();
							createLayout(portLayout, borderItem.getFigure());
							port.setLayout(portLayout);
							// set the port label
							for (Object portChild : borderItem.getChildren())
							{
								if (portChild instanceof ITextAwareEditPart)
								{
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
						else if (nodeElement instanceof ITextAwareEditPart)
						{
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
				}
			}
			
			// build edges
			for (Object child : children)
			{
				if (child instanceof AbstractBorderedShapeEditPart)
				{
					AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart)child;
					for (Object nodeElement : boxEditPart.getChildren())
					{
						if (nodeElement instanceof InputPortEditPart)
						{
							InputPortEditPart portEditPart = (InputPortEditPart)nodeElement;
							KPort targetPort = borderItem2PortMapping.get(portEditPart);
							for (Object portElement : portEditPart.getSourceConnections())
							{
								if (portElement instanceof ConnectionEditPart)
								{
									ConnectionEditPart connectionEditPart = (ConnectionEditPart)portElement;
									// add the new edge
									KEdge edge = KimlLayoutGraphFactory.eINSTANCE.createKEdge();
									edge2ConnectionMapping.put(edge, connectionEditPart);
									KPort sourcePort = borderItem2PortMapping.get(connectionEditPart.getSource());
									edge.setSource(sourcePort.getNodeGroup());
									edge.setSourcePort(sourcePort);
									edge.setTarget(targetPort.getNodeGroup());
									edge.setTargetPort(targetPort);
									sourcePort.getEdges().add(edge);
									sourcePort.getNodeGroup().getOutgoingEdges().add(edge);
									targetPort.getEdges().add(edge);
									targetPort.getNodeGroup().getIncomingEdges().add(edge);
									// set the edge's layout
									KEdgeLayout edgeLayout = KimlLayoutGraphFactory.eINSTANCE.createKEdgeLayout();
									edgeLayout.setSourcePoint(KimlLayoutGraphFactory.eINSTANCE.createKPoint());
									edgeLayout.setTargetPoint(KimlLayoutGraphFactory.eINSTANCE.createKPoint());
									edge.setLayout(edgeLayout);
								}
							}
						}
					}
				}
			}
		}
	}

}
