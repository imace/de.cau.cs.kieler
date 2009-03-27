/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KimlLayoutGraphFactoryImpl extends EFactoryImpl implements KimlLayoutGraphFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KimlLayoutGraphFactory init() {
        try {
            KimlLayoutGraphFactory theKimlLayoutGraphFactory = (KimlLayoutGraphFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.informatik.uni-kiel.de/rtsys/kimllayoutgraph"); 
            if (theKimlLayoutGraphFactory != null) {
                return theKimlLayoutGraphFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new KimlLayoutGraphFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KimlLayoutGraphFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case KimlLayoutGraphPackage.KPOINT: return createKPoint();
            case KimlLayoutGraphPackage.KDIMENSION: return createKDimension();
            case KimlLayoutGraphPackage.KINSETS: return createKInsets();
            case KimlLayoutGraphPackage.KLAYOUT_GRAPH: return createKLayoutGraph();
            case KimlLayoutGraphPackage.KLAYOUT_EDGE: return createKLayoutEdge();
            case KimlLayoutGraphPackage.KEDGE_LAYOUT: return createKEdgeLayout();
            case KimlLayoutGraphPackage.KLAYOUT_NODE: return createKLayoutNode();
            case KimlLayoutGraphPackage.KNODE_LAYOUT: return createKNodeLayout();
            case KimlLayoutGraphPackage.KEDGE_LABEL: return createKEdgeLabel();
            case KimlLayoutGraphPackage.KEDGE_LABEL_LAYOUT: return createKEdgeLabelLayout();
            case KimlLayoutGraphPackage.KNODE_LABEL: return createKNodeLabel();
            case KimlLayoutGraphPackage.KNODE_LABEL_LAYOUT: return createKNodeLabelLayout();
            case KimlLayoutGraphPackage.KLAYOUTER_INFO: return createKLayouterInfo();
            case KimlLayoutGraphPackage.KLAYOUT_PORT: return createKLayoutPort();
            case KimlLayoutGraphPackage.KPORT_LAYOUT: return createKPortLayout();
            case KimlLayoutGraphPackage.KPORT_LABEL: return createKPortLabel();
            case KimlLayoutGraphPackage.KPORT_LABEL_LAYOUT: return createKPortLabelLayout();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case KimlLayoutGraphPackage.KEDGE_TYPE:
                return createKEdgeTypeFromString(eDataType, initialValue);
            case KimlLayoutGraphPackage.KLAYOUT_TYPE:
                return createKLayoutTypeFromString(eDataType, initialValue);
            case KimlLayoutGraphPackage.KLAYOUT_OPTION:
                return createKLayoutOptionFromString(eDataType, initialValue);
            case KimlLayoutGraphPackage.KEDGE_LABEL_PLACEMENT:
                return createKEdgeLabelPlacementFromString(eDataType, initialValue);
            case KimlLayoutGraphPackage.KNODE_LABEL_PLACEMENT:
                return createKNodeLabelPlacementFromString(eDataType, initialValue);
            case KimlLayoutGraphPackage.KPORT_TYPE:
                return createKPortTypeFromString(eDataType, initialValue);
            case KimlLayoutGraphPackage.KPORT_PLACEMENT:
                return createKPortPlacementFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case KimlLayoutGraphPackage.KEDGE_TYPE:
                return convertKEdgeTypeToString(eDataType, instanceValue);
            case KimlLayoutGraphPackage.KLAYOUT_TYPE:
                return convertKLayoutTypeToString(eDataType, instanceValue);
            case KimlLayoutGraphPackage.KLAYOUT_OPTION:
                return convertKLayoutOptionToString(eDataType, instanceValue);
            case KimlLayoutGraphPackage.KEDGE_LABEL_PLACEMENT:
                return convertKEdgeLabelPlacementToString(eDataType, instanceValue);
            case KimlLayoutGraphPackage.KNODE_LABEL_PLACEMENT:
                return convertKNodeLabelPlacementToString(eDataType, instanceValue);
            case KimlLayoutGraphPackage.KPORT_TYPE:
                return convertKPortTypeToString(eDataType, instanceValue);
            case KimlLayoutGraphPackage.KPORT_PLACEMENT:
                return convertKPortPlacementToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KPoint createKPoint() {
        KPointImpl kPoint = new KPointImpl();
        return kPoint;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KDimension createKDimension() {
        KDimensionImpl kDimension = new KDimensionImpl();
        return kDimension;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KInsets createKInsets() {
        KInsetsImpl kInsets = new KInsetsImpl();
        return kInsets;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KLayoutGraph createKLayoutGraph() {
        KLayoutGraphImpl kLayoutGraph = new KLayoutGraphImpl();
        return kLayoutGraph;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KLayoutEdge createKLayoutEdge() {
        KLayoutEdgeImpl kLayoutEdge = new KLayoutEdgeImpl();
        return kLayoutEdge;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KEdgeLayout createKEdgeLayout() {
        KEdgeLayoutImpl kEdgeLayout = new KEdgeLayoutImpl();
        return kEdgeLayout;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KLayoutNode createKLayoutNode() {
        KLayoutNodeImpl kLayoutNode = new KLayoutNodeImpl();
        return kLayoutNode;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KNodeLayout createKNodeLayout() {
        KNodeLayoutImpl kNodeLayout = new KNodeLayoutImpl();
        return kNodeLayout;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KEdgeLabel createKEdgeLabel() {
        KEdgeLabelImpl kEdgeLabel = new KEdgeLabelImpl();
        return kEdgeLabel;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KEdgeLabelLayout createKEdgeLabelLayout() {
        KEdgeLabelLayoutImpl kEdgeLabelLayout = new KEdgeLabelLayoutImpl();
        return kEdgeLabelLayout;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KNodeLabel createKNodeLabel() {
        KNodeLabelImpl kNodeLabel = new KNodeLabelImpl();
        return kNodeLabel;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KNodeLabelLayout createKNodeLabelLayout() {
        KNodeLabelLayoutImpl kNodeLabelLayout = new KNodeLabelLayoutImpl();
        return kNodeLabelLayout;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KLayouterInfo createKLayouterInfo() {
        KLayouterInfoImpl kLayouterInfo = new KLayouterInfoImpl();
        return kLayouterInfo;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KLayoutPort createKLayoutPort() {
        KLayoutPortImpl kLayoutPort = new KLayoutPortImpl();
        return kLayoutPort;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KPortLayout createKPortLayout() {
        KPortLayoutImpl kPortLayout = new KPortLayoutImpl();
        return kPortLayout;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KPortLabel createKPortLabel() {
        KPortLabelImpl kPortLabel = new KPortLabelImpl();
        return kPortLabel;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KPortLabelLayout createKPortLabelLayout() {
        KPortLabelLayoutImpl kPortLabelLayout = new KPortLabelLayoutImpl();
        return kPortLabelLayout;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KEdgeType createKEdgeTypeFromString(EDataType eDataType, String initialValue) {
        KEdgeType result = KEdgeType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertKEdgeTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KLayoutType createKLayoutTypeFromString(EDataType eDataType, String initialValue) {
        KLayoutType result = KLayoutType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertKLayoutTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KLayoutOption createKLayoutOptionFromString(EDataType eDataType, String initialValue) {
        KLayoutOption result = KLayoutOption.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertKLayoutOptionToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KEdgeLabelPlacement createKEdgeLabelPlacementFromString(EDataType eDataType, String initialValue) {
        KEdgeLabelPlacement result = KEdgeLabelPlacement.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertKEdgeLabelPlacementToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KNodeLabelPlacement createKNodeLabelPlacementFromString(EDataType eDataType, String initialValue) {
        KNodeLabelPlacement result = KNodeLabelPlacement.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertKNodeLabelPlacementToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KPortType createKPortTypeFromString(EDataType eDataType, String initialValue) {
        KPortType result = KPortType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertKPortTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KPortPlacement createKPortPlacementFromString(EDataType eDataType, String initialValue) {
        KPortPlacement result = KPortPlacement.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertKPortPlacementToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KimlLayoutGraphPackage getKimlLayoutGraphPackage() {
        return (KimlLayoutGraphPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static KimlLayoutGraphPackage getPackage() {
        return KimlLayoutGraphPackage.eINSTANCE;
    }

} //KimlLayoutGraphFactoryImpl
