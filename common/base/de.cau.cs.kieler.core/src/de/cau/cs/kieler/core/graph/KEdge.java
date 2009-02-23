package de.cau.cs.kieler.core.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * An edge in the graph structure used for the topology-shape-metrics
 * approach.
 * 
 * @author msp
 */
public class KEdge extends KGraphElement {

	/**
	 * Definition of an edge bend for orthogonal drawing.
	 */
	public static class Bend {
		/** Type of edge bend, from the perspective of the source node */
		public enum Type {
			UNDEFINED, LEFT, RIGHT
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
		private KEdge edge;
		
		/**
		 * Creates an edge bend of given type.
		 * 
		 * @param edge the edge to which the new bend is added
		 * @param type type of edge bend
		 */
		public Bend(KEdge edge, Type type) {
			this.edge = edge;
			this.type = type;
			index = edge.bends.size();
		}
		
		/**
		 * Returns the TSM edge associated with this bend.
		 * 
		 * @return the edge
		 */
		public KEdge getEdge() {
			return edge;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return type.toString();
		}
	}
	
	/** source node */
	public KNode source;
	/** target node */
	public KNode target;
	/** left face */
	public KFace leftFace;
	/** right face */
	public KFace rightFace;
	/** the bends of this edge */
	public final List<Bend> bends = new LinkedList<Bend>();
	/** the side on which the edge leaves the source */
	public KNode.Side sourceSide = KNode.Side.UNDEFINED;
	/** the side on which the edge reaches the target */
	public KNode.Side targetSide = KNode.Side.UNDEFINED;
	
	/**
	 * Creates an edge connecting two existing nodes.
	 * 
	 * @param graph the graph to which the new edge shall be added
	 * @param source source node
	 * @param target target node
	 */
	public KEdge(KGraph graph, KNode source, KNode target) {
		graph.edges.add(this);
		this.id = graph.nextEdgeId++;
		this.source = source;
		this.target = target;
	}
	
	/**
	 * Creates an edge connecting two existing nodes, with an object
	 * to be contained.
	 * 
	 * @param graph the graph to which the new edge shall be added
	 * @param source source node
	 * @param target target node
	 * @param obj object to be contained
	 */
	public KEdge(KGraph graph, KNode source, KNode target, Object obj) {
		this(graph, source, target);
		this.object = obj;
	}
	
	/**
	 * Connects this edge with the source and target. New incidence
	 * entries are created for the incidence lists of the source and
	 * the target.
	 */
	public void connectNodes() {
		source.incidence.add(new KNode.IncEntry(this,
				KNode.IncEntry.Type.OUT));
		target.incidence.add(new KNode.IncEntry(this,
				KNode.IncEntry.Type.IN));
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
		source.incidence.add(sourceRank, new KNode.IncEntry(this,
				KNode.IncEntry.Type.OUT));
		target.incidence.add(targetRank, new KNode.IncEntry(this,
				KNode.IncEntry.Type.IN));		
	}
	
	/**
	 * Connects this edge with the source and target respecting the
	 * order of incidence according to the given node sides.
	 * 
	 * @param sourceSide port side at the source node
	 * @param targetSide port side at the target node
	 */
	public void connectNodes(KNode.Side sourceSide, KNode.Side targetSide) {
		this.sourceSide = sourceSide;
		this.targetSide = targetSide;
		ListIterator<KNode.IncEntry> incIter = source.incidence.listIterator();
		while (incIter.hasNext()) {
			KNode.IncEntry nextEntry = incIter.next();
			KNode.Side side = (nextEntry.type == KNode.IncEntry.Type.OUT
					? nextEntry.edge.sourceSide : nextEntry.edge.targetSide);
			if (sourceSide.compareTo(side) <= 0) {
				incIter.previous();
				break;
			}
		}
		incIter.add(new KNode.IncEntry(this, KNode.IncEntry.Type.OUT));
		incIter = target.incidence.listIterator();
		while (incIter.hasNext()) {
			KNode.IncEntry nextEntry = incIter.next();
			KNode.Side side = (nextEntry.type == KNode.IncEntry.Type.OUT
					? nextEntry.edge.sourceSide : nextEntry.edge.targetSide);
			if (targetSide.compareTo(side) <= 0) {
				incIter.previous();
				break;
			}
		}
		incIter.add(new KNode.IncEntry(this, KNode.IncEntry.Type.IN));
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraphElement#toString()
	 */
	public String toString() {
		String baseString = super.toString();
		if (source != null && target != null)
			return baseString + " " + source.id + ">" + target.id;
		else return baseString;
	}
	
}
