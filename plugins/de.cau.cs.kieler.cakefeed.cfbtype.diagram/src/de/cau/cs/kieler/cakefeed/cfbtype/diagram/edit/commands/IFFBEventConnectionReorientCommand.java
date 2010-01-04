package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.cau.cs.kieler.cakefeed.CFBType;
import de.cau.cs.kieler.cakefeed.FBInputEvent;
import de.cau.cs.kieler.cakefeed.IFFBEventConnection;
import de.cau.cs.kieler.cakefeed.IFInputEvent;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies.CakefeedBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class IFFBEventConnectionReorientCommand extends EditElementCommand {

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
	public IFFBEventConnectionReorientCommand(
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
		if (false == getElementToEdit() instanceof IFFBEventConnection) {
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
		FBInputEvent target = getLink().getDestination();
		if (!(getLink().eContainer() instanceof CFBType)) {
			return false;
		}
		CFBType container = (CFBType) getLink().eContainer();
		return CakefeedBaseItemSemanticEditPolicy.LinkConstraints
				.canExistIFFBEventConnection_4008(container, getNewSource(),
						target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof FBInputEvent && newEnd instanceof FBInputEvent)) {
			return false;
		}
		IFInputEvent source = getLink().getSource();
		if (!(getLink().eContainer() instanceof CFBType)) {
			return false;
		}
		CFBType container = (CFBType) getLink().eContainer();
		return CakefeedBaseItemSemanticEditPolicy.LinkConstraints
				.canExistIFFBEventConnection_4008(container, source,
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
	protected IFFBEventConnection getLink() {
		return (IFFBEventConnection) getElementToEdit();
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
	protected FBInputEvent getOldTarget() {
		return (FBInputEvent) oldEnd;
	}

	/**
	 * @generated
	 */
	protected FBInputEvent getNewTarget() {
		return (FBInputEvent) newEnd;
	}
}
