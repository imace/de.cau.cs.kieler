/**
 */
package de.cau.cs.kieler.kiml.graphviz.dot.dot;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.kiml.graphviz.dot.dot.DotPackage
 * @generated
 */
public interface DotFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DotFactory eINSTANCE = de.cau.cs.kieler.kiml.graphviz.dot.dot.impl.DotFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Graphviz Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Graphviz Model</em>'.
   * @generated
   */
  GraphvizModel createGraphvizModel();

  /**
   * Returns a new object of class '<em>Graph</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Graph</em>'.
   * @generated
   */
  Graph createGraph();

  /**
   * Returns a new object of class '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement</em>'.
   * @generated
   */
  Statement createStatement();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Node Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Statement</em>'.
   * @generated
   */
  NodeStatement createNodeStatement();

  /**
   * Returns a new object of class '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node</em>'.
   * @generated
   */
  Node createNode();

  /**
   * Returns a new object of class '<em>Edge Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Edge Statement</em>'.
   * @generated
   */
  EdgeStatement createEdgeStatement();

  /**
   * Returns a new object of class '<em>Edge Target</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Edge Target</em>'.
   * @generated
   */
  EdgeTarget createEdgeTarget();

  /**
   * Returns a new object of class '<em>Attribute Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Statement</em>'.
   * @generated
   */
  AttributeStatement createAttributeStatement();

  /**
   * Returns a new object of class '<em>Subgraph</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subgraph</em>'.
   * @generated
   */
  Subgraph createSubgraph();

  /**
   * Returns a new object of class '<em>Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port</em>'.
   * @generated
   */
  Port createPort();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DotPackage getDotPackage();

} //DotFactory
