/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.synccharts.text.kits.formatting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.parsetree.reconstr.impl.ValueSerializer;

import com.google.inject.Inject;

import de.cau.cs.kieler.core.expressions.ExpressionsPackage;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;
import de.cau.cs.kieler.synccharts.text.kits.KitsTransientValueService;

/**
 * customized {@link ITokenSerializer.IValueSerializer}. Realizes the output of the optional keyword
 * state and empty state labels. Works hand-in-hand with {@link KitsTransientValueService}.
 * 
 * @author chsch
 */
public class KitsValueSerializer extends ValueSerializer {

    @Inject
    IGrammarAccess grammarAccess;

    @Inject
    ITransientValueService transientValueService;

    /**
     * Decides whether a feature value of an EObject is valid to be serialized. In case the
     * assignment of a scope label is processed delegate to {@link KitsTransientValueService},
     * delegate to {@link ValueSerializer} otherwise.
     */
    public boolean isValid(EObject context, RuleCall ruleCall, Object value,
            IErrorAcceptor errorAcceptor) {

        // if we have a state under consideration and are processing the call of a
        // parser rule called from an assignment to a feature of the state
        // here: ... label = EString ... ,i.e. the call of the EString rule
        if (SyncchartsPackage.eINSTANCE.getScope().isInstance(context)
                && XtextPackage.eINSTANCE.getAssignment().isInstance(ruleCall.eContainer())) {

            Assignment a = (Assignment) ruleCall.eContainer();

            // if the feature the assignment is made to is the label feature
            if (a.getFeature().equals(SyncchartsPackage.eINSTANCE.getScope_Label().getName())) {

                // ask the transientValueService;
                // note that the return inverse value semantics!
                
                return !transientValueService.isTransient(context,
                        SyncchartsPackage.eINSTANCE.getScope_Label(), -1);
            }
        }

        // if we have a signal under consideration and are processing the call of a
        // parser rule called from an assignment to a feature of the signal
        // here: ... hostType = EString ... ,i.e. the call of the EString rule
        // or: ... hostCombineOperator = EString ... ,i.e. the call of the EString rule
        if (ExpressionsPackage.eINSTANCE.getValuedObject().isInstance(context)
                && XtextPackage.eINSTANCE.getAssignment().isInstance(ruleCall.eContainer())) {

            Assignment a = (Assignment) ruleCall.eContainer();

            // if the feature the assignment is made to is the 'initialValue' feature
            if (a.getFeature().equals(
                    ExpressionsPackage.eINSTANCE.getValuedObject_InitialValue().getName())) {

                // ask the transientValueService;
                // note that the return inverse value semantics!
                return !transientValueService.isTransient(context,
                        ExpressionsPackage.eINSTANCE.getValuedObject_InitialValue(), -1);
            }

            // if the feature the assignment is made to is the 'hostType' feature
            if (a.getFeature().equals(
                    ExpressionsPackage.eINSTANCE.getValuedObject_HostType().getName())) {

                // ask the transientValueService;
                // note that the return inverse value semantics!
                return !transientValueService.isTransient(context,
                        ExpressionsPackage.eINSTANCE.getValuedObject_HostType(), -1);
            }

            // if the feature the assignment is made to is the 'hostCombineOperator' feature
            if (a.getFeature().equals(
                    ExpressionsPackage.eINSTANCE.getSignal_HostCombineOperator().getName())) {

                // ask the transientValueService;
                // note that the return inverse value semantics!
                return !transientValueService.isTransient(context,
                        ExpressionsPackage.eINSTANCE.getSignal_HostCombineOperator(), -1);
            }
        }
        return super.isValid(context, ruleCall, value, errorAcceptor);
    }

}
