package edu.unikiel.rtsys.klodd.orthogonal;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider;
import edu.unikiel.rtsys.klodd.core.KloddCorePlugin;

/**
 * Layout provider for the KLoDD orthogonal dataflow diagram layouter.
 * 
 * @author msp
 */
public class OrthogonalDataflowLayoutProvider extends
		KimlAbstractLayoutProvider {

	/** displayed name of this layout provider */
	public static final String LAYOUTER_NAME = "KLoDD Orthogonal";
	
	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider#doLayout(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup)
	 */
	public void doLayout(KNodeGroup nodeGroup) {
		// get the currently configured modules
		updateModules();

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

	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayoutProvider#getLayouterInfo()
	 */
	public LAYOUTER_INFO getLayouterInfo() {
		LAYOUTER_INFO info = KimlLayoutGraphFactory.eINSTANCE.createLAYOUTER_INFO();
		info.setLayouterName(LAYOUTER_NAME);
		info.setLayoutType(LAYOUT_TYPE.ORTHOGONAL);
		info.setLayoutOption(LAYOUT_OPTION.DEFAULT);
		info.setLayouterCollectionID(KloddCorePlugin.COLLECTION_NAME);
		return info;
	}
	
	/**
	 * Sets the internally used algorithm modules to the current configuration.
	 */
	private void updateModules() {
		
	}

}
