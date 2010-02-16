package de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.cau.cs.kieler.cakefeed.FBFBDataConnection;
import de.cau.cs.kieler.cakefeed.FBInputVar;
import de.cau.cs.kieler.cakefeed.FBOutputVar;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.policies.CakefeedBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class FBFBDataConnectionReorientCommand extends EditElementCommand {

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
	public FBFBDataConnectionReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof FBFBDataConnection) {
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
		if (!(oldEnd instanceof FBOutputVar && newEnd instanceof FBOutputVar)) {
			return false;
		}
		FBInputVar target = getLink().getDestination();
		if (!(getLink().eContainer() instanceof de.cau.cs.kieler.cakefeed.FBD)) {
			return false;
		}
		de.cau.cs.kieler.cakefeed.FBD container = (de.cau.cs.kieler.cakefeed.FBD) getLink()
				.eContainer();
		return CakefeedBaseItemSemanticEditPolicy.LinkConstraints
				.canExistFBFBDataConnection_4005(container, getNewSource(),
						target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof FBInputVar && newEnd instanceof FBInputVar)) {
			return false;
		}
		FBOutputVar source = getLink().getSource();
		if (!(getLink().eContainer() instanceof de.cau.cs.kieler.cakefeed.FBD)) {
			return false;
		}
		de.cau.cs.kieler.cakefeed.FBD container = (de.cau.cs.kieler.cakefeed.FBD) getLink()
				.eContainer();
		return CakefeedBaseItemSemanticEditPolicy.LinkConstraints
				.canExistFBFBDataConnection_4005(container, source,
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
	protected FBFBDataConnection getLink() {
		return (FBFBDataConnection) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected FBOutputVar getOldSource() {
		return (FBOutputVar) oldEnd;
	}

	/**
	 * @generated
	 */
	protected FBOutputVar getNewSource() {
		return (FBOutputVar) newEnd;
	}

	/**
	 * @generated
	 */
	protected FBInputVar getOldTarget() {
		return (FBInputVar) oldEnd;
	}

	/**
	 * @generated
	 */
	protected FBInputVar getNewTarget() {
		return (FBInputVar) newEnd;
	}
}
