package de.cau.cs.kieler.klodd.orthogonal.impl;

import lpsolve.LpSolve;
import lpsolve.LpSolveException;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.modules.IOrthogonalizer;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;

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
	private class IlpSection {
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
		 * @param faceCount number of faces in the graph
		 */
		KandinskyRows(int nodeCount, int edgeCount, int faceCount) {
			k1 = new IlpSection(nodeCount);
			k2 = new IlpSection(k1, faceCount);
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
	
	private KandinskyRows rows;
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
			if (!node.edges.isEmpty())
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
			ilp.setInt(j, true);
			objFn[jx] = 1;
			objFnIndex[jx] = j;
		}
		ilp.setObjFnex(cols.objFn.count, objFn, objFnIndex);
		
		// set constraint K1
		int i = rows.k1.start;
		for (TSMNode node : graph.nodes) {
			int localEdgeCount = node.edges.size();
			if (localEdgeCount > 0) {
				ilp.setInt(i, true);
				ilp.setConstrType(i, LpSolve.EQ);
				ilp.setRh(i, 4);
				double[] row = new double[localEdgeCount];
				int[] rowIndex = new int[localEdgeCount];
				int jx = 0;
				for (TSMEdge edge : node.edges) {
					row[jx] = 1;
					if (edge.source.id == node.id)
						rowIndex[jx] = cols.sourceAnchor.start + edge.id;
					if (edge.target.id == node.id)
						rowIndex[jx] = cols.targetAnchor.start + edge.id;
					jx++;
				}
				ilp.setRowex(i, localEdgeCount, row, rowIndex);
				i++;
			}
		}

		return ilp;
	}
	
	/**
	 * Applies the ILP solution to the given graph.
	 * 
	 * @param graph graph to which the solution should be applied
	 * @param ilp ILP with solution vector
	 * @throws LpSolveException if the lp_solve library reports a failure
	 */
	private void applySolution(TSMGraph graph, LpSolve ilp) throws LpSolveException {
		/* example
		double[] solution = new double[1 + 2 + 2];
		ilp.getPrimalSolution(solution);
		System.out.println("Optimal solution:\n  objective function value "
				+ solution[0] + "\n  constraint values "
				+ solution[1] + ", " + solution[2]
				+ "\n  variable values " + solution[3] + ", " + solution[4]);*/
	}

}
