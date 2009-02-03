package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.Iterator;
import java.util.List;

import lpsolve.LpSolve;
import lpsolve.LpSolveException;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.modules.IOrthogonalizer;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;
import de.cau.cs.kieler.klodd.orthogonal.structures.TSMEdge.Bend;

/**
 * Orthogonalizer implementation that uses LP methods to solve the
 * Kandinsky approach.
 * 
 * @author msp
 */
public class KandinskyLPOrthogonalizer extends AbstractAlgorithm implements
		IOrthogonalizer {

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.IOrthogonalizer#orthogonalize(de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph)
	 */
	public void orthogonalize(TSMGraph graph) {
		// exit immediately in the trivial case
		if (graph.edges.isEmpty())
			return;
		
		LpSolve ilp = null;
		try {
			// construct an ILP from the given graph
			ilp = makeIlp(graph);
			
			// execute the solver on the ILP
			int result = ilp.solve();
			
			if (result == LpSolve.OPTIMAL || result == LpSolve.SUBOPTIMAL) {
				// apply the solution to the input graph
				applySolution(graph, ilp);
			}
			else throw new RuntimeException("No solution was found in orthogonalization phase (lp_solve result: "
					+ result + ").");
		}
		catch (LpSolveException exception) {
			throw new RuntimeException("Orthogonalization phase failed.", exception);
		}
		finally {
			if (ilp != null)
				ilp.deleteLp();
		}
	}
	
	/**
	 * Data structure that describes a section of an ILP problem, that
	 * is a part of the rows or of the columns of the problem matrix.
	 */
	private static class IlpSection {
		/** starting index of the section */
		int start;
		/** number of rows / columns of the section */
		int count;
		
		/**
		 * Creates an ILP section with starting value 1.
		 * @param count the number of elements of the new section
		 */
		IlpSection(int count) {
			this.start = 1;
			this.count = count;
		}
		
		/**
		 * Creates an ILP section that follows the given section.
		 * @param pred the predecessor of the new section
		 * @param count the number of elements of the new section
		 */
		IlpSection(IlpSection pred, int count) {
			this.start = pred.start + pred.count;
			this.count = count;
		}
	}
	
	/**
	 * Structure describing the dimensions of the rows in the Kandinsky ILP. 
	 */
	private class KandinskyRows {
		IlpSection k1, k2, k3, k4, k5;
		int count;
		
		/**
		 * Creates a rows dimensions structure.
		 * 
		 * @param nodeCount number of nodes with degree > 0 in the graph
		 * @param edgeCount number of edges in the graph
		 * @param faceCount number of internal faces in the graph
		 */
		KandinskyRows(int nodeCount, int edgeCount, int faceCount) {
			k1 = new IlpSection(nodeCount);
			k2 = new IlpSection(k1, faceCount + 1);
			k3 = new IlpSection(k2, 2 * edgeCount);
			k4 = new IlpSection(k3, 2 * edgeCount);
			k5 = new IlpSection(k4, 6 * edgeCount);
			count = k5.start + k5.count - 1;
		}
	}
	
	/**
	 * Structure describing the dimensions of the columns in the
	 * Kandinsky ILP.
	 */
	private class KandinskyCols {
		IlpSection forwSourceLeft, forwSourceRight, forwFaceLeft, forwFaceRight,
		    forwTargetLeft, forwTargetRight, backSourceLeft, backSourceRight,
		    backFaceLeft, backFaceRight, backTargetLeft, backTargetRight,
		    sourceAnchor, targetAnchor, objFn;
		int count;
		
		/**
		 * Creates a rows dimensions structure.
		 * 
		 * @param edgeCount number of edges in the graph
		 */
		KandinskyCols(int edgeCount) {
			forwSourceLeft = new IlpSection(edgeCount);
			forwSourceRight = new IlpSection(forwSourceLeft, edgeCount);
			forwFaceLeft = new IlpSection(forwSourceRight, edgeCount);
			forwFaceRight = new IlpSection(forwFaceLeft, edgeCount);
			forwTargetLeft = new IlpSection(forwFaceRight, edgeCount);
			forwTargetRight = new IlpSection(forwTargetLeft, edgeCount);
			objFn = new IlpSection(6 * edgeCount);
			backSourceLeft = new IlpSection(forwTargetRight, edgeCount);
			backSourceRight = new IlpSection(backSourceLeft, edgeCount);
			backFaceLeft = new IlpSection(backSourceRight, edgeCount);
			backFaceRight = new IlpSection(backFaceLeft, edgeCount);
			backTargetLeft = new IlpSection(backFaceRight, edgeCount);
			backTargetRight = new IlpSection(backTargetLeft, edgeCount);
			sourceAnchor = new IlpSection(backTargetRight, edgeCount);
			targetAnchor = new IlpSection(sourceAnchor, edgeCount);
			count = targetAnchor.start + targetAnchor.count - 1;
		}
	}
	
	/** the rows needed for the Kandinsky ILP */
	private KandinskyRows rows;
	/** the columns needed for the Kandinsky ILP */
	private KandinskyCols cols;
	
	/**
	 * Constructs an ILP using the Kandinsky model as a basis.
	 * 
	 * @param graph graph for which the ILP should be created
	 * @return an ILP containing all constraints needed for the input graph
	 * @throws LpSolveException if the lp_solve library reports a failure
	 */
	private LpSolve makeIlp(TSMGraph graph) throws LpSolveException {
		// count only nodes with degree > 0
		int nodeCount = 0;
		for (TSMNode node : graph.nodes) {
			if (!node.incidence.isEmpty())
				nodeCount++;
		}
		int edgeCount = graph.edges.size();
		int faceCount = graph.faces.size();
		// create dimensions of rows and columns
		rows = new KandinskyRows(nodeCount, edgeCount, faceCount);
		cols = new KandinskyCols(edgeCount);

		// create instance of ILP
		LpSolve ilp = LpSolve.makeLp(rows.count, cols.count);
		ilp.setMinim();
		
		// set objective function
		double[] objFn = new double[cols.objFn.count];
		int[] objFnIndex = new int[cols.objFn.count];
		for (int j = cols.objFn.start, jx = 0; jx < cols.objFn.count; j++, jx++) {
			objFn[jx] = 1;
			objFnIndex[jx] = j;
		}
		ilp.setObjFnex(cols.objFn.count, objFn, objFnIndex);
		
		// set variables types
		for (int j = 1; j <= cols.count; j++)
			ilp.setInt(j, true);
		
		// set variables bounds
		int end = cols.forwSourceLeft.start + cols.forwSourceLeft.count;
		for (int j = cols.forwSourceLeft.start; j < end; j++)
			ilp.setBounds(j, 0, 1);
		end = cols.forwSourceRight.start + cols.forwSourceRight.count;
		for (int j = cols.forwSourceRight.start; j < end; j++)
			ilp.setBounds(j, 0, 1);
		end = cols.forwTargetLeft.start + cols.forwTargetLeft.count;
		for (int j = cols.forwTargetLeft.start; j < end; j++)
			ilp.setBounds(j, 0, 1);
		end = cols.forwTargetRight.start + cols.forwTargetRight.count;
		for (int j = cols.forwTargetRight.start; j < end; j++)
			ilp.setBounds(j, 0, 1);
		end = cols.backSourceLeft.start + cols.backSourceLeft.count;
		for (int j = cols.backSourceLeft.start; j < end; j++)
			ilp.setBounds(j, 0, 1);
		end = cols.backSourceRight.start + cols.backSourceRight.count;
		for (int j = cols.backSourceRight.start; j < end; j++)
			ilp.setBounds(j, 0, 1);
		end = cols.backTargetLeft.start + cols.backTargetLeft.count;
		for (int j = cols.backTargetLeft.start; j < end; j++)
			ilp.setBounds(j, 0, 1);
		end = cols.backTargetRight.start + cols.backTargetRight.count;
		for (int j = cols.backTargetRight.start; j < end; j++)
			ilp.setBounds(j, 0, 1);
		end = cols.sourceAnchor.start + cols.sourceAnchor.count;
		for (int j = cols.sourceAnchor.start; j < end; j++)
			ilp.setBounds(j, 0, 4);
		end = cols.targetAnchor.start + cols.targetAnchor.count;
		for (int j = cols.targetAnchor.start; j < end; j++)
			ilp.setBounds(j, 0, 4);
		
		// set constraint K1
		int i = rows.k1.start;
		for (TSMNode node : graph.nodes) {
			if (setK1Constraint(node, ilp, i))
				i++;
		}
		
		// set constraint K2
		i = rows.k2.start;
		setK2Constraint(graph.externalFace, true, ilp, i++);
		for (TSMFace face : graph.faces) {
			setK2Constraint(face, false, ilp, i++);
		}
		
		// set constraint K3
		i = rows.k3.start;
		for (TSMEdge edge : graph.edges) {
			setK3Constraint(edge, ilp, i);
			i += 2;
		}
		
		// set constraint K4
		i = rows.k4.start;
		for (TSMNode node : graph.nodes) {
			if (!node.incidence.isEmpty()) {
				Iterator<TSMNode.IncEntry> edgeIter = node.incidence.iterator();
				TSMEdge currentEdge = edgeIter.next().edge;
				while (edgeIter.hasNext()) {
					TSMEdge nextEdge = edgeIter.next().edge;
					setK4Constraint(node, currentEdge, nextEdge, ilp, i++);
					currentEdge = nextEdge;
				}
				setK4Constraint(node, currentEdge, node.incidence.get(0).edge,
						ilp, i);
			}
		}
		
		// set constraint K5
		i = rows.k5.start;
		for (TSMEdge edge : graph.edges) {
			setK5Constraint(edge, ilp, i);
			i += 6;
		}
		
		ilp.setAddRowmode(true);
		// add constraints for dummy nodes
		for (TSMNode node : graph.nodes) {
			if (node.type == TSMNode.Type.CROSSING)
				addDummyNodeConstraint(node, ilp);
		}

		return ilp;
	}
	
	/**
	 * Creates a K1 node constraint for the given node. A new row is
	 * added only if the node has degree > 0.
	 * 
	 * @param node node for which the constraint shall be created
	 * @param ilp currently processed ILP instance
	 * @param i index of the row that shall be modified
	 * @return true if a row was added
	 * @throws LpSolveException if the lp_solve library reports a failure
	 */
	private boolean setK1Constraint(TSMNode node, LpSolve ilp, int i)
			throws LpSolveException {
		int localEdgeCount = node.incidence.size();
		if (localEdgeCount > 0) {
			ilp.setConstrType(i, LpSolve.EQ);
			ilp.setRh(i, 4);
			double[] row = new double[localEdgeCount];
			int[] rowIndex = new int[localEdgeCount];
			int jx = 0;
			for (TSMNode.IncEntry edgeEntry : node.incidence) {
				TSMEdge edge = edgeEntry.edge;
				row[jx] = 1;
				if (edge.source.id == node.id
						&& (edge.target.id != node.id || edge.rank != 1)) {
					rowIndex[jx] = cols.sourceAnchor.start + edge.id;
					if (edge.target.id == node.id)
						edge.rank = 1;
				}
				else if (edge.target.id == node.id
						&& (edge.source.id != node.id || edge.rank != -1)) {
					rowIndex[jx] = cols.targetAnchor.start + edge.id;
					if (edge.source.id == node.id)
						edge.rank = -1;
				}
				jx++;
			}
			ilp.setRowex(i, localEdgeCount, row, rowIndex);
			return true;
		}
		else return false;
	}
	
	/**
	 * Creates a K2 face constraint for the given face.
	 * 
	 * @param face face for which the constraint shall be created
	 * @param external if true, the given face is external
	 * @param ilp currently processed ILP instance
	 * @param i index of the row that shall be modified
	 * @throws LpSolveException if the lp_solve library reports a failure
	 */
	private void setK2Constraint(TSMFace face, boolean external,
			LpSolve ilp, int i) throws LpSolveException {
		int edgeCount = 0; 
		for (List<TSMFace.BorderEntry> border : face.borders) {
			edgeCount += border.size();
		}
		int colCount = 7 * edgeCount;
		
		ilp.setConstrType(i, LpSolve.EQ);
		if (external)
			ilp.setRh(i, 2 * edgeCount + 4);
		else
			ilp.setRh(i, 2 * edgeCount - 4);
		double[] row = new double[colCount];
		int[] rowIndex = new int[colCount];
		int jx = 0;
		for (List<TSMFace.BorderEntry> border : face.borders) {
			for (TSMFace.BorderEntry entry : border) {
				int edgeId = entry.edge.id;
				if (entry.edge.source.id == entry.node.id) {
					row[jx] = 1;
					rowIndex[jx++] = cols.sourceAnchor.start + edgeId;
					row[jx] = 1;
					rowIndex[jx++] = cols.forwSourceLeft.start + edgeId;
					row[jx] = 1;
					rowIndex[jx++] = cols.forwFaceLeft.start + edgeId;
					row[jx] = 1;
					rowIndex[jx++] = cols.forwTargetLeft.start + edgeId;
					row[jx] = -1;
					rowIndex[jx++] = cols.forwSourceRight.start + edgeId;
					row[jx] = -1;
					rowIndex[jx++] = cols.forwFaceRight.start + edgeId;
					row[jx] = -1;
					rowIndex[jx++] = cols.forwTargetRight.start + edgeId;
				}
				else {
					assert entry.edge.target.id == entry.node.id;
					row[jx] = 1;
					rowIndex[jx++] = cols.targetAnchor.start + edgeId;
					row[jx] = 1;
					rowIndex[jx++] = cols.backSourceLeft.start + edgeId;
					row[jx] = 1;
					rowIndex[jx++] = cols.backFaceLeft.start + edgeId;
					row[jx] = 1;
					rowIndex[jx++] = cols.backTargetLeft.start + edgeId;
					row[jx] = -1;
					rowIndex[jx++] = cols.backSourceRight.start + edgeId;
					row[jx] = -1;
					rowIndex[jx++] = cols.backFaceRight.start + edgeId;
					row[jx] = -1;
					rowIndex[jx++] = cols.backTargetRight.start + edgeId;
				}
			}
		}
		ilp.setRowex(i, colCount, row, rowIndex);
	}
	
	/**
	 * Creates two K3 edge constraints for the given edge. The first
	 * row is used for forward orientation, the second for backwards
	 * orientation.
	 * 
	 * @param edge the edge for which constraints shall be created
	 * @param ilp currently processed ILP instance
	 * @param i index of the first row that shall be modified
	 * @throws LpSolveException if the lp_solve library reports a failure
	 */
	private void setK3Constraint(TSMEdge edge, LpSolve ilp, int i)
			throws LpSolveException {
		double[] row = new double[2];
		int[] rowIndex = new int[2];

		ilp.setConstrType(i, LpSolve.LE);
		ilp.setRh(i, 1);
		row[0] = 1;
		rowIndex[0] = cols.forwSourceLeft.start + edge.id;
		row[1] = 1;
		rowIndex[1] = cols.forwSourceRight.start + edge.id;
		ilp.setRowex(i, 2, row, rowIndex);
		
		ilp.setConstrType(i + 1, LpSolve.LE);
		ilp.setRh(i + 1, 1);
		row[0] = 1;
		rowIndex[0] = cols.backSourceLeft.start + edge.id;
		row[1] = 1;
		rowIndex[1] = cols.backSourceRight.start + edge.id;
		ilp.setRowex(i + 1, 2, row, rowIndex);
	}
	
	/**
	 * Creates a K4 constraint for the two given edges.
	 * 
	 * @param node node incident to both edges
	 * @param leftEdge the left edge 
	 * @param rightEdge the right edge
	 * @param ilp currently processed ILP instance
	 * @param i index of the first row that shall be modified
	 * @throws LpSolveException if the lp_solve library reports a failure
	 */
	private void setK4Constraint(TSMNode node, TSMEdge leftEdge,
			TSMEdge rightEdge, LpSolve ilp, int i) throws LpSolveException {
		ilp.setConstrType(i, LpSolve.GE);
		ilp.setRh(i, 1);
		double[] row = new double[3];
		int[] rowIndex = new int[3];
		row[0] = 1;
		if (leftEdge.source.id == node.id
				&& (leftEdge.target.id != node.id || leftEdge.rank != 1)) {
			rowIndex[0] = cols.forwSourceLeft.start + leftEdge.id;
			if (leftEdge.target.id == node.id)
				leftEdge.rank = 1;
		}
		else if (leftEdge.target.id == node.id
				&& (leftEdge.source.id != node.id || leftEdge.rank != -1)) {
			rowIndex[0] = cols.backSourceLeft.start + leftEdge.id;
			if (leftEdge.source.id == node.id)
				leftEdge.rank = -1;
		}
		row[1] = 1;
		row[2] = 1;
		if (rightEdge.source.id == node.id
				&& (rightEdge.target.id != node.id || rightEdge.rank != 1)) {
			rowIndex[1] = cols.forwSourceRight.start + rightEdge.id;
			rowIndex[2] = cols.sourceAnchor.start + rightEdge.id;
			if (rightEdge.target.id == node.id)
				rightEdge.rank = 1;
		}
		else if (rightEdge.target.id == node.id
				&& (rightEdge.source.id != node.id || rightEdge.rank != -1)) {
			rowIndex[1] = cols.backSourceRight.start + rightEdge.id;
			rowIndex[2] = cols.targetAnchor.start + rightEdge.id;
			if (rightEdge.source.id == node.id)
				rightEdge.rank = -1;
		}
		ilp.setRowex(i, 2, row, rowIndex);
	}
	
	/**
	 * Creates six K5 edge constraints for the given edge. The first
	 * three rows are used for forward orientation, the second for
	 * backwards orientation.
	 * 
	 * @param edge the edge for which constraints shall be created
	 * @param ilp currently processed ILP instance
	 * @param i index of the first row that shall be modified
	 * @throws LpSolveException if the lp_solve library reports a failure
	 */
	private void setK5Constraint(TSMEdge edge, LpSolve ilp, int i)
			throws LpSolveException {
		double[] row = new double[2];
		int[] rowIndex = new int[2];

		ilp.setConstrType(i, LpSolve.EQ);
		ilp.setRh(i, 0);
		row[0] = 1;
		rowIndex[0] = cols.forwSourceLeft.start + edge.id;
		row[1] = -1;
		rowIndex[1] = cols.backTargetRight.start + edge.id;
		ilp.setRowex(i++, 2, row, rowIndex);
		
		ilp.setConstrType(i, LpSolve.EQ);
		ilp.setRh(i, 0);
		row[0] = 1;
		rowIndex[0] = cols.forwFaceLeft.start + edge.id;
		row[1] = -1;
		rowIndex[1] = cols.backFaceRight.start + edge.id;
		ilp.setRowex(i++, 2, row, rowIndex);
		
		ilp.setConstrType(i, LpSolve.EQ);
		ilp.setRh(i, 0);
		row[0] = 1;
		rowIndex[0] = cols.forwTargetLeft.start + edge.id;
		row[1] = -1;
		rowIndex[1] = cols.backSourceRight.start + edge.id;
		ilp.setRowex(i++, 2, row, rowIndex);
		
		ilp.setConstrType(i, LpSolve.EQ);
		ilp.setRh(i, 0);
		row[0] = 1;
		rowIndex[0] = cols.backSourceLeft.start + edge.id;
		row[1] = -1;
		rowIndex[1] = cols.forwTargetRight.start + edge.id;
		ilp.setRowex(i++, 2, row, rowIndex);
		
		ilp.setConstrType(i, LpSolve.EQ);
		ilp.setRh(i, 0);
		row[0] = 1;
		rowIndex[0] = cols.backFaceLeft.start + edge.id;
		row[1] = -1;
		rowIndex[1] = cols.forwFaceRight.start + edge.id;
		ilp.setRowex(i++, 2, row, rowIndex);
		
		ilp.setConstrType(i, LpSolve.EQ);
		ilp.setRh(i, 0);
		row[0] = 1;
		rowIndex[0] = cols.backTargetLeft.start + edge.id;
		row[1] = -1;
		rowIndex[1] = cols.forwSourceRight.start + edge.id;
		ilp.setRowex(i++, 2, row, rowIndex);
	}
	
	/**
	 * Creates a dummy node constraint for the given node. This adds four
	 * new rows to the ILP instance.
	 * 
	 * @param node node for which the constraint shall be created
	 * @param ilp currently processed ILP instance
	 * @throws LpSolveException if the lp_solve library reports a failure
	 */
	private void addDummyNodeConstraint(TSMNode node, LpSolve ilp)
			throws LpSolveException {
		assert node.incidence.size() == 4;
		double[] row = new double[1];
		int[] rowIndex = new int[1];
		for (TSMNode.IncEntry edgeEntry : node.incidence) {
			TSMEdge edge = edgeEntry.edge;
			row[0] = 1;
			if (edge.source.id == node.id
					&& (edge.target.id != node.id || edge.rank != 1)) {
				rowIndex[0] = cols.sourceAnchor.start + edge.id;
				if (edge.target.id == node.id)
					edge.rank = 1;
			}
			else if (edge.target.id == node.id
					&& (edge.source.id != node.id || edge.rank != -1)) {
				rowIndex[0] = cols.targetAnchor.start + edge.id;
				if (edge.source.id == node.id)
					edge.rank = -1;
			}
			ilp.addConstraintex(1, row, rowIndex, LpSolve.EQ, 1);
		}
	}
	
	/**
	 * Applies the ILP solution to the given graph.
	 * 
	 * @param graph graph to which the solution should be applied
	 * @param ilp ILP with solution vector
	 * @throws LpSolveException if the lp_solve library reports a failure
	 */
	private void applySolution(TSMGraph graph, LpSolve ilp) throws LpSolveException {
		int rowCount = ilp.getNrows();
		double[] solution = new double[1 + rowCount + ilp.getNcolumns()];
		ilp.getPrimalSolution(solution);
		for (TSMEdge edge : graph.edges) {
			// add all bends to the current edge
			if (solution[rowCount + cols.forwSourceLeft.start + edge.id] > 0.5)
				edge.bends.add(new Bend(Bend.Type.LEFT));
			if (solution[rowCount + cols.forwSourceRight.start + edge.id] > 0.5)
				edge.bends.add(new Bend(Bend.Type.RIGHT));
			long faceLeftBends = Math.round(solution[rowCount
			        + cols.forwFaceLeft.start + edge.id]);
			for (int i = 0; i < faceLeftBends; i++) {
				edge.bends.add(new Bend(Bend.Type.LEFT));
			}
			long faceRightBends = Math.round(solution[rowCount
			        + cols.forwFaceRight.start + edge.id]);
			for (int i = 0; i < faceRightBends; i++) {
				edge.bends.add(new Bend(Bend.Type.RIGHT));
			}
			if (solution[rowCount + cols.forwTargetLeft.start + edge.id] > 0.5)
				edge.bends.add(new Bend(Bend.Type.LEFT));
			if (solution[rowCount + cols.forwTargetRight.start + edge.id] > 0.5)
				edge.bends.add(new Bend(Bend.Type.RIGHT));
		}
	}

}
