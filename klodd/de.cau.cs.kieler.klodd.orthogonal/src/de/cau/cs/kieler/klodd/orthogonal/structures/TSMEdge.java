package de.cau.cs.kieler.klodd.orthogonal.structures;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;

/**
 * An edge in the graph structure used for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class TSMEdge extends TSMGraphElement {

	/**
	 * Definition of an edge bend for orthogonal drawing.
	 */
	public static class Bend {
		/** Type of edge bend, from the perspective of the source node */
		public enum Type {
			LEFT, RIGHT
		}
		/** the type of edge bend */
		public Type type;
		/** the x coordinate position */
		public float xpos;
		/** the y coordinate position */
		public float ypos;
		/** the index of this bend */
		public int index;
		
		/** the edge associated with this bend */
		private TSMEdge edge;
		
		/**
		 * Creates an edge bend of given type.
		 * 
		 * @param edge the edge to which the new bend is added
		 * @param type type of edge bend
		 */
		public Bend(TSMEdge edge, Type type) {
			this.edge = edge;
			this.type = type;
			index = edge.bends.size();
		}
		
		/**
		 * Returns the TSM edge associated with this bend.
		 * 
		 * @return the edge
		 */
		public TSMEdge getEdge() {
			return edge;
		}
	}
	
	/** source node */
	public TSMNode source;
	/** target node */
	public TSMNode target;
	/** left face */
	public TSMFace leftFace;
	/** right face */
	public TSMFace rightFace;
	/** layout graph edge contained in this TSM edge, or null if there is none */
	public KLayoutEdge layoutEdge;
	/** the previous edge of a split edge */
	public TSMEdge previousEdge;
	/** the next edge of a split edge */
	public TSMEdge nextEdge;
	/** the bends of this edge */
	public final List<Bend> bends = new LinkedList<Bend>();
	/** the side on which the edge leaves the source */
	public TSMNode.Side sourceSide = TSMNode.Side.UNDEFINED;
	/** the side on which the edge reaches the target */
	public TSMNode.Side targetSide = TSMNode.Side.UNDEFINED;
	
	/**
	 * Creates an edge connecting two existing nodes, with a layout graph
	 * edge as reference.
	 * 
	 * @param graph the graph to which the new edge shall be added
	 * @param source source node
	 * @param target target node
	 * @param layoutEdge the layout graph edge to be contained
	 */
	public TSMEdge(TSMGraph graph, TSMNode source, TSMNode target,
			KLayoutEdge layoutEdge) {
		graph.edges.add(this);
		this.id = graph.nextEdgeId++;
		this.source = source;
		this.target = target;
		this.layoutEdge = layoutEdge;
	}
	
	/**
	 * Creates an edge connecting two existing nodes.
	 * 
	 * @param graph the graph to which the new edge shall be added
	 * @param source source node
	 * @param target target node
	 */
	public TSMEdge(TSMGraph graph, TSMNode source, TSMNode target) {
		this(graph, source, target, null);
	}
	
	/**
	 * Connects this edge with the source and target. New incidence
	 * entries are created for the incidence lists of the source and
	 * the target.
	 */
	public void connectNodes() {
		source.incidence.add(new TSMNode.IncEntry(this,
				TSMNode.IncEntry.Type.OUT));
		target.incidence.add(new TSMNode.IncEntry(this,
				TSMNode.IncEntry.Type.IN));
	}
	
	/**
	 * Connects this edge with the source and target with given ranks.
	 * New incidence entries are created for the incidence lists of the
	 * source and the target.
	 * 
	 * @param sourceRank rank of the edge at source
	 * @param targetRank rank of the edge at target
	 * @param forwardSelfLoop for self-loops: is the target rank greater
	 *     than the source rank?
	 */
	public void connectNodes(int sourceRank, int targetRank, boolean
			forwardSelfLoop) {
		if (source.id == target.id && (sourceRank < targetRank
				|| (sourceRank == targetRank && forwardSelfLoop)))
			targetRank++;
		source.incidence.add(sourceRank, new TSMNode.IncEntry(this,
				TSMNode.IncEntry.Type.OUT));
		target.incidence.add(targetRank, new TSMNode.IncEntry(this,
				TSMNode.IncEntry.Type.IN));		
	}
	
	/**
	 * Connects this edge with the source and target respecting the
	 * order of incidence according to the given node sides.
	 * 
	 * @param sourceSide port side at the source node
	 * @param targetSide port side at the target node
	 */
	public void connectNodes(TSMNode.Side sourceSide, TSMNode.Side targetSide) {
		this.sourceSide = sourceSide;
		this.targetSide = targetSide;
		ListIterator<TSMNode.IncEntry> incIter = source.incidence.listIterator();
		while (incIter.hasNext()) {
			TSMNode.IncEntry nextEntry = incIter.next();
			TSMNode.Side side = (nextEntry.type == TSMNode.IncEntry.Type.OUT
					? nextEntry.edge.sourceSide : nextEntry.edge.targetSide);
			if (sourceSide.compareTo(side) <= 0) {
				incIter.previous();
				break;
			}
		}
		incIter.add(new TSMNode.IncEntry(this, TSMNode.IncEntry.Type.OUT));
		incIter = target.incidence.listIterator();
		while (incIter.hasNext()) {
			TSMNode.IncEntry nextEntry = incIter.next();
			TSMNode.Side side = (nextEntry.type == TSMNode.IncEntry.Type.OUT
					? nextEntry.edge.sourceSide : nextEntry.edge.targetSide);
			if (targetSide.compareTo(side) <= 0) {
				incIter.previous();
				break;
			}
		}
		incIter.add(new TSMNode.IncEntry(this, TSMNode.IncEntry.Type.IN));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		return (other instanceof TSMEdge)
				&& ((TSMEdge)other).id == this.id;
	}
	
	/**
	 * Applies the layout to the original layout edge.
	 * 
	 * @param offsetX x offset to be added
	 * @param offsetY y offset to be added
	 */
	public void applyLayout(float offsetX, float offsetY) {
		// find the first edge in a series of edges
		TSMEdge currentEdge = this;
		while (currentEdge.previousEdge != null)
			currentEdge = currentEdge.previousEdge;
		TSMEdge firstEdge = currentEdge, lastEdge;
		
		// add all bend points of the edge
		List<KPoint> bendPoints = layoutEdge.getLayout().getBendPoints();
		bendPoints.clear();
		do {
			for (Bend bend : currentEdge.bends) {
				KPoint newPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
				newPoint.setX(bend.xpos + offsetX);
				newPoint.setY(bend.ypos + offsetY);
				bendPoints.add(newPoint);
			}
			lastEdge = currentEdge;
			// mark the edge as visited
			currentEdge.rank = 1;
			currentEdge = currentEdge.nextEdge;
		} while (currentEdge != null);
		
		// set start point
		KPoint newPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		float xpos = layoutEdge.getSource().getLayout().getLocation().getX()
				+ layoutEdge.getSourcePort().getLayout().getLocation().getX()
				+ offsetX;
		float ypos = layoutEdge.getSource().getLayout().getLocation().getY()
				+ layoutEdge.getSourcePort().getLayout().getLocation().getY()
				+ offsetY;
		switch (firstEdge.sourceSide) {
		case NORTH:
			xpos += layoutEdge.getSourcePort().getLayout().getSize().getWidth() / 2;
			break;
		case EAST:
			xpos += layoutEdge.getSourcePort().getLayout().getSize().getWidth();
			ypos += layoutEdge.getSourcePort().getLayout().getSize().getHeight() / 2;
			break;
		case SOUTH:
			xpos += layoutEdge.getSourcePort().getLayout().getSize().getWidth() / 2;
			ypos += layoutEdge.getSourcePort().getLayout().getSize().getHeight();
			break;
		case WEST:
			ypos += layoutEdge.getSourcePort().getLayout().getSize().getHeight() / 2;
			break;
		}
		newPoint.setX(xpos);
		newPoint.setY(ypos);
		layoutEdge.getLayout().setSourcePoint(newPoint);
		
		// set end point
		newPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		xpos = layoutEdge.getTarget().getLayout().getLocation().getX()
				+ layoutEdge.getTargetPort().getLayout().getLocation().getX()
				+ offsetX;
		ypos = layoutEdge.getTarget().getLayout().getLocation().getY()
				+ layoutEdge.getTargetPort().getLayout().getLocation().getY()
				+ offsetY;
		switch (lastEdge.targetSide) {
		case NORTH:
			xpos += layoutEdge.getTargetPort().getLayout().getSize().getWidth() / 2;
			break;
		case EAST:
			xpos += layoutEdge.getTargetPort().getLayout().getSize().getWidth();
			ypos += layoutEdge.getTargetPort().getLayout().getSize().getHeight() / 2;
			break;
		case SOUTH:
			xpos += layoutEdge.getTargetPort().getLayout().getSize().getWidth() / 2;
			ypos += layoutEdge.getTargetPort().getLayout().getSize().getHeight();
			break;
		case WEST:
			ypos += layoutEdge.getTargetPort().getLayout().getSize().getHeight() / 2;
			break;
		}
		newPoint.setX(xpos);
		newPoint.setY(ypos);
		layoutEdge.getLayout().setTargetPoint(newPoint);
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraphElement#toString()
	 */
	public String toString() {
		String baseString = super.toString();
		if (source != null && target != null)
			return baseString + " - [" + source.toString() + "] > ["
					+ target.toString() + "]";
		else return baseString;
	}
	
}
