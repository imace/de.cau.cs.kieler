/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;

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
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory
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
	KimlLayoutGraphPackage eINSTANCE = de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPointImpl <em>KPoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPointImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPoint()
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
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KDimensionImpl <em>KDimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KDimensionImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKDimension()
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
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KInsetsImpl <em>KInsets</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KInsetsImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKInsets()
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
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl <em>KLayout Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutNode()
	 * @generated
	 */
	int KLAYOUT_NODE = 7;

	/**
	 * The feature id for the '<em><b>Child Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_NODE__CHILD_NODES = 0;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_NODE__OUTGOING_EDGES = 1;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_NODE__INCOMING_EDGES = 2;

	/**
	 * The feature id for the '<em><b>Parent Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_NODE__PARENT_NODE = 3;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_NODE__LAYOUT = 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_NODE__LABEL = 5;

	/**
	 * The feature id for the '<em><b>Id String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_NODE__ID_STRING = 6;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_NODE__PORTS = 7;

	/**
	 * The number of structural features of the '<em>KLayout Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_NODE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutGraphImpl <em>KLayout Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutGraphImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutGraph()
	 * @generated
	 */
	int KLAYOUT_GRAPH = 3;

	/**
	 * The feature id for the '<em><b>Child Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH__CHILD_NODES = KLAYOUT_NODE__CHILD_NODES;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH__OUTGOING_EDGES = KLAYOUT_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH__INCOMING_EDGES = KLAYOUT_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Parent Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH__PARENT_NODE = KLAYOUT_NODE__PARENT_NODE;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH__LAYOUT = KLAYOUT_NODE__LAYOUT;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH__LABEL = KLAYOUT_NODE__LABEL;

	/**
	 * The feature id for the '<em><b>Id String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH__ID_STRING = KLAYOUT_NODE__ID_STRING;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH__PORTS = KLAYOUT_NODE__PORTS;

	/**
	 * The number of structural features of the '<em>KLayout Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_GRAPH_FEATURE_COUNT = KLAYOUT_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KShapeLayoutImpl <em>KShape Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KShapeLayoutImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKShapeLayout()
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
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutEdgeImpl <em>KLayout Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutEdgeImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutEdge()
	 * @generated
	 */
	int KLAYOUT_EDGE = 5;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_EDGE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_EDGE__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_EDGE__LAYOUT = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_EDGE__LABEL = 3;

	/**
	 * The feature id for the '<em><b>Source Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_EDGE__SOURCE_PORT = 4;

	/**
	 * The feature id for the '<em><b>Target Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_EDGE__TARGET_PORT = 5;

	/**
	 * The number of structural features of the '<em>KLayout Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_EDGE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl <em>KEdge Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLayout()
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
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLayoutImpl <em>KNode Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLayoutImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeLayout()
	 * @generated
	 */
	int KNODE_LAYOUT = 8;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LAYOUT__LOCATION = KSHAPE_LAYOUT__LOCATION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LAYOUT__SIZE = KSHAPE_LAYOUT__SIZE;

	/**
	 * The feature id for the '<em><b>Use Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LAYOUT__USE_LAYOUT = KSHAPE_LAYOUT__USE_LAYOUT;

	/**
	 * The feature id for the '<em><b>Layout Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LAYOUT__LAYOUT_TYPE = KSHAPE_LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Layout Options</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LAYOUT__LAYOUT_OPTIONS = KSHAPE_LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Layouter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LAYOUT__LAYOUTER_NAME = KSHAPE_LAYOUT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Insets</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LAYOUT__INSETS = KSHAPE_LAYOUT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>KNode Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LAYOUT_FEATURE_COUNT = KSHAPE_LAYOUT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLabelImpl <em>KLabel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLabelImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLabel()
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
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelImpl <em>KEdge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLabel()
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
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelLayoutImpl <em>KEdge Label Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelLayoutImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLabelLayout()
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
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLabelImpl <em>KNode Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLabelImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeLabel()
	 * @generated
	 */
	int KNODE_LABEL = 12;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LABEL__TEXT = KLABEL__TEXT;

	/**
	 * The feature id for the '<em><b>Label Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LABEL__LABEL_LAYOUT = KLABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>KNode Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LABEL_FEATURE_COUNT = KLABEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLabelLayoutImpl <em>KNode Label Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLabelLayoutImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeLabelLayout()
	 * @generated
	 */
	int KNODE_LABEL_LAYOUT = 13;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LABEL_LAYOUT__LOCATION = KSHAPE_LAYOUT__LOCATION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LABEL_LAYOUT__SIZE = KSHAPE_LAYOUT__SIZE;

	/**
	 * The feature id for the '<em><b>Use Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LABEL_LAYOUT__USE_LAYOUT = KSHAPE_LAYOUT__USE_LAYOUT;

	/**
	 * The feature id for the '<em><b>Label Placement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LABEL_LAYOUT__LABEL_PLACEMENT = KSHAPE_LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>KNode Label Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNODE_LABEL_LAYOUT_FEATURE_COUNT = KSHAPE_LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayouterInfoImpl <em>KLayouter Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayouterInfoImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayouterInfo()
	 * @generated
	 */
	int KLAYOUTER_INFO = 14;

	/**
	 * The feature id for the '<em><b>Layouter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUTER_INFO__LAYOUTER_NAME = 0;

	/**
	 * The feature id for the '<em><b>Layout Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUTER_INFO__LAYOUT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Layout Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUTER_INFO__LAYOUT_OPTION = 2;

	/**
	 * The feature id for the '<em><b>Layouter Collection ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUTER_INFO__LAYOUTER_COLLECTION_ID = 3;

	/**
	 * The number of structural features of the '<em>KLayouter Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUTER_INFO_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutPortImpl <em>KLayout Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutPortImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutPort()
	 * @generated
	 */
	int KLAYOUT_PORT = 15;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_PORT__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_PORT__LABEL = 1;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_PORT__NODE = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_PORT__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_PORT__EDGES = 4;

	/**
	 * The number of structural features of the '<em>KLayout Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLAYOUT_PORT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLayoutImpl <em>KPort Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLayoutImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPortLayout()
	 * @generated
	 */
	int KPORT_LAYOUT = 16;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LAYOUT__LOCATION = KSHAPE_LAYOUT__LOCATION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LAYOUT__SIZE = KSHAPE_LAYOUT__SIZE;

	/**
	 * The feature id for the '<em><b>Use Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LAYOUT__USE_LAYOUT = KSHAPE_LAYOUT__USE_LAYOUT;

	/**
	 * The feature id for the '<em><b>Placement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LAYOUT__PLACEMENT = KSHAPE_LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>KPort Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LAYOUT_FEATURE_COUNT = KSHAPE_LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLabelImpl <em>KPort Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLabelImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPortLabel()
	 * @generated
	 */
	int KPORT_LABEL = 17;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LABEL__TEXT = KLABEL__TEXT;

	/**
	 * The feature id for the '<em><b>Label Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LABEL__LABEL_LAYOUT = KLABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>KPort Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LABEL_FEATURE_COUNT = KLABEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLabelLayoutImpl <em>KPort Label Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLabelLayoutImpl
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPortLabelLayout()
	 * @generated
	 */
	int KPORT_LABEL_LAYOUT = 18;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LABEL_LAYOUT__LOCATION = KSHAPE_LAYOUT__LOCATION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LABEL_LAYOUT__SIZE = KSHAPE_LAYOUT__SIZE;

	/**
	 * The feature id for the '<em><b>Use Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LABEL_LAYOUT__USE_LAYOUT = KSHAPE_LAYOUT__USE_LAYOUT;

	/**
	 * The number of structural features of the '<em>KPort Label Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KPORT_LABEL_LAYOUT_FEATURE_COUNT = KSHAPE_LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType <em>KEdge Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeType()
	 * @generated
	 */
	int KEDGE_TYPE = 19;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType <em>KLayout Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutType()
	 * @generated
	 */
	int KLAYOUT_TYPE = 20;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption <em>KLayout Option</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutOption()
	 * @generated
	 */
	int KLAYOUT_OPTION = 21;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement <em>KEdge Label Placement</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLabelPlacement()
	 * @generated
	 */
	int KEDGE_LABEL_PLACEMENT = 22;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelPlacement <em>KNode Label Placement</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelPlacement
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeLabelPlacement()
	 * @generated
	 */
	int KNODE_LABEL_PLACEMENT = 23;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType <em>KPort Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPortType()
	 * @generated
	 */
	int KPORT_TYPE = 24;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement <em>KPort Placement</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPortPlacement()
	 * @generated
	 */
	int KPORT_PLACEMENT = 25;

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint <em>KPoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KPoint</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint
	 * @generated
	 */
	EClass getKPoint();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint#getX()
	 * @see #getKPoint()
	 * @generated
	 */
	EAttribute getKPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint#getY()
	 * @see #getKPoint()
	 * @generated
	 */
	EAttribute getKPoint_Y();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension <em>KDimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KDimension</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension
	 * @generated
	 */
	EClass getKDimension();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension#getHeight()
	 * @see #getKDimension()
	 * @generated
	 */
	EAttribute getKDimension_Height();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension#getWidth()
	 * @see #getKDimension()
	 * @generated
	 */
	EAttribute getKDimension_Width();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets <em>KInsets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KInsets</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets
	 * @generated
	 */
	EClass getKInsets();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets#getBottom <em>Bottom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bottom</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets#getBottom()
	 * @see #getKInsets()
	 * @generated
	 */
	EAttribute getKInsets_Bottom();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets#getLeft()
	 * @see #getKInsets()
	 * @generated
	 */
	EAttribute getKInsets_Left();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets#getRight()
	 * @see #getKInsets()
	 * @generated
	 */
	EAttribute getKInsets_Right();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets#getTop <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Top</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets#getTop()
	 * @see #getKInsets()
	 * @generated
	 */
	EAttribute getKInsets_Top();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph <em>KLayout Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KLayout Graph</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph
	 * @generated
	 */
	EClass getKLayoutGraph();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout <em>KShape Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KShape Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout
	 * @generated
	 */
	EClass getKShapeLayout();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Location</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getLocation()
	 * @see #getKShapeLayout()
	 * @generated
	 */
	EReference getKShapeLayout_Location();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Size</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getSize()
	 * @see #getKShapeLayout()
	 * @generated
	 */
	EReference getKShapeLayout_Size();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#isUseLayout <em>Use Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#isUseLayout()
	 * @see #getKShapeLayout()
	 * @generated
	 */
	EAttribute getKShapeLayout_UseLayout();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge <em>KLayout Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KLayout Edge</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge
	 * @generated
	 */
	EClass getKLayoutEdge();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getSource()
	 * @see #getKLayoutEdge()
	 * @generated
	 */
	EReference getKLayoutEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getTarget()
	 * @see #getKLayoutEdge()
	 * @generated
	 */
	EReference getKLayoutEdge_Target();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getLayout()
	 * @see #getKLayoutEdge()
	 * @generated
	 */
	EReference getKLayoutEdge_Layout();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Label</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getLabel()
	 * @see #getKLayoutEdge()
	 * @generated
	 */
	EReference getKLayoutEdge_Label();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getSourcePort <em>Source Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Port</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getSourcePort()
	 * @see #getKLayoutEdge()
	 * @generated
	 */
	EReference getKLayoutEdge_SourcePort();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getTargetPort <em>Target Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Port</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getTargetPort()
	 * @see #getKLayoutEdge()
	 * @generated
	 */
	EReference getKLayoutEdge_TargetPort();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout <em>KEdge Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KEdge Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout
	 * @generated
	 */
	EClass getKEdgeLayout();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getSourcePoint <em>Source Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Point</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getSourcePoint()
	 * @see #getKEdgeLayout()
	 * @generated
	 */
	EReference getKEdgeLayout_SourcePoint();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getTargetPoint <em>Target Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Point</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getTargetPoint()
	 * @see #getKEdgeLayout()
	 * @generated
	 */
	EReference getKEdgeLayout_TargetPoint();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getGridPoints <em>Grid Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Grid Points</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getGridPoints()
	 * @see #getKEdgeLayout()
	 * @generated
	 */
	EReference getKEdgeLayout_GridPoints();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getEdgeType <em>Edge Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edge Type</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getEdgeType()
	 * @see #getKEdgeLayout()
	 * @generated
	 */
	EAttribute getKEdgeLayout_EdgeType();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#isUseLayout <em>Use Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#isUseLayout()
	 * @see #getKEdgeLayout()
	 * @generated
	 */
	EAttribute getKEdgeLayout_UseLayout();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode <em>KLayout Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KLayout Node</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode
	 * @generated
	 */
	EClass getKLayoutNode();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getChildNodes <em>Child Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Child Nodes</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getChildNodes()
	 * @see #getKLayoutNode()
	 * @generated
	 */
	EReference getKLayoutNode_ChildNodes();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getOutgoingEdges <em>Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Edges</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getOutgoingEdges()
	 * @see #getKLayoutNode()
	 * @generated
	 */
	EReference getKLayoutNode_OutgoingEdges();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Edges</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getIncomingEdges()
	 * @see #getKLayoutNode()
	 * @generated
	 */
	EReference getKLayoutNode_IncomingEdges();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getParentNode <em>Parent Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Node</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getParentNode()
	 * @see #getKLayoutNode()
	 * @generated
	 */
	EReference getKLayoutNode_ParentNode();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getLayout()
	 * @see #getKLayoutNode()
	 * @generated
	 */
	EReference getKLayoutNode_Layout();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Label</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getLabel()
	 * @see #getKLayoutNode()
	 * @generated
	 */
	EReference getKLayoutNode_Label();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getIdString <em>Id String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id String</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getIdString()
	 * @see #getKLayoutNode()
	 * @generated
	 */
	EAttribute getKLayoutNode_IdString();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ports</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getPorts()
	 * @see #getKLayoutNode()
	 * @generated
	 */
	EReference getKLayoutNode_Ports();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout <em>KNode Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KNode Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout
	 * @generated
	 */
	EClass getKNodeLayout();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getLayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout Type</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getLayoutType()
	 * @see #getKNodeLayout()
	 * @generated
	 */
	EAttribute getKNodeLayout_LayoutType();

	/**
	 * Returns the meta object for the attribute list '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getLayoutOptions <em>Layout Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Layout Options</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getLayoutOptions()
	 * @see #getKNodeLayout()
	 * @generated
	 */
	EAttribute getKNodeLayout_LayoutOptions();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getLayouterName <em>Layouter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layouter Name</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getLayouterName()
	 * @see #getKNodeLayout()
	 * @generated
	 */
	EAttribute getKNodeLayout_LayouterName();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getInsets <em>Insets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Insets</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getInsets()
	 * @see #getKNodeLayout()
	 * @generated
	 */
	EReference getKNodeLayout_Insets();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLabel <em>KLabel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KLabel</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLabel
	 * @generated
	 */
	EClass getKLabel();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLabel#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLabel#getText()
	 * @see #getKLabel()
	 * @generated
	 */
	EAttribute getKLabel_Text();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel <em>KEdge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KEdge Label</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel
	 * @generated
	 */
	EClass getKEdgeLabel();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel#getLabelLayout <em>Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Label Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel#getLabelLayout()
	 * @see #getKEdgeLabel()
	 * @generated
	 */
	EReference getKEdgeLabel_LabelLayout();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout <em>KEdge Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KEdge Label Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout
	 * @generated
	 */
	EClass getKEdgeLabelLayout();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout#getLabelPlacement <em>Label Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label Placement</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout#getLabelPlacement()
	 * @see #getKEdgeLabelLayout()
	 * @generated
	 */
	EAttribute getKEdgeLabelLayout_LabelPlacement();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel <em>KNode Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KNode Label</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel
	 * @generated
	 */
	EClass getKNodeLabel();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel#getLabelLayout <em>Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Label Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel#getLabelLayout()
	 * @see #getKNodeLabel()
	 * @generated
	 */
	EReference getKNodeLabel_LabelLayout();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelLayout <em>KNode Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KNode Label Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelLayout
	 * @generated
	 */
	EClass getKNodeLabelLayout();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelLayout#getLabelPlacement <em>Label Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label Placement</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelLayout#getLabelPlacement()
	 * @see #getKNodeLabelLayout()
	 * @generated
	 */
	EAttribute getKNodeLabelLayout_LabelPlacement();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo <em>KLayouter Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KLayouter Info</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo
	 * @generated
	 */
	EClass getKLayouterInfo();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayouterName <em>Layouter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layouter Name</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayouterName()
	 * @see #getKLayouterInfo()
	 * @generated
	 */
	EAttribute getKLayouterInfo_LayouterName();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout Type</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayoutType()
	 * @see #getKLayouterInfo()
	 * @generated
	 */
	EAttribute getKLayouterInfo_LayoutType();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayoutOption <em>Layout Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout Option</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayoutOption()
	 * @see #getKLayouterInfo()
	 * @generated
	 */
	EAttribute getKLayouterInfo_LayoutOption();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayouterCollectionID <em>Layouter Collection ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layouter Collection ID</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayouterCollectionID()
	 * @see #getKLayouterInfo()
	 * @generated
	 */
	EAttribute getKLayouterInfo_LayouterCollectionID();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort <em>KLayout Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KLayout Port</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort
	 * @generated
	 */
	EClass getKLayoutPort();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getLayout()
	 * @see #getKLayoutPort()
	 * @generated
	 */
	EReference getKLayoutPort_Layout();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Label</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getLabel()
	 * @see #getKLayoutPort()
	 * @generated
	 */
	EReference getKLayoutPort_Label();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getNode()
	 * @see #getKLayoutPort()
	 * @generated
	 */
	EReference getKLayoutPort_Node();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getType()
	 * @see #getKLayoutPort()
	 * @generated
	 */
	EAttribute getKLayoutPort_Type();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edges</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getEdges()
	 * @see #getKLayoutPort()
	 * @generated
	 */
	EReference getKLayoutPort_Edges();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout <em>KPort Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KPort Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout
	 * @generated
	 */
	EClass getKPortLayout();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout#getPlacement <em>Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Placement</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout#getPlacement()
	 * @see #getKPortLayout()
	 * @generated
	 */
	EAttribute getKPortLayout_Placement();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel <em>KPort Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KPort Label</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel
	 * @generated
	 */
	EClass getKPortLabel();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel#getLabelLayout <em>Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Label Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel#getLabelLayout()
	 * @see #getKPortLabel()
	 * @generated
	 */
	EReference getKPortLabel_LabelLayout();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabelLayout <em>KPort Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KPort Label Layout</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabelLayout
	 * @generated
	 */
	EClass getKPortLabelLayout();

	/**
	 * Returns the meta object for enum '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType <em>KEdge Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>KEdge Type</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType
	 * @generated
	 */
	EEnum getKEdgeType();

	/**
	 * Returns the meta object for enum '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType <em>KLayout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>KLayout Type</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType
	 * @generated
	 */
	EEnum getKLayoutType();

	/**
	 * Returns the meta object for enum '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption <em>KLayout Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>KLayout Option</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption
	 * @generated
	 */
	EEnum getKLayoutOption();

	/**
	 * Returns the meta object for enum '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement <em>KEdge Label Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>KEdge Label Placement</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement
	 * @generated
	 */
	EEnum getKEdgeLabelPlacement();

	/**
	 * Returns the meta object for enum '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelPlacement <em>KNode Label Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>KNode Label Placement</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelPlacement
	 * @generated
	 */
	EEnum getKNodeLabelPlacement();

	/**
	 * Returns the meta object for enum '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType <em>KPort Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>KPort Type</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType
	 * @generated
	 */
	EEnum getKPortType();

	/**
	 * Returns the meta object for enum '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement <em>KPort Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>KPort Placement</em>'.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement
	 * @generated
	 */
	EEnum getKPortPlacement();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPointImpl <em>KPoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPointImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPoint()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KDimensionImpl <em>KDimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KDimensionImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKDimension()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KInsetsImpl <em>KInsets</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KInsetsImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKInsets()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutGraphImpl <em>KLayout Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutGraphImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutGraph()
		 * @generated
		 */
		EClass KLAYOUT_GRAPH = eINSTANCE.getKLayoutGraph();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KShapeLayoutImpl <em>KShape Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KShapeLayoutImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKShapeLayout()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutEdgeImpl <em>KLayout Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutEdgeImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutEdge()
		 * @generated
		 */
		EClass KLAYOUT_EDGE = eINSTANCE.getKLayoutEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_EDGE__SOURCE = eINSTANCE.getKLayoutEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_EDGE__TARGET = eINSTANCE.getKLayoutEdge_Target();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_EDGE__LAYOUT = eINSTANCE.getKLayoutEdge_Layout();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_EDGE__LABEL = eINSTANCE.getKLayoutEdge_Label();

		/**
		 * The meta object literal for the '<em><b>Source Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_EDGE__SOURCE_PORT = eINSTANCE.getKLayoutEdge_SourcePort();

		/**
		 * The meta object literal for the '<em><b>Target Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_EDGE__TARGET_PORT = eINSTANCE.getKLayoutEdge_TargetPort();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl <em>KEdge Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLayout()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl <em>KLayout Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutNode()
		 * @generated
		 */
		EClass KLAYOUT_NODE = eINSTANCE.getKLayoutNode();

		/**
		 * The meta object literal for the '<em><b>Child Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_NODE__CHILD_NODES = eINSTANCE.getKLayoutNode_ChildNodes();

		/**
		 * The meta object literal for the '<em><b>Outgoing Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_NODE__OUTGOING_EDGES = eINSTANCE.getKLayoutNode_OutgoingEdges();

		/**
		 * The meta object literal for the '<em><b>Incoming Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_NODE__INCOMING_EDGES = eINSTANCE.getKLayoutNode_IncomingEdges();

		/**
		 * The meta object literal for the '<em><b>Parent Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_NODE__PARENT_NODE = eINSTANCE.getKLayoutNode_ParentNode();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_NODE__LAYOUT = eINSTANCE.getKLayoutNode_Layout();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_NODE__LABEL = eINSTANCE.getKLayoutNode_Label();

		/**
		 * The meta object literal for the '<em><b>Id String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KLAYOUT_NODE__ID_STRING = eINSTANCE.getKLayoutNode_IdString();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_NODE__PORTS = eINSTANCE.getKLayoutNode_Ports();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLayoutImpl <em>KNode Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLayoutImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeLayout()
		 * @generated
		 */
		EClass KNODE_LAYOUT = eINSTANCE.getKNodeLayout();

		/**
		 * The meta object literal for the '<em><b>Layout Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KNODE_LAYOUT__LAYOUT_TYPE = eINSTANCE.getKNodeLayout_LayoutType();

		/**
		 * The meta object literal for the '<em><b>Layout Options</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KNODE_LAYOUT__LAYOUT_OPTIONS = eINSTANCE.getKNodeLayout_LayoutOptions();

		/**
		 * The meta object literal for the '<em><b>Layouter Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KNODE_LAYOUT__LAYOUTER_NAME = eINSTANCE.getKNodeLayout_LayouterName();

		/**
		 * The meta object literal for the '<em><b>Insets</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_LAYOUT__INSETS = eINSTANCE.getKNodeLayout_Insets();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLabelImpl <em>KLabel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLabelImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLabel()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelImpl <em>KEdge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLabel()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelLayoutImpl <em>KEdge Label Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelLayoutImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLabelLayout()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLabelImpl <em>KNode Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLabelImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeLabel()
		 * @generated
		 */
		EClass KNODE_LABEL = eINSTANCE.getKNodeLabel();

		/**
		 * The meta object literal for the '<em><b>Label Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNODE_LABEL__LABEL_LAYOUT = eINSTANCE.getKNodeLabel_LabelLayout();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLabelLayoutImpl <em>KNode Label Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLabelLayoutImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeLabelLayout()
		 * @generated
		 */
		EClass KNODE_LABEL_LAYOUT = eINSTANCE.getKNodeLabelLayout();

		/**
		 * The meta object literal for the '<em><b>Label Placement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KNODE_LABEL_LAYOUT__LABEL_PLACEMENT = eINSTANCE.getKNodeLabelLayout_LabelPlacement();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayouterInfoImpl <em>KLayouter Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayouterInfoImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayouterInfo()
		 * @generated
		 */
		EClass KLAYOUTER_INFO = eINSTANCE.getKLayouterInfo();

		/**
		 * The meta object literal for the '<em><b>Layouter Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KLAYOUTER_INFO__LAYOUTER_NAME = eINSTANCE.getKLayouterInfo_LayouterName();

		/**
		 * The meta object literal for the '<em><b>Layout Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KLAYOUTER_INFO__LAYOUT_TYPE = eINSTANCE.getKLayouterInfo_LayoutType();

		/**
		 * The meta object literal for the '<em><b>Layout Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KLAYOUTER_INFO__LAYOUT_OPTION = eINSTANCE.getKLayouterInfo_LayoutOption();

		/**
		 * The meta object literal for the '<em><b>Layouter Collection ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KLAYOUTER_INFO__LAYOUTER_COLLECTION_ID = eINSTANCE.getKLayouterInfo_LayouterCollectionID();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutPortImpl <em>KLayout Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutPortImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutPort()
		 * @generated
		 */
		EClass KLAYOUT_PORT = eINSTANCE.getKLayoutPort();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_PORT__LAYOUT = eINSTANCE.getKLayoutPort_Layout();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_PORT__LABEL = eINSTANCE.getKLayoutPort_Label();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_PORT__NODE = eINSTANCE.getKLayoutPort_Node();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KLAYOUT_PORT__TYPE = eINSTANCE.getKLayoutPort_Type();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLAYOUT_PORT__EDGES = eINSTANCE.getKLayoutPort_Edges();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLayoutImpl <em>KPort Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLayoutImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPortLayout()
		 * @generated
		 */
		EClass KPORT_LAYOUT = eINSTANCE.getKPortLayout();

		/**
		 * The meta object literal for the '<em><b>Placement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KPORT_LAYOUT__PLACEMENT = eINSTANCE.getKPortLayout_Placement();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLabelImpl <em>KPort Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLabelImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPortLabel()
		 * @generated
		 */
		EClass KPORT_LABEL = eINSTANCE.getKPortLabel();

		/**
		 * The meta object literal for the '<em><b>Label Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KPORT_LABEL__LABEL_LAYOUT = eINSTANCE.getKPortLabel_LabelLayout();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLabelLayoutImpl <em>KPort Label Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLabelLayoutImpl
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPortLabelLayout()
		 * @generated
		 */
		EClass KPORT_LABEL_LAYOUT = eINSTANCE.getKPortLabelLayout();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType <em>KEdge Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeType()
		 * @generated
		 */
		EEnum KEDGE_TYPE = eINSTANCE.getKEdgeType();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType <em>KLayout Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutType()
		 * @generated
		 */
		EEnum KLAYOUT_TYPE = eINSTANCE.getKLayoutType();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption <em>KLayout Option</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKLayoutOption()
		 * @generated
		 */
		EEnum KLAYOUT_OPTION = eINSTANCE.getKLayoutOption();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement <em>KEdge Label Placement</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKEdgeLabelPlacement()
		 * @generated
		 */
		EEnum KEDGE_LABEL_PLACEMENT = eINSTANCE.getKEdgeLabelPlacement();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelPlacement <em>KNode Label Placement</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelPlacement
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKNodeLabelPlacement()
		 * @generated
		 */
		EEnum KNODE_LABEL_PLACEMENT = eINSTANCE.getKNodeLabelPlacement();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType <em>KPort Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPortType()
		 * @generated
		 */
		EEnum KPORT_TYPE = eINSTANCE.getKPortType();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement <em>KPort Placement</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement
		 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphPackageImpl#getKPortPlacement()
		 * @generated
		 */
		EEnum KPORT_PLACEMENT = eINSTANCE.getKPortPlacement();

	}

} //KimlLayoutGraphPackage
