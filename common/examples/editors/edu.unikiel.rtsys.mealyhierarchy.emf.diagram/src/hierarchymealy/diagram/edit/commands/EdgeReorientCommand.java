package hierarchymealy.diagram.edit.commands;

import hierarchymealy.CompositeState;
import hierarchymealy.Edge;
import hierarchymealy.State;
import hierarchymealy.diagram.edit.policies.MealyMachineBaseItemSemanticEditPolicy;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class EdgeReorientCommand extends EditElementCommand {

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
	public EdgeReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Edge) {
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
		if (!(oldEnd instanceof State && newEnd instanceof State)) {
			return false;
		}
		State target = getLink().getTargetNode();
		if (!(getLink().eContainer() instanceof CompositeState)) {
			return false;
		}
		CompositeState container = (CompositeState) getLink().eContainer();
		return MealyMachineBaseItemSemanticEditPolicy.LinkConstraints
				.canExistEdge_4001(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof State && newEnd instanceof State)) {
			return false;
		}
		State source = getLink().getSourceNode();
		if (!(getLink().eContainer() instanceof CompositeState)) {
			return false;
		}
		CompositeState container = (CompositeState) getLink().eContainer();
		return MealyMachineBaseItemSemanticEditPolicy.LinkConstraints
				.canExistEdge_4001(container, source, getNewTarget());
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
		getLink().setSourceNode(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTargetNode(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Edge getLink() {
		return (Edge) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected State getOldSource() {
		return (State) oldEnd;
	}

	/**
	 * @generated
	 */
	protected State getNewSource() {
		return (State) newEnd;
	}

	/**
	 * @generated
	 */
	protected State getOldTarget() {
		return (State) oldEnd;
	}

	/**
	 * @generated
	 */
	protected State getNewTarget() {
		return (State) newEnd;
	}
}
