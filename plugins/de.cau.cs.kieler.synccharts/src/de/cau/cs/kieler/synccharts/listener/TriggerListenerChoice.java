package de.cau.cs.kieler.synccharts.listener;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import de.cau.cs.kieler.core.model.util.PossiblyEmptyCompoundCommand;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.StateType;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;
import de.cau.cs.kieler.synccharts.Transition;

/**
 * A SyncCharts TriggerListener that will react on Type changes of States and
 * set outgoing transitions of CONDITIONAL States to immediate.
 * 
 * @author haf
 */
public class TriggerListenerChoice extends FireOnceTriggerListener {

    public TriggerListenerChoice() {
        // either the type is changed explicitly or a new Conditional state is
        // inserted in a region
        super(NotificationFilter
                .createFeatureFilter(
                        SyncchartsPackage.eINSTANCE.getState_Type())
                .or(NotificationFilter
                        .createFeatureFilter(SyncchartsPackage.eINSTANCE
                                .getRegion_States()))
                .or(NotificationFilter
                        .createFeatureFilter(SyncchartsPackage.eINSTANCE
                                .getState_OutgoingTransitions())));
    }

    @Override
    protected Command trigger(final TransactionalEditingDomain domain,
            final Notification notification) {
        if (notification.getFeature().equals(
                SyncchartsPackage.eINSTANCE.getState_OutgoingTransitions())) {
            return handleNewTransition(notification);
        }

        PossiblyEmptyCompoundCommand cc = new PossiblyEmptyCompoundCommand();

        State state = null;
        StateType newStateType = null;
        StateType oldStateType = null;

        if (notification.getFeature().equals(
                SyncchartsPackage.eINSTANCE.getState_Type())) {
            state = (State) notification.getNotifier();
            newStateType = (StateType) notification.getNewValue();
            oldStateType = (StateType) notification.getOldValue();
        }
        if (notification.getFeature().equals(
                SyncchartsPackage.eINSTANCE.getRegion_States())) {
            if(notification.getNewValue() instanceof State){
                state = (State) notification.getNewValue();
            }
            // state might be null if a state is removed and not added
            if (state != null) {
                newStateType = state.getType();
            }
            oldStateType = null;
        }
        // in null case, no state was added but removed. we don't handle this
        // here
        if (state != null && newStateType != null
                && newStateType.equals(StateType.CONDITIONAL)
                && !newStateType.equals(oldStateType)) {
            for (Transition t : state.getOutgoingTransitions()) {
                cc.append(new SetCommand(getTarget(), t,
                        SyncchartsPackage.eINSTANCE.getAction_IsImmediate(),
                        true));
            }
        }
        return cc;
    }

    private Command handleNewTransition(final Notification notification) {
        State state = (State) notification.getNotifier();
        Transition transition = (Transition) notification.getNewValue();
        if (state.getType().equals(StateType.CONDITIONAL)) {
            return new SetCommand(getTarget(), transition,
                    SyncchartsPackage.eINSTANCE.getAction_IsImmediate(), true);
        }
        return null;
    }

}
