package de.cau.cs.kieler.ssm.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.ssm.diagram.edit.parts.RegionEditPart;
import de.cau.cs.kieler.ssm.diagram.part.SafeStateMachineDiagramUpdater;
import de.cau.cs.kieler.ssm.diagram.part.SafeStateMachineNodeDescriptor;
import de.cau.cs.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry;


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
		for (Iterator it = SafeStateMachineDiagramUpdater
				.getCompositeStateCompositeStateCompartment_7003SemanticChildren(
						viewObject).iterator(); it.hasNext();) {
			result.add(((SafeStateMachineNodeDescriptor) it.next())
					.getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = SafeStateMachineVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case RegionEditPart.VISUAL_ID:
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
			myFeaturesToSynchronize
					.add(edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
							.getCompositeState_Regions());
		}
		return myFeaturesToSynchronize;
	}

}
