package de.cau.cs.kieler.klodd.hierarchical.structures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.cau.cs.kieler.core.graph.KEdge;
import de.cau.cs.kieler.core.graph.KGraph;
import de.cau.cs.kieler.core.graph.KNode;
import de.cau.cs.kieler.core.graph.alg.ICycleRemover;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;


/**
 * This structure manages the layering of an acyclic directed graph.
 * 
 * @author msp
 */
public class LayeredGraph {
	
	/** crosswise dimension of this layered graph */
	public float crosswiseDim = 0.0f;
	/** lengthwise dimension of this layered graph */
	public float lengthwiseDim = 0.0f;
	
	/** list of layers in this layered graph */
	private List<Layer> layers = new LinkedList<Layer>();
	/** parent layout node associated with this layered graph */
	private KLayoutNode parentNode;
	/** map of objects to their corresponding layer */
	private Map<Object, LayerElement> obj2LayerElemMap = new HashMap<Object, LayerElement>();
	/** map of ports to connected long edges */
	private Map<KLayoutPort, LinearSegment> longEdgesMap = new HashMap<KLayoutPort, LinearSegment>();
	/** list of linear segments in this layered graph */
	private List<LinearSegment> linearSegments = new LinkedList<LinearSegment>();
	/** layout direction for this layered graph: HORIZONTAL or VERTICAL */
	private KLayoutOption layoutDirection;
	/** are the external ports of this layered graph fixed? */
	private boolean fixedExternalPorts;
	/** position of this layered graph */
	private KPoint position;
	
	/**
	 * Creates a new layered graph.
	 * 
	 * @param parentNode parent layout node
	 */
	public LayeredGraph(KLayoutNode parentNode) {
		position = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		position.setX(0.0f);
		position.setY(0.0f);
		
		// get layout options from the parent group
		this.parentNode = parentNode;
		List<KLayoutOption> parentOptions = parentNode.getLayout().getLayoutOptions();
		layoutDirection = parentOptions.contains(KLayoutOption.VERTICAL) ?
				KLayoutOption.VERTICAL : KLayoutOption.HORIZONTAL;
		fixedExternalPorts = parentOptions.contains(KLayoutOption.FIXED_PORTS);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String text = getClass().getSimpleName();
		if (parentNode.getLabel() != null)
			text += "(" + parentNode.getLabel().getText() + ")";
		return text;
	}
	
	/**
	 * Put the given object into a layer with specified rank. The search
	 * for the right layer begins at the front of the internal list.
	 * 
	 * @param obj object to put
	 * @param rank rank of the object
	 * @param kNode the corresponding node in the acyclic KIELER graph
	 */
	public void putFront(Object obj, int rank, KNode kNode) {
		ListIterator<Layer> layerIter = layers.listIterator();
		while (layerIter.hasNext()) {
			Layer layer = layerIter.next();
			if (layer.rank < 0 || layer.rank > rank) {
				// insert a new layer into the list
				Layer newLayer = new Layer(rank, Layer.UNDEF_HEIGHT, this);
				doPut(obj, newLayer, kNode);
				layerIter.previous();
				layerIter.add(newLayer);
				return;
			}
			else if (layer.rank == rank) {
				// the right layer was found
				doPut(obj, layer, kNode);
				return;
			}
		}
		
		// add a new layer at the end of the list
		Layer newLayer = new Layer(rank, Layer.UNDEF_HEIGHT, this);
		doPut(obj, newLayer, kNode);
		layers.add(newLayer);
	}

