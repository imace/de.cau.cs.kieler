package edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.unikiel.informatik.aiw.generated.epc.EpcFactory;
import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.epc.Function;
import edu.unikiel.informatik.aiw.generated.epc.Information;
import edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.policies.EpcBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class ProvidesDataToCreateCommand extends CreateElementCommand {

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
	private edu.unikiel.informatik.aiw.generated.epc.EPC container;

	/**
	 * @generated
	 */
	public ProvidesDataToCreateCommand(CreateRelationshipRequest request,
			EObject source, EObject target) {
		super(request);
		this.source = source;
		this.target = target;
		if (request.getContainmentFeature() == null) {
			setContainmentFeature(EpcPackage.eINSTANCE.getEPC_Connectors());
		}

		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null; element = element
				.eContainer()) {
			if (element instanceof edu.unikiel.informatik.aiw.generated.epc.EPC) {
				container = (edu.unikiel.informatik.aiw.generated.epc.EPC) element;
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
		if (source != null && !(source instanceof Information)) {
			return false;
		}
		if (target != null && !(target instanceof Function)) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return EpcBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateProvidesDataTo_3002(getContainer(), getSource(),
						getTarget());
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		// edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo newElement = (edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo) super.doDefaultElementCreation();
		ProvidesDataTo newElement = EpcFactory.eINSTANCE.createProvidesDataTo();
		getContainer().getConnectors().add(newElement);
		newElement.setSource(getSource());
		newElement.setTarget(getTarget());
		return newElement;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return EpcPackage.eINSTANCE.getEPC();
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
	protected Information getSource() {
		return (Information) source;
	}

	/**
	 * @generated
	 */
	protected Function getTarget() {
		return (Function) target;
	}

	/**
	 * @generated
	 */
	public edu.unikiel.informatik.aiw.generated.epc.EPC getContainer() {
		return container;
	}
}
