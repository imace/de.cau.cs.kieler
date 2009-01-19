package de.cau.cs.kieler.ssm.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.cau.cs.kieler.ssm.diagram.edit.policies.SafeStateMachineBaseItemSemanticEditPolicy;

import edu.unikiel.rtsys.kieler.ssm.AbstractState;
import edu.unikiel.rtsys.kieler.ssm.Region;
import edu.unikiel.rtsys.kieler.ssm.StrongAbortion;

/**
 * @generated
 */
public class StrongAbortionReorientCommand extends EditElementCommand {

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
	public StrongAbortionReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof StrongAbortion) {
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
		if (!(oldEnd instanceof AbstractState && newEnd instanceof AbstractState)) {
			return false;
		}
		AbstractState target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof Region)) {
			return false;
		}
		Region container = (Region) getLink().eContainer();
		return SafeStateMachineBaseItemSemanticEditPolicy.LinkConstraints
				.canExistStrongAbortion_4001(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof AbstractState && newEnd instanceof AbstractState)) {
			return false;
		}
		AbstractState source = getLink().getSource();
		if (!(getLink().eContainer() instanceof Region)) {
			return false;
		}
		Region container = (Region) getLink().eContainer();
		return SafeStateMachineBaseItemSemanticEditPolicy.LinkConstraints
				.canExistStrongAbortion_4001(container, source, getNewTarget());
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
	protected StrongAbortion getLink() {
		return (StrongAbortion) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected AbstractState getOldSource() {
		return (AbstractState) oldEnd;
	}

	/**
	 * @generated
	 */
	protected AbstractState getNewSource() {
		return (AbstractState) newEnd;
	}

	/**
	 * @generated
	 */
	protected AbstractState getOldTarget() {
		return (AbstractState) oldEnd;
	}

	/**
	 * @generated
	 */
	protected AbstractState getNewTarget() {
		return (AbstractState) newEnd;
	}
}
