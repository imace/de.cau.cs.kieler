package kiel.layouter.graphviz;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.layout.LayoutNodesOperation;
import org.eclipse.gmf.runtime.diagram.ui.providers.internal.DefaultProvider;
import org.eclipse.gmf.runtime.diagram.ui.providers.internal.DiagramProvidersDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.providers.internal.DiagramProvidersPlugin;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.layouter.LayoutType;
import edu.unikiel.rtsys.layouter.gef.DebugFigureHandler;
import edu.unikiel.rtsys.layouter.graph.CompositeNode;
import edu.unikiel.rtsys.layouter.graph.Coordinates;
import edu.unikiel.rtsys.layouter.graph.Edge;
import edu.unikiel.rtsys.layouter.graph.Graph;
import edu.unikiel.rtsys.layouter.graph.GraphFactory;
import edu.unikiel.rtsys.layouter.graph.Label;
import edu.unikiel.rtsys.layouter.graph.Node;
import edu.unikiel.rtsys.layouter.graph.Size;
import edu.unikiel.rtsys.layouter.graph.custom.GraphTools;
import edu.unikiel.rtsys.layouter.ui.WorkbenchPreferencePage;


/**
 * Layout Provider that employs the Graphviz (http://www.graphviz.org/) layout
 * library to layout a diagram.
 * 
 * @author Hauke Fuhrmann <haf@informatik.uni-kiel.de>
 * 
 */
public class GraphvizLayoutProvider extends DefaultProvider{

	public static final String ID = "edu.unikiel.rtsys.layouter.layoutprovider";
	
	private DebugFigureHandler debugFigureHandler = new DebugFigureHandler();
	
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
		Graph layoutGraph = buildGraph(containerEditPart.getChildren());
		layoutGraph.setData(containerEditPart);
		
		// do GraphvizLayout
		GraphvizDraw2DGraphLayout layout = new GraphvizDraw2DGraphLayout();

		// do manual layout for test
//		StaticTestLayout layout = new StaticTestLayout();
		layout.visit(layoutGraph);
		// share the graph data with other objects, e.g. the Layout Graph View
		LayouterPlugin.getDefault().getCommonLayer().setLayoutGraph(layoutGraph);
		
		// update Diagram with methods from original eclipse layouter
		Command cmd = updateDiagram(containerEditPart, layoutGraph, true);
		
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
		buildNodes(selectedEditParts, editPart2Node, graph);
		
