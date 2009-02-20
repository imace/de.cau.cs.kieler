package ssm.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import ssm.diagram.edit.parts.State3EditPart;
import ssm.diagram.part.SsmDiagramUpdater;
import ssm.diagram.part.SsmNodeDescriptor;
import ssm.diagram.part.SsmVisualIDRegistry;

/**
 * @generated
 */
public class StateStateCompartmentCanonicalEditPolicy extends
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
		for (Iterator it = SsmDiagramUpdater
				.getStateStateCompartment_7001SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			result.add(((SsmNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = SsmVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case State3EditPart.VISUAL_ID:
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
			myFeaturesToSynchronize.add(ssm.ssmPackage.eINSTANCE
					.getState_InnerStates());
		}
		return myFeaturesToSynchronize;
	}

}
