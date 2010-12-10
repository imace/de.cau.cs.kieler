package de.cau.cs.kieler.synccharts.synchronizer.merge;

import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.merge.DefaultMerger;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EObject;

import de.cau.cs.kieler.core.kexpressions.ValuedObjectReference;
import de.cau.cs.kieler.synccharts.Assignment;
import de.cau.cs.kieler.synccharts.Emission;

public class MyUpdateReferenceMerger extends DefaultMerger {

	public boolean canApplyInOrigin() {
		return false;
	}

	public void applyInOrigin() {
	}

	public boolean canUndoInTarget() {
		return true;
	}

	public void undoInTarget() {
		final UpdateReference theDiff = (UpdateReference) this.diff;
		final EObject leftElement = theDiff.getLeftElement();
		final EObject rightElement = theDiff.getRightElement();

		EObject rightTarget = theDiff.getRightTarget();

		if (rightTarget.eResource().equals(leftElement.eResource())) {
			// very evil bug (likely
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=292311)
			// that makes differ confusing left- / rightTarget in several
			// situations
			rightTarget = theDiff.getLeftTarget();
			
		}
		
		// in case of a simultaneous exchange of some signal(s) / variable(s)
		// and references onto it the (renewed) rightTarget may be null
		// example: rename variable X into W (leads to disposition of X and introduction of W)
		// and update references to X into references to W leads to the problem
		if (rightTarget == null
				&& (leftElement instanceof Emission
					|| leftElement instanceof Assignment
					|| leftElement instanceof ValuedObjectReference)) {

			// bare the URIfragment by means of the resource
			// of the active EObject / editor = merge source
			String URIfragment = leftElement.eResource().getURIFragment(
					theDiff.getRightTarget());

			// bare the intended referenced target EObject by means of
			// the resource of the passive EObject /editor = merge target
			rightTarget = rightElement.eResource().getEObject(URIfragment);
		}

		try {
			EFactory.eSet(rightElement, theDiff.getReference().getName(),
					rightTarget);
		} catch (final FactoryException e) {
			EMFComparePlugin.log(e, true);
		}
		super.undoInTarget();
	}

}
