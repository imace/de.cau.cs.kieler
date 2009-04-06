/**
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
 * $Id$
 */
package de.cau.cs.kieler.core.kgraph.impl;

import de.cau.cs.kieler.core.kgraph.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KGraphFactoryImpl extends EFactoryImpl implements KGraphFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static KGraphFactory init() {
        try {
            KGraphFactory theKGraphFactory = (KGraphFactory)EPackage.Registry.INSTANCE.getEFactory("http://rtsys.informatik.uni-kiel.de/trac/kieler/wiki/KGraph"); 
            if (theKGraphFactory != null) {
                return theKGraphFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new KGraphFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KGraphFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case KGraphPackage.KNODE: return createKNode();
            case KGraphPackage.KEDGE: return createKEdge();
            case KGraphPackage.KPORT: return createKPort();
            case KGraphPackage.KLABEL: return createKLabel();
            case KGraphPackage.KOPTION: return createKOption();
            case KGraphPackage.KSTRING_OPTION: return createKStringOption();
            case KGraphPackage.KINT_OPTION: return createKIntOption();
            case KGraphPackage.KFLOAT_OPTION: return createKFloatOption();
            case KGraphPackage.KOBJECT_OPTION: return createKObjectOption();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case KGraphPackage.KPORT_TYPE:
                return createKPortTypeFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case KGraphPackage.KPORT_TYPE:
                return convertKPortTypeToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KNode createKNode() {
        KNodeImpl kNode = new KNodeImpl();
        return kNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KEdge createKEdge() {
        KEdgeImpl kEdge = new KEdgeImpl();
        return kEdge;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KPort createKPort() {
        KPortImpl kPort = new KPortImpl();
        return kPort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KLabel createKLabel() {
        KLabelImpl kLabel = new KLabelImpl();
        return kLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KOption createKOption() {
        KOptionImpl kOption = new KOptionImpl();
        return kOption;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KStringOption createKStringOption() {
        KStringOptionImpl kStringOption = new KStringOptionImpl();
        return kStringOption;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KIntOption createKIntOption() {
        KIntOptionImpl kIntOption = new KIntOptionImpl();
        return kIntOption;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KFloatOption createKFloatOption() {
        KFloatOptionImpl kFloatOption = new KFloatOptionImpl();
        return kFloatOption;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KObjectOption createKObjectOption() {
        KObjectOptionImpl kObjectOption = new KObjectOptionImpl();
        return kObjectOption;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KPortType createKPortTypeFromString(EDataType eDataType, String initialValue) {
        KPortType result = KPortType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertKPortTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KGraphPackage getKGraphPackage() {
        return (KGraphPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static KGraphPackage getPackage() {
        return KGraphPackage.eINSTANCE;
    }

} //KGraphFactoryImpl
