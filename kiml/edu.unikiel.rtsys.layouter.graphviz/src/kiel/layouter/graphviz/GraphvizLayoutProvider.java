package kiel.layouter.graphviz;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.layout.LayoutNodesOperation;
import org.eclipse.gmf.runtime.diagram.ui.providers.internal.DefaultProvider;
import org.eclipse.gmf.runtime.diagram.ui.providers.internal.DiagramProvidersDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.providers.internal.DiagramProvidersPlugin;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.rtsys.layouter.graph.Coordinates;
import edu.unikiel.rtsys.layouter.graph.Edge;
import edu.unikiel.rtsys.layouter.graph.Graph;
import edu.unikiel.rtsys.layouter.graph.GraphFactory;
import edu.unikiel.rtsys.layouter.graph.Label;
import edu.unikiel.rtsys.layouter.graph.Node;
import edu.unikiel.rtsys.layouter.graph.Size;


/**
 * Layout Provider that employs the Graphviz (http://www.graphviz.org/) layout
 * library to layout a diagram.
 * 
 * @author Hauke Fuhrmann <haf@informatik.uni-kiel.de>
 * 
 */
public class GraphvizLayoutProvider extends DefaultProvider {

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.layout.AbstractLayoutEditPartProvider#layoutEditParts(org.eclipse.gef.GraphicalEditPart,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	public Command layoutEditParts(GraphicalEditPart containerEditPart,
			IAdaptable layoutHint) {
		System.out.println("LAYOUT edit parts 1");
		// handle error case
		if (containerEditPart == null) {
			InvalidParameterException ipe = new InvalidParameterException();
			Trace.throwing(DiagramProvidersPlugin.getInstance(),
					DiagramProvidersDebugOptions.EXCEPTIONS_THROWING,
					getClass(), "layout()", //$NON-NLS-1$
					ipe);
			throw ipe;
		}

		// create abstract graph
		Graph g = buildGraph(containerEditPart.getChildren());

		// do GraphvizLayout
		GraphvizDraw2DGraphLayout layout = new GraphvizDraw2DGraphLayout();
		layout.visit(g);

		// update Diagram with methods from original eclipse layouter
		Command cmd = updateDiagram(containerEditPart, g, true);
		return cmd;
	}

	/**
	 * Fills a <code>Graph</code> datastructure from EditParts.
	 * 
	 * @param containerEditPart
	 * @param g
	 */
	private Graph buildGraph(List selectedEditParts) {
		// map to relate EditParts and Graph Nodes
		Map<EditPart,Node> editPart2Node = new HashMap<EditPart,Node>();
		
		GraphFactory factory = GraphFactory.eINSTANCE;
		Graph graph = factory.createGraph();

		// create nodes for selected EditParts
		ListIterator li = selectedEditParts.listIterator();
		ArrayList connections = new ArrayList();
		while (li.hasNext()) {
			IGraphicalEditPart gep = (IGraphicalEditPart) li.next();
			if (gep instanceof ShapeEditPart) {
				ShapeEditPart shapeEP = (ShapeEditPart) gep;
				Point position = shapeEP.getLocation();
				Node node = factory.createNode();
				// store the EditPart in the node to get the mapping later
				node.setData(shapeEP); 
				editPart2Node.put(shapeEP, node);
				Size size = factory.createSize();
				size.setWidth(shapeEP.getSize().width);
				size.setHeight(shapeEP.getSize().height);
				node.setSize(size);
				graph.getNodes().add(node);
				System.out.println("Node: "+node);
			}
			// crumble the relevant connections from the selected EditParts
			connections.addAll(gep.getSourceConnections());
			
			/* TODO: find connections not directly connected to the edit part but to its
			 * border... 
			if (gep instanceof IBorderedShapeEditPart) {
				// search the BorderItemEditParts
				for (Object child : gep.getChildren()) {
					if( child instanceof IBorderItemEditPart)
						connections.addAll(((IGraphicalEditPart)child).getSourceConnections());
				}
			}
			*/
		}
		
		// create edges for selected connections
		for (Object object : connections) {
			if (object instanceof ConnectionEditPart) {
				ConnectionEditPart con = (ConnectionEditPart) object;
				Node source = editPart2Node.get(con.getSource());
				Node target = editPart2Node.get(con.getTarget());
				// connection might be to not selected component
				if(source != null && target != null)
				{
					Edge edge = factory.createEdge();
					edge.setSource(source);
					edge.setTarget(target);
					graph.getEdges().add(edge);
					edge.setData(con); // save EP in edge for later
					System.out.println("Edge: "+edge);
					
					// create Labels
					for (Object child : con.getChildren()) {
						if (child instanceof LabelEditPart) {
							// create at most one label TODO: support multiple labels
							if(edge.getEdgeLabel() == null){ 
								LabelEditPart labelEP = (LabelEditPart) child;
								Label label = GraphFactory.eINSTANCE.createLabel();
								Size size = GraphFactory.eINSTANCE.createSize();
								size.setHeight(labelEP.getFigure().getBounds().height);
								size.setWidth(labelEP.getFigure().getBounds().width);
								label.setSize(size);
								edge.setEdgeLabel(label);
								label.setData(labelEP);
							}
						}
					}
					
				}
			}
		}
		return graph;
	}

	/**
	 * Reads a <code>Graph</code> datastructure containing layout information
	 * and generates a compound command to change the corresponding layout
	 * parameters for the EditParts.
	 * 
	 * @param containerEditPart
	 * @param g
	 * @param b
	 * @return
	 */
	private Command updateDiagram(GraphicalEditPart containerEditPart, Graph g,
			boolean b) {
		CompoundCommand cc = new CompoundCommand("");
		// get change commands for new node positions
		for (Node node : g.getNodes()) {
			if (node.getData() instanceof IGraphicalEditPart) {
				IGraphicalEditPart gep = (IGraphicalEditPart) node.getData();
				ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
				request.setEditParts(gep);
				// calculate the Move Delta (required by movement request)
				Point oldPosition = gep.getFigure().getBounds().getLocation();
				Point newPosition = new Point(node.getPosition().getX(),node.getPosition().getY());
				Point delta = new Point(newPosition.x-oldPosition.x, newPosition.y-oldPosition.y);
				request.setMoveDelta(delta);
				request.setLocation(newPosition);
				// get the actual command for the request from EP itself
				Command cmd = gep.getCommand(request);
				if ( cmd!=null && cmd.canExecute() )
					cc.add(cmd);
			}
		}
		// get change commands for connection routing
		for (Edge edge : g.getEdges()){

			if(edge.getData() instanceof ConnectionEditPart){
				// get the corresponding EditPart from the edge data (saved earlier)
				ConnectionEditPart con = (ConnectionEditPart) edge.getData();

				// start debug, check the real bendpoints of the polyline
				PolylineConnection poly = (PolylineConnection)con.getFigure();
				PointList temps = poly.getPoints();
				System.out.print("Bendpoints1: ");
				for(int i = 0;i<temps.size();i++){
					Point p = temps.getPoint(i);
					System.out.print(p.x+" "+p.y+" ");
				}
				System.out.println();
				// end debug
				
				List<Coordinates> bendpoints = edge.getBendpoints();
				PointList pointList = new PointList();
				pointList.removeAllPoints(); // init
				// need reference points of source and target:
				// center of connected node
				// TODO: put calculation in seperate function (e.g. use Rectangle and getCenter Method)
				Point ptSourceReference = new Point(edge.getSource().getPosition().getX()+(edge.getSource().getSize().getWidth()/2),edge.getSource().getPosition().getY()+(edge.getSource().getSize().getHeight()/2));
				Point ptTargetReference = new Point(edge.getTarget().getPosition().getX()+(edge.getTarget().getSize().getWidth()/2),edge.getTarget().getPosition().getY()+(edge.getTarget().getSize().getHeight()/2));
				if(bendpoints != null && !bendpoints.isEmpty()){
					System.out.print("Bendpoints2: ");
					for (Coordinates coordinates : bendpoints) {
						pointList.addPoint(coordinates.getX(), coordinates.getY());
						System.out.print(coordinates.getX()+","+coordinates.getY()+" ");
					}
					System.out.println("\n");
					SetAllBendpointRequest request = new SetAllBendpointRequest(
							RequestConstants.REQ_SET_ALL_BENDPOINT,
						    pointList, ptSourceReference, ptTargetReference);
					Command cmd = con.getCommand(request);
					if(cmd != null && cmd.canExecute())
						cc.add(cmd);
				}
				// set the snapback position for all children owned by the connection
				for (Object child : con.getChildren()) {
					if (child instanceof GraphicalEditPart) {
						GraphicalEditPart gep = (GraphicalEditPart) child;
						Rectangle gepBox = gep.getFigure().getBounds().getCopy();
						if (!gep.getFigure().isVisible() || 
			                    gepBox.width == 0 || gepBox.height == 0)
			                    continue;
						Request snapBackRequest = new Request(RequestConstants.REQ_SNAP_BACK);
						Command cmd = gep.getCommand(snapBackRequest);
						if(cmd != null && cmd.canExecute())
							cc.add(cmd);
					}					
				}
				// set positions for labels
				// TODO: do absolute label positioning and not relative movement only!!!
				Label label = edge.getEdgeLabel();
				if (label != null && label.getData() instanceof LabelEditPart) {
					LabelEditPart labelEP = (LabelEditPart) label.getData();
					ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
					request.setEditParts(labelEP);
					// calculate the Move Delta (required by movement request)
					Point oldPosition = labelEP.getFigure().getBounds().getLocation();
					Point newPosition = new Point(label.getPosition().getX(),label.getPosition().getY());
					Point delta = new Point(newPosition.x-oldPosition.x, newPosition.y-oldPosition.y);
					request.setMoveDelta(delta);
					request.setLocation(newPosition);
					// get the actual command for the request from EP itself
					Command cmd = labelEP.getCommand(request);
					if ( cmd!=null && cmd.canExecute() )
						cc.add(cmd);
					/*
					 * this does not work: manipulating layout constraints
					 * is only allowed in some "transaction"
					 */
//					Object object = labelEP.getModel();
//					if (object instanceof org.eclipse.gmf.runtime.notation.Node) {
//						org.eclipse.gmf.runtime.notation.Node notationNode = (org.eclipse.gmf.runtime.notation.Node) object;
//						Location location = (Location)(notationNode.getLayoutConstraint());
//						location.setX(newPosition.x);
//						location.setY(newPosition.y);
//					}
										
				} 
			}	
		}
		if(cc.isEmpty())
			return null; 
		return cc;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.layout.AbstractLayoutEditPartProvider#layoutEditParts(java.util.List,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	public Command layoutEditParts(List selectedObjects, IAdaptable layoutHint) {
		System.out.println("LAYOUT edit parts 2");
		CompoundCommand cc = new CompoundCommand();
		return cc;
	}

	/**
	 * Checks whether this provider provides the service for the given
	 * operation. I.e. if this LayoutProvider provides the layout service for
	 * the given layout type from the layout hint adapter of the operation.
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		System.out.println("GraphViz Provider provides: " + operation);
		if (operation == null)
			return false;
		View cview = getContainer(operation);
		if (cview == null)
			return false;

		IAdaptable layoutHint = ((LayoutNodesOperation) operation)
				.getLayoutHint();
		String layoutType = (String) layoutHint.getAdapter(String.class);
		return LayoutType.DEFAULT.equals(layoutType);
	}

	@Override
	protected Rectangle translateFromGraph(Rectangle rect) {
		// no tanslation, just return original layout
		return rect;
	}

	@Override
	protected Rectangle translateToGraph(Rectangle rect) {
		// no tanslation, just return original layout
		return rect;
	}

}