	/**
	 * Put the given object into a layer with specified height. The search
	 * for the right layer begins at the back of the internal list.
	 * 
	 * @param obj object to put
	 * @param height height of the object
	 * @param kNode the corresponding node in the acyclic KIELER graph
	 */
	public void putBack(Object obj, int height, KNode kNode) {
		ListIterator<Layer> layerIter = layers.listIterator(layers.size());
		while (layerIter.hasPrevious()) {
			Layer layer = layerIter.previous();
			if (layer.height < 0 || layer.height > height) {
				// insert a new layer into the list
				Layer newLayer = new Layer(Layer.UNDEF_RANK, height, this);
				doPut(obj, newLayer, kNode);
				layerIter.next();
				layerIter.add(newLayer);
				return;
			}
			else if (layer.height == height) {
				// the right layer was found
				doPut(obj, layer, kNode);
				return;
			}
		}
		
		// add a new layer at the start of the list
		Layer newLayer = new Layer(Layer.UNDEF_RANK, height, this);
		doPut(obj, newLayer, kNode);
		layers.add(0, newLayer);
	}
	
	/**
	 * Gets the layer element that holds the given object.
	 * 
	 * @param obj the object
	 * @return the corresponding layer element, or null if none exists
	 */
	public LayerElement getLayerElement(Object obj) {
		return obj2LayerElemMap.get(obj);
	}
	
	/**
	 * Gets the list of layers.
	 * 
	 * @return the layers
	 */
	public List<Layer> getLayers() {
		return layers;
	}

	/**
	 * Gets the parent layout node.
	 * 
	 * @return the parent node
	 */
	public KLayoutNode getParentNode() {
		return parentNode;
	}

	/**
	 * Creates connections between layer elements and creates long edges.
	 * This method should be called after all nodes and ports have been
	 * put into the layered graph.
	 * 
	 * @param kGraph acyclic version of the graph
	 */
	public void createConnections(KGraph kGraph) {
		for (Layer layer : layers) {
			List<LayerElement> elements = layer.getElements();
			for (LayerElement element : elements) {
				if (element.linearSegment == null) {
					// create new linear segment
					createLinearSegment(element);
				}
				List<KEdge> outgoingEdges = element.getOutgoingEdges();
				if (outgoingEdges != null) {
					for (KEdge edge : outgoingEdges) {
						KLayoutEdge layoutEdge = (KLayoutEdge)edge.object;
						KLayoutNode targetNode;
						KLayoutPort sourcePort, targetPort;
						if (edge.rank == ICycleRemover.REVERSED) {
							targetNode = layoutEdge.getSource();
							sourcePort = layoutEdge.getTargetPort();
							targetPort = layoutEdge.getSourcePort();
						}
						else {
							targetNode = layoutEdge.getTarget();
							sourcePort = layoutEdge.getSourcePort();
							targetPort = layoutEdge.getTargetPort();
						}
						
						if (targetNode != null) {
							createConnection(element,
									obj2LayerElemMap.get(targetNode),
									layoutEdge, sourcePort, targetPort);
						}
						else if (targetPort != null) {
							createConnection(element,
									obj2LayerElemMap.get(targetPort),
									layoutEdge, sourcePort, targetPort);
						}
					}
				}
			}
		}
	}
	
	/**
	 * Applies the layout of this layered graph to the contained layout graph.
	 */
	public void applyLayout() {
		KInsets insets = parentNode.getLayout().getInsets();
		// apply the new layout to the contained elements
		for (Layer layer : layers) {
			for (LayerElement element : layer.getElements()) {
				element.applyLayout(position, insets);
				for (LayerConnection connection : element.getIncomingConnections()) {
					connection.applyLayout(position, insets);
				}
				for (ElementLoop loop : element.getLoops()) {
					loop.applyLayout(position);
				}
			}
		}
		
		// update the size of the parent layout node
		float width = insets.getLeft() + insets.getRight();
		float height = insets.getTop() + insets.getBottom();
		if (layoutDirection == KLayoutOption.VERTICAL) {
			width += crosswiseDim;
			height += lengthwiseDim;
		}
		else {
			width += lengthwiseDim;
			height += crosswiseDim;
		}
		parentNode.getLayout().getSize().setWidth(width);
		parentNode.getLayout().getSize().setHeight(height);
		
		// update layout options of the parent layout node
		List<KLayoutOption> layoutOptions = parentNode.getLayout().getLayoutOptions();
		if (!layoutOptions.contains(KLayoutOption.FIXED_SIZE))
			layoutOptions.add(KLayoutOption.FIXED_SIZE);
		if (!layoutOptions.contains(KLayoutOption.FIXED_PORTS))
			layoutOptions.add(KLayoutOption.FIXED_PORTS);
	}

