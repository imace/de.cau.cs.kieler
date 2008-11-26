package edu.unikiel.rtsys.klodd.hierarchical.structures;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;

/**
 * Connection between two layer elements in a layered graph.
 * 
 * @author msp
 */
public class LayerConnection {
	
	/** crosswise routing position at the source of this connection */
	public int sourceRoutePos = 0;
	/** crosswise routing position at the target of this connection */
	public int targetRoutePos = 0;
	
	/** the source element */
	private LayerElement sourceElement;
	/** the source port */
	private KPort sourcePort;
	/** the target element */
	private LayerElement targetElement;
	/** the target port */
	private KPort targetPort;

	/**
	 * Creates a layer connection with given source and target.
	 * 
	 * @param sourceElem the source element
	 * @param sourcePort the source port
	 * @param targetElem the target element
	 * @param targetPort the target port
	 */
	public LayerConnection(LayerElement sourceElem, KPort sourcePort,
			LayerElement targetElem, KPort targetPort) {
		this.sourceElement = sourceElem;
		this.sourcePort = sourcePort;
		this.targetElement = targetElem;
		this.targetPort = targetPort;
	}

	/**
	 * Creates a layer connection with given source and target.
	 * 
	 * @param sourceElem the source element
	 * @param targetElem the target element
	 */
	public LayerConnection(LayerElement sourceElem, LayerElement targetElem) {
		this.sourceElement = sourceElem;
		this.sourcePort = null;
		this.targetElement = targetElem;
		this.targetPort = null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[" + sourceElement.toString() + "] > ["
			+ targetElement.toString() + "]";
	}

	/**
	 * Gets the source element.
	 * 
	 * @return the sourceElement
	 */
	public LayerElement getSourceElement() {
		return sourceElement;
	}

	/**
	 * Gets the source port.
	 * 
	 * @return the sourcePort
	 */
	public KPort getSourcePort() {
		return sourcePort;
	}

	/**
	 * Gets the target element.
	 * 
	 * @return the targetElement
	 */
	public LayerElement getTargetElement() {
		return targetElement;
	}

	/**
	 * Gets the target port.
	 * 
	 * @return the targetPort
	 */
	public KPort getTargetPort() {
		return targetPort;
	}
	
}
