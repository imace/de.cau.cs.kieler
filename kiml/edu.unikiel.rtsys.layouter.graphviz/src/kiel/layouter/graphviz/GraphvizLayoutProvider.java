package kiel.layouter.graphviz;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
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
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PrecisionPointList;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.Color;

import edu.unikiel.rtsys.layouter.LayoutType;
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

		// do manual layout for test
//		StaticTestLayout layout = new StaticTestLayout();
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
	
/*
 * This is stuff stolen from the DefaultProvider class to test the update to the diagram
 * which makes a lot of trouble with the Graphviz Layout...
 * As it does not help yet, I use my old stuff instead again...
 */
	private Command updateDiagram2(GraphicalEditPart containerEditPart, Graph g, boolean isLayoutForSelected){	
		CompoundCommand cc = new CompoundCommand(""); //$NON-NLS-1$
		
		Point diff = getLayoutPositionDelta(g, isLayoutForSelected);
		Command cmd = createNodeChangeBoundCommands(g, diff);
		if (cmd != null)
		    cc.add(cmd);
		
		cmd = createEdgesChangeBoundsCommands(g, diff);
		if (cmd != null)
		    cc.add(cmd);
		
		return cc;
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
				//System.out.println("Node pos, old: "+oldPosition+ " new: "+newPosition+" delta: "+delta);
				
				Dimension oldSize = new Dimension(gep.getFigure().getBounds().width, gep.getFigure().getBounds().height);
				Dimension newSize = new Dimension(node.getSize().getWidth(), node.getSize().getHeight());
				Dimension deltaSize = new Dimension(oldSize.width-newSize.width, oldSize.height-newSize.height);
				
				addDebugPoint(newPosition, ColorConstants.green);
				Point newPosition2 = new Point(newPosition.x+newSize.width, newPosition.y+newSize.height);
				addDebugPoint(newPosition2, ColorConstants.cyan);
				
				//request.setSizeDelta(deltaSize);
				request.setMoveDelta(delta);
				request.setLocation(newPosition);
				// get the actual command for the request from EP itself
				Command cmd = gep.getCommand(request);
				if ( cmd!=null && cmd.canExecute() )
					cc.add(cmd);
			}
		}
		// get change commands for connection routing
		for (final Edge edge : g.getEdges()){
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
							addDebugPoint(p, ColorConstants.blue); // add something visible
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
								addDebugPoint(new Point(coordinates.getX(), coordinates.getY()));
								//System.out.print(coordinates.getX()+","+coordinates.getY()+" ");
								// set start & end ref point to first and last bendpoint.
								if(pointnumber == 0)
									ptSourceReference = new Point(coordinates.getX(), coordinates.getY());
								if(pointnumber == bendpoints.size()-1)
									ptTargetReference = new Point(coordinates.getX(), coordinates.getY());
								pointnumber++;
							}
							//System.out.println("\n");
							
/*							// different tries for different reference points
							// all do not work...
							ptSourceReference = new Point(edge.getSource().getPosition().getX(),edge.getSource().getPosition().getY());
							ptTargetReference = new Point(edge.getTarget().getPosition().getX(),edge.getTarget().getPosition().getY());
							Point ref1 = poly.getTargetAnchor().getReferencePoint();
							Point ref2 = poly.getSourceAnchor().getReferencePoint();
							System.out.println("Source Anchor:"+poly.getSourceAnchor().getLocation(poly.getSourceAnchor().getReferencePoint()));
							System.out.println("Target Anchor:"+poly.getTargetAnchor().getLocation(poly.getTargetAnchor().getReferencePoint()));
							ptTargetReference.x = poly.getTargetAnchor().getLocation(ref1).x;
							ptTargetReference.y = poly.getTargetAnchor().getLocation(ref1).y;
							ptTargetReference.x = ref1.x;
							ptTargetReference.y = ref1.y;
							ptSourceReference.x = ref2.x;
							ptSourceReference.y = ref2.y;
							ptTargetReference = poly.getEnd();
							ptSourceReference = poly.getStart();
*/							
							SetAllBendpointRequest request = new SetAllBendpointRequest(
									RequestConstants.REQ_SET_ALL_BENDPOINT,
								    pointList, ptSourceReference, ptTargetReference);
							Command cmd = con.getCommand(request);
							if(cmd != null && cmd.canExecute()){
								cc.add(cmd);
							}
					}
				}
				
		
