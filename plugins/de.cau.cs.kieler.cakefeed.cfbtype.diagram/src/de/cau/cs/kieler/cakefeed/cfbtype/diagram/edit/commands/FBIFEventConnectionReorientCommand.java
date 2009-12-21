package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.cau.cs.kieler.cakefeed.CFBType;
import de.cau.cs.kieler.cakefeed.FBIFEventConnection;
import de.cau.cs.kieler.cakefeed.FBOutputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies.CakefeedBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class FBIFEventConnectionReorientCommand extends EditElementCommand {

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
	public FBIFEventConnectionReorientCommand(
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
		if (false == getElementToEdit() instanceof FBIFEventConnection) {
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
		if (!(oldEnd instanceof FBOutputEvent && newEnd instanceof FBOutputEvent)) {
			return false;
		}
		IFOutputEvent target = getLink().getDestination();
		if (!(getLink().eContainer() instanceof CFBType)) {
			return false;
		}
		CFBType container = (CFBType) getLink().eContainer();
		return CakefeedBaseItemSemanticEditPolicy.LinkConstraints
				.canExistFBIFEventConnection_4009(container, getNewSource(),
						target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof IFOutputEvent && newEnd instanceof IFOutputEvent)) {
			return false;
		}
		FBOutputEvent source = getLink().getSource();
		if (!(getLink().eContainer() instanceof CFBType)) {
			return false;
		}
		CFBType container = (CFBType) getLink().eContainer();
		return CakefeedBaseItemSemanticEditPolicy.LinkConstraints
				.canExistFBIFEventConnection_4009(container, source,
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
	protected FBIFEventConnection getLink() {
		return (FBIFEventConnection) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected FBOutputEvent getOldSource() {
		return (FBOutputEvent) oldEnd;
	}

	/**
	 * @generated
	 */
	protected FBOutputEvent getNewSource() {
		return (FBOutputEvent) newEnd;
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
