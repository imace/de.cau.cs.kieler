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
	 * Constructs an ILP using the Kandinsky model as a basis.
	 * 
	 * @param graph graph for which the ILP should be created
	 * @return an ILP containing all constraints needed for the input graph
	 * @throws LpSolveException if the lp_solve library reports a failure
	 */
	private LpSolve makeIlp(TSMGraph graph) throws LpSolveException {
		LpSolve ilp = LpSolve.makeLp(2, 2);
		
		ilp.setMinim();
		/* example
		ilp.setObjFn(new double[] {0.0, 1.0, 1.0});
		ilp.setRhVec(new double[] {0.0, 1.4, 2.2});
		ilp.setInt(1, true);
		ilp.setConstrType(1, LpSolve.GE);
		ilp.setRow(1, new double[] {0.0, 1.0, 0.0});
		ilp.setInt(2, true);
		ilp.setConstrType(2, LpSolve.GE);
		ilp.setRow(2, new double[] {0.0, 0.0, 1.0}); */

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
