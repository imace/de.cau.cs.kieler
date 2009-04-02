/**
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 * 
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright ${year} by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 *
 * $Id$
 */
package de.cau.cs.kieler.core.graph.kgraph.util;

import de.cau.cs.kieler.core.graph.kgraph.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.notation.Style;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage
 * @generated
 */
public class KGraphSwitch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static KGraphPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KGraphSwitch() {
        if (modelPackage == null) {
            modelPackage = KGraphPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case KGraphPackage.KGRAPH_ELEMENT: {
                KGraphElement kGraphElement = (KGraphElement)theEObject;
                T result = caseKGraphElement(kGraphElement);
                if (result == null) result = caseEModelElement(kGraphElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KGraphPackage.KGRAPH_DATA: {
                KGraphData kGraphData = (KGraphData)theEObject;
                T result = caseKGraphData(kGraphData);
                if (result == null) result = caseStyle(kGraphData);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KGraphPackage.KNODE: {
                KNode kNode = (KNode)theEObject;
                T result = caseKNode(kNode);
                if (result == null) result = caseKGraphElement(kNode);
                if (result == null) result = caseEModelElement(kNode);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KGraphPackage.KEDGE: {
                KEdge kEdge = (KEdge)theEObject;
                T result = caseKEdge(kEdge);
                if (result == null) result = caseKGraphElement(kEdge);
                if (result == null) result = caseEModelElement(kEdge);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KGraphPackage.KPORT: {
                KPort kPort = (KPort)theEObject;
                T result = caseKPort(kPort);
                if (result == null) result = caseKGraphElement(kPort);
                if (result == null) result = caseEModelElement(kPort);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KGraphPackage.KLABEL: {
                KLabel kLabel = (KLabel)theEObject;
                T result = caseKLabel(kLabel);
                if (result == null) result = caseKGraphElement(kLabel);
                if (result == null) result = caseEModelElement(kLabel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KGraphPackage.KOPTION: {
                KOption kOption = (KOption)theEObject;
                T result = caseKOption(kOption);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KGraphPackage.KSTRING_OPTION: {
                KStringOption kStringOption = (KStringOption)theEObject;
                T result = caseKStringOption(kStringOption);
                if (result == null) result = caseKOption(kStringOption);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KGraphPackage.KINT_OPTION: {
                KIntOption kIntOption = (KIntOption)theEObject;
                T result = caseKIntOption(kIntOption);
                if (result == null) result = caseKOption(kIntOption);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KGraphPackage.KFLOAT_OPTION: {
                KFloatOption kFloatOption = (KFloatOption)theEObject;
                T result = caseKFloatOption(kFloatOption);
                if (result == null) result = caseKOption(kFloatOption);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKGraphElement(KGraphElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKGraphData(KGraphData object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>KNode</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KNode</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKNode(KNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>KEdge</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KEdge</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKEdge(KEdge object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>KPort</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KPort</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKPort(KPort object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>KLabel</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KLabel</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKLabel(KLabel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>KOption</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KOption</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKOption(KOption object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>KString Option</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KString Option</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKStringOption(KStringOption object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>KInt Option</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KInt Option</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKIntOption(KIntOption object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>KFloat Option</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KFloat Option</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKFloatOption(KFloatOption object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEModelElement(EModelElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Style</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Style</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStyle(Style object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
        return null;
    }

} //KGraphSwitch
