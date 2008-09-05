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
			case KimlLayoutGraphPackage.KPOINT: return createkPoint();
			case KimlLayoutGraphPackage.KDIMENSION: return createkDimension();
			case KimlLayoutGraphPackage.KINSETS: return createkInsets();
			case KimlLayoutGraphPackage.KEDGE: return createkEdge();
			case KimlLayoutGraphPackage.KLAYOUT_GRAPH: return createkLayoutGraph();
			case KimlLayoutGraphPackage.KSHAPE_LAYOUT: return createkShapeLayout();
			case KimlLayoutGraphPackage.KEDGE_LAYOUT: return createkEdgeLayout();
			case KimlLayoutGraphPackage.KNODE_GROUP: return createkNodeGroup();
			case KimlLayoutGraphPackage.KEDGE_LABEL: return createkEdgeLabel();
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT: return createkNodeGroupLayout();
			case KimlLayoutGraphPackage.KEDGE_LABEL_LAYOUT: return createkEdgeLabelLayout();
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
			case KimlLayoutGraphPackage.EDGE_TYPES:
				return createEDGE_TYPESFromString(eDataType, initialValue);
			case KimlLayoutGraphPackage.EDGE_LABEL_PLACEMENT:
				return createEDGE_LABEL_PLACEMENTFromString(eDataType, initialValue);
			case KimlLayoutGraphPackage.LAYOUT_TYPES:
				return createLAYOUT_TYPESFromString(eDataType, initialValue);
			case KimlLayoutGraphPackage.LAYOUT_OPTIONS:
				return createLAYOUT_OPTIONSFromString(eDataType, initialValue);
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
			case KimlLayoutGraphPackage.EDGE_TYPES:
				return convertEDGE_TYPESToString(eDataType, instanceValue);
			case KimlLayoutGraphPackage.EDGE_LABEL_PLACEMENT:
				return convertEDGE_LABEL_PLACEMENTToString(eDataType, instanceValue);
			case KimlLayoutGraphPackage.LAYOUT_TYPES:
				return convertLAYOUT_TYPESToString(eDataType, instanceValue);
			case KimlLayoutGraphPackage.LAYOUT_OPTIONS:
				return convertLAYOUT_OPTIONSToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kPoint createkPoint() {
		kPointImpl kPoint = new kPointImpl();
		return kPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kDimension createkDimension() {
		kDimensionImpl kDimension = new kDimensionImpl();
		return kDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kInsets createkInsets() {
		kInsetsImpl kInsets = new kInsetsImpl();
		return kInsets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kEdge createkEdge() {
		kEdgeImpl kEdge = new kEdgeImpl();
		return kEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kLayoutGraph createkLayoutGraph() {
		kLayoutGraphImpl kLayoutGraph = new kLayoutGraphImpl();
		return kLayoutGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kShapeLayout createkShapeLayout() {
		kShapeLayoutImpl kShapeLayout = new kShapeLayoutImpl();
		return kShapeLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kEdgeLayout createkEdgeLayout() {
		kEdgeLayoutImpl kEdgeLayout = new kEdgeLayoutImpl();
		return kEdgeLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kNodeGroup createkNodeGroup() {
		kNodeGroupImpl kNodeGroup = new kNodeGroupImpl();
		return kNodeGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kEdgeLabel createkEdgeLabel() {
		kEdgeLabelImpl kEdgeLabel = new kEdgeLabelImpl();
		return kEdgeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kNodeGroupLayout createkNodeGroupLayout() {
		kNodeGroupLayoutImpl kNodeGroupLayout = new kNodeGroupLayoutImpl();
		return kNodeGroupLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kEdgeLabelLayout createkEdgeLabelLayout() {
		kEdgeLabelLayoutImpl kEdgeLabelLayout = new kEdgeLabelLayoutImpl();
		return kEdgeLabelLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDGE_TYPES createEDGE_TYPESFromString(EDataType eDataType, String initialValue) {
		EDGE_TYPES result = EDGE_TYPES.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDGE_TYPESToString(EDataType eDataType, Object instanceValue) {
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
	public LAYOUT_TYPES createLAYOUT_TYPESFromString(EDataType eDataType, String initialValue) {
		LAYOUT_TYPES result = LAYOUT_TYPES.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLAYOUT_TYPESToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAYOUT_OPTIONS createLAYOUT_OPTIONSFromString(EDataType eDataType, String initialValue) {
		LAYOUT_OPTIONS result = LAYOUT_OPTIONS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLAYOUT_OPTIONSToString(EDataType eDataType, Object instanceValue) {
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
