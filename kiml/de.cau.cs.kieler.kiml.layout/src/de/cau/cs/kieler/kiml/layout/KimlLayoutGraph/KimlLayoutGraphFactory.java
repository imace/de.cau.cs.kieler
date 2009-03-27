/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage
 * @generated
 */
public interface KimlLayoutGraphFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	KimlLayoutGraphFactory eINSTANCE = de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KimlLayoutGraphFactoryImpl.init();

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
     * Returns a new object of class '<em>KLayout Edge</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>KLayout Edge</em>'.
     * @generated
     */
	KLayoutEdge createKLayoutEdge();

	/**
     * Returns a new object of class '<em>KEdge Layout</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>KEdge Layout</em>'.
     * @generated
     */
	KEdgeLayout createKEdgeLayout();

	/**
     * Returns a new object of class '<em>KLayout Node</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>KLayout Node</em>'.
     * @generated
     */
	KLayoutNode createKLayoutNode();

	/**
     * Returns a new object of class '<em>KNode Layout</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>KNode Layout</em>'.
     * @generated
     */
	KNodeLayout createKNodeLayout();

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
     * Returns a new object of class '<em>KNode Label</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>KNode Label</em>'.
     * @generated
     */
	KNodeLabel createKNodeLabel();

	/**
     * Returns a new object of class '<em>KNode Label Layout</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>KNode Label Layout</em>'.
     * @generated
     */
	KNodeLabelLayout createKNodeLabelLayout();

	/**
     * Returns a new object of class '<em>KLayouter Info</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>KLayouter Info</em>'.
     * @generated
     */
	KLayouterInfo createKLayouterInfo();

	/**
     * Returns a new object of class '<em>KLayout Port</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>KLayout Port</em>'.
     * @generated
     */
	KLayoutPort createKLayoutPort();

	/**
     * Returns a new object of class '<em>KPort Layout</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>KPort Layout</em>'.
     * @generated
     */
	KPortLayout createKPortLayout();

	/**
     * Returns a new object of class '<em>KPort Label</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>KPort Label</em>'.
     * @generated
     */
	KPortLabel createKPortLabel();

	/**
     * Returns a new object of class '<em>KPort Label Layout</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>KPort Label Layout</em>'.
     * @generated
     */
	KPortLabelLayout createKPortLabelLayout();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	KimlLayoutGraphPackage getKimlLayoutGraphPackage();

} //KimlLayoutGraphFactory
