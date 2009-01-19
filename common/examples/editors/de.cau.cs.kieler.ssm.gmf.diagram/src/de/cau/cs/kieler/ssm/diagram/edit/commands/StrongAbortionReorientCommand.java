package de.cau.cs.kieler.ssm.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.cau.cs.kieler.ssm.diagram.edit.policies.SafeStateMachineBaseItemSemanticEditPolicy;

import de.cau.cs.kieler.ssm.AbstractState;
import de.cau.cs.kieler.ssm.Region;
import de.cau.cs.kieler.ssm.StrongAbortion;

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
		if (false == getElementToEdit() instanceof de.cau.cs.kieler.ssm.StrongAbortion) {
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
		if (!(oldEnd instanceof de.cau.cs.kieler.ssm.AbstractState && newEnd instanceof de.cau.cs.kieler.ssm.AbstractState)) {
			return false;
		}
		de.cau.cs.kieler.ssm.AbstractState target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof de.cau.cs.kieler.ssm.Region)) {
			return false;
		}
		de.cau.cs.kieler.ssm.Region container = (de.cau.cs.kieler.ssm.Region) getLink()
				.eContainer();
		return SafeStateMachineBaseItemSemanticEditPolicy.LinkConstraints
				.canExistStrongAbortion_4001(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof de.cau.cs.kieler.ssm.AbstractState && newEnd instanceof de.cau.cs.kieler.ssm.AbstractState)) {
			return false;
		}
		de.cau.cs.kieler.ssm.AbstractState source = getLink().getSource();
		if (!(getLink().eContainer() instanceof de.cau.cs.kieler.ssm.Region)) {
			return false;
		}
		de.cau.cs.kieler.ssm.Region container = (de.cau.cs.kieler.ssm.Region) getLink()
				.eContainer();
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
	protected de.cau.cs.kieler.ssm.StrongAbortion getLink() {
		return (de.cau.cs.kieler.ssm.StrongAbortion) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected de.cau.cs.kieler.ssm.AbstractState getOldSource() {
		return (de.cau.cs.kieler.ssm.AbstractState) oldEnd;
	}

	/**
	 * @generated
	 */
	protected de.cau.cs.kieler.ssm.AbstractState getNewSource() {
		return (de.cau.cs.kieler.ssm.AbstractState) newEnd;
	}

	/**
	 * @generated
	 */
	protected de.cau.cs.kieler.ssm.AbstractState getOldTarget() {
		return (de.cau.cs.kieler.ssm.AbstractState) oldEnd;
	}

	/**
	 * @generated
	 */
	protected de.cau.cs.kieler.ssm.AbstractState getNewTarget() {
		return (de.cau.cs.kieler.ssm.AbstractState) newEnd;
	}
}
