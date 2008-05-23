package edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.unikiel.informatik.aiw.generated.epc.Function;
import edu.unikiel.informatik.aiw.generated.epc.Information;
import edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.policies.EpcBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class ProvidesDataToReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public ProvidesDataToReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (!(getElementToEdit() instanceof ProvidesDataTo)) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Information && newEnd instanceof Information)) {
			return false;
		}
		Function target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof edu.unikiel.informatik.aiw.generated.epc.EPC)) {
			return false;
		}
		edu.unikiel.informatik.aiw.generated.epc.EPC container = (edu.unikiel.informatik.aiw.generated.epc.EPC) getLink()
				.eContainer();
		return EpcBaseItemSemanticEditPolicy.LinkConstraints
				.canExistProvidesDataTo_3002(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Function && newEnd instanceof Function)) {
			return false;
		}
		Information source = getLink().getSource();
		if (!(getLink().eContainer() instanceof edu.unikiel.informatik.aiw.generated.epc.EPC)) {
			return false;
		}
		edu.unikiel.informatik.aiw.generated.epc.EPC container = (edu.unikiel.informatik.aiw.generated.epc.EPC) getLink()
				.eContainer();
		return EpcBaseItemSemanticEditPolicy.LinkConstraints
				.canExistProvidesDataTo_3002(container, source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setSource(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected ProvidesDataTo getLink() {
		return (ProvidesDataTo) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Information getOldSource() {
		return (Information) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Information getNewSource() {
		return (Information) newEnd;
	}

	/**
	 * @generated
	 */
	protected Function getOldTarget() {
		return (Function) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Function getNewTarget() {
		return (Function) newEnd;
	}
}
