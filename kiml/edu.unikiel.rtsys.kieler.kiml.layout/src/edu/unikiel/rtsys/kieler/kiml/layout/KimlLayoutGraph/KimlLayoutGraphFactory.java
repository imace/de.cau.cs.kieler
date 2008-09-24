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
	 * Returns a new object of class '<em>KPoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KPoint</em>'.
	 * @generated
	 */
	KPoint createKPoint();

	/**
	 * Returns a new object of class '<em>KDimension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KDimension</em>'.
	 * @generated
	 */
	KDimension createKDimension();

	/**
	 * Returns a new object of class '<em>KInsets</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KInsets</em>'.
	 * @generated
	 */
	KInsets createKInsets();

	/**
	 * Returns a new object of class '<em>KLayout Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KLayout Graph</em>'.
	 * @generated
	 */
	KLayoutGraph createKLayoutGraph();

	/**
	 * Returns a new object of class '<em>KEdge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KEdge</em>'.
	 * @generated
	 */
	KEdge createKEdge();

	/**
	 * Returns a new object of class '<em>KEdge Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KEdge Layout</em>'.
	 * @generated
	 */
	KEdgeLayout createKEdgeLayout();

	/**
	 * Returns a new object of class '<em>KNode Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KNode Group</em>'.
	 * @generated
	 */
	KNodeGroup createKNodeGroup();

	/**
	 * Returns a new object of class '<em>KNode Group Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KNode Group Layout</em>'.
	 * @generated
	 */
	KNodeGroupLayout createKNodeGroupLayout();

	/**
	 * Returns a new object of class '<em>KEdge Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KEdge Label</em>'.
	 * @generated
	 */
	KEdgeLabel createKEdgeLabel();

	/**
	 * Returns a new object of class '<em>KEdge Label Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KEdge Label Layout</em>'.
	 * @generated
	 */
	KEdgeLabelLayout createKEdgeLabelLayout();

	/**
	 * Returns a new object of class '<em>KNode Group Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KNode Group Label</em>'.
	 * @generated
	 */
	KNodeGroupLabel createKNodeGroupLabel();

	/**
	 * Returns a new object of class '<em>KNode Group Label Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KNode Group Label Layout</em>'.
	 * @generated
	 */
	KNodeGroupLabelLayout createKNodeGroupLabelLayout();

	/**
	 * Returns a new object of class '<em>LAYOUTER INFO</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>LAYOUTER INFO</em>'.
	 * @generated
	 */
	LAYOUTER_INFO createLAYOUTER_INFO();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	KimlLayoutGraphPackage getKimlLayoutGraphPackage();

} //KimlLayoutGraphFactory
