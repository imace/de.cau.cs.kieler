package de.cau.cs.kieler.klodd.hierarchical.structures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.klodd.core.util.FixedArrayList;


/**
 * This structure manages the layering of an acyclic directed graph.
 * 
 * @author msp
 */
public class LayeredGraph {
	
	/**
	 * Types of layered graphs.
	 */
	public enum Type {
		/** the layered graph is built up from the front */
		BUILD_FRONT,
		/** the layered graph is built up from the back */
		BUILD_BACK
	}
	
	/** crosswise dimension of this layered graph */
	public float crosswiseDim = 0.0f;
	/** lengthwise dimension of this layered graph */
	public float lengthwiseDim = 0.0f;
	
	/** list of layers in this layered graph */
	private List<Layer> layers;
	/** parent layout node associated with this layered graph */
	KLayoutNode parentNode;
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
	 * Creates a new layered graph. Choosing the right type can be important
	 * for efficiency; BUILD_FRONT should be chosen if putFront is used to
	 * put normal nodes, and BUILD_BACK should be chosen if putBack is used
	 * to put normal nodes.
	 * 
	 * @param type type of layered graph building: from front or from back
	 * @param parentNode parent layout node
	 */
	public LayeredGraph(Type type, KLayoutNode parentNode) {
		layers = new FixedArrayList<Layer>(parentNode.getChildNodes().size() + 2,
				type == Type.BUILD_FRONT ? FixedArrayList.Type.ALIGN_FRONT
						: FixedArrayList.Type.ALIGN_BACK);
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
		return parentNode.getLabel().getText();
	}
	
	/**
	 * Put the given object into a layer with specified rank. The search
	 * for the right layer begins at the front of the internal list.
	 * 
	 * @param obj object to put
	 * @param rank rank of the object
	 */
	public void putFront(Object obj, int rank) {
		for (int i = 0; i < layers.size(); i++) {
			int currentRank = layers.get(i).rank;
			if (currentRank < 0 || currentRank > rank) {
				// insert a new layer into the list
				Layer newLayer = new Layer(rank, Layer.UNDEF_HEIGHT, this);
				doPut(obj, newLayer);
				layers.add(i, newLayer);
				return;
			}
			else if (currentRank == rank) {
				// the right layer was found
				doPut(obj, layers.get(i));
				return;
			}
		}
		
		// add a new layer at the end of the list
		Layer newLayer = new Layer(rank, Layer.UNDEF_HEIGHT, this);
		doPut(obj, newLayer);
		layers.add(newLayer);
	}

	/**
	 * Put the given object into a layer with specified height. The search
	 * for the right layer begins at the back of the internal list.
	 * 
	 * @param obj object to put
	 * @param height height of the object
	 */
	public void putBack(Object obj, int height) {
		for (int i = layers.size() - 1; i >= 0; i--) {
			int currentHeight = layers.get(i).height;
			if (currentHeight < 0 || currentHeight > height) {
				// insert a new layer into the list
				Layer newLayer = new Layer(Layer.UNDEF_RANK, height, this);
				doPut(obj, newLayer);
				layers.add(i, newLayer);
				return;
			}
			else if (currentHeight == height) {
				// the right layer was found
				doPut(obj, layers.get(i));
				return;
			}
		}
		
		// add a new layer at the start of the list
		Layer newLayer = new Layer(Layer.UNDEF_RANK, height, this);
		doPut(obj, newLayer);
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
	 * @return the parentNode
	 */
	public KLayoutNode getParentGroup() {
		return parentNode;
	}

	/**
	 * Fills rank and height information for all layers, creates connections
	 * between layer elements and creates long edges. This method should be
	 * called after all nodes and ports have been put into the layered graph.
	 */
	public void createConnections() {
		int layerCount = layers.size();
		// fill rank information for all layers
		int rank = layers.get(0).rank;
		if (rank == Layer.UNDEF_RANK) rank = 1;
		for (int i = 0; i < layerCount; i++) {
			layers.get(i).rank = rank++;
			if (i + 1 < layerCount)
				layers.get(i).next = layers.get(i + 1);
		}
		// fill height information for all layers
		int height = layers.get(layerCount - 1).height;
		if (height == Layer.UNDEF_HEIGHT) height = 1;
		for (int i = layerCount - 1; i >= 0; i--)
			layers.get(i).height = height++;
		
		// create connections between layer elements
		for (int i = 0; i < layerCount - 1; i++) {
			Layer layer = layers.get(i);
			List<LayerElement> elements = layer.getElements();
			for (LayerElement element : elements) {
				if (element.linearSegment == null) {
					// create new linear segment
					createLinearSegment(element);
				}
				List<KLayoutEdge> outgoingEdges = element.getOutgoingEdges();
				if (outgoingEdges != null) {
					for (KLayoutEdge edge : outgoingEdges) {
						KLayoutNode targetGroup = edge.getTarget();
						KLayoutPort targetPort = edge.getTargetPort();
						if (targetGroup != null) {
							createConnection(element, obj2LayerElemMap.get(targetGroup), edge);
						}
						else if (targetPort != null) {
							createConnection(element, obj2LayerElemMap.get(targetPort), edge);
						}
					}
				}
			}
		}
		// create linear segments for the last layer
		for (LayerElement element : layers.get(layerCount - 1).getElements()) {
			createLinearSegment(element);
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
	 */
	private void doPut(Object obj, Layer layer) {
		LayerElement element = layer.put(obj);
		obj2LayerElemMap.put(obj, element);
	}
	
	/**
	 * Creates a cross-layer connection between two layer elements,
	 * possibly leading to a linear segment of edge elements.
	 * 
	 * @param source source element
	 * @param target target element
	 * @param edge the edge object connecting both elements
	 */
	private void createConnection(LayerElement source,
			LayerElement target, KLayoutEdge edge) {
		Layer sourceLayer = source.getLayer();
		Layer targetLayer = target.getLayer();
		if (targetLayer.rank - sourceLayer.rank == 1) {
			source.addOutgoing(edge, target, edge.getSourcePort(),
					edge.getTargetPort());
		}
		else {
			LayerElement currentElement = null;
			// process existing long edges for the source or target port
			LinearSegment linearSegment = longEdgesMap.get(edge.getSourcePort());
			if (linearSegment == null)
				linearSegment = longEdgesMap.get(edge.getTargetPort());
			if (linearSegment != null) {
				ListIterator<LayerElement> elemIter = linearSegment.elements.listIterator();
				while (elemIter.hasNext()
						&& (currentElement = elemIter.next()).getLayer().rank
						< targetLayer.rank - 1);
				source.addOutgoing(edge, linearSegment.elements.get(0),
						edge.getSourcePort(), null);
			}
			else {
				currentElement = sourceLayer.next.put(edge);
				linearSegment = createLinearSegment(currentElement);
				source.addOutgoing(edge, currentElement, edge.getSourcePort(), null);
			}
			// add new layer elements to the linear segment if needed
			while (currentElement.getLayer().rank < targetLayer.rank - 1) {
				LayerElement newElement = currentElement.getLayer().next.put(edge);
				linearSegment.elements.add(newElement);
				newElement.linearSegment = linearSegment;
				currentElement.addOutgoing(edge, newElement);
				currentElement = newElement;
			}
			currentElement.addOutgoing(edge, target, null, edge.getTargetPort());
			longEdgesMap.put(edge.getSourcePort(), linearSegment);
			longEdgesMap.put(edge.getTargetPort(), linearSegment);
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
