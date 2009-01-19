package dataflow.diagram.services;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;

import dataflow.diagram.edit.parts.InputPortEditPart;
import dataflow.diagram.edit.parts.OutputPortEditPart;
import edu.unikiel.rtsys.kieler.kiml.ui.policies.LayoutEditPolicy;

/**
 * Edit policy provider implementation used for the layout of dataflow
 * diagrams.
 * 
 * @author msp
 */
public class DataflowLayoutEditPolicyProvider extends AbstractProvider
		implements IEditPolicyProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider#createEditPolicies(org.eclipse.gef.EditPart)
	 */
	public void createEditPolicies(EditPart editPart) {
		if (editPart instanceof InputPortEditPart
				|| editPart instanceof OutputPortEditPart) {
			editPart.installEditPolicy(EditPolicy.LAYOUT_ROLE,
					new LayoutEditPolicy());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		return operation instanceof CreateEditPoliciesOperation;
	}

}
