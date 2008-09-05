/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabelLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kShapeLayout;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
public class KimlLayoutGraphPackageImpl extends EPackageImpl implements KimlLayoutGraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kInsetsEClass = null;

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
	private EClass kLayoutGraphEClass = null;

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
	private EClass kNodeGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kEdgeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kNodeGroupLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kEdgeLabelLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum edgE_TYPESEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum edgE_LABEL_PLACEMENTEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum layouT_TYPESEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum layouT_OPTIONSEEnum = null;

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
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private KimlLayoutGraphPackageImpl() {
		super(eNS_URI, KimlLayoutGraphFactory.eINSTANCE);
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
	public static KimlLayoutGraphPackage init() {
		if (isInited) return (KimlLayoutGraphPackage)EPackage.Registry.INSTANCE.getEPackage(KimlLayoutGraphPackage.eNS_URI);

		// Obtain or create and register package
		KimlLayoutGraphPackageImpl theKimlLayoutGraphPackage = (KimlLayoutGraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof KimlLayoutGraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new KimlLayoutGraphPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theKimlLayoutGraphPackage.createPackageContents();

		// Initialize created meta-data
		theKimlLayoutGraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theKimlLayoutGraphPackage.freeze();

		return theKimlLayoutGraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getkPoint() {
		return kPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkPoint_X() {
		return (EAttribute)kPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkPoint_Y() {
		return (EAttribute)kPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getkDimension() {
		return kDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkDimension_Height() {
		return (EAttribute)kDimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkDimension_Width() {
		return (EAttribute)kDimensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getkInsets() {
		return kInsetsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkInsets_Bottom() {
		return (EAttribute)kInsetsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkInsets_Left() {
		return (EAttribute)kInsetsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkInsets_Right() {
		return (EAttribute)kInsetsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkInsets_Top() {
		return (EAttribute)kInsetsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getkEdge() {
		return kEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkEdge_Source() {
		return (EReference)kEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkEdge_Target() {
		return (EReference)kEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkEdge_EdgeLayout() {
		return (EReference)kEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkEdge_EdgeLabel() {
		return (EReference)kEdgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getkLayoutGraph() {
		return kLayoutGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkLayoutGraph_TopGroup() {
		return (EReference)kLayoutGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getkShapeLayout() {
		return kShapeLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkShapeLayout_Location() {
		return (EReference)kShapeLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkShapeLayout_Size() {
		return (EReference)kShapeLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkShapeLayout_Insets() {
		return (EReference)kShapeLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getkEdgeLayout() {
		return kEdgeLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkEdgeLayout_SourcePoint() {
		return (EReference)kEdgeLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkEdgeLayout_TargetPoint() {
		return (EReference)kEdgeLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkEdgeLayout_GridPoints() {
		return (EReference)kEdgeLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkEdgeLayout_EdgeType() {
		return (EAttribute)kEdgeLayoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getkNodeGroup() {
		return kNodeGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkNodeGroup_SubNodeGroups() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkNodeGroup_OutgoingEdges() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkNodeGroup_IncomingEdges() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkNodeGroup_ParentGroup() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkNodeGroup_NodeGroupLayout() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getkEdgeLabel() {
		return kEdgeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkEdgeLabel_Text() {
		return (EAttribute)kEdgeLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getkEdgeLabel_EdgeLabelLayout() {
		return (EReference)kEdgeLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getkNodeGroupLayout() {
		return kNodeGroupLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkNodeGroupLayout_LayoutType() {
		return (EAttribute)kNodeGroupLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkNodeGroupLayout_LayoutOptions() {
		return (EAttribute)kNodeGroupLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getkEdgeLabelLayout() {
		return kEdgeLabelLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getkEdgeLabelLayout_EdgeLabelPlacement() {
		return (EAttribute)kEdgeLabelLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEDGE_TYPES() {
		return edgE_TYPESEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEDGE_LABEL_PLACEMENT() {
		return edgE_LABEL_PLACEMENTEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLAYOUT_TYPES() {
		return layouT_TYPESEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLAYOUT_OPTIONS() {
		return layouT_OPTIONSEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KimlLayoutGraphFactory getKimlLayoutGraphFactory() {
		return (KimlLayoutGraphFactory)getEFactoryInstance();
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
		kPointEClass = createEClass(KPOINT);
		createEAttribute(kPointEClass, KPOINT__X);
		createEAttribute(kPointEClass, KPOINT__Y);

		kDimensionEClass = createEClass(KDIMENSION);
		createEAttribute(kDimensionEClass, KDIMENSION__HEIGHT);
		createEAttribute(kDimensionEClass, KDIMENSION__WIDTH);

		kInsetsEClass = createEClass(KINSETS);
		createEAttribute(kInsetsEClass, KINSETS__BOTTOM);
		createEAttribute(kInsetsEClass, KINSETS__LEFT);
		createEAttribute(kInsetsEClass, KINSETS__RIGHT);
		createEAttribute(kInsetsEClass, KINSETS__TOP);

		kEdgeEClass = createEClass(KEDGE);
		createEReference(kEdgeEClass, KEDGE__SOURCE);
		createEReference(kEdgeEClass, KEDGE__TARGET);
		createEReference(kEdgeEClass, KEDGE__EDGE_LAYOUT);
		createEReference(kEdgeEClass, KEDGE__EDGE_LABEL);

		kLayoutGraphEClass = createEClass(KLAYOUT_GRAPH);
		createEReference(kLayoutGraphEClass, KLAYOUT_GRAPH__TOP_GROUP);

		kShapeLayoutEClass = createEClass(KSHAPE_LAYOUT);
		createEReference(kShapeLayoutEClass, KSHAPE_LAYOUT__LOCATION);
		createEReference(kShapeLayoutEClass, KSHAPE_LAYOUT__SIZE);
		createEReference(kShapeLayoutEClass, KSHAPE_LAYOUT__INSETS);

		kEdgeLayoutEClass = createEClass(KEDGE_LAYOUT);
		createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__SOURCE_POINT);
		createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__TARGET_POINT);
		createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__GRID_POINTS);
		createEAttribute(kEdgeLayoutEClass, KEDGE_LAYOUT__EDGE_TYPE);

		kNodeGroupEClass = createEClass(KNODE_GROUP);
		createEReference(kNodeGroupEClass, KNODE_GROUP__SUB_NODE_GROUPS);
		createEReference(kNodeGroupEClass, KNODE_GROUP__OUTGOING_EDGES);
		createEReference(kNodeGroupEClass, KNODE_GROUP__INCOMING_EDGES);
		createEReference(kNodeGroupEClass, KNODE_GROUP__PARENT_GROUP);
		createEReference(kNodeGroupEClass, KNODE_GROUP__NODE_GROUP_LAYOUT);

		kEdgeLabelEClass = createEClass(KEDGE_LABEL);
		createEAttribute(kEdgeLabelEClass, KEDGE_LABEL__TEXT);
		createEReference(kEdgeLabelEClass, KEDGE_LABEL__EDGE_LABEL_LAYOUT);

		kNodeGroupLayoutEClass = createEClass(KNODE_GROUP_LAYOUT);
		createEAttribute(kNodeGroupLayoutEClass, KNODE_GROUP_LAYOUT__LAYOUT_TYPE);
		createEAttribute(kNodeGroupLayoutEClass, KNODE_GROUP_LAYOUT__LAYOUT_OPTIONS);

		kEdgeLabelLayoutEClass = createEClass(KEDGE_LABEL_LAYOUT);
		createEAttribute(kEdgeLabelLayoutEClass, KEDGE_LABEL_LAYOUT__EDGE_LABEL_PLACEMENT);

		// Create enums
		edgE_TYPESEEnum = createEEnum(EDGE_TYPES);
		edgE_LABEL_PLACEMENTEEnum = createEEnum(EDGE_LABEL_PLACEMENT);
		layouT_TYPESEEnum = createEEnum(LAYOUT_TYPES);
		layouT_OPTIONSEEnum = createEEnum(LAYOUT_OPTIONS);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		kNodeGroupLayoutEClass.getESuperTypes().add(this.getkShapeLayout());
		kEdgeLabelLayoutEClass.getESuperTypes().add(this.getkShapeLayout());

		// Initialize classes and features; add operations and parameters
		initEClass(kPointEClass, kPoint.class, "kPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getkPoint_X(), theEcorePackage.getEFloat(), "x", null, 1, 1, kPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getkPoint_Y(), theEcorePackage.getEFloat(), "y", null, 1, 1, kPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kDimensionEClass, kDimension.class, "kDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getkDimension_Height(), theEcorePackage.getEFloat(), "height", null, 1, 1, kDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getkDimension_Width(), theEcorePackage.getEFloat(), "width", null, 1, 1, kDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kInsetsEClass, kInsets.class, "kInsets", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getkInsets_Bottom(), theEcorePackage.getEFloat(), "bottom", null, 1, 1, kInsets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getkInsets_Left(), theEcorePackage.getEFloat(), "left", null, 1, 1, kInsets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getkInsets_Right(), theEcorePackage.getEFloat(), "right", null, 1, 1, kInsets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getkInsets_Top(), theEcorePackage.getEFloat(), "top", null, 1, 1, kInsets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kEdgeEClass, kEdge.class, "kEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getkEdge_Source(), this.getkNodeGroup(), this.getkNodeGroup_OutgoingEdges(), "source", null, 1, 1, kEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkEdge_Target(), this.getkNodeGroup(), this.getkNodeGroup_IncomingEdges(), "target", null, 1, 1, kEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkEdge_EdgeLayout(), this.getkEdgeLayout(), null, "edgeLayout", null, 1, 1, kEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkEdge_EdgeLabel(), this.getkEdgeLabel(), null, "edgeLabel", null, 0, -1, kEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kLayoutGraphEClass, kLayoutGraph.class, "kLayoutGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getkLayoutGraph_TopGroup(), this.getkNodeGroup(), null, "topGroup", null, 1, 1, kLayoutGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kShapeLayoutEClass, kShapeLayout.class, "kShapeLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getkShapeLayout_Location(), this.getkPoint(), null, "location", null, 1, 1, kShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkShapeLayout_Size(), this.getkDimension(), null, "size", null, 1, 1, kShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkShapeLayout_Insets(), this.getkInsets(), null, "insets", null, 0, 1, kShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kEdgeLayoutEClass, kEdgeLayout.class, "kEdgeLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getkEdgeLayout_SourcePoint(), this.getkPoint(), null, "sourcePoint", null, 1, 1, kEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkEdgeLayout_TargetPoint(), this.getkPoint(), null, "targetPoint", null, 1, 1, kEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkEdgeLayout_GridPoints(), this.getkPoint(), null, "gridPoints", null, 0, -1, kEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getkEdgeLayout_EdgeType(), this.getEDGE_TYPES(), "edgeType", null, 0, 1, kEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kNodeGroupEClass, kNodeGroup.class, "kNodeGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getkNodeGroup_SubNodeGroups(), this.getkNodeGroup(), null, "subNodeGroups", null, 0, -1, kNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkNodeGroup_OutgoingEdges(), this.getkEdge(), this.getkEdge_Source(), "outgoingEdges", null, 0, -1, kNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkNodeGroup_IncomingEdges(), this.getkEdge(), this.getkEdge_Target(), "incomingEdges", null, 0, -1, kNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkNodeGroup_ParentGroup(), this.getkNodeGroup(), null, "parentGroup", null, 1, 1, kNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkNodeGroup_NodeGroupLayout(), this.getkNodeGroupLayout(), null, "nodeGroupLayout", null, 1, 1, kNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kEdgeLabelEClass, kEdgeLabel.class, "kEdgeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getkEdgeLabel_Text(), theEcorePackage.getEString(), "text", null, 0, 1, kEdgeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getkEdgeLabel_EdgeLabelLayout(), this.getkEdgeLabelLayout(), null, "edgeLabelLayout", null, 1, 1, kEdgeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kNodeGroupLayoutEClass, kNodeGroupLayout.class, "kNodeGroupLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getkNodeGroupLayout_LayoutType(), this.getLAYOUT_TYPES(), "layoutType", null, 0, 1, kNodeGroupLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getkNodeGroupLayout_LayoutOptions(), theEcorePackage.getEInt(), "layoutOptions", null, 0, 1, kNodeGroupLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kEdgeLabelLayoutEClass, kEdgeLabelLayout.class, "kEdgeLabelLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getkEdgeLabelLayout_EdgeLabelPlacement(), this.getEDGE_LABEL_PLACEMENT(), "edgeLabelPlacement", null, 0, 1, kEdgeLabelLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(edgE_TYPESEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPES.class, "EDGE_TYPES");
		addEEnumLiteral(edgE_TYPESEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPES.NONE);
		addEEnumLiteral(edgE_TYPESEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPES.DIRECT);
		addEEnumLiteral(edgE_TYPESEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPES.SPLINE);
		addEEnumLiteral(edgE_TYPESEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPES.BEZIER);

		initEEnum(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.class, "EDGE_LABEL_PLACEMENT");
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.ANYWHERE);
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.CENTER);
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.HEAD);
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.TAIL);
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.LEFT);
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.RIGHT);

		initEEnum(layouT_TYPESEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPES.class, "LAYOUT_TYPES");
		addEEnumLiteral(layouT_TYPESEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPES.DOT);
		addEEnumLiteral(layouT_TYPESEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPES.CIRCO);

		initEEnum(layouT_OPTIONSEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTIONS.class, "LAYOUT_OPTIONS");
		addEEnumLiteral(layouT_OPTIONSEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTIONS.DEFAULT);
		addEEnumLiteral(layouT_OPTIONSEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTIONS.PRESERVE_MENTAL_MAP);

		// Create resource
		createResource(eNS_URI);
	}

} //KimlLayoutGraphPackageImpl
