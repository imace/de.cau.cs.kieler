package edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.unikiel.informatik.aiw.generated.epc.Event;
import edu.unikiel.informatik.aiw.generated.epc.EventToOperatorConnection;
import edu.unikiel.informatik.aiw.generated.epc.LogicalOperator;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.policies.EpcBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class EventToOperatorConnectionReorientCommand extends
		EditElementCommand {

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
	public EventToOperatorConnectionReorientCommand(
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
		if (!(getElementToEdit() instanceof EventToOperatorConnection)) {
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
		if (!(oldEnd instanceof Event && newEnd instanceof Event)) {
			return false;
		}
		LogicalOperator target = getLink().getOperator();
		if (!(getLink().eContainer() instanceof edu.unikiel.informatik.aiw.generated.epc.EPC)) {
			return false;
		}
		edu.unikiel.informatik.aiw.generated.epc.EPC container = (edu.unikiel.informatik.aiw.generated.epc.EPC) getLink()
				.eContainer();
		return EpcBaseItemSemanticEditPolicy.LinkConstraints
				.canExistEventToOperatorConnection_3005(container,
						getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof LogicalOperator && newEnd instanceof LogicalOperator)) {
			return false;
		}
		Event source = getLink().getEvent();
		if (!(getLink().eContainer() instanceof edu.unikiel.informatik.aiw.generated.epc.EPC)) {
			return false;
		}
		edu.unikiel.informatik.aiw.generated.epc.EPC container = (edu.unikiel.informatik.aiw.generated.epc.EPC) getLink()
				.eContainer();
		return EpcBaseItemSemanticEditPolicy.LinkConstraints
				.canExistEventToOperatorConnection_3005(container, source,
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
		getLink().setEvent(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setOperator(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected EventToOperatorConnection getLink() {
		return (EventToOperatorConnection) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Event getOldSource() {
		return (Event) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Event getNewSource() {
		return (Event) newEnd;
	}

	/**
	 * @generated
	 */
	protected LogicalOperator getOldTarget() {
		return (LogicalOperator) oldEnd;
	}

	/**
	 * @generated
	 */
	protected LogicalOperator getNewTarget() {
		return (LogicalOperator) newEnd;
	}
}
