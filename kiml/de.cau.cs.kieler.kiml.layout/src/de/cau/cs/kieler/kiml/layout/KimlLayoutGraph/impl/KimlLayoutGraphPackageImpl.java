/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelPlacement;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;

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
	private EClass kLayoutEdgeEClass = null;

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
	private EClass kLayoutNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kNodeLayoutEClass = null;

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
	private EClass kEdgeLabelEClass = null;

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
	private EClass kNodeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kNodeLabelLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kLayouterInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kLayoutPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kPortLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kPortLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kPortLabelLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum kEdgeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum kLayoutTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum kLayoutOptionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum kEdgeLabelPlacementEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum kNodeLabelPlacementEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum kPortTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum kPortPlacementEEnum = null;

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
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#eNS_URI
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
	public EClass getKDimension() {
		return kDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKDimension_Height() {
		return (EAttribute)kDimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKDimension_Width() {
		return (EAttribute)kDimensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKInsets() {
		return kInsetsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKInsets_Bottom() {
		return (EAttribute)kInsetsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKInsets_Left() {
		return (EAttribute)kInsetsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKInsets_Right() {
		return (EAttribute)kInsetsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKInsets_Top() {
		return (EAttribute)kInsetsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKLayoutGraph() {
		return kLayoutGraphEClass;
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
	public EReference getKShapeLayout_Location() {
		return (EReference)kShapeLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKShapeLayout_Size() {
		return (EReference)kShapeLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKShapeLayout_UseLayout() {
		return (EAttribute)kShapeLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKLayoutEdge() {
		return kLayoutEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutEdge_Source() {
		return (EReference)kLayoutEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutEdge_Target() {
		return (EReference)kLayoutEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutEdge_Layout() {
		return (EReference)kLayoutEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutEdge_Label() {
		return (EReference)kLayoutEdgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutEdge_SourcePort() {
		return (EReference)kLayoutEdgeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutEdge_TargetPort() {
		return (EReference)kLayoutEdgeEClass.getEStructuralFeatures().get(5);
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
	public EReference getKEdgeLayout_SourcePoint() {
		return (EReference)kEdgeLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKEdgeLayout_TargetPoint() {
		return (EReference)kEdgeLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKEdgeLayout_BendPoints() {
		return (EReference)kEdgeLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKEdgeLayout_EdgeType() {
		return (EAttribute)kEdgeLayoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKEdgeLayout_UseLayout() {
		return (EAttribute)kEdgeLayoutEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKLayoutNode() {
		return kLayoutNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutNode_ChildNodes() {
		return (EReference)kLayoutNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutNode_OutgoingEdges() {
		return (EReference)kLayoutNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutNode_IncomingEdges() {
		return (EReference)kLayoutNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutNode_ParentNode() {
		return (EReference)kLayoutNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutNode_Layout() {
		return (EReference)kLayoutNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutNode_Label() {
		return (EReference)kLayoutNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKLayoutNode_IdString() {
		return (EAttribute)kLayoutNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutNode_Ports() {
		return (EReference)kLayoutNodeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKNodeLayout() {
		return kNodeLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKNodeLayout_LayoutType() {
		return (EAttribute)kNodeLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKNodeLayout_LayoutOptions() {
		return (EAttribute)kNodeLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKNodeLayout_LayouterName() {
		return (EAttribute)kNodeLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKNodeLayout_Insets() {
		return (EReference)kNodeLayoutEClass.getEStructuralFeatures().get(3);
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
	public EClass getKEdgeLabel() {
		return kEdgeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKEdgeLabel_LabelLayout() {
		return (EReference)kEdgeLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKEdgeLabelLayout() {
		return kEdgeLabelLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKEdgeLabelLayout_LabelPlacement() {
		return (EAttribute)kEdgeLabelLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKNodeLabel() {
		return kNodeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKNodeLabel_LabelLayout() {
		return (EReference)kNodeLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKNodeLabelLayout() {
		return kNodeLabelLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKNodeLabelLayout_LabelPlacement() {
		return (EAttribute)kNodeLabelLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKLayouterInfo() {
		return kLayouterInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKLayouterInfo_LayouterName() {
		return (EAttribute)kLayouterInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKLayouterInfo_LayoutType() {
		return (EAttribute)kLayouterInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKLayouterInfo_LayoutOption() {
		return (EAttribute)kLayouterInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKLayouterInfo_LayouterCollectionID() {
		return (EAttribute)kLayouterInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKLayoutPort() {
		return kLayoutPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutPort_Layout() {
		return (EReference)kLayoutPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutPort_Label() {
		return (EReference)kLayoutPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutPort_Node() {
		return (EReference)kLayoutPortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKLayoutPort_Type() {
		return (EAttribute)kLayoutPortEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKLayoutPort_Edges() {
		return (EReference)kLayoutPortEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKPortLayout() {
		return kPortLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKPortLayout_Placement() {
		return (EAttribute)kPortLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKPortLabel() {
		return kPortLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKPortLabel_LabelLayout() {
		return (EReference)kPortLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKPortLabelLayout() {
		return kPortLabelLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getKEdgeType() {
		return kEdgeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getKLayoutType() {
		return kLayoutTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getKLayoutOption() {
		return kLayoutOptionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getKEdgeLabelPlacement() {
		return kEdgeLabelPlacementEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getKNodeLabelPlacement() {
		return kNodeLabelPlacementEEnum;
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
	public EEnum getKPortPlacement() {
		return kPortPlacementEEnum;
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

		kLayoutGraphEClass = createEClass(KLAYOUT_GRAPH);

		kShapeLayoutEClass = createEClass(KSHAPE_LAYOUT);
		createEReference(kShapeLayoutEClass, KSHAPE_LAYOUT__LOCATION);
		createEReference(kShapeLayoutEClass, KSHAPE_LAYOUT__SIZE);
		createEAttribute(kShapeLayoutEClass, KSHAPE_LAYOUT__USE_LAYOUT);

		kLayoutEdgeEClass = createEClass(KLAYOUT_EDGE);
		createEReference(kLayoutEdgeEClass, KLAYOUT_EDGE__SOURCE);
		createEReference(kLayoutEdgeEClass, KLAYOUT_EDGE__TARGET);
		createEReference(kLayoutEdgeEClass, KLAYOUT_EDGE__LAYOUT);
		createEReference(kLayoutEdgeEClass, KLAYOUT_EDGE__LABEL);
		createEReference(kLayoutEdgeEClass, KLAYOUT_EDGE__SOURCE_PORT);
		createEReference(kLayoutEdgeEClass, KLAYOUT_EDGE__TARGET_PORT);

		kEdgeLayoutEClass = createEClass(KEDGE_LAYOUT);
		createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__SOURCE_POINT);
		createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__TARGET_POINT);
		createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__BEND_POINTS);
		createEAttribute(kEdgeLayoutEClass, KEDGE_LAYOUT__EDGE_TYPE);
		createEAttribute(kEdgeLayoutEClass, KEDGE_LAYOUT__USE_LAYOUT);

		kLayoutNodeEClass = createEClass(KLAYOUT_NODE);
		createEReference(kLayoutNodeEClass, KLAYOUT_NODE__CHILD_NODES);
		createEReference(kLayoutNodeEClass, KLAYOUT_NODE__OUTGOING_EDGES);
		createEReference(kLayoutNodeEClass, KLAYOUT_NODE__INCOMING_EDGES);
		createEReference(kLayoutNodeEClass, KLAYOUT_NODE__PARENT_NODE);
		createEReference(kLayoutNodeEClass, KLAYOUT_NODE__LAYOUT);
		createEReference(kLayoutNodeEClass, KLAYOUT_NODE__LABEL);
		createEAttribute(kLayoutNodeEClass, KLAYOUT_NODE__ID_STRING);
		createEReference(kLayoutNodeEClass, KLAYOUT_NODE__PORTS);

		kNodeLayoutEClass = createEClass(KNODE_LAYOUT);
		createEAttribute(kNodeLayoutEClass, KNODE_LAYOUT__LAYOUT_TYPE);
		createEAttribute(kNodeLayoutEClass, KNODE_LAYOUT__LAYOUT_OPTIONS);
		createEAttribute(kNodeLayoutEClass, KNODE_LAYOUT__LAYOUTER_NAME);
		createEReference(kNodeLayoutEClass, KNODE_LAYOUT__INSETS);

		kLabelEClass = createEClass(KLABEL);
		createEAttribute(kLabelEClass, KLABEL__TEXT);

		kEdgeLabelEClass = createEClass(KEDGE_LABEL);
		createEReference(kEdgeLabelEClass, KEDGE_LABEL__LABEL_LAYOUT);

		kEdgeLabelLayoutEClass = createEClass(KEDGE_LABEL_LAYOUT);
		createEAttribute(kEdgeLabelLayoutEClass, KEDGE_LABEL_LAYOUT__LABEL_PLACEMENT);

		kNodeLabelEClass = createEClass(KNODE_LABEL);
		createEReference(kNodeLabelEClass, KNODE_LABEL__LABEL_LAYOUT);

		kNodeLabelLayoutEClass = createEClass(KNODE_LABEL_LAYOUT);
		createEAttribute(kNodeLabelLayoutEClass, KNODE_LABEL_LAYOUT__LABEL_PLACEMENT);

		kLayouterInfoEClass = createEClass(KLAYOUTER_INFO);
		createEAttribute(kLayouterInfoEClass, KLAYOUTER_INFO__LAYOUTER_NAME);
		createEAttribute(kLayouterInfoEClass, KLAYOUTER_INFO__LAYOUT_TYPE);
		createEAttribute(kLayouterInfoEClass, KLAYOUTER_INFO__LAYOUT_OPTION);
		createEAttribute(kLayouterInfoEClass, KLAYOUTER_INFO__LAYOUTER_COLLECTION_ID);

		kLayoutPortEClass = createEClass(KLAYOUT_PORT);
		createEReference(kLayoutPortEClass, KLAYOUT_PORT__LAYOUT);
		createEReference(kLayoutPortEClass, KLAYOUT_PORT__LABEL);
		createEReference(kLayoutPortEClass, KLAYOUT_PORT__NODE);
		createEAttribute(kLayoutPortEClass, KLAYOUT_PORT__TYPE);
		createEReference(kLayoutPortEClass, KLAYOUT_PORT__EDGES);

		kPortLayoutEClass = createEClass(KPORT_LAYOUT);
		createEAttribute(kPortLayoutEClass, KPORT_LAYOUT__PLACEMENT);

		kPortLabelEClass = createEClass(KPORT_LABEL);
		createEReference(kPortLabelEClass, KPORT_LABEL__LABEL_LAYOUT);

		kPortLabelLayoutEClass = createEClass(KPORT_LABEL_LAYOUT);

		// Create enums
		kEdgeTypeEEnum = createEEnum(KEDGE_TYPE);
		kLayoutTypeEEnum = createEEnum(KLAYOUT_TYPE);
		kLayoutOptionEEnum = createEEnum(KLAYOUT_OPTION);
		kEdgeLabelPlacementEEnum = createEEnum(KEDGE_LABEL_PLACEMENT);
		kNodeLabelPlacementEEnum = createEEnum(KNODE_LABEL_PLACEMENT);
		kPortTypeEEnum = createEEnum(KPORT_TYPE);
		kPortPlacementEEnum = createEEnum(KPORT_PLACEMENT);
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
		kLayoutGraphEClass.getESuperTypes().add(this.getKLayoutNode());
		kNodeLayoutEClass.getESuperTypes().add(this.getKShapeLayout());
		kEdgeLabelEClass.getESuperTypes().add(this.getKLabel());
		kEdgeLabelLayoutEClass.getESuperTypes().add(this.getKShapeLayout());
		kNodeLabelEClass.getESuperTypes().add(this.getKLabel());
		kNodeLabelLayoutEClass.getESuperTypes().add(this.getKShapeLayout());
		kPortLayoutEClass.getESuperTypes().add(this.getKShapeLayout());
		kPortLabelEClass.getESuperTypes().add(this.getKLabel());
		kPortLabelLayoutEClass.getESuperTypes().add(this.getKShapeLayout());

		// Initialize classes and features; add operations and parameters
		initEClass(kPointEClass, KPoint.class, "KPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKPoint_X(), theEcorePackage.getEFloat(), "x", null, 1, 1, KPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKPoint_Y(), theEcorePackage.getEFloat(), "y", null, 1, 1, KPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kDimensionEClass, KDimension.class, "KDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKDimension_Height(), theEcorePackage.getEFloat(), "height", null, 1, 1, KDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKDimension_Width(), theEcorePackage.getEFloat(), "width", null, 1, 1, KDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kInsetsEClass, KInsets.class, "KInsets", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKInsets_Bottom(), theEcorePackage.getEFloat(), "bottom", null, 1, 1, KInsets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKInsets_Left(), theEcorePackage.getEFloat(), "left", null, 1, 1, KInsets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKInsets_Right(), theEcorePackage.getEFloat(), "right", null, 1, 1, KInsets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKInsets_Top(), theEcorePackage.getEFloat(), "top", null, 1, 1, KInsets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kLayoutGraphEClass, KLayoutGraph.class, "KLayoutGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(kShapeLayoutEClass, KShapeLayout.class, "KShapeLayout", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKShapeLayout_Location(), this.getKPoint(), null, "location", null, 1, 1, KShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKShapeLayout_Size(), this.getKDimension(), null, "size", null, 1, 1, KShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKShapeLayout_UseLayout(), theEcorePackage.getEBoolean(), "useLayout", "true", 1, 1, KShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kLayoutEdgeEClass, KLayoutEdge.class, "KLayoutEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKLayoutEdge_Source(), this.getKLayoutNode(), this.getKLayoutNode_OutgoingEdges(), "source", null, 1, 1, KLayoutEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutEdge_Target(), this.getKLayoutNode(), this.getKLayoutNode_IncomingEdges(), "target", null, 1, 1, KLayoutEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutEdge_Layout(), this.getKEdgeLayout(), null, "layout", null, 1, 1, KLayoutEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutEdge_Label(), this.getKEdgeLabel(), null, "label", null, 0, -1, KLayoutEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutEdge_SourcePort(), this.getKLayoutPort(), null, "sourcePort", null, 0, 1, KLayoutEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutEdge_TargetPort(), this.getKLayoutPort(), null, "targetPort", null, 0, 1, KLayoutEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kEdgeLayoutEClass, KEdgeLayout.class, "KEdgeLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKEdgeLayout_SourcePoint(), this.getKPoint(), null, "sourcePoint", null, 1, 1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKEdgeLayout_TargetPoint(), this.getKPoint(), null, "targetPoint", null, 1, 1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKEdgeLayout_BendPoints(), this.getKPoint(), null, "bendPoints", null, 0, -1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKEdgeLayout_EdgeType(), this.getKEdgeType(), "edgeType", null, 1, 1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKEdgeLayout_UseLayout(), theEcorePackage.getEBoolean(), "useLayout", "true", 1, 1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kLayoutNodeEClass, KLayoutNode.class, "KLayoutNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKLayoutNode_ChildNodes(), this.getKLayoutNode(), this.getKLayoutNode_ParentNode(), "childNodes", null, 0, -1, KLayoutNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutNode_OutgoingEdges(), this.getKLayoutEdge(), this.getKLayoutEdge_Source(), "outgoingEdges", null, 0, -1, KLayoutNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutNode_IncomingEdges(), this.getKLayoutEdge(), this.getKLayoutEdge_Target(), "incomingEdges", null, 0, -1, KLayoutNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutNode_ParentNode(), this.getKLayoutNode(), this.getKLayoutNode_ChildNodes(), "parentNode", null, 1, 1, KLayoutNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutNode_Layout(), this.getKNodeLayout(), null, "layout", null, 1, 1, KLayoutNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutNode_Label(), this.getKNodeLabel(), null, "label", null, 1, 1, KLayoutNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKLayoutNode_IdString(), theEcorePackage.getEString(), "idString", "\"\"", 1, 1, KLayoutNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutNode_Ports(), this.getKLayoutPort(), this.getKLayoutPort_Node(), "ports", null, 0, -1, KLayoutNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kNodeLayoutEClass, KNodeLayout.class, "KNodeLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKNodeLayout_LayoutType(), this.getKLayoutType(), "layoutType", "", 1, 1, KNodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKNodeLayout_LayoutOptions(), this.getKLayoutOption(), "layoutOptions", "", 0, -1, KNodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getKNodeLayout_LayouterName(), theEcorePackage.getEString(), "layouterName", "\"\"", 1, 1, KNodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKNodeLayout_Insets(), this.getKInsets(), null, "insets", null, 1, 1, KNodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kLabelEClass, KLabel.class, "KLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKLabel_Text(), theEcorePackage.getEString(), "text", null, 1, 1, KLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kEdgeLabelEClass, KEdgeLabel.class, "KEdgeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKEdgeLabel_LabelLayout(), this.getKEdgeLabelLayout(), null, "labelLayout", null, 1, 1, KEdgeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kEdgeLabelLayoutEClass, KEdgeLabelLayout.class, "KEdgeLabelLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKEdgeLabelLayout_LabelPlacement(), this.getKEdgeLabelPlacement(), "labelPlacement", null, 1, 1, KEdgeLabelLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kNodeLabelEClass, KNodeLabel.class, "KNodeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKNodeLabel_LabelLayout(), this.getKNodeLabelLayout(), null, "labelLayout", null, 1, 1, KNodeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kNodeLabelLayoutEClass, KNodeLabelLayout.class, "KNodeLabelLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKNodeLabelLayout_LabelPlacement(), this.getKNodeLabelPlacement(), "labelPlacement", null, 1, 1, KNodeLabelLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kLayouterInfoEClass, KLayouterInfo.class, "KLayouterInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKLayouterInfo_LayouterName(), theEcorePackage.getEString(), "layouterName", null, 1, 1, KLayouterInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKLayouterInfo_LayoutType(), this.getKLayoutType(), "layoutType", null, 1, 1, KLayouterInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKLayouterInfo_LayoutOption(), this.getKLayoutOption(), "layoutOption", null, 1, 1, KLayouterInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKLayouterInfo_LayouterCollectionID(), theEcorePackage.getEString(), "layouterCollectionID", null, 1, 1, KLayouterInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kLayoutPortEClass, KLayoutPort.class, "KLayoutPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKLayoutPort_Layout(), this.getKPortLayout(), null, "layout", null, 1, 1, KLayoutPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutPort_Label(), this.getKPortLabel(), null, "label", null, 0, 1, KLayoutPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutPort_Node(), this.getKLayoutNode(), this.getKLayoutNode_Ports(), "node", null, 1, 1, KLayoutPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKLayoutPort_Type(), this.getKPortType(), "type", "0", 1, 1, KLayoutPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKLayoutPort_Edges(), this.getKLayoutEdge(), null, "edges", null, 0, -1, KLayoutPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kPortLayoutEClass, KPortLayout.class, "KPortLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKPortLayout_Placement(), this.getKPortPlacement(), "placement", "0", 0, 1, KPortLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kPortLabelEClass, KPortLabel.class, "KPortLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKPortLabel_LabelLayout(), this.getKPortLabelLayout(), null, "labelLayout", null, 0, 1, KPortLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kPortLabelLayoutEClass, KPortLabelLayout.class, "KPortLabelLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(kEdgeTypeEEnum, KEdgeType.class, "KEdgeType");
		addEEnumLiteral(kEdgeTypeEEnum, KEdgeType.DEFAULT);
		addEEnumLiteral(kEdgeTypeEEnum, KEdgeType.DIRECT);
		addEEnumLiteral(kEdgeTypeEEnum, KEdgeType.SPLINE);
		addEEnumLiteral(kEdgeTypeEEnum, KEdgeType.BEZIER);
		addEEnumLiteral(kEdgeTypeEEnum, KEdgeType.RECTILINEAR);

		initEEnum(kLayoutTypeEEnum, KLayoutType.class, "KLayoutType");
		addEEnumLiteral(kLayoutTypeEEnum, KLayoutType.DEFAULT);
		addEEnumLiteral(kLayoutTypeEEnum, KLayoutType.ORTHOGONAL);
		addEEnumLiteral(kLayoutTypeEEnum, KLayoutType.HIERARCHICAL);
		addEEnumLiteral(kLayoutTypeEEnum, KLayoutType.CIRCLE);
		addEEnumLiteral(kLayoutTypeEEnum, KLayoutType.RADIAL);
		addEEnumLiteral(kLayoutTypeEEnum, KLayoutType.SPRING_MODEL);
		addEEnumLiteral(kLayoutTypeEEnum, KLayoutType.OTHER);

		initEEnum(kLayoutOptionEEnum, KLayoutOption.class, "KLayoutOption");
		addEEnumLiteral(kLayoutOptionEEnum, KLayoutOption.DEFAULT);
		addEEnumLiteral(kLayoutOptionEEnum, KLayoutOption.PRESERVE_MENTAL_MAP);
		addEEnumLiteral(kLayoutOptionEEnum, KLayoutOption.VERTICAL);
		addEEnumLiteral(kLayoutOptionEEnum, KLayoutOption.HORIZONTAL);
		addEEnumLiteral(kLayoutOptionEEnum, KLayoutOption.FIXED_PORTS);
		addEEnumLiteral(kLayoutOptionEEnum, KLayoutOption.FIXED_SIZE);

		initEEnum(kEdgeLabelPlacementEEnum, KEdgeLabelPlacement.class, "KEdgeLabelPlacement");
		addEEnumLiteral(kEdgeLabelPlacementEEnum, KEdgeLabelPlacement.DEFAULT);
		addEEnumLiteral(kEdgeLabelPlacementEEnum, KEdgeLabelPlacement.CENTER);
		addEEnumLiteral(kEdgeLabelPlacementEEnum, KEdgeLabelPlacement.HEAD);
		addEEnumLiteral(kEdgeLabelPlacementEEnum, KEdgeLabelPlacement.TAIL);
		addEEnumLiteral(kEdgeLabelPlacementEEnum, KEdgeLabelPlacement.LEFT);
		addEEnumLiteral(kEdgeLabelPlacementEEnum, KEdgeLabelPlacement.RIGHT);

		initEEnum(kNodeLabelPlacementEEnum, KNodeLabelPlacement.class, "KNodeLabelPlacement");
		addEEnumLiteral(kNodeLabelPlacementEEnum, KNodeLabelPlacement.DEFAULT);
		addEEnumLiteral(kNodeLabelPlacementEEnum, KNodeLabelPlacement.INSIDE_NORTH);
		addEEnumLiteral(kNodeLabelPlacementEEnum, KNodeLabelPlacement.INSIDE_SOUTH);
		addEEnumLiteral(kNodeLabelPlacementEEnum, KNodeLabelPlacement.INSIDE_WEST);
		addEEnumLiteral(kNodeLabelPlacementEEnum, KNodeLabelPlacement.INSIDE_EAST);
		addEEnumLiteral(kNodeLabelPlacementEEnum, KNodeLabelPlacement.OUTSIDE_NORTH);
		addEEnumLiteral(kNodeLabelPlacementEEnum, KNodeLabelPlacement.OUTSIDE_SOUTH);
		addEEnumLiteral(kNodeLabelPlacementEEnum, KNodeLabelPlacement.OUTSIDE_WEST);
		addEEnumLiteral(kNodeLabelPlacementEEnum, KNodeLabelPlacement.OUTSIDE_EAST);

		initEEnum(kPortTypeEEnum, KPortType.class, "KPortType");
		addEEnumLiteral(kPortTypeEEnum, KPortType.DEFAULT);
		addEEnumLiteral(kPortTypeEEnum, KPortType.INPUT);
		addEEnumLiteral(kPortTypeEEnum, KPortType.OUTPUT);

		initEEnum(kPortPlacementEEnum, KPortPlacement.class, "KPortPlacement");
		addEEnumLiteral(kPortPlacementEEnum, KPortPlacement.DEFAULT);
		addEEnumLiteral(kPortPlacementEEnum, KPortPlacement.NORTH);
		addEEnumLiteral(kPortPlacementEEnum, KPortPlacement.EAST);
		addEEnumLiteral(kPortPlacementEEnum, KPortPlacement.SOUTH);
		addEEnumLiteral(kPortPlacementEEnum, KPortPlacement.WEST);

		// Create resource
		createResource(eNS_URI);
	}

} //KimlLayoutGraphPackageImpl
