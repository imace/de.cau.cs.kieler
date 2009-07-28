/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.kiml.graphviz.dot;

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
 * @see de.cau.cs.kieler.kiml.graphviz.dot.DotFactory
 * @model kind="package"
 * @generated
 */
public interface DotPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dot";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://kieler.cs.cau.de/Dot";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dot";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DotPackage eINSTANCE = de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl.init();

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.GraphvizModelImpl <em>Graphviz Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.GraphvizModelImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getGraphvizModel()
   * @generated
   */
  int GRAPHVIZ_MODEL = 0;

  /**
   * The feature id for the '<em><b>Graphs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPHVIZ_MODEL__GRAPHS = 0;

  /**
   * The number of structural features of the '<em>Graphviz Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPHVIZ_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.GraphImpl <em>Graph</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.GraphImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getGraph()
   * @generated
   */
  int GRAPH = 1;

  /**
   * The feature id for the '<em><b>Strict</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH__STRICT = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH__TYPE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH__NAME = 2;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH__STATEMENTS = 3;

  /**
   * The number of structural features of the '<em>Graph</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.StatementImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.EdgeStatementImpl <em>Edge Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.EdgeStatementImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getEdgeStatement()
   * @generated
   */
  int EDGE_STATEMENT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_STATEMENT__NAME = STATEMENT__NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_STATEMENT__VALUE = STATEMENT__VALUE;

  /**
   * The feature id for the '<em><b>Source Subgraph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_STATEMENT__SOURCE_SUBGRAPH = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_STATEMENT__SOURCE_NODE = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Edge Targets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_STATEMENT__EDGE_TARGETS = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_STATEMENT__ATTRIBUTES = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Edge Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.EdgeTargetImpl <em>Edge Target</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.EdgeTargetImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getEdgeTarget()
   * @generated
   */
  int EDGE_TARGET = 4;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_TARGET__OPERATOR = 0;

  /**
   * The feature id for the '<em><b>Target Subgraph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_TARGET__TARGET_SUBGRAPH = 1;

  /**
   * The feature id for the '<em><b>Targetnode</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_TARGET__TARGETNODE = 2;

  /**
   * The number of structural features of the '<em>Edge Target</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDGE_TARGET_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.NodeStatementImpl <em>Node Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.NodeStatementImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getNodeStatement()
   * @generated
   */
  int NODE_STATEMENT = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_STATEMENT__NAME = STATEMENT__NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_STATEMENT__VALUE = STATEMENT__VALUE;

  /**
   * The feature id for the '<em><b>Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_STATEMENT__NODE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_STATEMENT__ATTRIBUTES = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Node Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeStatementImpl <em>Attribute Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeStatementImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getAttributeStatement()
   * @generated
   */
  int ATTRIBUTE_STATEMENT = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_STATEMENT__NAME = STATEMENT__NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_STATEMENT__VALUE = STATEMENT__VALUE;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_STATEMENT__TYPE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_STATEMENT__ATTRIBUTES = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Attribute Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.SubgraphImpl <em>Subgraph</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.SubgraphImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getSubgraph()
   * @generated
   */
  int SUBGRAPH = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBGRAPH__NAME = STATEMENT__NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBGRAPH__VALUE = STATEMENT__VALUE;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBGRAPH__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Subgraph</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBGRAPH_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeListImpl <em>Attribute List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeListImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getAttributeList()
   * @generated
   */
  int ATTRIBUTE_LIST = 8;

  /**
   * The feature id for the '<em><b>Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_LIST__ENTRIES = 0;

  /**
   * The number of structural features of the '<em>Attribute List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.NodeImpl <em>Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.NodeImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getNode()
   * @generated
   */
  int NODE = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__NAME = 0;

  /**
   * The feature id for the '<em><b>Port</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__PORT = 1;

  /**
   * The number of structural features of the '<em>Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.PortImpl <em>Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.PortImpl
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getPort()
   * @generated
   */
  int PORT = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__NAME = 0;

  /**
   * The feature id for the '<em><b>Compass pt</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__COMPASS_PT = 1;

  /**
   * The number of structural features of the '<em>Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeOperator <em>Edge Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeOperator
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getEdgeOperator()
   * @generated
   */
  int EDGE_OPERATOR = 12;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.GraphType <em>Graph Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.GraphType
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getGraphType()
   * @generated
   */
  int GRAPH_TYPE = 13;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.AttributeType <em>Attribute Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.AttributeType
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getAttributeType()
   * @generated
   */
  int ATTRIBUTE_TYPE = 14;

  /**
   * The meta object id for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.CompassPoint <em>Compass Point</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.cau.cs.kieler.kiml.graphviz.dot.CompassPoint
   * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getCompassPoint()
   * @generated
   */
  int COMPASS_POINT = 15;


  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.GraphvizModel <em>Graphviz Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Graphviz Model</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.GraphvizModel
   * @generated
   */
  EClass getGraphvizModel();

  /**
   * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.kiml.graphviz.dot.GraphvizModel#getGraphs <em>Graphs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Graphs</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.GraphvizModel#getGraphs()
   * @see #getGraphvizModel()
   * @generated
   */
  EReference getGraphvizModel_Graphs();

  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.Graph <em>Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Graph</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Graph
   * @generated
   */
  EClass getGraph();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.Graph#isStrict <em>Strict</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Strict</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Graph#isStrict()
   * @see #getGraph()
   * @generated
   */
  EAttribute getGraph_Strict();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.Graph#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Graph#getType()
   * @see #getGraph()
   * @generated
   */
  EAttribute getGraph_Type();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.Graph#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Graph#getName()
   * @see #getGraph()
   * @generated
   */
  EAttribute getGraph_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.kiml.graphviz.dot.Graph#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Graph#getStatements()
   * @see #getGraph()
   * @generated
   */
  EReference getGraph_Statements();

  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.Statement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Statement#getName()
   * @see #getStatement()
   * @generated
   */
  EAttribute getStatement_Name();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.Statement#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Statement#getValue()
   * @see #getStatement()
   * @generated
   */
  EAttribute getStatement_Value();

  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeStatement <em>Edge Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Edge Statement</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeStatement
   * @generated
   */
  EClass getEdgeStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeStatement#getSourceSubgraph <em>Source Subgraph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source Subgraph</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeStatement#getSourceSubgraph()
   * @see #getEdgeStatement()
   * @generated
   */
  EReference getEdgeStatement_SourceSubgraph();

  /**
   * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeStatement#getSourceNode <em>Source Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source Node</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeStatement#getSourceNode()
   * @see #getEdgeStatement()
   * @generated
   */
  EReference getEdgeStatement_SourceNode();

  /**
   * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeStatement#getEdgeTargets <em>Edge Targets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Edge Targets</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeStatement#getEdgeTargets()
   * @see #getEdgeStatement()
   * @generated
   */
  EReference getEdgeStatement_EdgeTargets();

  /**
   * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeStatement#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Attributes</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeStatement#getAttributes()
   * @see #getEdgeStatement()
   * @generated
   */
  EReference getEdgeStatement_Attributes();

  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeTarget <em>Edge Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Edge Target</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeTarget
   * @generated
   */
  EClass getEdgeTarget();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeTarget#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeTarget#getOperator()
   * @see #getEdgeTarget()
   * @generated
   */
  EAttribute getEdgeTarget_Operator();

  /**
   * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeTarget#getTargetSubgraph <em>Target Subgraph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target Subgraph</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeTarget#getTargetSubgraph()
   * @see #getEdgeTarget()
   * @generated
   */
  EReference getEdgeTarget_TargetSubgraph();

  /**
   * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeTarget#getTargetnode <em>Targetnode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Targetnode</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeTarget#getTargetnode()
   * @see #getEdgeTarget()
   * @generated
   */
  EReference getEdgeTarget_Targetnode();

  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.NodeStatement <em>Node Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Statement</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.NodeStatement
   * @generated
   */
  EClass getNodeStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.kiml.graphviz.dot.NodeStatement#getNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Node</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.NodeStatement#getNode()
   * @see #getNodeStatement()
   * @generated
   */
  EReference getNodeStatement_Node();

  /**
   * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.kiml.graphviz.dot.NodeStatement#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Attributes</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.NodeStatement#getAttributes()
   * @see #getNodeStatement()
   * @generated
   */
  EReference getNodeStatement_Attributes();

  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.AttributeStatement <em>Attribute Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Statement</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.AttributeStatement
   * @generated
   */
  EClass getAttributeStatement();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.AttributeStatement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.AttributeStatement#getType()
   * @see #getAttributeStatement()
   * @generated
   */
  EAttribute getAttributeStatement_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.kiml.graphviz.dot.AttributeStatement#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Attributes</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.AttributeStatement#getAttributes()
   * @see #getAttributeStatement()
   * @generated
   */
  EReference getAttributeStatement_Attributes();

  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.Subgraph <em>Subgraph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subgraph</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Subgraph
   * @generated
   */
  EClass getSubgraph();

  /**
   * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.kiml.graphviz.dot.Subgraph#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Subgraph#getStatements()
   * @see #getSubgraph()
   * @generated
   */
  EReference getSubgraph_Statements();

  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.AttributeList <em>Attribute List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute List</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.AttributeList
   * @generated
   */
  EClass getAttributeList();

  /**
   * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.kiml.graphviz.dot.AttributeList#getEntries <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entries</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.AttributeList#getEntries()
   * @see #getAttributeList()
   * @generated
   */
  EReference getAttributeList_Entries();

  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.Attribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Attribute#getName()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Name();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Value();

  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Node
   * @generated
   */
  EClass getNode();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.Node#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Node#getName()
   * @see #getNode()
   * @generated
   */
  EAttribute getNode_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.kiml.graphviz.dot.Node#getPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Port</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Node#getPort()
   * @see #getNode()
   * @generated
   */
  EReference getNode_Port();

  /**
   * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.graphviz.dot.Port <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Port
   * @generated
   */
  EClass getPort();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.Port#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Port#getName()
   * @see #getPort()
   * @generated
   */
  EAttribute getPort_Name();

  /**
   * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.graphviz.dot.Port#getCompass_pt <em>Compass pt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Compass pt</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.Port#getCompass_pt()
   * @see #getPort()
   * @generated
   */
  EAttribute getPort_Compass_pt();

  /**
   * Returns the meta object for enum '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeOperator <em>Edge Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Edge Operator</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeOperator
   * @generated
   */
  EEnum getEdgeOperator();

  /**
   * Returns the meta object for enum '{@link de.cau.cs.kieler.kiml.graphviz.dot.GraphType <em>Graph Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Graph Type</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.GraphType
   * @generated
   */
  EEnum getGraphType();

  /**
   * Returns the meta object for enum '{@link de.cau.cs.kieler.kiml.graphviz.dot.AttributeType <em>Attribute Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Attribute Type</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.AttributeType
   * @generated
   */
  EEnum getAttributeType();

  /**
   * Returns the meta object for enum '{@link de.cau.cs.kieler.kiml.graphviz.dot.CompassPoint <em>Compass Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Compass Point</em>'.
   * @see de.cau.cs.kieler.kiml.graphviz.dot.CompassPoint
   * @generated
   */
  EEnum getCompassPoint();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DotFactory getDotFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.GraphvizModelImpl <em>Graphviz Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.GraphvizModelImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getGraphvizModel()
     * @generated
     */
    EClass GRAPHVIZ_MODEL = eINSTANCE.getGraphvizModel();

    /**
     * The meta object literal for the '<em><b>Graphs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRAPHVIZ_MODEL__GRAPHS = eINSTANCE.getGraphvizModel_Graphs();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.GraphImpl <em>Graph</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.GraphImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getGraph()
     * @generated
     */
    EClass GRAPH = eINSTANCE.getGraph();

    /**
     * The meta object literal for the '<em><b>Strict</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GRAPH__STRICT = eINSTANCE.getGraph_Strict();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GRAPH__TYPE = eINSTANCE.getGraph_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GRAPH__NAME = eINSTANCE.getGraph_Name();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRAPH__STATEMENTS = eINSTANCE.getGraph_Statements();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.StatementImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATEMENT__NAME = eINSTANCE.getStatement_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATEMENT__VALUE = eINSTANCE.getStatement_Value();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.EdgeStatementImpl <em>Edge Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.EdgeStatementImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getEdgeStatement()
     * @generated
     */
    EClass EDGE_STATEMENT = eINSTANCE.getEdgeStatement();

    /**
     * The meta object literal for the '<em><b>Source Subgraph</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EDGE_STATEMENT__SOURCE_SUBGRAPH = eINSTANCE.getEdgeStatement_SourceSubgraph();

    /**
     * The meta object literal for the '<em><b>Source Node</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EDGE_STATEMENT__SOURCE_NODE = eINSTANCE.getEdgeStatement_SourceNode();

    /**
     * The meta object literal for the '<em><b>Edge Targets</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EDGE_STATEMENT__EDGE_TARGETS = eINSTANCE.getEdgeStatement_EdgeTargets();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EDGE_STATEMENT__ATTRIBUTES = eINSTANCE.getEdgeStatement_Attributes();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.EdgeTargetImpl <em>Edge Target</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.EdgeTargetImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getEdgeTarget()
     * @generated
     */
    EClass EDGE_TARGET = eINSTANCE.getEdgeTarget();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EDGE_TARGET__OPERATOR = eINSTANCE.getEdgeTarget_Operator();

    /**
     * The meta object literal for the '<em><b>Target Subgraph</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EDGE_TARGET__TARGET_SUBGRAPH = eINSTANCE.getEdgeTarget_TargetSubgraph();

    /**
     * The meta object literal for the '<em><b>Targetnode</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EDGE_TARGET__TARGETNODE = eINSTANCE.getEdgeTarget_Targetnode();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.NodeStatementImpl <em>Node Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.NodeStatementImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getNodeStatement()
     * @generated
     */
    EClass NODE_STATEMENT = eINSTANCE.getNodeStatement();

    /**
     * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_STATEMENT__NODE = eINSTANCE.getNodeStatement_Node();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_STATEMENT__ATTRIBUTES = eINSTANCE.getNodeStatement_Attributes();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeStatementImpl <em>Attribute Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeStatementImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getAttributeStatement()
     * @generated
     */
    EClass ATTRIBUTE_STATEMENT = eINSTANCE.getAttributeStatement();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_STATEMENT__TYPE = eINSTANCE.getAttributeStatement_Type();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_STATEMENT__ATTRIBUTES = eINSTANCE.getAttributeStatement_Attributes();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.SubgraphImpl <em>Subgraph</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.SubgraphImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getSubgraph()
     * @generated
     */
    EClass SUBGRAPH = eINSTANCE.getSubgraph();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBGRAPH__STATEMENTS = eINSTANCE.getSubgraph_Statements();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeListImpl <em>Attribute List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeListImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getAttributeList()
     * @generated
     */
    EClass ATTRIBUTE_LIST = eINSTANCE.getAttributeList();

    /**
     * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_LIST__ENTRIES = eINSTANCE.getAttributeList_Entries();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.AttributeImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.NodeImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getNode()
     * @generated
     */
    EClass NODE = eINSTANCE.getNode();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE__NAME = eINSTANCE.getNode_Name();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE__PORT = eINSTANCE.getNode_Port();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.impl.PortImpl <em>Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.PortImpl
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getPort()
     * @generated
     */
    EClass PORT = eINSTANCE.getPort();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT__NAME = eINSTANCE.getPort_Name();

    /**
     * The meta object literal for the '<em><b>Compass pt</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT__COMPASS_PT = eINSTANCE.getPort_Compass_pt();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.EdgeOperator <em>Edge Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.EdgeOperator
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getEdgeOperator()
     * @generated
     */
    EEnum EDGE_OPERATOR = eINSTANCE.getEdgeOperator();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.GraphType <em>Graph Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.GraphType
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getGraphType()
     * @generated
     */
    EEnum GRAPH_TYPE = eINSTANCE.getGraphType();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.AttributeType <em>Attribute Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.AttributeType
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getAttributeType()
     * @generated
     */
    EEnum ATTRIBUTE_TYPE = eINSTANCE.getAttributeType();

    /**
     * The meta object literal for the '{@link de.cau.cs.kieler.kiml.graphviz.dot.CompassPoint <em>Compass Point</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.graphviz.dot.CompassPoint
     * @see de.cau.cs.kieler.kiml.graphviz.dot.impl.DotPackageImpl#getCompassPoint()
     * @generated
     */
    EEnum COMPASS_POINT = eINSTANCE.getCompassPoint();

  }

} //DotPackage
