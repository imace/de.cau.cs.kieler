package edu.unikiel.rtsys.kieler.ssm.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeState2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.InitialStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SimpleStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineDiagramUpdater;
import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineNodeDescriptor;
import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry;

/**
 * @generated
 */
public class RegionRegionCompartmentCanonicalEditPolicy extends
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
				.getRegionRegionCompartment_7002SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
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
		case CompositeState2EditPart.VISUAL_ID:
		case SimpleStateEditPart.VISUAL_ID:
		case InitialStateEditPart.VISUAL_ID:
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
							.getRegion_States());
		}
		return myFeaturesToSynchronize;
	}

}
