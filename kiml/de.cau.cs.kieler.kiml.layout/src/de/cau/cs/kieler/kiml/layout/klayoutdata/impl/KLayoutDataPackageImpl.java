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
package de.cau.cs.kieler.kiml.layout.klayoutdata.impl;

import de.cau.cs.kieler.core.kgraph.KGraphPackage;

import de.cau.cs.kieler.kiml.layout.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutData;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutDataFactory;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutDataPackage;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KLayoutDataPackageImpl extends EPackageImpl implements KLayoutDataPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kLayoutDataEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kShapeLayoutEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kEdgeLayoutEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kPointEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutDataPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private KLayoutDataPackageImpl() {
        super(eNS_URI, KLayoutDataFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static KLayoutDataPackage init() {
        if (isInited) return (KLayoutDataPackage)EPackage.Registry.INSTANCE.getEPackage(KLayoutDataPackage.eNS_URI);

        // Obtain or create and register package
        KLayoutDataPackageImpl theKLayoutDataPackage = (KLayoutDataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof KLayoutDataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new KLayoutDataPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        KGraphPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theKLayoutDataPackage.createPackageContents();

        // Initialize created meta-data
        theKLayoutDataPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theKLayoutDataPackage.freeze();

        return theKLayoutDataPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKLayoutData() {
        return kLayoutDataEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKLayoutData_Options() {
        return (EReference)kLayoutDataEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKShapeLayout() {
        return kShapeLayoutEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKShapeLayout_Xpos() {
        return (EAttribute)kShapeLayoutEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKShapeLayout_Ypos() {
        return (EAttribute)kShapeLayoutEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKShapeLayout_Width() {
        return (EAttribute)kShapeLayoutEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKShapeLayout_Height() {
        return (EAttribute)kShapeLayoutEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKEdgeLayout() {
        return kEdgeLayoutEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKEdgeLayout_BendPoints() {
        return (EReference)kEdgeLayoutEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKEdgeLayout_SourcePoint() {
        return (EReference)kEdgeLayoutEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKEdgeLayout_TargetPoint() {
        return (EReference)kEdgeLayoutEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKPoint() {
        return kPointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKPoint_X() {
        return (EAttribute)kPointEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKPoint_Y() {
        return (EAttribute)kPointEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KLayoutDataFactory getKLayoutDataFactory() {
        return (KLayoutDataFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        kLayoutDataEClass = createEClass(KLAYOUT_DATA);
        createEReference(kLayoutDataEClass, KLAYOUT_DATA__OPTIONS);

        kShapeLayoutEClass = createEClass(KSHAPE_LAYOUT);
        createEAttribute(kShapeLayoutEClass, KSHAPE_LAYOUT__XPOS);
        createEAttribute(kShapeLayoutEClass, KSHAPE_LAYOUT__YPOS);
        createEAttribute(kShapeLayoutEClass, KSHAPE_LAYOUT__WIDTH);
        createEAttribute(kShapeLayoutEClass, KSHAPE_LAYOUT__HEIGHT);

        kEdgeLayoutEClass = createEClass(KEDGE_LAYOUT);
        createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__BEND_POINTS);
        createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__SOURCE_POINT);
        createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__TARGET_POINT);

        kPointEClass = createEClass(KPOINT);
        createEAttribute(kPointEClass, KPOINT__X);
        createEAttribute(kPointEClass, KPOINT__Y);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        KGraphPackage theKGraphPackage = (KGraphPackage)EPackage.Registry.INSTANCE.getEPackage(KGraphPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        kLayoutDataEClass.getESuperTypes().add(theKGraphPackage.getKGraphData());
        kShapeLayoutEClass.getESuperTypes().add(this.getKLayoutData());
        kEdgeLayoutEClass.getESuperTypes().add(this.getKLayoutData());

        // Initialize classes and features; add operations and parameters
        initEClass(kLayoutDataEClass, KLayoutData.class, "KLayoutData", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getKLayoutData_Options(), theKGraphPackage.getKOption(), null, "options", null, 0, -1, KLayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        EOperation op = addEOperation(kLayoutDataEClass, theKGraphPackage.getKOption(), "getOption", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(kShapeLayoutEClass, KShapeLayout.class, "KShapeLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKShapeLayout_Xpos(), theEcorePackage.getEFloat(), "xpos", null, 0, 1, KShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKShapeLayout_Ypos(), theEcorePackage.getEFloat(), "ypos", null, 0, 1, KShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKShapeLayout_Width(), theEcorePackage.getEFloat(), "width", null, 0, 1, KShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKShapeLayout_Height(), theEcorePackage.getEFloat(), "height", null, 0, 1, KShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(kEdgeLayoutEClass, KEdgeLayout.class, "KEdgeLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getKEdgeLayout_BendPoints(), this.getKPoint(), null, "bendPoints", null, 0, -1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKEdgeLayout_SourcePoint(), this.getKPoint(), null, "sourcePoint", null, 1, 1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKEdgeLayout_TargetPoint(), this.getKPoint(), null, "targetPoint", null, 1, 1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(kPointEClass, KPoint.class, "KPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKPoint_X(), theEcorePackage.getEFloat(), "x", null, 0, 1, KPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKPoint_Y(), theEcorePackage.getEFloat(), "y", null, 0, 1, KPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //KLayoutDataPackageImpl
