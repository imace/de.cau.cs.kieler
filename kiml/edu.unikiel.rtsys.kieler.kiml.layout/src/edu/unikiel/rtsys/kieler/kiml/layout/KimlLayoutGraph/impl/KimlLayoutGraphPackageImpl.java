/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabelLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLabelLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;

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
	private EClass kEdgeEClass = null;

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
	private EClass kNodeGroupLayoutEClass = null;

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
	private EClass kNodeGroupLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kNodeGroupLabelLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layouteR_INFOEClass = null;

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
	private EEnum edgE_TYPEEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum layouT_TYPEEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum layouT_OPTIONEEnum = null;

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
	private EEnum nodE_LABEL_PLACEMENTEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum porT_TYPEEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum porT_PLACEMENTEEnum = null;

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
	public EReference getKLayoutGraph_TopGroup() {
		return (EReference)kLayoutGraphEClass.getEStructuralFeatures().get(0);
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
	public EReference getKEdge_Layout() {
		return (EReference)kEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKEdge_Label() {
		return (EReference)kEdgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKEdge_SourcePort() {
		return (EReference)kEdgeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKEdge_TargetPort() {
		return (EReference)kEdgeEClass.getEStructuralFeatures().get(5);
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
	public EReference getKEdgeLayout_GridPoints() {
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
	public EClass getKNodeGroup() {
		return kNodeGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKNodeGroup_SubNodeGroups() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKNodeGroup_OutgoingEdges() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKNodeGroup_IncomingEdges() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKNodeGroup_ParentGroup() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKNodeGroup_Layout() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKNodeGroup_Label() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKNodeGroup_IdString() {
		return (EAttribute)kNodeGroupEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKNodeGroup_Ports() {
		return (EReference)kNodeGroupEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKNodeGroupLayout() {
		return kNodeGroupLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKNodeGroupLayout_LayoutType() {
		return (EAttribute)kNodeGroupLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKNodeGroupLayout_LayoutOptions() {
		return (EAttribute)kNodeGroupLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKNodeGroupLayout_LayouterName() {
		return (EAttribute)kNodeGroupLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKNodeGroupLayout_Insets() {
		return (EReference)kNodeGroupLayoutEClass.getEStructuralFeatures().get(3);
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
	public EClass getKNodeGroupLabel() {
		return kNodeGroupLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKNodeGroupLabel_LabelLayout() {
		return (EReference)kNodeGroupLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKNodeGroupLabelLayout() {
		return kNodeGroupLabelLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKNodeGroupLabelLayout_LabelPlacement() {
		return (EAttribute)kNodeGroupLabelLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLAYOUTER_INFO() {
		return layouteR_INFOEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAYOUTER_INFO_LayouterName() {
		return (EAttribute)layouteR_INFOEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAYOUTER_INFO_LayoutType() {
		return (EAttribute)layouteR_INFOEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAYOUTER_INFO_LayoutOption() {
		return (EAttribute)layouteR_INFOEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAYOUTER_INFO_LayouterCollectionID() {
		return (EAttribute)layouteR_INFOEClass.getEStructuralFeatures().get(3);
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
	public EReference getKPort_Layout() {
		return (EReference)kPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKPort_Label() {
		return (EReference)kPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKPort_NodeGroup() {
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
	public EReference getKPort_Edges() {
		return (EReference)kPortEClass.getEStructuralFeatures().get(4);
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
	public EEnum getEDGE_TYPE() {
		return edgE_TYPEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLAYOUT_TYPE() {
		return layouT_TYPEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLAYOUT_OPTION() {
		return layouT_OPTIONEEnum;
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
	public EEnum getNODE_LABEL_PLACEMENT() {
		return nodE_LABEL_PLACEMENTEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPORT_TYPE() {
		return porT_TYPEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPORT_PLACEMENT() {
		return porT_PLACEMENTEEnum;
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
		createEReference(kLayoutGraphEClass, KLAYOUT_GRAPH__TOP_GROUP);

		kShapeLayoutEClass = createEClass(KSHAPE_LAYOUT);
		createEReference(kShapeLayoutEClass, KSHAPE_LAYOUT__LOCATION);
		createEReference(kShapeLayoutEClass, KSHAPE_LAYOUT__SIZE);
		createEAttribute(kShapeLayoutEClass, KSHAPE_LAYOUT__USE_LAYOUT);

		kEdgeEClass = createEClass(KEDGE);
		createEReference(kEdgeEClass, KEDGE__SOURCE);
		createEReference(kEdgeEClass, KEDGE__TARGET);
		createEReference(kEdgeEClass, KEDGE__LAYOUT);
		createEReference(kEdgeEClass, KEDGE__LABEL);
		createEReference(kEdgeEClass, KEDGE__SOURCE_PORT);
		createEReference(kEdgeEClass, KEDGE__TARGET_PORT);

		kEdgeLayoutEClass = createEClass(KEDGE_LAYOUT);
		createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__SOURCE_POINT);
		createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__TARGET_POINT);
		createEReference(kEdgeLayoutEClass, KEDGE_LAYOUT__GRID_POINTS);
		createEAttribute(kEdgeLayoutEClass, KEDGE_LAYOUT__EDGE_TYPE);
		createEAttribute(kEdgeLayoutEClass, KEDGE_LAYOUT__USE_LAYOUT);

		kNodeGroupEClass = createEClass(KNODE_GROUP);
		createEReference(kNodeGroupEClass, KNODE_GROUP__SUB_NODE_GROUPS);
		createEReference(kNodeGroupEClass, KNODE_GROUP__OUTGOING_EDGES);
		createEReference(kNodeGroupEClass, KNODE_GROUP__INCOMING_EDGES);
		createEReference(kNodeGroupEClass, KNODE_GROUP__PARENT_GROUP);
		createEReference(kNodeGroupEClass, KNODE_GROUP__LAYOUT);
		createEReference(kNodeGroupEClass, KNODE_GROUP__LABEL);
		createEAttribute(kNodeGroupEClass, KNODE_GROUP__ID_STRING);
		createEReference(kNodeGroupEClass, KNODE_GROUP__PORTS);

		kNodeGroupLayoutEClass = createEClass(KNODE_GROUP_LAYOUT);
		createEAttribute(kNodeGroupLayoutEClass, KNODE_GROUP_LAYOUT__LAYOUT_TYPE);
		createEAttribute(kNodeGroupLayoutEClass, KNODE_GROUP_LAYOUT__LAYOUT_OPTIONS);
		createEAttribute(kNodeGroupLayoutEClass, KNODE_GROUP_LAYOUT__LAYOUTER_NAME);
		createEReference(kNodeGroupLayoutEClass, KNODE_GROUP_LAYOUT__INSETS);

		kLabelEClass = createEClass(KLABEL);
		createEAttribute(kLabelEClass, KLABEL__TEXT);

		kEdgeLabelEClass = createEClass(KEDGE_LABEL);
		createEReference(kEdgeLabelEClass, KEDGE_LABEL__LABEL_LAYOUT);

		kEdgeLabelLayoutEClass = createEClass(KEDGE_LABEL_LAYOUT);
		createEAttribute(kEdgeLabelLayoutEClass, KEDGE_LABEL_LAYOUT__LABEL_PLACEMENT);

		kNodeGroupLabelEClass = createEClass(KNODE_GROUP_LABEL);
		createEReference(kNodeGroupLabelEClass, KNODE_GROUP_LABEL__LABEL_LAYOUT);

		kNodeGroupLabelLayoutEClass = createEClass(KNODE_GROUP_LABEL_LAYOUT);
		createEAttribute(kNodeGroupLabelLayoutEClass, KNODE_GROUP_LABEL_LAYOUT__LABEL_PLACEMENT);

		layouteR_INFOEClass = createEClass(LAYOUTER_INFO);
		createEAttribute(layouteR_INFOEClass, LAYOUTER_INFO__LAYOUTER_NAME);
		createEAttribute(layouteR_INFOEClass, LAYOUTER_INFO__LAYOUT_TYPE);
		createEAttribute(layouteR_INFOEClass, LAYOUTER_INFO__LAYOUT_OPTION);
		createEAttribute(layouteR_INFOEClass, LAYOUTER_INFO__LAYOUTER_COLLECTION_ID);

		kPortEClass = createEClass(KPORT);
		createEReference(kPortEClass, KPORT__LAYOUT);
		createEReference(kPortEClass, KPORT__LABEL);
		createEReference(kPortEClass, KPORT__NODE_GROUP);
		createEAttribute(kPortEClass, KPORT__TYPE);
		createEReference(kPortEClass, KPORT__EDGES);

		kPortLayoutEClass = createEClass(KPORT_LAYOUT);
		createEAttribute(kPortLayoutEClass, KPORT_LAYOUT__PLACEMENT);

		kPortLabelEClass = createEClass(KPORT_LABEL);
		createEReference(kPortLabelEClass, KPORT_LABEL__LABEL_LAYOUT);

		kPortLabelLayoutEClass = createEClass(KPORT_LABEL_LAYOUT);

		// Create enums
		edgE_TYPEEEnum = createEEnum(EDGE_TYPE);
		layouT_TYPEEEnum = createEEnum(LAYOUT_TYPE);
		layouT_OPTIONEEnum = createEEnum(LAYOUT_OPTION);
		edgE_LABEL_PLACEMENTEEnum = createEEnum(EDGE_LABEL_PLACEMENT);
		nodE_LABEL_PLACEMENTEEnum = createEEnum(NODE_LABEL_PLACEMENT);
		porT_TYPEEEnum = createEEnum(PORT_TYPE);
		porT_PLACEMENTEEnum = createEEnum(PORT_PLACEMENT);
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
		kNodeGroupLayoutEClass.getESuperTypes().add(this.getKShapeLayout());
		kEdgeLabelEClass.getESuperTypes().add(this.getKLabel());
		kEdgeLabelLayoutEClass.getESuperTypes().add(this.getKShapeLayout());
		kNodeGroupLabelEClass.getESuperTypes().add(this.getKLabel());
		kNodeGroupLabelLayoutEClass.getESuperTypes().add(this.getKShapeLayout());
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
		initEReference(getKLayoutGraph_TopGroup(), this.getKNodeGroup(), null, "topGroup", null, 1, 1, KLayoutGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kShapeLayoutEClass, KShapeLayout.class, "KShapeLayout", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKShapeLayout_Location(), this.getKPoint(), null, "location", null, 1, 1, KShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKShapeLayout_Size(), this.getKDimension(), null, "size", null, 1, 1, KShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKShapeLayout_UseLayout(), theEcorePackage.getEBoolean(), "useLayout", "true", 1, 1, KShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kEdgeEClass, KEdge.class, "KEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKEdge_Source(), this.getKNodeGroup(), this.getKNodeGroup_OutgoingEdges(), "source", null, 1, 1, KEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKEdge_Target(), this.getKNodeGroup(), this.getKNodeGroup_IncomingEdges(), "target", null, 1, 1, KEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKEdge_Layout(), this.getKEdgeLayout(), null, "layout", null, 1, 1, KEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKEdge_Label(), this.getKEdgeLabel(), null, "label", null, 0, -1, KEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKEdge_SourcePort(), this.getKPort(), null, "sourcePort", null, 0, 1, KEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKEdge_TargetPort(), this.getKPort(), null, "targetPort", null, 0, 1, KEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kEdgeLayoutEClass, KEdgeLayout.class, "KEdgeLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKEdgeLayout_SourcePoint(), this.getKPoint(), null, "sourcePoint", null, 1, 1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKEdgeLayout_TargetPoint(), this.getKPoint(), null, "targetPoint", null, 1, 1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKEdgeLayout_GridPoints(), this.getKPoint(), null, "gridPoints", null, 0, -1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKEdgeLayout_EdgeType(), this.getEDGE_TYPE(), "edgeType", null, 1, 1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKEdgeLayout_UseLayout(), theEcorePackage.getEBoolean(), "useLayout", "true", 1, 1, KEdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kNodeGroupEClass, KNodeGroup.class, "KNodeGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKNodeGroup_SubNodeGroups(), this.getKNodeGroup(), this.getKNodeGroup_ParentGroup(), "subNodeGroups", null, 0, -1, KNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKNodeGroup_OutgoingEdges(), this.getKEdge(), this.getKEdge_Source(), "outgoingEdges", null, 0, -1, KNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKNodeGroup_IncomingEdges(), this.getKEdge(), this.getKEdge_Target(), "incomingEdges", null, 0, -1, KNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKNodeGroup_ParentGroup(), this.getKNodeGroup(), this.getKNodeGroup_SubNodeGroups(), "parentGroup", null, 1, 1, KNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKNodeGroup_Layout(), this.getKNodeGroupLayout(), null, "layout", null, 1, 1, KNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKNodeGroup_Label(), this.getKNodeGroupLabel(), null, "label", null, 1, 1, KNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKNodeGroup_IdString(), theEcorePackage.getEString(), "idString", "\"\"", 1, 1, KNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKNodeGroup_Ports(), this.getKPort(), this.getKPort_NodeGroup(), "ports", null, 0, -1, KNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kNodeGroupLayoutEClass, KNodeGroupLayout.class, "KNodeGroupLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKNodeGroupLayout_LayoutType(), this.getLAYOUT_TYPE(), "layoutType", "", 1, 1, KNodeGroupLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKNodeGroupLayout_LayoutOptions(), this.getLAYOUT_OPTION(), "layoutOptions", "", 0, -1, KNodeGroupLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getKNodeGroupLayout_LayouterName(), theEcorePackage.getEString(), "layouterName", "\"\"", 1, 1, KNodeGroupLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKNodeGroupLayout_Insets(), this.getKInsets(), null, "insets", null, 1, 1, KNodeGroupLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kLabelEClass, KLabel.class, "KLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKLabel_Text(), theEcorePackage.getEString(), "text", null, 1, 1, KLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kEdgeLabelEClass, KEdgeLabel.class, "KEdgeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKEdgeLabel_LabelLayout(), this.getKEdgeLabelLayout(), null, "labelLayout", null, 1, 1, KEdgeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kEdgeLabelLayoutEClass, KEdgeLabelLayout.class, "KEdgeLabelLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKEdgeLabelLayout_LabelPlacement(), this.getEDGE_LABEL_PLACEMENT(), "labelPlacement", null, 1, 1, KEdgeLabelLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kNodeGroupLabelEClass, KNodeGroupLabel.class, "KNodeGroupLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKNodeGroupLabel_LabelLayout(), this.getKNodeGroupLabelLayout(), null, "labelLayout", null, 1, 1, KNodeGroupLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kNodeGroupLabelLayoutEClass, KNodeGroupLabelLayout.class, "KNodeGroupLabelLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKNodeGroupLabelLayout_LabelPlacement(), this.getNODE_LABEL_PLACEMENT(), "labelPlacement", null, 1, 1, KNodeGroupLabelLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(layouteR_INFOEClass, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO.class, "LAYOUTER_INFO", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLAYOUTER_INFO_LayouterName(), theEcorePackage.getEString(), "layouterName", null, 1, 1, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLAYOUTER_INFO_LayoutType(), this.getLAYOUT_TYPE(), "layoutType", null, 1, 1, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLAYOUTER_INFO_LayoutOption(), this.getLAYOUT_OPTION(), "layoutOption", null, 1, 1, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLAYOUTER_INFO_LayouterCollectionID(), theEcorePackage.getEString(), "layouterCollectionID", null, 1, 1, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kPortEClass, KPort.class, "KPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKPort_Layout(), this.getKPortLayout(), null, "layout", null, 1, 1, KPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKPort_Label(), this.getKPortLabel(), null, "label", null, 0, 1, KPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKPort_NodeGroup(), this.getKNodeGroup(), this.getKNodeGroup_Ports(), "nodeGroup", null, 1, 1, KPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKPort_Type(), this.getPORT_TYPE(), "type", "0", 1, 1, KPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKPort_Edges(), this.getKEdge(), null, "edges", null, 0, -1, KPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kPortLayoutEClass, KPortLayout.class, "KPortLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKPortLayout_Placement(), this.getPORT_PLACEMENT(), "placement", "0", 0, 1, KPortLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kPortLabelEClass, KPortLabel.class, "KPortLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKPortLabel_LabelLayout(), this.getKPortLabelLayout(), null, "labelLayout", null, 0, 1, KPortLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kPortLabelLayoutEClass, KPortLabelLayout.class, "KPortLabelLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(edgE_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE.class, "EDGE_TYPE");
		addEEnumLiteral(edgE_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE.DEFAULT);
		addEEnumLiteral(edgE_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE.DIRECT);
		addEEnumLiteral(edgE_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE.SPLINE);
		addEEnumLiteral(edgE_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE.BEZIER);

		initEEnum(layouT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE.class, "LAYOUT_TYPE");
		addEEnumLiteral(layouT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE.DEFAULT);
		addEEnumLiteral(layouT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE.PATTERN_RECOGNITION);
		addEEnumLiteral(layouT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE.HIERARCHICAL);
		addEEnumLiteral(layouT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE.CIRCLE);
		addEEnumLiteral(layouT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE.RADIAL);
		addEEnumLiteral(layouT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE.SPRING_MODEL);
		addEEnumLiteral(layouT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE.OTHER);

		initEEnum(layouT_OPTIONEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION.class, "LAYOUT_OPTION");
		addEEnumLiteral(layouT_OPTIONEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION.DEFAULT);
		addEEnumLiteral(layouT_OPTIONEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION.PRESERVE_MENTAL_MAP);
		addEEnumLiteral(layouT_OPTIONEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION.VERTICAL);
		addEEnumLiteral(layouT_OPTIONEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION.HORIZONTAL);
		addEEnumLiteral(layouT_OPTIONEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION.FIXED_PORTS);

		initEEnum(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.class, "EDGE_LABEL_PLACEMENT");
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.DEFAULT);
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.CENTER);
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.HEAD);
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.TAIL);
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.LEFT);
		addEEnumLiteral(edgE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT.RIGHT);

		initEEnum(nodE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT.class, "NODE_LABEL_PLACEMENT");
		addEEnumLiteral(nodE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT.DEFAULT);
		addEEnumLiteral(nodE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT.INSIDE_NORTH);
		addEEnumLiteral(nodE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT.INSIDE_SOUTH);
		addEEnumLiteral(nodE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT.INSIDE_WEST);
		addEEnumLiteral(nodE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT.INSIDE_EAST);
		addEEnumLiteral(nodE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT.OUTSIDE_NORTH);
		addEEnumLiteral(nodE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT.OUTSIDE_SOUTH);
		addEEnumLiteral(nodE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT.OUTSIDE_WEST);
		addEEnumLiteral(nodE_LABEL_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT.OUTSIDE_EAST);

		initEEnum(porT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_TYPE.class, "PORT_TYPE");
		addEEnumLiteral(porT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_TYPE.DEFAULT);
		addEEnumLiteral(porT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_TYPE.INPUT);
		addEEnumLiteral(porT_TYPEEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_TYPE.OUTPUT);

		initEEnum(porT_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT.class, "PORT_PLACEMENT");
		addEEnumLiteral(porT_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT.DEFAULT);
		addEEnumLiteral(porT_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT.NORTH);
		addEEnumLiteral(porT_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT.EAST);
		addEEnumLiteral(porT_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT.SOUTH);
		addEEnumLiteral(porT_PLACEMENTEEnum, edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT.WEST);

		// Create resource
		createResource(eNS_URI);
	}

} //KimlLayoutGraphPackageImpl
