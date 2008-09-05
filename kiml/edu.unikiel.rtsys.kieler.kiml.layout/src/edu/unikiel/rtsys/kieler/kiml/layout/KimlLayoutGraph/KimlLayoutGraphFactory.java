/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage
 * @generated
 */
public interface KimlLayoutGraphFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KimlLayoutGraphFactory eINSTANCE = edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>kPoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>kPoint</em>'.
	 * @generated
	 */
	kPoint createkPoint();

	/**
	 * Returns a new object of class '<em>kDimension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>kDimension</em>'.
	 * @generated
	 */
	kDimension createkDimension();

	/**
	 * Returns a new object of class '<em>kInsets</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>kInsets</em>'.
	 * @generated
	 */
	kInsets createkInsets();

	/**
	 * Returns a new object of class '<em>kEdge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>kEdge</em>'.
	 * @generated
	 */
	kEdge createkEdge();

	/**
	 * Returns a new object of class '<em>kLayout Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>kLayout Graph</em>'.
	 * @generated
	 */
	kLayoutGraph createkLayoutGraph();

	/**
	 * Returns a new object of class '<em>kShape Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>kShape Layout</em>'.
	 * @generated
	 */
	kShapeLayout createkShapeLayout();

	/**
	 * Returns a new object of class '<em>kEdge Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>kEdge Layout</em>'.
	 * @generated
	 */
	kEdgeLayout createkEdgeLayout();

	/**
	 * Returns a new object of class '<em>kNode Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>kNode Group</em>'.
	 * @generated
	 */
	kNodeGroup createkNodeGroup();

	/**
	 * Returns a new object of class '<em>kEdge Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>kEdge Label</em>'.
	 * @generated
	 */
	kEdgeLabel createkEdgeLabel();

	/**
	 * Returns a new object of class '<em>kNode Group Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>kNode Group Layout</em>'.
	 * @generated
	 */
	kNodeGroupLayout createkNodeGroupLayout();

	/**
	 * Returns a new object of class '<em>kEdge Label Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>kEdge Label Layout</em>'.
	 * @generated
	 */
	kEdgeLabelLayout createkEdgeLabelLayout();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	KimlLayoutGraphPackage getKimlLayoutGraphPackage();

} //KimlLayoutGraphFactory
