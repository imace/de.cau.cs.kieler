package de.cau.cs.kieler.ssm.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.cau.cs.kieler.ssm.diagram.edit.policies.SafeStateMachineBaseItemSemanticEditPolicy;

import de.cau.cs.kieler.ssm.AbstractState;
import de.cau.cs.kieler.ssm.NormalTermination;
import de.cau.cs.kieler.ssm.Region;

/**
 * @generated
 */
public class NormalTerminationCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	private de.cau.cs.kieler.ssm.Region container;

	/**
	 * @generated
	 */
	public NormalTerminationCreateCommand(CreateRelationshipRequest request,
			EObject source, EObject target) {
		super(request);
		this.source = source;
		this.target = target;
		if (request.getContainmentFeature() == null) {
			setContainmentFeature(de.cau.cs.kieler.ssm.ssmPackage.eINSTANCE
					.getRegion_Transitions());
		}

		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null; element = element
				.eContainer()) {
			if (element instanceof de.cau.cs.kieler.ssm.Region) {
				container = (de.cau.cs.kieler.ssm.Region) element;
				super.setElementToEdit(container);
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null
				&& false == source instanceof de.cau.cs.kieler.ssm.AbstractState) {
			return false;
		}
		if (target != null
				&& false == target instanceof de.cau.cs.kieler.ssm.AbstractState) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return SafeStateMachineBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateNormalTermination_4002(getContainer(), getSource(),
						getTarget());
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		de.cau.cs.kieler.ssm.NormalTermination newElement = de.cau.cs.kieler.ssm.ssmFactory.eINSTANCE
				.createNormalTermination();
		getContainer().getTransitions().add(newElement);
		newElement.setSource(getSource());
		newElement.setTarget(getTarget());
		return newElement;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return de.cau.cs.kieler.ssm.ssmPackage.eINSTANCE.getRegion();
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in create link command"); //$NON-NLS-1$
		}
		return super.doExecuteWithResult(monitor, info);
	}

	/**
	 * @generated
	 */
	protected ConfigureRequest createConfigureRequest() {
		ConfigureRequest request = super.createConfigureRequest();
		request.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		request.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		return request;
	}

	/**
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected de.cau.cs.kieler.ssm.AbstractState getSource() {
		return (de.cau.cs.kieler.ssm.AbstractState) source;
	}

	/**
	 * @generated
	 */
	protected de.cau.cs.kieler.ssm.AbstractState getTarget() {
		return (de.cau.cs.kieler.ssm.AbstractState) target;
	}

	/**
	 * @generated
	 */
	public de.cau.cs.kieler.ssm.Region getContainer() {
		return container;
	}
}
