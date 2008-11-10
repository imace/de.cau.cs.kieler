/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;

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
			case KimlLayoutGraphPackage.KEDGE: return createKEdge();
			case KimlLayoutGraphPackage.KEDGE_LAYOUT: return createKEdgeLayout();
			case KimlLayoutGraphPackage.KNODE_GROUP: return createKNodeGroup();
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT: return createKNodeGroupLayout();
			case KimlLayoutGraphPackage.KEDGE_LABEL: return createKEdgeLabel();
			case KimlLayoutGraphPackage.KEDGE_LABEL_LAYOUT: return createKEdgeLabelLayout();
			case KimlLayoutGraphPackage.KNODE_GROUP_LABEL: return createKNodeGroupLabel();
			case KimlLayoutGraphPackage.KNODE_GROUP_LABEL_LAYOUT: return createKNodeGroupLabelLayout();
			case KimlLayoutGraphPackage.LAYOUTER_INFO: return createLAYOUTER_INFO();
			case KimlLayoutGraphPackage.KPORT: return createKPort();
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
			case KimlLayoutGraphPackage.EDGE_TYPE:
				return createEDGE_TYPEFromString(eDataType, initialValue);
			case KimlLayoutGraphPackage.LAYOUT_TYPE:
				return createLAYOUT_TYPEFromString(eDataType, initialValue);
			case KimlLayoutGraphPackage.LAYOUT_OPTION:
				return createLAYOUT_OPTIONFromString(eDataType, initialValue);
			case KimlLayoutGraphPackage.EDGE_LABEL_PLACEMENT:
				return createEDGE_LABEL_PLACEMENTFromString(eDataType, initialValue);
			case KimlLayoutGraphPackage.NODE_LABEL_PLACEMENT:
				return createNODE_LABEL_PLACEMENTFromString(eDataType, initialValue);
			case KimlLayoutGraphPackage.PORT_TYPE:
				return createPORT_TYPEFromString(eDataType, initialValue);
			case KimlLayoutGraphPackage.PORT_PLACEMENT:
				return createPORT_PLACEMENTFromString(eDataType, initialValue);
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
			case KimlLayoutGraphPackage.EDGE_TYPE:
				return convertEDGE_TYPEToString(eDataType, instanceValue);
			case KimlLayoutGraphPackage.LAYOUT_TYPE:
				return convertLAYOUT_TYPEToString(eDataType, instanceValue);
			case KimlLayoutGraphPackage.LAYOUT_OPTION:
				return convertLAYOUT_OPTIONToString(eDataType, instanceValue);
			case KimlLayoutGraphPackage.EDGE_LABEL_PLACEMENT:
				return convertEDGE_LABEL_PLACEMENTToString(eDataType, instanceValue);
			case KimlLayoutGraphPackage.NODE_LABEL_PLACEMENT:
				return convertNODE_LABEL_PLACEMENTToString(eDataType, instanceValue);
			case KimlLayoutGraphPackage.PORT_TYPE:
				return convertPORT_TYPEToString(eDataType, instanceValue);
			case KimlLayoutGraphPackage.PORT_PLACEMENT:
				return convertPORT_PLACEMENTToString(eDataType, instanceValue);
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
	public KEdge createKEdge() {
		KEdgeImpl kEdge = new KEdgeImpl();
		return kEdge;
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
	public KNodeGroup createKNodeGroup() {
		KNodeGroupImpl kNodeGroup = new KNodeGroupImpl();
		return kNodeGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeGroupLayout createKNodeGroupLayout() {
		KNodeGroupLayoutImpl kNodeGroupLayout = new KNodeGroupLayoutImpl();
		return kNodeGroupLayout;
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
	public KNodeGroupLabel createKNodeGroupLabel() {
		KNodeGroupLabelImpl kNodeGroupLabel = new KNodeGroupLabelImpl();
		return kNodeGroupLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeGroupLabelLayout createKNodeGroupLabelLayout() {
		KNodeGroupLabelLayoutImpl kNodeGroupLabelLayout = new KNodeGroupLabelLayoutImpl();
		return kNodeGroupLabelLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAYOUTER_INFO createLAYOUTER_INFO() {
		LAYOUTER_INFOImpl layouteR_INFO = new LAYOUTER_INFOImpl();
		return layouteR_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KPort createKPort() {
		KPortImpl kPort = new KPortImpl();
		return kPort;
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
	public EDGE_TYPE createEDGE_TYPEFromString(EDataType eDataType, String initialValue) {
		EDGE_TYPE result = EDGE_TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDGE_TYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAYOUT_TYPE createLAYOUT_TYPEFromString(EDataType eDataType, String initialValue) {
		LAYOUT_TYPE result = LAYOUT_TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLAYOUT_TYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAYOUT_OPTION createLAYOUT_OPTIONFromString(EDataType eDataType, String initialValue) {
		LAYOUT_OPTION result = LAYOUT_OPTION.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLAYOUT_OPTIONToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDGE_LABEL_PLACEMENT createEDGE_LABEL_PLACEMENTFromString(EDataType eDataType, String initialValue) {
		EDGE_LABEL_PLACEMENT result = EDGE_LABEL_PLACEMENT.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDGE_LABEL_PLACEMENTToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NODE_LABEL_PLACEMENT createNODE_LABEL_PLACEMENTFromString(EDataType eDataType, String initialValue) {
		NODE_LABEL_PLACEMENT result = NODE_LABEL_PLACEMENT.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNODE_LABEL_PLACEMENTToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PORT_TYPE createPORT_TYPEFromString(EDataType eDataType, String initialValue) {
		PORT_TYPE result = PORT_TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPORT_TYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PORT_PLACEMENT createPORT_PLACEMENTFromString(EDataType eDataType, String initialValue) {
		PORT_PLACEMENT result = PORT_PLACEMENT.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPORT_PLACEMENTToString(EDataType eDataType, Object instanceValue) {
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
