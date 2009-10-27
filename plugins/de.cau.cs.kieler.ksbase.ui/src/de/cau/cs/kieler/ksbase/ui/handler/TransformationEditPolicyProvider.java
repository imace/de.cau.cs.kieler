/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 * 
 *****************************************************************************/
package de.cau.cs.kieler.ksbase.ui.handler;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;

/**
 * Provides an edit policy the create and execute KSBasE commands.
 * 
 * @author Michael Matzen - mim AT informatik.uni-kiel.de
 * 
 */
public class TransformationEditPolicyProvider extends AbstractProvider
        implements IEditPolicyProvider {

    /** the key used to install an <i>execute transformation</i> edit policy. */
    public static final String EXECUTE_TRANSFORMATION_ROLE = "ExecuteTransformationEditPolicy";
    /** the key used to install an <i>KSBasE popup bar</i> edit policy. */
    public static final String KSBASE_POPUPBAR = "KSbasEPopupBarEditPolicy";

    /**
     * Creates the edit policies.
     * 
     * @param editPart
     *            The editPart to register this policy with.
     */
    public void createEditPolicies(final EditPart editPart) {
        editPart.installEditPolicy(EXECUTE_TRANSFORMATION_ROLE,
                new ExecuteTransformationEditPolicy());
        // editPart.installEditPolicy(KSBASE_POPUPBAR, new
        // KSBAsEPopupBarEditPolicy());
    }

    /**
     * Checks if this edit policy provides an operation.
     * 
     * @param operation The operation to check.
     * @return True if this edit policy provides the given operation
     */
    public boolean provides(final IOperation operation) {
        return operation instanceof CreateEditPoliciesOperation;
    }

}