//			cc.add(edgeCommand);

			
//			if(edge.getData() instanceof ConnectionEditPart){
//				// get the corresponding EditPart from the edge data (saved earlier)
//				ConnectionEditPart con = (ConnectionEditPart) edge.getData();
//
//				// start debug, check the real bendpoints of the polyline
//				PolylineConnection poly = (PolylineConnection)con.getFigure();
//				PointList temps = poly.getPoints();
//				System.out.print("Bendpoints1: ");
//				for(int i = 0;i<temps.size();i++){
//					Point p = temps.getPoint(i);
//					System.out.print(p.x+" "+p.y+" ");
//				}
//				System.out.println();
//				// end debug
//				
//				List<Coordinates> bendpoints = edge.getBendpoints();
//				PointList pointList = new PointList();
//				pointList.removeAllPoints(); // init
//				// need reference points of source and target:
//				// center of connected node
//				// TODO: put calculation in seperate function (e.g. use Rectangle and getCenter Method)
//				Point ptSourceReference = new Point(edge.getSource().getPosition().getX()+(edge.getSource().getSize().getWidth()/2),edge.getSource().getPosition().getY()+(edge.getSource().getSize().getHeight()/2));
//				Point ptTargetReference = new Point(edge.getTarget().getPosition().getX()+(edge.getTarget().getSize().getWidth()/2),edge.getTarget().getPosition().getY()+(edge.getTarget().getSize().getHeight()/2));
//				if(bendpoints != null && !bendpoints.isEmpty()){
//					System.out.print("Bendpoints2: ");
//					for (Coordinates coordinates : bendpoints) {
//						pointList.addPoint(coordinates.getX(), coordinates.getY());
//						System.out.print(coordinates.getX()+","+coordinates.getY()+" ");
//					}
//					System.out.println("\n");
//					
///*					Point ref1 = poly.getTargetAnchor().getReferencePoint();
//					Point ref2 = poly.getSourceAnchor().getReferencePoint();
//					System.out.println("Source Anchor:"+poly.getSourceAnchor().getLocation(poly.getSourceAnchor().getReferencePoint()));
//					System.out.println("Target Anchor:"+poly.getTargetAnchor().getLocation(poly.getTargetAnchor().getReferencePoint()));
//					ptTargetReference.x = poly.getTargetAnchor().getLocation(ref1).x;
//					ptTargetReference.y = poly.getTargetAnchor().getLocation(ref1).y;
//					ptTargetReference.x = ref1.x;
//					ptTargetReference.y = ref1.y;
//					ptSourceReference.x = ref2.x;
//					ptSourceReference.y = ref2.y;
//*/					
///*					SetAllBendpointRequest request = new SetAllBendpointRequest(
//							RequestConstants.REQ_SET_ALL_BENDPOINT,
//						    pointList, ptSourceReference, ptTargetReference);
//*/					SetAllBendpointRequest request = new SetAllBendpointRequest(RequestConstants.REQ_SET_ALL_BENDPOINT, pointList);
//					Command cmd = con.getCommand(request);
//					if(cmd != null && cmd.canExecute()){
//						cc.add(cmd);
//					}
//						
//				}
//				// set the snapback position for all children owned by the connection
////				for (Object child : con.getChildren()) {
////					if (child instanceof GraphicalEditPart) {
////						GraphicalEditPart gep = (GraphicalEditPart) child;
////						Rectangle gepBox = gep.getFigure().getBounds().getCopy();
////						if (!gep.getFigure().isVisible() || 
////			                    gepBox.width == 0 || gepBox.height == 0)
////			                    continue;
////						Request snapBackRequest = new Request(RequestConstants.REQ_SNAP_BACK);
////						Command cmd = gep.getCommand(snapBackRequest);
////						if(cmd != null && cmd.canExecute())
////							cc.add(cmd);
////					}					
////				}
				// set positions for labels
				// TODO: do absolute label positioning and not relative movement only!!!
				Label label = edge.getEdgeLabel();
				if (label != null && label.getData() instanceof LabelEditPart) {
					LabelEditPart labelEP = (LabelEditPart) label.getData();
					Point newPosition = new Point(label.getPosition().getX(),label.getPosition().getY());
					Command cmd = new AbsoluteMoveCommand(labelEP, newPosition);
/*					ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
					request.setEditParts(labelEP);
					// calculate the Move Delta (required by movement request)
					Point oldPosition = labelEP.getFigure().getBounds().getLocation();
					Point newPosition = new Point(label.getPosition().getX(),label.getPosition().getY());
					Point delta = new Point(newPosition.x-oldPosition.x, newPosition.y-oldPosition.y);
					request.setMoveDelta(delta);
					request.setLocation(newPosition);
					System.out.println("LabelPos: "+newPosition);
					// get the actual command for the request from EP itself
					Command cmd = labelEP.getCommand(request);
*/					
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
		
		addDebugGraphics(containerEditPart);
		if(cc.isEmpty())
			return null; 
		return cc;
		
	}

	Figure debugFigure;
	List<Point> debugPoints;
	List<Color> debugColors;
	boolean debug = false;
	private void addDebugGraphics(GraphicalEditPart containerEditPart) {
		IFigure fig = containerEditPart.getContentPane();
		if(debug){
		// if necessary create new debug layer and add it to the root part
		if( debugFigure == null || !fig.getChildren().contains(debugFigure)){
			debugFigure = new Figure();
			debugFigure.setBounds(fig.getBounds());
			fig.add(debugFigure);
			
		}
		// remove all old stuff from the debug layer
		debugFigure.removeAll();
		// add new stuff to the debug layer
		if(debugPoints != null){
			for (int i = 0; i<debugPoints.size();i++) {
				Point p = debugPoints.get(i);
				Color c = debugColors.get(i);
				CrossFigure cross = new CrossFigure(6, p.x,p.y);
				cross.setForegroundColor(c);
				this.debugFigure.add(cross);
			}
		}
		this.debugPoints.clear();
		this.debugColors.clear();
		}
		else{// if(debug)
			if(fig.getChildren().contains(debugFigure))
				fig.remove(debugFigure);
		}
	}
	
	private void addDebugPoint(Point p){
		if(debugPoints == null){
			debugPoints = new ArrayList<Point>();
		}
		if(debugColors == null){
			debugColors = new ArrayList<Color>();
		}
		debugPoints.add(p);
		debugColors.add(ColorConstants.red);
	}
	private void addDebugPoint(Point p, Color c){
		if(debugPoints == null){
			debugPoints = new ArrayList<Point>();
		}
		if(debugColors == null){
			debugColors = new ArrayList<Color>();
		}
		debugPoints.add(p);
		debugColors.add(c);
	}
	
	/*
	 * Read preferences and set internal vars accoridngly.
	 */
	private void retrievePreferences(){
		IPreferenceStore prefs = LayouterPlugin.getDefault().getPreferenceStore();
		debug = prefs.getBoolean(WorkbenchPreferencePage.PREF_DEBUG_LAYOUTER);
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
		// no tanslation, just return original layout
		return rect;
	}

	@Override
	protected Rectangle translateToGraph(Rectangle rect) {
		// no tanslation, just return original layout
		return rect;
	}

	
	private Point getLayoutPositionDelta(Graph g, boolean isLayoutForSelected) {
        // If laying out selected objects, use diff variables to
        // position objects at topleft corner of enclosing rectangle.
        if (isLayoutForSelected) {
            ListIterator vi;
            vi = g.getNodes().listIterator();
            Point ptLayoutMin = new Point(-1, -1);
            while (vi.hasNext()) {
                Node node = (Node) vi.next();
                // ignore ghost node
                if (node.getData() != null) {
                    Rectangle nodeExt = getNodeMetrics(node);
                    if (ptLayoutMin.x == -1) {
                        ptLayoutMin.x = nodeExt.x;
                        ptLayoutMin.y = nodeExt.y;
                    } else {
                        ptLayoutMin.x = Math.min(ptLayoutMin.x, nodeExt.x);
                        ptLayoutMin.y = Math.min(ptLayoutMin.y, nodeExt.y);
                    }
                }
            }
    
            return new Point(this.minX - ptLayoutMin.x, this.minY - ptLayoutMin.y);
        }
        
        return new Point(layoutDefaultMargin, layoutDefaultMargin);
    }
	
    /**
     * getNodeMetrics Retrieves the node extend and position from the node
     * object. Defined as abstract to allow subclasses to implement to perform a
     * transformation on the values stored in the node. i.e. support for
     * Left-Right layout as opposed to Top-Down.
     * 
     * @param n
     *            Node that has the metrics values to be retrieved.
     * @return Rectangle that represents the location and extend of the Node.
     */
     protected Rectangle getNodeMetrics(Node n) {
        Rectangle rect = new Rectangle(n.getPosition().getX(), n.getPosition().getY(), n.getSize().getWidth(), n.getSize().getHeight());
        PrecisionRectangle preciseRect = new PrecisionRectangle(rect);
        return translateFromGraph(preciseRect);
    }
     
     protected Command createNodeChangeBoundCommands(Graph g, Point diff) {
         ListIterator vi = g.getNodes().listIterator();
         CompoundCommand cc = new CompoundCommand(""); //$NON-NLS-1$
         createSubCommands(diff, vi, cc);
         if (cc.isEmpty())
             return null;
         return cc;
     }

     protected void createSubCommands(Point diff, ListIterator vi, CompoundCommand cc) {
         // Now set the position of the icons. This causes the
         // arc connection points to be recalculated
         while (vi.hasNext()) {
             Node node = (Node) vi.next();
             if (node.getData() instanceof ShapeEditPart) {
                 IGraphicalEditPart gep = (IGraphicalEditPart)node.getData();
                 
                 ChangeBoundsRequest request = new ChangeBoundsRequest(
                     RequestConstants.REQ_MOVE);
                 Rectangle nodeExt = getNodeMetrics(node);
                 Point ptLocation = new PrecisionPoint(nodeExt.preciseX() + diff.preciseX(), nodeExt.preciseY()
                     + diff.preciseY());

                 PrecisionPoint ptOldLocation = new PrecisionPoint(gep.getFigure().getBounds().getLocation());
                 gep.getFigure().translateToAbsolute(ptOldLocation);
                 
                 gep.getFigure().translateToAbsolute(ptLocation);
                 PrecisionPoint delta = new PrecisionPoint(ptLocation.preciseX()
                     - ptOldLocation.preciseX(), ptLocation.preciseY()
                     - ptOldLocation.preciseY());

                 request.setEditParts(gep);
                 request.setMoveDelta(delta);
                 request.setLocation(ptLocation);
                 
                 Command cmd = gep.getCommand(request);
                 if (cmd != null && cmd.canExecute())
                     cc.add(cmd);
                 }
             }
         }

     /*
      * Find all of the arcs and set their intermediate points. This
      * loop does not set the icon positions yet, because that causes
      * recalculation of the arc connection points. The intermediate
      * points of both outgoing and incomping arcs must be set before
      * recalculating connection points.
      */ 
     protected Command createEdgesChangeBoundsCommands(Graph g, Point diff) {
         
         CompoundCommand cc = new CompoundCommand(""); //$NON-NLS-1$
         PointList points = new PrecisionPointList(10);
         
         ListIterator vi = g.getEdges().listIterator();
         while (vi.hasNext()) {
             Edge edge = (Edge) vi.next();
             
             if (edge.getData() == null || edge.getBendpoints()==null)
                 continue;
             
             points.removeAllPoints();

             ConnectionEditPart cep = null;
             Node source = null, target = null;
             
             collectPoints(points, edge);
             cep = (ConnectionEditPart)edge.getData();
             source = edge.getSource();
             target = edge.getTarget();
             
             if (cep != null) {
                 PointListUtilities.normalizeSegments(points, MapModeUtil.getMapMode(cep.getFigure()).DPtoLP(3));
                     
                 // Reset the points list
                 Command cmd = routeThrough(edge, cep, source, target, points, diff.x, diff.y);
                 if (cmd != null)
                     cc.add(cmd);
             }
             
             addLabelMoveCommand(cc, edge, diff.x, diff.y);
         }
         
         if (cc.isEmpty())
             return null;
         return cc;
     }

     private void collectPoints(PointList points, Edge edge) {
         List<Coordinates> pointList = edge.getBendpoints();
    	 for (int i = 0; i < pointList.size(); i++) {
         	 Point point = new Point(pointList.get(i).getX(),pointList.get(i).getY()); 
    		 Rectangle pt = translateFromGraph(new Rectangle(point, new Dimension()));
         	points.addPoint(pt.getLocation());
         }
     }

     /**
      * Computes the command that will route the given connection editpart with the given points.
      */
     protected Command routeThrough(Edge edge, ConnectionEditPart connectEP, Node source, Node target, PointList points, int diffX, int diffY) {

         if (connectEP == null)
             return null;

         PointList routePoints = points;
         if (source.getData() == connectEP.getTarget()) {
             routePoints = new PointList(points.size());
             reverse(points, routePoints);
             Node tmpNode = source;
             source = target;
             target = tmpNode;
         }
         
         double totalEdgeDiffX = diffX ;
         double totalEdgeDiffY = diffY ;
         
         PrecisionPointList allPoints = new PrecisionPointList(routePoints.size());
         for (int i = 0; i < routePoints.size(); i++) {
             allPoints.addPrecisionPoint(routePoints.getPoint(i).preciseX() + totalEdgeDiffX, routePoints
                 .getPoint(i).preciseY()
                 + totalEdgeDiffY);
         }

         CompoundCommand cc = new CompoundCommand(""); //$NON-NLS-1$
         
         LineSeg anchorReferencePoints = addAnchorsCommands(cc, allPoints.getFirstPoint(), allPoints.getLastPoint(), source, target, connectEP, diffX, diffY);
         		
         SetAllBendpointRequest request = new SetAllBendpointRequest(
                 RequestConstants.REQ_SET_ALL_BENDPOINT, allPoints,
                 anchorReferencePoints.getOrigin(), anchorReferencePoints.getTerminus());

         Command cmd = connectEP.getCommand(request);
         if (cmd != null)
             cc.add(cmd);
         
         // set the snapback position for all children owned by the connection
         List affectingChildren = getAffectingChildren(connectEP);
         Request snapBackRequest = new Request(RequestConstants.REQ_SNAP_BACK);
         ListIterator li = affectingChildren.listIterator();
         while (li.hasNext()) {
             EditPart ep = (EditPart)li.next();
             cmd = ep.getCommand(snapBackRequest);
             if (cmd != null)
                 cc.add(cmd);
         }
         
         if (cc.isEmpty())
             return null;
         return cc;
     }
     
     /**
      * reverse Utility function to reverse the order of points in a list.
      * 
      * @param c
      *            PointList that is passed to the routine.
      * @param rc
      *            PointList that is reversed.
      */
     private void reverse(PointList c, PointList rc) {
         rc.removeAllPoints();

         for (int i = c.size() - 1; i >= 0; i--) {
             rc.addPoint(c.getPoint(i));
         }
     }

     /**
	 	 * Creates source and target anchor commands and appends them to the
	 	 * compound command passed in. Returns a line segment ends of which are the
	 	 * new source and target anchor reference points for further use in the
	 	 * command setting the bend points.
	 	 * 
	 	 * @param cc
	 	 *            command to add anchors commands to
	 	 * @param sourceAnchorLocation
	 	 *            the source anchor location coordinates
	 	 * @param targetAnchorLocation
	 	 *            the target anchor location coordinates
	 	 * @param source
	 	 *            source node
	 	 * @param target
	 	 *            target node
	 	 * @param cep
	 	 *            connection editpart
	 	 * @param diffX
	 	 *            x axis offset
	 	 * @param diffY
	 	 *            y axis offset
	 	 * @return <code>LineSeg</code> origin is the new source anchor reference
	 	 *         point and origin is the new target anchor reference point
	 	 */
	 	protected LineSeg addAnchorsCommands(CompoundCommand cc,
	 			Point sourceAnchorLocation, Point targetAnchorLocation,
	 			Node source, Node target, ConnectionEditPart cep, int diffX,
	 			int diffY) {
	 		Rectangle sourceExt = getNodeMetrics(source);
	 		Rectangle targetExt = getNodeMetrics(target);
	 		sourceExt.performTranslate(diffX, diffY);
	 		targetExt.performTranslate(diffX, diffY);
	 		
	 		/*
	 		 * If source or target anchor command won't be created or will be non-executable,
	 		 * source or target reference point is assumed to be the geometric centre of a shape.
	 		 */
	 		Point resultantSourceAnchorReference = sourceExt.getCenter();
	 		Point resultantTargetAnchorReference = targetExt.getCenter();

	 		PrecisionPoint sourceRatio = new PrecisionPoint((sourceAnchorLocation
	 				.preciseX() - sourceExt.preciseX())
	 				/ sourceExt.preciseWidth(),
	 				(sourceAnchorLocation.preciseY() - sourceExt.preciseY())
	 						/ sourceExt.preciseHeight());
	 		PrecisionPoint targetRatio = new PrecisionPoint((targetAnchorLocation
	 				.preciseX() - targetExt.preciseX())
	 				/ targetExt.preciseWidth(),
	 				(targetAnchorLocation.preciseY() - targetExt.preciseY())
	 						/ targetExt.preciseHeight());
	 		
	 		/*
	 		 * Need to fake reconnection of the ends of the connection. Currently
	 		 * existing figure coordinates (old coordinates) needs to be used for
	 		 * this, since the reconnection location is passed in absolute
	 		 * coordinates.
	 		 */
	 		ReconnectRequest reconnectRequest = new ReconnectRequest(
	 				org.eclipse.gef.RequestConstants.REQ_RECONNECT_SOURCE);
	 		reconnectRequest.setConnectionEditPart(cep);
	 		reconnectRequest.setTargetEditPart((EditPart) source.getData());
	 		IFigure sourceFig = ((GraphicalEditPart) source.getData()).getFigure();
	 		Point sourceAnchorReference = new PrecisionPoint(
	 				sourceFig.getBounds().preciseX() + sourceRatio.preciseX()
	 						* sourceFig.getBounds().preciseWidth(), sourceFig
	 						.getBounds().preciseY()
	 						+ sourceRatio.preciseY()
	 						* sourceFig.getBounds().preciseHeight());
	 		sourceFig.translateToAbsolute(sourceAnchorReference);
	 		reconnectRequest.setLocation(sourceAnchorReference);
	 		Command sourceAnchorCommand = ((EditPart) source.getData())
	 				.getCommand(reconnectRequest);
	 		if (sourceAnchorCommand != null && sourceAnchorCommand.canExecute()) {
	 			cc.add(sourceAnchorCommand);
	 			resultantSourceAnchorReference = new PrecisionPoint(sourceExt
	 					.preciseWidth()
	 					* sourceRatio.preciseX() + sourceExt.preciseX(), sourceExt
	 					.preciseHeight()
	 					* sourceRatio.preciseY() + sourceExt.preciseY());
	 		}

	 		reconnectRequest
	 				.setType(org.eclipse.gef.RequestConstants.REQ_RECONNECT_TARGET);
	 		reconnectRequest.setTargetEditPart((EditPart) target.getData());
	 		IFigure targetFig = ((GraphicalEditPart) target.getData()).getFigure();
	 		Point targetAnchorReference = new PrecisionPoint(
	 				targetFig.getBounds().preciseX() + targetRatio.preciseX()
	 						* targetFig.getBounds().preciseWidth(), targetFig
	 						.getBounds().preciseY()
	 						+ targetRatio.preciseY()
	 						* targetFig.getBounds().preciseHeight());
	 		targetFig.translateToAbsolute(targetAnchorReference);
	 		reconnectRequest.setLocation(targetAnchorReference);
	 		Command targetAnchorCommand = ((EditPart) target.getData())
	 				.getCommand(reconnectRequest);
	 		if (targetAnchorCommand != null && targetAnchorCommand.canExecute()) {
	 			cc.add(targetAnchorCommand);
	 			resultantTargetAnchorReference = new PrecisionPoint(targetExt
	 					.preciseWidth()
	 					* targetRatio.preciseX + targetExt.preciseX(), targetExt
	 					.preciseHeight()
	 					* targetRatio.preciseY() + targetExt.preciseY());
	 		}
	 		return new LineSeg(resultantSourceAnchorReference,
	 				resultantTargetAnchorReference);
	 	}
	     /**
	      * Retrieve the associated children from the given connection editpart that will affect
	      * the layout.
	      * 
	      * @param conn the <code>ConnectionEditPart</code> to retrieve the children from
	      * @return a <code>List</code> that contains <code>GraphicalEditPart</code> objects
	      */
	     private List getAffectingChildren(ConnectionEditPart conn) {
	         List children = conn.getChildren();
	         ListIterator lli = children.listIterator();
	         List affectingChildrenList = new ArrayList();
	         while (lli.hasNext()) {
	             Object obj = lli.next();
	             if (obj instanceof GraphicalEditPart) {
	                 GraphicalEditPart lep = (GraphicalEditPart)obj;
	                 Rectangle lepBox = lep.getFigure().getBounds().getCopy();
	                 
	                 if (!lep.getFigure().isVisible() || 
	                     lepBox.width == 0 || lepBox.height == 0)
	                     continue;
	                 
	                 affectingChildrenList.add(lep);
	             }
	         }
	         return affectingChildrenList;
	     }
	     
	     void addLabelMoveCommand(CompoundCommand cc, Edge edge, int diffx, int diffy){
				Label label = edge.getEdgeLabel();
				if (label != null && label.getData() instanceof LabelEditPart) {
					LabelEditPart labelEP = (LabelEditPart) label.getData();
					Point newPosition = new Point(label.getPosition().getX() + diffx,label.getPosition().getY() + diffy);
					Command cmd = new AbsoluteMoveCommand(labelEP, newPosition);
					if ( cmd!=null && cmd.canExecute() )
						cc.add(cmd);
				}
	     }
}
