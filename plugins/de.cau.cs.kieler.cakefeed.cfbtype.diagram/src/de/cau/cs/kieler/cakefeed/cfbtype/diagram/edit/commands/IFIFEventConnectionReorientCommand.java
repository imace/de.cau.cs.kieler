package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.cau.cs.kieler.cakefeed.FBNetwork;
import de.cau.cs.kieler.cakefeed.IFIFEventConnection;
import de.cau.cs.kieler.cakefeed.IFInputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies.CakefeedBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class IFIFEventConnectionReorientCommand extends EditElementCommand {

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
	public IFIFEventConnectionReorientCommand(
			ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof IFIFEventConnection) {
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
		if (!(oldEnd instanceof IFInputEvent && newEnd instanceof IFInputEvent)) {
			return false;
		}
		IFOutputEvent target = getLink().getDestination();
		if (!(getLink().eContainer() instanceof FBNetwork)) {
			return false;
		}
		FBNetwork container = (FBNetwork) getLink().eContainer();
		return CakefeedBaseItemSemanticEditPolicy.LinkConstraints
				.canExistIFIFEventConnection_4007(container, getNewSource(),
						target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof IFOutputEvent && newEnd instanceof IFOutputEvent)) {
			return false;
		}
		IFInputEvent source = getLink().getSource();
		if (!(getLink().eContainer() instanceof FBNetwork)) {
			return false;
		}
		FBNetwork container = (FBNetwork) getLink().eContainer();
		return CakefeedBaseItemSemanticEditPolicy.LinkConstraints
				.canExistIFIFEventConnection_4007(container, source,
						getNewTarget());
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
		getLink().setDestination(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected IFIFEventConnection getLink() {
		return (IFIFEventConnection) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected IFInputEvent getOldSource() {
		return (IFInputEvent) oldEnd;
	}

	/**
	 * @generated
	 */
	protected IFInputEvent getNewSource() {
		return (IFInputEvent) newEnd;
	}

	/**
	 * @generated
	 */
	protected IFOutputEvent getOldTarget() {
		return (IFOutputEvent) oldEnd;
	}

	/**
	 * @generated
	 */
	protected IFOutputEvent getNewTarget() {
		return (IFOutputEvent) newEnd;
	}
}
