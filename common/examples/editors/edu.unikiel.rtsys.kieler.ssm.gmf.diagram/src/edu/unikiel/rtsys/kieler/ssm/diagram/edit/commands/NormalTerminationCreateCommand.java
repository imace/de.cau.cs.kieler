package edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.unikiel.rtsys.kieler.ssm.AbstractState;
import edu.unikiel.rtsys.kieler.ssm.Region;
import edu.unikiel.rtsys.kieler.ssm.WeakAbortion;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.policies.SafeStateMachineBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class NormalTerminationCreateCommand extends CreateElementCommand {

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
    private Region container;

    /**
     * @generated
     */
    public NormalTerminationCreateCommand(CreateRelationshipRequest request,
            EObject source, EObject target) {
        super(request);
        this.source = source;
        this.target = target;
        if (request.getContainmentFeature() == null) {
            setContainmentFeature(edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                    .getRegion_Transitions());
        }

        // Find container element for the new link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null; element = element
                .eContainer()) {
            if (element instanceof Region) {
                container = (Region) element;
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
        if (source != null && false == source instanceof AbstractState) {
            return false;
        }
        if (target != null && false == target instanceof AbstractState) {
            return false;
        }
        if (getSource() == null) {
            return true; // link creation is in progress; source is not defined yet
        }
        // target may be null here but it's possible to check constraint
        if (getContainer() == null) {
            return false;
        }
        return SafeStateMachineBaseItemSemanticEditPolicy.LinkConstraints
                .canCreateWeakAbortion_4003(getContainer(), getSource(),
                        getTarget());
    }

    /**
     * @generated
     */
    protected EObject doDefaultElementCreation() {
        WeakAbortion newElement = edu.unikiel.rtsys.kieler.ssm.ssmFactory.eINSTANCE
                .createWeakAbortion();
        getContainer().getTransitions().add(newElement);
        newElement.setSource(getSource());
        newElement.setTarget(getTarget());
        return newElement;
    }

    /**
     * @generated
     */
    protected EClass getEClassToEdit() {
        return edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE.getRegion();
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
    protected AbstractState getSource() {
        return (AbstractState) source;
    }

    /**
     * @generated
     */
    protected AbstractState getTarget() {
        return (AbstractState) target;
    }

    /**
     * @generated
     */
    public Region getContainer() {
        return container;
    }
}
