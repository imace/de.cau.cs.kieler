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
package de.cau.cs.kieler.core.graph.kgraph.impl;

import de.cau.cs.kieler.core.graph.kgraph.KEdge;
import de.cau.cs.kieler.core.graph.kgraph.KFloatOption;
import de.cau.cs.kieler.core.graph.kgraph.KGraphData;
import de.cau.cs.kieler.core.graph.kgraph.KGraphElement;
import de.cau.cs.kieler.core.graph.kgraph.KGraphFactory;
import de.cau.cs.kieler.core.graph.kgraph.KGraphPackage;
import de.cau.cs.kieler.core.graph.kgraph.KIntOption;
import de.cau.cs.kieler.core.graph.kgraph.KLabel;
import de.cau.cs.kieler.core.graph.kgraph.KNode;
import de.cau.cs.kieler.core.graph.kgraph.KOption;
import de.cau.cs.kieler.core.graph.kgraph.KPort;
import de.cau.cs.kieler.core.graph.kgraph.KPortType;
import de.cau.cs.kieler.core.graph.kgraph.KStringOption;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KGraphPackageImpl extends EPackageImpl implements KGraphPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kGraphElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kGraphDataEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kEdgeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kPortEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kLabelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kOptionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kStringOptionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kIntOptionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass kFloatOptionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum kPortTypeEEnum = null;

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
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private KGraphPackageImpl() {
        super(eNS_URI, KGraphFactory.eINSTANCE);
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
    public static KGraphPackage init() {
        if (isInited) return (KGraphPackage)EPackage.Registry.INSTANCE.getEPackage(KGraphPackage.eNS_URI);

        // Obtain or create and register package
        KGraphPackageImpl theKGraphPackage = (KGraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof KGraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new KGraphPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        NotationPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theKGraphPackage.createPackageContents();

        // Initialize created meta-data
        theKGraphPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theKGraphPackage.freeze();

        return theKGraphPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKGraphElement() {
        return kGraphElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKGraphElement_Data() {
        return (EReference)kGraphElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKGraphData() {
        return kGraphDataEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKNode() {
        return kNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKNode_Children() {
        return (EReference)kNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKNode_Parent() {
        return (EReference)kNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKNode_Ports() {
        return (EReference)kNodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKNode_OutgoingEdges() {
        return (EReference)kNodeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKNode_IncomingEdges() {
        return (EReference)kNodeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKNode_Label() {
        return (EReference)kNodeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKEdge() {
        return kEdgeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKEdge_Source() {
        return (EReference)kEdgeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKEdge_Target() {
        return (EReference)kEdgeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKEdge_SourcePort() {
        return (EReference)kEdgeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKEdge_TargetPort() {
        return (EReference)kEdgeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKEdge_Labels() {
        return (EReference)kEdgeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKPort() {
        return kPortEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKPort_Node() {
        return (EReference)kPortEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKPort_Edges() {
        return (EReference)kPortEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getKPort_Label() {
        return (EReference)kPortEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKPort_Type() {
        return (EAttribute)kPortEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKLabel() {
        return kLabelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKLabel_Text() {
        return (EAttribute)kLabelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKOption() {
        return kOptionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKOption_Key() {
        return (EAttribute)kOptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKStringOption() {
        return kStringOptionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKStringOption_Value() {
        return (EAttribute)kStringOptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKIntOption() {
        return kIntOptionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKIntOption_Value() {
        return (EAttribute)kIntOptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKFloatOption() {
        return kFloatOptionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKFloatOption_Value() {
        return (EAttribute)kFloatOptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getKPortType() {
        return kPortTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KGraphFactory getKGraphFactory() {
        return (KGraphFactory)getEFactoryInstance();
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
        kGraphElementEClass = createEClass(KGRAPH_ELEMENT);
        createEReference(kGraphElementEClass, KGRAPH_ELEMENT__DATA);

        kGraphDataEClass = createEClass(KGRAPH_DATA);

        kNodeEClass = createEClass(KNODE);
        createEReference(kNodeEClass, KNODE__CHILDREN);
        createEReference(kNodeEClass, KNODE__PARENT);
        createEReference(kNodeEClass, KNODE__PORTS);
        createEReference(kNodeEClass, KNODE__OUTGOING_EDGES);
        createEReference(kNodeEClass, KNODE__INCOMING_EDGES);
        createEReference(kNodeEClass, KNODE__LABEL);

        kEdgeEClass = createEClass(KEDGE);
        createEReference(kEdgeEClass, KEDGE__SOURCE);
        createEReference(kEdgeEClass, KEDGE__TARGET);
        createEReference(kEdgeEClass, KEDGE__SOURCE_PORT);
        createEReference(kEdgeEClass, KEDGE__TARGET_PORT);
        createEReference(kEdgeEClass, KEDGE__LABELS);

        kPortEClass = createEClass(KPORT);
        createEReference(kPortEClass, KPORT__NODE);
        createEReference(kPortEClass, KPORT__EDGES);
        createEReference(kPortEClass, KPORT__LABEL);
        createEAttribute(kPortEClass, KPORT__TYPE);

        kLabelEClass = createEClass(KLABEL);
        createEAttribute(kLabelEClass, KLABEL__TEXT);

        kOptionEClass = createEClass(KOPTION);
        createEAttribute(kOptionEClass, KOPTION__KEY);

        kStringOptionEClass = createEClass(KSTRING_OPTION);
        createEAttribute(kStringOptionEClass, KSTRING_OPTION__VALUE);

        kIntOptionEClass = createEClass(KINT_OPTION);
        createEAttribute(kIntOptionEClass, KINT_OPTION__VALUE);

        kFloatOptionEClass = createEClass(KFLOAT_OPTION);
        createEAttribute(kFloatOptionEClass, KFLOAT_OPTION__VALUE);

        // Create enums
        kPortTypeEEnum = createEEnum(KPORT_TYPE);
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
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
        NotationPackage theNotationPackage = (NotationPackage)EPackage.Registry.INSTANCE.getEPackage(NotationPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        kGraphElementEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
        kGraphDataEClass.getESuperTypes().add(theNotationPackage.getStyle());
        kNodeEClass.getESuperTypes().add(this.getKGraphElement());
        kEdgeEClass.getESuperTypes().add(this.getKGraphElement());
        kPortEClass.getESuperTypes().add(this.getKGraphElement());
        kLabelEClass.getESuperTypes().add(this.getKGraphElement());
        kStringOptionEClass.getESuperTypes().add(this.getKOption());
        kIntOptionEClass.getESuperTypes().add(this.getKOption());
        kFloatOptionEClass.getESuperTypes().add(this.getKOption());

        // Initialize classes and features; add operations and parameters
        initEClass(kGraphElementEClass, KGraphElement.class, "KGraphElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getKGraphElement_Data(), this.getKGraphData(), null, "data", null, 0, -1, KGraphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        EOperation op = addEOperation(kGraphElementEClass, this.getKGraphData(), "getData", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEClass(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(kGraphDataEClass, KGraphData.class, "KGraphData", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(kNodeEClass, KNode.class, "KNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getKNode_Children(), this.getKNode(), this.getKNode_Parent(), "children", null, 0, -1, KNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKNode_Parent(), this.getKNode(), this.getKNode_Children(), "parent", null, 0, 1, KNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKNode_Ports(), this.getKPort(), this.getKPort_Node(), "ports", null, 0, -1, KNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKNode_OutgoingEdges(), this.getKEdge(), this.getKEdge_Source(), "outgoingEdges", null, 0, -1, KNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKNode_IncomingEdges(), this.getKEdge(), this.getKEdge_Target(), "incomingEdges", null, 0, -1, KNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKNode_Label(), this.getKLabel(), null, "label", null, 0, 1, KNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(kEdgeEClass, KEdge.class, "KEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getKEdge_Source(), this.getKNode(), this.getKNode_OutgoingEdges(), "source", null, 1, 1, KEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKEdge_Target(), this.getKNode(), this.getKNode_IncomingEdges(), "target", null, 1, 1, KEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKEdge_SourcePort(), this.getKPort(), null, "sourcePort", null, 0, 1, KEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKEdge_TargetPort(), this.getKPort(), null, "targetPort", null, 0, 1, KEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKEdge_Labels(), this.getKLabel(), null, "labels", null, 0, -1, KEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(kPortEClass, KPort.class, "KPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getKPort_Node(), this.getKNode(), this.getKNode_Ports(), "node", null, 1, 1, KPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKPort_Edges(), this.getKEdge(), null, "edges", null, 0, -1, KPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getKPort_Label(), this.getKLabel(), null, "label", null, 0, 1, KPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKPort_Type(), this.getKPortType(), "type", null, 0, 1, KPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(kLabelEClass, KLabel.class, "KLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKLabel_Text(), theEcorePackage.getEString(), "text", null, 1, 1, KLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(kOptionEClass, KOption.class, "KOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKOption_Key(), theEcorePackage.getEString(), "key", null, 0, 1, KOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(kStringOptionEClass, KStringOption.class, "KStringOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKStringOption_Value(), theEcorePackage.getEString(), "value", "", 0, 1, KStringOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(kIntOptionEClass, KIntOption.class, "KIntOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKIntOption_Value(), theEcorePackage.getEInt(), "value", null, 0, 1, KIntOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(kFloatOptionEClass, KFloatOption.class, "KFloatOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKFloatOption_Value(), theEcorePackage.getEFloat(), "value", null, 0, 1, KFloatOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(kPortTypeEEnum, KPortType.class, "KPortType");
        addEEnumLiteral(kPortTypeEEnum, KPortType.UNDEFINED);
        addEEnumLiteral(kPortTypeEEnum, KPortType.INPUT);
        addEEnumLiteral(kPortTypeEEnum, KPortType.OUTPUT);

        // Create resource
        createResource(eNS_URI);
    }

} //KGraphPackageImpl
