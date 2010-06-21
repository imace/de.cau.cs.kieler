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
 * 
 *****************************************************************************/
package de.cau.cs.kieler.synccharts.interfacedeclparser.formatting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;

import de.cau.cs.kieler.core.expressions.CombineOperator;
import de.cau.cs.kieler.core.expressions.ExpressionsPackage;
import de.cau.cs.kieler.core.expressions.Signal;
import de.cau.cs.kieler.core.expressions.ValueType;
import de.cau.cs.kieler.core.expressions.Variable;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;

/**
 * Overrides the DefaultTransientValueService to provide functionality for
 * syncchart signals and variables. For instance a Signaltype of PURE should not
 * be serialized even though it's set.
 * 
 * @author uru
 * @author car
 * 
 */
public class InterfaceDeclTransientValueService extends
        DefaultTransientValueService {

    private static SyncchartsPackage sync = SyncchartsPackage.eINSTANCE;
    private static ExpressionsPackage exp = ExpressionsPackage.eINSTANCE;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTransient(final EObject owner,
            final EStructuralFeature feature, final int index) {

        // TODO check whether variables need to be treated further.
        if (owner instanceof Variable) {
            Variable var = (Variable) owner;

            // initial value
            if (feature.equals(exp.getValuedObject_InitialValue())
                    && ((var.getInitialValue() != null) && var
                            .getInitialValue().trim() != "")) {
                return false;
            }
        }

        // if a signal is passed in, check for relevant elements being set
        if (owner instanceof Signal) {
            Signal sig = (Signal) owner;

            if ((feature.equals(exp.getValuedObject_Type()) && sig.getType() != ValueType.PURE)
                    || (feature.equals(exp.getSignal_CombineOperator()) && sig
                            .getCombineOperator() != CombineOperator.NONE)) {
                // combine and type
                return false;
            } else if (feature.equals(exp.getValuedObject_InitialValue())
                    && (sig.getInitialValue() != null)) {
                // initial value
                return false;
            } else if ((feature.equals(exp.getValuedObject_HostType())
                    && sig.getHostType() != null && sig.getHostType().length() > 0)
                    || (feature.equals(exp.getSignal_HostCombineOperator())
                            && sig.getHostCombineOperator() != null && sig
                            .getHostCombineOperator().length() > 0)) {
                // hosttype and hostcombine op
                return false;
            } else if (feature.equals(exp.getValuedObject_Name())) {
                // name
                return false;
            }
            return true;
        }

        // else return usual transientvalueservice return
        return super.isTransient(owner, feature, index);
    }
}
