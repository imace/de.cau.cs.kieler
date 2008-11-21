package edu.unikiel.rtsys.klodd.hierarchical.structures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.klodd.core.util.FixedArrayList;

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
	
	/** list of layers in this layered graph */
	private List<Layer> layers;
	/** parent node group associated with this layered graph */
	KNodeGroup parentGroup;
	/** map of objects to their corresponding layer */
	private Map<Object, LayerElement> obj2LayerElemMap = new HashMap<Object, LayerElement>();
	/** layout direction for this layered graph: HORIZONTAL or VERTICAL */
	private LAYOUT_OPTION layoutDirection;
	/** are the external ports of this layered graph fixed? */
	private boolean fixedExternalPorts;
	
	/**
	 * Creates a new layered graph. Choosing the right type can be important
	 * for efficiency; BUILD_FRONT should be chosen if putFront is used to
	 * put normal nodes, and BUILD_BACK should be chosen if putBack is used
	 * to put normal nodes.
	 * 
	 * @param type type of layered graph building: from front or from back
	 * @param parentGroup parent node group
	 */
	public LayeredGraph(Type type, KNodeGroup parentGroup) {
		layers = new FixedArrayList<Layer>(parentGroup.getSubNodeGroups().size() + 2,
				type == Type.BUILD_FRONT ? FixedArrayList.Type.ALIGN_FRONT
						: FixedArrayList.Type.ALIGN_BACK);
		
		// get layout options from the parent group
		this.parentGroup = parentGroup;
		List<LAYOUT_OPTION> parentOptions = parentGroup.getLayout().getLayoutOptions();
		layoutDirection = parentOptions.contains(LAYOUT_OPTION.VERTICAL) ?
				LAYOUT_OPTION.VERTICAL : LAYOUT_OPTION.HORIZONTAL;
		fixedExternalPorts = parentOptions.contains(LAYOUT_OPTION.FIXED_PORTS);
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
	 * Gets the parent node group.
	 * 
	 * @return the parentGroup
	 */
	public KNodeGroup getParentGroup() {
		return parentGroup;
	}

	/**
	 * Fills rank and height information for all layers, creates connections
	 * between layer elements and creates long edges. This method should be
	 * called after all nodes and ports have been put into the layered graph.
	 */
	public void postProcess() {
		int layerCount = layers.size();
		// fill rank information for all layers
		int rank = layers.get(0).rank;
		if (rank == Layer.UNDEF_RANK) rank = 1;
		for (int i = 0; i < layerCount; i++)
			layers.get(i).rank = rank++;
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
				List<KEdge> outgoingEdges = element.getOutgoingEdges();
				for (KEdge edge : outgoingEdges) {
					KNodeGroup targetGroup = edge.getTarget();
					KPort sourcePort = edge.getSourcePort();
					KPort targetPort = edge.getTargetPort();
					if (targetGroup != null) {
						createConnection(element, obj2LayerElemMap.get(targetGroup),
								edge, sourcePort, targetPort);
					}
					else if (targetPort != null) {
						createConnection(element, obj2LayerElemMap.get(targetPort),
								edge, sourcePort, targetPort);
					}
				}
			}
		}
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
	 * @param sourcePort the source port
	 * @param targetPort the target port
	 */
	private void createConnection(LayerElement source,
			LayerElement target, KEdge edge, KPort sourcePort,
			KPort targetPort) {
		Layer sourceLayer = source.getLayer();
		Layer targetLayer = target.getLayer();
		if (targetLayer.rank - sourceLayer.rank == 1) {
			source.addOutgoing(target, sourcePort, targetPort);
		}
		else {
			// determine the index of the first layer after the source layer
			int layerIndex = sourceLayer.rank + 1;
			if (layers.get(0).rank > 0)
				layerIndex--;
			// create a long edge as linear segment
			LayerElement newElement = layers.get(layerIndex).put(edge);
			source.addOutgoing(newElement, sourcePort, null);
			LayerElement currentElement = newElement;
			for (int i = sourceLayer.rank + 1; i < targetLayer.rank - 1; i++) {
				layerIndex++;
				newElement = layers.get(layerIndex).put(edge);
				currentElement.addOutgoing(newElement);
				currentElement = newElement;
			}
			currentElement.addOutgoing(target, null, targetPort);
		}
	}

	/**
	 * Gets the layout direction: HORIZONTAL or VERTICAL.
	 * 
	 * @return the layoutDirection
	 */
	public LAYOUT_OPTION getLayoutDirection() {
		return layoutDirection;
	}

	/**
	 * Are the external ports of this layered graph fixed?
	 * 
	 * @return the fixedExternalPorts
	 */
	public boolean areExternalPortsFixed() {
		return fixedExternalPorts;
	}
	
}
