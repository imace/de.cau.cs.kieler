/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory
 * @model kind="package"
 * @generated
 */
public interface KimlLayoutGraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "KimlLayoutGraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.informatik.uni-kiel.de/rtsys/kimllayoutgraph";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "kimllayoutgraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KimlLayoutGraphPackage eINSTANCE = edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KPointImpl <em>KPoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KPointImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPoint()
	 * @generated
	 */
	int KPOINT = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPOINT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPOINT__Y = 1;

	/**
	 * The number of structural features of the '<em>KPoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPOINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KDimensionImpl <em>KDimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KDimensionImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKDimension()
	 * @generated
	 */
	int KDIMENSION = 1;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KDIMENSION__HEIGHT = 0;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KDIMENSION__WIDTH = 1;

	/**
	 * The number of structural features of the '<em>KDimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KDIMENSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KInsetsImpl <em>KInsets</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KInsetsImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKInsets()
	 * @generated
	 */
	int KINSETS = 2;

	/**
	 * The feature id for the '<em><b>Bottom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KINSETS__BOTTOM = 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KINSETS__LEFT = 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KINSETS__RIGHT = 2;

	/**
	 * The feature id for the '<em><b>Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KINSETS__TOP = 3;

	/**
	 * The number of structural features of the '<em>KInsets</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KINSETS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutGraphImpl <em>KLayout Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutGraphImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutGraph()
	 * @generated
	 */
	int KLAYOUT_GRAPH = 3;

	/**
	 * The feature id for the '<em><b>Top Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH__TOP_GROUP = 0;

	/**
	 * The number of structural features of the '<em>KLayout Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KShapeLayoutImpl <em>KShape Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KShapeLayoutImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKShapeLayout()
	 * @generated
	 */
	int KSHAPE_LAYOUT = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KSHAPE_LAYOUT__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KSHAPE_LAYOUT__SIZE = 1;

	/**
	 * The feature id for the '<em><b>Use Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KSHAPE_LAYOUT__USE_LAYOUT = 2;

	/**
	 * The number of structural features of the '<em>KShape Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KSHAPE_LAYOUT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeImpl <em>KEdge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdge()
	 * @generated
	 */
	int KEDGE = 5;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE__LAYOUT = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE__LABEL = 3;

	/**
	 * The number of structural features of the '<em>KEdge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl <em>KEdge Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLayout()
	 * @generated
	 */
	int KEDGE_LAYOUT = 6;

	/**
	 * The feature id for the '<em><b>Source Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LAYOUT__SOURCE_POINT = 0;

	/**
	 * The feature id for the '<em><b>Target Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LAYOUT__TARGET_POINT = 1;

	/**
	 * The feature id for the '<em><b>Grid Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LAYOUT__GRID_POINTS = 2;

	/**
	 * The feature id for the '<em><b>Edge Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LAYOUT__EDGE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Use Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LAYOUT__USE_LAYOUT = 4;

	/**
	 * The number of structural features of the '<em>KEdge Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LAYOUT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl <em>KNode Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeGroup()
	 * @generated
	 */
	int KNODE_GROUP = 7;

	/**
	 * The feature id for the '<em><b>Sub Node Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP__SUB_NODE_GROUPS = 0;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP__OUTGOING_EDGES = 1;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP__INCOMING_EDGES = 2;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP__PARENT_GROUP = 3;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP__LAYOUT = 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP__LABEL = 5;

	/**
	 * The feature id for the '<em><b>Id String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP__ID_STRING = 6;

	/**
	 * The number of structural features of the '<em>KNode Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLayoutImpl <em>KNode Group Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLayoutImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeGroupLayout()
	 * @generated
	 */
	int KNODE_GROUP_LAYOUT = 8;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT__LOCATION = KSHAPE_LAYOUT__LOCATION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT__SIZE = KSHAPE_LAYOUT__SIZE;

	/**
	 * The feature id for the '<em><b>Use Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT__USE_LAYOUT = KSHAPE_LAYOUT__USE_LAYOUT;

	/**
	 * The feature id for the '<em><b>Layout Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT__LAYOUT_TYPE = KSHAPE_LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Layout Options</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT__LAYOUT_OPTIONS = KSHAPE_LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Layouter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT__LAYOUTER_NAME = KSHAPE_LAYOUT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Insets</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT__INSETS = KSHAPE_LAYOUT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>KNode Group Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT_FEATURE_COUNT = KSHAPE_LAYOUT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KLabelImpl <em>KLabel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KLabelImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLabel()
	 * @generated
	 */
	int KLABEL = 9;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLABEL__TEXT = 0;

	/**
	 * The number of structural features of the '<em>KLabel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLABEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelImpl <em>KEdge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLabel()
	 * @generated
	 */
	int KEDGE_LABEL = 10;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL__TEXT = KLABEL__TEXT;

	/**
	 * The feature id for the '<em><b>Label Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL__LABEL_LAYOUT = KLABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>KEdge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL_FEATURE_COUNT = KLABEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelLayoutImpl <em>KEdge Label Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelLayoutImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLabelLayout()
	 * @generated
	 */
	int KEDGE_LABEL_LAYOUT = 11;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL_LAYOUT__LOCATION = KSHAPE_LAYOUT__LOCATION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL_LAYOUT__SIZE = KSHAPE_LAYOUT__SIZE;

	/**
	 * The feature id for the '<em><b>Use Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL_LAYOUT__USE_LAYOUT = KSHAPE_LAYOUT__USE_LAYOUT;

	/**
	 * The feature id for the '<em><b>Label Placement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL_LAYOUT__LABEL_PLACEMENT = KSHAPE_LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>KEdge Label Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL_LAYOUT_FEATURE_COUNT = KSHAPE_LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLabelImpl <em>KNode Group Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLabelImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeGroupLabel()
	 * @generated
	 */
	int KNODE_GROUP_LABEL = 12;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LABEL__TEXT = KLABEL__TEXT;

	/**
	 * The feature id for the '<em><b>Label Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LABEL__LABEL_LAYOUT = KLABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>KNode Group Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LABEL_FEATURE_COUNT = KLABEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLabelLayoutImpl <em>KNode Group Label Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLabelLayoutImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeGroupLabelLayout()
	 * @generated
	 */
	int KNODE_GROUP_LABEL_LAYOUT = 13;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LABEL_LAYOUT__LOCATION = KSHAPE_LAYOUT__LOCATION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LABEL_LAYOUT__SIZE = KSHAPE_LAYOUT__SIZE;

	/**
	 * The feature id for the '<em><b>Use Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LABEL_LAYOUT__USE_LAYOUT = KSHAPE_LAYOUT__USE_LAYOUT;

	/**
	 * The feature id for the '<em><b>Label Placement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LABEL_LAYOUT__LABEL_PLACEMENT = KSHAPE_LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>KNode Group Label Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LABEL_LAYOUT_FEATURE_COUNT = KSHAPE_LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.LAYOUTER_INFOImpl <em>LAYOUTER INFO</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.LAYOUTER_INFOImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getLAYOUTER_INFO()
	 * @generated
	 */
	int LAYOUTER_INFO = 14;

	/**
	 * The feature id for the '<em><b>Layouter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUTER_INFO__LAYOUTER_NAME = 0;

	/**
	 * The feature id for the '<em><b>Layout Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUTER_INFO__LAYOUT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Layout Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUTER_INFO__LAYOUT_OPTION = 2;

	/**
	 * The feature id for the '<em><b>Layout Provider ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUTER_INFO__LAYOUT_PROVIDER_ID = 3;

	/**
	 * The number of structural features of the '<em>LAYOUTER INFO</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUTER_INFO_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE <em>EDGE TYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getEDGE_TYPE()
	 * @generated
	 */
	int EDGE_TYPE = 15;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE <em>LAYOUT TYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getLAYOUT_TYPE()
	 * @generated
	 */
	int LAYOUT_TYPE = 16;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION <em>LAYOUT OPTION</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getLAYOUT_OPTION()
	 * @generated
	 */
	int LAYOUT_OPTION = 17;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT <em>EDGE LABEL PLACEMENT</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getEDGE_LABEL_PLACEMENT()
	 * @generated
	 */
	int EDGE_LABEL_PLACEMENT = 18;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT <em>NODE LABEL PLACEMENT</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getNODE_LABEL_PLACEMENT()
	 * @generated
	 */
	int NODE_LABEL_PLACEMENT = 19;


	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint <em>KPoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KPoint</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint
	 * @generated
	 */
	EClass getKPoint();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint#getX()
	 * @see #getKPoint()
	 * @generated
	 */
	EAttribute getKPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint#getY()
	 * @see #getKPoint()
	 * @generated
	 */
	EAttribute getKPoint_Y();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension <em>KDimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KDimension</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension
	 * @generated
	 */
	EClass getKDimension();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension#getHeight()
	 * @see #getKDimension()
	 * @generated
	 */
	EAttribute getKDimension_Height();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension#getWidth()
	 * @see #getKDimension()
	 * @generated
	 */
	EAttribute getKDimension_Width();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets <em>KInsets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KInsets</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets
	 * @generated
	 */
	EClass getKInsets();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets#getBottom <em>Bottom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bottom</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets#getBottom()
	 * @see #getKInsets()
	 * @generated
	 */
	EAttribute getKInsets_Bottom();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets#getLeft()
	 * @see #getKInsets()
	 * @generated
	 */
	EAttribute getKInsets_Left();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets#getRight()
	 * @see #getKInsets()
	 * @generated
	 */
	EAttribute getKInsets_Right();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets#getTop <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Top</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets#getTop()
	 * @see #getKInsets()
	 * @generated
	 */
	EAttribute getKInsets_Top();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph <em>KLayout Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KLayout Graph</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph
	 * @generated
	 */
	EClass getKLayoutGraph();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph#getTopGroup <em>Top Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top Group</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph#getTopGroup()
	 * @see #getKLayoutGraph()
	 * @generated
	 */
	EReference getKLayoutGraph_TopGroup();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout <em>KShape Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KShape Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout
	 * @generated
	 */
	EClass getKShapeLayout();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Location</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getLocation()
	 * @see #getKShapeLayout()
	 * @generated
	 */
	EReference getKShapeLayout_Location();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Size</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getSize()
	 * @see #getKShapeLayout()
	 * @generated
	 */
	EReference getKShapeLayout_Size();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#isUseLayout <em>Use Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#isUseLayout()
	 * @see #getKShapeLayout()
	 * @generated
	 */
	EAttribute getKShapeLayout_UseLayout();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge <em>KEdge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KEdge</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge
	 * @generated
	 */
	EClass getKEdge();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getSource()
	 * @see #getKEdge()
	 * @generated
	 */
	EReference getKEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getTarget()
	 * @see #getKEdge()
	 * @generated
	 */
	EReference getKEdge_Target();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getLayout()
	 * @see #getKEdge()
	 * @generated
	 */
	EReference getKEdge_Layout();

	/**
	 * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Label</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getLabel()
	 * @see #getKEdge()
	 * @generated
	 */
	EReference getKEdge_Label();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout <em>KEdge Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KEdge Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout
	 * @generated
	 */
	EClass getKEdgeLayout();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getSourcePoint <em>Source Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Point</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getSourcePoint()
	 * @see #getKEdgeLayout()
	 * @generated
	 */
	EReference getKEdgeLayout_SourcePoint();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getTargetPoint <em>Target Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Point</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getTargetPoint()
	 * @see #getKEdgeLayout()
	 * @generated
	 */
	EReference getKEdgeLayout_TargetPoint();

	/**
	 * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getGridPoints <em>Grid Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Grid Points</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getGridPoints()
	 * @see #getKEdgeLayout()
	 * @generated
	 */
	EReference getKEdgeLayout_GridPoints();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getEdgeType <em>Edge Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edge Type</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getEdgeType()
	 * @see #getKEdgeLayout()
	 * @generated
	 */
	EAttribute getKEdgeLayout_EdgeType();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#isUseLayout <em>Use Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#isUseLayout()
	 * @see #getKEdgeLayout()
	 * @generated
	 */
	EAttribute getKEdgeLayout_UseLayout();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup <em>KNode Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KNode Group</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup
	 * @generated
	 */
	EClass getKNodeGroup();

	/**
	 * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getSubNodeGroups <em>Sub Node Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Node Groups</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getSubNodeGroups()
	 * @see #getKNodeGroup()
	 * @generated
	 */
	EReference getKNodeGroup_SubNodeGroups();

	/**
	 * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getOutgoingEdges <em>Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Edges</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getOutgoingEdges()
	 * @see #getKNodeGroup()
	 * @generated
	 */
	EReference getKNodeGroup_OutgoingEdges();

	/**
	 * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Edges</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getIncomingEdges()
	 * @see #getKNodeGroup()
	 * @generated
	 */
	EReference getKNodeGroup_IncomingEdges();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Group</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getParentGroup()
	 * @see #getKNodeGroup()
	 * @generated
	 */
	EReference getKNodeGroup_ParentGroup();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getLayout()
	 * @see #getKNodeGroup()
	 * @generated
	 */
	EReference getKNodeGroup_Layout();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Label</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getLabel()
	 * @see #getKNodeGroup()
	 * @generated
	 */
	EReference getKNodeGroup_Label();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getIdString <em>Id String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id String</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getIdString()
	 * @see #getKNodeGroup()
	 * @generated
	 */
	EAttribute getKNodeGroup_IdString();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout <em>KNode Group Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KNode Group Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout
	 * @generated
	 */
	EClass getKNodeGroupLayout();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getLayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout Type</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getLayoutType()
	 * @see #getKNodeGroupLayout()
	 * @generated
	 */
	EAttribute getKNodeGroupLayout_LayoutType();

	/**
	 * Returns the meta object for the attribute list '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getLayoutOptions <em>Layout Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Layout Options</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getLayoutOptions()
	 * @see #getKNodeGroupLayout()
	 * @generated
	 */
	EAttribute getKNodeGroupLayout_LayoutOptions();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getLayouterName <em>Layouter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layouter Name</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getLayouterName()
	 * @see #getKNodeGroupLayout()
	 * @generated
	 */
	EAttribute getKNodeGroupLayout_LayouterName();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getInsets <em>Insets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Insets</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getInsets()
	 * @see #getKNodeGroupLayout()
	 * @generated
	 */
	EReference getKNodeGroupLayout_Insets();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLabel <em>KLabel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KLabel</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLabel
	 * @generated
	 */
	EClass getKLabel();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLabel#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLabel#getText()
	 * @see #getKLabel()
	 * @generated
	 */
	EAttribute getKLabel_Text();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel <em>KEdge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KEdge Label</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel
	 * @generated
	 */
	EClass getKEdgeLabel();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel#getLabelLayout <em>Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Label Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel#getLabelLayout()
	 * @see #getKEdgeLabel()
	 * @generated
	 */
	EReference getKEdgeLabel_LabelLayout();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout <em>KEdge Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KEdge Label Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout
	 * @generated
	 */
	EClass getKEdgeLabelLayout();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout#getLabelPlacement <em>Label Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label Placement</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout#getLabelPlacement()
	 * @see #getKEdgeLabelLayout()
	 * @generated
	 */
	EAttribute getKEdgeLabelLayout_LabelPlacement();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel <em>KNode Group Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KNode Group Label</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel
	 * @generated
	 */
	EClass getKNodeGroupLabel();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel#getLabelLayout <em>Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Label Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel#getLabelLayout()
	 * @see #getKNodeGroupLabel()
	 * @generated
	 */
	EReference getKNodeGroupLabel_LabelLayout();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabelLayout <em>KNode Group Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KNode Group Label Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabelLayout
	 * @generated
	 */
	EClass getKNodeGroupLabelLayout();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabelLayout#getLabelPlacement <em>Label Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label Placement</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabelLayout#getLabelPlacement()
	 * @see #getKNodeGroupLabelLayout()
	 * @generated
	 */
	EAttribute getKNodeGroupLabelLayout_LabelPlacement();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO <em>LAYOUTER INFO</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LAYOUTER INFO</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO
	 * @generated
	 */
	EClass getLAYOUTER_INFO();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayouterName <em>Layouter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layouter Name</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayouterName()
	 * @see #getLAYOUTER_INFO()
	 * @generated
	 */
	EAttribute getLAYOUTER_INFO_LayouterName();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout Type</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayoutType()
	 * @see #getLAYOUTER_INFO()
	 * @generated
	 */
	EAttribute getLAYOUTER_INFO_LayoutType();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayoutOption <em>Layout Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout Option</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayoutOption()
	 * @see #getLAYOUTER_INFO()
	 * @generated
	 */
	EAttribute getLAYOUTER_INFO_LayoutOption();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayoutProviderID <em>Layout Provider ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout Provider ID</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayoutProviderID()
	 * @see #getLAYOUTER_INFO()
	 * @generated
	 */
	EAttribute getLAYOUTER_INFO_LayoutProviderID();

	/**
	 * Returns the meta object for enum '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE <em>EDGE TYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EDGE TYPE</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE
	 * @generated
	 */
	EEnum getEDGE_TYPE();

	/**
	 * Returns the meta object for enum '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE <em>LAYOUT TYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>LAYOUT TYPE</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE
	 * @generated
	 */
	EEnum getLAYOUT_TYPE();

	/**
	 * Returns the meta object for enum '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION <em>LAYOUT OPTION</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>LAYOUT OPTION</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION
	 * @generated
	 */
	EEnum getLAYOUT_OPTION();

	/**
	 * Returns the meta object for enum '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT <em>EDGE LABEL PLACEMENT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EDGE LABEL PLACEMENT</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT
	 * @generated
	 */
	EEnum getEDGE_LABEL_PLACEMENT();

	/**
	 * Returns the meta object for enum '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT <em>NODE LABEL PLACEMENT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>NODE LABEL PLACEMENT</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT
	 * @generated
	 */
	EEnum getNODE_LABEL_PLACEMENT();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KimlLayoutGraphFactory getKimlLayoutGraphFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KPointImpl <em>KPoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KPointImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPoint()
		 * @generated
		 */
		EClass KPOINT = eINSTANCE.getKPoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KPOINT__X = eINSTANCE.getKPoint_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KPOINT__Y = eINSTANCE.getKPoint_Y();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KDimensionImpl <em>KDimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KDimensionImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKDimension()
		 * @generated
		 */
		EClass KDIMENSION = eINSTANCE.getKDimension();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KDIMENSION__HEIGHT = eINSTANCE.getKDimension_Height();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KDIMENSION__WIDTH = eINSTANCE.getKDimension_Width();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KInsetsImpl <em>KInsets</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KInsetsImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKInsets()
		 * @generated
		 */
		EClass KINSETS = eINSTANCE.getKInsets();

		/**
		 * The meta object literal for the '<em><b>Bottom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KINSETS__BOTTOM = eINSTANCE.getKInsets_Bottom();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KINSETS__LEFT = eINSTANCE.getKInsets_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KINSETS__RIGHT = eINSTANCE.getKInsets_Right();

		/**
		 * The meta object literal for the '<em><b>Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KINSETS__TOP = eINSTANCE.getKInsets_Top();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutGraphImpl <em>KLayout Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutGraphImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutGraph()
		 * @generated
		 */
		EClass KLAYOUT_GRAPH = eINSTANCE.getKLayoutGraph();

		/**
		 * The meta object literal for the '<em><b>Top Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_GRAPH__TOP_GROUP = eINSTANCE.getKLayoutGraph_TopGroup();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KShapeLayoutImpl <em>KShape Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KShapeLayoutImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKShapeLayout()
		 * @generated
		 */
		EClass KSHAPE_LAYOUT = eINSTANCE.getKShapeLayout();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KSHAPE_LAYOUT__LOCATION = eINSTANCE.getKShapeLayout_Location();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KSHAPE_LAYOUT__SIZE = eINSTANCE.getKShapeLayout_Size();

		/**
		 * The meta object literal for the '<em><b>Use Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KSHAPE_LAYOUT__USE_LAYOUT = eINSTANCE.getKShapeLayout_UseLayout();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeImpl <em>KEdge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdge()
		 * @generated
		 */
		EClass KEDGE = eINSTANCE.getKEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE__SOURCE = eINSTANCE.getKEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE__TARGET = eINSTANCE.getKEdge_Target();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE__LAYOUT = eINSTANCE.getKEdge_Layout();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE__LABEL = eINSTANCE.getKEdge_Label();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl <em>KEdge Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLayout()
		 * @generated
		 */
		EClass KEDGE_LAYOUT = eINSTANCE.getKEdgeLayout();

		/**
		 * The meta object literal for the '<em><b>Source Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE_LAYOUT__SOURCE_POINT = eINSTANCE.getKEdgeLayout_SourcePoint();

		/**
		 * The meta object literal for the '<em><b>Target Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE_LAYOUT__TARGET_POINT = eINSTANCE.getKEdgeLayout_TargetPoint();

		/**
		 * The meta object literal for the '<em><b>Grid Points</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE_LAYOUT__GRID_POINTS = eINSTANCE.getKEdgeLayout_GridPoints();

		/**
		 * The meta object literal for the '<em><b>Edge Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEDGE_LAYOUT__EDGE_TYPE = eINSTANCE.getKEdgeLayout_EdgeType();

		/**
		 * The meta object literal for the '<em><b>Use Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEDGE_LAYOUT__USE_LAYOUT = eINSTANCE.getKEdgeLayout_UseLayout();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl <em>KNode Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeGroup()
		 * @generated
		 */
		EClass KNODE_GROUP = eINSTANCE.getKNodeGroup();

		/**
		 * The meta object literal for the '<em><b>Sub Node Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP__SUB_NODE_GROUPS = eINSTANCE.getKNodeGroup_SubNodeGroups();

		/**
		 * The meta object literal for the '<em><b>Outgoing Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP__OUTGOING_EDGES = eINSTANCE.getKNodeGroup_OutgoingEdges();

		/**
		 * The meta object literal for the '<em><b>Incoming Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP__INCOMING_EDGES = eINSTANCE.getKNodeGroup_IncomingEdges();

		/**
		 * The meta object literal for the '<em><b>Parent Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP__PARENT_GROUP = eINSTANCE.getKNodeGroup_ParentGroup();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP__LAYOUT = eINSTANCE.getKNodeGroup_Layout();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP__LABEL = eINSTANCE.getKNodeGroup_Label();

		/**
		 * The meta object literal for the '<em><b>Id String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KNODE_GROUP__ID_STRING = eINSTANCE.getKNodeGroup_IdString();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLayoutImpl <em>KNode Group Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLayoutImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeGroupLayout()
		 * @generated
		 */
		EClass KNODE_GROUP_LAYOUT = eINSTANCE.getKNodeGroupLayout();

		/**
		 * The meta object literal for the '<em><b>Layout Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KNODE_GROUP_LAYOUT__LAYOUT_TYPE = eINSTANCE.getKNodeGroupLayout_LayoutType();

		/**
		 * The meta object literal for the '<em><b>Layout Options</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KNODE_GROUP_LAYOUT__LAYOUT_OPTIONS = eINSTANCE.getKNodeGroupLayout_LayoutOptions();

		/**
		 * The meta object literal for the '<em><b>Layouter Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KNODE_GROUP_LAYOUT__LAYOUTER_NAME = eINSTANCE.getKNodeGroupLayout_LayouterName();

		/**
		 * The meta object literal for the '<em><b>Insets</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP_LAYOUT__INSETS = eINSTANCE.getKNodeGroupLayout_Insets();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KLabelImpl <em>KLabel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KLabelImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLabel()
		 * @generated
		 */
		EClass KLABEL = eINSTANCE.getKLabel();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KLABEL__TEXT = eINSTANCE.getKLabel_Text();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelImpl <em>KEdge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLabel()
		 * @generated
		 */
		EClass KEDGE_LABEL = eINSTANCE.getKEdgeLabel();

		/**
		 * The meta object literal for the '<em><b>Label Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE_LABEL__LABEL_LAYOUT = eINSTANCE.getKEdgeLabel_LabelLayout();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelLayoutImpl <em>KEdge Label Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelLayoutImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLabelLayout()
		 * @generated
		 */
		EClass KEDGE_LABEL_LAYOUT = eINSTANCE.getKEdgeLabelLayout();

		/**
		 * The meta object literal for the '<em><b>Label Placement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEDGE_LABEL_LAYOUT__LABEL_PLACEMENT = eINSTANCE.getKEdgeLabelLayout_LabelPlacement();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLabelImpl <em>KNode Group Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLabelImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeGroupLabel()
		 * @generated
		 */
		EClass KNODE_GROUP_LABEL = eINSTANCE.getKNodeGroupLabel();

		/**
		 * The meta object literal for the '<em><b>Label Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP_LABEL__LABEL_LAYOUT = eINSTANCE.getKNodeGroupLabel_LabelLayout();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLabelLayoutImpl <em>KNode Group Label Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLabelLayoutImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeGroupLabelLayout()
		 * @generated
		 */
		EClass KNODE_GROUP_LABEL_LAYOUT = eINSTANCE.getKNodeGroupLabelLayout();

		/**
		 * The meta object literal for the '<em><b>Label Placement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KNODE_GROUP_LABEL_LAYOUT__LABEL_PLACEMENT = eINSTANCE.getKNodeGroupLabelLayout_LabelPlacement();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.LAYOUTER_INFOImpl <em>LAYOUTER INFO</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.LAYOUTER_INFOImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getLAYOUTER_INFO()
		 * @generated
		 */
		EClass LAYOUTER_INFO = eINSTANCE.getLAYOUTER_INFO();

		/**
		 * The meta object literal for the '<em><b>Layouter Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUTER_INFO__LAYOUTER_NAME = eINSTANCE.getLAYOUTER_INFO_LayouterName();

		/**
		 * The meta object literal for the '<em><b>Layout Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUTER_INFO__LAYOUT_TYPE = eINSTANCE.getLAYOUTER_INFO_LayoutType();

		/**
		 * The meta object literal for the '<em><b>Layout Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUTER_INFO__LAYOUT_OPTION = eINSTANCE.getLAYOUTER_INFO_LayoutOption();

		/**
		 * The meta object literal for the '<em><b>Layout Provider ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUTER_INFO__LAYOUT_PROVIDER_ID = eINSTANCE.getLAYOUTER_INFO_LayoutProviderID();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE <em>EDGE TYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getEDGE_TYPE()
		 * @generated
		 */
		EEnum EDGE_TYPE = eINSTANCE.getEDGE_TYPE();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE <em>LAYOUT TYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getLAYOUT_TYPE()
		 * @generated
		 */
		EEnum LAYOUT_TYPE = eINSTANCE.getLAYOUT_TYPE();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION <em>LAYOUT OPTION</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getLAYOUT_OPTION()
		 * @generated
		 */
		EEnum LAYOUT_OPTION = eINSTANCE.getLAYOUT_OPTION();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT <em>EDGE LABEL PLACEMENT</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getEDGE_LABEL_PLACEMENT()
		 * @generated
		 */
		EEnum EDGE_LABEL_PLACEMENT = eINSTANCE.getEDGE_LABEL_PLACEMENT();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT <em>NODE LABEL PLACEMENT</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getNODE_LABEL_PLACEMENT()
		 * @generated
		 */
		EEnum NODE_LABEL_PLACEMENT = eINSTANCE.getNODE_LABEL_PLACEMENT();

	}

} //KimlLayoutGraphPackage
