package de.cau.cs.kieler.synccharts.contentadapter;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;

/**
 * A TriggerListener that executes the trigger only once for a given
 * transaction. That is, it will not call the trigger again, if the trigger
 * itself has caused some changes that lead to new notifications. This avoids
 * the usual notification loops.
 * 
 * @author haf
 */
public abstract class FireOnceTriggerListener extends FailSafeTriggerListener {

    protected Transaction transaction;

    public FireOnceTriggerListener(NotificationFilter filter) {
        super(filter);
    }
    
    public FireOnceTriggerListener(){
        super();
    }

    /**
     * Setting the Transaction in the event to null will also trigger this listener
     * no matter what.
     */
    @Override
    public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
        if (event.getTransaction() != null && transaction != null && transaction.isActive()) {
            // do nothing if the last transaction seen is not yet committed.
            // That means
            // we see changes performed within that transaction again
            return null;
        }
        // so this is a fresh transaction and we can process it
        if (event != null && event.getTransaction() != null) {
            this.transaction = event.getTransaction();
        }
        return super.transactionAboutToCommit(event);
    }
}
