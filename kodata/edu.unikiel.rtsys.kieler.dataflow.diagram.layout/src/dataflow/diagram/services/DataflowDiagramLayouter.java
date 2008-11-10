package dataflow.diagram.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.ui.IEditorPart;

import dataflow.diagram.edit.parts.*;
import dataflow.diagram.part.DataflowDiagramEditor;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;

/**
 * This layouter for dataflow diagrams performs the needed transformation
 * from diagram elements to the KIML Layout Graph structure.
 * @author msp
 */
public class DataflowDiagramLayouter extends KimlAbstractLayouter {

	private DataflowModelEditPart modelPart = null;
	
	private Map<KNodeGroup, AbstractBorderedShapeEditPart> nodeGroup2BoxMapping = new HashMap<KNodeGroup, AbstractBorderedShapeEditPart>();
	private Map<KEdge, ConnectionEditPart> edge2ConnectionMapping = new HashMap<KEdge, ConnectionEditPart>();
	private Map<KPort, BorderedBorderItemEditPart> port2BorderItemMapping = new HashMap<KPort, BorderedBorderItemEditPart>();
	private Map<BorderedBorderItemEditPart, KPort> borderItem2PortMapping = new HashMap<BorderedBorderItemEditPart, KPort>();
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#init(java.lang.Object)
	 */
	protected boolean init(Object target) {
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
		KLayoutGraph layoutGraph = KimlLayoutGraphFactory.eINSTANCE.createKLayoutGraph();
		// the layout graph always has a top node
		KNodeGroup topNode = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroup();
		layoutGraph.setTopGroup(topNode);
		
		buildLayoutGraphRecursively(modelPart.getChildren(), topNode);		
		return layoutGraph;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#applyLayout()
	 */
	protected void applyLayout() {
		// apply node layouts
		for (KNodeGroup nodeGroup : nodeGroup2BoxMapping.keySet())
		{
			AbstractBorderedShapeEditPart boxEditPart = nodeGroup2BoxMapping.get(nodeGroup);
			//boxEditPart.getLocation()
		}
	}
	
	/**
	 * Sets the location and size properties of a shape layout.
	 * @param shapeLayout layout object to be changed
	 * @param shapeEditPart source object with layout information
	 */
	private static void createLayout(KShapeLayout shapeLayout, ShapeEditPart shapeEditPart)
	{
		KPoint kPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		kPoint.setX(shapeEditPart.getLocation().x);
		kPoint.setY(shapeEditPart.getLocation().y);
		shapeLayout.setLocation(kPoint);
		KDimension kDimension = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
		kDimension.setHeight(shapeEditPart.getSize().height);
		kDimension.setWidth(shapeEditPart.getSize().width);
		shapeLayout.setSize(kDimension);
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
					createLayout(nodeGroupLayout, boxEditPart);
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
							createLayout(portLayout, borderItem);
							port.setLayout(portLayout);
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
								}
							}
						}
					}
				}
			}
		}
	}

}
