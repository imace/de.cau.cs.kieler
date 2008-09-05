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
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kPointImpl <em>kPoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kPointImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkPoint()
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
	 * The number of structural features of the '<em>kPoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPOINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kDimensionImpl <em>kDimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kDimensionImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkDimension()
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
	 * The number of structural features of the '<em>kDimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KDIMENSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kInsetsImpl <em>kInsets</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kInsetsImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkInsets()
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
	 * The number of structural features of the '<em>kInsets</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KINSETS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeImpl <em>kEdge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkEdge()
	 * @generated
	 */
	int KEDGE = 3;

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
	 * The feature id for the '<em><b>Edge Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE__EDGE_LAYOUT = 2;

	/**
	 * The feature id for the '<em><b>Edge Label</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE__EDGE_LABEL = 3;

	/**
	 * The number of structural features of the '<em>kEdge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kLayoutGraphImpl <em>kLayout Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kLayoutGraphImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkLayoutGraph()
	 * @generated
	 */
	int KLAYOUT_GRAPH = 4;

	/**
	 * The feature id for the '<em><b>Top Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH__TOP_GROUP = 0;

	/**
	 * The number of structural features of the '<em>kLayout Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kShapeLayoutImpl <em>kShape Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kShapeLayoutImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkShapeLayout()
	 * @generated
	 */
	int KSHAPE_LAYOUT = 5;

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
	 * The feature id for the '<em><b>Insets</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KSHAPE_LAYOUT__INSETS = 2;

	/**
	 * The number of structural features of the '<em>kShape Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KSHAPE_LAYOUT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLayoutImpl <em>kEdge Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLayoutImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkEdgeLayout()
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
	 * The number of structural features of the '<em>kEdge Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LAYOUT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupImpl <em>kNode Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkNodeGroup()
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
	 * The feature id for the '<em><b>Node Group Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP__NODE_GROUP_LAYOUT = 4;

	/**
	 * The number of structural features of the '<em>kNode Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLabelImpl <em>kEdge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLabelImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkEdgeLabel()
	 * @generated
	 */
	int KEDGE_LABEL = 8;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Edge Label Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL__EDGE_LABEL_LAYOUT = 1;

	/**
	 * The number of structural features of the '<em>kEdge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupLayoutImpl <em>kNode Group Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupLayoutImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkNodeGroupLayout()
	 * @generated
	 */
	int KNODE_GROUP_LAYOUT = 9;

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
	 * The feature id for the '<em><b>Insets</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT__INSETS = KSHAPE_LAYOUT__INSETS;

	/**
	 * The feature id for the '<em><b>Layout Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT__LAYOUT_TYPE = KSHAPE_LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Layout Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT__LAYOUT_OPTIONS = KSHAPE_LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>kNode Group Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_GROUP_LAYOUT_FEATURE_COUNT = KSHAPE_LAYOUT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLabelLayoutImpl <em>kEdge Label Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLabelLayoutImpl
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkEdgeLabelLayout()
	 * @generated
	 */
	int KEDGE_LABEL_LAYOUT = 10;

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
	 * The feature id for the '<em><b>Insets</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL_LAYOUT__INSETS = KSHAPE_LAYOUT__INSETS;

	/**
	 * The feature id for the '<em><b>Edge Label Placement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL_LAYOUT__EDGE_LABEL_PLACEMENT = KSHAPE_LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>kEdge Label Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEDGE_LABEL_LAYOUT_FEATURE_COUNT = KSHAPE_LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPES <em>EDGE TYPES</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPES
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getEDGE_TYPES()
	 * @generated
	 */
	int EDGE_TYPES = 11;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT <em>EDGE LABEL PLACEMENT</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getEDGE_LABEL_PLACEMENT()
	 * @generated
	 */
	int EDGE_LABEL_PLACEMENT = 12;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPES <em>LAYOUT TYPES</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPES
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getLAYOUT_TYPES()
	 * @generated
	 */
	int LAYOUT_TYPES = 13;

	/**
	 * The meta object id for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTIONS <em>LAYOUT OPTIONS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTIONS
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getLAYOUT_OPTIONS()
	 * @generated
	 */
	int LAYOUT_OPTIONS = 14;


	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kPoint <em>kPoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>kPoint</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kPoint
	 * @generated
	 */
	EClass getkPoint();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kPoint#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kPoint#getX()
	 * @see #getkPoint()
	 * @generated
	 */
	EAttribute getkPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kPoint#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kPoint#getY()
	 * @see #getkPoint()
	 * @generated
	 */
	EAttribute getkPoint_Y();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kDimension <em>kDimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>kDimension</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kDimension
	 * @generated
	 */
	EClass getkDimension();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kDimension#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kDimension#getHeight()
	 * @see #getkDimension()
	 * @generated
	 */
	EAttribute getkDimension_Height();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kDimension#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kDimension#getWidth()
	 * @see #getkDimension()
	 * @generated
	 */
	EAttribute getkDimension_Width();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets <em>kInsets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>kInsets</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets
	 * @generated
	 */
	EClass getkInsets();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets#getBottom <em>Bottom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bottom</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets#getBottom()
	 * @see #getkInsets()
	 * @generated
	 */
	EAttribute getkInsets_Bottom();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets#getLeft()
	 * @see #getkInsets()
	 * @generated
	 */
	EAttribute getkInsets_Left();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets#getRight()
	 * @see #getkInsets()
	 * @generated
	 */
	EAttribute getkInsets_Right();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets#getTop <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Top</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets#getTop()
	 * @see #getkInsets()
	 * @generated
	 */
	EAttribute getkInsets_Top();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge <em>kEdge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>kEdge</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge
	 * @generated
	 */
	EClass getkEdge();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getSource()
	 * @see #getkEdge()
	 * @generated
	 */
	EReference getkEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getTarget()
	 * @see #getkEdge()
	 * @generated
	 */
	EReference getkEdge_Target();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getEdgeLayout <em>Edge Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Edge Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getEdgeLayout()
	 * @see #getkEdge()
	 * @generated
	 */
	EReference getkEdge_EdgeLayout();

	/**
	 * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getEdgeLabel <em>Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edge Label</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getEdgeLabel()
	 * @see #getkEdge()
	 * @generated
	 */
	EReference getkEdge_EdgeLabel();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kLayoutGraph <em>kLayout Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>kLayout Graph</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kLayoutGraph
	 * @generated
	 */
	EClass getkLayoutGraph();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kLayoutGraph#getTopGroup <em>Top Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top Group</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kLayoutGraph#getTopGroup()
	 * @see #getkLayoutGraph()
	 * @generated
	 */
	EReference getkLayoutGraph_TopGroup();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kShapeLayout <em>kShape Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>kShape Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kShapeLayout
	 * @generated
	 */
	EClass getkShapeLayout();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kShapeLayout#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Location</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kShapeLayout#getLocation()
	 * @see #getkShapeLayout()
	 * @generated
	 */
	EReference getkShapeLayout_Location();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kShapeLayout#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Size</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kShapeLayout#getSize()
	 * @see #getkShapeLayout()
	 * @generated
	 */
	EReference getkShapeLayout_Size();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kShapeLayout#getInsets <em>Insets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Insets</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kShapeLayout#getInsets()
	 * @see #getkShapeLayout()
	 * @generated
	 */
	EReference getkShapeLayout_Insets();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout <em>kEdge Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>kEdge Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout
	 * @generated
	 */
	EClass getkEdgeLayout();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout#getSourcePoint <em>Source Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Point</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout#getSourcePoint()
	 * @see #getkEdgeLayout()
	 * @generated
	 */
	EReference getkEdgeLayout_SourcePoint();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout#getTargetPoint <em>Target Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Point</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout#getTargetPoint()
	 * @see #getkEdgeLayout()
	 * @generated
	 */
	EReference getkEdgeLayout_TargetPoint();

	/**
	 * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout#getGridPoints <em>Grid Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Grid Points</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout#getGridPoints()
	 * @see #getkEdgeLayout()
	 * @generated
	 */
	EReference getkEdgeLayout_GridPoints();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout#getEdgeType <em>Edge Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edge Type</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout#getEdgeType()
	 * @see #getkEdgeLayout()
	 * @generated
	 */
	EAttribute getkEdgeLayout_EdgeType();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup <em>kNode Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>kNode Group</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup
	 * @generated
	 */
	EClass getkNodeGroup();

	/**
	 * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getSubNodeGroups <em>Sub Node Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Node Groups</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getSubNodeGroups()
	 * @see #getkNodeGroup()
	 * @generated
	 */
	EReference getkNodeGroup_SubNodeGroups();

	/**
	 * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getOutgoingEdges <em>Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Edges</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getOutgoingEdges()
	 * @see #getkNodeGroup()
	 * @generated
	 */
	EReference getkNodeGroup_OutgoingEdges();

	/**
	 * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Edges</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getIncomingEdges()
	 * @see #getkNodeGroup()
	 * @generated
	 */
	EReference getkNodeGroup_IncomingEdges();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Group</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getParentGroup()
	 * @see #getkNodeGroup()
	 * @generated
	 */
	EReference getkNodeGroup_ParentGroup();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getNodeGroupLayout <em>Node Group Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node Group Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getNodeGroupLayout()
	 * @see #getkNodeGroup()
	 * @generated
	 */
	EReference getkNodeGroup_NodeGroupLayout();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabel <em>kEdge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>kEdge Label</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabel
	 * @generated
	 */
	EClass getkEdgeLabel();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabel#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabel#getText()
	 * @see #getkEdgeLabel()
	 * @generated
	 */
	EAttribute getkEdgeLabel_Text();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabel#getEdgeLabelLayout <em>Edge Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Edge Label Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabel#getEdgeLabelLayout()
	 * @see #getkEdgeLabel()
	 * @generated
	 */
	EReference getkEdgeLabel_EdgeLabelLayout();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout <em>kNode Group Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>kNode Group Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout
	 * @generated
	 */
	EClass getkNodeGroupLayout();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout#getLayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout Type</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout#getLayoutType()
	 * @see #getkNodeGroupLayout()
	 * @generated
	 */
	EAttribute getkNodeGroupLayout_LayoutType();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout#getLayoutOptions <em>Layout Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout Options</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout#getLayoutOptions()
	 * @see #getkNodeGroupLayout()
	 * @generated
	 */
	EAttribute getkNodeGroupLayout_LayoutOptions();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabelLayout <em>kEdge Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>kEdge Label Layout</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabelLayout
	 * @generated
	 */
	EClass getkEdgeLabelLayout();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabelLayout#getEdgeLabelPlacement <em>Edge Label Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edge Label Placement</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabelLayout#getEdgeLabelPlacement()
	 * @see #getkEdgeLabelLayout()
	 * @generated
	 */
	EAttribute getkEdgeLabelLayout_EdgeLabelPlacement();

	/**
	 * Returns the meta object for enum '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPES <em>EDGE TYPES</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EDGE TYPES</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPES
	 * @generated
	 */
	EEnum getEDGE_TYPES();

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
	 * Returns the meta object for enum '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPES <em>LAYOUT TYPES</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>LAYOUT TYPES</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPES
	 * @generated
	 */
	EEnum getLAYOUT_TYPES();

	/**
	 * Returns the meta object for enum '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTIONS <em>LAYOUT OPTIONS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>LAYOUT OPTIONS</em>'.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTIONS
	 * @generated
	 */
	EEnum getLAYOUT_OPTIONS();

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
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kPointImpl <em>kPoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kPointImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkPoint()
		 * @generated
		 */
		EClass KPOINT = eINSTANCE.getkPoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KPOINT__X = eINSTANCE.getkPoint_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KPOINT__Y = eINSTANCE.getkPoint_Y();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kDimensionImpl <em>kDimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kDimensionImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkDimension()
		 * @generated
		 */
		EClass KDIMENSION = eINSTANCE.getkDimension();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KDIMENSION__HEIGHT = eINSTANCE.getkDimension_Height();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KDIMENSION__WIDTH = eINSTANCE.getkDimension_Width();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kInsetsImpl <em>kInsets</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kInsetsImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkInsets()
		 * @generated
		 */
		EClass KINSETS = eINSTANCE.getkInsets();

		/**
		 * The meta object literal for the '<em><b>Bottom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KINSETS__BOTTOM = eINSTANCE.getkInsets_Bottom();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KINSETS__LEFT = eINSTANCE.getkInsets_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KINSETS__RIGHT = eINSTANCE.getkInsets_Right();

		/**
		 * The meta object literal for the '<em><b>Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KINSETS__TOP = eINSTANCE.getkInsets_Top();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeImpl <em>kEdge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkEdge()
		 * @generated
		 */
		EClass KEDGE = eINSTANCE.getkEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE__SOURCE = eINSTANCE.getkEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE__TARGET = eINSTANCE.getkEdge_Target();

		/**
		 * The meta object literal for the '<em><b>Edge Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE__EDGE_LAYOUT = eINSTANCE.getkEdge_EdgeLayout();

		/**
		 * The meta object literal for the '<em><b>Edge Label</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE__EDGE_LABEL = eINSTANCE.getkEdge_EdgeLabel();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kLayoutGraphImpl <em>kLayout Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kLayoutGraphImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkLayoutGraph()
		 * @generated
		 */
		EClass KLAYOUT_GRAPH = eINSTANCE.getkLayoutGraph();

		/**
		 * The meta object literal for the '<em><b>Top Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_GRAPH__TOP_GROUP = eINSTANCE.getkLayoutGraph_TopGroup();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kShapeLayoutImpl <em>kShape Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kShapeLayoutImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkShapeLayout()
		 * @generated
		 */
		EClass KSHAPE_LAYOUT = eINSTANCE.getkShapeLayout();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KSHAPE_LAYOUT__LOCATION = eINSTANCE.getkShapeLayout_Location();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KSHAPE_LAYOUT__SIZE = eINSTANCE.getkShapeLayout_Size();

		/**
		 * The meta object literal for the '<em><b>Insets</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KSHAPE_LAYOUT__INSETS = eINSTANCE.getkShapeLayout_Insets();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLayoutImpl <em>kEdge Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLayoutImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkEdgeLayout()
		 * @generated
		 */
		EClass KEDGE_LAYOUT = eINSTANCE.getkEdgeLayout();

		/**
		 * The meta object literal for the '<em><b>Source Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE_LAYOUT__SOURCE_POINT = eINSTANCE.getkEdgeLayout_SourcePoint();

		/**
		 * The meta object literal for the '<em><b>Target Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE_LAYOUT__TARGET_POINT = eINSTANCE.getkEdgeLayout_TargetPoint();

		/**
		 * The meta object literal for the '<em><b>Grid Points</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE_LAYOUT__GRID_POINTS = eINSTANCE.getkEdgeLayout_GridPoints();

		/**
		 * The meta object literal for the '<em><b>Edge Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEDGE_LAYOUT__EDGE_TYPE = eINSTANCE.getkEdgeLayout_EdgeType();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupImpl <em>kNode Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkNodeGroup()
		 * @generated
		 */
		EClass KNODE_GROUP = eINSTANCE.getkNodeGroup();

		/**
		 * The meta object literal for the '<em><b>Sub Node Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP__SUB_NODE_GROUPS = eINSTANCE.getkNodeGroup_SubNodeGroups();

		/**
		 * The meta object literal for the '<em><b>Outgoing Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP__OUTGOING_EDGES = eINSTANCE.getkNodeGroup_OutgoingEdges();

		/**
		 * The meta object literal for the '<em><b>Incoming Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP__INCOMING_EDGES = eINSTANCE.getkNodeGroup_IncomingEdges();

		/**
		 * The meta object literal for the '<em><b>Parent Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP__PARENT_GROUP = eINSTANCE.getkNodeGroup_ParentGroup();

		/**
		 * The meta object literal for the '<em><b>Node Group Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_GROUP__NODE_GROUP_LAYOUT = eINSTANCE.getkNodeGroup_NodeGroupLayout();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLabelImpl <em>kEdge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLabelImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkEdgeLabel()
		 * @generated
		 */
		EClass KEDGE_LABEL = eINSTANCE.getkEdgeLabel();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEDGE_LABEL__TEXT = eINSTANCE.getkEdgeLabel_Text();

		/**
		 * The meta object literal for the '<em><b>Edge Label Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEDGE_LABEL__EDGE_LABEL_LAYOUT = eINSTANCE.getkEdgeLabel_EdgeLabelLayout();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupLayoutImpl <em>kNode Group Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupLayoutImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkNodeGroupLayout()
		 * @generated
		 */
		EClass KNODE_GROUP_LAYOUT = eINSTANCE.getkNodeGroupLayout();

		/**
		 * The meta object literal for the '<em><b>Layout Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KNODE_GROUP_LAYOUT__LAYOUT_TYPE = eINSTANCE.getkNodeGroupLayout_LayoutType();

		/**
		 * The meta object literal for the '<em><b>Layout Options</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KNODE_GROUP_LAYOUT__LAYOUT_OPTIONS = eINSTANCE.getkNodeGroupLayout_LayoutOptions();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLabelLayoutImpl <em>kEdge Label Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLabelLayoutImpl
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getkEdgeLabelLayout()
		 * @generated
		 */
		EClass KEDGE_LABEL_LAYOUT = eINSTANCE.getkEdgeLabelLayout();

		/**
		 * The meta object literal for the '<em><b>Edge Label Placement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEDGE_LABEL_LAYOUT__EDGE_LABEL_PLACEMENT = eINSTANCE.getkEdgeLabelLayout_EdgeLabelPlacement();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPES <em>EDGE TYPES</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPES
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getEDGE_TYPES()
		 * @generated
		 */
		EEnum EDGE_TYPES = eINSTANCE.getEDGE_TYPES();

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
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPES <em>LAYOUT TYPES</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPES
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getLAYOUT_TYPES()
		 * @generated
		 */
		EEnum LAYOUT_TYPES = eINSTANCE.getLAYOUT_TYPES();

		/**
		 * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTIONS <em>LAYOUT OPTIONS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTIONS
		 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getLAYOUT_OPTIONS()
		 * @generated
		 */
		EEnum LAYOUT_OPTIONS = eINSTANCE.getLAYOUT_OPTIONS();

	}

} //KimlLayoutGraphPackage
