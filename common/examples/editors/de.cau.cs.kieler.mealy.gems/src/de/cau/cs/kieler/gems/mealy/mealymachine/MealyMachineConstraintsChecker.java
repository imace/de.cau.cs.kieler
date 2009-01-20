
package de.cau.cs.kieler.gems.mealy.mealymachine;

import org.eclipse.gmt.gems.model.AbstractConstraintsChecker;

import org.eclipse.gmt.gems.model.Container;
import org.eclipse.gmt.gems.model.ModelObject;
import org.eclipse.gmt.gems.model.ModelUtilities;
import org.eclipse.gmt.gems.model.Model;
import org.eclipse.gmt.gems.model.event.ModelChangeEvent;
import org.eclipse.gmt.gems.model.ExecutableConstraint;
import org.eclipse.gmt.gems.model.ExecutableEventConstraint;
import org.eclipse.gmt.gems.model.Root;
import org.eclipse.gmt.gems.metamodel.ConstraintMemento;
import org.eclipse.gmt.gems.model.actions.EventInterestFactory;
import org.eclipse.gmt.gems.model.actions.EventInterestFactoryRepository;
import org.eclipse.gmt.gems.model.actions.PersistentModelEventInterest;

public class MealyMachineConstraintsChecker extends AbstractConstraintsChecker {

    /**
     * 
     */
    public MealyMachineConstraintsChecker() {
        super();
    }
    
    public void createConstraints() {
        addConnectionConstraint(State.class,
                                State.class,
                                0,
                                2147483647,
                                0,
                                2147483647,
                                TransitionConnectionType.INSTANCE);
       
       
        addContainmentConstraint(MealyMachine.class,
                                 State.class,
                                 0,
                                 2147483647);
        addContainmentConstraint(MealyMachine.class,
                                 State.class,
                                 0,
                                 2147483647);
        addContainmentConstraint(Root.class,
                                 State.class,
                                 0,
                                 Integer.MAX_VALUE);
        
    }
    
    public java.util.List<org.eclipse.gmt.gems.Memento> getConstraintMementos(){
        java.util.LinkedList<org.eclipse.gmt.gems.Memento> mems = new java.util.LinkedList<org.eclipse.gmt.gems.Memento>();
    	 
        return mems;
    }


}