		System.out.println(GraphTools.graph2String(graph));
		return graph;
	}

	/** Creates edges for a list of connections and fills the given
	 * Graph object.
	 * @param editPart2Node map of editParts to nodes
	 * @param parentNode the composite node to fill
	 * @param connections list of connections to create graph edges for
	 */
	private void buildConnections(Map<EditPart, Node> editPart2Node,
			CompositeNode parentNode, ArrayList connections) {
		GraphFactory factory = GraphFactory.eINSTANCE;
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
					parentNode.getEdges().add(edge);
					edge.setData(con); // save EP in edge for later
					
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
	}

	/**
	 * Create nodes for selected EditParts and fills the given parentNode of the graph.
	 * Returns a list of connections between the nodes.
	 * @param selectedEditParts which editParts are relevant
	 * @param editPart2Node maps editParts to Nodes
	 * @param parentNode to fill
	 * @return
	 */
	private ArrayList buildNodes(List selectedEditParts,
			Map<EditPart, Node> editPart2Node, CompositeNode parentNode) {
		GraphFactory factory = GraphFactory.eINSTANCE;
		ListIterator li = selectedEditParts.listIterator();
		ArrayList connections = new ArrayList();
		while (li.hasNext()) {
			IGraphicalEditPart gep = (IGraphicalEditPart) li.next();
			if (gep instanceof ShapeEditPart) {
				ShapeEditPart shapeEP = (ShapeEditPart) gep;
				Point position = shapeEP.getLocation();
				// TODO: create Composite only if it really contains compartment, normal Node else
				CompositeNode node = factory.createCompositeNode();
				// store the EditPart in the node to get the mapping later
				node.setData(shapeEP); 
				editPart2Node.put(shapeEP, node);
				Size size = factory.createSize();
				size.setWidth(shapeEP.getSize().width);
				size.setHeight(shapeEP.getSize().height);
				node.setSize(size);
				parentNode.getNodes().add(node);
				// recursive call to check for hierarchy
				buildNodes(gep.getChildren(),editPart2Node,node);
			}
			if(gep instanceof CompartmentEditPart){
				// recursive call to check for hierarchy
				// here add children to the parent node of this compartment
				buildNodes(gep.getChildren(),editPart2Node,parentNode);
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
		// add connections to the current composite node
		buildConnections(editPart2Node, parentNode, connections);
		return connections;
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
		retrievePreferences(); // read preferences
		
		CompoundCommand cc = new CompoundCommand("");

		updateDiagramNodes(g, cc);
		debugFigureHandler.refresh();
		
		if(cc.isEmpty())
			return null; 
		return cc;
		
	}

	/**
	 *  Get change commands for connection routing
	 *  
	 */
	private void updateDiagramEdges(CompositeNode parentNode, CompoundCommand cc) {
		for (final Edge edge : parentNode.getEdges()){
/*			// reconnect nodes, dunno what it does... has no effect but copied from eclipsecon slides
			Command cmd1 = reconnect(edge.getSource(), edge.getData(), RequestConstants.REQ_RECONNECT_SOURCE);
			if(cmd1 != null && cmd1.canExecute()) cc.add(cmd1);
			Command cmd2 = reconnect(edge.getTarget(), edge.getData(), RequestConstants.REQ_RECONNECT_TARGET);
			if(cmd2 != null && cmd2.canExecute()) cc.add(cmd2);
*/			
						
					if(edge.getData() instanceof ConnectionEditPart){
						// get the corresponding EditPart from the edge data (saved earlier)
						ConnectionEditPart con = (ConnectionEditPart) edge.getData();
						// start debug, check the real bendpoints of the polyline
						PolylineConnection poly = (PolylineConnection)con.getFigure();
						
						// handling connection router
						//System.out.println("Router: "+poly.getConnectionRouter());
						poly.setConnectionRouter(null);
						
						
						PointList temps = poly.getPoints();
						//System.out.print("Bendpoints1: ");
						for(int i = 0;i<temps.size();i++){
							Point p = temps.getPoint(i);
							//System.out.print(p.x+" "+p.y+" ");
							debugFigureHandler.addDebugPoint((GraphicalEditPart)con.getParent(), p, ColorConstants.blue); // add something visible
						}
						//System.out.println();
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
							//System.out.print("Bendpoints2: ");
							int pointnumber = 0;
							for (Coordinates coordinates : bendpoints) {
								pointList.addPoint(coordinates.getX(), coordinates.getY());
								// debug stuff, show the points
								debugFigureHandler.addDebugPoint((GraphicalEditPart)parentNode.getData(),new Point(coordinates.getX(), coordinates.getY()));
								//System.out.print(coordinates.getX()+","+coordinates.getY()+" ");
								// set start & end ref point to first and last bendpoint.
								if(pointnumber == 0)
									ptSourceReference = new Point(coordinates.getX(), coordinates.getY());
								if(pointnumber == bendpoints.size()-1)
									ptTargetReference = new Point(coordinates.getX(), coordinates.getY());
								pointnumber++;
							}
							//System.out.println("\n");
							
							SetAllBendpointRequest request = new SetAllBendpointRequest(
									RequestConstants.REQ_SET_ALL_BENDPOINT,
								    pointList, ptSourceReference, ptTargetReference);
							Command cmd = con.getCommand(request);
							if(cmd != null && cmd.canExecute()){
								cc.add(cmd);
							}
					}
				}
				// set positions for labels
				// TODO: do absolute label positioning and not relative movement only!!!
				Label label = edge.getEdgeLabel();
				if (label != null && label.getData() instanceof LabelEditPart) {
					LabelEditPart labelEP = (LabelEditPart) label.getData();
					Point newPosition = new Point(label.getPosition().getX(),label.getPosition().getY());
					Command cmd = new AbsoluteMoveCommand(labelEP, newPosition);
					if ( cmd!=null && cmd.canExecute() )
						cc.add(cmd);
				} 
			}
	}

	/**
	 * Get change commands for new node positions
	 * @param g
	 * @param cc
	 */
	private void updateDiagramNodes(CompositeNode parentNode, CompoundCommand cc) {
		for (Node node : parentNode.getNodes()) {
			if (node.getData() instanceof IGraphicalEditPart) {
				IGraphicalEditPart gep = (IGraphicalEditPart) node.getData();
				ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
				request.setEditParts(gep);
				// calculate the Move Delta (required by movement request)
				Point oldPosition = gep.getFigure().getBounds().getLocation();
				Point newPosition = new Point(node.getPosition().getX(),node.getPosition().getY());
				Point delta = new Point(newPosition.x-oldPosition.x, newPosition.y-oldPosition.y);
				//System.out.println("Node pos, old: "+oldPosition+ " new: "+newPosition+" delta: "+delta);
				
				Dimension oldSize = new Dimension(gep.getFigure().getBounds().width, gep.getFigure().getBounds().height);
				Dimension newSize = new Dimension(node.getSize().getWidth(), node.getSize().getHeight());
				Dimension deltaSize = new Dimension(oldSize.width-newSize.width, oldSize.height-newSize.height);
				
				debugFigureHandler.addDebugPoint((GraphicalEditPart)gep.getParent(),newPosition, ColorConstants.green);
				Point newPosition2 = new Point(newPosition.x+newSize.width, newPosition.y+newSize.height);
				debugFigureHandler.addDebugPoint((GraphicalEditPart)gep.getParent(),newPosition2, ColorConstants.cyan);
				
				for(int i = 0; i<100; i++)
					for(int ii = 0; ii < 100; ii++)
						debugFigureHandler.addDebugPoint((GraphicalEditPart)gep.getParent(), new Point(i,ii),ColorConstants.darkGreen);
				
				
				
				debugFigureHandler.addDebugPoint((GraphicalEditPart)gep.getParent(), new Point(23,101),ColorConstants.darkGreen);
				debugFigureHandler.addDebugPoint((GraphicalEditPart)gep.getParent(), new Point(23,31),ColorConstants.darkGreen);
				
				//request.setSizeDelta(deltaSize);
				request.setMoveDelta(delta);
				request.setLocation(newPosition);
				// get the actual command for the request from EP itself
				Command cmd = gep.getCommand(request);
				if ( cmd!=null && cmd.canExecute() )
					cc.add(cmd);
				
				// recursive call to cover hierarchy
				if(node instanceof CompositeNode){
					updateDiagramNodes((CompositeNode)node, cc);
				}
			} // if
		} // for
		// update edges here to cover all edges of all hierarchy levels
		updateDiagramEdges(parentNode, cc);
	}

	
	
	/*
	 * Read preferences and set internal vars accoridngly.
	 */
	private void retrievePreferences(){
		IPreferenceStore prefs = LayouterPlugin.getDefault().getPreferenceStore();
		debugFigureHandler.setDebug(prefs.getBoolean(WorkbenchPreferencePage.PREF_DEBUG_LAYOUTER));
	}
	
	/**
	 * Create ReconnectRequest for Node with its corresponding edge.
	 * @param node
	 * @param edge
	 * @param type
	 * @return
	 */
	Command reconnect(Object node, Object edge, String type){
		if(node instanceof GraphicalEditPart){
			GraphicalEditPart gep = (GraphicalEditPart)node;
			ReconnectRequest request = new ReconnectRequest(type);
			if(edge instanceof ConnectionEditPart){
				ConnectionEditPart cep = (ConnectionEditPart)edge;
				request.setConnectionEditPart(cep);
			}
			Command cmd = gep.getCommand(request);
			if (cmd!=null && cmd.canExecute() )
				return cmd;
		}
		return null;
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
		//System.out.println("GraphViz Provider provides: " + operation);
		if (operation == null)
			return false;
		
		View cview = this.getContainer(operation);
		if (cview == null)
			return false;

		IAdaptable layoutHint = ((LayoutNodesOperation) operation)
				.getLayoutHint();
		String layoutType = (String) layoutHint.getAdapter(String.class);
		// this layouter supports only the GraphViz Dot Layout
		return LayoutType.GRAPHVIZ_DOT.equals(layoutType);
	}

	@Override
	protected Rectangle translateFromGraph(Rectangle rect) {
		// TODO Auto-generated method stub
		return rect;
	}

	@Override
	protected Rectangle translateToGraph(Rectangle r) {
		// TODO Auto-generated method stub
		return r;
	}




}
