/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uml.impl;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import uml.CreationEvent;
import uml.UmlPackage;

import uml.util.UmlValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Creation Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CreationEventImpl extends EventImpl implements CreationEvent {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CreationEventImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UmlPackage.eINSTANCE.getCreationEvent();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean no_occurrence_above(DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         UmlValidator.DIAGNOSTIC_SOURCE,
                         UmlValidator.CREATION_EVENT__NO_OCCURRENCE_ABOVE,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "no_occurrence_above", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

} //CreationEventImpl
