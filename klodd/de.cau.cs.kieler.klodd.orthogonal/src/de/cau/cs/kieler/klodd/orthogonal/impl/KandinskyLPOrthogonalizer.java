package de.cau.cs.kieler.klodd.orthogonal.impl;

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
		
		/* Example for using the LpSolve package
		LpSolve ilp = null;
		try {
			ilp = LpSolve.makeLp(2, 2);
			ilp.setMinim();
			ilp.setObjFn(new double[] {0.0, 1.0, 1.0});
			ilp.setRhVec(new double[] {0.0, 1.4, 2.2});
			ilp.setInt(1, true);
			ilp.setConstrType(1, LpSolve.GE);
			ilp.setRow(1, new double[] {0.0, 1.0, 0.0});
			ilp.setInt(2, true);
			ilp.setConstrType(2, LpSolve.GE);
			ilp.setRow(2, new double[] {0.0, 0.0, 1.0});
			
			int result = ilp.solve();
			if (result == LpSolve.OPTIMAL) {
				double[] solution = new double[1 + 2 + 2];
				ilp.getPrimalSolution(solution);
				System.out.println("Optimal solution:\n  objective function value "
						+ solution[0] + "\n  constraint values "
						+ solution[1] + ", " + solution[2]
						+ "\n  variable values " + solution[3] + ", " + solution[4]);
			}
			else {
				System.out.println("Non-optimal solution or failure: " + result);
			}
		}
		catch (LpSolveException exception) {
			exception.printStackTrace();
		}
		finally {
			if (ilp != null)
				ilp.deleteLp();
		}*/
	}

}
