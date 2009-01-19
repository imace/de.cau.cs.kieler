package hierarchymealy.diagram.edit.policies;

import hierarchymealy.MealyPackage;
import hierarchymealy.diagram.edit.parts.CompositeState2EditPart;
import hierarchymealy.diagram.edit.parts.State2EditPart;
import hierarchymealy.diagram.part.MealyMachineDiagramUpdater;
import hierarchymealy.diagram.part.MealyMachineNodeDescriptor;
import hierarchymealy.diagram.part.MealyMachineVisualIDRegistry;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class CompositeStateCompositeStateCompartment2CanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = MealyMachineDiagramUpdater
				.getCompositeStateCompositeStateCompartment_5002SemanticChildren(
						viewObject).iterator(); it.hasNext();) {
			result.add(((MealyMachineNodeDescriptor) it.next())
					.getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = MealyMachineVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case State2EditPart.VISUAL_ID:
		case CompositeState2EditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(MealyPackage.eINSTANCE
					.getCompositeState_Nodes());
		}
		return myFeaturesToSynchronize;
	}

}