	/**
	 * Gets the layout direction: HORIZONTAL or VERTICAL.
	 * 
	 * @return the layout direction
	 */
	public KLayoutOption getLayoutDirection() {
		return layoutDirection;
	}

	/**
	 * Are the external ports of this layered graph fixed?
	 * 
	 * @return true if external ports are fixed
	 */
	public boolean areExternalPortsFixed() {
		return fixedExternalPorts;
	}
	
	/**
	 * Gets the list of linear segments of this layered graph. Each
	 * node is assigned a unique linear segment of size 1.
	 * 
	 * @return list of linear segments
	 */
	public List<LinearSegment> getLinearSegments() {
		return linearSegments;
	}
	
	/**
	 * Gets the current layout position of this layered graph.
	 * 
	 * @return the position
	 */
	public KPoint getPosition() {
		return position;
	}

	/**
	 * Puts an object into a given layer.
	 * 
	 * @param obj object to put
	 * @param layer the layer
	 * @param kNode the corresponding node in the acyclic KIELER graph
	 */
	private void doPut(Object obj, Layer layer, KNode kNode) {
		LayerElement element = layer.put(obj, kNode);
		obj2LayerElemMap.put(obj, element);
	}
	
	/**
	 * Creates a cross-layer connection between two layer elements,
	 * possibly leading to a linear segment of edge elements.
	 * 
	 * @param source source element
	 * @param target target element
	 * @param edge the edge object connecting both elements
	 * @param sourcePort the source port
	 * @param targetPort the target port
	 */
	private void createConnection(LayerElement source,
			LayerElement target, KLayoutEdge edge, KLayoutPort sourcePort,
			KLayoutPort targetPort) {
		Layer sourceLayer = source.getLayer();
		Layer targetLayer = target.getLayer();
		if (targetLayer.rank - sourceLayer.rank == 1) {
			source.addOutgoing(edge, target, sourcePort, targetPort);
		}
		else {
			LayerElement currentElement = null;
			// process existing long edges for the source or target port
			LinearSegment linearSegment = longEdgesMap.get(sourcePort);
			if (linearSegment == null)
				linearSegment = longEdgesMap.get(targetPort);
			if (linearSegment != null) {
				ListIterator<LayerElement> elemIter = linearSegment.elements.listIterator();
				while (elemIter.hasNext()
						&& (currentElement = elemIter.next()).getLayer().rank
						< targetLayer.rank - 1);
				source.addOutgoing(edge, linearSegment.elements.get(0),
						sourcePort, null);
			}
			else {
				currentElement = sourceLayer.next.put(edge, null);
				linearSegment = createLinearSegment(currentElement);
				source.addOutgoing(edge, currentElement, sourcePort, null);
			}
			// add new layer elements to the linear segment if needed
			while (currentElement.getLayer().rank < targetLayer.rank - 1) {
				LayerElement newElement = currentElement.getLayer().next.put(edge, null);
				linearSegment.elements.add(newElement);
				newElement.linearSegment = linearSegment;
				currentElement.addOutgoing(edge, newElement);
				currentElement = newElement;
			}
			currentElement.addOutgoing(edge, target, null, targetPort);
			longEdgesMap.put(sourcePort, linearSegment);
			longEdgesMap.put(targetPort, linearSegment);
		}
	}
	
	/**
	 * Creates a new linear segment that contains the given element.
	 * 
	 * @param element layer element that is put into the new linear segment
	 */
	private LinearSegment createLinearSegment(LayerElement element) {
		LinearSegment linearSegment = new LinearSegment();
		linearSegment.elements.add(element);
		element.linearSegment = linearSegment;
		linearSegments.add(linearSegment);
		return linearSegment;
	}
	
}
